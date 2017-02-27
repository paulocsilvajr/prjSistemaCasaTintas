/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
public class iFrmVendas extends javax.swing.JInternalFrame {
    private String idCliente = "", idVendedor = "";
    private int idProduto = 0, idVenda = 0, idItemVenda = 0, 
            idContaReceber = 0, idCaixa = 0, prazo = 0;
    private double quantOriginal = 0.0, comissaoProduto, juros = 0, valorParcelamento;
    private boolean pesquisaCliente = false, pesquisarProduto = false, pesquisaCaixa = false,
            novaVenda = true, alteracaoItensVenda = false, fracionado=false;
    private JDBQuery qryCliente, qryProduto, qryItensVenda, qryVenda, qryTemp, 
            qryFrmPgto, qryLancContasReceber, qryVwPromocoesAtivas, qryCaixa;
    private JDBUpdate update;

    /**
     * Creates new form iFrmVendas
     */
    public iFrmVendas() {
        idVendedor = FrmLogin.usuario.getNomeUsuario();
//        idCaixa = 1; // atribuido de acordo com escolha do usuário
        
        // ocultando menus e barra ferramentas
        principal.FrmPrincipal.Menu.setVisible(false);
        principal.FrmPrincipal.BarraFerramenta.setVisible(false);
        
        // Criação qryVendas e qryItensVenda
        qryVenda = new JDBQuery();
        qryVenda.setJDBConnection(principal.Principal.conexao.getConexao());
        qryVenda.setSQL(String.format(
                "SELECT id, data, doc_principal_cliente, "
                    + "nome_usuario, cancelada, data_modificacao "
                + "FROM vendas ORDER BY id DESC LIMIT 1"));
        qryVenda.setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
        
        qryItensVenda = new JDBQuery();
        qryItensVenda.setJDBConnection(principal.Principal.conexao.getConexao());
        qryItensVenda.setConcurUpdatable(false);
        
        // JDBUpdate usado para enviar INSERT, UPDATE E DELETE. 
        // Mudar setShowMessageOnError(true) para false quando finalizar venda.
        update = new JDBUpdate();
        update.setJDBConnection(principal.Principal.conexao.getConexao());
        update.setShowMessageOnError(true);
        
        // qryProduto
        qryProduto = new JDBQuery();
        qryProduto.setJDBConnection(principal.Principal.conexao.getConexao());
        qryProduto.setConcurUpdatable(false);
        
        // qryTemp, para uso em consultas temporárias
        qryTemp = new JDBQuery();
        qryTemp.setJDBConnection(principal.Principal.conexao.getConexao());
        qryTemp.setConcurUpdatable(false);
        
        //qryFormasPgto
        qryFrmPgto = new JDBQuery();
        qryFrmPgto.setJDBConnection(principal.Principal.conexao.getConexao());
        qryFrmPgto.setConcurUpdatable(false);
        qryFrmPgto.setSQL(
                "SELECT id, descricao, especie, desc_especie, numero_parcelas, prazo, juros "
                + "FROM vw_formas_pagamento");
        
        //qryContasReceber
        qryLancContasReceber = new JDBQuery();
        qryLancContasReceber.setJDBConnection(principal.Principal.conexao.getConexao());
        qryLancContasReceber.setConcurUpdatable(false);
        
        // qryVwPromocoesAtivas
        qryVwPromocoesAtivas = new JDBQuery();
        qryVwPromocoesAtivas.setJDBConnection(principal.Principal.conexao.getConexao());
        qryVwPromocoesAtivas.setConcurUpdatable(false);
        
        //qryCaixa
        qryCaixa = new JDBQuery();
        qryCaixa.setJDBConnection(principal.Principal.conexao.getConexao());
        qryCaixa.setConcurUpdatable(false);
        
        initComponents();
        
        // execução da qryVenda; qryItensVenda somente é executado após cada CRUD.
        qryVenda.execQuery();
        
        // definindo campos invisíveis do cbxFormaPag e executando qry formas de pagamento
        cbxFormaPag.setInvisibleFields("id especie numero_parcelas prazo juros");
        qryFrmPgto.execQuery();
        
        txtCliente.requestFocus();
        
        // definindo mascara para os jFormattedTextField
//        DecimalFormat decimal = new DecimalFormat("#######.00#");        
        DecimalFormat decimal = new DecimalFormat("######0.000"); 
        NumberFormatter numFormatter = new NumberFormatter(decimal);
        numFormatter.setFormat(decimal);
        numFormatter.setAllowsInvalid(false);
        DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatter);
        // guia vendas
        txtQuantidade.setFormatterFactory(dfFactory);
        txtValorUnitario.setFormatterFactory(dfFactory);
        txtValorTotal.setFormatterFactory(dfFactory);
        txtValorCrediario.setFormatterFactory(dfFactory);
        txtValorDh.setFormatterFactory(dfFactory);
        txtValorChCt.setFormatterFactory(dfFactory);
        //guia parcelas
        txtTotalVendaParc.setFormatterFactory(dfFactory);
        txtValorParc.setFormatterFactory(dfFactory);
        txtValorDh.setFormatterFactory(dfFactory);
        txtValorChCt.setFormatterFactory(dfFactory);
        txtValorCrediario.setFormatterFactory(dfFactory);
        txtTotalVendaJuros.setFormatterFactory(dfFactory);
        
        // limpeza inicial da venda
        limparVenda();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVenda = new javax.swing.JTabbedPane();
        pnVenda = new javax.swing.JPanel();
        pnCodigo = new javax.swing.JPanel();
        txtID = new lib.jdb.control.jdbtextfield.JDBTextField();
        lblData = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        scrlVenda = new javax.swing.JScrollPane();
        tbVenda = new lib.jdb.control.jdbtable.JDBTable();
        pnInf = new javax.swing.JPanel();
        lblProduto = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        lblUnidade = new javax.swing.JLabel();
        lblValorUni = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        pnCodigo2 = new javax.swing.JPanel();
        txtIdProduto = new lib.jdb.control.jdbtextfield.JDBTextField();
        btnAdicionar = new lib.jdb.control.jdbbuttonsave.JDBButtonSave();
        btnLimpar = new lib.jdb.control.jdbbuttoncancel.JDBButtonCancel();
        txtProduto = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JFormattedTextField();
        btnPesqProduto = new javax.swing.JButton();
        txtValorUnitario = new javax.swing.JFormattedTextField();
        txtValorTotal = new javax.swing.JFormattedTextField();
        btnRemover = new javax.swing.JButton();
        btnProx = new lib.jdb.control.jdbbuttonsave.JDBButtonSave();
        txtUsuario = new lib.jdb.control.jdbtextfield.JDBTextField();
        txtCliente = new javax.swing.JTextField();
        btnPesqCliente = new javax.swing.JButton();
        lblVenda = new javax.swing.JLabel();
        txtTotal = new javax.swing.JFormattedTextField();
        txtData = new javax.swing.JTextField();
        btnCancelarVenda = new javax.swing.JButton();
        txtCaixa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnPesquisarCaixa = new javax.swing.JButton();
        pnParcela = new javax.swing.JPanel();
        lblFormaPag = new javax.swing.JLabel();
        cbxFormaPag = new lib.jdb.control.jdblistcombobox.JDBListComboBox();
        pnCrediario = new javax.swing.JPanel();
        lblValor_Cred = new javax.swing.JLabel();
        lblParcelas_Cred = new javax.swing.JLabel();
        btnSalvar_Cred = new lib.jdb.control.jdbbuttonsave.JDBButtonSave();
        btnRemover_Cred = new lib.jdb.control.jdbbuttondelete.JDBButtonDelete();
        txtValorCrediario = new javax.swing.JFormattedTextField();
        cbxParcCrediario = new javax.swing.JComboBox();
        txtValorCrediarioJuros = new javax.swing.JFormattedTextField();
        lblCredito = new javax.swing.JLabel();
        pnCartaoCheque = new javax.swing.JPanel();
        lblValor_CC = new javax.swing.JLabel();
        lblParcelas_CC = new javax.swing.JLabel();
        lblDadosAdic_CC = new javax.swing.JLabel();
        btnSalvar_CC = new lib.jdb.control.jdbbuttonsave.JDBButtonSave();
        btnRemover_CC = new lib.jdb.control.jdbbuttondelete.JDBButtonDelete();
        txtValorChCt = new javax.swing.JFormattedTextField();
        cbxParcChCt = new javax.swing.JComboBox();
        txtValorChCtJuros = new javax.swing.JFormattedTextField();
        lblChequeCartao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDadosAdic_CC = new javax.swing.JTextArea();
        pnDinheiro = new javax.swing.JPanel();
        lblValor_Din = new javax.swing.JLabel();
        btnSalvar_Din = new lib.jdb.control.jdbbuttonsave.JDBButtonSave();
        btnRemover_Din = new lib.jdb.control.jdbbuttondelete.JDBButtonDelete();
        txtValorDh = new javax.swing.JFormattedTextField();
        txtValorDhDesconto = new javax.swing.JFormattedTextField();
        lblDinheiro = new javax.swing.JLabel();
        scrlParcela = new javax.swing.JScrollPane();
        tbParcela = new lib.jdb.control.jdbtable.JDBTable();
        btnConfirmar = new javax.swing.JButton();
        btnConcluirV = new lib.jdb.control.jdbbuttonsave.JDBButtonSave();
        txtTotalVendaParc = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtValorParc = new javax.swing.JFormattedTextField();
        lblFormaPag1 = new javax.swing.JLabel();
        btnCancelarVendaParc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTotalVendaJuros = new javax.swing.JFormattedTextField();
        btnCancelarParcelas = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Vendas");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        pnlVenda.setEnabled(false);
        pnlVenda.setNextFocusableComponent(txtID);

