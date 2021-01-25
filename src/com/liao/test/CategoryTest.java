package com.liao.test;

import java.util.Scanner;

import com.liao.entity.Category;
import com.liao.factory.ObjectFactory;
import com.liao.service.CategoryService;


public class CategoryTest {
    //	获取输入方法
    static Scanner sc = new Scanner(System.in);
    //	新建一个用户对象
    static Category category = new Category();
    //	使用多态指向子类
    static CategoryService categoryService = (CategoryService) ObjectFactory.getBean("CategoryService");

    public static void main(String[] args) {
//		add();//添加
//		delect();//删除
//		modif();//修改
//		show();//模糊查询

    }

    /**
     * 添加
     */
    public static void add() {
        Category category = data();
        System.out.println(categoryService.addCategory(category));

    }

    /**
     * 删除
     */
    public static void delect() {
        System.out.println("输入要删除的数据如 12345");
        String str = sc.next();
        category.setId(str);
        System.out.println(categoryService.deleCategory(category));
        categoryService.selectCategoryAll();

    }

    /**
     * 修改
     */
    public static void modif() {
        System.out.println("输入要修改的数据ID如14523");
        String modiID = sc.next();
        category.setId(modiID);
        System.out.println("请输入数据 如 蔬菜");
        String str = sc.next();
        category.setCategory(str);
        System.out.println(categoryService.modiCategory(category));
        categoryService.selectCategoryAll();

    }

    /**
     * 模糊查询
     */
    public static void show() {
        System.out.println("请输入数据 如 蔬菜");
        String str = sc.next();
        category.setId(str);
        category.setCategory(str);
        category.setCreateTime(str);
        categoryService.showCategory(category);
        categoryService.selectCategoryAll();

    }

    /**
     * 将分割数据封装成一个方法
     */
    public static Category data() {
        System.out.println("请输入数据 如 12245,家居");
        String str = sc.next();
        String strs[] = str.split(",");
        category.setId(strs[0]);
        category.setCategory(strs[1]);
        System.out.println(category.toString());
        return category;
    }
}
