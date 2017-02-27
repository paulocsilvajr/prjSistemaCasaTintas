package sistema;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import lib.jdb.jdbquery.JDBQuery;

/**
 * DEPRECATED
 */
public class ControlePermissao {
    private String usuario;
    private final Conexao conexao;
    private JDBQuery qryPermissoes;
    private ArrayList<HashMap> listaPermissoes;
    private ArrayList<HashMap> permVendedor, permAdminstrador, permColorista, 
            permComprador, permEstoquista, permGerenteFinanceiro, permGerenteVendas;
//    private final String[] tabelas = {"produtos", "cfop", "categorias_produto", "marcas", "tintas", 
//    "bases_tinta", "unidades", "montadoras", "tipos", "categorias_tinta", "vendas", "itens_venda",
//    "compras", "itens_compra", "formas_pagamento", "contas_pagar", "lancamentos_conta_pagar", 
//    "contas_receber", "lancamento_conta_receber", "pessoas", "localidades", "contatos", "usuarios",
//    "caixas", "itens_caixa", "controle_cheque_cartao", "lancamentos_cheque_cartao", "promocoes"};
    private final HashMap<String, String> dicTabelas;
    private boolean administrador, vendedor, colorista, comprador, estoquista, 
            gerenteFinanceiro, gerenteVendas;
    
    public ControlePermissao(Conexao conexao){
        this.conexao = conexao;
        
        listaPermissoes = new ArrayList<>();
        
        dicTabelas = new HashMap<>();
        dicTabelas.put("produtos", "produtos");
        dicTabelas.put("cfop", "cfop");
        dicTabelas.put("categoriasProduto", "categorias_produto");
        dicTabelas.put("marcas", "marcas");
        dicTabelas.put("tintas", "tintas");
        dicTabelas.put("basesTinta", "bases_tinta");
        dicTabelas.put("unidades", "unidades");
        dicTabelas.put("montadoras", "montadoras");
        dicTabelas.put("tipos", "tipos");
        dicTabelas.put("categoriasTinta", "categorias_tinta");
        dicTabelas.put("vendas", "vendas");
        dicTabelas.put("itensVenda", "itens_venda");
        dicTabelas.put("compras", "compras");
        dicTabelas.put("itensCompra", "itens_compra");
        dicTabelas.put("formasPagamento", "formas_pagamento");
        dicTabelas.put("contasPagar", "contas_pagar");
        dicTabelas.put("lancamentosContaPagar", "lancamentos_conta_pagar");
        dicTabelas.put("contasReceber", "contas_receber");
        dicTabelas.put("lancamentosContaReceber", "lancamentos_conta_receber");
        dicTabelas.put("pessoas", "pessoas");
        dicTabelas.put("localidades", "localidades");
        dicTabelas.put("contatos", "contatos");
        dicTabelas.put("usuarios", "usuarios");
        dicTabelas.put("caixas", "caixas");
        dicTabelas.put("itensCaixa", "itensCaixa");
        dicTabelas.put("controleChequeCartao", "controle_cheque_cartao");
        dicTabelas.put("lancamentosChequeCartao", "lancamentos_cheque_cartao");
        dicTabelas.put("promocoes", "promocoes");
        
        administrador = vendedor = colorista = comprador = estoquista = 
                gerenteFinanceiro = gerenteVendas = false;
        
        capturarPermissoes();
        
        permVendedor = new ArrayList<>();
        permAdminstrador = new ArrayList<>();
        permColorista = new ArrayList<>();
        permComprador = new ArrayList<>();
        permEstoquista = new ArrayList<>();
        permGerenteFinanceiro = new ArrayList<>();
        permGerenteVendas = new ArrayList<>();
    }
    
