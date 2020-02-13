package com.itbaizhan.Handler;

import com.itbaizhan.orm.Tgoods;
import com.itbaizhan.orm.TorderItem;
import com.itbaizhan.service.liuService;
import com.itbaizhan.util.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: lcp
 * @Date: 2019/12/2 17:20
 */
public class AddToCartHandler extends Handler {
    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res,String oper) {
        if ("addToCart".equalsIgnoreCase(oper)) {
            String goods_id=req.getParameter("goods_id");//��ƷID
            int quantity=Integer.parseInt(req.getParameter("quantity"));//��Ʒ����
            Tgoods goods= liuService.getGoods(goods_id);//��ƷID������good

            TorderItem orderItem=new TorderItem();
            orderItem.setGoods(goods);//������ƷID
            orderItem.setGoods_quantity(quantity);//������Ʒ����

            HttpSession session=req.getSession();
            Cart cart =(Cart)session.getAttribute("cart");
            cart.addGoods(goods_id, orderItem);

            session.setAttribute("cart", cart);

            req.setAttribute("message", "�����ɹ�");
            req.setAttribute("path", "site/cart/mycart.jsp");//��ӹ��ﳵ�ɹ���ת����ҳ��

            String targetURL = "/common/success.jsp";
            dispatch(targetURL, req, res);//��ת��targetURL

        }
    }
}
