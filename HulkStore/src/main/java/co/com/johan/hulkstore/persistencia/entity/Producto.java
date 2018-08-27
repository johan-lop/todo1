package co.com.johan.hulkstore.persistencia.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author johan.lopez
 */
@Entity
@Table(name = "Producto")//, schema="${schema}")
@NamedQueries({
    @NamedQuery(name = "Producto.obtenerTodos", query = "select e from Producto e ORDER by e.id")
})
public class Producto implements Serializable {

    public Producto() {
    }

    public Producto(Long id) {
        this.id = id;
    }

    /**
     * Identificador de la tabla Producto.
     */
    @Id
    @GeneratedValue(generator = "ProductoGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ProductoGen", sequenceName = "Producto_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "IMAGEN", columnDefinition = "TEXT")
    private String imagen;

    @Column(name = "STOK")
    private Integer stock;
    
    @Column(name = "VALOR")
    private Double valor;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

   
}
