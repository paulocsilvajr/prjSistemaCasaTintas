
package sistema;

import lib.jdb.jdbquery.JDBQuery;

public class Configuracoes {
    private JDBQuery configuracoes;
    
    public Configuracoes(Conexao conexao) {
        configuracoes = new JDBQuery();
        configuracoes.setJDBConnection(conexao.getConexao());
        configuracoes.setSQL("SELECT id, descricao, valor FROM configuracoes");
        configuracoes.execQuery();
    }
    
    public JDBQuery getQuery(){
        return configuracoes;
    }
    
    public String getValor(int id){
        String valor = "";
        
        configuracoes.first();
        if(configuracoes.getRow() == 1){
            do{
                if(configuracoes.getCurrentFieldValueAsInteger("id") == id){
                    
                    valor = configuracoes.getCurrentFieldValueAsString("valor");
                    
                    break;
                }
            }while(configuracoes.next() != -1);
        }
        
        return valor;
    }
    
    public String getValor(String descricao){
        String valor = "";
        
        configuracoes.first();
        if(configuracoes.getRow() == 1){
            do{
                if(configuracoes.getCurrentFieldValueAsString("descricao").contains(descricao)){
                    
                    valor = configuracoes.getCurrentFieldValueAsString("valor");
                    
                    break;
                }
            }while(configuracoes.next() != -1);
        }
        
        return valor;
    }
    
}
