
package relatorio;

import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorios {
    private static void executar_report(String pathRelatorio, HashMap parametro){
        try{
            JasperPrint jp = JasperFillManager.fillReport(             
                    pathRelatorio,
                    parametro,
                    principal.Principal.conexao.getConexao().getConnection());
            JasperViewer.viewReport(jp,false);              
        }catch(JRException jre){
            System.out.println(jre.getMessage());
        }
    }
    
    public static void relatorio_teste_cliente_geral(String data_inicio, String data_fim){
        String pathRelatorio = "src/relatorio/repClienteGeral.jasper";
        HashMap parametro = new HashMap();
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_cliente_geral(java.sql.Date data_inicio, java.sql.Date data_fim){
        String pathRelatorio = "src/relatorio/rep_cliente_geral.jasper";
        HashMap parametro = new HashMap();
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_vendas(String id_venda, java.lang.Double soma_venda, java.lang.Double soma_parcela){
        String pathRelatorio = "src/relatorio/rep_vendas.jasper";
        HashMap parametro = new HashMap();
        parametro.put("id_venda", id_venda);
        parametro.put("soma_venda", soma_venda);
        parametro.put("soma_parcela", soma_parcela);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_comissao(String vendedor, java.sql.Date data_inicio, java.sql.Date data_fim){
        String pathRelatorio = "src/relatorio/rep_comissao.jasper";
        
        if(vendedor.isEmpty()){
            vendedor = "%%";
        }
        
        HashMap parametro = new HashMap();
        parametro.put("vendedor", vendedor);
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_lancamentos_conta_receber_cliente(
            java.sql.Date data_inicio, java.sql.Date data_fim, String where, String titulo){
        String pathRelatorio = "src/relatorio/rep_lancamentos_conta_receber_cliente.jasper";
        HashMap parametro = new HashMap();
        parametro.put("titulo", titulo);
        parametro.put("where", where);
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_lancamentos_conta_pagar_fornecedor(
            java.sql.Date data_inicio, java.sql.Date data_fim, String where, String titulo){
        String pathRelatorio = "src/relatorio/rep_lancamentos_conta_pagar_fornecedor.jasper";
        HashMap parametro = new HashMap();
        parametro.put("titulo", titulo);
        parametro.put("where", where);
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_producao_tinta(
            java.sql.Date data_inicio, java.sql.Date data_fim, String where){
        String pathRelatorio = "src/relatorio/rep_producao_tinta.jasper";
        HashMap parametro = new HashMap();
        parametro.put("where", where);
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_funcionarios_geral(
            java.sql.Date data_inicio, java.sql.Date data_fim){
        String pathRelatorio = "src/relatorio/rep_funcionarios_geral.jasper";
        HashMap parametro = new HashMap();
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_fornecedores_geral(
            java.sql.Date data_inicio, java.sql.Date data_fim){
        String pathRelatorio = "src/relatorio/rep_fornecedores_geral.jasper";
        HashMap parametro = new HashMap();
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_vendas_total(
            java.sql.Date data_inicio, java.sql.Date data_fim, String where){
        String pathRelatorio = "src/relatorio/rep_vendas_total.jasper";
        HashMap parametro = new HashMap();
        parametro.put("where", where);
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_produtos_vendidos(
            java.sql.Date data_inicio, java.sql.Date data_fim, String where,
            String ordenacao, String quantidade){
        String pathRelatorio = "src/relatorio/rep_produtos_vendidos.jasper";
        HashMap parametro = new HashMap();
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        parametro.put("where", where);
        parametro.put("ordenacao", ordenacao);
        parametro.put("quantidade", quantidade);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_produtos_completo(String where){
        String pathRelatorio = "src/relatorio/rep_produtos_completo.jasper";
        HashMap parametro = new HashMap();
        parametro.put("where", where);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_produtos_simples(){
        String pathRelatorio = "src/relatorio/rep_produtos_simples.jasper";
        
        executar_report(pathRelatorio, null);
    }
    
    public static void rep_historico(
            java.sql.Date data_inicio, java.sql.Date data_fim, String where){
        String pathRelatorio = "src/relatorio/rep_historico.jasper";
        HashMap parametro = new HashMap();
        parametro.put("where", where);
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_usuarios(String where){
        String pathRelatorio = "src/relatorio/rep_usuarios.jasper";
        HashMap parametro = new HashMap();
        parametro.put("where", where);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_caixas(String id_caixa){
        String pathRelatorio = "src/relatorio/rep_caixas.jasper";
        HashMap parametro = new HashMap();
        parametro.put("id_caixa", id_caixa);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_pessoas(String doc_principal){
        String pathRelatorio = "src/relatorio/rep_pessoas.jasper";
        HashMap parametro = new HashMap();
        parametro.put("doc_principal", doc_principal);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_controle_ch_ct(
            java.sql.Date data_inicio, java.sql.Date data_fim, String where){
        String pathRelatorio = "src/relatorio/rep_controle_ch_ct.jasper";
        HashMap parametro = new HashMap();
        parametro.put("where", where);
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_despesas(
            java.sql.Date data_inicio, java.sql.Date data_fim, String where, String titulo){
        String pathRelatorio = "src/relatorio/rep_despesas.jasper";
        HashMap parametro = new HashMap();
        parametro.put("titulo", titulo);
        parametro.put("where", where);
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_vendas_melhores_compradores(
            java.sql.Date data_inicio, java.sql.Date data_fim, String where, String quantidade){
        String pathRelatorio = "src/relatorio/rep_vendas_melhores_compradores.jasper";
        HashMap parametro = new HashMap();
        parametro.put("where", where);
        parametro.put("quantidade", quantidade);
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_promocoes(
            java.sql.Date data_inicio, java.sql.Date data_fim, String where){
        String pathRelatorio = "src/relatorio/rep_promocoes.jasper";
        HashMap parametro = new HashMap();
        parametro.put("where", where);
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_compras_total(
            java.sql.Date data_inicio, java.sql.Date data_fim, String where){
        String pathRelatorio = "src/relatorio/rep_compras_total.jasper";
        HashMap parametro = new HashMap();
        parametro.put("where", where);
        parametro.put("data_inicio", data_inicio);
        parametro.put("data_fim", data_fim);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_venda_esp(String id_venda){
        String pathRelatorio = "src/relatorio/rep_venda_esp.jasper";
        HashMap parametro = new HashMap();
        parametro.put("id_venda", id_venda);
        
        executar_report(pathRelatorio, parametro);
    }
    
    public static void rep_compra_esp(String id_compra){
        String pathRelatorio = "src/relatorio/rep_compra_esp.jasper";
        HashMap parametro = new HashMap();
        parametro.put("id_compra", id_compra);
        
        executar_report(pathRelatorio, parametro);
    }
}
