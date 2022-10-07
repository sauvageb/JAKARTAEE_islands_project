package com.example.demo.servlet.country;

import com.example.demo.dao.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/countries/delete")
public class DeleteCountryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idCountry");
        try {
            DaoFactory.getCountryDAO().delete(Long.parseLong(idStr));
        } catch (NumberFormatException e) {
            //TODO
        }
        resp.sendRedirect(req.getContextPath() + "/countries");
    }
}
