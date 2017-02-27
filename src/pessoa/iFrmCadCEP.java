/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoa;

import javax.swing.JOptionPane;
import lib.jdb.jdbquery.JDBQuery;
import lib.jdb.jdbupdate.JDBUpdate;

/**
 *
 * @author paulo
 */
public class iFrmCadCEP extends javax.swing.JInternalFrame {
    private JDBQuery qryEstado;
    private String cep_origem;
    private pessoa.iFrmCadPessoa cadPessoa;
    private boolean pessoa;
    
    /**
     * Creates new form iFrmCadCEP
     */
    public iFrmCadCEP(pessoa.iFrmCadPessoa cadPessoa, String cep, boolean pessoa) {
        cep_origem = cep;
        this.cadPessoa = cadPessoa;
        this.pessoa = pessoa;
        
        qryEstado = new JDBQuery();
        qryEstado.setJDBConnection(principal.Principal.conexao.getConexao());
        qryEstado.setConcurUpdatable(false);
        
        qryEstado.setSQL("SELECT uf, nome_estado FROM estados");
        
        initComponents();
        
        if(!cep_origem.isEmpty()){
            mskCEP.setValue(cep);
        }
        
        cbxEstado.setJDBListQuery(qryEstado);
        cbxEstado.setInvisibleFields("uf");
        
        qryEstado.execQuery();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxEstado = new lib.jdb.control.jdblistcombobox.JDBListComboBox();
        mskCEP = new lib.jdb.control.jdbmaskedtextfield.JDBMaskedTextField();
        lblCEP = new javax.swing.JLabel();
        txtLocalidade = new javax.swing.JTextField();
        lblCEP2 = new javax.swing.JLabel();
        lblCEP3 = new javax.swing.JLabel();
        btnSalvar_Pes = new lib.jdb.control.jdbbuttonsave.JDBButtonSave();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de localidade");

        mskCEP.setFont(principal.FrmLogin.fontePadrao);
        mskCEP.setMask("#####-###");
        mskCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mskCEPFocusLost(evt);
            }
        });

        lblCEP.setFont(principal.FrmLogin.fontePadrao);
        lblCEP.setText("CEP:");

        lblCEP2.setFont(principal.FrmLogin.fontePadrao);
        lblCEP2.setText("Localidade/cidade:");

        lblCEP3.setFont(principal.FrmLogin.fontePadrao);
        lblCEP3.setText("Estado:");

        btnSalvar_Pes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document_add.png"))); // NOI18N
        btnSalvar_Pes.setMnemonic('s');
        btnSalvar_Pes.setFont(principal.FrmLogin.fontePadrao);
        btnSalvar_Pes.setText("Salvar");
        btnSalvar_Pes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar_PesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar_Pes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCEP)
                        .addComponent(mskCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLocalidade)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                    .addComponent(lblCEP2)
                    .addComponent(lblCEP3))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblCEP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mskCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCEP2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCEP3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar_Pes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mskCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mskCEPFocusLost
        
    }//GEN-LAST:event_mskCEPFocusLost

    private void btnSalvar_PesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar_PesActionPerformed
        if(String.valueOf(mskCEP.getValue().toString()).isEmpty()){
            JOptionPane.showMessageDialog(this, "Informe um CEP", "Atenção", 
                    JOptionPane.INFORMATION_MESSAGE);
            mskCEP.requestFocus();
        }else if(txtLocalidade.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Informe uma localidade/cidade", 
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            txtLocalidade.requestFocus();
        }else if(cbxEstado.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Selecione uma categoria", 
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            cbxEstado.requestFocus();
        }else{
            String sql, cep;
            cep = sistema.CNP.removerMascara(mskCEP.getText());
            
            sql = String.format(
                    "INSERT INTO localidades(cep, localidade, estado) "
                    + "VALUES ('%s','%s','%s')",
                    cep, txtLocalidade.getText(), qryEstado.getCurrentFieldValueAsString("uf"));
            
            enviarTransacao(sql);
            
            cadPessoa.recuperarEndereco(pessoa);
            
            doDefaultCloseAction();
        }
    }//GEN-LAST:event_btnSalvar_PesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lib.jdb.control.jdbbuttonsave.JDBButtonSave btnSalvar_Pes;
    private lib.jdb.control.jdblistcombobox.JDBListComboBox cbxEstado;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCEP2;
    private javax.swing.JLabel lblCEP3;
    private lib.jdb.control.jdbmaskedtextfield.JDBMaskedTextField mskCEP;
    private javax.swing.JTextField txtLocalidade;
    // End of variables declaration//GEN-END:variables
    
    private boolean enviarTransacao(String sql){
        JDBUpdate transacao = new JDBUpdate();
        transacao.setJDBConnection(principal.Principal.conexao.getConexao());

        transacao.setSQL(sql);
        transacao.setShowMessageOnError(false);
        
        boolean concluido = transacao.execUpdate();
        // Se a transação retornar erro:
        if(!concluido){
            //1062: Violação de primary key ou unique
            if(transacao.getErrorCode() == 1062){
                JOptionPane.showMessageDialog(this, 
                        "CEP já cadastrado", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        return concluido;
    }
}
