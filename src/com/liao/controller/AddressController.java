package com.liao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liao.entity.Address;
import com.liao.entity.Goods;
import com.liao.entity.GoodsImg;
import com.liao.entity.ShoppingCart;
import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.AddressService;
import com.liao.util.ResJson;

/**
 * 地址操作类
 *
 * @author soft01
 */
@SuppressWarnings("all")
public class AddressController {

    private AddressService addressService = (AddressService) ObjectFactory.getBean("AddressService");


    /**
     * 地址分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void AddressSelectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ResJson rejson = null;

        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));

        // 获取查询参数
        Address address = new Address();
        // 用户ID
        address.setUserid(request.getParameter("userId"));
        // 用户姓名
        address.setName(request.getParameter("userName"));
        // 用户地址
        address.setUseraddress(request.getParameter("userAddress"));
        // 手机
        address.setPhone(request.getParameter("phone"));
        int count = 0;

        count = addressService.selectAddressouny(address, null);


        String json = "{\"total\":\"" + count + "\",\"rows\":[";

        rejson = addressService.selectAddressByLimit(pageNum, pageSize, address, null);
        // 获取查询到的数据
        List<Address> addressesList = rejson.getList();
        // 循环遍历查询到的数据
        for (int i = 0; i < addressesList.size(); i++) {
            // 取出数据
            Address a = addressesList.get(i);
            // 地址ID
            json += "{\"id\":\"" + a.getId() + "\"" +
                    // 用户ID
                    ",\"userid\":\"" + a.getUserid() + "\"" +
                    // 用户姓名
                    ",\"userName\":\"" + a.getName() + "\"" +
                    // 用户地址
                    ",\"userAddress\":\"" + a.getUseraddress() + "\"" +
                    // 手机
                    ",\"phone\":\"" + a.getPhone() + "\"" +
                    // 备注
                    ",\"Remarks\":\"" + a.getRemarks() + "\"" +
                    //	状态
                    ",\"situation\":\"" + a.getSituation() + "\"},";

        }

        json = json.substring(0, json.length() - 1) + "]}";
        out.print(json);
        out.flush();
        out.close();
    }
    
    /**
     * 查询用户所有地址
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectUserAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ResJson rejson = null;
        // 获取当前登录的用户
        HttpSession s = request.getSession();

        User u = (User) s.getAttribute("user");
        // 获取查询参数
        Address address = new Address();
        // 状态
        address.setSituation(request.getParameter("situation"));
        
        int count = 10;

        rejson = addressService.selectUserAddressouny(address, u);
        
        count = rejson.getList().size();

        String json = "{\"total\":\"" + count + "\",\"rows\":[";

        rejson = addressService.selectUserAddressouny(address, u);
        // 获取查询到的数据
        List<Address> addressesList = rejson.getList();
        // 循环遍历查询到的数据
        for (int i = 0; i < addressesList.size(); i++) {
            // 取出数据
            Address a = addressesList.get(i);
            // 地址ID
            json += "{\"id\":\"" + a.getId() + "\"" +
                    // 用户ID
                    ",\"userid\":\"" + a.getUserid() + "\"" +
                    // 用户姓名
                    ",\"userName\":\"" + a.getName() + "\"" +
                    // 用户地址
                    ",\"userAddress\":\"" + a.getUseraddress() + "\"" +
                    // 手机
                    ",\"phone\":\"" + a.getPhone() + "\"" +
                    // 备注
                    ",\"Remarks\":\"" + a.getRemarks() + "\"" +
                    //	状态
                    ",\"situation\":\"" + a.getSituation() + "\"},";

        }

        json = json.substring(0, json.length() - 1) + "]}";
        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * 地址添加
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addressAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取当前登录的用户
        HttpSession s = request.getSession();

        User u = (User) s.getAttribute("user");
//		获取姓名
        String name = request.getParameter("addName");
//		获取电话
        String phone = request.getParameter("addPhone");
//		获取地址
        String addrss = request.getParameter("address");
        Address a = new Address();
//		姓名
        a.setName(name);
//		电话
        a.setPhone(phone);
//		地址
        a.setUseraddress(addrss);
//        备注
        a.setRemarks("无");
//        状态
        a.setSituation("存在");

        String json = "";
        ResJson resJson = addressService.addAddress(a,u);

        if (resJson.getSub()) {
            // 成功
            json = "{\"isSuccess\":\"true\",\"user\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        } else {
            //失败
            json = "{\"isSuccess\":\"false\",\"user\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        }

        out.print(json);
        out.flush();
        out.close();
    }


    /**
     * 用户地址删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void userAddressDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
//		获取ID
        String id = request.getParameter("id");
//		获取等级
        String situation = request.getParameter("param");
        Address a = new Address();
//		ID
        a.setId(id);
//		等级
        a.setSituation(situation);

        String json = "";
        ResJson resJson = addressService.deleAddress(a);

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
