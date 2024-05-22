package alke.wallet;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una cuenta en la aplicación Alke Wallet.
 */
public class Cuenta {
    private int numero; // Número de la cuenta
    private double saldo; // Saldo de la cuenta
    private String tipoMoneda; // Tipo de moneda de la cuenta
    private List<Transaccion> transacciones; // Lista de transacciones realizadas en la cuenta

    /**
     * Constructor de la clase Cuenta.
     * 
     * @param numero      Número de la cuenta.
     * @param saldo       Saldo inicial de la cuenta.
     * @param tipoMoneda  Tipo de moneda de la cuenta.
     */
    public Cuenta(int numero, double saldo, String tipoMoneda) {
        this.numero = numero;
        this.saldo = saldo;
        this.tipoMoneda = tipoMoneda;
        this.transacciones = new ArrayList<>();
    }

    /**
     * Método para realizar un depósito en la cuenta.
     * 
     * @param monto El monto a depositar.
     */
    public void depositar(double monto) {
        saldo += monto;
        Transaccion transaccion = new Transaccion(monto, "Deposito");
        transacciones.add(transaccion);
        System.out.println("Se depositaron " + monto + " en la cuenta #" + numero);
    }

    /**
     * Método para realizar un retiro de la cuenta.
     * 
     * @param monto El monto a retirar.
     * @throws SaldoInsuficienteException Si el saldo es insuficiente para el retiro.
     */
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (saldo >= monto) {
            saldo -= monto;
            Transaccion transaccion = new Transaccion(-monto, "Retiro");
            transacciones.add(transaccion);
            System.out.println("Se retiraron " + monto + " de la cuenta #" + numero);
        } else {
            throw new SaldoInsuficienteException("Fondos insuficientes en la cuenta #" + numero);
        }
    }

    /**
     * Método para convertir el saldo de la cuenta a otra moneda.
     * 
     * @param nuevaMoneda La nueva moneda a la cual se convertirá el saldo.
     * @param tipoCambio  El tipo de cambio para la conversión.
     */
    public void convertirSaldo(String nuevaMoneda, double tipoCambio) {
        if (!nuevaMoneda.equals(tipoMoneda)) {
            double nuevoSaldo = saldo * tipoCambio;
            Transaccion transaccion = new Transaccion(nuevoSaldo - saldo, "Conversión de Moneda");
            tipoMoneda = nuevaMoneda;
            saldo = nuevoSaldo;
            transacciones.add(transaccion);
            System.out.println("Se ha convertido el saldo a " + nuevaMoneda + " con un tipo de cambio de " + tipoCambio);
        } else {
            System.out.println("La nueva moneda es la misma que la moneda actual de la cuenta.");
        }
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    /**
     * Método para agregar una transacción a la lista de transacciones.
     * 
     * @param transaccion La transacción a agregar.
     */
    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }
}



