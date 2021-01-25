package com.liao.service.impl;

import java.util.List;

import com.liao.dao.ShoppingCartDao;
import com.liao.entity.Goods;
import com.liao.entity.ShoppingCart;
import com.liao.entity.User;
import com.liao.exception.AddBookExcoption;
import com.liao.exception.ModiExcoption;
import com.liao.exception.ShowIDExcoption;
import com.liao.factory.ObjectFactory;
import com.liao.service.ShoppingCartService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private ShoppingCartDao shoppingCartDao = (ShoppingCartDao) ObjectFactory.getBean("ShoppingCartDao");

    /**
     * 查询所有
     */
    @Override
    public ResJson selectShoppingCartAll(User user) {
        ResJson json = new ResJson();

        try {
            List<ShoppingCart> shoppingCartsList = shoppingCartDao.selectShoppingCartAll(user);
            if (shoppingCartsList.size() > 0) {
                json.setSub(true);
                json.setList(shoppingCartsList);
            } else {
                json.setSub(false);
                json.setStr("查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setStr(e.getMessage());
        }

        return json;
    }

    @Override
    public void shoppingCart(ShoppingCart shoppingCart) {


    }

    /**
     * 分页查询
     *
     * @return
     */
    @Override
    public ResJson selectShoppingCartByLimit(int pageNum, int pageSize,
                                             ShoppingCart shoppingCart, User user) {
        ResJson rejs = new ResJson();
        try {
//			判断分页数据是否合法
            if (pageNum < 1) {
                throw new ShowIDExcoption("pageNum不合法");
            }

            if (pageSize < 1) {
                throw new ShowIDExcoption("pageSize不合法");
            }
//			获取查询到的集合
            List<ShoppingCart> shoppingCartList = shoppingCartDao.selectShoppingCartByLimit
                    (pageNum, pageSize, shoppingCart, user);
//			成功
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(shoppingCartList);
        } catch (Exception e) {
//			异常
            rejs.setSub(false);
            rejs.setStr(e.getMessage());
            rejs.setList(null);
        }
//		返回结果
        return rejs;
    }

    /**
     * 查询符合条件的数据条数
     */
    @Override
    public int selectShoppingCartCouny(ShoppingCart shoppingCart, User user) {
        int count = 0;
//		获取返回的集合
        List<ShoppingCart> shoppingCartList = shoppingCartDao.selectShoppingCartCouny(shoppingCart, user);
        count = shoppingCartList.size();
//		返回结果
        return count;
    }

    /**
     * 购物车添加
     */
    @Override
    public ResJson addShoppingCart(ShoppingCart shoppingCart) {
        ResJson json = new ResJson();
        int count = 0;

        try {
//			判断添加参数是否为空
            if (shoppingCart == null) {
                throw new AddBookExcoption("添加的数据为空");
            }
//			判断添用户ID是否唯空
            if (shoppingCart.getUserId() == null || shoppingCart.getUserId().trim().length() == 0) {
                throw new AddBookExcoption("用户ID为空");
            }
//			判断数量是否为空
            if (shoppingCart.getQuantity() == null || shoppingCart.getQuantity().trim().length() < 0) {
                shoppingCart.setQuantity("1");
            }
//			判断价格是否为空
            if (shoppingCart.getPrice() == null || shoppingCart.getPrice().trim().length() < 0) {
                shoppingCart.setPrice("1.00");
            }
//			判断小计是否为空
            if (shoppingCart.getTotalPrice() == null || shoppingCart.getTotalPrice().trim().length() == 0) {
                shoppingCart.setTotalPrice("1.00");
            }
//			执行添加
            count = shoppingCartDao.addShoppingCart(shoppingCart);
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
     * 修改购物车数量
     */
    @Override
    public ResJson modiShoppingCartQuantity(ShoppingCart shoppingCart) {
        ResJson json = new ResJson();
        int count = 0;
        try {
//			判断修改的参数是否为空
            if (shoppingCart == null) {
                throw new ModiExcoption("修改异常： 添加修改的数据为空");
            }
//			判断ID是否唯空
            if (shoppingCart.getId() == null || shoppingCart.getId().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 购物车ID为空");
            }
////			判断数量是否唯空
//            if (shoppingCart.getPrice() == null || shoppingCart.getPrice().trim().length() == 0) {
//                throw new AddBookExcoption("修改异常： 密码为空");
//            }

//			判断小计是否为空
            if (shoppingCart.getTotalPrice() == null || shoppingCart.getTotalPrice().trim().length() < 0) {
                throw new AddBookExcoption("修改异常：小计为空");
            }
//			执行修改
            count = shoppingCartDao.modiShoppingCartQuantity(shoppingCart);
//			判断修改是否成功
            if (count > 0) {
                json.setSub(true);
                json.setStr("修改成功");
            } else {
                json.setSub(false);
                json.setStr("修改失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            json.setSub(false);
            json.setStr(e.getMessage());
        }
        return json;
    }

    /**
     * 根据商品ID查询购物车
     * @param goods
     * @return
     */
    @Override
    public ResJson selectShoppingCartGoodsId(Goods goods) {

        ResJson rejs = new ResJson();
        try {
//			获取查询到的集合
            List<ShoppingCart> shoppingCartList = shoppingCartDao.selectShoppingCartGoodsId(goods);
//			成功
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(shoppingCartList);
        } catch (Exception e) {
//			异常
            rejs.setSub(false);
            rejs.setStr(e.getMessage());
            rejs.setList(null);
        }
//		返回结果
        return rejs;
    }

    
    /**
     * 购物车根据条件查询
     */
	@Override
	public ResJson selectUserIDShoppingCartCouny(ShoppingCart shoppingCart, User user) {
		
		ResJson rejs = new ResJson();
        try {
//			获取查询到的集合
            List<ShoppingCart> shoppingCartList = shoppingCartDao.selectUserShoppingCart(shoppingCart, user);
//			成功
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(shoppingCartList);
        } catch (Exception e) {
//			异常
            rejs.setSub(false);
            rejs.setStr(e.getMessage());
            rejs.setList(null);
        }
//		返回结果
        return rejs;
	}

	
	/**
	 * 购物车删除
	 */
	@Override
	public ResJson deleteShoppingCart(ShoppingCart shoppingCart) {
		ResJson json = new ResJson();
        int count = 0;
        try {
//			判断修改的参数是否为空
            if (shoppingCart == null) {
                throw new ModiExcoption("修改异常： 添加修改的数据为空");
            }
//			判断ID是否唯空
            if (shoppingCart.getId() == null || shoppingCart.getId().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 购物车ID为空");
            }

//			执行修改
            count = shoppingCartDao.deleteShoppingCartQuantity(shoppingCart);
//			判断修改是否成功
            if (count > 0) {
                json.setSub(true);
                json.setStr("删除成功");
            } else {
                json.setSub(false);
                json.setStr("删除失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            json.setSub(false);
            json.setStr(e.getMessage());
        }
        return json;
	}

	
	/**
	 * 购物车商品提交
	 */
	@Override
	public ResJson shoppingCartSettlement(ShoppingCart shoppingCart) {
		ResJson json = new ResJson();
        int count = 0;
        try {
//			判断修改的参数是否为空
            if (shoppingCart == null) {
                throw new ModiExcoption("提交异常： 数据为空");
            }
//			判断ID是否唯空
            if (shoppingCart.getId() == null || shoppingCart.getId().trim().length() == 0) {
                throw new AddBookExcoption("提交异常： 购物车ID为空");
            }

//			执行修改
            count = shoppingCartDao.shoppingCartSettlement(shoppingCart);
//			判断修改是否成功
            if (count > 0) {
                json.setSub(true);
                json.setStr("成功");
            } else {
                json.setSub(false);
                json.setStr("失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            json.setSub(false);
            json.setStr(e.getMessage());
        }
        return json;
	}

	
	/**
	 * 购物车订单删除
	 */
	@Override
	public ResJson removeShoppingCartOrfers(ShoppingCart shoppingCart) {
		ResJson json = new ResJson();
        int count = 0;
        try {
//			判断修改的参数是否为空
            if (shoppingCart == null) {
                throw new ModiExcoption("修改异常： 添加修改的数据为空");
            }
//			判断ID是否唯空
            if (shoppingCart.getId() == null || shoppingCart.getId().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 购物车ID为空");
            }

//			执行修改
            count = shoppingCartDao.removeShoppingCartOrfers(shoppingCart);
//			判断修改是否成功
            if (count > 0) {
                json.setSub(true);
                json.setStr("删除成功");
            } else {
                json.setSub(false);
                json.setStr("删除失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            json.setSub(false);
            json.setStr(e.getMessage());
        }
        return json;
	}

}
