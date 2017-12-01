
package Controlador;

import Modelo.ConsultasClientes;
import Modelo.clientes;
import Vista.frmclientes1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Ctrlclientes implements ActionListener{
private clientes mod;
private ConsultasClientes modC;
private frmclientes1 frm;
public Ctrlclientes(clientes mod, ConsultasClientes modC, frmclientes1 frm){
    this.mod= mod;
        this.modC= modC;
        this.frm= frm;
         this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
}    
 public void Iniciar()
    {
     frm.setTitle("clientes");
     frm.setLocationRelativeTo(null); 
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==frm.btnGuardar){
            mod.setNIT(frm.txtNIT.getText());
        mod.setNombre(frm.txtnombre.getText());
        mod.setTelefono(frm.txttelefono.getText());
        mod.setDireccion(frm.txtdireccion.getText());
       
        if(modC.registrar(mod)){
            JOptionPane.showMessageDialog(null," Registro guardado. ");
            limpiar();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error al Guardar. ");
            limpiar();
        }
        }
        if(e.getSource()==frm.btnModificar){
        mod.setNIT(frm.txtNIT.getText());
        mod.setNombre(frm.txtnombre.getText());
        mod.setTelefono(frm.txttelefono.getText());
        mod.setDireccion(frm.txtdireccion.getText());
       
        if(modC.modificar(mod)){
            JOptionPane.showMessageDialog(null," Registro Modificado. ");
            limpiar();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error al Modificar. ");
            limpiar();
        }
        }
    if(e.getSource()==frm.btnEliminar){
        mod.setNIT(frm.txtNIT.getText());
        if(modC.eliminar(mod)){
            JOptionPane.showMessageDialog(null," Registro Eliminado. ");
            limpiar();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error al Elminar. ");
            limpiar();
        }
        }
        if(e.getSource()==frm.btnBuscar){
        mod.setNombre(frm.txtnombre.getText());

        if(modC.buscar(mod)){
            frm.txtNIT.setText(mod.getNIT());
            frm.txtnombre.setText(mod.getNombre());
            frm.txttelefono.setText(mod.getTelefono());
            frm.txtdireccion.setText(mod.getDireccion());
        }else{
            
            JOptionPane.showMessageDialog(null," No se encontro el Registro ");
            limpiar();
        }}
        if (e.getSource()== frm.btnLimpiar){ 
        limpiar();
        }
        }
    
public void limpiar()
    {
       frm.txtNIT.setText(null);
       frm.txtnombre.setText(null);
       frm.txttelefono.setText(null);
       frm.txtdireccion.setText(null);
    
    }

   
}
