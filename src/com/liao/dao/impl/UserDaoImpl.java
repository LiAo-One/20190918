package com.liao.dao.impl;

import java.util.List;

import javax.swing.JOptionPane;

import com.liao.dao.UserDao;
import com.liao.entity.Goods;
import com.liao.entity.User;
import com.liao.mapper.impl.GoodsMapper;
import com.liao.mapper.impl.UserMapper;
import com.liao.util.JDBCTemplate;

@SuppressWarnings("all")
public class UserDaoImpl implements UserDao {

	static User user = null;

	/**
	 * 登录
	 * 
	 * @param
	 * @param
	 * @return
	 */
	@Override
	public List<User> login(User user) {
		String sql = "select id,nikeName,logName,logPwd,lev,sex,age,img,createTime,balance " + "from user where  logName = binary ? and  logPwd = binary ? ";
		List<User> userList = JDBCTemplate.executeQUery(sql, new UserMapper(), user.getLoginName(), user.getLoginPwd());
		return userList;
	}

	/**
	 * 添加
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public int addUser(User user) {
		int count = 0;
		String sql = "insert user (nikeName,logName,logPwd,lev,sex,age,img,createTime)values" + "(?,?,?,?,?,?,?,now())";
		count = JDBCTemplate.executeUpdate(sql, new UserMapper(), user.getNikeName(), user.getLoginName(), user.getLoginPwd(), user.getLev(), user.getSex(), user.getAge(), user.getImg());

		// 获取数据库操作对象
		// 返回数据库操作结果
		return count;
	}

	/**
	 * 删除
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public int deleUser(User user) {
		String sql = " delete from user where id = ? ";
		int count = JDBCTemplate.executeUpdate(sql, new UserMapper(), user.getId());
		return count;
	}

	/**
	 * 修改
	 * 
	 * @param user
	 *            修改的参数
	 * @return 返回修改了几条数据
	 */
	@Override
	public int modiUser(User user) {
		int count = 0;
		String sql = "update user set nikeName = ?,logPwd = ?,sex = ?,age = ?,img  = ? ,logName = ? , lev = ? where id = ?";
		count = JDBCTemplate
				.executeUpdate(sql, new UserMapper(), user.getNikeName(), user.getLoginPwd(), user.getSex(), user.getAge(), user.getImg(), user.getLoginName(), user.getLev(), user.getId());
		return count;
	}

	/**
	 * 模糊查询
	 */
	@Override
	public void showUser(User user) {
		int i = 0;
		// 查询语句
		String sql = "select id,nikeName,logName,logPwd,lev,sex,age,img,createTime from user where id like ? or loginName like ? or loginPwd like ? or nikeName like ? or lev like ? or sex like ? or age like ? or img like ? or createTime like ? ";
		List<User> list = JDBCTemplate.executeQUery(sql, new UserMapper(), user.getId(), user.getNikeName(), user.getLoginName(), user.getLoginPwd(), user.getLev(), user.getSex(), user.getAge(), user
				.getImg(), user.getCreateTime());
		for (Object attribute : list) {
			System.out.println(attribute.toString());
		}
	}

	/**
	 * 查询所有
	 */
	@Override
	public List<User> selectUserAll() {
		int i = 0;
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append(" select ");
		stringBuffer.append(" * ");
		stringBuffer.append(" from ");
		stringBuffer.append(" user ");
		// 拼接sql语句
		String sql = stringBuffer.toString();
		// 获取查询到的数据
		List<User> userList = JDBCTemplate.executeQUery(sql, new UserMapper(), null);
		return userList;

	}

