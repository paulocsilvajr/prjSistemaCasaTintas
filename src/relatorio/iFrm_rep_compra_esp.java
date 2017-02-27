/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import javax.swing.JOptionPane;
import principal.FrmLogin;

/**
 *
 * @author paulo
 */
public class iFrm_rep_compra_esp extends javax.swing.JInternalFrame {

    /**
     * Creates new form iFrm_rep_compra_esp
     */
    public iFrm_rep_compra_esp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnDados = new javax.swing.JPanel();
        btnCancelar = new lib.jdb.control.jdbbuttoncancel.JDBButtonCancel();
        pnDatas = new javax.swing.JPanel();
        txtCliente = new javax.swing.JTextField();
        lblInc1 = new javax.swing.JLabel();
        btnGerar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Impressão de compra");

        pnDados.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return2.png"))); // NOI18N
        btnCancelar.setFont(principal.FrmLogin.fontePadrao);
        btnCancelar.setText("Limpar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        pnDatas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        lblInc1.setFont(principal.FrmLogin.fontePadrao);
        lblInc1.setText("Código da compra:");

        javax.swing.GroupLayout pnDatasLayout = new javax.swing.GroupLayout(pnDatas);
        pnDatas.setLayout(pnDatasLayout);
        pnDatasLayout.setHorizontalGroup(
            pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInc1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDatasLayout.setVerticalGroup(
            pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInc1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document_search.png"))); // NOI18N
        btnGerar.setText("Gerar");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDadosLayout = new javax.swing.GroupLayout(pnDados);
        pnDados.setLayout(pnDadosLayout);
        pnDadosLayout.setHorizontalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDatas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnDadosLayout.setVerticalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnDatas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtCliente.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        if(txtCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Informe o código da compra",
                "Atenção", JOptionPane.INFORMATION_MESSAGE);
            txtCliente.requestFocus();
        }else if(!txtCliente.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(this, "Código da compra deve ser formado somente por números",
                "Atenção", JOptionPane.INFORMATION_MESSAGE);
            txtCliente.requestFocus();
        }else{

            relatorio.Relatorios.rep_compra_esp(txtCliente.getText());

            // registro de log
            FrmLogin.log.gravar(
                FrmLogin.usuario.getNomeUsuario(),
                "iFrmCompra",
                txtCliente.getText(),
                "emitido impressão de compra");
        }
    }//GEN-LAST:event_btnGerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lib.jdb.control.jdbbuttoncancel.JDBButtonCancel btnCancelar;
    private javax.swing.JButton btnGerar;
    private javax.swing.JLabel lblInc1;
    private javax.swing.JPanel pnDados;
    private javax.swing.JPanel pnDatas;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables
}
