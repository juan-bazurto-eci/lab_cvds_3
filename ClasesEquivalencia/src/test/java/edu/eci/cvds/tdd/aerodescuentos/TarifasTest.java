package edu.eci.cvds.tdd.aerodescuentos;
import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;
import edu.eci.cvds.tdd.registry.RegisterResult;
import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {

    CalculadorDescuentos cd = new CalculadorDescuentos();

    @Test
    public void validarCalculoTarifaEdadSuperior() {
        double descuentoAplicado = cd.calculoTarifa(300000,12,70);
        double resultadoEsperado = 276000;
        Assert.assertEquals(resultadoEsperado, descuentoAplicado, 0);
    }

    @Test
    public void validarCalculoTarifaDiasAntelacion() {
        double descuentoAplicado = cd.calculoTarifa(1200000,21,20);
        double resultadoEsperado = 1020000;
        Assert.assertEquals(resultadoEsperado, descuentoAplicado, 0);
    }

    @Test
    public void validarCalculoTarifaMenorEdad() {
        double descuentoAplicado = cd.calculoTarifa(100000,15,13);
        double resultadoEsperado = 95000;
        Assert.assertEquals(resultadoEsperado, descuentoAplicado, 0);
    }

}
