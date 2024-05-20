package ec.edu.epn.modelo.test;

import ec.edu.epn.modelo.entidad.Videojuego;
import ec.edu.epn.modelo.persistencia.VideojuegoDAO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

//Cual usamos el org.junit...
//o
//org.junit.jupiter.api

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VideojuegoTest {

public static VideojuegoDAO videojuegoDAO;
public static Videojuego videojuego1 = new Videojuego();
public static Videojuego videojuego2 = new Videojuego();
   @BeforeClass
    public static void setUp() {
        String tituloEntrante = "GTA V";
        String tituloEntrante2 = "The Witcher";
        Double precioVideojuego = 20.00;
        Double precioVideojuego2 = 30.00;
        String desarrolladorVideojuego = "Jorman Chuquer";
        String desarrolladorVideojuego2 = "Cristian Sangucho";
        videojuegoDAO = Mockito.mock(VideojuegoDAO.class);
        videojuego1.setTitulo(tituloEntrante);
        videojuego2.setTitulo(tituloEntrante2);
        videojuego1.setPrecio(precioVideojuego);
        videojuego2.setPrecio(precioVideojuego2);
        videojuego1.setNombreDeDesarrollador(desarrolladorVideojuego);
        videojuego2.setNombreDeDesarrollador(desarrolladorVideojuego2);
    }

    @Test
    public void testWithMockBuscarVideojuegoPorTitulo_then_obtener_coincidencias() {
        // Crear una lista de videojuegos para simular lo que retornaría la base de datos
        String tituloEntrante = "GTA V";
        List<Videojuego> videojuegos = new ArrayList<>();
        videojuegos.add(videojuego1);
        // Definir el comportamiento del mock
        Mockito.when(videojuegoDAO.getVideojuegoByTitulo(tituloEntrante)).thenReturn(videojuegos);
        // Llamada del metodo que vamos a probar
        List<Videojuego> resultado = videojuegoDAO.getVideojuegoByTitulo(tituloEntrante);
        assertNotNull(resultado);
        // Verificar que el método getVideojuegoByTitulo fue llamado con los argumentos correctos
        Mockito.verify(videojuegoDAO).getVideojuegoByTitulo(tituloEntrante);
    }
    @Test
    public void testWithMockBuscarVideojuegoPorTitulo_then_no_obtener_ninguna_coincidencia(){
       String tituloEntrante = "Minecraft";
        //no se obtiene ninguna coincidencia

        Mockito.when(videojuegoDAO.getVideojuegoByTitulo(tituloEntrante)).thenReturn(new ArrayList<>());
        List<Videojuego> resultado = videojuegoDAO.getVideojuegoByTitulo(tituloEntrante);
        assertTrue(resultado.isEmpty());

    }
    @Test
    public void testWithMockBuscarVideojuegoPorRangoDePrecio_then_obtenerCoincidencias(){
        Double precioMinimo = 15.00;
        Double precioMaximo = 25.00;
        List<Videojuego> videojuegos = new ArrayList<>();
        videojuegos.add(videojuego1);
        Mockito.when(videojuegoDAO.getVideojuegosByRangoDePrecio(precioMinimo, precioMaximo)).thenReturn(videojuegos);
        List<Videojuego> resultados = videojuegoDAO.getVideojuegosByRangoDePrecio(precioMinimo, precioMaximo);
        assertNotNull(resultados);

    }
    @Test
    public void testWithMockBuscarVideojuegoPorRangoDePrecio_then_no_obtener_coincidencias(){
       Double precioMinimo = 155.00;
       Double precioMaximo = 205.00;
       Mockito.when(videojuegoDAO.getVideojuegosByRangoDePrecio(precioMinimo, precioMaximo)).thenReturn(new ArrayList<>());
       List<Videojuego> resultado = videojuegoDAO.getVideojuegosByRangoDePrecio(precioMinimo, precioMaximo);
       assertTrue(resultado.isEmpty());
    }
    @Test
    public void testWithMockBuscarVideojuegoPorDesarrollador_then_obtenerCoincidencias() {
        // Crear una lista de videojuegos para simular lo que retornaría la base de datos
        String nombreDesarrollador = "Cristian Sangucho";
        List<Videojuego> videojuegos = new ArrayList<>();
        videojuegos.add(videojuego2);
        // Definir el comportamiento del mock
        Mockito.when(videojuegoDAO.getVideojuegoByDesarrollador(nombreDesarrollador)).thenReturn(videojuegos);
        // Llamada del metodo que vamos a probar
        List<Videojuego> resultado = videojuegoDAO.getVideojuegoByTitulo(nombreDesarrollador);
        assertNotNull(resultado);
        // Verificar que el método getVideojuegoByTitulo fue llamado con los argumentos correctos
        Mockito.verify(videojuegoDAO).getVideojuegoByTitulo(nombreDesarrollador);
    }
    @Test
    public void testWithMockBuscarVideojuegoPorDesarrollador_then_no_obtener_ninguna_coincidencia(){
       String nombreDesarrollador = "Cristian Zambrano";
       //no se obtiene ninguna coincidencia
       Mockito.when(videojuegoDAO.getVideojuegoByDesarrollador(nombreDesarrollador)).thenReturn(new ArrayList<>());
       List<Videojuego> resultado = videojuegoDAO.getVideojuegoByDesarrollador(nombreDesarrollador);
       assertTrue(resultado.isEmpty());
    }

}
