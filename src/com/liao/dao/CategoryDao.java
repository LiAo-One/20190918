package com.liao.dao;

import java.util.List;

import com.liao.entity.Category;

public interface CategoryDao {
	
	/**
	 * 添加
	 * @param
	 * @return
	 */
	
	public int addCategory(Category category);
	/**
	 * 删除
	 * @param
	 * @return
	 */
	public int deleCategory(Category category);
	/**
	 * 修改
	 * @param
	 * @return
	 */
	public int modiCategory(Category category);
	
	/**
	 * 模糊查询
	 * @param
	 * @return
	 */
	public List<Category> showCategory(Category category);
	/**
	 * 查询所有
	 */
	public List<Category> selectCategoryAll();
	
	/**
	 * 分页查询
	 * @return
	 */
	public List<Category> selectCategoryByLimit(int pageNum , int pageSize,Category category);
	
	/**
	 * 根据条件查询数据条数
	 * @param category
	 * @return
	 */
	public List<Category> selectCategoryCouny(Category category);
	
	/**
	 * 判断类别是否重复
	 * @param category
	 * @return
	 */
	public List<Category> repeatName(Category category);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
