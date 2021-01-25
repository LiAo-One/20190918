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
import com.liao.entity.ShoppingCart;
import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.GoodsImgService;
import com.liao.service.ShoppingCartService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
/**
 * 购物车操作
 *
 * @author soft01
 *
 */
public class ShoppingCartController {

	private ShoppingCartService shoppingCartService = (ShoppingCartService) ObjectFactory.getBean("ShoppingCartService");

	private GoodsImgService goodsImgService = (GoodsImgService) ObjectFactory.getBean("GoodsImgService");

	/**
	 * 购物车分页查询
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void shopinnCartSelectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ResJson rejson = null;

		Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
		Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));

		// 获取查询参数
		ShoppingCart shopping = new ShoppingCart();
		// 用户ID
		shopping.setUserId(request.getParameter("userId"));
		// 用户名称
		shopping.setUserName(request.getParameter("userName"));
		// 商品名称
		shopping.setGoodsName(request.getParameter("goodsName"));
		// 状态
		shopping.setSituation(request.getParameter("situation"));
		int count = 0;

		count = shoppingCartService.selectShoppingCartCouny(shopping, null);

		String json = "{\"total\":\"" + count + "\",\"rows\":[";

		String imgJsonStr;
		rejson = shoppingCartService.selectShoppingCartByLimit(pageNum, pageSize, shopping, null);
		// 获取查询到的数据
		List<ShoppingCart> shoppingCartsList = rejson.getList();
		// 循环遍历查询到的数据
		for (int i = 0; i < shoppingCartsList.size(); i++) {
			// 取出数据
			ShoppingCart shoppingCart = shoppingCartsList.get(i);

			Goods g = new Goods();
			// 获取商品ID
			g.setId(shoppingCart.getGoodsId());
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

			// 购物车ID
			json += "{\"id\":\"" + shoppingCart.getId() + "\"" +
			// 用户ID
					",\"userid\":\"" + shoppingCart.getUserId() + "\"" +
					// 用户姓名
					",\"userName\":\"" + shoppingCart.getUserName() + "\"" +
					// 商品名称
					",\"productName\":\"" + shoppingCart.getGoodsName() + "\"" +
					// 时间
					",\"creatime\":\"" + shoppingCart.getTimes() + "\"" +
					// 数量
					",\"quantity\":\"" + shoppingCart.getQuantity() + "\"" +
					// 单价
					",\"pric\":\"" + shoppingCart.getPrice() + "\"" +
					// 小计
					",\"totalPric\":\"" + shoppingCart.getTotalPrice() + "\"" +
					// 状态
					",\"situation\":\"" + shoppingCart.getSituation() + "\",\"img\":" + imgJsonStr + "\"},";

			json = json.substring(0, json.length() - 3) + "},";
		}

		json = json.substring(0, json.length() - 1) + "]}";
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 购物车添加
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addShopinnCartSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		HttpSession s = request.getSession();

		User u = (User) s.getAttribute("user");

		// 获取商品ID
		String goodsid = request.getParameter("goodsId");

		// 获取单价

		String goodsPrice = request.getParameter("goodsPrice");
		// 存储向前台输出语句
		String json = "";
		// 存储添加或修改的结果
		ResJson resJson = null;
		// 获取请求的数据
		Goods goods = new Goods();

		goods.setId(request.getParameter("goodsId"));

		// 判断商品是否已经存在购物车
		resJson = shoppingCartService.selectShoppingCartGoodsId(goods);

		if (!(resJson.getList().size() <= 0)) {
			// 有数据，执行购物车修改功能
			List<ShoppingCart> modifiShoppinn = resJson.getList();
			// 获取查询到集合的第一条数据的、数量、小计、id
			String id = modifiShoppinn.get(0).getId();
			// 数量
			int quantity = Integer.parseInt(modifiShoppinn.get(0).getQuantity());
			// 单价
			double price = Double.parseDouble(modifiShoppinn.get(0).getPrice());
			// 小计
			// 数量加一
			quantity++;
			String totalPric = (quantity * price) + "";
			// 存储购物车修改的数据
			ShoppingCart shopp = new ShoppingCart();
			// id
			shopp.setId(id);
			// 数量
			shopp.setQuantity(quantity + "");
			// 小计
			shopp.setTotalPrice(totalPric);
			// 调用修改方法
			resJson = shoppingCartService.modiShoppingCartQuantity(shopp);

			json = "{\"isSuccess\":\"true\",\"shopp\":\"" + null + "\",\"message\":\"添加成功\"}";
		} else {
			// 商品不存在购物车，执行添加

			ShoppingCart addShopinnCart = new ShoppingCart();

			// 商品ID
			addShopinnCart.setGoodsId(goodsid);
			// 用户ID
			addShopinnCart.setUserId(u.getId());
			// 商品数量
			addShopinnCart.setQuantity("1");
			// 商品单价
			addShopinnCart.setPrice(goodsPrice);
			// 商品小计
			// 价格转换类型
			double price = Double.parseDouble(addShopinnCart.getPrice());

			addShopinnCart.setTotalPrice((price * 1) + "");
			// 状态
			addShopinnCart.setSituation("待结算");

			resJson = shoppingCartService.addShoppingCart(addShopinnCart);
			json = "{\"isSuccess\":\"true\",\"shopp\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
		}

		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 购物车数量修改
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modiShoppingCartQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 存储向前台输出语句
		String json = "";
		// 存储添加或修改的结果
		ResJson resJson = null;
		// 获取请求的数据
		ShoppingCart modiShoppin = new ShoppingCart();
		modiShoppin.setId(request.getParameter("shoppid"));
		modiShoppin.setQuantity(request.getParameter("quantity"));
		modiShoppin.setTotalPrice(request.getParameter("totalPrice"));
		// 执行修改
		resJson = shoppingCartService.modiShoppingCartQuantity(modiShoppin);
		// 判断结果
		if (resJson.getSub()) {
			// 修改成功
			json = "{\"isSuccess\":\"true\",\"shopp\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
		} else {
			json = "{\"isSuccess\":\"false\",\"shopp\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
		}
		// 输出
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 查询用户购物车
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void shopinnCartUserIdAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ResJson rejson = null;

		HttpSession s = request.getSession();

		User u = (User) s.getAttribute("user");

		int count = 0;
		// 获取购物车状态
		ShoppingCart shopp = new ShoppingCart();
		
		shopp.setSituation(request.getParameter("situation"));
		rejson = shoppingCartService.selectUserIDShoppingCartCouny(shopp, u);

		count = rejson.getList().size();

		String json = "{\"total\":\"" + count + "\",\"rows\":[";

		rejson = shoppingCartService.selectUserIDShoppingCartCouny(shopp, u);
		// 获取查询到的数据
		List<ShoppingCart> shoppingCartsList = rejson.getList();
		// 循环遍历查询到的数据
		for (int i = 0; i < shoppingCartsList.size(); i++) {
			// 取出数据
			ShoppingCart shoppingCart = shoppingCartsList.get(i);

			Goods g = new Goods();
			// 获取商品ID
			g.setId(shoppingCart.getGoodsId());
			// 查询商品图片
			ResJson imgJson = goodsImgService.selectGoodsImg(g);

			List<GoodsImg> imgList = imgJson.getList();

			shoppingCart.setImg(imgList.get(0).getName());

			// 购物车ID
			json += "{\"id\":\"" + shoppingCart.getId() + "\"" +
			// 用户ID
					",\"userid\":\"" + shoppingCart.getUserId() + "\"" +
					// 用户姓名
					",\"userName\":\"" + shoppingCart.getUserName() + "\"" +
					// 商品名称
					",\"productName\":\"" + shoppingCart.getGoodsName() + "\"" +
					// 商品图片
					",\"goodsImg\":\"" + shoppingCart.getImg() + "\"" +
					// 时间
					",\"creatime\":\"" + shoppingCart.getTimes() + "\"" +
					// 数量
					",\"quantity\":\"" + shoppingCart.getQuantity() + "\"" +
					// 单价
					",\"pric\":\"" + shoppingCart.getPrice() + "\"" +
					// 小计
					",\"totalPric\":\"" + shoppingCart.getTotalPrice() + "\"" +
					// 状态
					",\"situation\":\"" + shoppingCart.getSituation() + "\"},";

		}

		json = json.substring(0, json.length() - 1) + "]}";
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 购物车删除
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteShoppingCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ResJson rejson = null;

		// 存储向前台输出语句
		String json = "";
		// 存储添加或修改的结果
		ResJson resJson = null;
		// 获取请求的数据
		ShoppingCart deleteShoppin = new ShoppingCart();
		deleteShoppin.setId(request.getParameter("shoppid"));
		// 执行修改
		resJson = shoppingCartService.deleteShoppingCart(deleteShoppin);
		// 判断结果
		if (resJson.getSub()) {
			// 成功
			json = "{\"isSuccess\":\"true\",\"shopp\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
		} else {
			// 失败
			json = "{\"isSuccess\":\"false\",\"shopp\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
		}
		// 输出
		out.print(json);
		out.flush();
		out.close();
	}

	
	/**
	 * 购物车提交方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userShoppingCartSettlement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ResJson rejson = null;

		// 获取ID
		String shoppingCartID = request.getParameter("idList");
		// 分割数组 存入集合
		String idList[] = shoppingCartID.split(",");
		// 存储向前台输出语句
		String json = "";
		// 存储添加或修改的结果
		ResJson resJson = null;
		// 获取请求的数据
		// 根据ID 数组循环修改购物车属性
		for (int i = 0; i < idList.length; i++) {
			ShoppingCart settemeltShoppin = new ShoppingCart();
			settemeltShoppin.setId(idList[i]);
			// 执行修改
			resJson = shoppingCartService.shoppingCartSettlement(settemeltShoppin);
		}

		// 判断结果
		if (resJson.getSub()) {
			// 成功
			json = "{\"isSuccess\":\"true\",\"shopp\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
		} else {
			// 失败
			json = "{\"isSuccess\":\"false\",\"shopp\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
		}
		// 输出
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 结算页订单删除
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void removeShoppingCartOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ResJson rejson = null;

		// 存储向前台输出语句
		String json = "";
		// 存储添加或修改的结果
		ResJson resJson = null;
		// 获取请求的数据
		ShoppingCart deleteShoppin = new ShoppingCart();
		deleteShoppin.setId(request.getParameter("shoppid"));
		// 执行修改
		resJson = shoppingCartService.removeShoppingCartOrfers(deleteShoppin);
		// 判断结果
		if (resJson.getSub()) {
			// 成功
			json = "{\"isSuccess\":\"true\",\"shopp\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
		} else {
			// 失败
			json = "{\"isSuccess\":\"false\",\"shopp\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
		}
		// 输出
		out.print(json);
		out.flush();
		out.close();
	}
}
