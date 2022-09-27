package com.example.demo.servlet;

import com.example.demo.dao.DaoFactory;
import com.example.demo.model.Island;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(IslandDetailsServlet.URL)
public class IslandDetailsServlet extends HttpServlet {

    public static final String URL = "/details";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        long id = Long.parseLong(idStr);
        Optional<Island> islandOptional = DaoFactory.getIslandDAO().findById(id);
        req.setAttribute("island", islandOptional.get());
        req.getRequestDispatcher("/WEB-INF/detailIsland.jsp").forward(req, resp);
    }
}
