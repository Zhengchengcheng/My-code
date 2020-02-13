package com.itbaizhan.Handler;

import com.itbaizhan.orm.Tuser;
import com.itbaizhan.service.liuService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: lcp
 * @Date: 2019/12/2 17:21
 */
public class MyorderHandler extends Handler {
    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse res,String oper) throws ServletException, IOException {
        if("myorder".equalsIgnoreCase(oper)){


        HttpSession session=req.getSession();
        Tuser user=(Tuser)session.getAttribute("user");

        req.setAttribute("orderList", liuService.orderList(user.getId()));//…Ë÷√orderListµƒ Ù–‘
        req.getRequestDispatcher("site/order/myorder.jsp").forward(req, res);
        }
    }
}
