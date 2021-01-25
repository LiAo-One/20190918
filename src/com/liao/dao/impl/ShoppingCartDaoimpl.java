package com.liao.dao.impl;

import java.util.List;

import com.liao.dao.ShoppingCartDao;
import com.liao.entity.Goods;
import com.liao.entity.ShoppingCart;
import com.liao.entity.User;
import com.liao.mapper.impl.ShoppingCartMapper;
import com.liao.mapper.impl.UserMapper;
import com.liao.util.JDBCTemplate;

@SuppressWarnings("all")
public class ShoppingCartDaoimpl implements ShoppingCartDao {
    /**
     * 查询所有
     */
    @Override
    public List<ShoppingCart> selectShoppingCartAll(User user) {
        // 数据库语句
        StringBuffer buffer = new StringBuffer();
        if (user == null) {
            buffer.append(" select s.id,s.userid,u.nikeName,g.id,g.productName,s.img,s.pric,s.totalPric,s.quantity,s.situation,s.creatime ");
            buffer.append(" from shoppingcart s ");
            buffer.append(" inner join user u ");
            buffer.append(" on s.userid = u.id ");
            buffer.append(" inner join goods g ");
            buffer.append(" on s.id = g.id ");

        } else {
            buffer.append(" select s.id,s.userid,u.nikeName,g.id,g.productName,s.img,s.pric,s.totalPric,s.quantity,s.situation,s.creatime ");
            buffer.append(" from shoppingcart s ");
            buffer.append(" inner join user u ");
            buffer.append(" on s.userid = u.id ");
            buffer.append(" inner join goods g ");
            buffer.append(" on s.id = g.id ");
            buffer.append(" where u.id =  " + user.getId());

        }
        String sql = buffer.toString();
        List<ShoppingCart> shoppingCartsList = JDBCTemplate.executeQUery(sql, new ShoppingCartMapper(), null);
        return shoppingCartsList;
    }

    /**
     * 模糊查询
     *
     * @param
     * @return
     */
    @Override
    public void shoppingCart(ShoppingCart shoppingCart) {
        // TODO Auto-generated method stub

    }

