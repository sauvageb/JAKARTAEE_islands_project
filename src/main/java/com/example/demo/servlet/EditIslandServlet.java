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

@WebServlet("/edit")
public class EditIslandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        Optional<Island> island = DaoFactory.getIslandDAO().findById(Long.parseLong(idStr));
        if (island.isPresent()) {
            req.setAttribute("island", island.get());
            req.getRequestDispatcher("/WEB-INF/updateIslandForm.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/islands");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idIsland");
        long id = Long.parseLong(idStr);

        String name = req.getParameter("name");
        String pictureUrl = req.getParameter("pictureUrl");
        String surface = req.getParameter("surface");
        String inhabitants = req.getParameter("inhabitants");
        String latitude = req.getParameter("latitude");
        String longitude = req.getParameter("longitude");
        String country = req.getParameter("country");

        DaoFactory.getIslandDAO().edit(new Island(
                id,
                name,
                pictureUrl,
                Double.parseDouble(surface),
                Long.parseLong(inhabitants),
                Double.parseDouble(latitude),
                Double.parseDouble(longitude),
                country));

        resp.sendRedirect(req.getContextPath() + "/islands");
    }
}







