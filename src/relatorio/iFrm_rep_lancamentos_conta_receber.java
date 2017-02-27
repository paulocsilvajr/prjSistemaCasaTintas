/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import lib.jdb.jdbquery.JDBQuery;
import principal.FrmLogin;

/**
 *
 * @author paulo
 */
public class iFrm_rep_lancamentos_conta_receber extends javax.swing.JInternalFrame {
    private JDBQuery qryPessoa;
    private String docPessoa;
    /**
     * Creates new form iFrm_rep_lancamentos_conta_receber
     */
    public iFrm_rep_lancamentos_conta_receber() {
        qryPessoa = new JDBQuery();
        qryPessoa.setJDBConnection(principal.Principal.conexao.getConexao());
        qryPessoa.setConcurUpdatable(false);
        
        docPessoa = "";
        
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
        lblInc = new javax.swing.JLabel();
        lblMod = new javax.swing.JLabel();
        calDataInicio = new lib.jdb.control.jdbcalendar.JDBCalendar();
        calDataFim = new lib.jdb.control.jdbcalendar.JDBCalendar();
        txtCliente = new javax.swing.JTextField();
        lblInc1 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();
        cbxTipo = new javax.swing.JComboBox();
        btnGerar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Relatório de contas a receber");

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

        lblInc.setFont(principal.FrmLogin.fontePadrao);
        lblInc.setText("Data Inicio:");

        lblMod.setFont(principal.FrmLogin.fontePadrao);
        lblMod.setText("Data Final:");

        calDataInicio.setDateFormat("dd/MM/yyyy");
        calDataInicio.setTextEditable(false);
        calDataInicio.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                calDataInicioAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        calDataFim.setDateFormat("dd/MM/yyyy");
        calDataFim.setTextEditable(false);
        calDataFim.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                calDataFimAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtCliente.setFocusable(false);

        lblInc1.setFont(principal.FrmLogin.fontePadrao);
        lblInc1.setText("Cliente");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnTodos.setText("Todos");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aberto", "Fechado" }));

        javax.swing.GroupLayout pnDatasLayout = new javax.swing.GroupLayout(pnDatas);
        pnDatas.setLayout(pnDatasLayout);
        pnDatasLayout.setHorizontalGroup(
            pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatasLayout.createSequentialGroup()
                        .addComponent(txtCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTodos))
                    .addComponent(lblInc1)
                    .addGroup(pnDatasLayout.createSequentialGroup()
                        .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblInc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDatasLayout.createSequentialGroup()
                                .addComponent(lblMod)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnDatasLayout.createSequentialGroup()
                                .addComponent(calDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxTipo, 0, 184, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnDatasLayout.setVerticalGroup(
            pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInc)
                    .addComponent(lblMod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(calDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(calDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(lblInc1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar)
                    .addComponent(btnTodos))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        calDataInicio.setText("");
        calDataFim.setText("");
        cbxTipo.setSelectedIndex(0);
        
        docPessoa = "";
        txtCliente.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void calDataInicioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_calDataInicioAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_calDataInicioAncestorAdded

    private void calDataFimAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_calDataFimAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_calDataFimAncestorAdded

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // campos para combobox sendo texto visual e o nome campo do banco referente.
        LinkedHashMap<String, String> combo = new LinkedHashMap<>();
        combo.put("Nome", "nome");
        combo.put("Documento", "doc_principal");

        // titulos para as colunas da tabela, sendo texto visual e nome campo do banco referente.
        LinkedHashMap<String, String> titulo = new LinkedHashMap<>();
        titulo.put("NOME", "nome");
        titulo.put("DOCUMENTO", "doc_principal");

        // campos que deseja deixar invisível, pode-se omitir.
        String[] invisivel = null;

        // tamanho das colunas visíveis, pode-se omitir.
        //        int[] tamanho = {200, 400};

        pesquisa.iFrmPesquisa pessoa;
        pessoa = new pesquisa.iFrmPesquisa(this,
            "Pesquisa de pessoas",
            principal.Principal.conexao.getConexao(),
            qryPessoa,
            "doc_principal",
            combo,
            titulo,
            "SELECT doc_principal, nome FROM vw_clientes_pesquisa_venda",
            invisivel,
            null);

        principal.FrmPrincipal.Desktop.add(pessoa);
        pessoa.setVisible(true);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        txtCliente.setText("");
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        if(calDataInicio.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Informe a data inicial");
        }else if(calDataFim.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Informe a data final");
        }else{
            String where, ordenacao, titulo;
            if(cbxTipo.getSelectedIndex() == 0){
                // contas abertas/sem pagamento
                where = String.format(
                        "WHERE data_pagamento IS NULL "
                        + "AND (data_vencimento BETWEEN '%s' AND '%s') ",
                        calDataInicio.getDateAsSQLDate(), 
                        calDataFim.getDateAsSQLDate());
                ordenacao = "ORDER BY doc_principal_cliente, data_vencimento ";
                titulo = "abertas";
            }else{
                // contas fechadas/com pagamento
                where = String.format(
                        "WHERE data_pagamento IS NOT NULL "
                        + "AND (data_pagamento BETWEEN '%s' AND '%s') ",
                        calDataInicio.getDateAsSQLDate(), 
                        calDataFim.getDateAsSQLDate());
                ordenacao = "ORDER BY doc_principal_cliente, data_pagamento ";
                titulo = "fechadas";
            }
            
            if(!txtCliente.getText().isEmpty()){
                where += String.format(
                        "AND doc_principal_cliente = '%s' ",
                        docPessoa);
            }
            
            where += ordenacao;
            
            relatorio.Relatorios.rep_lancamentos_conta_receber_cliente(
                calDataInicio.getDateAsSQLDate(),
                calDataFim.getDateAsSQLDate(),
                where,
                titulo);

            // registro de log
            FrmLogin.log.gravar(
                FrmLogin.usuario.getNomeUsuario(),
                "iFrm_rep_lancamentos_conta_receber",
                docPessoa,
                "emitido relatório");
        }
    }//GEN-LAST:event_btnGerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lib.jdb.control.jdbbuttoncancel.JDBButtonCancel btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnTodos;
    private lib.jdb.control.jdbcalendar.JDBCalendar calDataFim;
    private lib.jdb.control.jdbcalendar.JDBCalendar calDataInicio;
    private javax.swing.JComboBox cbxTipo;
    private javax.swing.JLabel lblInc;
    private javax.swing.JLabel lblInc1;
    private javax.swing.JLabel lblMod;
    private javax.swing.JPanel pnDados;
    private javax.swing.JPanel pnDatas;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables

    public void atribuirCampos(){
        docPessoa = qryPessoa.getCurrentFieldValueAsString("doc_principal");
        txtCliente.setText(qryPessoa.getCurrentFieldValueAsString("nome"));
    }
    
}
