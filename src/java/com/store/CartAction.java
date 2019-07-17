/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store;

import com.exceptions.BookNotFoundException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Instructor
 */
public class CartAction implements Action {

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        String adding = req.getParameter("add");
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }
        if (adding.equalsIgnoreCase("true")) {
            this.addToCart(req, cart);
        } else {
            req.getSession().setAttribute("cart", cart);
        }

        return "/cart.jsp";
    }

    private void addToCart(HttpServletRequest req, Cart cart) {
        HashMap map = (HashMap) req.getSession().getServletContext().getAttribute("books");
        Integer id = Integer.parseInt(req.getParameter("id"));
        Book b = (Book) map.get(id);
        System.out.println(b.getId());
        System.out.println(b.getName());
        try {
            cart.addItem(b);
            req.getSession().setAttribute("cart", cart);
        } catch (BookNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
