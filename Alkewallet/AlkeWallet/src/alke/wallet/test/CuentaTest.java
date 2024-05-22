package alke.wallet.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import alke.wallet.Cuenta;
import alke.wallet.SaldoInsuficienteException;
import alke.wallet.Transaccion;

public class CuentaTest {

    @Test
    public void testConstructor() {
        Cuenta cuenta = new Cuenta(1001, 5000.0, "USD");
        assertEquals(1001, cuenta.getNumero());
        assertEquals(5000.0, cuenta.getSaldo(), 0.0);
        assertEquals("USD", cuenta.getTipoMoneda());
    }

    @Test
    public void testDepositar() {
        Cuenta cuenta = new Cuenta(1001, 5000.0, "USD");
        cuenta.depositar(1000.0);
        assertEquals(6000.0, cuenta.getSaldo(), 0.0);
    }

    @Test
    public void testRetirar() {
        Cuenta cuenta = new Cuenta(1001, 5000.0, "USD");
        try {
            cuenta.retirar(2000.0);
        } catch (SaldoInsuficienteException e) {
            // No debería lanzarse esta excepción
        }
        assertEquals(3000.0, cuenta.getSaldo(), 0.0);
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void testRetirarFondosInsuficientes() throws SaldoInsuficienteException {
        Cuenta cuenta = new Cuenta(1001, 500.0, "USD");
        cuenta.retirar(1000.0);
    }

    @Test
    public void testConvertirSaldo() {
        Cuenta cuenta = new Cuenta(1001, 1000.0, "USD");
        cuenta.convertirSaldo("EUR", 0.85);
        assertEquals("EUR", cuenta.getTipoMoneda());
        assertEquals(850.0, cuenta.getSaldo(), 0.0);
    }

    @Test
    public void testAgregarTransaccion() {
        Cuenta cuenta = new Cuenta(1001, 1000.0, "USD");
        Transaccion transaccion = new Transaccion(1000.0, "Deposito");
        cuenta.agregarTransaccion(transaccion);
        assertEquals(1, cuenta.getTransacciones().size());
        assertEquals(transaccion, cuenta.getTransacciones().get(0));
    }
}