    /**
     * 分页查询
     *
     * @return
     */
    @Override
    public List<ShoppingCart> selectShoppingCartByLimit(int pageNum, int pageSize, ShoppingCart shoppingCart, User user) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select s.id,s.userid,u.nikeName,g.id,g.productName,s.img,s.pric,s.quantity,s.totalPric,s.situation,s.creatime ");
        buffer.append(" from shoppingcart s ");
        buffer.append(" inner join user u ");
        buffer.append(" on s.userid = u.id ");
        buffer.append(" inner join goods g ");
        buffer.append(" on s.id = g.id ");
        if (user == null) {
            buffer.append(" where 1 = 1");
        } else {
            buffer.append(" where s.userid =  " + user.getId());
        }
        if (shoppingCart != null) {

            // 根据用户ID
            if (shoppingCart.getUserId() != null && shoppingCart.getUserId().trim().length() > 0) {
                buffer.append(" and s.userid like '%" + shoppingCart.getUserId() + "%'");
            }

            // 根据用户姓名
            if (shoppingCart.getUserName() != null && shoppingCart.getUserName().trim().length() > 0) {
                buffer.append(" and u.nikeName like '%" + shoppingCart.getUserName() + "%'");
            }

            // 根据商品名称
            if (shoppingCart.getGoodsName() != null && shoppingCart.getGoodsName().trim().length() > 0) {
                buffer.append(" and g.productName like '%" + shoppingCart.getGoodsName() + "%'");
            }
            // 根据价格
            if (shoppingCart.getPrice() != null && shoppingCart.getPrice().trim().length() > 0) {
                buffer.append(" and g.price like '%" + shoppingCart.getPrice() + "%'");
            }

            // 根据图片
            if (shoppingCart.getImg() != null && shoppingCart.getImg().trim().length() > 0) {
                buffer.append(" and g.img like '%" + shoppingCart.getImg() + "%'");
            }

            // 根据数量
            if (shoppingCart.getQuantity() != null && shoppingCart.getQuantity().trim().length() > 0) {
                buffer.append(" and  s.quantity = '" + shoppingCart.getQuantity() + "'");
            }

            // 根据状态
            if (shoppingCart.getSituation() != null && shoppingCart.getSituation().trim().length() > 0) {
                buffer.append(" and  s.situation like '%" + shoppingCart.getSituation() + "%'");
            }

        }
        buffer.append(" LIMIT " + pageSize * (pageNum - 1) + " , " + pageSize);
        String sql = buffer.toString();
        List<ShoppingCart> shoppingCartsList = JDBCTemplate.executeQUery(sql, new ShoppingCartMapper(), null);
        return shoppingCartsList;
    }

    /**
     * 根据条件查询数据条数
     *
     * @param goods
     * @return
     */
    @Override
    public List<ShoppingCart> selectShoppingCartCouny(ShoppingCart shoppingCart, User user) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select s.id,s.userid,u.nikeName,g.id,g.productName,s.img,s.pric,s.quantity,s.totalPric,s.situation,s.creatime ");
        buffer.append(" from shoppingcart s ");
        buffer.append(" inner join user u ");
        buffer.append(" on s.userid = u.id ");
        buffer.append(" inner join goods g ");
        buffer.append(" on s.id = g.id ");
        if (user == null) {
            buffer.append(" where 1 = 1");
        } else {
            buffer.append(" where s.userid =  " + user.getId());
        }

        if (shoppingCart != null) {

            // 根据用户ID
            if (shoppingCart.getUserId() != null && shoppingCart.getUserId().trim().length() > 0) {
                buffer.append(" and s.userid like '%" + shoppingCart.getUserId() + "%'");
            }

            // 根据用户姓名
            if (shoppingCart.getUserName() != null && shoppingCart.getUserName().trim().length() > 0) {
                buffer.append(" and u.nikeName like '%" + shoppingCart.getUserName() + "%'");
            }

            // 根据商品名称
            if (shoppingCart.getGoodsName() != null && shoppingCart.getGoodsName().trim().length() > 0) {
                buffer.append(" and g.productName like '%" + shoppingCart.getGoodsName() + "%'");
            }
            // 根据价格
            if (shoppingCart.getPrice() != null && shoppingCart.getPrice().trim().length() > 0) {
                buffer.append(" and g.price like '%" + shoppingCart.getPrice() + "%'");
            }

            // 根据图片
            if (shoppingCart.getImg() != null && shoppingCart.getImg().trim().length() > 0) {
                buffer.append(" and g.img like '%" + shoppingCart.getImg() + "%'");
            }

            // 根据数量
            if (shoppingCart.getQuantity() != null && shoppingCart.getQuantity().trim().length() > 0) {
                buffer.append(" and  s.quantity = '" + shoppingCart.getQuantity() + "'");
            }

            // 根据状态
            if (shoppingCart.getSituation() != null && shoppingCart.getSituation().trim().length() > 0) {
                buffer.append(" and  s.situation like '%" + shoppingCart.getSituation() + "%'");
            }

        }
        String sql = buffer.toString();
        List<ShoppingCart> shoppingCartsList = JDBCTemplate.executeQUery(sql, new ShoppingCartMapper(), null);
        return shoppingCartsList;
    }

    /**
     * 购物车添加
     *
     * @param shoppingCart
     * @return
     */
    @Override
    public int addShoppingCart(ShoppingCart shoppingCart) {
        int count = 0;
        String sql = "insert shoppingcart (goodsid,userid,quantity,pric,totalPric,situation,creatime)values" + "(?,?,?,?,?,?,now())";
        count = JDBCTemplate.executeUpdate(sql, new ShoppingCartMapper(),
                shoppingCart.getGoodsId(),
                shoppingCart.getUserId(),
                shoppingCart.getQuantity(),
                shoppingCart.getPrice(),
                shoppingCart.getTotalPrice(),
                shoppingCart.getSituation());

        // 返回数据库操作结果
        return count;
    }

    /**
     * 购物车数量小计修改方法
     */
    @Override
    public int modiShoppingCartQuantity(ShoppingCart shoppingCart) {
        int count = 0;
        String sql = "update shoppingcart set quantity = ?,totalPric  = ? where id = ?";
        count = JDBCTemplate.executeUpdate(sql, new UserMapper(), shoppingCart.getQuantity(), shoppingCart.getTotalPrice(), shoppingCart.getId());
        return count;
    }

    /**
     * 根据商品ID查询
     * @param goods
     * @return
     */
    @Override
    public List<ShoppingCart> selectShoppingCartGoodsId(Goods goods) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select s.id,s.userid,u.nikeName,g.id,g.productName,s.img,s.pric,s.quantity,s.totalPric,s.situation,s.creatime ");
        buffer.append(" from shoppingcart s ");
        buffer.append(" inner join user u ");
        buffer.append(" on s.userid = u.id ");
        buffer.append(" inner join goods g ");
        buffer.append(" on s.goodsid = g.id ");
        buffer.append(" where g.id = "+goods.getId());
        buffer.append(" and s.situation = '待结算'");

        String sql = buffer.toString();

        List<ShoppingCart> shoppingCartsList = JDBCTemplate.executeQUery(sql, new ShoppingCartMapper(), null);
        return shoppingCartsList;
    }


    /**
     * 购物车删除
     * @param shoppingCart
     * @return
     */
    @Override
    public int deleteShoppingCartQuantity(ShoppingCart shoppingCart) {
        StringBuffer buffer = new StringBuffer();

        buffer.append(" update  shoppingcart set situation = '已销毁' where id = ?");

        String sql = buffer.toString();
        int count = JDBCTemplate.executeUpdate(sql, null, shoppingCart.getId());
        return count;
    }

    
    /**
     * 购物车商品提交方式
     */
	@Override
	public int shoppingCartSettlement(ShoppingCart shoppingCart) {
		StringBuffer buffer = new StringBuffer();

        buffer.append(" update  shoppingcart set situation = '结算' where id = ?");

        String sql = buffer.toString();
        int count = JDBCTemplate.executeUpdate(sql, null, shoppingCart.getId());
        return count;
	}

	
	/**
	 * 查询用户待付款购物车
	 */
	@Override
	public List<ShoppingCart> selectUserShoppingCart(ShoppingCart shoppingCart, User user) {
		StringBuffer buffer = new StringBuffer();
        buffer.append(" select s.id,s.userid,u.nikeName,g.id,g.productName,s.img,s.pric,s.quantity,s.totalPric,s.situation,s.creatime ");
        buffer.append(" from shoppingcart s ");
        buffer.append(" inner join user u ");
        buffer.append(" on s.userid = u.id ");
        buffer.append(" inner join goods g ");
        buffer.append(" on s.goodsid = g.id ");
        buffer.append(" where s.userid =  " + user.getId());
        buffer.append(" and s.situation = '" + shoppingCart.getSituation() + "'");
        
        String sql = buffer.toString();
        
        List<ShoppingCart> shoppingCartsList = JDBCTemplate.executeQUery(sql, new ShoppingCartMapper(), null);
        
        return shoppingCartsList;
	}

	
	/**
	 * 结算订单删除
	 */
	@Override
	public int removeShoppingCartOrfers(ShoppingCart shoppingCart) {
		
		StringBuffer buffer = new StringBuffer();

        buffer.append(" update  shoppingcart set situation = '待结算' where id = ?");

        String sql = buffer.toString();
        int count = JDBCTemplate.executeUpdate(sql, null, shoppingCart.getId());
        return count;
	}
	
	
}
