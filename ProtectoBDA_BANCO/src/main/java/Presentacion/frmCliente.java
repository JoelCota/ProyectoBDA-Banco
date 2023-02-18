/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Cliente;
import Implementaciones.ClientesDAO;
import Implementaciones.ConexionBD;
import Interfaces.IClientesDAO;
import Interfaces.IConexionBD;
import Presentacion.frmInterfazCliente;
import javax.swing.JOptionPane;

/**
 *
 * @author Joel Lopez
 */
public class frmCliente extends javax.swing.JFrame {
    
    IConexionBD manejadorConexiones = new ConexionBD(
                "jdbc:mysql://localhost/banco",
                "root",
                "13553Lop?"
        );
    IClientesDAO clientesDAO = new ClientesDAO(manejadorConexiones);

    /**
     * Creates new form ClientesForm
     */
    public frmCliente() {
        initComponents();
    }
    
    private Cliente inicioSesion(Integer numeroCuenta,String contrasena){
        if (clientesDAO.consultar(numeroCuenta).getContrasena()==contrasena) {
           frmInterfazCliente  frmICliente= new frmInterfazCliente();
           frmICliente.setVisible(true);
           this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Hola");
        }
        return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIniciarSesionCliente = new javax.swing.JButton();
        lblNumeroCliente = new javax.swing.JLabel();
        lnlContraseña = new javax.swing.JLabel();
        txtNumeroCliente = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clientes");

        btnIniciarSesionCliente.setText("Iniciar Sesion");
        btnIniciarSesionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionClienteActionPerformed(evt);
            }
        });

        lblNumeroCliente.setText("Numero Cliente");

        lnlContraseña.setText("Contraseña");

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumeroCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lnlContraseña, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContraseña)
                            .addComponent(txtNumeroCliente)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIniciarSesionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(92, 92, 92))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtras)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAtras)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroCliente))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnlContraseña)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnIniciarSesionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionClienteActionPerformed
        Integer id_cliente=Integer.parseInt(this.txtNumeroCliente.getText());
        String contrasena=this.txtContraseña.getText();
        inicioSesion(id_cliente,contrasena);
    }//GEN-LAST:event_btnIniciarSesionClienteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        frmBanco banco = new frmBanco(clientesDAO);
        banco.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnIniciarSesionCliente;
    private javax.swing.JLabel lblNumeroCliente;
    private javax.swing.JLabel lnlContraseña;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtNumeroCliente;
    // End of variables declaration//GEN-END:variables
}
