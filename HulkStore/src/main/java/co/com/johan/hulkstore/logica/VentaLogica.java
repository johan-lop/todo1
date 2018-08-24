package co.com.johan.hulkstore.logica;

import co.com.johan.hulkstore.persistencia.entity.Venta;
import co.com.johan.hulkstore.persistencia.VentaDAO;
import co.com.johan.hulkstore.dto.VentaDTO;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author johan.lopez
 */
@Stateless
public class VentaLogica {

    @EJB
    private VentaDAO persistencia;

    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /**
     * Retorna una lista con los Venta que se encuentran en la base de datos
     *
     * @return retorna una lista de VentaDTO
     *
     */
    public List<VentaDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    /**
     * Obtiene Venta dado su identificador.
     *
     * @param id identificador del elemento Venta
     * @return Venta del id dado
     *
     */
    public VentaDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * Almacena la informacion de Venta
     *
     * @param dto Venta a guardar
     * @return Venta con los cambios realizados por el proceso de guardar
     *
     */
    public VentaDTO guardar(VentaDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro Venta con el identificador dado
     *
     * @param id identificador del Venta
     *
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de Venta
     *
     * @param dto Venta a guardar
     *
     */
    public void actualizar(VentaDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }

    /**
     * Convierte un VentaDTO en la entidad Venta.
     *
     * @param dto a convertir
     * @return entidad Venta
     *
     */
    public Venta convertirDTO(VentaDTO dto) {
        if (dto == null) {
            return null;
        }
        Venta entidad = new Venta();
        entidad.setId(dto.getId());
        entidad.setCliente(dto.getCliente());
        entidad.setValorTotal(dto.getValorTotal());
        if (dto.getFechaVenta() != null) {
            entidad.setFechaVenta(LocalDate.parse(dto.getFechaVenta(), formatoFecha));
        }
        return entidad;
    }

    /**
     * Convierte una lista de VentaDTO en una lista de Venta.
     *
     * @param dtos a convertir
     * @return entidades List<Venta>
     *
     */
    public List<Venta> convertirDTO(List<VentaDTO> dtos) {
        List<Venta> entidades = new ArrayList<Venta>();
        for (VentaDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte Venta en un DTO VentaDTO.
     *
     * @param entidad a convertir
     * @return dto VentaDTO
     *
     */
    public VentaDTO convertirEntidad(Venta entidad) {
        VentaDTO dto = new VentaDTO();
        dto.setId(entidad.getId());
        dto.setCliente(entidad.getCliente());
        dto.setValorTotal(entidad.getValorTotal());

        if (entidad.getFechaVenta() != null) {
            dto.setFechaVenta(formatoFechaHora.format(entidad.getFechaVenta()));
        }
        return dto;
    }

    /**
     * Convierte una lista de Venta en una lista de VentaDTO.
     *
     * @param entidades a convertir
     * @return dtos List<VentaDTO>
     *
     */
    public List<VentaDTO> convertirEntidad(List<Venta> entidades) {
        List<VentaDTO> dtos = new ArrayList<VentaDTO>();
        for (Venta entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
