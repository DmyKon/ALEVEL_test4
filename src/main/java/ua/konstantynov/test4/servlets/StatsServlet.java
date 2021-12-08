package ua.konstantynov.test4.servlets;

import ua.konstantynov.test4.entities.Race;
import ua.konstantynov.test4.service.RacesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/stats")
public class StatsServlet extends HttpServlet {
    private static final RacesService RACES_SERVICE = new RacesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("racesCount", RACES_SERVICE.getCount());
        getServletContext().getRequestDispatcher("/stats.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int number = Integer.parseInt(req.getParameter("number"));
        int count = Integer.parseInt(req.getParameter("count"));
        try {
            Race race = RACES_SERVICE.startRace(count, number);
            RACES_SERVICE.save(race);
            req.setAttribute("raceId", race.getIdentifier());
            req.setAttribute("racesCount", RACES_SERVICE.getCount());
            req.setAttribute("horsePlace", race.getHorses().get(number - 1).getPlace());
            getServletContext().getRequestDispatcher("/stats.jsp").include(req, resp);
        } catch (IllegalArgumentException e) {
            resp.setContentType("text/html");
            PrintWriter responseBody = resp.getWriter();
            responseBody.println("<br><br><h3 style=\"text-align: center; color: #FF0000;\">" +
                    e.getMessage() + "</h3>");
            getServletContext().getRequestDispatcher("/").include(req, resp);
        }
    }
}
