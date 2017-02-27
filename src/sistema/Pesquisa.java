package sistema;

import lib.jdb.connection.JDBConnection;

/**
 * Interface para classe originária de formulário GUI.
 * Pela obrigatoriedade de FrmPesquisa necessitar de uma conexão, deve-se implementar 
 * na classe pai do formulario os métodos desta interface.
 * @author paulo
 */
public interface Pesquisa {
    
    /**
     * Retorno da conexão para o funcionamento correto do formulário pesquisa.
     * @return JDBConnection.
     */
    public JDBConnection getConexao();
}
