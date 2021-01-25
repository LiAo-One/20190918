package com.liao.service.impl;
/**
 * 商品类别
 */

import java.util.List;

import com.liao.dao.CategoryDao;
import com.liao.entity.Category;
import com.liao.exception.AddBookExcoption;
import com.liao.exception.DeleExcoption;
import com.liao.exception.ModiExcoption;
import com.liao.exception.ShowIDExcoption;
import com.liao.factory.ObjectFactory;
import com.liao.service.CategoryService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = (CategoryDao) ObjectFactory.getBean("CategoryDao");

    /**
     * 添加
     */
    @Override
    public ResJson addCategory(Category category) {
        ResJson resj = new ResJson();
        int count = 0;
        try {
//			判断添加参数是否为空
            if (category == null) {
                throw new AddBookExcoption("添加异常： 添加的数据为空");
            }

            if (category.getId() == null || category.getId().length() == 0) {
                throw new AddBookExcoption("添加异常： 类别ID为空");
            }
//			判断数据是否合法
            if (category.getId().length() != 5) {
                throw new AddBookExcoption("添加异常： 类别ID必须是5位数字");
            }

            if (category.getCategory() == null || category.getCategory().length() == 0) {
                throw new AddBookExcoption("添加异常： 类别名称为空");
            }

//			执行添加
            count = categoryDao.addCategory(category);
//			判断添加是否成功
            if (count > 0) {
                resj.setSub(true);
                resj.setStr("添加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resj.setSub(false);
            resj.setStr(e.getMessage());
        }
        return resj;
    }

    /**
     * 删除
     */
    @Override
    public ResJson deleCategory(Category category) {
        ResJson resj = new ResJson();
        int count = 0;
        try {
//			判断参数是否为空
            if (category == null) {
                throw new DeleExcoption("删除异常： 删除的数据为空");
            }
//			判断删除的id是否为空
            if (category.getId() == null || category.getId().trim().length() == 0) {
                throw new DeleExcoption("删除异常： 删除的id为空");
            }
//			执行删除
            count = categoryDao.deleCategory(category);
//			判断是否成功
            if (count > 0) {
                resj.setSub(true);
                resj.setStr("删除成功");
            } else {
                resj.setSub(false);
                resj.setStr("已被商品绑定，暂时无法删除");
            }
//			捕获异常
        } catch (Exception e) {
            resj.setSub(false);
            resj.setStr(e.getMessage());
            e.printStackTrace();
        }
//		返回结果
        return resj;
    }

    /**
     * 修改
     */
    @Override
    public ResJson modiCategory(Category category) {
        ResJson josn = new ResJson();
        int count = 0;
        try {
//			判断添加参数是否为空
            if (category == null) {
                throw new ModiExcoption("修该异常： 添加修该的数据为空");
            }
            if (category.getId() == null) {
                throw new ModiExcoption("修改异常： 修改的ID为空");
            }

//			执行修改
            count = categoryDao.modiCategory(category);
//			判断修改是否成功
            if (count > 0) {
                josn.setSub(true);
                josn.setStr("修改成功");
            } else {
                josn.setSub(false);
                josn.setStr("类别ID 已绑定商品无法修改，只可修改名称");
            }
//		捕获异常
        } catch (Exception e) {
            e.printStackTrace();

            josn.setStr(e.getMessage());
        }
//		返回修改结果
        return josn;
    }

    /**
     * 查询全部
     */
    @Override
    public ResJson selectCategoryAll() {
//		存储查询结果
        ResJson rejs = new ResJson();
//		获取查询结果集合
        List<Category> categoriesList = categoryDao.selectCategoryAll();
        try {
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(categoriesList);
//		捕获异常
        } catch (Exception e) {
            rejs.setSub(false);
            rejs.setStr(e.getMessage());
            rejs.setList(null);
        }
        return rejs;

    }

    /**
     * 模糊查询
     *
     * @param category
     */
    @Override
    public ResJson showCategory(Category category) {
        ResJson json = new ResJson();
        try {
            if (category == null) {
                throw new ShowIDExcoption("查询异常 ：查询的数据为空");
            }
            List<Category> categoriesLis = categoryDao.showCategory(category);
            if (categoriesLis != null) {
                json.setSub(true);
                json.setList(categoriesLis);
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setSub(false);
            json.setStr(e.getMessage());
        }
        return json;

    }

    /**
     * 分页查询
     */
    @Override
    public ResJson selectCategoryByLimit(int pageNum, int pageSize, Category category) {
//		存储查询结果
        ResJson rejs = new ResJson();
//		判断分页值是否合法
        try {
            if (pageNum < 1) {
                throw new ShowIDExcoption("pageNum不合法");
            }

            if (pageSize < 1) {
                throw new ShowIDExcoption("pageSize不合法");
            }
//			获取查询的集合
            List<Category> categoryList = categoryDao.selectCategoryByLimit(pageNum, pageSize, category);
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(categoryList);
        } catch (Exception e) {

            rejs.setSub(false);
            rejs.setStr(e.getMessage());
            rejs.setList(null);
        }
        return rejs;
    }

    @Override
    public int selectCategoryCouny(Category category) {
        int count = 0;
        List<Category> categoryList = categoryDao.selectCategoryCouny(category);
        count = categoryList.size();

        return count;
    }

    /**
     * 判断列别是否已经占用
     */
    @Override
    public ResJson repeatName(Category category) {
        ResJson json = new ResJson();
        int count = 0;
//		获取集合
        List<Category> categorList = categoryDao.repeatName(category);
//		判断结果
        if (!(categorList.size() > 0)) {
            json.setSub(true);
        } else {
            json.setSub(false);
            json.setStr("类别已被占用");
        }
//		返回结果
        return json;
    }

}



















