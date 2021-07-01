/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.Interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author jyoti
 */

public class LoginInterceptor extends HandlerInterceptorAdapter{
    

    
     @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception
     {
          HttpSession session = request.getSession(false);
          if (session== null)
          {
            response.sendRedirect("/TechWorldHustle/Welcome.jsp");
            return false;}
          
          else
          {
              if (session.getAttribute("login_session").equals(session))
                {return true;}
              else 
                {
                    response.sendRedirect("/TechWorldHustle/Welcome.jsp");
                    return false;}
         }
     }
    
}
