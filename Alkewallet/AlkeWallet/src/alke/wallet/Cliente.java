package alke.wallet;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un cliente en la aplicación Alke Wallet.
 */
public class Cliente {
    private int id; // ID del cliente
    private String nombre; // Nombre del cliente
    private String correoElectronico; // Correo electrónico del cliente
    private List<Cuenta> cuentas; // Lista de cuentas asociadas al cliente

    /**
     * Constructor de la clase Cliente.
     * 
     * @param id               ID del cliente.
     * @param nombre           Nombre del cliente.
     * @param correoElectronico Correo electrónico del cliente.
     */
    public Cliente(int id, String nombre, String correoElectronico) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.cuentas = new ArrayList<>();
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    /**
     * Método para agregar una cuenta a la lista de cuentas del cliente.
     * 
     * @param cuenta La cuenta a agregar.
     */
    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
}

