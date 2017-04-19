package mariovelez.psptarea6;

import static spark.Spark.*;
/**
 *
 * @author Mario F. Vélez R.
 */
public class Controlador
{
    /**
     * Método main que controla la ejecución de las otras clases y envia el resultado a Heroku
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        
        get("/", (request, response) -> {
        Vista controladorVista = new Vista();
        Modelo controladorModelo = new Modelo();
        controladorModelo.calculador(1, 10, 6, 0.20);
        double x1 = controladorModelo.resultado;
        controladorModelo.resultado = 0;
        controladorModelo.calculador(1, 10, 15, 0.45);
        double x2 = controladorModelo.resultado;
        controladorModelo.resultado = 0;
        controladorModelo.calculador(1, 10, 4, 0.495);
        double x3 = controladorModelo.resultado;
        controladorModelo.resultado = 0;
        return controladorVista.mostrarResultados(x1, x2, x3);
    });
    }
}