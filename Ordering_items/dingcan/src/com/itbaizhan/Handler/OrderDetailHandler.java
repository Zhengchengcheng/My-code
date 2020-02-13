package com.itbaizhan.Handler;

import com.itbaizhan.service.liuService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: lcp
 * @Date: 2019/12/2 17:21
 */
public class OrderDetailHandler extends Handler {
    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res,String oper) throws ServletException, IOException {
        if("orderDetail".equalsIgnoreCase(oper)){
            String order_id=req.getParameter("order_id");
            System.out.println(order_id+"DD");//Êä³öorder_idDD
            req.setAttribute("orderItemList", liuService.orderItemList(order_id));
            req.getRequestDispatcher("site/order/orderDetail.jsp").forward(req, res);
        }
    }
}
