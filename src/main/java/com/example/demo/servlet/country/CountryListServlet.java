package com.example.demo.servlet.country;

import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.entity.Country;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/countries")
public class CountryListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Country> countryList = DaoFactory.getCountryDAO().findAll();
        req.setAttribute("countries", countryList);
        req.getRequestDispatcher("/WEB-INF/countryList.jsp").forward(req, resp);
    }
}