        pnVenda.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));

        pnCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "Código", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        txtID.setFocusable(false);
        txtID.setFont(principal.FrmLogin.fontePadrao);

        javax.swing.GroupLayout pnCodigoLayout = new javax.swing.GroupLayout(pnCodigo);
        pnCodigo.setLayout(pnCodigoLayout);
        pnCodigoLayout.setHorizontalGroup(
            pnCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCodigoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnCodigoLayout.setVerticalGroup(
            pnCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCodigoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        lblData.setFont(principal.FrmLogin.fontePadrao);
        lblData.setText("Data:");

        lblCliente.setFont(principal.FrmLogin.fontePadrao);
        lblCliente.setText("Cliente:");

        lblUsuario.setFont(principal.FrmLogin.fontePadrao);
        lblUsuario.setText("Vendedor:");

        scrlVenda.setFont(principal.FrmLogin.fontePadrao);

        tbVenda.setJDBQuery(qryItensVenda);
        tbVenda.setEditable(false);
        tbVenda.setInvisibleFields("id\nid_venda\ncomissao");
        tbVenda.setToolTipText("Clique para modificar o item");
        tbVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbVendaKeyPressed(evt);
            }
        });
        tbVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVendaMouseClicked(evt);
            }
        });
        scrlVenda.setViewportView(tbVenda);

        pnInf.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        lblProduto.setFont(principal.FrmLogin.fontePadrao);
        lblProduto.setText("Produto:");

        lblQuantidade.setFont(principal.FrmLogin.fontePadrao);
        lblQuantidade.setText("Quantidade:");

        lblUnidade.setFont(principal.FrmLogin.fontePadrao);
        lblUnidade.setText("Unidade");

        lblValorUni.setFont(principal.FrmLogin.fontePadrao);
        lblValorUni.setText("Valor unitário(R$):");

        lblValorTotal.setFont(principal.FrmLogin.fontePadrao);
        lblValorTotal.setText("Valor total(R$):");

        pnCodigo2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "Código", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        txtIdProduto.setFocusable(false);
        txtIdProduto.setFont(principal.FrmLogin.fontePadrao);

        javax.swing.GroupLayout pnCodigo2Layout = new javax.swing.GroupLayout(pnCodigo2);
        pnCodigo2.setLayout(pnCodigo2Layout);
        pnCodigo2Layout.setHorizontalGroup(
            pnCodigo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCodigo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIdProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnCodigo2Layout.setVerticalGroup(
            pnCodigo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCodigo2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart_add.png"))); // NOI18N
        btnAdicionar.setMnemonic('A');
        btnAdicionar.setFont(principal.FrmLogin.fontePadrao);
        btnAdicionar.setNextFocusableComponent(btnLimpar);
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return2.png"))); // NOI18N
        btnLimpar.setMnemonic('l');
        btnLimpar.setFont(principal.FrmLogin.fontePadrao);
        btnLimpar.setNextFocusableComponent(btnRemover);
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProdutoKeyPressed(evt);
            }
        });

        txtQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtQuantidade.setNextFocusableComponent(btnAdicionar);
        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusLost(evt);
            }
        });

        btnPesqProduto.setFont(principal.FrmLogin.fontePadrao);
        btnPesqProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/look.png"))); // NOI18N
        btnPesqProduto.setMnemonic('c');
        btnPesqProduto.setText("Pesquisar");
        btnPesqProduto.setNextFocusableComponent(txtQuantidade);
        btnPesqProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqProdutoActionPerformed(evt);
            }
        });

        txtValorUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtValorUnitario.setFocusable(false);

        txtValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtValorTotal.setFocusable(false);

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        btnRemover.setMnemonic('r');
        btnRemover.setText("Remover");
        btnRemover.setNextFocusableComponent(txtProduto);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed1(evt);
            }
        });

        javax.swing.GroupLayout pnInfLayout = new javax.swing.GroupLayout(pnInf);
        pnInf.setLayout(pnInfLayout);
        pnInfLayout.setHorizontalGroup(
            pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInfLayout.createSequentialGroup()
                        .addGroup(pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnInfLayout.createSequentialGroup()
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUnidade))
                            .addComponent(lblQuantidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValorUni)
                            .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValorTotal)
                            .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(pnInfLayout.createSequentialGroup()
                        .addComponent(lblProduto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesqProduto)
                .addGap(18, 18, 18)
                .addGroup(pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnInfLayout.setVerticalGroup(
            pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnInfLayout.createSequentialGroup()
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnInfLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnInfLayout.createSequentialGroup()
                                .addComponent(pnCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(pnInfLayout.createSequentialGroup()
                                .addComponent(lblProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPesqProduto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnInfLayout.createSequentialGroup()
                                        .addGroup(pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblValorUni)
                                            .addComponent(lblValorTotal))
                                        .addGap(33, 33, 33))
                                    .addGroup(pnInfLayout.createSequentialGroup()
                                        .addComponent(lblQuantidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblUnidade)
                                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnProx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_right.png"))); // NOI18N
        btnProx.setMnemonic('P');
        btnProx.setFont(principal.FrmLogin.fontePadrao);
        btnProx.setText("Próxima Etapa");
        btnProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxActionPerformed(evt);
            }
        });

        txtUsuario.setFocusable(false);
        txtUsuario.setFont(principal.FrmLogin.fontePadrao);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtCliente.setNextFocusableComponent(btnPesqCliente);
        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClienteKeyPressed(evt);
            }
        });

        btnPesqCliente.setFont(principal.FrmLogin.fontePadrao);
        btnPesqCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/look.png"))); // NOI18N
        btnPesqCliente.setMnemonic('c');
        btnPesqCliente.setText("Pesquisar");
        btnPesqCliente.setNextFocusableComponent(txtProduto);
        btnPesqCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqClienteActionPerformed(evt);
            }
        });

        lblVenda.setFont(principal.FrmLogin.fontePadraoNegrito);
        lblVenda.setText("Total da venda(R$):");

        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtTotal.setFocusable(false);
        txtTotal.setNextFocusableComponent(btnAdicionar);

        txtData.setFocusable(false);

        btnCancelarVenda.setText("Cancelar");
        btnCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVendaActionPerformed(evt);
            }
        });

        txtCaixa.setToolTipText("Somente caixas abertos no dia corrente e do tipo normal podem ser usados nas vendas");
        txtCaixa.setFocusable(false);

        jLabel3.setText("Caixa:");

        btnPesquisarCaixa.setFont(principal.FrmLogin.fontePadrao);
        btnPesquisarCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/look.png"))); // NOI18N
        btnPesquisarCaixa.setMnemonic('c');
        btnPesquisarCaixa.setText("Pesquisar");
        btnPesquisarCaixa.setNextFocusableComponent(txtProduto);
        btnPesquisarCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCaixaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnVendaLayout = new javax.swing.GroupLayout(pnVenda);
        pnVenda.setLayout(pnVendaLayout);
        pnVendaLayout.setHorizontalGroup(
            pnVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnInf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrlVenda, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnVendaLayout.createSequentialGroup()
                        .addGroup(pnVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCaixa)
                            .addComponent(lblData)
                            .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnVendaLayout.createSequentialGroup()
                                .addComponent(btnPesquisarCaixa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblVenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnVendaLayout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addGap(281, 281, 281)
                                .addComponent(lblUsuario))
                            .addGroup(pnVendaLayout.createSequentialGroup()
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesqCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnVendaLayout.setVerticalGroup(
            pnVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnVendaLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(pnVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnVendaLayout.createSequentialGroup()
                        .addGroup(pnVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblData)
                            .addComponent(lblCliente)
                            .addComponent(lblUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesqCliente)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelarVenda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnProx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVenda)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btnPesquisarCaixa))))
                .addGap(10, 10, 10)
                .addComponent(scrlVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlVenda.addTab("Venda", pnVenda);

        pnParcela.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));
        pnParcela.setPreferredSize(new java.awt.Dimension(750, 448));

        lblFormaPag.setFont(principal.FrmLogin.fontePadrao);
        lblFormaPag.setText("Forma de pagamento:");

        cbxFormaPag.setJDBListQuery(qryFrmPgto);
        cbxFormaPag.setFont(principal.FrmLogin.fontePadrao);
        cbxFormaPag.setKeyListField("id");
        cbxFormaPag.setNextFocusableComponent(btnConfirmar);

        pnCrediario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "Crediário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        lblValor_Cred.setFont(principal.FrmLogin.fontePadrao);
        lblValor_Cred.setText("Valor(R$):");

        lblParcelas_Cred.setFont(principal.FrmLogin.fontePadrao);
        lblParcelas_Cred.setText("Parcelas:");

        btnSalvar_Cred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnSalvar_Cred.setFont(principal.FrmLogin.fontePadrao);
        btnSalvar_Cred.setText("Salvar");
        btnSalvar_Cred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar_CredActionPerformed(evt);
            }
        });

        btnRemover_Cred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnRemover_Cred.setText("Cancelar");
        btnRemover_Cred.setFont(principal.FrmLogin.fontePadrao);
        btnRemover_Cred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover_CredActionPerformed(evt);
            }
        });
        btnRemover_Cred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover_CredActionPerformed(evt);
            }
        });

        txtValorCrediario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtValorCrediario.setFocusable(false);

        cbxParcCrediario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));

        txtValorCrediarioJuros.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtValorCrediarioJuros.setFocusable(false);

        lblCredito.setFont(principal.FrmLogin.fontePadrao);
        lblCredito.setText("Valor com acréscimo(R$):");

        javax.swing.GroupLayout pnCrediarioLayout = new javax.swing.GroupLayout(pnCrediario);
        pnCrediario.setLayout(pnCrediarioLayout);
        pnCrediarioLayout.setHorizontalGroup(
            pnCrediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCrediarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCrediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCrediarioLayout.createSequentialGroup()
                        .addGroup(pnCrediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCredito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtValorCrediarioJuros, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorCrediario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxParcCrediario, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnCrediarioLayout.createSequentialGroup()
                                .addComponent(lblParcelas_Cred)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(pnCrediarioLayout.createSequentialGroup()
                        .addGroup(pnCrediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCrediarioLayout.createSequentialGroup()
                                .addComponent(btnSalvar_Cred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemover_Cred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblValor_Cred))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        pnCrediarioLayout.setVerticalGroup(
            pnCrediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCrediarioLayout.createSequentialGroup()
                .addComponent(lblValor_Cred)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorCrediario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCredito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorCrediarioJuros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblParcelas_Cred)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxParcCrediario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCrediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar_Cred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover_Cred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pnCartaoCheque.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "Cartão/Cheque", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        lblValor_CC.setFont(principal.FrmLogin.fontePadrao);
        lblValor_CC.setText("Valor(R$):");

        lblParcelas_CC.setFont(principal.FrmLogin.fontePadrao);
        lblParcelas_CC.setText("Parcelas:");

        lblDadosAdic_CC.setFont(principal.FrmLogin.fontePadrao);
        lblDadosAdic_CC.setText("Dados adicionais:");

        btnSalvar_CC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnSalvar_CC.setFont(principal.FrmLogin.fontePadrao);
        btnSalvar_CC.setText("Salvar");
        btnSalvar_CC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar_CCActionPerformed(evt);
            }
        });

        btnRemover_CC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnRemover_CC.setText("Cancelar");
        btnRemover_CC.setFont(principal.FrmLogin.fontePadrao);
        btnRemover_CC.setNextFocusableComponent(btnConcluirV);
        btnRemover_CC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover_CCActionPerformed(evt);
            }
        });
        btnRemover_CC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover_CCActionPerformed(evt);
            }
        });

        txtValorChCt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtValorChCt.setFocusable(false);

        cbxParcChCt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));

        txtValorChCtJuros.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtValorChCtJuros.setFocusable(false);

        lblChequeCartao.setFont(principal.FrmLogin.fontePadrao);
        lblChequeCartao.setText("Valor com acréscimo(R$):");

        txaDadosAdic_CC.setColumns(20);
        txaDadosAdic_CC.setRows(5);
        jScrollPane1.setViewportView(txaDadosAdic_CC);

        javax.swing.GroupLayout pnCartaoChequeLayout = new javax.swing.GroupLayout(pnCartaoCheque);
        pnCartaoCheque.setLayout(pnCartaoChequeLayout);
        pnCartaoChequeLayout.setHorizontalGroup(
            pnCartaoChequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCartaoChequeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCartaoChequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValorChCt)
                    .addComponent(cbxParcChCt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtValorChCtJuros)
                    .addComponent(lblChequeCartao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCartaoChequeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCartaoChequeLayout.createSequentialGroup()
                        .addGroup(pnCartaoChequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValor_CC)
                            .addComponent(lblDadosAdic_CC)
                            .addComponent(lblParcelas_CC))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnCartaoChequeLayout.createSequentialGroup()
                        .addComponent(btnSalvar_CC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemover_CC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnCartaoChequeLayout.setVerticalGroup(
            pnCartaoChequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCartaoChequeLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblValor_CC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorChCt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblChequeCartao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValorChCtJuros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblParcelas_CC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxParcChCt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDadosAdic_CC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCartaoChequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover_CC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar_CC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnDinheiro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "Dinheiro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        lblValor_Din.setFont(principal.FrmLogin.fontePadrao);
        lblValor_Din.setText("Valor(R$):");

        btnSalvar_Din.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnSalvar_Din.setFont(principal.FrmLogin.fontePadrao);
        btnSalvar_Din.setText("Salvar");
        btnSalvar_Din.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar_DinActionPerformed(evt);
            }
        });

        btnRemover_Din.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnRemover_Din.setText("Cancelar");
        btnRemover_Din.setFont(principal.FrmLogin.fontePadrao);
        btnRemover_Din.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover_DinActionPerformed(evt);
            }
        });
        btnRemover_Din.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover_DinActionPerformed(evt);
            }
        });

        txtValorDh.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtValorDh.setFocusable(false);

        txtValorDhDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtValorDhDesconto.setFocusable(false);

        lblDinheiro.setFont(principal.FrmLogin.fontePadrao);
        lblDinheiro.setText("Valor com acréscimo(R$):");

        javax.swing.GroupLayout pnDinheiroLayout = new javax.swing.GroupLayout(pnDinheiro);
        pnDinheiro.setLayout(pnDinheiroLayout);
        pnDinheiroLayout.setHorizontalGroup(
            pnDinheiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDinheiroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDinheiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValorDhDesconto)
                    .addComponent(txtValorDh)
                    .addGroup(pnDinheiroLayout.createSequentialGroup()
                        .addGroup(pnDinheiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValor_Din)
                            .addComponent(lblDinheiro))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnDinheiroLayout.createSequentialGroup()
                        .addComponent(btnSalvar_Din, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnRemover_Din, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnDinheiroLayout.setVerticalGroup(
            pnDinheiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDinheiroLayout.createSequentialGroup()
                .addComponent(lblValor_Din)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorDh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDinheiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtValorDhDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDinheiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar_Din, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover_Din, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        scrlParcela.setFont(principal.FrmLogin.fontePadrao);

        tbParcela.setEditable(false);
        scrlParcela.setViewportView(tbParcela);

        btnConfirmar.setFont(principal.FrmLogin.fontePadrao);
        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/done.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setName(""); // NOI18N
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnConcluirV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart.png"))); // NOI18N
        btnConcluirV.setMnemonic('c');
        btnConcluirV.setFont(principal.FrmLogin.fontePadrao);
        btnConcluirV.setNextFocusableComponent(cbxFormaPag);
        btnConcluirV.setText("Concluir Venda");
        btnConcluirV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirVActionPerformed(evt);
            }
        });

        txtTotalVendaParc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtTotalVendaParc.setFocusable(false);

        jLabel1.setText("Total em venda(R$):");

        txtValorParc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtValorParc.setNextFocusableComponent(cbxFormaPag);
        txtValorParc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorParcFocusLost(evt);
            }
        });

        lblFormaPag1.setFont(principal.FrmLogin.fontePadrao);
        lblFormaPag1.setText("Valor de pagamento");

        btnCancelarVendaParc.setText("Cancelar");
        btnCancelarVendaParc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVendaParcActionPerformed(evt);
            }
        });

        jLabel2.setText("Total em parcelas(R$):");

        txtTotalVendaJuros.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00#"))));
        txtTotalVendaJuros.setFocusable(false);

        btnCancelarParcelas.setText("Cancelar parcelas");
        btnCancelarParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarParcelasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnParcelaLayout = new javax.swing.GroupLayout(pnParcela);
        pnParcela.setLayout(pnParcelaLayout);
        pnParcelaLayout.setHorizontalGroup(
            pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnParcelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtValorParc, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnCrediario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblFormaPag1)
                    .addComponent(pnDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnParcelaLayout.createSequentialGroup()
                        .addComponent(lblFormaPag)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnParcelaLayout.createSequentialGroup()
                        .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnCartaoCheque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxFormaPag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnParcelaLayout.createSequentialGroup()
                                .addGap(18, 229, Short.MAX_VALUE)
                                .addComponent(btnConcluirV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnParcelaLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnParcelaLayout.createSequentialGroup()
                                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCancelarVendaParc, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(scrlParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(pnParcelaLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnParcelaLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                        .addComponent(txtTotalVendaJuros, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnParcelaLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                        .addComponent(txtTotalVendaParc, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnParcelaLayout.createSequentialGroup()
                                        .addComponent(btnCancelarParcelas)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        pnParcelaLayout.setVerticalGroup(
            pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnParcelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormaPag1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar)
                    .addComponent(txtValorParc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarVendaParc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnParcelaLayout.createSequentialGroup()
                        .addComponent(scrlParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalVendaParc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalVendaJuros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarParcelas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConcluirV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnParcelaLayout.createSequentialGroup()
                        .addComponent(pnCrediario, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnDinheiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnCartaoCheque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlVenda.addTab("Parcela", pnParcela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlVenda)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxActionPerformed
        if(qryItensVenda.getRow() >= 1){
            if(sistema.Mensagem.showConfirmDialog(this, 
                    "Deseja realmente finalizar a venda?", "Confirmação") == 0){
                pnlVenda.setSelectedIndex(1);
                cbxFormaPag.requestFocus();

                txtValorParc.setValue(txtTotal.getValue());
                valorParcelamento = Double.valueOf(txtTotal.getValue().toString());
                txtTotalVendaParc.setValue(txtTotal.getValue());
                
                // criando conta a receber específica para esta venda e capturando
                // chave de contas a receber.
                update.setSQL(String.format(
                        "INSERT INTO contas_receber("
                            + "doc_principal_cliente, id_venda) "
                        + "VALUES ("
                            + "'%s','%s')", idCliente, idVenda));
                update.execUpdate();
                
                qryTemp.setSQL("SELECT LAST_INSERT_ID()");
                qryTemp.execQuery();
                
                idContaReceber = qryTemp.getCurrentFieldValueAsInteger(1);
                
                // criando qryLancContasReceber e vinculando a table
                qryLancContasReceber.setSQL(String.format(
                        "SELECT "
                            + "id, id_conta_receber, id_item_caixa, "
                            + "id_forma_pagamento, descricao, desc_especie, "
                            + "valor, data_vencimento, data_pagamento "
                        + "FROM "
                            + "vw_lancamentos_conta_receber "
                        + "WHERE id_conta_receber = %s ORDER BY id", idContaReceber));
                
                qryLancContasReceber.setDateFormat("dd/MM/yyyy");
//                qryLancContasReceber.setTimeFormat("dd/MM/yyyy hh:mm:ss");
                qryLancContasReceber.setLanguage("pt");
                
                tbParcela.setJDBQuery(qryLancContasReceber);
                tbParcela.setInvisibleFields(
                        "id id_conta_receber id_item_caixa "
                        + "id_forma_pagamento");
                tbParcela.setFieldsTitle("descricao", "DESC");
                tbParcela.setFieldsTitle("desc_especie", "TIPO");
                tbParcela.setFieldsTitle("valor", "VALOR");
                tbParcela.setFieldsTitle("data_vencimento", "VENC");
                tbParcela.setFieldsTitle("data_pagamento", "PGTO");
                
                tbParcela.setAutoResizeMode(tbParcela.AUTO_RESIZE_OFF);
                tbParcela.setFieldsWidth("descricao", 100);
                tbParcela.setFieldsWidth("desc_especie", 40);
                tbParcela.setFieldsWidth("valor", 100);
                tbParcela.setFieldsWidth("data_vencimento", 90);
                tbParcela.setFieldsWidth("data_pagamento", 90);
                
                qryLancContasReceber.execQuery();
            }
        }else{
            JOptionPane.showMessageDialog(this, 
                    "Adicione produto na venda", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            txtProduto.requestFocus();
        }
    }//GEN-LAST:event_btnProxActionPerformed

    private void btnConcluirVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirVActionPerformed
        if(FrmLogin.usuario.verificarPermissao(this, 1)){
            // compParcAtivos(componentes parcela ativos) verifica se todos o 
            // componente de valor estão ativo em cada painel de parcelamento. 
            boolean compParcAtivos = txtValorCrediario.isEnabled() && 
                    txtValorChCt.isEnabled() && txtValorDh.isEnabled();

            // Se existe pelo menos uma entrada de parcela e 
            // se o valor total a parcelar está zerado e
            // se nenhum dos compomentes de parcelamento estão ativos,
            // possibilita a conclusão da venda.
            if(qryLancContasReceber.getRow() >= 1 &&
                    Double.valueOf(txtValorParc.getValue().toString()) == 0.0 &&
                    !compParcAtivos){
                if(sistema.Mensagem.showConfirmDialog(this, 
                        "Concluir venda?", "Confirmação") == 0){
                    pnlVenda.setSelectedIndex(0);

                    // registrando o histórico
                    FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(), 
                            this, String.valueOf(idVenda), 1);
                    
                    String id_venda = String.valueOf(idVenda);
                    Double soma_venda, soma_parcela;
                    soma_venda = Double.valueOf(txtTotalVendaParc.getValue().toString());
                    soma_parcela = Double.valueOf(txtTotalVendaJuros.getValue().toString());
                    
                    limparVenda();

                    // fechando as transações aberta na criação da venda,
                    // gravando todas as modificações/inserções.
                    principal.Principal.conexao.fecharTransacoes();
                    
                    relatorio.Relatorios.rep_vendas(id_venda, soma_venda, soma_parcela);
                }
            }else{
                JOptionPane.showMessageDialog(this, 
                        "Informe pelo menos uma forma de pagamento para finalizar a venda",
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnConcluirVActionPerformed

    private void btnPesqProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqProdutoActionPerformed
//        if(!txtProduto.getText().isEmpty()){
        if(idProduto != 0){
            if(sistema.Mensagem.showConfirmDialog(this, 
                    "Deseja pesquisar um novo produto?", "Confirmação") == 0){
                txtProduto.setText("");
                pesquisarProduto();
            }
        }else{
            pesquisarProduto();
        }
    }//GEN-LAST:event_btnPesqProdutoActionPerformed

    private void btnPesqClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqClienteActionPerformed
//        if(!txtCliente.getText().isEmpty()){
        if(!idCliente.isEmpty()){
            if(sistema.Mensagem.showConfirmDialog(this, 
                    "Deseja pesquisar um novo cliente?", "Confirmação") == 0){
                txtCliente.setText("");
                
                pesquisarCliente();
            }
        }else{
            pesquisarCliente();
        }
    }//GEN-LAST:event_btnPesqClienteActionPerformed

    private void txtClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyPressed
        if(evt.getKeyChar() == '\n'){
            pesquisarCliente();
        }
    }//GEN-LAST:event_txtClienteKeyPressed

    private void txtProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdutoKeyPressed
        if(evt.getKeyChar() == '\n'){
            pesquisarProduto();
        }
    }//GEN-LAST:event_txtProdutoKeyPressed

    private void txtQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusLost
        double quantidade, valorUnitario, valorTotal;
        
        if(txtQuantidade.getText().equals("0,000")){
            quantidade = (double)0.0;
        }else{
            quantidade = Double.valueOf(txtQuantidade.getText().replaceAll(",", "."));
        }
        
        if(!fracionado && sistema.Verificador.decimal(quantidade)){
            JOptionPane.showMessageDialog(this, 
                    "Produto não aceita quantidade decimal.\n"
                    + "O sistema irá arredondar a quantidade.",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            
            quantidade = Math.floor(quantidade);
            txtQuantidade.setValue(quantidade);
        }
        
        valorUnitario = (double)txtValorUnitario.getValue();
        
        valorTotal = quantidade * valorUnitario;
        txtValorTotal.setValue(valorTotal);
    }//GEN-LAST:event_txtQuantidadeFocusLost

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // Somente vai adicionar um novo item na venda se tiver um cliente, um
        // produto carregado e um caixa selecionado.
        if(idCaixa == 0){
            JOptionPane.showMessageDialog(this, "Selecione um CAIXA",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            btnPesquisarCaixa.requestFocus();
        }else if(txtCliente.getText().isEmpty() || idCliente.isEmpty()){
            if(sistema.Mensagem.showConfirmDialog(this, "Não foi selecionado um cliente. \n"
                    + "Deseja carregar o cliente padrão?", "Atenção") == 0){
                txtCliente.setText(FrmLogin.conf.getValor(5));
                pesquisarCliente();
            }else{
//            JOptionPane.showMessageDialog(this, "Pesquise um CLIENTE para adicionar um produto",
//                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            txtCliente.requestFocus();
            }
        }else if(txtProduto.getText().isEmpty() || idProduto == 0){
            JOptionPane.showMessageDialog(this, "Pesquise um PRODUTO para adicionar à venda",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            txtProduto.requestFocus();
        }else{
            double quantidade, valor, valorTotalItem, valorLimiteCredito, 
                    valorTotalVenda, valorTotalDividaCrediario;
            quantidade = Double.valueOf(txtQuantidade.getValue().toString());
            valor = Double.valueOf(txtValorTotal.getValue().toString());
            valorTotalDividaCrediario = retornarDividaCrediario(this.idCliente);
            valorTotalVenda = Double.valueOf(txtTotal.getValue().toString());
            valorLimiteCredito = qryCliente.getCurrentFieldValueAsDouble("limite_credito");
            
            if(quantidade > 0.0){
                double estoque;
                if(alteracaoItensVenda){
                    estoque = retornarEstoqueProduto(idProduto) + quantOriginal;
                    valorTotalItem = valor - 
                            (quantOriginal * Double.valueOf(txtValorUnitario.getValue().toString()));
                }else{
                    estoque = retornarEstoqueProduto(idProduto);
                    valorTotalItem = valor;
                }
                
                // Se o estoque for >= a quantidade em venda, continua a venda, 
                // caso contrário a falta de estoque.
                if(estoque >= quantidade){
                    // Se o valor do limite de crédito do cliente for menor que a 
                    // soma do total das dívidas(item desejado + total em venda + total em 
                    // conta como crediário em aberto(pagamento=NULL)), NÃO autoriza 
                    // a continuação da inclusão de itens.
                    if(valorLimiteCredito < 
                            (valorTotalItem + valorTotalVenda + valorTotalDividaCrediario)){
                        JOptionPane.showMessageDialog(this, String.format(
                                "Limite de crédito ultrapassado!"
                                + "\nLimite: %.2f"
                                + "\nCrediário: %.2f"
                                + "\nVenda: %.2f", 
                                valorLimiteCredito, 
                                valorTotalDividaCrediario,
                                valorTotalItem + valorTotalVenda),
                                "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        if(novaVenda){
                            // Abre as transações em banco, somente vai gravar as operações 
                            // CRUD quando executar o método fecharTransações. Se executado o 
                            // método cancelarTransações ou fechado a aplicação(destruindo a conexão),
                            // as operações serão perdidas.
                            principal.Principal.conexao.abrirTransacoes();

                            novaVenda = false;

                            criarVenda();
                        }

                        adicionarItemVenda();
                    }
                }else{
                    JOptionPane.showMessageDialog(this,String.format( 
                            "Estoque insuficiente!\n"
                            + "Informado: %s \n"
                            + "Em estoque: %s", 
                            txtQuantidade.getValue(), 
                            estoque),
                            "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    txtQuantidade.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(this, 
                            "Não foi informado uma quantidade",
                            "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    txtQuantidade.requestFocus();
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparItensVenda();
        
        btnPesqProduto.setEnabled(true);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if(!txtProduto.getText().isEmpty()){
            
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        //cancela as transações caso a janela for fechada.
        principal.Principal.conexao.cancelarTransacoes();
        
        // desocultando menus e barra ferramentas
        principal.FrmPrincipal.Menu.setVisible(true);
        principal.FrmPrincipal.BarraFerramenta.setVisible(true);
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void tbVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbVendaKeyPressed
        
    }//GEN-LAST:event_tbVendaKeyPressed

    private void tbVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVendaMouseClicked
        double quantidade, valorUnitario;
        
        alteracaoItensVenda = true;

        idItemVenda = qryItensVenda.getCurrentFieldValueAsInteger("id");
        idProduto = qryItensVenda.getCurrentFieldValueAsInteger("id_produto");

        txtIdProduto.setText(qryItensVenda.getCurrentFieldValueAsString("id_produto"));
        txtProduto.setText(qryItensVenda.getCurrentFieldValueAsString("nome_produto"));
        quantidade = qryItensVenda.getCurrentFieldValueAsDouble("quantidade");
        txtQuantidade.setValue(quantidade);
        valorUnitario = qryItensVenda.getCurrentFieldValueAsDouble("valor_unitario");
        txtValorUnitario.setValue(valorUnitario);
        txtValorTotal.setValue(quantidade * valorUnitario);
        lblUnidade.setText(qryItensVenda.getCurrentFieldValueAsString("unidade"));
        comissaoProduto = qryItensVenda.getCurrentFieldValueAsDouble("comissao");

        txtProduto.setFocusable(false);
        btnPesqProduto.setEnabled(false);
        
        quantOriginal = quantidade;
    }//GEN-LAST:event_tbVendaMouseClicked

    private void btnCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVendaActionPerformed
        cancelarVenda();
    }//GEN-LAST:event_btnCancelarVendaActionPerformed

    private void btnRemoverActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed1
        if(alteracaoItensVenda){
            update.setSQL(String.format(
                    "DELETE FROM itens_vendas WHERE id = %s", idItemVenda));
            update.execUpdate();

            update.setSQL(String.format(
                "UPDATE produtos SET estoque = estoque + %s WHERE id = %s",
                quantOriginal, idProduto));
            update.execUpdate();

            qryItensVenda.execQuery();
            
            txtTotal.setValue(somarItensVenda());
            
            alteracaoItensVenda = false;
            
            limparItensVenda();
        }else{
            JOptionPane.showMessageDialog(this, "Selecione um item de venda!",
                "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed1

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int codEspecie, quantParcelas;
        double valorParcial;
        
        if(Double.valueOf(txtValorParc.getValue().toString()) > 0){
            if(cbxFormaPag.getSelectedIndex() != 0){
                codEspecie = qryFrmPgto.getCurrentFieldValueAsInteger("especie");
                valorParcial = Double.valueOf(txtValorParc.getValue().toString());
                quantParcelas = qryFrmPgto.getCurrentFieldValueAsInteger("numero_parcelas");
                // prazo e juros são visíveis em todo formulário, usando na composição 
                // da conta a receber.
                juros = qryFrmPgto.getCurrentFieldValueAsDouble("juros") == null?
                        0.0:qryFrmPgto.getCurrentFieldValueAsDouble("juros");
                prazo = qryFrmPgto.getCurrentFieldValueAsInteger("prazo");

                // 0=dh, 1=ch, 2=ct, 3=crediário
                if(codEspecie == 0){
                    txtValorDh.setValue(valorParcial);
                    txtValorDhDesconto.setValue(valorParcial / (1 + (Math.abs(juros)/100)));
                    lblDinheiro.setText("Valor com desconto(" + juros + "%)");

                    mudarStatusPainelFrmPgto(true, false, false);
                    btnSalvar_Din.requestFocus();
                }else if(codEspecie == 1){
                    txtValorChCt.setValue(valorParcial);
                    txtValorChCtJuros.setValue(valorParcial * (1 + (juros/100)));
                    lblChequeCartao.setText("Valor com acréscimo(" + juros + "%)");
                    txaDadosAdic_CC.setFocusable(true);

                    mudarStatusPainelFrmPgto(false, true, false);
                    btnSalvar_CC.requestFocus();

                    //adicionando parcelas no combobox
                    cbxParcChCt.removeAllItems();
                    for(int i=1; i <= quantParcelas; i++){
                        cbxParcChCt.addItem(String.format("%s", i));
                    }
                }else if(codEspecie == 2){
                    txtValorChCt.setValue(valorParcial);
                    txtValorChCtJuros.setValue(valorParcial * (1 + (juros/100)));
                    lblChequeCartao.setText("Valor com acréscimo(" + juros + "%)");
                    txaDadosAdic_CC.setFocusable(true);

                    mudarStatusPainelFrmPgto(false, true, false);
                    btnSalvar_CC.requestFocus();

                    //adicionando parcelas no combobox
                    cbxParcChCt.removeAllItems();
                    for(int i=1; i <= quantParcelas; i++){
                        cbxParcChCt.addItem(String.format("%s", i));
                    }
                }else if(codEspecie == 3){
                    txtValorCrediario.setValue(valorParcial);
                    txtValorCrediarioJuros.setValue(valorParcial * (1 + (juros/100)));
                    lblCredito.setText("Valor com acréscimo(" + juros + "%)");

                    mudarStatusPainelFrmPgto(false, false, true);
                    btnSalvar_Cred.requestFocus();

                    cbxParcCrediario.removeAllItems();
                    for(int i=1; i <= quantParcelas; i++){
                        cbxParcCrediario.addItem(String.format("%s", i));
                    }
                }

                // reatribuindo variável valorParc e txtValorParc
                txtValorParc.setValue(valorParcelamento - valorParcial);
                valorParcelamento -= valorParcial;
                
                cbxFormaPag.setEnabled(false);
                btnConfirmar.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(this, "Selecione uma forma de pagamento",
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);
                cbxFormaPag.requestFocus();
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtValorParcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorParcFocusLost
        double valorParcial;
        valorParcial = Double.valueOf(txtValorParc.getText().replaceAll(",", "."));
        
        if(valorParcial < 0 || valorParcial > valorParcelamento){
            txtValorParc.setValue(valorParcelamento);
            
            JOptionPane.showMessageDialog(this, "Valor da parcela inválido", 
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txtValorParcFocusLost

    private void btnRemover_CCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemover_CCActionPerformed
        valorParcelamento = 
                Double.valueOf(txtValorParc.getValue().toString()) + 
                Double.valueOf(txtValorChCt.getValue().toString());
        txtValorParc.setValue(valorParcelamento);
        lblChequeCartao.setText("Valor(R$):");
        
        txtValorChCt.setValue(0.0);
        txtValorChCtJuros.setValue(0.0);
        txaDadosAdic_CC.setText("");
        cbxParcChCt.setSelectedIndex(0);
        txaDadosAdic_CC.setFocusable(false);
        
        mudarStatusPainelFrmPgto(false, false, false);
        
        cbxFormaPag.setEnabled(true);
        btnConfirmar.setEnabled(true);
    }//GEN-LAST:event_btnRemover_CCActionPerformed

    private void btnRemover_DinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemover_DinActionPerformed
        valorParcelamento = 
                Double.valueOf(txtValorParc.getValue().toString()) + 
                Double.valueOf(txtValorDh.getValue().toString());
        txtValorParc.setValue(valorParcelamento);
        lblDinheiro.setText("Valor(R$):");
        
        txtValorDh.setValue(0.0);
        txtValorDhDesconto.setValue(0.0);
        
        mudarStatusPainelFrmPgto(false, false, false);
        
        cbxFormaPag.setEnabled(true);
        btnConfirmar.setEnabled(true);
    }//GEN-LAST:event_btnRemover_DinActionPerformed

    private void btnRemover_CredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemover_CredActionPerformed
        valorParcelamento = 
                Double.valueOf(txtValorParc.getValue().toString()) + 
                Double.valueOf(txtValorCrediario.getValue().toString());
        txtValorParc.setValue(valorParcelamento);
        lblCredito.setText("Valor(R$):");
        
        txtValorCrediario.setValue(0.0);
        txtValorCrediarioJuros.setValue(0.0);
        cbxParcCrediario.setSelectedIndex(0);
        
        mudarStatusPainelFrmPgto(false, false, false);
        
        cbxFormaPag.setEnabled(true);
        btnConfirmar.setEnabled(true);
    }//GEN-LAST:event_btnRemover_CredActionPerformed

    private void btnSalvar_CredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar_CredActionPerformed
        double valor;
        valor = Double.valueOf(txtValorCrediarioJuros.getValue().toString());
        
        // parcelas em crediário não entram no caixa, somente em contas a receber
        // sem data de pagamento(null) e sem id_item_caixa(null) 
        
        // se o crediário for divivido em parcelas, obten-se a quantidade de parcelas
        // e divide o valor pelas parcelas.
        int prazoParcelas, parcelas;
        parcelas = Integer.valueOf(cbxParcCrediario.getSelectedItem().toString());
        prazoParcelas = 0;
        double valorParcela = valor / parcelas;
        
        // criando entrada em lancamentos contas a receber
        for(int i=0; i < parcelas; i++){
            update.setSQL(String.format(
                    "INSERT INTO lancamentos_conta_receber("
                        + "id_conta_receber, valor, "
                        + "id_forma_pagamento, data_vencimento) "
                        + "VALUES "
                    + "('%s','%s','%s','%s')",
                    idContaReceber, 
                    valorParcela, 
                    qryFrmPgto.getCurrentFieldValueAsInteger("id"), 
                    sistema.Data.getAtualAcrescimoDiasSQL(prazoParcelas + prazo) ) );
            update.execUpdate();
            
            prazoParcelas += prazo;
        }
        
        qryLancContasReceber.execQuery();
        
        // limpar painel crediário
        lblCredito.setText("Valor(R$):");
        
        txtValorCrediario.setValue(0.0);
        txtValorCrediarioJuros.setValue(0.0);
        cbxParcCrediario.setSelectedIndex(0);
        
        mudarStatusPainelFrmPgto(false, false, false);
        
        cbxFormaPag.setEnabled(true);
        btnConfirmar.setEnabled(true);
        
        txtTotalVendaJuros.setValue(somarLancContasReceber(idContaReceber));
    }//GEN-LAST:event_btnSalvar_CredActionPerformed

    private void btnSalvar_DinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar_DinActionPerformed
        double valor;
        valor = Double.valueOf(txtValorDhDesconto.getValue().toString());
        
        // criando entrada caixa, movimento 1(true)=crédito
        update.setSQL(String.format(
                "INSERT INTO itens_caixa("
                    + "id_caixa, descricao, valor, movimento) "
                + "VALUES "
                    + "('%s','%s','%s','%s')",
                idCaixa, "Venda " + idVenda, valor, 1));
        update.execUpdate();
        
        qryTemp.setSQL("SELECT LAST_INSERT_ID()");
        qryTemp.execQuery();
        
        int idItemCaixa = qryTemp.getCurrentFieldValueAsInteger(1);
        
        // criando entrada em lancamentos contas a receber
        update.setSQL(String.format(
                "INSERT INTO lancamentos_conta_receber("
                    + "id_conta_receber, id_item_caixa, valor, "
                    + "id_forma_pagamento, data_vencimento, data_pagamento) "
                    + "VALUES "
                + "('%s','%s','%s','%s','%s','%s')",
                idContaReceber, 
                idItemCaixa, 
                valor, 
                qryFrmPgto.getCurrentFieldValueAsInteger("id"), 
                sistema.Data.getAtualAcrescimoDiasSQL(prazo),
                sistema.Data.getAtualSQL() ) );
        update.execUpdate();
        
        qryLancContasReceber.execQuery();
        
        // limpar painel dinheiro
        lblDinheiro.setText("Valor(R$):");
        
        txtValorDh.setValue(0.0);
        txtValorDhDesconto.setValue(0.0);
        
        mudarStatusPainelFrmPgto(false, false, false);
        
        cbxFormaPag.setEnabled(true);
        btnConfirmar.setEnabled(true);
        
        txtTotalVendaJuros.setValue(somarLancContasReceber(idContaReceber));
    }//GEN-LAST:event_btnSalvar_DinActionPerformed

    private void btnSalvar_CCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar_CCActionPerformed
        double valor;
        valor = Double.valueOf(txtValorChCtJuros.getValue().toString());
        
        // criando entrada caixa, movimento 1(true)=crédito
        update.setSQL(String.format(
                "INSERT INTO itens_caixa("
                    + "id_caixa, descricao, valor, especie, movimento) "
                + "VALUES "
                    + "('%s','%s','%s', '%s','%s')",
                idCaixa, 
                "Venda " + idVenda, 
                valor,
                qryFrmPgto.getCurrentFieldValueAsInteger("especie"),
                1));
        update.execUpdate();
        
        qryTemp.setSQL("SELECT LAST_INSERT_ID()");
        qryTemp.execQuery();
        
        int idItemCaixa = qryTemp.getCurrentFieldValueAsInteger(1);
        
        // criando entrada em lancamentos contas a receber
        int prazoParcelas, parcelas;
        parcelas = Integer.valueOf(cbxParcChCt.getSelectedItem().toString());
        prazoParcelas = 0;
        double valorParcela = valor / parcelas;
        
        for(int i=0; i < parcelas; i++){
            update.setSQL(String.format(
                    "INSERT INTO lancamentos_conta_receber("
                        + "id_conta_receber, id_item_caixa, valor, "
                        + "id_forma_pagamento, data_vencimento, data_pagamento) "
                    + "VALUES "
                        + "('%s','%s','%s','%s','%s','%s')",
                    idContaReceber, 
                    idItemCaixa,
                    valorParcela, 
                    qryFrmPgto.getCurrentFieldValueAsInteger("id"), 
                    sistema.Data.getAtualAcrescimoDiasSQL(prazoParcelas + prazo),
                    sistema.Data.getAtualSQL() ) );
            update.execUpdate();
            
            prazoParcelas += prazo;
        }
        
        qryLancContasReceber.execQuery();
        
        // criando entrada em controle ch ct e lancamentos controle ch e cartão
        update.setSQL(String.format(
                "INSERT INTO controle_cheque_cartao("
                    + "doc_principal_pessoa, id_conta_receber, "
                    + "dados_adicionais, valor_total, quantidade_parcelas) "
                + "VALUES ("
                    + "'%s','%s','%s','%s','%s')",
                    idCliente,
                    idContaReceber,
                    txaDadosAdic_CC.getText(),
                    valor,
                    parcelas));
        update.execUpdate();
        
        qryTemp.setSQL(String.format("SELECT LAST_INSERT_ID()"));
        qryTemp.execQuery();
        
        int idControlCHCT = qryTemp.getCurrentFieldValueAsInteger(1);
        
        prazoParcelas = 0;
        
        for(int i=0; i < parcelas; i++){
            update.setSQL(String.format(
                    "INSERT INTO lancamentos_controle_cheque_cartao("
                        + "numero_parcela, id_controle_cheque_cartao, "
                        + "valor_parcela, data_vencimento) "
                    + "VALUES ("
                        + "'%s','%s','%s','%s')",
                    i + 1, 
                    idControlCHCT,
                    valorParcela, 
                    sistema.Data.getAtualAcrescimoDiasSQL(prazoParcelas + prazo) ) );
            update.execUpdate();
            
            prazoParcelas += prazo;
        }
        
        // limpar painel ch ct
        lblChequeCartao.setText("Valor(R$):");
        
        txtValorChCt.setValue(0.0);
        txtValorChCtJuros.setValue(0.0);
        txaDadosAdic_CC.setText("");
        cbxParcChCt.setSelectedIndex(0);
        txaDadosAdic_CC.setFocusable(false);
        
        mudarStatusPainelFrmPgto(false, false, false);
        
        cbxFormaPag.setEnabled(true);
        btnConfirmar.setEnabled(true);
        
        txtTotalVendaJuros.setValue(somarLancContasReceber(idContaReceber));
    }//GEN-LAST:event_btnSalvar_CCActionPerformed

    private void btnCancelarVendaParcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVendaParcActionPerformed
        cancelarVenda();
    }//GEN-LAST:event_btnCancelarVendaParcActionPerformed

    private void btnCancelarParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarParcelasActionPerformed
        if(qryLancContasReceber.getRow() >= 1){
            if(sistema.Mensagem.showConfirmDialog(this, 
                    "Deseja realmente apagar todas as parcelas geradas nessa venda?", 
                    "Confirmação") == 0){
                // apagando entradas do caixa referentes a conta a receber e em 
                // cascata apaga também os lancamentos_conta_receber vinculado ao item_caixa.
                qryLancContasReceber.first();
                while(qryLancContasReceber.getRow() >= 1){
                    if(qryLancContasReceber.getCurrentFieldValueAsInteger("id_item_caixa") != null){
                        int idItemCaixa = qryLancContasReceber.getCurrentFieldValueAsInteger("id_item_caixa");
                        update.setSQL("DELETE FROM itens_caixa WHERE id = " + idItemCaixa);
                        update.execUpdate();
                    }

                    if(qryLancContasReceber.next() == -1){
                        break;
                    }
                }

                // zerando soma total de venda com juros
                txtTotalVendaJuros.setValue(0.0);
                txtValorParc.setValue(txtTotalVendaParc.getValue());
                valorParcelamento = Double.valueOf(txtTotalVendaParc.getValue().toString());

                // apagando todas os lançamentos contas a receber e atualizando table.
                update.setSQL(String.format(
                        "DELETE FROM lancamentos_conta_receber "
                        + "WHERE id_conta_receber = %s",
                        idContaReceber));
                update.execUpdate(); 
                qryLancContasReceber.execQuery();

                // apagando todos controles cheque cartão vinculados a venda e 
                // seus filhos(lancamentos controle cheque cartao) pelo delete on cascade.
                update.setSQL(String.format(
                        "DELETE FROM controle_cheque_cartao "
                        + "WHERE id_conta_receber = %s",
                        idContaReceber));
                update.execUpdate();
            }
        }
    }//GEN-LAST:event_btnCancelarParcelasActionPerformed

    private void btnPesquisarCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarCaixaActionPerformed
        carregarCaixa();
    }//GEN-LAST:event_btnPesquisarCaixaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lib.jdb.control.jdbbuttonsave.JDBButtonSave btnAdicionar;
    private javax.swing.JButton btnCancelarParcelas;
    private javax.swing.JButton btnCancelarVenda;
    private javax.swing.JButton btnCancelarVendaParc;
    private lib.jdb.control.jdbbuttonsave.JDBButtonSave btnConcluirV;
    private javax.swing.JButton btnConfirmar;
    private lib.jdb.control.jdbbuttoncancel.JDBButtonCancel btnLimpar;
    private javax.swing.JButton btnPesqCliente;
    private javax.swing.JButton btnPesqProduto;
    private javax.swing.JButton btnPesquisarCaixa;
    private lib.jdb.control.jdbbuttonsave.JDBButtonSave btnProx;
    private javax.swing.JButton btnRemover;
    private lib.jdb.control.jdbbuttondelete.JDBButtonDelete btnRemover_CC;
    private lib.jdb.control.jdbbuttondelete.JDBButtonDelete btnRemover_Cred;
    private lib.jdb.control.jdbbuttondelete.JDBButtonDelete btnRemover_Din;
    private lib.jdb.control.jdbbuttonsave.JDBButtonSave btnSalvar_CC;
    private lib.jdb.control.jdbbuttonsave.JDBButtonSave btnSalvar_Cred;
    private lib.jdb.control.jdbbuttonsave.JDBButtonSave btnSalvar_Din;
    private lib.jdb.control.jdblistcombobox.JDBListComboBox cbxFormaPag;
    private javax.swing.JComboBox cbxParcChCt;
    private javax.swing.JComboBox cbxParcCrediario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChequeCartao;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCredito;
    private javax.swing.JLabel lblDadosAdic_CC;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDinheiro;
    private javax.swing.JLabel lblFormaPag;
    private javax.swing.JLabel lblFormaPag1;
    private javax.swing.JLabel lblParcelas_CC;
    private javax.swing.JLabel lblParcelas_Cred;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblUnidade;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JLabel lblValorUni;
    private javax.swing.JLabel lblValor_CC;
    private javax.swing.JLabel lblValor_Cred;
    private javax.swing.JLabel lblValor_Din;
    private javax.swing.JLabel lblVenda;
    private javax.swing.JPanel pnCartaoCheque;
    private javax.swing.JPanel pnCodigo;
    private javax.swing.JPanel pnCodigo2;
    private javax.swing.JPanel pnCrediario;
    private javax.swing.JPanel pnDinheiro;
    private javax.swing.JPanel pnInf;
    private javax.swing.JPanel pnParcela;
    private javax.swing.JPanel pnVenda;
    private javax.swing.JTabbedPane pnlVenda;
    private javax.swing.JScrollPane scrlParcela;
    private javax.swing.JScrollPane scrlVenda;
    private lib.jdb.control.jdbtable.JDBTable tbParcela;
    private lib.jdb.control.jdbtable.JDBTable tbVenda;
    private javax.swing.JTextArea txaDadosAdic_CC;
    private javax.swing.JTextField txtCaixa;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtData;
    private lib.jdb.control.jdbtextfield.JDBTextField txtID;
    private lib.jdb.control.jdbtextfield.JDBTextField txtIdProduto;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JFormattedTextField txtQuantidade;
    private javax.swing.JFormattedTextField txtTotal;
    private javax.swing.JFormattedTextField txtTotalVendaJuros;
    private javax.swing.JFormattedTextField txtTotalVendaParc;
    private lib.jdb.control.jdbtextfield.JDBTextField txtUsuario;
    private javax.swing.JFormattedTextField txtValorChCt;
    private javax.swing.JFormattedTextField txtValorChCtJuros;
    private javax.swing.JFormattedTextField txtValorCrediario;
    private javax.swing.JFormattedTextField txtValorCrediarioJuros;
    private javax.swing.JFormattedTextField txtValorDh;
    private javax.swing.JFormattedTextField txtValorDhDesconto;
    private javax.swing.JFormattedTextField txtValorParc;
    private javax.swing.JFormattedTextField txtValorTotal;
    private javax.swing.JFormattedTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
    
    private void criarVenda(){        
        // inserindo uma nova venda
        update.setSQL(String.format(
                "INSERT INTO vendas(doc_principal_cliente, nome_usuario)"
                + " VALUES ('%s','%s')", idCliente, idVendedor));
        update.execUpdate();
        
        // retorno da última chave inserida(chave da venda) e atribuição
        qryTemp.setSQL("SELECT LAST_INSERT_ID()");
        qryTemp.execQuery();
        
        idVenda = qryTemp.getCurrentFieldValueAsInteger(1);
        txtID.setText(String.valueOf(idVenda));
        
        // atualizando query venda
        qryVenda.execQuery();
        
        // atribuindo a data no formato dd/MM/yyyy hh:mm:ss
        txtData.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(
                qryVenda.getCurrentFieldValueAsSQLTimestamp("data")));
        
        // atribuindo o usuário/vendedor
        txtUsuario.setText(qryVenda.getCurrentFieldValueAsString("nome_usuario"));
        
        // desativando consulta de cliente
        txtCliente.setFocusable(false);
        btnPesqCliente.setEnabled(false);
    }
    
    private void adicionarItemVenda(){
        // recuperando promoção
        qryVwPromocoesAtivas.setSQL(
                "SELECT valor_unitario, quantidade "
                + "FROM vw_promocoes_ativas "
                + "WHERE id_produto = " + idProduto);
        qryVwPromocoesAtivas.execQuery();

        // se encontrado promoção, avisa ao usuário sobre a 
        // quantidade mínima e o valor da promoção. 
        if(qryVwPromocoesAtivas.getRow() == 1){
            if(Double.valueOf(txtQuantidade.getValue().toString()) >= 
                    qryVwPromocoesAtivas.getCurrentFieldValueAsDouble("quantidade")){
                
                double novoValor =  qryVwPromocoesAtivas.getCurrentFieldValueAsDouble("valor_unitario");
                if(sistema.Mensagem.showConfirmDialog(this, String.format(
                    "Aplicar a promoção ao produto?\n"
                    + "Valor unitário original: R$ %.2f\n"
                    + "Valor unitário promocional: R$ %.2f",
                    txtValorUnitario.getValue(),
                    novoValor), 
                    "Atenção") == 0){
                    
                    txtValorUnitario.setValue(novoValor);
                }
            }
        }
        
        if(alteracaoItensVenda){
            if(sistema.Mensagem.showConfirmDialog(this, 
                    "Deseja realmente alterar este item?", "Confirmação") == 0){
                update.setSQL(String.format(
                        "UPDATE itens_vendas SET "
                            + "id_venda='%s',"
                            + "id_produto='%s',"
                            + "quantidade='%s', "
                            + "unidade='%s',"
                            + "valor_unitario='%s',"
                            + "comissao='%s' "
                        + "WHERE "
                            + "id = %s", 
                        idVenda, 
                        idProduto, 
                        txtQuantidade.getValue(),
                        lblUnidade.getText(),
                        txtValorUnitario.getValue(),
                        comissaoProduto,
                        idItemVenda));
                update.execUpdate();
                
                update.setSQL(String.format(
                    "UPDATE produtos SET estoque = estoque - %s WHERE id = %s",
                    (Double.valueOf(txtQuantidade.getValue().toString()) - quantOriginal), idProduto));
                update.execUpdate();
            }
        }else{
            // laço de verificação para NÃO inclusão de itens repetidos.
            boolean encontradoRegistro = false;
            
            qryItensVenda.first();
            while(qryItensVenda.getRow() >= 1){
                if(qryItensVenda.getCurrentFieldValueAsInteger("id_produto") == idProduto){
                    encontradoRegistro = true;
                    
                    break;
                }
                
                if(qryItensVenda.next() == -1){
                    break;
                }
            }
            //Se não foi encontrado o item, insere em itensvenda
            if(!encontradoRegistro){
                update.setSQL(String.format(
                        "INSERT INTO itens_vendas("
                            + "id_venda, id_produto, quantidade, "
                            + "unidade, valor_unitario, comissao) "
                        + "VALUES ("
                            + "'%s','%s','%s','%s','%s','%s')", 
                        idVenda, 
                        idProduto, 
                        txtQuantidade.getValue(),
                        lblUnidade.getText(),
                        txtValorUnitario.getValue(),
                        comissaoProduto));
                update.execUpdate();
                
                // atualizando estoque do produto.
                update.setSQL(String.format(
                        "UPDATE produtos SET estoque = estoque - %s WHERE id = %s",
                        txtQuantidade.getValue(), idProduto));
                update.execUpdate();
            //senão exibe mensagem.
            }else{
                JOptionPane.showMessageDialog(this, "Produto já incluído na venda");
            }
        }
        
        limparItensVenda();
        
        definirVwItensVenda();
        qryItensVenda.execQuery();
        
        // retornando valor total de venda.
        txtTotal.setValue(somarItensVenda());
    }
    
    private double retornarEstoqueProduto(int idProduto){
        qryProduto.setSQL(String.format(
                "SELECT estoque FROM produtos WHERE id = %s", idProduto));
        qryProduto.execQuery();
        
        return qryProduto.getCurrentFieldValueAsDouble("estoque");
    }
    
    private void definirVwItensVenda(){
        qryItensVenda.setSQL(String.format(
                "SELECT"
                    + " id, id_venda, id_produto, nome_produto, quantidade,"
                    + " unidade, valor_unitario, total, comissao "
                + "FROM"
                    + " vw_itens_vendas "
                + "WHERE"
                    + " id_venda = '%s'", idVenda));
        
        tbVenda.setInvisibleFields("id id_venda comissao");
        tbVenda.setFieldsTitle("id_produto","CÓD.PRODUTO");
        tbVenda.setFieldsTitle("nome_produto", "PRODUTO");
        tbVenda.setFieldsTitle("quantidade","QUANTIDATE");
        tbVenda.setFieldsTitle("unidade","UN");
        tbVenda.setFieldsTitle("valor_unitario","VALOR UNITÁRIO");
        tbVenda.setFieldsTitle("total", "VALOR TOTAL");
    }
    
    private double somarItensVenda(){
        double total;
//        qryItensVenda.last();
        if(qryItensVenda.getRow() >= 1){
            qryTemp.setSQL(String.format(
                    "SELECT sum(quantidade * valor_unitario) AS 'total'"
                    + "FROM itens_vendas WHERE id_venda = %s", idVenda));
            qryTemp.execQuery();

            total = qryTemp.getCurrentFieldValueAsDouble("total");
        }else{
            total = 0;
        }
        
        return total;
    }
    
    private void limparVenda(){
        txtCliente.requestFocus();
        
        pesquisaCliente = false;
        novaVenda = true;
        
        idVenda = 0;
        txtID.setText("");
        idCliente = "";
        txtCliente.setText("");
        
        definirVwItensVenda();
        qryItensVenda.execQuery();
        
        // não deve ser limpo o id do vendedor 
        // e o id do caixa, eles são atribuídos
        // na abertura do form. vendas.
        idContaReceber = 0;
        idItemVenda = 0;
        idProduto = 0;
        
        valorParcelamento = 0.0;
        
        txtCliente.setFocusable(true);
        btnPesqCliente.setEnabled(true);
        
        txtTotalVendaParc.setValue(0.0);
        txtValorParc.setValue(0.0);
        txtValorDh.setValue(0.0);
        txtValorChCt.setValue(0.0);
        txtValorCrediario.setValue(0.0);
        
        txtTotal.setValue(0.0);
        
        txtData.setText("");
        
        txtTotalVendaJuros.setValue(0.0);
        
        //desativando paineis das formas de pagamento
        mudarStatusPainelFrmPgto(false, false, false);
        
        limparItensVenda();
    }
    
    private void mudarStatusPainelFrmPgto(boolean dinheiro, boolean cartaoCheque, boolean crediario){
        for(int i=0; i<pnDinheiro.getComponentCount(); i++){
            pnDinheiro.getComponent(i).setEnabled(dinheiro);
        }
        
        for(int i=0; i<pnCartaoCheque.getComponentCount(); i++){
            pnCartaoCheque.getComponent(i).setEnabled(cartaoCheque);
        }
        txaDadosAdic_CC.setFocusable(cartaoCheque);

        
        for(int i=0; i<pnCrediario.getComponentCount(); i++){
            pnCrediario.getComponent(i).setEnabled(crediario);
        }
    }
    
    private void limparItensVenda(){
        pesquisarProduto = false;
        alteracaoItensVenda = false;
        
        fracionado = false;
        
        idItemVenda = 0;
        idProduto = 0;
        txtIdProduto.setText("");
        txtProduto.setText("");
        txtValorUnitario.setValue(0.0);
        txtValorTotal.setValue(0.0);
        txtQuantidade.setValue(0.0);
        lblUnidade.setText("Unidade");  
        
        txtProduto.setFocusable(true);
        btnPesqProduto.setEnabled(true);
    }
    
    private void pesquisarCliente(){
        qryCliente = new JDBQuery();
        qryCliente.setJDBConnection(principal.Principal.conexao.getConexao());
        qryCliente.setConcurUpdatable(false);

        String sql, texto;
        sql = "SELECT"
                + " doc_principal, nome,"
                + " data_nascimento, limite_credito "
            + "FROM"
                + " vw_clientes_pesquisa_venda";
        texto = txtCliente.getText();
        
        // limpando a textfield e a variável de id.
        this.idCliente = "";
        txtCliente.setText("");
        
        if(!texto.isEmpty()){
            if(texto.matches("[0-9]+")){
                sql += String.format(" WHERE doc_principal LIKE '%%%s%%'", texto);
            }else if(texto.matches("[a-zA-Z0-9 ]+")){
                texto = texto.replaceAll(" ", "%");
                sql += String.format(" WHERE nome LIKE '%%%s%%'", texto);
            }
            
            qryCliente.setSQL(sql);
            qryCliente.execQuery();
            
            //move o ponteiro da query para a ultima posição
            // e captura qual posição está tem com o getrow();
            qryCliente.last();
            if(qryCliente.getRow() == 1){
                alimentarCamposCliente();
            }else
                carregarCliente(qryCliente);
        }else{
//            //abre pesquisa genérica
            carregarCliente(qryCliente);
        }
    }
    
    private void alimentarCamposCliente(){
        this.idCliente = qryCliente.getCurrentFieldValueAsString("doc_principal");
        txtCliente.setText(qryCliente.getCurrentFieldValueAsString("nome"));
        
        aniversarioCliente();
    }
    
    private void aniversarioCliente(){
        // verificando aniversário do cliente.
        if(qryCliente.getCurrentFieldValueAsSQLDate("data_nascimento") != null){
            String dataAtual, aniversario;
            aniversario = sistema.Data.formatarData(
                    qryCliente.getCurrentFieldValueAsSQLDate("data_nascimento"),
                    "dd/MM");
            dataAtual = sistema.Data.getAtualFormatada("dd/MM");
            if(dataAtual.equals(aniversario)){
                JOptionPane.showMessageDialog(this,String.format(
                        "Hoje(%s) é o ANIVERSÁRIO do cliente %s", aniversario, txtCliente.getText()), 
                        "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private void carregarCliente(JDBQuery qryCliente){
        pesquisaCliente = true;
        pesquisarProduto = false;
        pesquisaCaixa = false;
        
        txtCliente.requestFocus();
        
        // campos para combobox sendo texto visual e o nome campo do banco referente.
        LinkedHashMap<String, String> combo = new LinkedHashMap<>();
        combo.put("Nome", "nome");
        combo.put("CPF/CNPJ", "doc_principal");
        
        // titulos para as colunas da tabela, sendo texto visual e nome campo do banco referente.
        LinkedHashMap<String, String> titulo = new LinkedHashMap<>();
        titulo.put("CPF/CNPJ", "doc_principal");
        titulo.put("NOME", "nome");

        // campos que deseja deixar invisível, pode-se omitir.
        String[] invisivel = {"data_nascimento", "limite_credito"};

        // tamanho das colunas visíveis, pode-se omitir.
        int[] tamanho = null;
        
        pesquisa.iFrmPesquisa clientes;
        clientes = new pesquisa.iFrmPesquisa(this,
                "Pesquisa de Clientes",
                principal.Principal.conexao.getConexao(),
                qryCliente,
                "doc_principal",
                combo,
                titulo,
                "SELECT doc_principal, nome,"
                    + " data_nascimento, limite_credito "
                + "FROM vw_clientes_pesquisa_venda",
                invisivel,
                tamanho);

        
        principal.FrmPrincipal.Desktop.add(clientes);
        clientes.setVisible(true);                        
    }
    
    private void pesquisarProduto(){
        String sql, texto;
        sql = "SELECT"
                + " id, nome, codigo_barra, codigo_fornecedor, categoria, estoque, sigla_unidade,"
                + " fracionado, preco_venda, comissao "
            + "FROM"
                + " vw_produtos";
        texto = txtProduto.getText();
        
        // limpando a textfield e a variável de id.
        limparItensVenda();
        
        if(!texto.isEmpty()){
            if(texto.matches("[0-9]+")){
                sql += String.format(" WHERE id = %s", texto);
            }else if(texto.matches("789[0-9]+")){
                sql += String.format(" WHERE codigo_barra LIKE '%%%s%%'");
            }else if(texto.matches("[a-zA-Z0-9 ]+")){
                texto = texto.replaceAll(" ", "%");
                sql += String.format(" WHERE nome LIKE '%%%s%%'", texto);
            }
            
            qryProduto.setSQL(sql);
            qryProduto.execQuery();
            
            //move o ponteiro da query para a ultima posição
            // e captura qual posição está tem com o getrow();
            qryProduto.last();
            if(qryProduto.getRow() == 1){
                alimentarCamposProduto();
            }else
                carregarProduto(qryProduto);
        }else{
//            //abre pesquisa genérica
            carregarProduto(qryProduto);
        }
    }
    
    private void alimentarCamposProduto(){
        // se tem estoque do produto:
        if(qryProduto.getCurrentFieldValueAsDouble("estoque") > 0){
            // capturando idProduto e sigla resultante da busca
            idProduto = qryProduto.getCurrentFieldValueAsInteger("id");
            lblUnidade.setText(qryProduto.getCurrentFieldValueAsString("sigla_unidade"));
            
            // recuperando promoção
            qryVwPromocoesAtivas.setSQL(
                    "SELECT valor_unitario, quantidade "
                    + "FROM vw_promocoes_ativas "
                    + "WHERE id_produto = " + idProduto);
            qryVwPromocoesAtivas.execQuery();
            
            // se encontrado promoção, avisa ao usuário sobre a 
            // quantidade mínima e o valor da promoção. 
            if(qryVwPromocoesAtivas.getRow() == 1){
                JOptionPane.showMessageDialog(this, String.format(
                        "Produto com promoção\n"
                        + "Quantidade mínima necessária: %.2f %s\n"
                        + "Valor unitário promocional: R$ %.2f",
                        qryVwPromocoesAtivas.getCurrentFieldValueAsDouble("quantidade"),
                        lblUnidade.getText(),
                        qryVwPromocoesAtivas.getCurrentFieldValueAsDouble("valor_unitario")), 
                        "Atenção",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
            // alimentando os outros campos de produto no item venda
            txtIdProduto.setText(String.valueOf(idProduto));
            txtProduto.setText(qryProduto.getCurrentFieldValueAsString("nome"));
            txtValorUnitario.setValue(qryProduto.getCurrentFieldValueAsDouble("preco_venda"));
            comissaoProduto = qryProduto.getCurrentFieldValueAsDouble("comissao");
            
            fracionado = qryProduto.getCurrentFieldValueAsBoolean("fracionado");
        // senão:
        }else{
            JOptionPane.showMessageDialog(this, 
                String.format("Produto sem estoque!\n%s", 
                    qryProduto.getCurrentFieldValueAsString("nome")), 
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);;
        }
    }
    
    private void carregarProduto(JDBQuery qryProduto){
        pesquisarProduto = true;
        pesquisaCliente = false;
        pesquisaCaixa = false;
        
        txtProduto.requestFocus();
        
        // campos para combobox sendo texto visual e o nome campo do banco referente.
        LinkedHashMap<String, String> combo = new LinkedHashMap<>();
        combo.put("Nome", "nome");
        combo.put("Código", "id");
        combo.put("Código Barra", "codigo_barra");
        combo.put("Código Fornecedor", "codigo_fornecedor");
        combo.put("Categoria", "categoria");
        
        // titulos para as colunas da tabela, sendo texto visual e nome campo do banco referente.
        LinkedHashMap<String, String> titulo = new LinkedHashMap<>();
        titulo.put("CÓDIGO", "id");
        titulo.put("NOME", "nome");
        titulo.put("ESTOQUE", "estoque");
        titulo.put("UN", "sigla_unidade");
        titulo.put("PREÇO", "preco_venda");

        // campos que deseja deixar invisível, pode-se omitir.
        String[] invisivel = {"codigo_fornecedor", "codigo_barra", "categoria", 
            "comissao", "fracionado"};

        // tamanho das colunas visíveis, pode-se omitir.
        int[] tamanho = null;
        
        pesquisa.iFrmPesquisa produtos;
        produtos = new pesquisa.iFrmPesquisa(this,
                "Pesquisa de Produtos",
                principal.Principal.conexao.getConexao(),
                qryProduto,
                "id",
                combo,
                titulo,
                "SELECT"
                    + " id, nome, codigo_barra, codigo_fornecedor, categoria, estoque, sigla_unidade,"
                    + " fracionado, preco_venda, comissao "
                + "FROM"
                    + " vw_produtos",
                invisivel,
                tamanho);

        
        principal.FrmPrincipal.Desktop.add(produtos);
        produtos.setVisible(true);                        
    }
    
    public void atribuirVenda(){
        if(pesquisaCliente){
            alimentarCamposCliente();
            
            pesquisaCliente = false;
        }else if(pesquisarProduto){
            alimentarCamposProduto();
            
            pesquisarProduto = false;
        }else if(pesquisaCaixa){
            alimentarCamposCaixa();
            
            pesquisaCaixa = false;
        }
    }

    private void cancelarVenda(){
        if(sistema.Mensagem.showConfirmDialog(this, 
                "Deseja realmente cancelar a venda?", "Confirmação") == 0){
            // o evento de fechar o formulário contém conexao.cancelarTransações, 
            // eliminando as transações em aberto.
            doDefaultCloseAction();
        }
    }
    
    private double somarLancContasReceber(int idLancContasReceber){
        qryTemp.setSQL(String.format(
                "SELECT sum(lancamentos_conta_receber.valor)"
                + " FROM lancamentos_conta_receber "
                + "WHERE lancamentos_conta_receber.id_conta_receber = %s", idLancContasReceber));
        qryTemp.execQuery();
        
        return qryTemp.getCurrentFieldValueAsDouble(1);
    }
    
    private double retornarDividaCrediario(String idCLiente){
        qryTemp.setSQL(String.format(
                "SELECT SUM(lancamentos_conta_receber.valor) "
                + "FROM lancamentos_conta_receber "
                    + "INNER JOIN contas_receber "
                        + "ON lancamentos_conta_receber.id_conta_receber = contas_receber.id "
                    + "INNER JOIN formas_pagamento "
                        + "ON lancamentos_conta_receber.id_forma_pagamento = formas_pagamento.id "
                + "WHERE formas_pagamento.especie = 3 "
                    + "AND lancamentos_conta_receber.data_pagamento IS NULL "
                    + "AND contas_receber.doc_principal_cliente = '%s'", 
                idCLiente));
        qryTemp.execQuery();
        
        return qryTemp.getCurrentFieldValueAsDouble(1) == null?0.0:qryTemp.getCurrentFieldValueAsDouble(1);
    }
    
    private void carregarCaixa(){
        pesquisaCaixa = true;
        pesquisaCliente = false;
        pesquisarProduto = false;
        
        btnAdicionar.requestFocus();
        
        // campos para combobox sendo texto visual e o nome campo do banco referente.
        LinkedHashMap<String, String> combo = new LinkedHashMap<>();
        combo.put("Descrição", "descricao");
        combo.put("Código", "id");
        
        // titulos para as colunas da tabela, sendo texto visual e nome campo do banco referente.
        LinkedHashMap<String, String> titulo = new LinkedHashMap<>();
        titulo.put("CÓDIGO", "id");
        titulo.put("DESCRIÇÃO", "descricao");

        // campos que deseja deixar invisível, pode-se omitir.
        String[] invisivel = null;

        // tamanho das colunas visíveis, pode-se omitir.
        int[] tamanho = null;
        
        pesquisa.iFrmPesquisa caixa;
        caixa = new pesquisa.iFrmPesquisa(this,
                "Pesquisa de Caixas",
                principal.Principal.conexao.getConexao(),
                qryCaixa,
                "id",
                combo,
                titulo,
                "SELECT "
                    + "id, descricao "
                + "FROM "
                    + "vw_caixa_consulta_venda",
                invisivel,
                tamanho);

        
        principal.FrmPrincipal.Desktop.add(caixa);
        caixa.setVisible(true);                        
    }
    
    private void alimentarCamposCaixa(){
        idCaixa = qryCaixa.getCurrentFieldValueAsInteger("id");
        txtCaixa.setText(qryCaixa.getCurrentFieldValueAsString("descricao"));
    }
}
