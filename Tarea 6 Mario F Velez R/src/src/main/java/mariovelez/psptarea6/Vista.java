package mariovelez.psptarea6;

/**
 *
 * @author Mario F. Vélez R.
 */
public class Vista
{

    /**
     * Método que permite organizar los resultados obtenidos para visualizarlos en Heroku
     * 
     * @param x1 Resultado del primer cálculo
     * @param x2 Resultado del segundo cálculo
     * @param x3 Resultado del tercer cálculo
     * @return   Resultados organizados para mostrar en Heroku
     */
    public String mostrarResultados(double x1, double x2, double x3)
    {
        String resultado = "Pruebas: " + "<br/>" + "p = 0.20, dof = 6, valor esperado = 0.55338, valor obtenido = " + x1 + "<br/>" + "p = 0.45, dof = 15, valor esperado = 1.75305, valor obtenido = " + x2 + "<br/>" + "p = 0.495, dof = 4, valor esperado = 4.60409, valor obtenido = " + x3;
		return resultado;
    }
}