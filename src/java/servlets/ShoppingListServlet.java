/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 838771
 */
@WebServlet(name = "ShoppingListServlet", urlPatterns = {"/ShoppingListServlet"})
public class ShoppingListServlet extends HttpServlet {

   ArrayList<String> list = new ArrayList<>();
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if(action != null && action.equals("logout")){
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/ShoppingList");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        
        
        if(action != null && !action.isEmpty()){
            if(action.equals("register")){
                session.setAttribute("username", request.getParameter("user"));
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
            else if(action.equals("add")){
                
                list.add(request.getParameter("addItem"));
                
                session.setAttribute("list", list);
                
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                
            }
            else if(action.equals("delete")){
                String toDelete = request.getParameter("itemRadio");
                if(toDelete == null || toDelete.equals("")){
                 getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);  
                 return;
                }
                int index = list.indexOf(toDelete);
                if(index > -1){
                    list.remove(index);
                    
                    session.setAttribute("list", list);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response); 
                
                
                }
            }
        }
    }

   

}
