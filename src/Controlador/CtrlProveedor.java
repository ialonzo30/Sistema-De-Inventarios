package Controlador;

import Modelo.ConsultasProveedor;
import Modelo.proveedor;
import Vista.frmProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlProveedor implements ActionListener {

    private proveedor mod;
    private ConsultasProveedor modC;
    private frmProveedor frm;

    public CtrlProveedor(proveedor mod, ConsultasProveedor modC, frmProveedor frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Proveedores");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.btnGuardar) {
            mod.setNit(frm.txtNIT.getText());
            mod.setNombre(frm.txtNOMBRE.getText());
            mod.setTelefono(frm.txtTELEFONO.getText());
            mod.setDireccion(frm.txtDIRECCION.getText());
            
            if(modC.registrar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnModificar) {
            mod.setNit(frm.txtNIT.getText());
            mod.setNombre(frm.txtNOMBRE.getText());
            mod.setTelefono(frm.txtTELEFONO.getText());
            mod.setDireccion(frm.txtDIRECCION.getText());
            
            if(modC.modificar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEliminar) {
            mod.setNit(frm.txtNIT.getText());
            
            if(modC.eliminar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBuscar) {
            mod.setNit(frm.txtNIT.getText());
            
            if(modC.buscar(mod))
            {
                
              
                frm.txtNOMBRE.setText(mod.getNombre());
                frm.txtTELEFONO.setText(String.valueOf(mod.getTelefono()));
                frm.txtDIRECCION.setText(String.valueOf(mod.getDireccion()));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }

    }
    
    public void limpiar()
    {
        frm.txtId.setText(null);
        frm.txtNIT.setText(null);
        frm.txtNOMBRE.setText(null);
        frm.txtTELEFONO.setText(null);
        frm.txtDIRECCION.setText(null);
    }

}
