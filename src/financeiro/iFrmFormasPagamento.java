/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import lib.jdb.jdbquery.JDBQuery;
import lib.jdb.jdbupdate.JDBUpdate;
import principal.FrmLogin;

/**
 *
 * @author patri
 */
public class iFrmFormasPagamento extends javax.swing.JInternalFrame {
    private JDBQuery qryFormPgto;
    private boolean alteracao = false;
    private String id;   
    private DecimalFormat decimal;
    private NumberFormatter numFormatter;
    DefaultFormatterFactory dfFactory;
    
    
    /**
     * Creates new form iFrmFormasPagamento
     */
    public iFrmFormasPagamento() {
        
        
        
        qryFormPgto = new JDBQuery();
        qryFormPgto.setJDBConnection(principal.Principal.conexao.getConexao());   
        initComponents();
        
       // qryFormPgto.execQuery();
        limpar();
        
        decimal = new DecimalFormat("0.00");        
        NumberFormatter numFormatter = new NumberFormatter(decimal);
        numFormatter.setFormat(decimal);
        numFormatter.setAllowsInvalid(false);
        dfFactory = new DefaultFormatterFactory(numFormatter);
        
        txtJuros.setFormatterFactory(dfFactory);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel = new javax.swing.JPanel();
        pnCodigo = new javax.swing.JPanel();
        txtID = new lib.jdb.control.jdbtextfield.JDBTextField();
        lblDesc = new javax.swing.JLabel();
        txtDesc = new lib.jdb.control.jdbtextfield.JDBTextField();
        lblNumParcela = new javax.swing.JLabel();
        txtNumParcela = new lib.jdb.control.jdbtextfield.JDBTextField();
        lblPrazo = new javax.swing.JLabel();
        txtPrazo = new lib.jdb.control.jdbtextfield.JDBTextField();
        lblJuros = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JPanel();
        lblInc = new javax.swing.JLabel();
        txtInc = new lib.jdb.control.jdbtextfield.JDBTextField();
        lblMod = new javax.swing.JLabel();
        txtMod = new lib.jdb.control.jdbtextfield.JDBTextField();
        lblNumParcela1 = new javax.swing.JLabel();
        cbxEspecie = new javax.swing.JComboBox<>();
        btnRemover = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtJuros = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        chbDesconto = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Formas de Pagamento");

        Painel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));

        pnCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "Código", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        txtID.setFocusable(false);
        txtID.setFont(principal.FrmLogin.fontePadrao);

        javax.swing.GroupLayout pnCodigoLayout = new javax.swing.GroupLayout(pnCodigo);
        pnCodigo.setLayout(pnCodigoLayout);
        pnCodigoLayout.setHorizontalGroup(
            pnCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCodigoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCodigoLayout.setVerticalGroup(
            pnCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCodigoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        lblDesc.setFont(principal.FrmLogin.fontePadrao);
        lblDesc.setText("Descrição:");

        txtDesc.setFont(principal.FrmLogin.fontePadrao);

        lblNumParcela.setFont(principal.FrmLogin.fontePadrao);
        lblNumParcela.setText("Nº. Parcelas:");

        txtNumParcela.setFont(principal.FrmLogin.fontePadrao);
        txtNumParcela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumParcelaFocusLost(evt);
            }
        });

        lblPrazo.setFont(principal.FrmLogin.fontePadrao);
        lblPrazo.setText("Prazo(dias):");

        txtPrazo.setFont(principal.FrmLogin.fontePadrao);
        txtPrazo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrazoFocusLost(evt);
            }
        });

        lblJuros.setFont(principal.FrmLogin.fontePadrao);
        lblJuros.setText("Acréscimo(%):");

        btnConsultar.setFont(principal.FrmLogin.fontePadrao);
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/look.png"))); // NOI18N
        btnConsultar.setMnemonic('C');
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnSalvar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "Datas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        lblInc.setFont(principal.FrmLogin.fontePadrao);
        lblInc.setText("Inclusão:");

        txtInc.setFocusable(false);

        lblMod.setFont(principal.FrmLogin.fontePadrao);
        lblMod.setText("Modificação:");

        txtMod.setFocusable(false);

        javax.swing.GroupLayout btnSalvarLayout = new javax.swing.GroupLayout(btnSalvar);
        btnSalvar.setLayout(btnSalvarLayout);
        btnSalvarLayout.setHorizontalGroup(
            btnSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSalvarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInc)
                    .addComponent(txtInc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMod, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMod))
                .addContainerGap())
        );
        btnSalvarLayout.setVerticalGroup(
            btnSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalvarLayout.createSequentialGroup()
                .addGroup(btnSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(btnSalvarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblInc))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, btnSalvarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblMod)))
                .addGap(11, 11, 11)
                .addGroup(btnSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        lblNumParcela1.setFont(principal.FrmLogin.fontePadrao);
        lblNumParcela1.setText("Espécie:");

        cbxEspecie.setFont(principal.FrmLogin.fontePadrao);
        cbxEspecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Cheque", "Cartão", "Crediário" }));
        cbxEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEspecieActionPerformed(evt);
            }
        });

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        btnRemover.setMnemonic('r');
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed1(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return2.png"))); // NOI18N
        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtJuros.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        chbDesconto.setText("Desconto");
        chbDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbDescontoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(pnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblDesc)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRemover))
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addComponent(lblNumParcela1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtNumParcela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNumParcela)
                                            .addComponent(cbxEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrazo)
                                    .addComponent(txtPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblJuros)
                                            .addComponent(txtJuros, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chbDesconto)))
                                .addGap(104, 104, 104)))))
                .addContainerGap())
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addComponent(lblNumParcela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addComponent(lblPrazo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addComponent(lblNumParcela1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                        .addComponent(lblJuros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJuros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbDesconto))))
                .addGap(4, 4, 4)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(btnRemover)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(10, 10, 10))
        );

        PainelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnConsultar, btnRemover});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        limpar();
        
        txtDesc.requestFocus();
        
        // campos para combobox sendo texto visual e o nome campo do banco referente.
        LinkedHashMap<String, String> combo = new LinkedHashMap<>();
        combo.put("Descrição", "descricao");//fazer pesquisa....1 nome campocbox, 2 tabela
        combo.put("Espécie","desc_especie");

        // titulos para as colunas da tabela, sendo texto visual e nome campo do banco referente.
        LinkedHashMap<String, String> titulo = new LinkedHashMap<>();
        titulo.put("CÓDIGO","id");
        titulo.put("DESCRIÇÃO", "descricao");//titulos da tabela
        titulo.put("ESPÉCIE", "desc_especie");
        titulo.put("Nº PARCELAS","numero_parcelas");
        titulo.put("PRAZO","prazo");
        titulo.put("JUROS", "juros");

        // campos que deseja deixar invisível, pode-se omitir.
        String[] invisivel = {"data_inclusao", "data_modificacao","especie"};

        // tamanho das colunas visíveis, pode-se omitir.
       //int[] tamanho = {50, 150, 110, 75, 30, 100};
        
        pesquisa.iFrmPesquisa forPgto;
        forPgto = new pesquisa.iFrmPesquisa(this,
                "Pesquisa de Formas de Pagamento",
                principal.Principal.conexao.getConexao(),
                qryFormPgto,
                "id",//chave primary teria que alterar
                combo,
                titulo,
                "SELECT id,descricao,especie,desc_especie,numero_parcelas,prazo,juros,"
                        + " data_inclusao,data_modificacao FROM vw_formas_pagamento_finac",
                //consulta do banco ...com todos os campos
                
                invisivel,
                null);//null do tamanho, se mudar coloca tamanho

        
        principal.FrmPrincipal.Desktop.add(forPgto);
        forPgto.setVisible(true);   
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void cbxEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEspecieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEspecieActionPerformed

    private void btnRemoverActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed1
        if(FrmLogin.usuario.verificarPermissao(this, 2)){
        
            if(alteracao){
                if(sistema.Mensagem.showConfirmDialog(this,
                        "Deseja realmente excluir esta forma de pagamento?", "Confirmação") == 0){

                    String sql = String.format("DELETE FROM formas_pagamento WHERE id = '%s'", id);

                    if(enviarTransacao(sql)){
                    
                        // registro de log
                        FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                                    this, id, 3);
                    }

                    limpar();
                }
            }else{
                JOptionPane.showMessageDialog(this, 
                        "Consulte uma forma de pagamento para excluir", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);

                btnConsultar.requestFocus();
            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed1

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpar();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    //quando perder o foco 
    private void txtNumParcelaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumParcelaFocusLost
        if(!txtNumParcela.getText().isEmpty()){
            if(!txtNumParcela.getText().matches("^[1-9][0-9]*$")){
               JOptionPane.showMessageDialog(this, 
                        "Favor informar numero maior que zero", "Atenção",
                        JOptionPane.INFORMATION_MESSAGE);
               txtNumParcela.requestFocus();

            }
        }
    }//GEN-LAST:event_txtNumParcelaFocusLost

    private void txtPrazoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrazoFocusLost
          if(!txtPrazo.getText().isEmpty()){
            if(!txtPrazo.getText().matches("^[0-9]+$")){
               JOptionPane.showMessageDialog(this, 
                        "Favor informar numero maior que zero", "Atenção",
                        JOptionPane.INFORMATION_MESSAGE);
               txtPrazo.requestFocus();

            }
        }
    }//GEN-LAST:event_txtPrazoFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(FrmLogin.usuario.verificarPermissao(this, 1)){
            
            if(txtDesc.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, 
                        "Informe a descrição", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
                txtDesc.requestFocus();
            }else if(txtDesc.getText().length() > 30){
                JOptionPane.showMessageDialog(this, 
                        "A descrição deve ter no máximo 30 caracteres", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
                txtDesc.requestFocus();
            }else if(txtNumParcela.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, 
                        "Informe o numero de parcela", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
                txtNumParcela.requestFocus();
            }else if(txtPrazo.getText().isEmpty ()){
                JOptionPane.showMessageDialog(this, 
                        "Informe o prazo", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
                txtPrazo.requestFocus();
            }else if(Double.valueOf(txtJuros.getValue().toString()) > 100.0 ){
               JOptionPane.showMessageDialog(this, 
                        "Juros não pode ser maior que 100%!", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
                txtJuros.requestFocus();
            }else{
                String sql;
                if(alteracao){
                    if(sistema.Mensagem.showConfirmDialog(this,
                        "Deseja realmente alterar essa forma de pagamento?", "Confirmação") == 0){

                        sql = String.format(
                              "UPDATE formas_pagamento "
                                + "SET descricao='%s',"
                                    + "especie=%s,"
                                    + "numero_parcelas=%s,"
                                    + "prazo='%s',"
                                    + "juros='%s' "
                                    + "WHERE id = '%s'", 
                              txtDesc.getText(),
                              cbxEspecie.getSelectedIndex(),
                              txtNumParcela.getText(),
                              txtPrazo.getText(),
                              txtJuros.getValue(),
                              id);

                        if(enviarTransacao(sql)){
                        
                            // registro de log
                            FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                                    this, id, 2);
                        }

                    }
                }else{
                    sql = String.format("INSERT INTO formas_pagamento("
                            + "descricao, "
                            + "especie, "
                            + "numero_parcelas, "
                            + "prazo, "
                            + "juros) "
                            + "VALUES ("
                            + "'%s',%s,%s,'%s','%s')",
                              txtDesc.getText(),
                              cbxEspecie.getSelectedIndex(),
                              txtNumParcela.getText(),
                              txtPrazo.getText(),
                              txtJuros.getValue());                
                    if(enviarTransacao(sql)){
                    
                        JDBQuery temp = new JDBQuery();
                        temp.setJDBConnection(principal.Principal.conexao.getConexao());
                        temp.setSQL("SELECT LAST_INSERT_ID()");
                        temp.execQuery();
                        String idFP = temp.getCurrentFieldValueAsString(1);

                        // registro de log
                            FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                                    this,idFP, 1);
                    }
                }

                limpar();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void chbDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbDescontoActionPerformed
        if(chbDesconto.isSelected() && 
                Double.valueOf(txtJuros.getText().replaceAll(",", ".")) > 0.0){
            txtJuros.setValue(Double.valueOf(txtJuros.getText().replaceAll(",", ".")) * -1);
        }else if(!chbDesconto.isSelected() && 
                Double.valueOf(txtJuros.getText().replaceAll(",", ".")) < 0.0){
            txtJuros.setValue(Double.valueOf(txtJuros.getText().replaceAll(",", ".")) * -1);
        }
    }//GEN-LAST:event_chbDescontoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JPanel btnSalvar;
    private javax.swing.JComboBox<String> cbxEspecie;
    private javax.swing.JCheckBox chbDesconto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblInc;
    private javax.swing.JLabel lblJuros;
    private javax.swing.JLabel lblMod;
    private javax.swing.JLabel lblNumParcela;
    private javax.swing.JLabel lblNumParcela1;
    private javax.swing.JLabel lblPrazo;
    private javax.swing.JPanel pnCodigo;
    private lib.jdb.control.jdbtextfield.JDBTextField txtDesc;
    private lib.jdb.control.jdbtextfield.JDBTextField txtID;
    private lib.jdb.control.jdbtextfield.JDBTextField txtInc;
    private javax.swing.JFormattedTextField txtJuros;
    private lib.jdb.control.jdbtextfield.JDBTextField txtMod;
    private lib.jdb.control.jdbtextfield.JDBTextField txtNumParcela;
    private lib.jdb.control.jdbtextfield.JDBTextField txtPrazo;
    // End of variables declaration//GEN-END:variables
    
    public void atribuirCampos(){
        // captura os valor da query resultante da pesquisa e atribui nos campos. Ex:
        // String nomeCampoFormulario = query.getCurrentFieldValueAsString("nomeCampoTabelaReferente");
        // elemento.setText(nomeCampoFormulario);
        String id, nome,descricao,data_inclusao,data_modificacao;
        
        float juros;
        int especie,numero_parcelas, prazo;
        
        id = qryFormPgto.getCurrentFieldValueAsString("id");
        descricao = qryFormPgto.getCurrentFieldValueAsString("descricao");
        data_inclusao = qryFormPgto.getCurrentFieldValueAsString("data_inclusao");
        data_modificacao = qryFormPgto.getCurrentFieldValueAsString("data_modificacao");
        
        especie = qryFormPgto.getCurrentFieldValueAsInteger("especie");
        numero_parcelas = qryFormPgto.getCurrentFieldValueAsInteger("numero_parcelas");
        prazo = qryFormPgto.getCurrentFieldValueAsInteger("prazo");
                
        juros = qryFormPgto.getCurrentFieldValueAsFloat("juros") == null ?
                0:qryFormPgto.getCurrentFieldValueAsFloat("juros");
                
        txtID.setText(id);
        txtDesc.setText(descricao);
        txtInc.setText(data_inclusao);
        txtMod.setText(data_modificacao);
        cbxEspecie.setSelectedIndex(especie);
        txtNumParcela.setText(String.valueOf(numero_parcelas));
        txtPrazo.setText(String.valueOf(prazo));
        txtJuros.setText(String.format("%.3f", juros));
        
        if(juros < 0){
            chbDesconto.setSelected(true);
        }
        
        alteracao = true;
        this.id = id;  
        
        
        
        
    }

    private void limpar() {
        txtID.setText("");
        txtDesc.setText("");
        txtInc.setText("");
        txtMod.setText("");
        cbxEspecie.setSelectedIndex(0);
        txtNumParcela.setText("");
        txtPrazo.setText("");
        txtJuros.setValue(0.0);
        chbDesconto.setSelected(false);

         alteracao = false;
         id = "";
    }
        
    private boolean enviarTransacao(String sql){
        JDBUpdate transacao = new JDBUpdate();
        transacao.setJDBConnection(principal.Principal.conexao.getConexao());

        transacao.setSQL(sql);
        transacao.setShowMessageOnError(false);
        
        boolean concluido = transacao.execUpdate();
        // Se a transação retornar erro:
        if(!concluido){
            //1451: Violação de foreign key, contém relacionamento
            if(transacao.getErrorCode() == 1451){
                JOptionPane.showMessageDialog(this, 
                        "Forma de pagamento com relacionamento, não pode ser excluída", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);                
            }
        }      
        
        return concluido;
        
    }
        
 }
