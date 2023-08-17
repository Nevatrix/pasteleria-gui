
package model;

import java.io.Serializable;

public class PedidoCompleto extends Pedido implements Serializable{
    protected String adicionalesPastel;
    protected double precioAdicionales;

    public PedidoCompleto() {
    }

    public PedidoCompleto(String adicionalesPastel, double precioAdicionales) {
        this.adicionalesPastel = adicionalesPastel;
        this.precioAdicionales = precioAdicionales;
    }

    public PedidoCompleto(String adicionalesPastel, double precioAdicionales, int numPedido, String tipoPastel, String tamañoPastel, double precioTipo, double precioTamaño, double precioTotal, boolean borrado, Usuario usuario) {
        super(numPedido, tipoPastel, tamañoPastel, precioTipo, precioTamaño, precioTotal, borrado, usuario);
        this.adicionalesPastel = adicionalesPastel;
        this.precioAdicionales = precioAdicionales;
    }
    
    public String getAdicionalesPastel() {
        return adicionalesPastel;
    }

    public void setAdicionalesPastel(String adicionalesPastel) {
        this.adicionalesPastel = adicionalesPastel;
    }

    public double getPrecioAdicionales() {
        return precioAdicionales;
    }

    public void setPrecioAdicionales(double precioAdicionales) {
        this.precioAdicionales = precioAdicionales;
    }

    @Override
    public double calcularPrecioTotal(){
        this.precioTotal = (this.precioTipo * this.precioTamaño) + precioAdicionales;
        return this.precioTotal;
    }
    
}
