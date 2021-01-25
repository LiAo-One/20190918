package com.liao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.liao.dao.UserDao;
import com.liao.entity.Goods;
import com.liao.entity.User;
import com.liao.exception.AddBookExcoption;
import com.liao.exception.DeleExcoption;
import com.liao.exception.LonInExcoption;
import com.liao.exception.ModiExcoption;
import com.liao.exception.ShowIDExcoption;
import com.liao.factory.ObjectFactory;
import com.liao.service.UserService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class UserServiceImpl implements UserService {
    private UserDao userDao = (UserDao) ObjectFactory.getBean("UserDao");

    /**
     * 登录
     */
    @Override
    public ResJson login(User user) {
        ResJson rejs = new ResJson();
        try {
            // 进行 参数 数据判断
            if (user == null) {
                throw new LonInExcoption("登录异常：参数 user 为null  ");
            }

            // 判断参数的name值是否没有数据、
            if (user.getLoginName() == null || user.getLoginName().trim().length() == 0) {
                throw new LonInExcoption("登录异常：登录名没有数据");
            }

            // 判断参数的name值是否没有数据、
            if (user.getLoginPwd() == null || user.getLoginPwd().trim().length() == 0) {
                throw new LonInExcoption("登录异常：密码没有数据");
            }

            // 执行登录：调用userDao层的登录方法
            List<User> userList = userDao.login(user);
            if (userList.size() > 0) {
                rejs.setSub(true);
                rejs.setStr("登录成功");
                rejs.setList(userList);
            } else {
                rejs.setSub(false);
                rejs.setStr("帐号密码错误");
            }

        } catch (Exception e) {
            // 打印异常信息
            e.printStackTrace();
            rejs.setList(null);
            rejs.setStr(e.getMessage());
        }

        return rejs;
    }

    /**
     * 添加
     */
    @Override
    public ResJson addUser(User user) {
        ResJson json = new ResJson();
        int count = 0;
        try {
//			判断添加参数是否为空
            if (user == null) {
                throw new AddBookExcoption("添加的数据为空");
            }
//			判断添加帐号是否唯空
            if (user.getLoginName() == null || user.getLoginName().trim().length() == 0) {
                throw new AddBookExcoption("帐号为空");
            }
//			判断添加密码是否唯空
            if (user.getLoginPwd() == null || user.getLoginPwd().trim().length() == 0) {
                throw new AddBookExcoption("密码为空");
            }

//			判断帐号是否合法
            if (!user.getLoginName().matches("\\w{3,20}")) {
                throw new AddBookExcoption("帐号不合法，登录名只能是：数字、字母、下划线，且长度是3~20");
            }
//			判断密码是否合法
            if (!user.getLoginPwd().matches("[A-Z][0-9a-zA-Z]{2,15}")) {
                throw new AddBookExcoption("密码不合法，密码只能是：数字、字母，且长度是3~16，首字母大写");
            }
//			判断姓名是否为空
            if (user.getNikeName() == null || user.getNikeName().trim().length() < 0) {
//				throw new AddBookExcoption("添加异常：姓名为空");
                user.setNikeName("aaa");
            }
            if (user.getNikeName().length() < 2) {
                throw new AddBookExcoption("姓名不合法");
            }
//			判断年龄是否为空
            if (user.getAge() == null || user.getAge().trim().length() < 0) {
//				throw new AddBookExcoption("添加异常：年龄为空");
                user.setAge("1");
            }
//			判断年龄是否合法
            if (!user.getAge().matches("^(?:[1-9][0-9]?|1[01][0-9]|[120])$")) {
                throw new AddBookExcoption("年龄不合法");
            }
//			判断等级是否为空
            if (user.getLev() == null || user.getLev().trim().length() < 0) {
                user.setLev("1");
            }

//			判断等级是否合法
            if (!user.getLev().matches("^[1-9][0-9]*$")) {
                throw new AddBookExcoption("等级不合法");

            }
//			判断等级是否在许可范围之内
            if (Integer.parseInt(user.getLev()) > 30) {
                throw new AddBookExcoption("等级只能是1-30之间的数字");
            }
//			判断性别是否为空
            if (user.getSex() == null || user.getSex().trim().length() == 0) {
//				throw new AddBookExcoption("添加异常：性别为空");
                user.setSex("男");
            }
            if (user.getImg() == null || user.getImg().trim().length() == 0) {
                user.setImg("QiuYang.jpg");
            }
//			执行添加
            count = userDao.addUser(user);
//			判断添加是否成功
            if (count > 0) {
                json.setSub(true);
                json.setStr("注册成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
            json.setSub(false);
            json.setList(null);
            json.setStr(e.getMessage());
        }
        return json;
    }

    /**
     * 删除
     */
    @Override
    public ResJson deleUser(User user) {
//		存储删除结果数值
        int count = 0;
//		存储结果
        ResJson json = new ResJson();
        try {
//			判断删除参数是否为空
            if (user.getId() == null || user.getId().trim().length() == 0) {
                throw new DeleExcoption("删除异常： 删除的id为空");
            }
            if (Integer.parseInt(user.getLev()) > 5) {
                throw new DeleExcoption("该用户等级大于5，您无权限执行删除");
            }
//			执行删除
            count = userDao.deleUser(user);
//			判断删除是否成功
            if (count > 0) {
                json.setSub(true);
                json.setStr("删除成功");
            } else {
                json.setSub(false);
                json.setStr("该用户有数据残留，无法删除");
            }

        } catch (Exception e) {
            e.printStackTrace();
//			获取删除异常
            json.setSub(false);
            json.setStr(e.getMessage());
        }
        return json;
    }

    /**
     * 修改
     */
    @Override
    public ResJson modiUser(User user) {
        ResJson json = new ResJson();
        int count = 0;
        try {
//			判断修改的参数是否为空
            if (user == null) {
                throw new ModiExcoption("修改异常： 添加修改的数据为空");
            }
//			判断帐号是否唯空
            if (user.getLoginName() == null || user.getLoginName().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 帐号为空");
            }
//			判断密码是否唯空
            if (user.getLoginPwd() == null || user.getLoginPwd().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 密码为空");
            }

//			判断帐号是否合法
            if (!user.getLoginName().matches("\\w{3,20}")) {
                throw new AddBookExcoption("修改异常：帐号不合法，登录名只能是：数字、字母、下划线，且长度是3~20");
            }
//			判断密码是否合法
            if (!user.getLoginPwd().matches("[A-Z][0-9a-zA-Z]{2,15}")) {
                throw new AddBookExcoption("修改异常：密码不合法，密码只能是：数字、字母，且长度是3~16，首字母大写");
            }
//			判断姓名是否为空
            if (user.getNikeName() == null || user.getNikeName().trim().length() < 0) {
                throw new AddBookExcoption("修改异常：姓名为空");
            }
            if (user.getNikeName().length() < 2) {
                throw new AddBookExcoption("修改异常: 姓名不合法");
            }
//			判断年龄是否为空
            if (user.getAge() == null || user.getAge().trim().length() < 0) {
                throw new AddBookExcoption("修改异常：年龄为空");
            }
//			判断年龄是否合法
            if (!user.getAge().matches("^(?:[1-9][0-9]?|1[01][0-9]|[120])$")) {
                throw new AddBookExcoption("修改异常：年龄不合法");
            }
//			判断等级是否合法
            if (!user.getLev().matches("^[1-9][0-9]*$")) {
                throw new AddBookExcoption("修改异常：等级不合法");
            }
//			判断等级是否在许可范围之内
            if (Integer.parseInt(user.getLev()) > 30) {
                throw new AddBookExcoption("修改异常：等级只能是1-30之间的数字");
            }
//			判断性别是否为空
            if (user.getSex() == null || user.getSex().trim().length() == 0) {
                throw new AddBookExcoption("修改异常：性别为空");
            }
//			如果修改性别为空，则赋默认值
            if (user.getLev() == null || user.getLev().trim().length() == 0) {
                user.setLev("1");
            }
//			如果修改图片为空，则赋默认值		
            if (user.getImg() == null || user.getImg().trim().length() == 0) {
                user.setImg("1.jpg");
            }
//			执行修改
            count = userDao.modiUser(user);
//			判断修改是否成功
            if (count > 0) {
                json.setSub(true);
                json.setStr("修改成功");
            } else {
                json.setSub(false);
                json.setStr("修改失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            json.setSub(false);
            json.setStr(e.getMessage());
        }
        return json;
    }

    /**
     * 查询所有
     */
    @Override
    public ResJson selectUserAll() {
        ResJson json = new ResJson();
        List<User> userList = userDao.selectUserAll();
        json.setList(userList);
        return json;
    }


    /**
     * 模糊查询
     */
    @Override
    public void showUser(User user) {
        try {
            if (user == null) {
                throw new ShowIDExcoption("查询异常 ：查询的数据为空");
            }
            userDao.showUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据条件查询
     */
    @Override
    public ResJson selectUserByLimit(int pageNum, int pageSize, User user) {
        ResJson rejs = new ResJson();
//		判断分页数据是否合法
        try {
            if (pageNum < 1) {
                throw new ShowIDExcoption("pageNum不合法");
            }
            if (pageSize < 1) {
                throw new ShowIDExcoption("pageSize不合法");
            }
//			获取查询到的集合
            List<User> userList = userDao.selectUserByLimit(pageNum, pageSize, user);
//			成功
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(userList);
        } catch (Exception e) {
//			异常
            rejs.setSub(false);
            rejs.setStr(e.getMessage());
            rejs.setList(null);
        }
//		返回结果
        return rejs;
    }

    /**
     * 根据条件查询条数
     */
    @Override
    public int selectUserCouny(User user) {
        int count = 0;
        List<User> userList = userDao.selectUserouny(user);
        count = userList.size();

        return count;
    }

    /**
     * 判断用户名是否被占用
     */
    @Override
    public ResJson repeatName(User user) {
        ResJson json = new ResJson();
        int count = 0;
//		获取返回的集合
        List<User> userList = userDao.repeatName(user);
        if (!(userList.size() > 0)) {
            json.setSub(true);
        } else {
            json.setSub(false);
            json.setStr("用户名已被占用");
        }
//		返回结果
        return json;
    }

    
    /**
     * 查询用户余额
     */
	@Override
	public ResJson userPay(User user) {
		
		 ResJson rejs = new ResJson();
//			判断分页数据是否合法
	        try {
//				判断性别是否为空
	            if (user.getId() == null || user.getId().trim().length() == 0) {
	                throw new AddBookExcoption("");
	            }
//				获取查询到的集合
	            List<User> userList = userDao.userIdBalance(user);
	            if(userList.size() > 0){
	            	// 成功
		            rejs.setSub(true);
		            rejs.setStr("成功");
		            rejs.setList(userList);
	            }
	        } catch (Exception e) {
//				异常
	            rejs.setSub(false);
	            rejs.setStr(e.getMessage());
	            rejs.setList(null);
	        }
//			返回结果
	        return rejs;
	}

	
	/**
	 * 用户充值
	 */
	@Override
	public ResJson userRechargs(User user) {
		
		ResJson rejs = new ResJson();
//		判断分页数据是否合法
        try {
//			判断性别是否为空
            if (user.getId() == null || user.getId().trim().length() == 0) {
                throw new AddBookExcoption("");
            }
//			获取查询到的集合
            int count = userDao.userPay(user);
            if(count > 0){
            	// 成功
	            rejs.setSub(true);
	            rejs.setStr("成功");
	            rejs.setList(null);
            }
        } catch (Exception e) {
//			异常
            rejs.setSub(false);
            rejs.setStr(e.getMessage());
            rejs.setList(null);
        }
//		返回结果
        return rejs;
	}
	
	
	

}
