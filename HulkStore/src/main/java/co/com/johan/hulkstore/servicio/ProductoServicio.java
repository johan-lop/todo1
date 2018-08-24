package co.com.johan.hulkstore.servicio;

import co.com.johan.hulkstore.logica.ProductoLogica;
import co.com.johan.hulkstore.dto.ProductoDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * @author johan.lopez
 * 
 */
@Stateless
@Path("/Producto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoServicio {

    @EJB
    private ProductoLogica logica;

    /**
     * retorna una lista con los Producto que se encuentran en la base de datos
     *
     * @return retorna una lista de ProductoDTO
     * 
     */
    @GET
    public List<ProductoDTO> obtenerTodosProductos() {
        return logica.obtenerTodos();
    }

    /**
     * @param id identificador del elemento Producto
     * @return Producto del id dado
     * 
     */
    @GET
    @Path("/{id}")
    public ProductoDTO obtenerProducto(@PathParam("id") Long id) {
        return logica.obtener(id);
    }

    /**
     * almacena la informacion de Producto
     *
     * @param dto Producto a guardar
     * @return Producto con los cambios realizados por el proceso de guardar
     * 
     */
    @POST
    public ProductoDTO guardarProducto(ProductoDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }
    
    /**
     * elimina el registro Producto con el identificador dado
     *
     * @param id identificador del Producto
     * 
     */
    @DELETE
    @Path("/{id}")
    public void borrarProducto(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
