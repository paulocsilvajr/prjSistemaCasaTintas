package sistema;

import java.awt.Component;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import lib.jdb.jdbquery.JDBQuery;

public class Usuario {
    private Conexao conexao;
    private JDBQuery qryPermissao, qryTarefas;
    private String nome, descricaoTipo;
    private boolean admin;
    private int idTipo;
    
    public Usuario(Conexao conexao){
        this.conexao = conexao;
        
        nome = "";
        descricaoTipo = "";
        admin = false;
        idTipo = 0;
    }
    
    public String getNomeUsuario(){
        return nome;
    }
    
    public String getDescricaoTipoUsuario(){
        return descricaoTipo;
    }
    
    public int getIdTipoUsuario(){
        return idTipo;
    }
    
    public boolean isAdmin(){
        return admin;
    }
    
    public static String criptografarSenha(String senha){
        String senhaCriptografada = "";
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            senhaCriptografada = hexString.toString();
            
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.err.println(ex.getMessage());
        }
        
        return senhaCriptografada;
    }
    
    public static String criptografarSenha20(String senha){
        return criptografarSenha(senha).substring(0, 20);
    }
    
    private void recuperarPermissoes(){
        conexao.setConsulta(String.format(
                "SELECT "
                    + "id, id_tipo_usuario, descricao_tipo_usuario, "
                    + "id_tarefa, nome_tarefa, descricao_tarefa, "
                    + "acesso, acesso_desc, gravacao, gravacao_desc, "
                    + "remocao, remocao_desc, data_inclusao, data_modificacao "
                + "FROM vw_tarefas_tipo_usuario "
                + "WHERE id_tipo_usuario = %s", idTipo));
        qryPermissao = conexao.getQuery();
        qryPermissao.setConcurUpdatable(false);
        qryPermissao.execQuery();
    }
    
    public void atualizarPermissao(){
        qryPermissao.execQuery();
    }
    
    private String recuperarDescricaoTarefa(String nomeTarefa){
        conexao.setConsulta(String.format(
                "SELECT id, nome, descricao "
                + "FROM tarefas "
                + "WHERE nome = '%s'", nomeTarefa));
        qryTarefas = conexao.getQuery();
        qryTarefas.setConcurUpdatable(false);
        qryTarefas.execQuery();
        
        return qryTarefas.getCurrentFieldValueAsString("descricao");
    }
    
    /**
     * Verificação de permissão em determinada tarefa e ação.
     * @param tarefa Nome da tarefa(nome do formulário ou tarefa)
     * @param acao Descrição das ações(acesso, gravacao, remocao)
     * @return true se o usuário satisfazer os parametros.
     */
    public boolean verificarPermissao(Component formOrigem, String tarefa, String acao){
        boolean verificacao = false;
        
        if(!admin){
            qryPermissao.first();
            if(qryPermissao.getRow() == 1){
                do{
                    if(qryPermissao.getCurrentFieldValueAsString("nome_tarefa").
                            equals(tarefa) && 
                        qryPermissao.getCurrentFieldValueAsBoolean(acao)){
                        
                        verificacao = true;
                        break;
                    }
                }while(qryPermissao.next() != -1);
                
            }
        }else{
            verificacao = true;
        }
        
        String acoesMensagem = "";
        switch (acao) {
            case "acesso":
                acoesMensagem = "Acesso em ";
                break;
            case "gravacao":
                acoesMensagem = "Gravação em ";
                break;
            case "remocao":
                acoesMensagem = "Remoção em ";
                break;
        }
        
        if(!verificacao){
            JOptionPane.showMessageDialog(formOrigem, "Usuário " +
                    nome + " não tem permissão para efetuar a tarefa:\n"
                    + acoesMensagem + recuperarDescricaoTarefa(tarefa),
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return verificacao;
    }
    
    /**
     * Verificação de permissão em determinada tarefa e ação.
     * @param tarefa Nome da tarefa(nome do formulário ou tarefa)
     * @param acao Inteiro representando as ações(0=acesso, 1=gravacao, 2=remocao)
     * @return true se o usuário satisfazer os parametros.
     */
    public boolean verificarPermissao(Component formOrigem, String tarefa, int acao){
        String[] acoes = {"acesso", "gravacao", "remocao"};
        
        if(acao < 0 || acao >= acoes.length){
            return false;
        }
        
        return verificarPermissao(formOrigem, tarefa, acoes[acao]);
    }
    
    /**
     * Verificação de permissão em determinada tarefa e ação.
     * @param tarefa object referente ao formulário
     * @param acao Inteiro representando as ações(0=acesso, 1=gravacao, 2=remocao)
     * @return true se o usuário satisfazer os parametros.
     */
    public boolean verificarPermissao(Object tarefa, int acao){
        return verificarPermissao((Component)tarefa, sistema.Log.nomeTarefa(tarefa), acao);
    }
    
    public boolean loginUsuario(String nome, String senha){
        conexao.setConsulta(String.format(
                "SELECT "
                    + "nome, senha, administrador, tipo, descricao_tipo "
                + "FROM vw_usuarios "
                + "WHERE nome = '%s'", nome));
        JDBQuery consulta = conexao.getQuery();
        consulta.setConcurUpdatable(false);
        consulta.execQuery();
        
        String criptSenhaInserida, nomeBanco, senhaBanco;
        
        criptSenhaInserida = criptografarSenha20(senha);
        
        if(consulta.getRow() == 0){
            JOptionPane.showMessageDialog(null, "Nome de usuário inválido", 
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            
            return false;
        }
        
        nomeBanco = consulta.getCurrentFieldValueAsString("nome");
        senhaBanco = consulta.getCurrentFieldValueAsString("senha");
        this.nome = nomeBanco;
        admin = consulta.getCurrentFieldValueAsBoolean("administrador");
        idTipo = consulta.getCurrentFieldValueAsInteger("tipo");
        descricaoTipo = consulta.getCurrentFieldValueAsString("descricao_tipo") == null?
                "administrador do sistema":consulta.getCurrentFieldValueAsString("descricao_tipo");
        
        boolean login = senhaBanco.equals(criptSenhaInserida) && nomeBanco.equals(nome);
        if(login){
            recuperarPermissoes();
        }else{
            JOptionPane.showMessageDialog(null, "Senha inválida", 
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
   
        return login;
    }
}
