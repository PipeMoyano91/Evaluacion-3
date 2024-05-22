package alke.wallet;

public class Main {
    public static void main(String[] args) {
        // Crear un cliente
        Cliente cliente = new Cliente(1, "John Doe", "john@example.com");

        // Crear una cuenta y agregarla al cliente
        Cuenta cuenta = new Cuenta(1001, 5000.0, "USD");
        cliente.agregarCuenta(cuenta);

        // Realizar operaciones en la cuenta
        cuenta.depositar(1500.0);
        try {
            cuenta.retirar(2000.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        // Convertir saldo a otra moneda
        cuenta.convertirSaldo("EUR", 0.85);

        // Imprimir detalles del cliente y sus cuentas
        System.out.println("Cliente: " + cliente.getNombre() + ", Email: " + cliente.getCorreoElectronico());
        for (Cuenta c : cliente.getCuentas()) {
            System.out.println("Cuenta #" + c.getNumero() + " - Saldo: " + c.getSaldo() + " " + c.getTipoMoneda());
            for (Transaccion t : c.getTransacciones()) {
                System.out.println(" - Transacción: " + t.getTipo() + " de " + t.getMonto() + " en " + t.getFecha());
            }
        }
    }
}
