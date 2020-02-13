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
            String goods_id=req.getParameter("goods_id");//商品ID
            int quantity=Integer.parseInt(req.getParameter("quantity"));//商品数量
            Tgoods goods= liuService.getGoods(goods_id);//商品ID，给了good

            TorderItem orderItem=new TorderItem();
            orderItem.setGoods(goods);//设置商品ID
            orderItem.setGoods_quantity(quantity);//设置商品数量

            HttpSession session=req.getSession();
            Cart cart =(Cart)session.getAttribute("cart");
            cart.addGoods(goods_id, orderItem);

            session.setAttribute("cart", cart);

            req.setAttribute("message", "操作成功");
            req.setAttribute("path", "site/cart/mycart.jsp");//添加购物车成功跳转到该页面

            String targetURL = "/common/success.jsp";
            dispatch(targetURL, req, res);//跳转到targetURL

        }
    }
}
