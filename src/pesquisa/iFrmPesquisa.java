/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisa;

import java.util.LinkedHashMap;
import lib.jdb.connection.JDBConnection;
import lib.jdb.jdbquery.JDBQuery;
import sistema.PesquisaSimples;

/**
 *
 * @author patri
 */
public class iFrmPesquisa extends javax.swing.JInternalFrame {
    private final PesquisaSimples pesq;
    private Object form;

    // exemplo de alimentação do construtor
//        txtDesc.requestFocus();
//        
//        // campos para combobox sendo texto visual e o nome campo do banco referente.
//        LinkedHashMap<String, String> combo = new LinkedHashMap<>();
//        combo.put("Descrição", "descricao");
//        combo.put("Fornecedor", "nome_fornecedor");
//        combo.put("Código","id");
//        
//        // titulos para as colunas da tabela, sendo texto visual e nome campo do banco referente.
//        HashMap<String, String> titulo = new HashMap<>();
//        titulo.put("DESCRIÇÃO", "descricao");
//        titulo.put("FORCENEDOR", "nome_fornecedor");
//        titulo.put("CÓDIGO", "id");
//
//        // campos que deseja deixar invisível, pode-se omitir.
//        String[] invisivel = {"doc_principal_fornecedor" ,"data_inclusao", "data_modificacao"};
//
//        // tamanho das colunas visíveis, pode-se omitir.
////        int[] tamanho = {200, 400};
//        
//        pesquisa.iFrmPesquisa marcas;
//        marcas = new pesquisa.iFrmPesquisa(this,
//                "Pesquisa de Marcas",
//                principal.Principal.conexao.getConexao(),
//                qryMarca,
//                "id",
//                combo,
//                titulo,
//                "SELECT id, descricao, doc_principal_fornecedor, "
//                        + "nome_fornecedor, data_inclusao, data_modificacao "
//                        + "FROM vw_marcas",
//                invisivel,
//                null);
//
//        
//        principal.FrmPrincipal.Desktop.add(marcas);
//        marcas.setVisible(true);                

    public iFrmPesquisa(String tituloJanela) {
        initComponents();
        title = tituloJanela;
        pesq = null;
    }
    
    public iFrmPesquisa(Object form,
            String tituloJanela,
            JDBConnection conexao,
            JDBQuery qryOrigem,
            String chave,
            LinkedHashMap<String,String> valorComboBox, 
            LinkedHashMap<String,String> titulos,
            String sql,
            String[] camposInvisiveis, 
            int[] larguraCamposVisiveis) {
        
        initComponents();
        title = tituloJanela;
        this.form = form;
        
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
        
//        txtPesquisa.requestFocus();
    }
    
    public iFrmPesquisa(String tituloJanela,
            JDBConnection conexao, 
            JDBQuery qryOrigem,
            String chave,
            LinkedHashMap<String,String> valorComboBox, 
            LinkedHashMap<String,String> titulos,
            String sql,
            String[] camposInvisiveis) {
        
        initComponents();
        title = tituloJanela;
        
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
        
//        txtPesquisa.requestFocus();
    }
    
    public iFrmPesquisa(String tituloJanela,
            JDBConnection conexao, 
            JDBQuery qryOrigem,
            String chave,
            LinkedHashMap<String,String> valorComboBox, 
            LinkedHashMap<String,String> titulos,
            String sql, 
            int[] larguraCamposVisiveis) {
        
        initComponents();
        title = tituloJanela;
        
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
        
//        txtPesquisa.requestFocus();
    }
    
