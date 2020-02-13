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

        String songhuodizhi=req.getParameter("songhuodizhi");//�õ��ͻ���ַ
        String fukuanfangshi=req.getParameter("fukuanfangshi");//�õ����ʽ

        HttpSession session=req.getSession();
        Cart cart =(Cart)session.getAttribute("cart");
        Tuser user=(Tuser)session.getAttribute("user");

        Torder order=new Torder();

        order.setId(String.valueOf(new Date().getTime()));//���ö���ID����ʱ��ĸ�ʽ
        order.setBianhao(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));//���ö�����ţ���ʽΪyyyyMMddhhmmss
        order.setShijian(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));//�����µ�ʱ�䣬��ʽΪyyyy-MM-dd hh:mm:ss
        order.setZhuangtai("no");

        order.setHuifu("");

        order.setSonghuodizhi(songhuodizhi);
        order.setFukuanfangshi(fukuanfangshi);
        order.setJine(cart.getTotalPrice());//�����ܽ��
        order.setUser_id(user.getId());

        liuService.saveOrder(order);

        for (Iterator it = cart.getItems().values().iterator(); it.hasNext();)
        //��������������it��ֵΪ��Ʒ������ֵ��������������滹�ж�����ִ��ѭ��
        {

            TorderItem orderItem = (TorderItem) it.next();//��ȡ��һ������ת����TorderItem���󣬸���TorderItem����orderItem

            String id=String.valueOf(new Date().getTime());//�õ����ID
            String order_id=order.getId();//�õ�����ID
            String goods_id=orderItem.getGoods().getId();
            int goods_quantity=orderItem.getGoods_quantity();
            liuService.saveOrderItem(id, order_id, goods_id, goods_quantity);//����id, order_id, goods_id, goods_quantity

        }

        cart.getItems().clear(); //��չ��ﳵ
        session.setAttribute("cart", cart);

        req.setAttribute("order", order);
        req.getRequestDispatcher("site/order/orderSubmit.jsp").forward(req, res);//��ת���������
       }
    }
}
