package com.example.demo.servlet;


import com.example.demo.dao.DaoFactory;
import com.example.demo.model.Island;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/islands"})
public class IslandListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // Requete a la base de données, traitements, calculs..
        List<Island> islandList = DaoFactory.getIslandDAO().findAll();

        // Insertion des données dans la requête
        // Rends l'information disponible dans la vue JSP
        request.setAttribute("islands", islandList);

        // Retourne la page HTML = réponse
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/islands.jsp");
        rd.forward(request, resp);
    }
}
