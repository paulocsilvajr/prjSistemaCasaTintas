package sistema;

import java.sql.ResultSet;
import java.sql.SQLException;
import lib.jdb.connection.JDBConnection;
import lib.jdb.jdbquery.JDBQuery;
import lib.jdb.jdbupdate.JDBUpdate;

public class Conexao {
    private final JDBConnection conexao;
    private final String nomeBanco;
    private final String host;
    private JDBQuery query;
    private JDBUpdate update;
    private String sql;
    
    public Conexao(String nomeBanco){
        this.nomeBanco = nomeBanco;
        conexao = new JDBConnection();
        conexao.setUsingFileConfig(false);
        conexao.setDriver("com.mysql.jdbc.Driver");
        host = "localhost";
        conexao.setURL("jdbc:mysql://" + host + "/" + this.nomeBanco);
        conexao.setUserName("root");
        conexao.setPassword("");
        conexao.setIdiom("pt");
        
        conectar();
    }
    
    public void novaConexao(String user, String password){
        desconectar();
                
        conexao.setUserName(user);
        conexao.setPassword(password);
        
        conectar();
    }
    
    public void abrirTransacoes(){
        try {
            conexao.prepareTransaction();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void fecharTransacoes(){
        try{
            conexao.commitTransaction();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void cancelarTransacoes(){
        try{
            conexao.rollbackTransaction();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    public String toString(){
        return String.format(
                "Banco:   %s\n" + 
                "Usuário: %s\n" + 
                "Driver:  %s\n" + 
                "URL:     %s\n", nomeBanco, conexao.getUserName(), 
                             conexao.getDriver(), conexao.getURL());
    }
    
    public String getHost(){
        return host;
    }
    
    public String getBanco(){
        return nomeBanco;
    }
    
    public JDBConnection getConexao(){
        return conexao;
    }
    
    private void conectar(){
        conexao.connectDB();
    }
    
    private void desconectar(){
        conexao.disconnetDB();
    }
    
    public String getUsuarioConectado(){
        return conexao.getUserName();
    }
    
    public String getSenha(){
        return conexao.getPassword();
    }
    
    public void setConsulta(String sql){
        this.sql = sql;
        query = new JDBQuery();
        query.setJDBConnection(conexao);
        query.setSQL(sql);
        query.setLanguage("pt");
        query.setDateFormat("dd/MM/yyyy");
        query.setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
        query.setDecimalFormat("0,000");
        
        // O método .setConcurUpdatable(false) desativa a possibilidade de inserções pela query. 
//        query.setConcurUpdatable(false);
        // O método execQuery deve ser invocado pelo objeto que receber getQuery.
//        query.execQuery();   
    }
    
    public void setTransacao(String sql){
        this.sql = sql;
        update = new JDBUpdate();
        update.setJDBConnection(conexao);
        update.setSQL(sql);
        
        update.execUpdate();
    }
    
    public String getSql(){
        return sql;
    }
    
    public ResultSet getResultSet(){
        ResultSet resultado = query.getResultSet();
        try{
            resultado.beforeFirst();
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return resultado;
    }
    
    public JDBQuery getQuery(){
        return query;
    }

    public JDBUpdate getUpdate(){
        return update;
    }
}

