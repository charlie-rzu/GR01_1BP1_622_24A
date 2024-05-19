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

@WebServlet(name = "SvBusquedaTitulo", value = "/SvBusquedaTitulo")
public class SvBusquedaTitulo extends HttpServlet {
    VideojuegoDAO videojuegoDAO = new VideojuegoDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tituloEntrante = request.getParameter("titulo");
        List<Videojuego> videojuegos =  videojuegoDAO.getVideojuegoByTitulo(tituloEntrante);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("videojuegos", videojuegos);
        response.sendRedirect("catalogoFiltrado.jsp");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }
}
