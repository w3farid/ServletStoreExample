/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Instructor
 */
public class StoreAction implements Action{

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        
        return "/main.jsp";
    }
    
}
