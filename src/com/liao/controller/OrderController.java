package com.liao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liao.entity.Goods;
import com.liao.entity.GoodsImg;
import com.liao.entity.Order;
import com.liao.entity.ShoppingCart;
import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.GoodsImgService;
import com.liao.service.GoodsService;
import com.liao.service.OrderService;
import com.liao.service.ShoppingCartService;
import com.liao.service.UserService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
/**
 * 订单操作类
 * @author liao9
 *
 */
public class OrderController {

    private OrderService orderService = (OrderService) ObjectFactory.getBean("OrderService");

    private GoodsService goodsService = (GoodsService) ObjectFactory.getBean("GoodsService");

    private GoodsImgService goodsImgService = (GoodsImgService) ObjectFactory.getBean("GoodsImgService");

    private ShoppingCartService shoppingCartService = (ShoppingCartService) ObjectFactory.getBean("ShoppingCartService");
   
    private UserService userService = (UserService) ObjectFactory.getBean("UserService");
    
    double userNum = 0;
    /**
     * 订单分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void OrderSelectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ResJson rejson = null;

        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));

        // 获取查询参数
        Order order = new Order();
        // 用户ID
        order.setUserID(request.getParameter("userId"));
        // 用户姓名
        order.setUserName(request.getParameter("userName"));
        // 商品名称
        order.setGoodsName(request.getParameter("godosName"));
        // 订单编号
        order.setNumbering(request.getParameter("numbering"));
        int count = 0;

        count = orderService.selectOrderouny(order, null);

        String json = "{\"total\":\"" + count + "\",\"rows\":[";

        String imgJsonStr;

        rejson = orderService.selectOrderByLimit(pageNum, pageSize, order, null);
        // 获取查询到的数据
        List<Order> orderList = rejson.getList();
        // 循环遍历查询到的数据
        for (int i = 0; i < orderList.size(); i++) {
            // 取出数据
            Order o = orderList.get(i);

            Goods g = new Goods();
            // 获取商品ID
            g.setId(o.getGoodsId());
            // 查询商品图片
            ResJson imgJson = goodsImgService.selectGoodsImg(g);

            List<GoodsImg> imgList = imgJson.getList();

            // 拼接每一张图片
            imgJsonStr = "[";

            // 判断是否有图片
            if (imgList != null) {
                // 遍历集合 将该商品对应的所有图片全部取出
                for (int j = 0; j < imgList.size(); j++) {
                    // 获取当前商品图片对象
                    GoodsImg img = imgList.get(j);
                    // 获取每一张图片 并拼接
                    imgJsonStr += "{\"id\":\"" + img.getId() + "\",\"name\":\"" + img.getName() + "\",\"goodsId\":\"" + img.getGoodsId() + "\",\"createTime\":\"" + img.getTime() + "\"},";
                }
                imgJsonStr = imgJsonStr.substring(0, imgJsonStr.length() - 1);
            }

            imgJsonStr = imgJsonStr + "]";

            // 订单ID
            json += "{\"id\":\"" + o.getId() + "\"" +
                    // 用户ID
                    ",\"userid\":\"" + o.getUserID() + "\"" +
                    // 商品ID
                    ",\"goodsid\":\"" + o.getUserName() + "\"" +
                    // 用户姓名
                    ",\"userName\":\"" + o.getUserName() + "\"" +
                    // 商品名称
                    ",\"productName\":\"" + o.getGoodsName() + "\"" +
                    // 单价
                    ",\"pric\":\"" + o.getPrice() + "\"" +
                    // 数量
                    ",\"quantity\":\"" + o.getQuantity() + "\"" +
                    // 总价
                    ",\"totalPric\":\"" + o.getTotalPric() + "\"" +
                    // 订单编号
                    ",\"numbering\":\"" + o.getNumbering() + "\"" +
                    // 时间
                    ",\"createTime\":\"" + o.getTimes() + "\"" +
                    // 状态
                    ",\"situation\":\"" + o.getStatus() + "\",\"img\":" + imgJsonStr + "\"},";

            json = json.substring(0, json.length() - 3) + "},";
        }

        json = json.substring(0, json.length() - 1) + "]}";
        out.print(json);
        out.flush();
        out.close();
    }
    
    /**
     * 根据ID查询所有
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectUserOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ResJson rejson = null;

        HttpSession s = request.getSession();

        User u = (User) s.getAttribute("user");

        // 获取状态
        Order os = new Order();
        os.setStatus(request.getParameter("situation"));
        int count = 0;

        rejson = orderService.selectUserAllOrderou(os,u);
        count = rejson.getList().size();

        String json = "{\"total\":\"" + count + "\",\"rows\":[";

        rejson = orderService.selectUserAllOrderou(os,u);
        // 获取查询到的数据
        List<Order> orderList = rejson.getList();
        // 循环遍历查询到的数据
        for (int i = 0; i < orderList.size(); i++) {
            // 取出数据
            Order o = orderList.get(i);
            
            Goods g = new Goods();
            // 获取商品ID
            g.setId(o.getGoodsId());
            // 查询商品图片
            ResJson imgJson = goodsImgService.selectGoodsImg(g);

            List<GoodsImg> imgList = imgJson.getList();
            
            // 获取图片
            o.setGoodsImg(imgList.get(0).getName());
            
            // 订单ID
            json += "{\"id\":\"" + o.getId() + "\"" +
                    // 用户ID
                    ",\"userid\":\"" + o.getUserID() + "\"" +
                    // 商品ID
                    ",\"goodsid\":\"" + o.getGoodsId() + "\"" +
                    // 用户姓名
                    ",\"userName\":\"" + o.getUserName() + "\"" +
                    // 商品名称
                    ",\"productName\":\"" + o.getGoodsName() + "\"" +
                    // 商品图片
                    ",\"goodsImg\":\"" + o.getGoodsImg() + "\"" +
                    // 单价
                    ",\"pric\":\"" + o.getPrice() + "\"" +
                    // 数量
                    ",\"quantity\":\"" + o.getQuantity() + "\"" +
                    // 总价
                    ",\"totalPric\":\"" + o.getTotalPric() + "\"" +
                    // 订单编号
                    ",\"numbering\":\"" + o.getNumbering() + "\"" +
                    // 时间
                    ",\"createTime\":\"" + o.getTimes() + "\"" +
                    // 状态
                    ",\"situation\":\"" + o.getStatus() + "\"},";

        }

        json = json.substring(0, json.length() - 1) + "]}";
        out.print(json);
        out.flush();
        out.close();
    }
    
    /**
     * 用户下单功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void userOrderSettlement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 获取当前用户
		HttpSession s = request.getSession();

        User u = (User) s.getAttribute("user");
        
		// 获取用户地址
		String userAddress = request.getParameter("userAddress");
		// 存储向前台输出语句
		String json = "";
		// 存储查询的结果
		ResJson  select = null;
		// 存储添加的结果
		ResJson addShopp = null;
		// 存储修改的结果
		ResJson modiShopp = null;
		// 购物车状态
		ShoppingCart shopp = new ShoppingCart();
		shopp.setSituation("结算");
		// 查询用户购物车属性为“结算”，即为将要付款的
		select = shoppingCartService.selectUserIDShoppingCartCouny(shopp, u);
		// 判断查询是否成功
		if(select.getSub()){
			// 成功
			// 定义集合接收数据
			List<ShoppingCart> shoppingCartList = select.getList();
			// 循环遍历集合
			for (int i = 0; i < shoppingCartList.size(); i++) {
				// 存储遍历的数据
				ShoppingCart shoppReover = new ShoppingCart();
				shoppReover = shoppingCartList.get(i);
				// 将遍历的数据赋值给订单，执行添加
				Order orderAdd = new Order();
				// 用户ID
				orderAdd.setUserID(shoppReover.getUserId());
				// 商品id
				orderAdd.setGoodsId(shoppReover.getGoodsId());
				// 订单编号
					String num = "";
					// 循环生成一个8位数订单编号
					for (int j = 0; j < 8; j++) {
						num += (int)(Math.random()*10);
					}
				orderAdd.setNumbering(num+"");
				// 单价
				orderAdd.setPrice(shoppReover.getPrice());
				// 订单数量 
				orderAdd.setQuantity(shoppReover.getQuantity());
				// 小计
				orderAdd.setTotalPric(shoppReover.getTotalPrice());
				// 订单地址
				orderAdd.setUseraddress(userAddress);
				// 状态
				orderAdd.setStatus("待收货");
				// 执行添加(订单提交)
				addShopp = orderService.addOrder(orderAdd);
				// 修改购物车订单属性(销毁)
				modiShopp = shoppingCartService.deleteShoppingCart(shoppReover);
			}
		}
		// 判断结果
		if (addShopp.getSub() && modiShopp.getSub()) {
			// 成功
			json = "{\"isSuccess\":\"true\",\"order\":\"" + null + "\",\"message\":\"" + modiShopp.getStr() + "\"}";
		} else {
			// 失败
			json = "{\"isSuccess\":\"false\",\"order\":\"" + null + "\",\"message\":\"" + modiShopp.getStr() + "\"}";
		}
		// 输出
		out.print(json);
		out.flush();
		out.close();
	}
    
    /**
     * 用户支付方式
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void userPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
			
		// 支付结果
        //	ouble payNum = 0;
		// 获取当前用户
		HttpSession s = request.getSession();

        User u = (User) s.getAttribute("user");
        String json = "";
		// 获取支付信息
		String userNum = request.getParameter("userPay");
		String money = u.getBalance();

        double payNum = Double.parseDouble(money) - Double.parseDouble(userNum);
		// 判断结果
		if (payNum > 0) {
			// 成功
			json = "{\"isSuccess\":\"true\",\"order\":\"" + null + "\",\"message\":\"支付成功，当前余额"+ payNum +"\"}";
			// 修改余额
			User user = new User();
			user.setId(u.getId());
			user.setBalance(payNum+"");
			
			userService.userPay(user);
		} else {
			// 失败
			json = "{\"isSuccess\":\"false\",\"order\":\"" + null + "\",\"message\":\"支付失败，余额不足\"}";
		}
		// 输出
		out.print(json);
		out.flush();
		out.close();
	}
    
    /**
     * 用户充值方式
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void userRechargs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 获取当前用户
		HttpSession s = request.getSession();

        User u = (User) s.getAttribute("user");
        String json = "";
		// 获取充值信息
		String userNum = request.getParameter("Rechargs");
		
		// 查询当前余额
		
		ResJson resJson = userService.userPay(u);
		// 获取查询的结果
		User uu = (User) resJson.getList().get(0);
		// 余额累加
		double balance = Double.parseDouble(uu.getBalance()) + Double.parseDouble(userNum);
		
		// 修改余额
		User user = new User();
		user.setId(u.getId());
		user.setBalance(balance+"");
		
		resJson = userService.userRechargs(user);
		// 判断结果
		if (resJson.getSub()) {
			// 成功
			json = "{\"isSuccess\":\"true\",\"order\":\"" + null + "\",\"message\":\"充值成功，当前余额"+ balance +"\"}";
			
		} else {
			// 失败
			json = "{\"isSuccess\":\"false\",\"order\":\"" + null + "\",\"message\":\"充值失败\"}";
		}
		// 输出
		out.print(json);
		out.flush();
		out.close();
	}
    
    
    /**
     * 确认收货
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void confirmOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


//		获取ID
        String id = request.getParameter("orderId");

        Order o = new Order();
//		ID
        o.setId(id);

        String json = "";
        ResJson resJson = orderService.modiOrder(o);

        if (resJson.getSub()) {
//			获取当前登录的用户
            json = "{\"isSuccess\":\"true\",\"user\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        } else {
//			失败
            json = "{\"isSuccess\":\"false\",\"user\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        }

        out.print(json);
        out.flush();
        out.close();
    }

}
