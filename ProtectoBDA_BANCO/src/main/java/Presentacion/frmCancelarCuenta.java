/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Dominio.Cliente;
import Dominio.Cuenta;
import Excepciones.PersistenciaException;
import Interfaces.IClientesDAO;
import Interfaces.ICuentasDAO;
import Interfaces.IDomicilioDAO;
import Interfaces.IOperacionesDAO;
import Interfaces.ITransferenciasDAO;
import static java.lang.Integer.parseInt;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aroco
 */
public class frmCancelarCuenta extends javax.swing.JFrame {
     private final Cliente cliente;
   private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final ITransferenciasDAO transferenciasDAO;
    private final IOperacionesDAO operacionesDAO;
    private final IDomicilioDAO domicilioDAO;
    private static final Logger LOG = Logger.getLogger(frmInterfazCliente.class.getName());

    public frmCancelarCuenta(Cliente cliente, IClientesDAO clientesDAO, ICuentasDAO cuentasDAO, ITransferenciasDAO transferenciasDAO, IOperacionesDAO operacionesDAO, IDomicilioDAO domicilioDAO) {
        this.cliente = cliente;
        this.clientesDAO = clientesDAO;
        this.cuentasDAO = cuentasDAO;
        this.transferenciasDAO = transferenciasDAO;
        this.operacionesDAO = operacionesDAO;
        this.domicilioDAO = domicilioDAO;
          initComponents();
          cargarComboBox();
    }

    
    public void cargarComboBox(){
        int cuentas;
          this.cbxCuentas.removeAllItems();
     try {
            List<Cuenta> listaCuentas = this.cuentasDAO.consultarListaCuentas(cliente);
            for (Cuenta cuenta : listaCuentas) {
                 cuentas=cuenta.getNum_cuenta();
              this.cbxCuentas.addItem(String.valueOf(cuentas));
            }
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }
    
    private void cancelarCuenta() {
        String cbxTexto = this.cbxCuentas.getItemAt(this.cbxCuentas.getSelectedIndex());
        Cuenta cuenta=new Cuenta(parseInt(cbxTexto),this.cliente.getId_cliente());
        try {
            cuentasDAO.cancelarCuenta(cuenta);
            JOptionPane.showMessageDialog(this,"Se cancelo la cuenta correctamente");
            new frmInterfazCliente(cliente,clientesDAO,cuentasDAO,transferenciasDAO,operacionesDAO,domicilioDAO).setVisible(true);
             this.dispose();
                   
        } catch (PersistenciaException ex) {
            Logger.getLogger(frmCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxCuentas = new javax.swing.JComboBox<>();
        btnCancelarCuenta = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbxCuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCancelarCuenta.setText("Cancelar Cuenta");
        btnCancelarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCuentaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Volver");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(btnCancelarCuenta)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(cbxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(cbxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarCuenta)
                    .addComponent(btnCancelar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCuentaActionPerformed
      cancelarCuenta();

    }//GEN-LAST:event_btnCancelarCuentaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        new frmInterfazCliente(cliente,clientesDAO,cuentasDAO,transferenciasDAO,operacionesDAO,domicilioDAO).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarCuenta;
    private javax.swing.JComboBox<String> cbxCuentas;
    // End of variables declaration//GEN-END:variables

    
}
