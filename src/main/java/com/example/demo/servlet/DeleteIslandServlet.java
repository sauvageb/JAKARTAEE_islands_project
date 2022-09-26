package com.example.demo.servlet;

import com.example.demo.dao.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(DeleteIslandServlet.URL)
public class DeleteIslandServlet extends HttpServlet {
    public static final String URL = "/delete-island";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idIslandStr = req.getParameter("idIsland");

        DaoFactory.getIslandDAO().delete(Long.parseLong(idIslandStr));

        resp.sendRedirect(req.getContextPath() + "/islands");
    }
}
