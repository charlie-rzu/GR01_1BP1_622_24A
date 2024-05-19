package ec.edu.epn.control;

import ec.edu.epn.modelo.entidad.Videojuego;
import ec.edu.epn.modelo.persistencia.VideojuegoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SvBusquedaRangoPrecio", value = "/SvBusquedaRangoPrecio")
public class SvBusquedaRangoPrecio extends HttpServlet {
    VideojuegoDAO videojuegoDAO = new VideojuegoDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String precioMinStr = request.getParameter("precio_min");
        String precioMaxStr = request.getParameter("precio_max");

        double precioMinimo = 0.0;
        double precioMaximo = 0.0;

        try {
            if (precioMinStr != null && !precioMinStr.isEmpty()) {
                precioMinimo = Double.parseDouble(precioMinStr);
            }
            if (precioMaxStr != null && !precioMaxStr.isEmpty()) {
                precioMaximo = Double.parseDouble(precioMaxStr);
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parámetros de precio inválidos.");
            return;
        }


        List<Videojuego> videojuegos = videojuegoDAO.getVideojuegosByRangoDePrecio(precioMinimo, precioMaximo);


        HttpSession session = request.getSession();

        session.setAttribute("videojuegos", videojuegos);

        response.sendRedirect("catalogoFiltrado.jsp");
    }
}
