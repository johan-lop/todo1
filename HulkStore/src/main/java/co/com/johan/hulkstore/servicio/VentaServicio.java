package co.com.johan.hulkstore.servicio;

import co.com.johan.hulkstore.logica.VentaLogica;
import co.com.johan.hulkstore.dto.VentaDTO;
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
@Path("/Venta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VentaServicio {

    @EJB
    private VentaLogica logica;

    /**
     * retorna una lista con los Venta que se encuentran en la base de datos
     *
     * @return retorna una lista de VentaDTO
     * 
     */
    @GET
    public List<VentaDTO> obtenerTodosVentas() {
        return logica.obtenerTodos();
    }

    /**
     * @param id identificador del elemento Venta
     * @return Venta del id dado
     * 
     */
    @GET
    @Path("/{id}")
    public VentaDTO obtenerVenta(@PathParam("id") Long id) {
        return logica.obtener(id);
    }

    /**
     * almacena la informacion de Venta
     *
     * @param dto Venta a guardar
     * @return Venta con los cambios realizados por el proceso de guardar
     * 
     */
    @POST
    public VentaDTO guardarVenta(VentaDTO dto) {
        if (dto.getId() != null) {
            logica.actualizar(dto);
            return dto;
        } else {
            return logica.guardar(dto);
        }
    }
    
    /**
     * elimina el registro Venta con el identificador dado
     *
     * @param id identificador del Venta
     * 
     */
    @DELETE
    @Path("/{id}")
    public void borrarVenta(@PathParam("id") Long id) {
        logica.borrar(id);
    }

}
