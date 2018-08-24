package co.com.johan.hulkstore.persistencia.entity;

import java.io.Serializable;
import java.time.*;
import javax.persistence.*;

/**
 *
 * @author johan.lopez
 *
 */
@Entity
@Table(name = "VENTA")
@NamedQueries({
    @NamedQuery(name = "Venta.obtenerTodos", query = "select e from Venta e")
})
public class Venta implements Serializable {

    public Venta() {
    }

    public Venta(Long id) {
        this.id = id;
    }
    
    /**
     * Identificador de la tabla Venta.
     */
    @Id
    @GeneratedValue(generator = "VentaGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "VentaGen", sequenceName = "Venta_SEQ", allocationSize = 1)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FECHA_VENTA")
    private LocalDate fechaVenta;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @Column(name = "CLIENTE")
    private String cliente;

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
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
