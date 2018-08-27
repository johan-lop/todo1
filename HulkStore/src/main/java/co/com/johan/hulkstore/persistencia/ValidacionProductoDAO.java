package co.com.johan.hulkstore.persistencia;

import co.com.johan.hulkstore.persistencia.entity.Producto;
import java.util.List;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 *
 * @author johan.lopez
 */
@Singleton
public class ValidacionProductoDAO {

    @PersistenceContext
    private EntityManager em;

    
    /**
     * Se agrega un bloqueo a la tabla producto para consultar la cantidad disponible
     * con el fin de no vender mas producto de la cantidad disponible
     *
     * @param productoId id del producto
     * @return Producto si se puede o no comprar la cantidad enviada
     *
     */
    @Lock(LockType.READ)
    public Producto validarCantidad(Long productoId, Integer cantidad) {
        Producto producto = em.find(Producto.class, productoId);
        if (producto != null) {
            if (producto.getStock() >= cantidad) {
                return producto;
            }
        }
        return null;
    }


}
