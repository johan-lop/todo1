package co.com.johan.hulkstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author johan.lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VentaDTO {

    public VentaDTO() {
        //constructor base
    }

    public VentaDTO(Long id) {
        this.id = id;
    }

    private Long id;

    private String fechaVenta;

    private Double valorTotal;

    private String cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
}
