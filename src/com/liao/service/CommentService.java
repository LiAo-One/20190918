package com.liao.service;

import com.liao.entity.Comment;
import com.liao.entity.Goods;
import com.liao.entity.User;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public interface CommentService {
    /**
     * 添加
     *
     * @param user
     * @return
     */
    public ResJson addComment(Comment comment, User user);

    /**
     * 删除
     *
     * @param comment
     * @return
     */
    public ResJson deleComment(Comment comment);

    /**
     * 修改
     *
     * @param comment
     * @return
     */
    public ResJson modiComment(Comment comment);

    /**
     * 查询所有
     */
    public ResJson selectCommentAll();

    /**
     * 分页查询
     *
     * @return
     */
    public ResJson selectCommentByLimit(int pageNum, int pageSize,
                                        Comment comment, User user);

    /**
     * 根据条件查询数据条数
     *
     * @param
     * @return
     */
    public int selectCommentouny(Comment comment, User user);

    /**
     * 根据商品id查询评论
     *
     * @param comment
     * @param comment
     * @return
     */
    public ResJson selectGoodsCommentouny(Comment comment, Goods goods);
}
