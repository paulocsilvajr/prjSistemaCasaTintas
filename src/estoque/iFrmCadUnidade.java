/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import lib.jdb.jdbquery.JDBQuery;
import lib.jdb.jdbupdate.JDBUpdate;
import principal.FrmLogin;

/**
 *
 * @author patri
 */
public class iFrmCadUnidade extends javax.swing.JInternalFrame {
    private JDBQuery qryUnidade;
    private boolean alteracao = false;
    private String sigla;

    /**
     * Creates new form iFrmCadCategoriaProd
     */
    public iFrmCadUnidade() {
        qryUnidade = new JDBQuery();
        qryUnidade.setJDBConnection(principal.Principal.conexao.getConexao());
//        qryUnidade.setSQL("SELECT"
//                + " sigla, descricao, data_inclusao, data_modificacao "
//                + "FROM unidades;");
//        qryUnidade.execQuery();
        
        
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

        Painel = new javax.swing.JPanel();
        btnSalvar = new lib.jdb.control.jdbbuttonsave.JDBButtonSave();
        btnCancelar = new lib.jdb.control.jdbbuttoncancel.JDBButtonCancel();
        lblDesc = new javax.swing.JLabel();
        txtDesc = new lib.jdb.control.jdbtextfield.JDBTextField();
        pnCodigo = new javax.swing.JPanel();
        txtID = new lib.jdb.control.jdbtextfield.JDBTextField();
        btnConsultar = new javax.swing.JButton();
        lib.jdb.control.jdbbuttondelete.JDBButtonDelete btnRemover = new lib.jdb.control.jdbbuttondelete.JDBButtonDelete();
        pnDatas = new javax.swing.JPanel();
        lblInc = new javax.swing.JLabel();
        txtInc = new lib.jdb.control.jdbtextfield.JDBTextField();
        lblMod = new javax.swing.JLabel();
        txtMod = new lib.jdb.control.jdbtextfield.JDBTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Unidade");

        Painel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnSalvar.setMnemonic('s');
        btnSalvar.setFont(principal.FrmLogin.fontePadrao);
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return2.png"))); // NOI18N
        btnCancelar.setMnemonic('l');
        btnCancelar.setFont(principal.FrmLogin.fontePadrao);
        btnCancelar.setText("Limpar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblDesc.setFont(principal.FrmLogin.fontePadrao);
        lblDesc.setText("Descrição:");

        txtDesc.setFieldName("descricao");
        txtDesc.setFont(principal.FrmLogin.fontePadrao);

        pnCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "Sigla", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        txtID.setFieldName("sigla");
        txtID.setFont(principal.FrmLogin.fontePadrao);

        javax.swing.GroupLayout pnCodigoLayout = new javax.swing.GroupLayout(pnCodigo);
        pnCodigo.setLayout(pnCodigoLayout);
        pnCodigoLayout.setHorizontalGroup(
            pnCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCodigoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnCodigoLayout.setVerticalGroup(
            pnCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCodigoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        btnConsultar.setFont(principal.FrmLogin.fontePadrao);
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/look.png"))); // NOI18N
        btnConsultar.setMnemonic('c');
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnRemover.setMnemonic('r');
        btnRemover.setText("Remover");
        btnRemover.setFont(principal.FrmLogin.fontePadrao);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed1(evt);
            }
        });

        pnDatas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "Datas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        lblInc.setFont(principal.FrmLogin.fontePadrao);
        lblInc.setText("Inclusão:");

        txtInc.setFocusable(false);

        lblMod.setFont(principal.FrmLogin.fontePadrao);
        lblMod.setText("Modificação:");

        txtMod.setFocusable(false);

        javax.swing.GroupLayout pnDatasLayout = new javax.swing.GroupLayout(pnDatas);
        pnDatas.setLayout(pnDatasLayout);
        pnDatasLayout.setHorizontalGroup(
            pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInc)
                    .addComponent(txtInc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatasLayout.createSequentialGroup()
                        .addComponent(lblMod)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatasLayout.createSequentialGroup()
                        .addComponent(txtMod, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnDatasLayout.setVerticalGroup(
            pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatasLayout.createSequentialGroup()
                .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnDatasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDatasLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblInc)
                            .addComponent(lblMod))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(txtInc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addComponent(pnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addComponent(lblDesc)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnDatas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))))
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnDatas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar)
                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        txtID.requestFocus();
        
        // campos para combobox sendo texto visual e o nome campo do banco referente.
        LinkedHashMap<String, String> combo = new LinkedHashMap<>();
        combo.put("Sigla","sigla");
        combo.put("Descrição", "descricao");
        
        // titulos para as colunas da tabela, sendo texto visual e nome campo do banco referente.
        LinkedHashMap<String, String> titulo = new LinkedHashMap<>();
        titulo.put("SIGLA", "sigla");
        titulo.put("DESCRIÇÃO", "descricao");

        // campos que deseja deixar invisível, pode-se omitir.
        String[] invisivel = {"data_inclusao", "data_modificacao"};

        // tamanho das colunas visíveis, pode-se omitir.
