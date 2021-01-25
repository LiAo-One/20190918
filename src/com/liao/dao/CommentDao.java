package com.liao.dao;

import java.util.List;

import com.liao.entity.Comment;
import com.liao.entity.Goods;
import com.liao.entity.User;

public interface CommentDao {
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	public int addComment(Comment comment,User user);
	/**
	 * 删除
	 * @param comment
	 * @return
	 */
	public int deleComment(Comment comment);
	/**
	 * 修改
	 * @param comment
	 * @return
	 */
	public int modiComment(Comment comment);

	/**
	 * 查询所有
	 */
	public int selectCommentAll();
	
	/**
	 * 分页查询
	 * @return
	 */
	public List<Comment> selectCommentByLimit(
			int pageNum , int pageSize,Comment comment,User user);
	
	/**
	 * 根据条件查询数据条数
	 * @param
	 * @return
	 */
	public List<Comment> selectCommentouny(Comment comment,User user);
	/**
	 * 根据商品id查询
	 * @param comment
	 * @param comment
	 * @return
	 */
	public List<Comment> selectGoodsCommentouny(Comment comment,Goods goods);
}
