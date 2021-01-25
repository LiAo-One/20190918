package com.liao.service;


import com.liao.entity.Goods;
import com.liao.entity.ShoppingCart;
import com.liao.entity.User;
import com.liao.util.ResJson;

import java.util.List;

@SuppressWarnings("all")
public interface ShoppingCartService {
    /**
     * 购物车添加
     *
     * @param shoppingCart
     * @return
     */
    public ResJson addShoppingCart(ShoppingCart shoppingCart);

    /**
     * 查询所有
     *
     * @param user
     * @return
     */
    public ResJson selectShoppingCartAll(User user);

    /**
     * 模糊查询
     *
     * @param
     * @return
     */
    public void shoppingCart(ShoppingCart shoppingCart);

    /**
     * 分页查询
     *
     * @return
     */
    public ResJson selectShoppingCartByLimit
    (int pageNum, int pageSize, ShoppingCart shoppingCart, User user);

    /**
     * 根据条件查询数据条数
     *
     * @param user
     * @return
     */
    public int selectShoppingCartCouny(ShoppingCart shoppingCart, User user);

    /**
     * 修改购物车数量
     *
     * @param shoppingCart
     * @return
     */
    public ResJson modiShoppingCartQuantity(ShoppingCart shoppingCart);


    /**
     * 根据商品ID查询
     * @param goods
     * @return
     */
    public ResJson selectShoppingCartGoodsId(Goods goods);
    
    
    /**
     * 根据条件查询数据
     *
     * @param user
     * @return
     */
    public ResJson selectUserIDShoppingCartCouny(ShoppingCart shoppingCart, User user);
    
    /**
     * 购物车删除
     * @param shoppingCart
     * @return
     */
    public ResJson deleteShoppingCart(ShoppingCart shoppingCart);
    
    
    /**
     * 购物车商品提交
     * @param shoppingCart
     * @return
     */
    public ResJson shoppingCartSettlement(ShoppingCart shoppingCart);
    
    /**
     * 结算订单ID删除事件
     * @param shoppingCart
     * @return
     */
    public ResJson removeShoppingCartOrfers(ShoppingCart shoppingCart);
}
