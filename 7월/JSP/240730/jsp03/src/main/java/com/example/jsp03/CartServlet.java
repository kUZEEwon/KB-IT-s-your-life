package com.example.jsp03;

import com.example.jsp03.cart.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart"); // 기존의 카트 가지고 오기

        if (cart == null) {
            // 카트가 없다면 만들기
            cart = new ArrayList<>();   // 장바구니
          //  session.setAttribute("cart", cart);
        }

        String itemName = request.getParameter("itemName");
        double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));

        Item item = new Item(itemName, itemPrice);
        cart.add(item);


        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
    }
}

