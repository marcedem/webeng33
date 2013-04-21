/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Dice;
import beans.Car;
import beans.Field;
import beans.User;

import service.DiceService;
import service.FieldService;
import service.GameService;

/**
 *
 * @author edem
 */
@WebServlet(name = "GameServlet", urlPatterns = {"/GameServlet"})
public class GameServlet extends HttpServlet {

    public GameServlet() {
        super();
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GameServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GameServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }


        HttpSession session = request.getSession(true);
        GameService gameData = (GameService) session.getAttribute("gameData");
        if (gameData == null) {
            gameData = new GameService();
        }

        if (!gameData.isInitialized()) {
            // Set the Player
            ArrayList<User> users = new ArrayList<User>();
            User user1 = new User();
            user1.setId(1);
            user1.setName("Player");
            users.add(user1);
            User user2 = new User();
            user2.setId(2);
            user2.setName("Computer");
            users.add(user2);
            gameData.init(users);
        }

        if (request.getParameter("reset") != null) {
            gameData = new GameService();
        } else {
            // player's turn
            if (gameData.isPlayersTurn()) {
                gameData.rollPlayerDice();

                if (gameData.isPlayersTurn()) {
                    session.setAttribute("gameData", gameData);
                    response.sendRedirect("table.jsp");
                    return;
                }
            }

            // computer's turn
            if (!gameData.isPlayersTurn() && !gameData.isGameOver()) {
                gameData.rollComputerDice();

                if (!gameData.isPlayersTurn()) {
                    RequestDispatcher dispatcher = getServletContext()
                            .getRequestDispatcher("/GameServlet");
                    dispatcher.forward(request, response);
                    return;
                }
            }
        }
        session.setAttribute("gameData", gameData);
        response.sendRedirect("table.jsp");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}