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

@WebServlet("/race/*")
public class RaceServlet extends HttpServlet {
    private static final RacesService RACES_SERVICE = new RacesService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        if (req.getRequestURI().equals("/race/start")) {
            getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
        } else {
            printRaceInfo(req.getPathInfo(), req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        printRaceInfo(req.getParameter("id"), req, resp);
    }

    private void printRaceInfo(String raceID, HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        Race race;
        try {
            long id = Long.parseLong(raceID.replaceAll("/", ""));
            race = RACES_SERVICE.get(id);
            req.setAttribute("race", race);
            getServletContext().getRequestDispatcher("/race.jsp").include(req, resp);

        } catch (NumberFormatException | NullPointerException | ServletException e) {
            resp.setContentType("text/html");
            PrintWriter responseBody = resp.getWriter();
            responseBody.println("<br><br><h3 style=\"text-align: center; color: #FF0000;\">RACE ID NOT FOUND!</h3>");
            getServletContext().getRequestDispatcher("/").include(req, resp);
        }
    }
}
