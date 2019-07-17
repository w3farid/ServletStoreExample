/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Instructor
 */
public class FrontController extends HttpServlet {

    @Override
    public void init() throws ServletException {

        HashMap map = new HashMap();
        Book book = new Book();
        book.setId(1);
        book.setName("Pro JSP");
        book.setPrice(500.0f);

        Book book1 = new Book();
        book1.setId(2);
        book1.setName("Pro JSP 2");
        book1.setPrice(501.0f);

        Book book3 = new Book();
        book3.setId(3);
        book3.setName("JavaScript");
        book3.setPrice(501.0f);

        map.put(1, book);
        map.put(2, book1);
        map.put(3, book3);
        getServletContext().setAttribute("books", map);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getPathInfo().substring(1);
        System.out.println(name);
        String viewName = "/error.jsp";
        try {
            name = "com.store." + name;
            Class c = getClass().getClassLoader().loadClass(name);
            Action action = (Action) c.newInstance();
            viewName = action.process(req, resp);

        } catch (ClassNotFoundException e) {

        } catch (InstantiationException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewName);
        dispatcher.forward(req, resp);

    }

}
