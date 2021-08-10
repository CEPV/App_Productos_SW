package com.example.myappswlocal.complementos;

public class ProductoVO {

    private  int idProducto;
    private String nombreProducto;
    private String distribuidorProducto;
    private  int precioProducto;
    private String tamañoProducto;

    public ProductoVO(int idProducto, String nombreProducto, String distribuidorProducto, int precioProducto, String tamañoProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.distribuidorProducto = distribuidorProducto;
        this.precioProducto = precioProducto;
        this.tamañoProducto = tamañoProducto;
    }

    public ProductoVO() {

    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDistribuidorProducto() {
        return distribuidorProducto;
    }

    public void setDistribuidorProducto(String distribuidorProducto) {
        this.distribuidorProducto = distribuidorProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getTamañoProducto() {
        return tamañoProducto;
    }

    public void setTamañoProducto(String tamañoProducto) {
        this.tamañoProducto = tamañoProducto;
    }
}
