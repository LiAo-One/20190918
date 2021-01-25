package com.liao.service;


import com.liao.entity.Category;
import com.liao.util.ResJson;
@SuppressWarnings("all")
public interface CategoryService {
	/**
	 * 添加
	 * @param category
	 * @return
	 */
	public ResJson addCategory(Category category);
	/**
	 * 删除
	 * @param category
	 * @return
	 */
	public ResJson deleCategory(Category category);
	/**
	 * 修改
	 * @param category
	 * @return
	 */
	public ResJson modiCategory(Category category);
	/**
	 * 模糊查询
	 * @param
	 * @return
	 */
	public ResJson showCategory(Category category);
	/**
	 * 查询所有
	 */
	public ResJson selectCategoryAll();
	
	/**
	 * 分页查询
	 * @return
	 */
	public ResJson selectCategoryByLimit(int pageNum , int pageSize, Category category);


	/**
	 * 按照条件查询数量
	 * @param
	 * @return
	 */
	public int selectCategoryCouny(Category category);
	
	
	/**
	 * 判断类别id是否存在
	 * @param category
	 * @return
	 */
	public ResJson repeatName(Category category);
	
	
	
	
	
	
	
	
	
	
}
