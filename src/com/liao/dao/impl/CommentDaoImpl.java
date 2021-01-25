package com.liao.dao.impl;

import java.util.List;

import com.liao.dao.CommentDao;
import com.liao.entity.Comment;
import com.liao.entity.Goods;
import com.liao.entity.User;
import com.liao.mapper.impl.CommentMapper;
import com.liao.mapper.impl.UserMapper;
import com.liao.util.JDBCTemplate;

@SuppressWarnings("all")
public class CommentDaoImpl implements CommentDao {
    /**
     * 评论添加添加
     */
    @Override
    public int addComment(Comment comment, User user) {
    	int count = 0;
        String sql = "insert comment (userid,goodsid,mood,feel,situation,creatime)values" +
                "(?,?,'好评',?,'是',now())";
        count = JDBCTemplate.executeUpdate(sql, new UserMapper(),
        		comment.getUserid(),
        		comment.getGoodsid(),
        		comment.getFell());
//		返回数据库操作结果
        return count;
    }

    /**
     * 删除
     */
    @Override
    public int deleComment(Comment comment) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 修改
     */
    @Override
    public int modiComment(Comment comment) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 查询全部
     */
    @Override
    public int selectCommentAll() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 分页查询
     */
    @Override
    public List<Comment> selectCommentByLimit(int pageNum, int pageSize, Comment comment, User user) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" c.id ,c.userid ,u.nikeName,u.img,c.goodsid,g.productName ,c.mood ,c.feel ,c.situation,c.creatime");
        buffer.append(" from comment c ");
        buffer.append(" inner join user u ");
        buffer.append(" on c.userid = u.id ");
        buffer.append(" inner join goods g ");
        buffer.append(" on c.goodsid = g.id ");
        if (user == null) {
            buffer.append(" where 1 = 1 ");
        } else {
            buffer.append(" where c.userid = " + user.getId());
        }
        if (comment != null) {
//			根据商品名称
            if (comment.getGoodsName() != null && comment.getGoodsName().length() > 0) {
                buffer.append(" and g.productName like '%" + comment.getGoodsName() + "%'");
            }
//			根据满意度
            if (comment.getMood() != null && comment.getMood().trim().length() > 0) {
                buffer.append(" and c.mood like '%" + comment.getMood() + "%'");
            }

//			根据评论语句
            if (comment.getFell() != null && comment.getFell().trim().length() > 0) {
                buffer.append(" and c.feel like '%" + comment.getFell() + "%'");
            }
//			根据用户姓名
            if (comment.getUserName() != null && comment.getUserName().trim().length() > 0) {
                buffer.append(" and u.nikeName like '%" + comment.getUserName() + "%'");
            }

//			根据用户ID
            if (comment.getUserid() != null && comment.getUserid().trim().length() > 0) {
                buffer.append(" and c.userid = " + comment.getUserid());
            }
            

        }
        buffer.append(" LIMIT " + pageSize * (pageNum - 1) + " , " + pageSize);
        String sql = buffer.toString();
        
        List<Comment> commentList = JDBCTemplate.executeQUery(sql, new CommentMapper(), null);
        return commentList;
    }

    /**
     * 查询满足条件的条
     */
    @Override
    public List<Comment> selectCommentouny(Comment comment, User user) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" c.id ,c.userid ,u.nikeName,u.img,c.goodsid,g.productName ,c.mood ,c.feel ,c.situation,c.creatime");
        buffer.append(" from comment c ");
        buffer.append(" inner join user u ");
        buffer.append(" on c.userid = u.id ");
        buffer.append(" inner join goods g ");
        buffer.append(" on c.goodsid = g.id ");
        if (user == null) {
            buffer.append(" where 1 = 1 ");
        } else {
            buffer.append(" where c.userid = " + user.getId());
        }
        if (comment != null) {
//			根据商品名称
            if (comment.getGoodsName() != null && comment.getGoodsName().length() > 0) {
                buffer.append(" and g.productName like '%" + comment.getGoodsName() + "%'");
            }
//			根据满意度
            if (comment.getMood() != null && comment.getMood().trim().length() > 0) {
                buffer.append(" and c.mood like '%" + comment.getMood() + "%'");
            }

//			根据评论语句
            if (comment.getFell() != null && comment.getFell().trim().length() > 0) {
                buffer.append(" and c.feel like '%" + comment.getFell() + "%'");
            }

//			根据用户姓名
            if (comment.getUserName() != null && comment.getUserName().trim().length() > 0) {
                buffer.append(" and u.nikeName like '%" + comment.getUserName() + "%'");
            }

//			根据用户ID
            if (comment.getUserid() != null && comment.getUserid().trim().length() > 0) {
                buffer.append(" and c.userid = " + comment.getUserid());
            }

        }
        String sql = buffer.toString();
        List<Comment> commentList = JDBCTemplate.executeQUery(sql, new CommentMapper(), null);

        return commentList;
    }

    /**
     * 根据商品ID查询
     */
    @Override
    public List<Comment> selectGoodsCommentouny(Comment comment, Goods goods) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" c.id ,c.userid ,u.nikeName,u.img,c.goodsid,g.productName ,c.mood ,c.feel ,c.situation,c.creatime");
        buffer.append(" from comment c ");
        buffer.append(" inner join user u ");
        buffer.append(" on c.userid = u.id ");
        buffer.append(" inner join goods g ");
        buffer.append(" on c.goodsid = g.id ");
        if (comment == null) {
            buffer.append(" where 1 = 1 ");
        } else {
            buffer.append(" where c.goodsid = " + comment.getGoodsid());
        }

        if (comment != null) {
//			根据商品名称
            if (comment.getGoodsName() != null && comment.getGoodsName().length() > 0) {
                buffer.append(" and g.productName like '%" + comment.getGoodsName() + "%'");
            }
//			根据满意度
            if (comment.getMood() != null && comment.getMood().trim().length() > 0) {
                buffer.append(" and c.mood like '%" + comment.getMood() + "%'");
            }

//			根据评论语句
            if (comment.getFell() != null && comment.getFell().trim().length() > 0) {
                buffer.append(" and c.feel like '%" + comment.getFell() + "%'");
            }

//			根据用户姓名
            if (comment.getUserName() != null && comment.getUserName().trim().length() > 0) {
                buffer.append(" and u.nikeName like '%" + comment.getUserName() + "%'");
            }

//			根据用户ID
            if (comment.getUserid() != null && comment.getUserid().trim().length() > 0) {
                buffer.append(" and c.userid = " + comment.getUserid());
            }

        }
        String sql = buffer.toString();
        List<Comment> commentList = JDBCTemplate.executeQUery(sql, new CommentMapper(), null);

        return commentList;
    }

}
