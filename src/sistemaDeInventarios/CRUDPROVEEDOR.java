/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import Controlador.CtrlProducto;
import Modelo.ConsultasProveedor;
import Modelo.proveedor;
import Vista.frmProveedor;

/**
 *
 * @author Marko
 */
public class CRUDPROVEEDOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        proveedor mod = new proveedor();
        ConsultasProveedor modC = new ConsultasProveedor();
        frmProveedor frm = new frmProveedor();
        
        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
    }
    
}
