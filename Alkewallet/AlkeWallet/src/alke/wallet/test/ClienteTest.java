package alke.wallet.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import alke.wallet.Cliente;
import alke.wallet.Cuenta;

public class ClienteTest {

    @Test
    public void testConstructor() {
        Cliente cliente = new Cliente(1, "John Doe", "john@example.com");
        assertEquals(1, cliente.getId());
        assertEquals("John Doe", cliente.getNombre());
        assertEquals("john@example.com", cliente.getCorreoElectronico());
    }

    @Test
    public void testSettersAndGetters() {
        Cliente cliente = new Cliente(1, "John Doe", "john@example.com");
        cliente.setNombre("Jane Doe");
        cliente.setCorreoElectronico("jane@example.com");
        assertEquals("Jane Doe", cliente.getNombre());
        assertEquals("jane@example.com", cliente.getCorreoElectronico());
    }

    @Test
    public void testAgregarCuenta() {
        Cliente cliente = new Cliente(1, "John Doe", "john@example.com");
        Cuenta cuenta = new Cuenta(1001, 1000.0, "USD");
        cliente.agregarCuenta(cuenta);
        assertEquals(1, cliente.getCuentas().size());
        assertEquals(cuenta, cliente.getCuentas().get(0));
    }
}
