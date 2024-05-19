package ec.edu.epn.control;

import ec.edu.epn.modelo.entidad.Videojuego;
import ec.edu.epn.modelo.persistencia.VideojuegoDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SvBusquedaDesarrollador", value = "/SvBusquedaDesarrollador")
public class SvBusquedaDesarrollador extends HttpServlet {
    VideojuegoDAO videojuegoDAO = new VideojuegoDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String desarrollador = request.getParameter("desarrollador");

        List<Videojuego> videojuegos =  videojuegoDAO.getVideojuegoByDesarrollador(desarrollador);

        HttpSession session = request.getSession();

        session.setAttribute("videojuegos", videojuegos);

        response.sendRedirect("catalogoFiltrado.jsp");
    }
}
