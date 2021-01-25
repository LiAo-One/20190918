package com.liao.service.impl;

import java.util.List;

import com.liao.dao.CommentDao;
import com.liao.entity.Comment;
import com.liao.entity.Goods;
import com.liao.entity.User;
import com.liao.exception.AddBookExcoption;
import com.liao.exception.ShowIDExcoption;
import com.liao.factory.ObjectFactory;
import com.liao.service.CommentService;
import com.liao.util.ResJson;

public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao = (CommentDao) ObjectFactory.getBean("CommentDao");

    /**
     * 添加
     *
     * @param user
     * @return
     */
    @Override
    public ResJson addComment(Comment comment, User user) {
    	ResJson json = new ResJson();
        int count = 0;
        try {
//			判断添加参数是否为空
            if (comment == null) {
                throw new AddBookExcoption("添加的数据为空");
            }
//			判断添加的用户ID是否为空
            if (comment.getUserid() == null || comment.getUserid().trim().length() == 0) {
                throw new AddBookExcoption("用户不存在");
            }
//			判断商品ID是否为空
            if (comment.getGoodsid() == null || comment.getGoodsid().trim().length() == 0) {
                throw new AddBookExcoption("商品不存在");
            }
//			判断评论语句是否为空
            if (comment.getFell() == null || comment.getFell().trim().length() == 0) {
                throw new AddBookExcoption("写点东西吧！！！");
            }

//			执行添加
            count = commentDao.addComment(comment, user);
//			判断添加是否成功
            if (count > 0) {
                json.setSub(true);
                json.setStr("添加成功");
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
     *
     * @param comment
     * @return
     */
    @Override
    public ResJson deleComment(Comment comment) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 修改
     *
     * @param comment
     * @return
     */
    @Override
    public ResJson modiComment(Comment comment) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 查询所有
     */
    @Override
    public ResJson selectCommentAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 分页查询
     *
     * @return
     */
    @Override
    public ResJson selectCommentByLimit
    (int pageNum, int pageSize, Comment comment, User user) {
//		存储结果
        ResJson rejs = new ResJson();
//		判断分页数据是否合法
        try {
            if (pageNum < 1) {
                throw new ShowIDExcoption("pageNum不合法");
            }

            if (pageSize < 1) {
                throw new ShowIDExcoption("pageSize不合法");
            }
//			获取查询的集合
            List<Comment> commentsList = commentDao.selectCommentByLimit
                    (pageNum, pageSize, comment, user);
//			为结果赋值
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(commentsList);
        } catch (Exception e) {
//			打印异常
            rejs.setSub(false);
            rejs.setStr(e.getMessage());
            rejs.setList(null);
        }
//		返回结果
        return rejs;
    }

    /**
     * 根据条件查询数据条数
     *
     * @param
     * @return
     */
    @Override
    public int selectCommentouny(Comment comment, User user) {
//		存储查询集合的长度
        int count = 0;
//		获取返回的集合
        List<Comment> commentsList = commentDao.selectCommentouny(comment, user);
//		获取长度
        count = commentsList.size();
//		返回长度
        return count;
    }


    
    /**
     * 根据商品ID查询评论
     */
    @Override
    public ResJson selectGoodsCommentouny(Comment comment, Goods goods) {
//		存储结果
        ResJson rejs = new ResJson();
//		判断分页数据是否合法
//			获取查询的集合
        List<Comment> commentsList = commentDao.selectGoodsCommentouny
                (comment, goods);
        try {
//			为结果赋值
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(commentsList);
        } catch (Exception e) {
//			打印异常
            rejs.setSub(false);
            rejs.setStr(e.getMessage());
            rejs.setList(null);
        }
//		返回结果
        return rejs;
    }

}
