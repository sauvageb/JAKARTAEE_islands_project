package com.example.demo.servlet.country;

import com.example.demo.dao.CountryDAO;
import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.entity.Country;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@WebServlet("/countries/edit")
public class EditCountryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        try {
            long id = Long.parseLong(idStr);
            Optional<Country> optCountry = DaoFactory.getCountryDAO().findById(id);
            req.setAttribute("country", optCountry.get());
        } catch (NumberFormatException | NoSuchElementException e) {
            req.setAttribute("country_not_found", true);
        }
        req.getRequestDispatcher("/WEB-INF/updateCountryForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idCountry");
        try {
            long id = Long.parseLong(idStr);
            String name = req.getParameter("name");

            CountryDAO dao = DaoFactory.getCountryDAO();
            Optional<Country> optCountry = dao.findById(id);
            Country country = optCountry.get();
            country.setName(name);
            dao.edit(country);

            resp.sendRedirect(req.getContextPath() + "/countries");

        } catch (NumberFormatException | NoSuchElementException e) {
            req.setAttribute("country_not_found", true);
            req.getRequestDispatcher("/WEB-INF/updateCountryForm.jsp").forward(req, resp);
        }
    }
}
