// package com.app;

// import java.io.IOException;
// import java.io.PrintWriter;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class LoginServlet extends HttpServlet {

//     // predefined credentials
//     private final String USER = "admin";
//     private final String PASS = "1234";

//     @Override
//     protected void doPost(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {

//         response.setContentType("text/html");

//         String username = request.getParameter("username");
//         String password = request.getParameter("password");

//         PrintWriter out = response.getWriter();

//         if(USER.equals(username) && PASS.equals(password)) {
//             out.println("<h1>Login Successful 🎉</h1>");
//             out.println("<h2>Welcome " + username + "</h2>");
//         } else {
//             out.println("<h1 style='color:red;'>Invalid Username or Password ❌</h1>");
//             out.println("<a href='login.jsp'>Try Again</a>");
//         }
//     }
// }


package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    private final String USER = "admin";
    private final String PASS = "1234";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // -------- NAME VALIDATION --------
        String namePattern = "^[A-Z][a-zA-Z]{2,}$";

        if(name == null || !name.matches(namePattern)) {
            out.println("<h2 style='color:red;'>Invalid Name!</h2>");
            out.println("<p>Name must start with Capital letter and minimum 3 characters.</p>");
            out.println("<a href='login.jsp'>Go Back</a>");
            return;
        }

        // -------- PASSWORD VALIDATION --------
        String passPattern = "^(?=.*[A-Z])(?=.*[0-9])(?=[^@#$%&]*[@#$%&][^@#$%&]*$).{8,}$";

        if(password == null || !password.matches(passPattern)) {
            out.println("<h2 style='color:red;'>Invalid Password!</h2>");
            out.println("<p>Password Rules:</p>");
            out.println("<ul>");
            out.println("<li>Minimum 8 characters</li>");
            out.println("<li>At least 1 uppercase letter</li>");
            out.println("<li>At least 1 number</li>");
            out.println("<li>Exactly 1 special character (@ # $ % &)</li>");
            out.println("</ul>");
            out.println("<a href='login.jsp'>Try Again</a>");
            return;
        }

        // -------- LOGIN VALIDATION --------
        if(username.equals("admin") && password.equals("Admin@123")) {
            out.println("<h1>Login Successful 🎉</h1>");
            out.println("<h2>Welcome " + name + "</h2>");
        } else {
            out.println("<h2 style='color:red;'>Invalid Username or Password</h2>");
            out.println("<a href='login.jsp'>Try Again</a>");
        }
    }
}