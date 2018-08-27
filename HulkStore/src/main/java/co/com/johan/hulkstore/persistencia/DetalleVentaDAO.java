package co.com.johan.hulkstore.persistencia;

import co.com.johan.hulkstore.persistencia.entity.DetalleVenta;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 *
 * @author johan.lopez
 */
@Stateless
public class DetalleVentaDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Almacena la informacion de DetalleVenta
     *
     * @param entidad DetalleVenta a guardar
     * @return Venta con los cambios realizados por el proceso de guardar
     *
     */
    public DetalleVenta guardar(DetalleVenta entidad) {
        em.persist(entidad);
        return entidad;
    }

}