    private void permVendedor(){
        HashMap<String, Object> perm = new HashMap<>();
        perm.put("tabela", dicTabelas.get("vendas"));
        perm.put("consultar", true);
        perm.put("inserir", true);
        perm.put("atualizar", true);
        perm.put("excluir", false);
        // vendas
        permVendedor.add(perm);
        
        perm = new HashMap<>();
        perm.put("tabela", dicTabelas.get("pessoas"));
        perm.put("consultar", true);
        perm.put("inserir", false);
        perm.put("atualizar", false);
        perm.put("excluir", false);
        // clientes
        permVendedor.add(perm);
        
        perm = new HashMap<>();
        perm.put("tabela", dicTabelas.get("contasReceber"));
        perm.put("consultar", false);
        perm.put("inserir", false);
        perm.put("atualizar", false);
        perm.put("excluir", false);
        // clientes
        permVendedor.add(perm);
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public boolean definirAdministrador(){
        return permissaoAdminstrador(true);
    }
    
    public boolean revogarAdministrador(){
        return permissaoAdminstrador(false);
    }
    
    private boolean permissaoAdminstrador(boolean definir){ 
        if(!usuario.isEmpty()){
            String tipo, comp;
            if(definir == true){
                tipo = "GRANT";
                comp = "TO";
            }else{
                tipo = "REVOKE";
                comp = "FROM";
            }
            
            conexao.abrirTransacoes();
            
            // permissão total 
            conexao.setTransacao(String.format(
                    "%s ALL PRIVILEGES ON %s.* %s %s@%s",
                    tipo,
                    conexao.getBanco(),
                    comp,
                    usuario,
                    conexao.getHost()) );
            
            // permissão para conceder permissões
            conexao.setTransacao(String.format(
                    "%s GRANT OPTION ON %s.* %s %s@%s", 
                    tipo,
                    conexao.getBanco(),
                    comp,
                    usuario,
                    conexao.getHost()) );
            
            conexao.setTransacao("FLUSH PRIVILEGES");
            
            conexao.fecharTransacoes();
            
            administrador = definir;
            
            return true;
        }else{
            System.err.println("Informe um usuário para definir permissão");    
        }
        
        return false;
    }
    
    private void recuperarPermissoes(){
        if(administrador){
            definirAdministrador();
        }
        
        if(vendedor){
            definirVendedor();
        }
        
        if(colorista){
            definirColorista();
        }
        
        if(comprador){
            definirComprador();
        }
        
        if(estoquista){
            definirEstoquista();
        }
        
        if(gerenteFinanceiro){
            definirGerenteFinanceiro();
        }
        
        if(gerenteVendas){
            definirGerenteVendas();
        }
    }
    
    private void permissaoVendedor(boolean definir){
//        conexao.abrirTransacoes();
//        
//        permissao(definir, dicTabelas.get("vendas"), true, true, false, false);
//        permissao(definir, dicTabelas.get("itensVenda"), true, true, true, true);
//        permissao(definir, dicTabelas.get("itensCaixa"), false, true, false, false);
//        permissao(definir, dicTabelas.get("lancamentos_conta_receber"), false, true, false, false);
//        permissao(definir, dicTabelas.get("produtos"), true, false, true, false);
//        
//        conexao.fecharTransacoes(); 
        
        vendedor = definir;
    }
    
    public void definirVendedor(){
        permissaoVendedor(true);
    }
    
    public void revogarVendedor(){
        permissaoVendedor(false);
        
        recuperarPermissoes();
    }
    
    public boolean isVendedor(){
        return vendedor;
    }
    
    private void permissaoColorista(boolean definir){
//        conexao.abrirTransacoes();
//        
//        permissao(definir, dicTabelas.get("tintas"), true, false, false, false);
//        permissao(definir, dicTabelas.get("basesTinta"), true, false, false, false);        
//        permissao(definir, dicTabelas.get("produtos"), true, true, true, false);
//        
//        conexao.fecharTransacoes();
        
        colorista = definir;
    }
    
    public void definirColorista(){
        permissaoColorista(true);
    }
    
    public void revogarColorista(){
        permissaoColorista(false);
        
        recuperarPermissoes();
    }
    
    public boolean isColorista(){
        return colorista;
    }
    
    private void permissaoEstoquista(boolean definir){
//        conexao.abrirTransacoes();
//        
//        permissao(definir, dicTabelas.get("tintas"), true, false, false, false);
//        permissao(definir, dicTabelas.get("basesTinta"), true, false, false, false);        
//        permissao(definir, dicTabelas.get("produtos"), true, true, true, false);
//        
//        conexao.fecharTransacoes();
        
        colorista = definir;
    }
    
    public void definirEstoquista(){
        permissaoEstoquista(true);
    }
    
    public void revogarEstoquista(){
        permissaoEstoquista(false);
        
        recuperarPermissoes();
    }
    
    public boolean isEstoquista(){
        return colorista;
    }
    
    private void permissaoGerenteFinanceiro(boolean definir){
//        conexao.abrirTransacoes();
//        
//        permissao(definir, dicTabelas.get("tintas"), true, false, false, false);
//        permissao(definir, dicTabelas.get("basesTinta"), true, false, false, false);        
//        permissao(definir, dicTabelas.get("produtos"), true, true, true, false);
//        
//        conexao.fecharTransacoes();
        
        colorista = definir;
    }
    
    public void definirGerenteFinanceiro(){
        permissaoGerenteFinanceiro(true);
    }
    
    public void revogarGerenteFinanceiro(){
        permissaoGerenteFinanceiro(false);
        
        recuperarPermissoes();
    }
    
    public boolean isGerenteFinanceiro(){
        return colorista;
    }
    
    private void permissaoGerenteVendas(boolean definir){
        conexao.abrirTransacoes();
        
        permissao(definir, dicTabelas.get("tintas"), true, false, false, false);
        permissao(definir, dicTabelas.get("basesTinta"), true, false, false, false);        
        permissao(definir, dicTabelas.get("produtos"), true, true, true, false);
        
        conexao.fecharTransacoes();
        
        colorista = definir;
    }
    
    public void definirGerenteVendas(){
        permissaoGerenteVendas(true);
    }
    
    public void revogarGerenteVendas(){
        permissaoGerenteVendas(false);
        
        recuperarPermissoes();
    }
    
    public boolean isGerenteVendas(){
        return colorista;
    }
    
    private void permissaoComprador(boolean definir){
//        conexao.abrirTransacoes();
//        
//        permissao(definir, dicTabelas.get("tintas"), true, false, false, false);
//        permissao(definir, dicTabelas.get("basesTinta"), true, false, false, false);        
//        permissao(definir, dicTabelas.get("produtos"), true, true, true, false);
//        
//        conexao.fecharTransacoes();
        
        colorista = definir;
    }
    
    public void definirComprador(){
        permissaoComprador(true);
    }
    
    public void revogarComprador(){
        permissaoComprador(false);
        
        recuperarPermissoes();
    }
    
    public boolean isComprador(){
        return comprador;
    }
    
    public void definirPermissao(String tabela, 
            boolean consultar, boolean inserir, boolean atualizar, boolean apagar){
        conexao.abrirTransacoes();
        
        permissao(true, tabela, consultar, inserir, atualizar, apagar);
        
        conexao.fecharTransacoes();
    }
    
    public void revogarPermissao(String tabela, 
            boolean consultar, boolean inserir, boolean atualizar, boolean apagar){
        conexao.abrirTransacoes();
        
        permissao(false, tabela, consultar, inserir, atualizar, apagar);
        
        conexao.fecharTransacoes();
    }
    
    private boolean permissao(boolean definir, String tabela, 
            boolean consultar, boolean inserir, boolean atualizar, boolean apagar){
        
        if(!usuario.isEmpty()){
            String tipo, comp;
            if(definir == true){
                tipo = "GRANT";
                comp = "TO";
            }else{
                tipo = "REVOKE";
                comp = "FROM";
            }
//            conexao.abrirTransacoes();
            if(consultar){
                conexao.setTransacao(String.format(
                        "%s SELECT ON %s.%s %s %s@%s",
                        tipo,
                        conexao.getBanco(),
                        tabela,
                        comp,
                        usuario,
                        conexao.getHost()) );
            }
            
            if(inserir){
                conexao.setTransacao(String.format(
                        "%s INSERT ON %s.%s %s %s@%s",
                        tipo,
                        conexao.getBanco(),
                        tabela,
                        comp,
                        usuario,
                        conexao.getHost()) );
            }
            
            if(atualizar){
                conexao.setTransacao(String.format(
                        "%s UPDATE ON %s.%s %s %s@%s",
                        tipo,
                        conexao.getBanco(),
                        tabela,
                        comp,
                        usuario,
                        conexao.getHost()) );
            }
            
            if(apagar){
                conexao.setTransacao(String.format(
                        "%s DELETE ON %s.%s %s %s@%s",
                        tipo,
                        conexao.getBanco(),
                        tabela,
                        comp,
                        usuario,
                        conexao.getHost()) );
            }
//            conexao.fecharTransacoes();
            return true;
        }
        
        return false;
    }
    
    private void consultarPermissoes(){
        conexao.setConsulta(String.format("SHOW GRANTS FOR %s@%s", getUsuario(), conexao.getHost()));
        qryPermissoes = conexao.getQuery();
    }
    
    private void capturarPermissoes(){
        try {
            consultarPermissoes();
            
            ResultSet resultado = qryPermissoes.getResultSet();
            
            boolean admin = false;
            for(String nome: dicTabelas.values()){
                resultado.first();
                do{
                    if(!resultado.getString(1).contains("USAGE")){
                        if(resultado.getString(1).contains("GRANT ALL PRIVILEGES")){
                            inserirItemLista("todas", true, true, true, true);
                            
                            admin = true;
                            
                            break;
                        }

                        boolean consultar, inserir, atualizar, excluir;
                        consultar = inserir = atualizar = excluir = false;

                        if(resultado.getString(1).contains("`" + nome + "`")){
                            if(resultado.getString(1).contains("SELECT")){ 
                                consultar = true;
                            }

                            if( resultado.getString(1).contains("INSERT") ){
                                inserir = true;
                            }

                            if( resultado.getString(1).contains("UPDATE") ){
                                atualizar = true;
                            }

                            if( resultado.getString(1).contains("DELETE") ){
                                excluir = true;
                            }

                            inserirItemLista(nome, consultar, inserir, atualizar, excluir);
                        }
                    }
                }while(resultado.next());
                
                if(admin){
                    break;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private void inserirItemLista(
            String tabela, boolean consultar, boolean inserir, boolean atualizar, boolean excluir){
        HashMap<String, Object> perm = new HashMap<>();
        perm.put("tabela", tabela);
        perm.put("consultar", consultar);
        perm.put("inserir", inserir);
        perm.put("atualizar", atualizar);
        perm.put("excluir", excluir);

        listaPermissoes.add(perm);
    }
    
    public ArrayList getPermissoes(){
        capturarPermissoes();
        
        return listaPermissoes;
    }
    
}
