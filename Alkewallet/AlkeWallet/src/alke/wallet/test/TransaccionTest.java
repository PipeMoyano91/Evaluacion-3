package alke.wallet.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import alke.wallet.Transaccion;

public class TransaccionTest {

    @Test
    public void testConstructor() {
        Transaccion transaccion = new Transaccion(100.0, "Compra en línea");
        assertEquals(100.0, transaccion.getMonto(), 0.0);
        assertEquals("Compra en línea", transaccion.getTipo());
    }

    @Test
    public void testSettersAndGetters() {
        Transaccion transaccion = new Transaccion(100.0, "Compra en línea");
        transaccion.setMonto(200.0);
        transaccion.setTipo("Deposito");
        assertEquals(200.0, transaccion.getMonto(), 0.0);
        assertEquals("Deposito", transaccion.getTipo());
    }
}
