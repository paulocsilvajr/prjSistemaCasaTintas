package sistema;

import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import lib.jdb.connection.JDBConnection;
import lib.jdb.control.jdblabelcount.JDBLabelCount;
import lib.jdb.control.jdbtable.JDBTable;
import lib.jdb.jdbquery.JDBQuery;

public class PesquisaSimples {
    private final JDBConnection conexao;
    private final JDBQuery qryOrigem; 
    private final String chave;
    private final LinkedHashMap<String, String> valorComboBox;
    private final HashMap<String, String> titulos;
    private final String sql;
    private final String[] camposInvisiveis;
    private final int[] larguraCamposVisiveis;
    private JDBQuery qryPesquisa;
    private JDBTable tabela_origem;
    
    public PesquisaSimples(JDBConnection conexao,
            JDBQuery qryOrigem,
            String chave,
            LinkedHashMap<String,String> valoresComboBox, 
            HashMap<String,String> titulosColunas,
            String sql,
            String[] camposInvisiveis, 
            int[] larguraCamposVisiveis) {
        
        this.conexao = conexao;
        this.valorComboBox = valoresComboBox;
        this.titulos = titulosColunas;
        this.sql = sql;
        this.camposInvisiveis = camposInvisiveis;
        this.larguraCamposVisiveis = larguraCamposVisiveis;
        this.qryOrigem = qryOrigem;
        this.chave = chave;
    }
    
    public JDBQuery getQryPesquisa(){
        return qryPesquisa;
    }
    
    public JDBQuery getQryOrigem(){
        return qryOrigem;
    }
    
    public String getChave(){
        return chave;
    }
    
    public String getSql(){
        return sql;
    }
    
    public void dadosIniciais(
            JComboBox<String> cbxPesquisa,
            JDBTable tblPesquisa,
            JDBLabelCount lblContador){        
        // Adicionando elementos no combobox pesquisa.
        for(String valor: this.valorComboBox.keySet()){
            cbxPesquisa.addItem(valor);
        }
        
        // Query local de pesquisa.
        qryPesquisa = new JDBQuery();
        qryPesquisa.setJDBConnection(conexao);
        qryPesquisa.setSQL(sql);  
        qryPesquisa.setDateFormat("dd/MM/yyyy");
        qryPesquisa.setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
        qryPesquisa.setLanguage("pt");
        qryPesquisa.setDecimalFormat("0.000");
        qryPesquisa.setConcurUpdatable(false);
        
        // Atribuindo a query na tabela e no label contador.
        tblPesquisa.setJDBQuery(qryPesquisa);
        lblContador.setjDBQuery(qryPesquisa);
        tabela_origem = tblPesquisa;
        
        // Ocultando campos na tabela.
        if(camposInvisiveis != null){
            String temp = "";
            for(String campo: camposInvisiveis){
                temp += campo + " ";
            }
            
            tblPesquisa.setInvisibleFields(temp);
        }
        
        // Se for informado os tamanhos, será atribuido de acordo com atributo 
        // larguraCamposVisiveis, caso contrário, será redimensionado 
        // automaticamente(todas as colunas do mesmo tamanho, ocupando a área da tabela).
        if(larguraCamposVisiveis != null){
    
            if(titulos.keySet().size() == larguraCamposVisiveis.length){

                tblPesquisa.setAutoResizeMode(tblPesquisa.AUTO_RESIZE_OFF);
                int i=0;
                for(String coluna: titulos.keySet()){
                    tblPesquisa.setFieldsWidth(titulos.get(coluna), larguraCamposVisiveis[i]);
                    i++;
                }
            }
        }
        
        // Atribuindo títulos informados no atributo hashmap titulos.
        for(String titulo: titulos.keySet()){
            tblPesquisa.setFieldsTitle(titulos.get(titulo), titulo);
        }
        
        // Executando query para carregamento inicial dos dados.
        qryPesquisa.execQuery();
    }

    public void pesquisar(JComboBox<String> cbxPesquisa, JTextField txtPesquisa){
        // Método invocado no filtro da tabela.
        String campo = valorComboBox.get(cbxPesquisa.getSelectedItem());
        
        // implementar
//      java.sql.Timestamp;
        
        String temp, tipo, texto;
        tipo = qryPesquisa.getFieldTypeName(campo);
        texto = txtPesquisa.getText();
        temp = "";
        
        // se pesquisa for em um campo que é string:
        if(tipo.equals("String")){
            if(texto.contains(" "))
                texto = texto.replaceAll("[ ]+", "%");
                
            temp = sql + " WHERE " + 
                    campo + 
                    " like '%" + texto + "%'";
        // se pesquisa foi em data:
        }else if(tipo.equals("java.sql.Date")){
            String[] partes = texto.split("/");
            if(partes.length == 3){
                texto = String.format("%s-%s-%s", partes[2], partes[1], partes[0]);

                temp = sql + " WHERE " + 
                        campo + 
                        " = '" + texto + "'";
            }else if(partes.length == 2){
                texto = String.format("%s-%s", partes[1], partes[0]);

                temp = sql + " WHERE " + 
                        campo + 
                        " LIKE '%" + texto + "%'";
            }else{
                texto = texto.replaceAll("[ ]+", "%");
                temp = sql + " WHERE " + 
                        campo + 
                        " LIKE '%" + texto + "%'";
            }
        // se for de outro tipos:
        }else{
            // se for vazia, não adiciona a clausula WHERE
            if(texto.isEmpty()){
                temp = sql;
            // senão adiciona WHERE com comparação simples
            }else{
                // para casos de ser informado um valor decimal
                if(texto.contains(",")){
                    texto = texto.replaceAll("[,]+", ".");
                }
                
                temp = sql + " WHERE " + 
                       campo + 
                       " = '" + texto + "'";
            }
        }
        
        // adicionando a ordenação pelo campo selecionado no combobox
        temp += " ORDER BY " + campo;
        
        qryPesquisa.setSQL(temp);
        qryPesquisa.setConcurUpdatable(false);
        //teste, visualizando a instrução SQL
//        System.out.println(qryPesquisa.getPlainSQL());
        //
        qryPesquisa.execQuery();
    }
    
    public void gerarQryPesquisa(){
        // Alimentando a query origem com a informação clicada na tabela da pesquisa.
        String valor = qryPesquisa.getCurrentFieldValue(chave);
        
        // caso a chave(nome chave primária) seja a mesma do primeira coluna,
        // sobrescreve o valor capturado acima.
        // Função usada para pegar o item certo quando é aplicado a 
        // ordenação(sorting) por coluna visualmente(auto-sort da jdbtable)
        if(tabela_origem.getColumnName(0).equals(chave)){
            valor = String.valueOf(
                            tabela_origem.getValueAt(
                                    tabela_origem.getSelectedRow(),
                                    0 ) );
        }

        // Formatação de campo tipo String, coloca-se aspas('') entre o valor capturado.
        if(qryPesquisa.getFieldTypeName(chave).equals("String")){
            qryOrigem.setSQL(sql + " WHERE " + chave + " = '" + valor + "'");
        }else{
            qryOrigem.setSQL(sql + " WHERE " + chave + " = " + valor);
        }

        qryOrigem.setConcurUpdatable(false);
        qryOrigem.setDateFormat("dd/MM/yyyy");
        qryOrigem.setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
        qryPesquisa.setLanguage("pt");
        qryOrigem.execQuery();
    }
}
