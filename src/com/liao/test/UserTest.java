package com.liao.test;

import java.util.Scanner;

import com.liao.entity.Goods;
import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.CommentService;
import com.liao.service.ShoppingCartService;
import com.liao.service.UserService;
import com.liao.util.ResJson;


public class UserTest {
    //	获取输入方法
    static Scanner sc = new Scanner(System.in);
    //	新建一个用户对象
    static User user = new User();
    //	使用多态指向子类
    static CommentService commService = (CommentService) ObjectFactory.getBean("CommentService");
    static UserService userService = (UserService) ObjectFactory.getBean("UserService");
    static ShoppingCartService shoppingCartService = (ShoppingCartService) ObjectFactory.getBean("ShoppingCartService");

    public static void main(String[] args) {
//		logIn();//登录
//		add();//添加
//		delect();//删除
//		modif();//修改
//		show();//模糊查询
//		logIns();
//		ResJson rejson = shoppingCartService.selectShoppingCartAll(null);
//	
//		List<ShoppingCart> shoppingCartsList = rejson.getList();
//		System.out.println(shoppingCartsList.toString());
    }

    public static void logIns() {
        Goods g = new Goods();
        g.setId("1");
        ResJson json = new ResJson();
        json = commService.selectGoodsCommentouny(null, g);
        System.out.println(json.getList().toString());
    }


    /**
     * 登录
     */
    public static void logIn() {
        User user = new User();
        user.setLoginName("admin");
        user.setLoginPwd("admin");
        System.out.println(userService.login(user));
    }


    /**
     * 添加
     */
    public static void add() {
        User user = data();
        System.out.println(userService.addUser(user));
    }

    /**
     * 删除
     */
    public static void delect() {
        System.out.println("输入要删除的数据如 15");
        String str = sc.next();
        user.setId(str);
        System.out.println(userService.deleUser(user));
    }

    /**
     * 修改
     */
    public static void modif() {
        System.out.println("输入要修改的数据ID如 1");
        String modiID = sc.next();
        user.setId(modiID);
        User user = data();
        System.out.println(userService.modiUser(user));
    }

    /**
     * 模糊查询
     */
    public static void show() {
        System.out.println("请输入数据 如 祝融");
        String str = sc.next();
        user.setId(str);
        user.setNikeName(str);
        user.setLoginName(str);
        user.setLoginPwd(str);
        user.setLev(str);
        user.setSex(str);
        user.setAge(str);
        user.setImg(str);
        user.setCreateTime(str);
        userService.showUser(user);
    }

    /**
     * 分割用户输入的添加修改的数据
     */
    public static User data() {
        System.out.println("请输入数据 如 祝融,admin,admin,12,男,45,1.jpg");
        String str = sc.next();
        String strs[] = str.split(",");
        user.setNikeName(strs[0]);
        user.setLoginName(strs[1]);
        user.setLoginPwd(strs[2]);
        user.setLev(strs[3]);
        user.setSex(strs[4]);
        user.setAge(strs[5]);
        user.setImg(strs[6]);
        System.out.println(user.toString());
        return user;
    }
}
