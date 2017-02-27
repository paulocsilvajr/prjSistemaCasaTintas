package sistema;

import java.util.HashMap;
import java.util.LinkedHashMap;
import lib.jdb.connection.JDBConnection;
import lib.jdb.jdbquery.JDBQuery;

/**
 * Clase de pesquisa para uso genérico.
 * Informar os parametros de acordo com a necessidade.
 * O combobox mantem a ordem informada no parametro valorComboBox.
 * @author paulo
 */

public class FrmPesquisa extends javax.swing.JFrame {
    private final PesquisaSimples pesq;
    
    /**
     * Método construtor do formulário de pesquisa simples genérico.
     * @param conexao Conexao JDBConnection para alimentar query interna.
     * @param qryOrigem JDBQuery que será atribuida após a seleção da pesquisa.
     * @param chave Campo chave primária da tabela informada em sql.
     * @param valorComboBox LinkedHashMap dos valores do combobox de 
     * pesquisa(chave=Descrição, valor=campo equivalente). LinkedHashMap mantem a ordem informada.
     * @param titulos HashMap dos títulos das colunas da tabela(chave=Descrição, valor=campo equivalente).
     * @param sql Consulta base. Deve conter somente SELECT campo1, campo2, ... FROM tabela ou view;
     * @param camposInvisiveis Vetor de campos que não serão visíveis na tabela, pode-se omitir.
     * @param larguraCamposVisiveis Vetor de tamanhos inteiros das colunas da tabela, pode-se omitir. 
     * Quando informado deve ser a mesma quantidade de campos visíveis.
     */
    public FrmPesquisa(JDBConnection conexao,
            JDBQuery qryOrigem,
            String chave,
            LinkedHashMap<String,String> valorComboBox, 
            HashMap<String,String> titulos,
            String sql,
            String[] camposInvisiveis, 
            int[] larguraCamposVisiveis) {
        
        initComponents();
        
        pesq = new PesquisaSimples(
                conexao, 
                qryOrigem, 
                chave, 
                valorComboBox, 
                titulos, 
                sql, 
                camposInvisiveis, 
                larguraCamposVisiveis);
        
        pesq.dadosIniciais(cbxPesquisa, tblPesquisa, lblContador);
    }
    
    public FrmPesquisa(JDBConnection conexao, 
            JDBQuery qryOrigem,
            String chave,
            LinkedHashMap<String,String> valorComboBox, 
            HashMap<String,String> titulos,
            String sql,
            String[] camposInvisiveis) {
        
        initComponents();
        
        pesq = new PesquisaSimples(
                conexao, 
                qryOrigem, 
                chave, 
                valorComboBox, 
                titulos, 
                sql, 
                camposInvisiveis, 
                null);
        
        pesq.dadosIniciais(cbxPesquisa, tblPesquisa, lblContador);
    }
    
    public FrmPesquisa(JDBConnection conexao, 
            JDBQuery qryOrigem,
            String chave,
            LinkedHashMap<String,String> valorComboBox, 
            HashMap<String,String> titulos,
            String sql, 
            int[] larguraCamposVisiveis) {
        
        initComponents();
        
        pesq = new PesquisaSimples(
                conexao, 
                qryOrigem, 
                chave, 
                valorComboBox, 
                titulos, 
                sql, 
                null, 
                larguraCamposVisiveis);
        
        pesq.dadosIniciais(cbxPesquisa, tblPesquisa, lblContador);
    }
    
    public FrmPesquisa(JDBConnection conexao, 
            JDBQuery qryOrigem,
            String chave,
            LinkedHashMap<String,String> valorComboBox, 
            HashMap<String,String> titulos,
            String sql) {
        
        initComponents();
        
        pesq = new PesquisaSimples(
                conexao, 
                qryOrigem, 
                chave, 
                valorComboBox, 
                titulos, 
                sql, 
                null, 
                null);
        
        pesq.dadosIniciais(cbxPesquisa, tblPesquisa, lblContador);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesquisa = new lib.jdb.control.jdbtable.JDBTable();
        lblContador = new lib.jdb.control.jdblabelcount.JDBLabelCount();
        btnPesquisar = new javax.swing.JButton();
        cbxPesquisa = new javax.swing.JComboBox<>();
        txtPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPesquisa.setEditable(false);
        tblPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesquisaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesquisa);

        lblContador.setText("jDBLabelCount1");

        btnPesquisar.setMnemonic('p');
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
        });

        jLabel1.setText("Quant. itens:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblContador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(cbxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        pesq.pesquisar(cbxPesquisa, txtPesquisa);
        txtPesquisa.requestFocus();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        if(evt.getKeyChar() == '\n'){
            pesq.pesquisar(cbxPesquisa, txtPesquisa);
        }
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void tblPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesquisaMouseClicked
        if(evt.getClickCount() == 2){
            pesq.gerarQryPesquisa();

            // fecha pesquisa.
            dispose();
        }
    }//GEN-LAST:event_tblPesquisaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmPesquisa().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cbxPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private lib.jdb.control.jdblabelcount.JDBLabelCount lblContador;
    private lib.jdb.control.jdbtable.JDBTable tblPesquisa;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
