/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.johan.hulkstore.logica;

import co.com.johan.hulkstore.dto.VentaDTO;
import co.com.johan.hulkstore.persistencia.entity.Venta;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import junit.framework.TestCase;

/**
 *
 * @author johan
 */
public class VentaLogicaTest extends TestCase {
    
    public VentaLogicaTest(String testName) {
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
        VentaLogica instance = (VentaLogica)container.getContext().lookup("java:global/HulkStore/VentaLogica");
        List<VentaDTO> expResult = null;
        List<VentaDTO> result = instance.obtenerTodos();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testObtener() throws Exception {
        System.out.println("obtener");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        VentaLogica instance = (VentaLogica)container.getContext().lookup("java:global/HulkStore/VentaLogica");
        VentaDTO expResult = null;
        VentaDTO result = instance.obtener(id);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testGuardar() throws Exception {
        System.out.println("guardar");
        VentaDTO dto = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        VentaLogica instance = (VentaLogica)container.getContext().lookup("java:global/HulkStore/VentaLogica");
        VentaDTO expResult = null;
        VentaDTO result = instance.guardar(dto);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testBorrar() throws Exception {
        System.out.println("borrar");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        VentaLogica instance = (VentaLogica)container.getContext().lookup("java:global/HulkStore/VentaLogica");
        instance.borrar(id);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testActualizar() throws Exception {
        System.out.println("actualizar");
        VentaDTO dto = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        VentaLogica instance = (VentaLogica)container.getContext().lookup("java:global/HulkStore/VentaLogica");
        instance.actualizar(dto);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testConvertirDTO_VentaDTO() throws Exception {
        System.out.println("convertirDTO");
        VentaDTO dto = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        VentaLogica instance = (VentaLogica)container.getContext().lookup("java:global/HulkStore/VentaLogica");
        Venta expResult = null;
        Venta result = instance.convertirDTO(dto);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testConvertirDTO_List() throws Exception {
        System.out.println("convertirDTO");
        List<VentaDTO> dtos = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        VentaLogica instance = (VentaLogica)container.getContext().lookup("java:global/HulkStore/VentaLogica");
        List<Venta> expResult = null;
        List<Venta> result = instance.convertirDTO(dtos);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testConvertirEntidad_Venta() throws Exception {
        System.out.println("convertirEntidad");
        Venta entidad = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        VentaLogica instance = (VentaLogica)container.getContext().lookup("java:global/HulkStore/VentaLogica");
        VentaDTO expResult = null;
        VentaDTO result = instance.convertirEntidad(entidad);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    public void testConvertirEntidad_List() throws Exception {
        System.out.println("convertirEntidad");
        List<Venta> entidades = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        VentaLogica instance = (VentaLogica)container.getContext().lookup("java:global/HulkStore/VentaLogica");
        List<VentaDTO> expResult = null;
        List<VentaDTO> result = instance.convertirEntidad(entidades);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }
    
}
