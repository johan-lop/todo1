package co.com.johan.hulkstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
  *  @author johan.lopez
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductoDTO {

    public ProductoDTO(){
        //constructor base
    }
    
    public ProductoDTO(Long id){
        this.id=id;
    }
    
    private Long id;

    private String descripcion;
    
    private String imagen;

    private Integer stock;
    
    private Double valor;
    
    private Integer cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    
    	
}