    public iFrmPesquisa(String tituloJanela,
            JDBConnection conexao, 
            JDBQuery qryOrigem,
            String chave,
            LinkedHashMap<String,String> valorComboBox, 
            LinkedHashMap<String,String> titulos,
            String sql) {
        
        initComponents();
        title = tituloJanela;
        
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
        
//        txtPesquisa.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDBQuery1 = new lib.jdb.jdbquery.JDBQuery();
        Painel = new javax.swing.JPanel();
        btnPesquisa = new javax.swing.JButton();
        scrlPesquisa = new javax.swing.JScrollPane();
        tblPesquisa = new lib.jdb.control.jdbtable.JDBTable();
        txtPesquisa = new javax.swing.JTextField();
        cbxPesquisa = new javax.swing.JComboBox<String>();
        lblQuantidadeItens = new javax.swing.JLabel();
        lblContador = new lib.jdb.control.jdblabelcount.JDBLabelCount();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pesquisar");
        setPreferredSize(new java.awt.Dimension(530, 418));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        Painel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        btnPesquisa.setFont(principal.FrmLogin.fontePadrao);
        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/look.png"))); // NOI18N
        btnPesquisa.setText("Pesquisar");
        btnPesquisa.setNextFocusableComponent(tblPesquisa);
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        scrlPesquisa.setFont(principal.FrmLogin.fontePadrao);

        tblPesquisa.setAutoCreateRowSorter(true);
        tblPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblPesquisa.setEditable(false);
        tblPesquisa.setFont(principal.FrmLogin.fontePadrao);
        tblPesquisa.setToolTipText("Duplo clique ou ENTER para carregar o registro");
        tblPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblPesquisaKeyPressed(evt);
            }
        });
        tblPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesquisaMouseClicked(evt);
            }
        });
        scrlPesquisa.setViewportView(tblPesquisa);

        txtPesquisa.setFont(principal.FrmLogin.fontePadrao);
        txtPesquisa.setToolTipText("Pressione ENTER para pesquisar");
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
        });

        cbxPesquisa.setFont(principal.FrmLogin.fontePadrao);
        cbxPesquisa.setToolTipText("Escolha um item para pesquisar");

        lblQuantidadeItens.setFont(principal.FrmLogin.fontePadrao);
        lblQuantidadeItens.setText("Quantidade de itens:");

        lblContador.setFont(principal.FrmLogin.fontePadrao);
        lblContador.setText("jDBLabelCount1");

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addComponent(txtPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisa))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblQuantidadeItens)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblContador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisa)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrlPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidadeItens)
                    .addComponent(lblContador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        setBounds(0, 0, 600, 418);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        pesq.pesquisar(cbxPesquisa, txtPesquisa);
        txtPesquisa.requestFocus();
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        if(evt.getKeyChar() == '\n'){
            pesq.pesquisar(cbxPesquisa, txtPesquisa);
            
            // testar(vários formulários) melhor para implementar
            pesq.getQryPesquisa().last();
            if(pesq.getQryPesquisa().getRow() == 1){
                
                pesq.getQryPesquisa().first();
                
                if(sistema.Mensagem.showConfirmDialog(this,
                    String.format("Sua pesquisa retornou somente um registro.\n"
                            + "Carregar o registro de código %s?",
                            pesq.getQryPesquisa().getCurrentFieldValueAsString(1)),
                    "Confirmação") == 0){
                    
                    carregarPesquisaSelecionada();
                }
            }
        }
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void tblPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesquisaMouseClicked
        if(evt.getClickCount() == 2){
            // criado método para carregar pesquisa, substituindo código anteriormente alocado aqui.
            carregarPesquisaSelecionada();
        }
    }//GEN-LAST:event_tblPesquisaMouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        txtPesquisa.requestFocus();
    }//GEN-LAST:event_formFocusGained

    private void tblPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPesquisaKeyPressed
        if(evt.getKeyChar() == '\n'){
            carregarPesquisaSelecionada();
        }
    }//GEN-LAST:event_tblPesquisaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JComboBox<String> cbxPesquisa;
    private lib.jdb.jdbquery.JDBQuery jDBQuery1;
    private lib.jdb.control.jdblabelcount.JDBLabelCount lblContador;
    private javax.swing.JLabel lblQuantidadeItens;
    private javax.swing.JScrollPane scrlPesquisa;
    private lib.jdb.control.jdbtable.JDBTable tblPesquisa;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
    
    private void carregarPesquisaSelecionada(){
        
        pesq.gerarQryPesquisa();

        //Atribuindo campos do formulário origem(deve haver um método 
        //atribuirCampos no formulário origem, pegando os resultado da
        //query e atribuindo nos campos do formulário).
        //Deve ter um if para cada formulário que usar a pesquisa genérica;
        if(form instanceof estoque.iFrmCadUnidade){
            estoque.iFrmCadUnidade cadUnid = (estoque.iFrmCadUnidade)form;
            cadUnid.atribuirCampos();
        }else if(form instanceof pessoa.iFrmCadTipoUsuario){
            pessoa.iFrmCadTipoUsuario cadTipoUs = (pessoa.iFrmCadTipoUsuario)form;
            cadTipoUs.atribuirCampos();
        }else if(form instanceof estoque.iFrmCadProduto){
            estoque.iFrmCadProduto cadProd = (estoque.iFrmCadProduto)form;
            cadProd.atribuirCampos();
        }else if(form instanceof estoque.iFrmCadCategoriaProd){
            estoque.iFrmCadCategoriaProd cadCatProd = (estoque.iFrmCadCategoriaProd)form;
            cadCatProd.atribuirCampos();
        }else if(form instanceof estoque.iFrmCadMarca){
            estoque.iFrmCadMarca cadMarca = (estoque.iFrmCadMarca)form;
            cadMarca.atribuirCampos();
        }else if(form instanceof estoque.iFrmCadTinta){
            estoque.iFrmCadTinta cadTinta = (estoque.iFrmCadTinta)form;
            cadTinta.atribuirCampos();
        }else if(form instanceof estoque.iFrmCadCategoriaTinta){
            estoque.iFrmCadCategoriaTinta cadCatTinta = (estoque.iFrmCadCategoriaTinta)form;
            cadCatTinta.atribuirCampos();
        }else if(form instanceof estoque.iFrmCadTipoTinta){
            estoque.iFrmCadTipoTinta cadTipoTinta = (estoque.iFrmCadTipoTinta)form;
            cadTipoTinta.atribuirCampos();
        }else if(form instanceof estoque.iFrmCadMontadora){
            estoque.iFrmCadMontadora cadMont = (estoque.iFrmCadMontadora)form;
            cadMont.atribuirCampos();
        }else if(form instanceof estoque.iFrmCompra){
            estoque.iFrmCompra cadCompra = (estoque.iFrmCompra)form;
            cadCompra.atribuirCampos();
        }else if(form instanceof financeiro.iFrmChequeCartao){
            financeiro.iFrmChequeCartao cadChCt = (financeiro.iFrmChequeCartao)form;
            cadChCt.atribuirCampos();
        }else if(form instanceof financeiro.iFrmFormasPagamento){
            financeiro.iFrmFormasPagamento cadFormPgto = (financeiro.iFrmFormasPagamento)form;
            cadFormPgto.atribuirCampos();
        }else if(form instanceof estoque.iFrmCadPromocoes){
            // no frmCadPromocoes é usado a pesquisa genérica para carregar um produto.
            estoque.iFrmCadPromocoes cadPromocao = (estoque.iFrmCadPromocoes)form;
            cadPromocao.atribuirProduto();
        }else if(form instanceof estoque.iFrmVendas){
            estoque.iFrmVendas vendas = (estoque.iFrmVendas)form;
            vendas.atribuirVenda();
        }else if(form instanceof principal.iFrmPermTipoUsuario){
            principal.iFrmPermTipoUsuario permissao = (principal.iFrmPermTipoUsuario)form;
            permissao.atribuirCampos();
        }else if(form instanceof principal.iFrmConfiguracoes){
            principal.iFrmConfiguracoes config = (principal.iFrmConfiguracoes)form;
            config.atribuirCampos();
        }else if(form instanceof financeiro.iFrmContas){
            financeiro.iFrmContas contas = (financeiro.iFrmContas)form;
            contas.atribuirCampos();
        }else if(form instanceof financeiro.iFrmChequeCartao){
            financeiro.iFrmChequeCartao controleChCt = (financeiro.iFrmChequeCartao)form;
            controleChCt.atribuirCampos();
        }else if(form instanceof principal.iFrmHistorico){
            principal.iFrmHistorico historico = (principal.iFrmHistorico)form;
            historico.atribuirCampos();
        }else if(form instanceof financeiro.iFrmDespesas){
            financeiro.iFrmDespesas despesas = (financeiro.iFrmDespesas)form;
            despesas.atribuirCampos();
        }else if(form instanceof relatorio.iFrm_rep_comissao){
            relatorio.iFrm_rep_comissao relat = (relatorio.iFrm_rep_comissao)form;
            relat.atribuirCampos();
        }else if(form instanceof relatorio.iFrm_rep_lancamentos_conta_receber){
            relatorio.iFrm_rep_lancamentos_conta_receber relat = (relatorio.iFrm_rep_lancamentos_conta_receber)form;
            relat.atribuirCampos();
        }else if(form instanceof relatorio.iFrm_rep_lancamentos_conta_pagar){
            relatorio.iFrm_rep_lancamentos_conta_pagar relat = (relatorio.iFrm_rep_lancamentos_conta_pagar)form;
            relat.atribuirCampos();
        }else if(form instanceof relatorio.iFrm_rep_producao_tinta){
            relatorio.iFrm_rep_producao_tinta relat = (relatorio.iFrm_rep_producao_tinta)form;
            relat.atribuirCampos();
        }else if(form instanceof relatorio.iFrm_rep_vendas_total){
            relatorio.iFrm_rep_vendas_total relat = (relatorio.iFrm_rep_vendas_total)form;
            relat.atribuirCampos();
        }else if(form instanceof relatorio.iFrm_rep_produtos_vendidos){
            relatorio.iFrm_rep_produtos_vendidos relat = (relatorio.iFrm_rep_produtos_vendidos)form;
            relat.atribuirCampos();
        }else if(form instanceof relatorio.iFrm_rep_produtos_completo){
            relatorio.iFrm_rep_produtos_completo relat = (relatorio.iFrm_rep_produtos_completo)form;
            relat.atribuirCampos();
        }else if(form instanceof relatorio.iFrm_rep_historico){
            relatorio.iFrm_rep_historico relat = (relatorio.iFrm_rep_historico)form;
            relat.atribuirCampos();
        }else if(form instanceof relatorio.iFrm_rep_pessoas){
            relatorio.iFrm_rep_pessoas relat = (relatorio.iFrm_rep_pessoas)form;
            relat.atribuirCampos();
        }else if(form instanceof relatorio.iFrm_rep_controle_ch_ct){
            relatorio.iFrm_rep_controle_ch_ct relat = (relatorio.iFrm_rep_controle_ch_ct)form;
            relat.atribuirCampos();
        }else if(form instanceof relatorio.iFrm_rep_despesas){
            relatorio.iFrm_rep_despesas relat = (relatorio.iFrm_rep_despesas)form;
            relat.atribuirCampos();
        }else if(form instanceof relatorio.iFrm_rep_compras_total){
            relatorio.iFrm_rep_compras_total relat = (relatorio.iFrm_rep_compras_total)form;
            relat.atribuirCampos();
        }

        // fecha pesquisa.
        doDefaultCloseAction();
//            dispose();
    }
}