//        int[] tamanho = {200, 400};
        
        // Construtor da pesquisa genérica
        pesquisa.iFrmPesquisa Unidade;
        Unidade = new pesquisa.iFrmPesquisa(this,
                "Pesquisa de Unidades",
                principal.Principal.conexao.getConexao(),
                qryUnidade,
                "sigla",
                combo,
                titulo,
                "SELECT sigla, descricao, data_inclusao, data_modificacao FROM unidades",
                invisivel,
                null);
        
        //adicionando ao DesktopPane principal
        principal.FrmPrincipal.Desktop.add(Unidade);
        //Exibindo a pesquisa
        Unidade.setVisible(true);        
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(FrmLogin.usuario.verificarPermissao(this, 1)){

            if(txtID.getText().isEmpty()){
                JOptionPane.showMessageDialog(iFrmCadUnidade.this, 
                        "Informe uma sigla", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
                txtID.requestFocus();
            }else if(txtDesc.getText().isEmpty()){
                JOptionPane.showMessageDialog(iFrmCadUnidade.this, 
                        "Informe uma descrição", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
                txtDesc.requestFocus();
            }else if(txtID.getText().length() != 2){
                JOptionPane.showMessageDialog(iFrmCadUnidade.this, 
                        "Sigla deve ter 2 caracteres", "Atenção",
                        JOptionPane.INFORMATION_MESSAGE);
                txtID.requestFocus();
            }else if(txtDesc.getText().length() > 15){
                JOptionPane.showMessageDialog(iFrmCadUnidade.this, 
                        "Descrição deve ter no máximo 15 caracteres", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
                txtDesc.requestFocus();
            }else{
                String sql;
                if(alteracao){
                    if(sistema.Mensagem.showConfirmDialog(iFrmCadUnidade.this,
                        "Deseja realmente alterar esta unidade?", "Confirmação") == 0){

                        sql = String.format(
                              "UPDATE unidades "
                              + "SET sigla='%s',descricao='%s' "
                              + "WHERE sigla = '%s'", 
                              txtID.getText(), txtDesc.getText(),
                              sigla);

                        if(enviarTransacao(sql)){
                        
                            // registro de log
                            FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                                    this, sigla, 2);
                        }
                    }
                }else{
                    sql = String.format(
                          "INSERT INTO unidades(" +
                          "sigla, descricao)" +
                          "VALUES('%s', '%s')", 
                          txtID.getText(), txtDesc.getText());
                    if(enviarTransacao(sql)){
                    
                        // registro de log
                        FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                               this, txtID.getText(), 1); 
                    }
                }

                limpar();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnRemoverActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed1
        if(FrmLogin.usuario.verificarPermissao(this, 2)){

            if(alteracao){
                if(sistema.Mensagem.showConfirmDialog(this,
                        "Deseja realmente excluir esta unidade?", "Confirmação") == 0){

                    String sql = String.format("DELETE FROM unidades WHERE sigla = '%s'", sigla);

                    if(enviarTransacao(sql)){
                    
                        // registro de log
                        FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                                    this, sigla, 3);
                    }

                    limpar();
                }
            }else{
                JOptionPane.showMessageDialog(this, 
                        "Consulte uma unidade para excluir", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);

                btnConsultar.requestFocus();
            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed1


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private lib.jdb.control.jdbbuttoncancel.JDBButtonCancel btnCancelar;
    private javax.swing.JButton btnConsultar;
    private lib.jdb.control.jdbbuttonsave.JDBButtonSave btnSalvar;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblInc;
    private javax.swing.JLabel lblMod;
    private javax.swing.JPanel pnCodigo;
    private javax.swing.JPanel pnDatas;
    private lib.jdb.control.jdbtextfield.JDBTextField txtDesc;
    private lib.jdb.control.jdbtextfield.JDBTextField txtID;
    private lib.jdb.control.jdbtextfield.JDBTextField txtInc;
    private lib.jdb.control.jdbtextfield.JDBTextField txtMod;
    // End of variables declaration//GEN-END:variables
    
    public void atribuirCampos(){
        String sigla, descricao, inclusao, modificacao;
        sigla = qryUnidade.getCurrentFieldValueAsString("sigla");
        descricao = qryUnidade.getCurrentFieldValueAsString("descricao");
        inclusao = qryUnidade.getCurrentFieldValueAsString("data_inclusao");
        modificacao = qryUnidade.getCurrentFieldValueAsString("data_modificacao");
        
        txtID.setText(sigla);
        txtDesc.setText(descricao);
        txtInc.setText(inclusao);
        txtMod.setText(modificacao);
        
        alteracao = true;
        this.sigla = sigla;
    }
    
    private void limpar(){
        txtID.setText("");
        txtDesc.setText("");
        txtInc.setText("");
        txtMod.setText("");
        
        alteracao = false;
        sigla = "";
        
        txtID.requestFocus();
    }
    
    private boolean enviarTransacao(String sql){
        JDBUpdate transacao = new JDBUpdate();
        transacao.setJDBConnection(principal.Principal.conexao.getConexao());

        transacao.setSQL(sql);
        transacao.setShowMessageOnError(false);
        
        boolean concluido = transacao.execUpdate();
        // Se a transação retornar erro:
        if(!concluido){
            //1062: Violação de primary key
            if(transacao.getErrorCode() == 1062){
                JOptionPane.showMessageDialog(this, 
                        "Sigla de unidade já cadastrada", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
            //1451: Violação de foreign key, contém relacionamento
            }else if(transacao.getErrorCode() == 1451){
                JOptionPane.showMessageDialog(this, 
                        "Sigla de unidade com relacionamento, não pode ser excluída", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);                
            }
                
        }
        
        return concluido;
    }
}
