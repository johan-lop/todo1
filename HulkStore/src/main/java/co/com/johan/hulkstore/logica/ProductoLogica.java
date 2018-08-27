package co.com.johan.hulkstore.logica;

import co.com.johan.hulkstore.persistencia.entity.Producto;
import co.com.johan.hulkstore.persistencia.ProductoDAO;
import co.com.johan.hulkstore.dto.ProductoDTO;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *  @author johan.lopez
 */
@Stateless
public class ProductoLogica {

    @EJB
    private ProductoDAO persistencia;

    /**
     * Retorna una lista con los Producto que se encuentran en la base de datos
     *
     * @return retorna una lista de ProductoDTO
     * 
     */
    public List<ProductoDTO> obtenerTodos() {
        return convertirEntidad(persistencia.obtenerTodos());
    }

    /**
     * Obtiene Producto dado su identificador.
     *
     * @param id identificador del elemento Producto
     * @return Producto del id dado
     * 
     */
    public ProductoDTO obtener(Long id) {
        return convertirEntidad(persistencia.obtener(id));
    }

    /**
     * Almacena la informacion de Producto
     *
     * @param dto Producto a guardar
     * @return Producto con los cambios realizados por el proceso de guardar
     * 
     */
    public ProductoDTO guardar(ProductoDTO dto) {
        return convertirEntidad(persistencia.guardar(convertirDTO(dto)));
    }

    /**
     * Elimina el registro Producto con el identificador dado
     *
     * @param id identificador del Producto
     * 
     */
    public void borrar(Long id) {
        persistencia.borrar(id);
    }

    /**
     * Actualiza la informacion de Producto
     *
     * @param dto Producto a guardar
     * 
     */
    public void actualizar(ProductoDTO dto) {
        persistencia.actualizar(convertirDTO(dto));
    }
    
    /**
     * Convierte un ProductoDTO en la entidad Producto.
     *
     * @param dto a convertir
     * @return entidad Producto
     * 
     */
    public Producto convertirDTO(ProductoDTO dto) {
        if (dto == null) {
            return null;
        }
        Producto entidad = new Producto();
        entidad.setId(dto.getId());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setImagen(dto.getImagen());
        entidad.setStock(dto.getStock());
        entidad.setValor(dto.getValor());
        return entidad;
    }

    /**
     * Convierte una lista de ProductoDTO en una lista de Producto.
     *
     * @param dtos a convertir
     * @return entidades List<Producto>
     * 
     */
    public List<Producto> convertirDTO(List<ProductoDTO> dtos) {
        List<Producto> entidades = new ArrayList<Producto>();
        for (ProductoDTO dto : dtos) {
            entidades.add(convertirDTO(dto));
        }
        return entidades;
    }

    /**
     * Convierte Producto en un DTO ProductoDTO.
     *
     * @param entidad a convertir
     * @return dto ProductoDTO
     * 
     */
    public ProductoDTO convertirEntidad(Producto entidad) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(entidad.getId());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setImagen(entidad.getImagen());
        dto.setStock(entidad.getStock());
        dto.setValor(entidad.getValor());
        return dto;
    }

    /**
     * Convierte una lista de Producto en una lista de ProductoDTO.
     *
     * @param entidades a convertir
     * @return dtos List<ProductoDTO>
     * 
     */
    public List<ProductoDTO> convertirEntidad(List<Producto> entidades) {
        List<ProductoDTO> dtos = new ArrayList<ProductoDTO>();
        for (Producto entidad : entidades) {
            dtos.add(convertirEntidad(entidad));
        }
        return dtos;
    }

}
