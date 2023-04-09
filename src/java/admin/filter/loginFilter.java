/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author princecalvinsagatwa
 */
public class loginFilter implements Filter {
    
    private String filterName;
    
    @Override
    public void init(FilterConfig config) throws ServletException {
        filterName = config.getFilterName();
        System.out.println("Initializing filter: " + filterName);
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpSession sess=((HttpServletRequest) request).getSession(true);
        if(sess.getAttribute("userId") !=null){
            System.out.println("SESS: "+ sess.getAttribute("userId"));
            if(!((HttpServletRequest) request).getRequestURI().contains("admission")){
                System.out.println("PATH: "+ ((HttpServletRequest) request).getRequestURI());
                ((HttpServletResponse) response).sendRedirect("admission.html");
            }
            chain.doFilter(request, response);
        }else{
            System.out.println("NOT SIGNED IN ");
            if(((HttpServletRequest) request).getRequestURI().contains("admission")){
                System.out.println("UNAUTHORIZED ");
                ((HttpServletResponse) response).sendRedirect("LoginAdmission_EN.html");
            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {   
        
    }

    
    
}
