package co.com.johan.hulkstore.persistencia.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author johan.lopez
 *
 */
@Entity
@Table(name = "DETALLE_VENTA")
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.obtenerTodos", query = "select e from DetalleVenta e")
})
public class DetalleVenta implements Serializable {

    public DetalleVenta() {
    }

    public DetalleVenta(Long id) {
        this.id = id;
    }
    
    @Id
    @GeneratedValue(generator = "DetalleVentaGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DetalleVentaGen", sequenceName = "DetalleVenta_SEQ", allocationSize = 1)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    @JoinColumn(name = "VENTA_ID")
    private Venta venta;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    @JoinColumn(name = "PRODUCTO_ID")
    private Producto producto;

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    

}
