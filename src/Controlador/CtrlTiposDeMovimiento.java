/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TiposDeMovimiento;
import Modelo.TiposDeMovimientoSQL;
import Vista.FrmTiposDeMovimiento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yulio_94
 */
public class CtrlTiposDeMovimiento implements ActionListener {
    private TiposDeMovimiento mod;
    private TiposDeMovimientoSQL modC;
    private FrmTiposDeMovimiento frm;
    
public CtrlTiposDeMovimiento(TiposDeMovimiento mod, TiposDeMovimientoSQL modC, FrmTiposDeMovimiento frm)
    {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.BtnGuardar.addActionListener(this);
        this.frm.BtnModificar.addActionListener(this);
        this.frm.BtnEliminar.addActionListener(this);
        this.frm.BtnLimpiar.addActionListener(this);
        this.frm.BtnBuscar.addActionListener(this);
    }
    public void LlenarTabla(JTable TblMov, String tipodemovimiento){
    System.out.println("Llenar Tabla");
    DefaultTableModel modeloT = new DefaultTableModel();
    TblMov.setModel(modeloT);
    modeloT.addColumn("Tipo de Movimiento");
    modeloT.addColumn("Descripcion");
    modeloT.addColumn("Signo");
    
    Object[] columna = new Object [3];
    
    int num = modC.listaTiposdeMovimientos(tipodemovimiento).size();
    for (int i = 0; i <num; i++){
            columna[0] = modC.listaTiposdeMovimientos(tipodemovimiento).get(i).getTipodemovimiento();
            columna[1] = modC.listaTiposdeMovimientos(tipodemovimiento).get(i).getDescripcion();
            columna[2] = modC.listaTiposdeMovimientos(tipodemovimiento).get(i).getSigno();
            modeloT.addRow(columna);
    }
    }

   public void Iniciar()
    {
        frm.setTitle("Unidad De Medida");
        frm.setLocationRelativeTo(null);
        LlenarTabla(frm.TblMov,"");
    }
    
    public void Limpiar()
    {
        frm.TxtTipoDeMovimiento.setText(null);
        frm.TxtDescripcion.setText(null);
        frm.TxtSigno.setText(null);
        LlenarTabla(frm.TblMov,"");
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==frm.BtnGuardar)
        {
            mod.setTipodemovimiento(Integer.parseInt(frm.TxtTipoDeMovimiento.getText()));
            mod.setDescripcion(frm.TxtDescripcion.getText());
            mod.setSigno(Integer.parseInt(frm.TxtSigno.getText()));
            
            if(modC.Registrar(mod))
            {
                JOptionPane.showMessageDialog(null, "Movimiento guardado.");
                LlenarTabla(frm.TblMov,"");
                Limpiar();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al guardar Movimiento.");
                Limpiar();
            }
        }
        
        if(e.getSource()==frm.BtnModificar)
        {
            mod.setTipodemovimiento(Integer.parseInt(frm.TxtTipoDeMovimiento.getText()));
            mod.setDescripcion(frm.TxtDescripcion.getText());
            mod.setSigno(Integer.parseInt(frm.TxtSigno.getText()));
            
            
            if(modC.Modificar(mod))
            {
                JOptionPane.showMessageDialog(null, "Movimiento Modificado.");
                LlenarTabla(frm.TblMov,"");
                Limpiar();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al modificar Movimiento.");
                Limpiar();
            }
        }
        
        if(e.getSource()==frm.BtnEliminar)
        {
            mod.setTipodemovimiento(Integer.parseInt(frm.TxtTipoDeMovimiento.getText()));
            
            if(modC.Eliminar(mod))
            {
                JOptionPane.showMessageDialog(null, "Movimiento eliminado.");
                LlenarTabla(frm.TblMov,"");
                Limpiar();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al eliminar Movimiento.");
                Limpiar();
            }
        }
        
        if(e.getSource()==frm.BtnBuscar)
        {
        mod.setTipodemovimiento(Integer.parseInt(frm.TxtTipoDeMovimiento.getText()));
        
        if(modC.Buscar(mod))
        {
              frm.TxtTipoDeMovimiento.setText(Integer.toString(mod.getTipodemovimiento()));
              frm.TxtDescripcion.setText(mod.getDescripcion());
              frm.TxtSigno.setText(Integer.toString(mod.getSigno()));
              LlenarTabla(frm.TblMov,"");
        }
        else{
            JOptionPane.showMessageDialog(null, "Error al Buscar.");
        }
        }
        
         if(e.getSource()==frm.BtnLimpiar)
        {
  
            Limpiar();
        }
    }
    
}
