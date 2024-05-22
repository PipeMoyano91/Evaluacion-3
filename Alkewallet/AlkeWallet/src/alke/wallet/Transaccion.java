package alke.wallet;

import java.time.LocalDateTime;

/**
 * Clase que representa una transacción en la aplicación Alke Wallet.
 */
public class Transaccion {
    private double monto; // Monto de la transacción
    private String tipo; // Tipo de transacción
    private LocalDateTime fecha; // Fecha y hora de la transacción

    /**
     * Constructor de la clase Transaccion.
     * 
     * @param monto El monto de la transacción.
     * @param tipo  El tipo de transacción.
     */
    public Transaccion(double monto, String tipo) {
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = LocalDateTime.now();
    }

    // Getters y setters
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}

