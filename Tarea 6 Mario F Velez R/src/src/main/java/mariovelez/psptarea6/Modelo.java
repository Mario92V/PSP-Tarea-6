package mariovelez.psptarea6;

/**
 *
 * @author Mario F. Vélez R.
 */
public class Modelo
{
    private double d = 0.5;
    private int contador = 10;
    double resultado = 0.0;
    
    /**
     * Método que calcula el valor W a partir de dos valores
     * 
     * @param x      Valor hasta el cual se quiere hallar el area bajo la curva
     * @param numSeg Número de segmentos en los que se divide la función
     * @return       Valor W para las siguientes ecuaciones
     */
    public double calcularW(double x, double numSeg)
    {
        double w = x/numSeg;
        return w;
    }
    
    /**
     * Método que calcula la función Gamma de un valor dado
     * 
     * @param valor Valor para el cual se desea calcula la función Gamma
     * @return      Valor de la función Gamma
     */
    public double funcionGamma(double valor)
    {
        double resultado = valor-1;
        if(resultado > 1)
        {
            resultado = resultado*funcionGamma(resultado);
        }
        else if(resultado == 0.5)
        {
            resultado = resultado*Math.sqrt(Math.PI);
        }
        return resultado;
    }
    
    /**
     * Método que calcula la distribución T para un valor dado con un dof dado
     * 
     * @param x   Valor para el cual se desea hallar la distribución T
     * @param dof Valor de los grados de libertad para el cálculo
     * @return    Valor de la distribución T
     */
    public double distribucionT(double x, double dof)
    {
        double resultado = (funcionGamma((dof+1)/2)/((Math.sqrt(dof*Math.PI))*funcionGamma(dof/2)))*(Math.pow(1+(Math.pow(x, 2)/dof), -(dof+1)/2));
        return resultado;
    }
    
    /**
     * Método que permite el cálculo de la sumatoria dado unos parametros
     * 
     * @param vInicial   Valor del que parte la sumatoria
     * @param vFinal     Valor en el que termina la sumatoria
     * @param incremento Valor del incremente para la sumatoria
     * @param constante  Valor que hace parte de la función en la sumatoria
     * @param w          Valor W hallado en el método calcularW
     * @param dof        Valor de grados de libertad para el método distribuciónT
     * @return           Valor de la sumatoria
     */
    public double sumatoria(int vInicial, int vFinal, int incremento, int constante, double w, double dof)
    {
        double resultado = 0.0;
        for(int i = vInicial; i < vFinal+1; i += incremento)
        {
            resultado = resultado + (constante*distribucionT(i*w, dof));
        }
        return resultado;
    }
    
    /**
     *  Método que permite calcular el valor de la integral
     * 
     * @param w      Valor W hallado en el método calcularW
     * @param x      Valor para el cual se debe hallar P
     * @param numSeg Valor del número de segmentos de la función
     * @param dof    Valor de grados de libertad
     * @param vFinal Valor para la sumatoria
     * @return       Valor de la integral o area bajo la curva
     */
    public double calcularP(double w, double x, double numSeg, double dof, int vFinal)
    {
        double p = (w/3)*(distribucionT(0, dof) + sumatoria(1, vFinal-1, 2, 4, w, dof) + sumatoria(2, vFinal-2, 2, 2, w, dof) + distribucionT(x, dof));
        return p;
    }
    
    /**
     * Método que permite verificar si el valor obtenido es valido
     * 
     * @param valor1 Valor obtenido para una cantidad de segmentos de la función
     * @param valor2 Valor obtenido para una cantidad de segmentos de la función
     * @return       Valor booleano de la comparación de los valores obtenidos
     */
    public boolean compararResultados(double valor1, double valor2)
    {
        boolean resultado = false;
        double e = 0.00001;
        if(Math.abs(valor1-valor2) < e)
        {
            resultado = true;
        }
        return resultado;
    }
    
    /**
     * Método que permite la lógica de control de cálculo de todo el programa
     * 
     * @param x         Valor inicial para el cálculo de la integral
     * @param numSeg    Valor del número de segmentos para el cálculo de la integral
     * @param dof       Valor de grados de libertad para el cálculo de la integral
     * @param pEsperado Valor del cálculo de la integral que se desea obtener
     */
    public void calculador(double x, double numSeg, double dof, double pEsperado)
    {
        resultado = x;
        double w = calcularW(x, numSeg);
        double p = calcularP(w, x, numSeg, dof, 10);
        if(compararResultados(p, pEsperado) == false)
            {
                if(p<pEsperado)
                    {
                       x = x+d;
                       contador = contador - 1;
                       if(contador == 0)
                        {
                            d = d/2;
                            contador = 10;
                        }
                       calculador(x, numSeg, dof, pEsperado);
                    }
                else if(p>pEsperado)
                    {
                        x=x-d;
                        contador = contador - 1;
                        if(contador == 0)
                        {
                            d = d/2;
                            contador = 10;
                        }
                        calculador(x, numSeg, dof, pEsperado);
                    }
            }
        contador = 10;
        d = 0.5;
    }
}