/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.johan.hulkstore.servicio;

import java.io.Serializable;

/**
 *
 * @author daniel
 */
@javax.ejb.ApplicationException
public class ApplicationException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = 1L;
    
    public ApplicationException() {
        super();
    }
    public ApplicationException(String msg)   {
        super(msg);
    }
    public ApplicationException(String msg, Exception e)  {
        super(msg, e);
    }

}
