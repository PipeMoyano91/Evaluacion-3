package alke.wallet;

import org.junit.Test;

public class SaldoInsuficienteException extends Exception {
    private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }

@Test(expected = SaldoInsuficienteException.class)
public void testRetirarConSaldoInsuficiente() throws SaldoInsuficienteException {
    Cuenta cuenta = new Cuenta(1001, 500.0, "USD");
    cuenta.retirar(1000.0);
	}
}