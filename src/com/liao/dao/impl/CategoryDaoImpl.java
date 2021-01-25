package com.liao.dao.impl;

import java.util.List;


import com.liao.dao.CategoryDao;
import com.liao.entity.Category;
import com.liao.entity.User;
import com.liao.mapper.impl.CategoryMapper;
import com.liao.mapper.impl.UserMapper;
import com.liao.util.JDBCTemplate;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class CategoryDaoImpl implements CategoryDao {

    static Category category = null;

    /**
     * 添加
     *
     * @param goods
     * @return
     */
    @Override
    public int addCategory(Category category) {
        String sql = "insert category (id,category,createTime)values(?,?,now())";
        int count = JDBCTemplate.executeUpdate(sql, new CategoryMapper(),
                category.getId(),
                category.getCategory());
//		返回操作结果

        return count;
    }

    /**
     * 删除
     *
     * @param goods
     * @return
     */
    @Override
    public int deleCategory(Category category) {
        String sql = " delete from category where id = ? ";
        int count = JDBCTemplate.executeUpdate(sql, new CategoryMapper(), category.getId());
        return count;
    }


    /**
     * 修改
     *
     * @param goods
     * @return
     */
    @Override
    public int modiCategory(Category category) {
        System.out.println(category);
        String sql = "update category set category = ? ,createTime = now() where id = ?";
        int count = JDBCTemplate.executeUpdate(sql, new CategoryMapper(),
                category.getCategory(),
                category.getId());
        return count;
    }

    /**
     * 模糊查询
     */
    @Override
    public List<Category> showCategory(Category category) {
        int i = 0;
//			查询语句
        String sql = "select id,category,createTime from category where id like ? or category like ? or createTime like ?";
        List<Category> categoriesList = JDBCTemplate.executeQUery(sql, new CategoryMapper(),
                category.getId(),
                category.getCategory(),
                category.getCreateTime());

        return categoriesList;
    }

    /**
     * 查询全部
     */
    @Override
    public List<Category> selectCategoryAll() {
        ResJson rejs = new ResJson();
        String sql = "select * from category";

        List<Category> categoryList = JDBCTemplate.executeQUery(sql, new CategoryMapper(), null);
        return categoryList;

    }

    @Override
    public List<Category> selectCategoryByLimit(int pageNum, int pageSize, Category category) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" id,category,createTime");
        buffer.append(" from category ");
        buffer.append(" WHERE 1 = 1 ");
        if (category != null) {
//			根据姓名
            if (category.getCategory() != null && category.getCategory().trim().length() > 0) {
                buffer.append(" and category =  '" + category.getCategory() + "'");
            }

            if (category.getId() != null && category.getId().trim().length() > 0) {
                buffer.append(" and id = '" + category.getId() + "'");
            }

        }
        buffer.append(" LIMIT " + pageSize * (pageNum - 1) + " , " + pageSize);
        String sql = buffer.toString();

        List<Category> categoriesList = JDBCTemplate.executeQUery(sql, new CategoryMapper(), null);
        return categoriesList;
    }

    @Override
    public List<Category> selectCategoryCouny(Category category) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" id,category,createTime");
        buffer.append(" from category ");
        buffer.append(" WHERE 1 = 1 ");
        if (category != null) {
//			根据姓名
            if (category.getCategory() != null && category.getCategory().trim().length() > 0) {
                buffer.append(" and category =  '" + category.getCategory() + "'");
            }

            if (category.getId() != null && category.getId().trim().length() > 0) {
                buffer.append(" and id = " + category.getId());
            }

        }

        String sql = buffer.toString();

        List<Category> categoriesList = JDBCTemplate.executeQUery(sql, new CategoryMapper(), null);
        return categoriesList;
    }

    @Override
    public List<Category> repeatName(Category category) {
        String sql = "select * from category where id = ? or category = ? ";
        List<Category> categoryList = JDBCTemplate.executeQUery(sql, new CategoryMapper(),
                category.getId(),
                category.getCategory());
        return categoryList;
    }


}



