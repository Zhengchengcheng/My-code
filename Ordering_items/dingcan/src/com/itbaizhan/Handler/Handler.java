package com.itbaizhan.Handler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: lcp
 * @Date: 2019/12/2 17:13
 */
public  abstract class Handler
{
    public ServletContext servletContext;

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    private Handler next;
    public void setNext(Handler next)
    {
        this.next=next;
    }
    public Handler getNext()
    {
        return next;
    }
    public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response)
    //跳转到下一界面
    {
        RequestDispatcher dispatch = servletContext.getRequestDispatcher(targetURI);
        try
        {
            dispatch.forward(request, response);
            return;
        }
        catch (ServletException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
    }
    //处理请求的方法
    public abstract void handleRequest(HttpServletRequest req, HttpServletResponse res, String oper) throws ServletException, IOException;
}
