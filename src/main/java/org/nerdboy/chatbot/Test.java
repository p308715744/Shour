package org.nerdboy.chatbot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Admin on 2016/12/12.
 */
@WebServlet("/shour")
public class Test  extends HttpServlet {


    public static String property = "Shour.properties";
    private static Shour shour;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        shour = new Shour(property);
        String question=request.getParameter("question");
        String result=shour.response(question);
        response.setContentType("text/html; charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer=response.getWriter();
        writer.write(result);


    }

}
