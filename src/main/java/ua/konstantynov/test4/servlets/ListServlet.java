package ua.konstantynov.test4.servlets;

import ua.konstantynov.test4.entities.Race;
import ua.konstantynov.test4.service.RacesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private static final RacesService RACES_SERVICE = new RacesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Race> raceList = RACES_SERVICE.getAll();
        req.setAttribute("raceList", raceList);
        getServletContext().getRequestDispatcher("/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String accept = req.getParameter("clear");
        if (accept.equals("Accept")) {
            RACES_SERVICE.deleteAll();
            getServletContext().getRequestDispatcher("/").include(req, resp);
        }
        resp.sendRedirect("/list");
    }
}