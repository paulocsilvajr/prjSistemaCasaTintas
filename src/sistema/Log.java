package sistema;

import lib.jdb.jdbquery.JDBQuery;


public class Log {
    private Conexao conexao;
    
    public Log(Conexao conexao){
        this.conexao = conexao;
    }
    
    private int getCodigoTarefa(String nome){
        conexao.setConsulta(String.format("SELECT id FROM tarefas WHERE nome = '%s'", nome));
        JDBQuery consulta = conexao.getQuery();
        consulta.execQuery();
        
        return consulta.getCurrentFieldValueAsInteger("id");
    }
    
    /**
     * Gravação de log do sistema no histórico.
     * @param usuario Nome do usuário.
     * @param nomeTarefa Nome da tarefa(nome do formulário ou tarefa)
     * @param codigo Código da operação(geralmente id da tabela pai do formulário).
     * @param descricao Descrição da ação para registrar no log.
     */
    public void gravar(String usuario, String nomeTarefa, String codigo, String descricao){
        int idTarefa = getCodigoTarefa(nomeTarefa);
        
        conexao.setTransacao(String.format("INSERT INTO historico("
                + "nome_usuario,"
                + "id_tarefa,"
                + "codigo,"
                + "descricao)"
                + "VALUES("
                + "'%s', '%s', '%s', '%s');", 
                usuario,
                idTarefa,
                codigo,
                descricao));
    }
    
    /**
     * Gravação de log do sistema no histórico.
     * @param usuario Nome do usuário.
     * @param nomeTarefa Nome da tarefa(nome do formulário ou tarefa)
     * @param descricao Descrição da ação para registrar no log.
     */
    public void gravar(String usuario, String nomeTarefa, String descricao){
        int idTarefa = getCodigoTarefa(nomeTarefa);
        
        conexao.setTransacao(String.format("INSERT INTO historico("
                + "nome_usuario,"
                + "id_tarefa,"
                + "codigo,"
                + "descricao)"
                + "VALUES("
                + "'%s', '%s', %s, '%s');", 
                usuario,
                idTarefa,
                "NULL",
                descricao));
    }
    
    /**
     * Gravação de log do sitema no histórico.
     * @param usuario Nome do usuário.
     * @param nomeTarefa Nome da tarefa(nome do formulário ou tarefa)
     * @param codigo Código da operação(geralmente id da tabela pai do formulário).
     * @param padrao Código de entrada padrão para o histórico.
     * 0=acessado tarefa,
     * 1=inserido registro,
     * 2=modificado registro,
     * 3=apagado registro,
     * default=efetuado operação
     */
    public void gravar(String usuario, String nomeTarefa, String codigo, int padrao){
        int idTarefa = getCodigoTarefa(nomeTarefa);
        
        String mensagem;
        switch(padrao){
            case 0: mensagem = "acessado tarefa"; break;
            case 1: mensagem = "inserido registro"; break;
            case 2: mensagem = "modificado registro"; break;
            case 3: mensagem = "apagado registro"; break;
            default: mensagem = "efetuado operação"; break;
        }
        
        conexao.setTransacao(String.format("INSERT INTO historico("
                + "nome_usuario,"
                + "id_tarefa,"
                + "codigo,"
                + "descricao)"
                + "VALUES("
                + "'%s', '%s', '%s', '%s');", 
                usuario,
                idTarefa,
                codigo,
                mensagem));
    }
    
    /**
     * Gravação de log do sitema no histórico.
     * @param usuario Nome do usuário.
     * @param nomeTarefa Nome da tarefa(nome do formulário ou tarefa)
     * @param padrao Código de entrada padrão para o histórico. 
     * 0=acessado tarefa,
     * 1=inserido registro,
     * 2=modificado registro,
     * 3=apagado registro,
     * default=efetuado operação
     */
    public void gravar(String usuario, String nomeTarefa, int padrao){
        int idTarefa = getCodigoTarefa(nomeTarefa);
        
        String mensagem;
        switch(padrao){
            case 0: mensagem = "acessado tarefa"; break;
            case 1: mensagem = "inserido registro"; break;
            case 2: mensagem = "modificado registro"; break;
            case 3: mensagem = "apagado registro"; break;
            default: mensagem = "efetuado operação"; break;
        }
        
        conexao.setTransacao(String.format("INSERT INTO historico("
                + "nome_usuario,"
                + "id_tarefa,"
                + "codigo,"
                + "descricao)"
                + "VALUES("
                + "'%s', '%s', %s, '%s');", 
                usuario,
                idTarefa,
                "NULL",
                mensagem));
    }
    
    public static String nomeTarefa(Object tarefa){
        String nomeTarefa = tarefa.getClass().getName();
        String[] classe = nomeTarefa.split("[.]");
        return classe[classe.length - 1];
    }
    
    /**
     * Gravação de log do sitema no histórico.
     * @param usuario Nome do usuário.
     * @param tarefa object do formulário da tarefa
     * @param codigo Código da operação(geralmente id da tabela pai do formulário).
     * @param padrao Código de entrada padrão para o histórico.
     * 0=acessado tarefa,
     * 1=inserido registro,
     * 2=modificado registro,
     * 3=apagado registro,
     * default=efetuado operação
     */
    public void gravar(String usuario, Object tarefa, String codigo, int padrao){
        gravar(usuario, nomeTarefa(tarefa), codigo, padrao);
    }
    
    /**
     * Gravação de log do sitema no histórico.
     * @param usuario Nome do usuário.
     * @param tarefa object do formulário da tarefa
     * @param padrao Código de entrada padrão para o histórico.
     * 0=acessado tarefa,
     * 1=inserido registro,
     * 2=modificado registro,
     * 3=apagado registro,
     * default=efetuado operação
     */
    public void gravar(String usuario, Object tarefa, int padrao){
        gravar(usuario, nomeTarefa(tarefa), padrao);
    }
}
