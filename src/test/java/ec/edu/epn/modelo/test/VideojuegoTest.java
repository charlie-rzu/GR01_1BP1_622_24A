package ec.edu.epn.modelo.test;

import ec.edu.epn.modelo.entidad.Videojuego;
import ec.edu.epn.modelo.persistencia.VideojuegoDAO;
import ec.edu.epn.modelo.services.BaseDeDatos;
import org.junit.BeforeClass;
import org.junit.Test;

//Cual usamos el org.junit...
//o
//org.junit.jupiter.api

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VideojuegoTest {
    private static VideojuegoDAO videojuegoDAO;

    @BeforeClass
    public static void setUp() {
        videojuegoDAO = new VideojuegoDAO();
        Videojuego videojuego = new Videojuego();
        videojuego.setTitulo("GTA V");
        videojuego.setNombreDeDesarrollador("Jorman Chuquer");
        videojuego.setPrecio(20);
        BaseDeDatos.persistirObjeto(videojuego);

    }

    @Test
    public void testBuscarVideojuegoPorTitulo() {
        assertNotNull(videojuegoDAO.getVideojuegoByTitulo("GTA V"));
    }
/*
    @Test
    public void testBuscarVideojuegoPorRangoDePrecio() {
        assertNotNull(videojuegoDAO.getVideojuegoByRangoDePrecio(10.00, 20.00));
    }

    @Test
    public void testBuscarVideojuegoPorDesarrollador() {
        assertNotNull(videojuegoDAO.getVideojuegoByDesarrollador("Jorman Chuquer"));
    }

    @Test
    public void testWithMockBuscarVideojuegoPorTitulo() {
        int idVideojuego = 1;
        String tituloEntrante = "GTA V";
        Double precioVideojuego = 20.00;
        String desarrolladorVideojuego = "Jorman Chuquer";

        VideojuegoDAO videojuegoDAO = Mockito.mock(VideojuegoDAO.class);

        // Definir el comportamiento del mock
        Mockito.when(videojuegoDAO.getVideojuegoByTitulo(tituloEntrante)).thenReturn(new Videojuego(idVideojuego,tituloEntrante,precioVideojuego, desarrolladorVideojuego));

        // Llamada del metodo que vamos a probar
        // Verificar el resultado
        assertNotNull(videojuegoDAO.getVideojuegoByTitulo(tituloEntrante));

        // Verificar que el método getVideojuegoByTitulo fue llamado con los argumentos correctos
        Mockito.verify(videojuegoDAO).getVideojuegoByTitulo(tituloEntrante);
    }

    @Test
    public void testWithMockBuscarVideojuegoPorDesarrollador() {
        int idVideojuego = 1;
        String tituloVideojuego = "GTA V";
        Double precioVideojuego = 20.00;
        String desarrolladorEntrante = "Jorman Chuquer";

        VideojuegoDAO videojuegoDAO = Mockito.mock(VideojuegoDAO.class);

        // Definir el comportamiento del mock
        Mockito.when(videojuegoDAO.getVideojuegoByDesarrollador(desarrolladorEntrante)).thenReturn(new Videojuego(idVideojuego,tituloVideojuego,precioVideojuego, desarrolladorEntrante));

        // Llamada del metodo que vamos a probar
        // Verificar el resultado
        assertNotNull(videojuegoDAO.getVideojuegoByDesarrollador(desarrolladorEntrante));

        // Verificar que el método getVideojuegoByTitulo fue llamado con los argumentos correctos
        Mockito.verify(videojuegoDAO).getVideojuegoByDesarrollador(desarrolladorEntrante);
    }

    @AfterClass
    public static void tearDown() {
        if (userDAO != null) {
            userDAO.close();
        }
    }*/
}
