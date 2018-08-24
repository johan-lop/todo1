package co.com.johan.hulkstore.persistencia;

import co.com.johan.hulkstore.persistencia.entity.Venta;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 *
 * @author johan.lopez
 */
@Stateless
public class VentaDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna una lista con los Venta que se encuentran en la base de
     * datos.
     *
     * @return lista de Venta
     *
     */
    public List<Venta> obtenerTodos() {
        return em.createNamedQuery("Venta.obtenerTodos").getResultList();
    }

    /**
     * Obtiene Venta dado su identificador.
     *
     * @param id identificador del elemento Venta
     * @return Venta del id dado
     *
     */
    public Venta obtener(Long id) {
        return em.find(Venta.class, id);
    }

    /**
     * Almacena la informacion de Venta
     *
     * @param entidad Venta a guardar
     * @return Venta con los cambios realizados por el proceso de guardar
     *
     */
    public Venta guardar(Venta entidad) {
        em.persist(entidad);
        return entidad;
    }

    /**
     * Elimina el registro Venta con el identificador dado.
     *
     * @param id identificador del Venta
     *
     */
    public void borrar(Long id) {
        em.remove(em.find(Venta.class, id));
    }

    /**
     * Actualiza la informacion de Venta.
     *
     * @param entidad Venta a actualizar
     *
     */
    public void actualizar(Venta entidad) {
        em.merge(entidad);
    }

}
