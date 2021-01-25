package com.liao.dao;

import java.util.List;

import com.liao.entity.Goods;
import com.liao.entity.ShoppingCart;
import com.liao.entity.User;

/**
 * 购物车
 *
 * @author soft01
 */
public interface ShoppingCartDao {
    /**
     * 购物车添加
     *
     * @param shoppingCart
     * @return
     */
    public int addShoppingCart(ShoppingCart shoppingCart);

    /**
     * 模糊查询
     *
     * @param
     * @return
     */
    public void shoppingCart(ShoppingCart shoppingCart);

    /**
     * 查询所有
     */
    public List<ShoppingCart> selectShoppingCartAll(User user);

    /**
     * 分页查询
     *
     * @return
     */
    public List<ShoppingCart> selectShoppingCartByLimit
    (int pageNum, int pageSize, ShoppingCart shoppingCart, User user);


    /**
     * 根据条件查询数据条数
     *
     * @param shoppingCart
     * @param user
     * @return
     */
    public List<ShoppingCart> selectShoppingCartCouny(ShoppingCart shoppingCart, User user);

    /**
     * 购物车数量修改
     *
     * @param shoppingCart
     * @return
     */
    public int modiShoppingCartQuantity(ShoppingCart shoppingCart);


    /**
     * 根据商品ID查询
     * @param goods
     * @return
     */
    public List<ShoppingCart> selectShoppingCartGoodsId(Goods goods);


    /**
     * 购物车删除
     * @param shoppingCart
     * @return
     */

    public int deleteShoppingCartQuantity(ShoppingCart shoppingCart);

    

    /**
     * 购物车商品提交
     * @param shoppingCart
     * @return
     */
    public int shoppingCartSettlement(ShoppingCart shoppingCart);
    
    
    
    /**
     * 查询用户待付款订单
     * @param shoppingCart
     * @param user
     * @return
     */
    public List<ShoppingCart> selectUserShoppingCart(ShoppingCart shoppingCart, User user);
    
    
    
    /**
     * 结算订单ID删除事件
     * @param shoppingCart
     * @return
     */
    public int removeShoppingCartOrfers(ShoppingCart shoppingCart);
    
    
    
    
    
    
    
    
    
}
