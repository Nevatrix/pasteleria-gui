
package model;

import java.io.Serializable;

public class Pedido implements Serializable{
    protected int numPedido;
    protected String tipoPastel;
    protected String tamañoPastel;
    protected double precioTipo;
    protected double precioTamaño;
    protected double precioTotal;
    protected boolean borrado;
    protected Usuario usuario;

    public Pedido() {// Constructor vacío
    }

    public Pedido(int numPedido, String tipoPastel, String tamañoPastel, double precioTipo, double precioTamaño, double precioTotal, boolean borrado, Usuario usuario) {
        this.numPedido = numPedido;
        this.tipoPastel = tipoPastel;
        this.tamañoPastel = tamañoPastel;
        this.precioTipo = precioTipo;
        this.precioTamaño = precioTamaño;
        this.precioTotal = precioTotal;
        this.borrado = borrado;
        this.usuario = usuario;
    }
    
    // Getters y setters para los atributos
    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public String getTipoPastel() {
        return tipoPastel;
    }

    public void setTipoPastel(String tipoPastel) {
        this.tipoPastel = tipoPastel;
    }

    public String getTamañoPastel() {
        return tamañoPastel;
    }

    public void setTamañoPastel(String tamañoPastel) {
        this.tamañoPastel = tamañoPastel;
    }

    public double getPrecioTipo() {
        return precioTipo;
    }

    public void setPrecioTipo(double precioTipo) {
        this.precioTipo = precioTipo;
    }

    public double getPrecioTamaño() {
        return precioTamaño;
    }

    public void setPrecioTamaño(double precioTamaño) {
        this.precioTamaño = precioTamaño;
    }
    
    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {    
        this.usuario = usuario;
    }

    // Calcular el precio total
    public double calcularPrecioTotal(){
        this.precioTotal = (this.precioTipo * this.precioTamaño);
        return this.precioTotal;
    }
}
