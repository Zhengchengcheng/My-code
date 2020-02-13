package com.itbaizhan.Handler;

import com.itbaizhan.orm.Torder;
import com.itbaizhan.orm.TorderItem;
import com.itbaizhan.orm.Tuser;
import com.itbaizhan.service.liuService;
import com.itbaizhan.util.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * @Author: lcp
 * @Date: 2019/12/2 17:20
 */
public class OrderSubmitHandler extends Handler {
    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res,String oper) throws ServletException, IOException {

       if("orderSubmit".equalsIgnoreCase(oper)){

        String songhuodizhi=req.getParameter("songhuodizhi");//得到送货地址
        String fukuanfangshi=req.getParameter("fukuanfangshi");//得到付款方式

        HttpSession session=req.getSession();
        Cart cart =(Cart)session.getAttribute("cart");
        Tuser user=(Tuser)session.getAttribute("user");

        Torder order=new Torder();

        order.setId(String.valueOf(new Date().getTime()));//设置订单ID，以时间的格式
        order.setBianhao(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));//设置订单编号，格式为yyyyMMddhhmmss
        order.setShijian(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));//设置下单时间，格式为yyyy-MM-dd hh:mm:ss
        order.setZhuangtai("no");

        order.setHuifu("");

        order.setSonghuodizhi(songhuodizhi);
        order.setFukuanfangshi(fukuanfangshi);
        order.setJine(cart.getTotalPrice());//设置总金额
        order.setUser_id(user.getId());

        liuService.saveOrder(order);

        for (Iterator it = cart.getItems().values().iterator(); it.hasNext();)
        //创建迭代器对象it，值为商品数量的值，如果迭代器后面还有东西，执行循环
        {

            TorderItem orderItem = (TorderItem) it.next();//获取下一个对象，转换成TorderItem对象，赋予TorderItem对象orderItem

            String id=String.valueOf(new Date().getTime());//得到编号ID
            String order_id=order.getId();//得到订单ID
            String goods_id=orderItem.getGoods().getId();
            int goods_quantity=orderItem.getGoods_quantity();
            liuService.saveOrderItem(id, order_id, goods_id, goods_quantity);//保存id, order_id, goods_id, goods_quantity

        }

        cart.getItems().clear(); //清空购物车
        session.setAttribute("cart", cart);

        req.setAttribute("order", order);
        req.getRequestDispatcher("site/order/orderSubmit.jsp").forward(req, res);//跳转到这个界面
       }
    }
}
