/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.johan.hulkstore.logica;

import co.com.johan.hulkstore.dto.ProductoDTO;
import co.com.johan.hulkstore.persistencia.entity.Producto;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 *
 * @author johan
 */
public class ProductoLogicaTest extends TestCase {
    
    public ProductoLogicaTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testObtenerTodos() throws Exception {
        System.out.println("obtenerTodos");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProductoLogica instance = (ProductoLogica)container.getContext()
                .lookup("java:global/HulkStore/ProductoLogica");
        List<ProductoDTO> expResult = null;
        List<ProductoDTO> result = instance.obtenerTodos();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testObtener() throws Exception {
        System.out.println("obtener");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProductoLogica instance = (ProductoLogica)container.getContext().lookup("java:global/HulkStore/ProductoLogica");
        ProductoDTO expResult = null;
        ProductoDTO result = instance.obtener(id);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testGuardar() throws Exception {
        System.out.println("guardar");
        ProductoDTO dto = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProductoLogica instance = (ProductoLogica)container.getContext().lookup("java:global/HulkStore/ProductoLogica");
        ProductoDTO expResult = null;
        ProductoDTO result = instance.guardar(dto);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testBorrar() throws Exception {
        System.out.println("borrar");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProductoLogica instance = (ProductoLogica)container.getContext().lookup("java:global/HulkStore/ProductoLogica");
        instance.borrar(id);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testActualizar() throws Exception {
        System.out.println("actualizar");
        ProductoDTO dto = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProductoLogica instance = (ProductoLogica)container.getContext().lookup("java:global/HulkStore/ProductoLogica");
        instance.actualizar(dto);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testConvertirDTO_ProductoDTO() throws Exception {
        System.out.println("convertirDTO");
        ProductoDTO dto = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProductoLogica instance = (ProductoLogica)container.getContext().lookup("java:global/HulkStore/ProductoLogica");
        Producto expResult = null;
        Producto result = instance.convertirDTO(dto);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testConvertirDTO_List() throws Exception {
        System.out.println("convertirDTO");
        List<ProductoDTO> dtos = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProductoLogica instance = (ProductoLogica)container.getContext().lookup("java:global/HulkStore/ProductoLogica");
        List<Producto> expResult = null;
        List<Producto> result = instance.convertirDTO(dtos);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testConvertirEntidad_Producto() throws Exception {
        System.out.println("convertirEntidad");
        Producto entidad = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProductoLogica instance = (ProductoLogica)container.getContext().lookup("java:global/HulkStore/ProductoLogica");
        ProductoDTO expResult = null;
        ProductoDTO result = instance.convertirEntidad(entidad);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testConvertirEntidad_List() throws Exception {
        System.out.println("convertirEntidad");
        List<Producto> entidades = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProductoLogica instance = (ProductoLogica)container.getContext().lookup("java:global/HulkStore/ProductoLogica");
        List<ProductoDTO> expResult = null;
        List<ProductoDTO> result = instance.convertirEntidad(entidades);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }
    
}
