package com.example.practicemanagecustomer;

import java.io.*;

import com.example.practicemanagecustomer.model.Customer;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static com.example.practicemanagecustomer.service.CustomerServiceImpl.customers;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }

}