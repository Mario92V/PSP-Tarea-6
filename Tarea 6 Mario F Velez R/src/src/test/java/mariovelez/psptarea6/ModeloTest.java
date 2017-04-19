/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariovelez.psptarea6;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class ModeloTest {
    
    public ModeloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcularW method, of class Modelo.
     */
    @Test
    public void testCalcularW() {
        System.out.println("calcularW");
        double x = 1.1;
        double numSeg = 10;
        Modelo instance = new Modelo();
        double expResult = 0.11;
        double result = instance.calcularW(x, numSeg);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of funcionGamma method, of class Modelo.
     */
    @Test
    public void testFuncionGamma() {
        System.out.println("funcionGamma");
        double valor = 4.5;
        Modelo instance = new Modelo();
        double expResult = 11.63173;
        double result = instance.funcionGamma(valor);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of distribucionT method, of class Modelo.
     */
    @Test
    public void testDistribucionT() {
        System.out.println("distribucionT");
        double x = 1.1;
        double dof = 9;
        Modelo instance = new Modelo();
        double expResult = 0.20652;
        double result = instance.distribucionT(x, dof);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of sumatoria method, of class Modelo.
     */
    @Test
    public void testSumatoria() {
        System.out.println("sumatoria");
        int vInicial = 1;
        int vFinal = 9;
        int incremento = 2;
        int constante = 4;
        double w = 0.11;
        double dof = 9;
        Modelo instance = new Modelo();
        double expResult = 6.37287849;
        double result = instance.sumatoria(vInicial, vFinal, incremento, constante, w, dof);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of calcularP method, of class Modelo.
     */
    @Test
    public void testCalcularP() {
        System.out.println("calcularP");
        double w = 0.11;
        double x = 1.1;
        double numSeg = 10;
        double dof = 9;
        int vFinal = 10;
        Modelo instance = new Modelo();
        double expResult = 0.3500589;
        double result = instance.calcularP(w, x, numSeg, dof, vFinal);
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of compararResultados method, of class Modelo.
     */
    @Test
    public void testCompararResultados() {
        System.out.println("compararResultados");
        double valor1 = 0.3500589;
        double valor2 = 0.35005864;
        Modelo instance = new Modelo();
        boolean expResult = true;
        boolean result = instance.compararResultados(valor1, valor2);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculador method, of class Modelo.
     */
    @Test
    public void testCalculador() {
        System.out.println("calculador");
        double x = 1.0;
        double numSeg = 10.0;
        double dof = 15.0;
        double pEsperado = 0.45;
        Modelo instance = new Modelo();
        instance.calculador(x, numSeg, dof, pEsperado);
    }
    
}