	/**
	 * 根据条件查询
	 */
	@Override
	public List<User> selectUserByLimit(int pageNum, int pageSize, User user) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select ");
		buffer.append(" id,nikeName,logName,logPwd,lev,sex,age,img,createTime,balance");
		buffer.append(" from user ");
		buffer.append(" where 1 = 1 ");
		if (user != null) {
			// 根据姓名
			if (user.getNikeName() != null && user.getNikeName().trim().length() > 0) {
				buffer.append(" and nikeName like '%" + user.getNikeName() + "%'");
			}
			// 根据账号
			if (user.getLoginName() != null && user.getLoginName().trim().length() > 0) {
				buffer.append(" and logName like '%" + user.getLoginName() + "%'");
			}

			// 根据性别
			if (user.getSex() != null && user.getSex().trim().length() > 0) {
				buffer.append(" and sex = '" + user.getSex() + "'");
			}

			// 根据年龄
			if (user.getAge() != null && user.getAge().trim().length() > 0) {
				buffer.append(" and  age = " + user.getAge());
			}
			// 根据等级
			if (user.getLev() != null && user.getLev().trim().length() > 0) {
				buffer.append(" and  lev = " + user.getLev());
			}
			// 根据密码
			if (user.getLoginPwd() != null && user.getLoginPwd().trim().length() > 0) {
				buffer.append(" and  logPwd like '%" + user.getLoginPwd() + "%'");
			}

			// 根据头像
			if (user.getImg() != null && user.getImg().trim().length() > 0) {
				buffer.append(" and  img like '%" + user.getImg() + "%'");
			}

		}
		buffer.append(" LIMIT " + pageSize * (pageNum - 1) + " , " + pageSize);
		String sql = buffer.toString();

		List<User> userList = JDBCTemplate.executeQUery(sql, new UserMapper(), null);
		return userList;
	}

	/**
	 * 根据条件查询数据条数
	 */
	@Override
	public List<User> selectUserouny(User user) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select ");
		buffer.append(" id,nikeName,logName,logPwd,lev,sex,age,img,createTime,balance");
		buffer.append(" from user ");
		buffer.append(" WHERE 1 = 1 ");
		if (user != null) {
			// 根据姓名
			if (user.getNikeName() != null && user.getNikeName().trim().length() > 0) {
				buffer.append(" and nikeName like '%" + user.getNikeName() + "%'");
			}
			// 根据账号
			if (user.getLoginName() != null && user.getLoginName().trim().length() > 0) {
				buffer.append(" and logName like '%" + user.getLoginName() + "%'");
			}

			// 根据性别
			if (user.getSex() != null && user.getSex().trim().length() > 0) {
				buffer.append(" and sex = '" + user.getSex() + "'");
			}

			// 根据年龄
			if (user.getAge() != null && user.getAge().trim().length() > 0) {
				buffer.append(" and  age = " + user.getAge());
			}
			// 根据等级
			if (user.getLev() != null && user.getLev().trim().length() > 0) {
				buffer.append(" and  lev = " + user.getLev());
			}
			// 根据密码
			if (user.getLoginPwd() != null && user.getLoginPwd().trim().length() > 0) {
				buffer.append(" and  logPwd like '%" + user.getLoginPwd() + "%'");
			}

			// 根据头像
			if (user.getImg() != null && user.getImg().trim().length() > 0) {
				buffer.append(" and  img like '%" + user.getImg() + "%'");
			}
		}

		String sql = buffer.toString();

		List<User> userList = JDBCTemplate.executeQUery(sql, new UserMapper(), null);
		return userList;
	}

	/**
	 * 判断账号是否重复
	 */
	@Override
	public List<User> repeatName(User user) {
		String sql = "select * from user where logName = ?";
		// 获取查询集合
		List<User> userList = JDBCTemplate.executeQUery(sql, new UserMapper(), user.getLoginName());
		// 返回结果集合
		return userList;
	}

	/**
	 * 用户充值
	 */
	@Override
	public int userPay(User user) {
		int count;
		String sql = "update user set balance = ? where id = ?";

		// 获取结果
		count = JDBCTemplate.executeUpdate(sql, new UserMapper(), user.getBalance(), user.getId());
		// 返回结果集合
		return count;
	}

	/**
	 * 根据ID查询用户余额
	 */
	@Override
	public List<User> userIdBalance(User user) {

		String sql = "select * from user where logName = ?";
		// 获取查询集合
		List<User> userList = JDBCTemplate.executeQUery(sql, new UserMapper(), user.getLoginName());
		// 返回结果集合
		return userList;
	}

}
