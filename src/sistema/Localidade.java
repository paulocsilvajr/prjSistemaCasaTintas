package sistema;

import lib.jdb.jdbquery.JDBQuery;


public class Localidade {
    private Conexao conexao;
    private JDBQuery consulta;
    
    public Localidade(Conexao conexao){
        this.conexao = conexao;
    }
    
    private String getNomeEstado(String uf){
        conexao.setConsulta(String.format(
                    "SELECT nome_estado " + 
                    "FROM estados WHERE uf = '%s'", uf));
        consulta = conexao.getQuery();
        consulta.execQuery();

        if(consulta.getRow() == 1)
            return consulta.getCurrentFieldValueAsString("nome_estado");
        
        return null;        
    }
    
    /**
     * Função para capturar o cep e o estado(sigla) de acordo com a localidade informada.
     * @param localidade Nome do local que deseja. Pode ser nome de uma cidade 
     * ou localidade que contenha CEP próprio.
     * @return vetor com os campos informados na descrição da função.
     */
    public String[] getCep(String localidade){
        conexao.setConsulta(String.format(
                "SELECT cep, estado FROM localidades " + 
                "WHERE localidade like '%%%s%%'", localidade));
        consulta = conexao.getQuery();
        consulta.setConcurUpdatable(false);
        consulta.execQuery();
        
        String cep, estado;
        if(consulta.getRow() > 0){
            cep = consulta.getCurrentFieldValueAsString("cep");
            estado = consulta.getCurrentFieldValueAsString("estado");
            
            estado = getNomeEstado(estado);
            
            String[] partes = {cep, estado};
            return partes;
        }
        
        return null;
    }
    
    /**
     * Função para decompor a descrição do contato em:
     * Rua, número, Bairro, CEP, Localidade(cidade), Estado.
     * @param descricao Descrição da tabela contato.
     * @return vetor com os campos informados na descrição da função.
     */
    public String[] getLocalidade(String descricao){
        String[] partes = descricao.split(",");
        
        conexao.setConsulta(String.format(
                "SELECT localidade, estado " + 
                "FROM localidades WHERE cep=%s", partes[3]));
        consulta = conexao.getQuery();
        consulta.setConcurUpdatable(false);
        consulta.execQuery();
        
        if(consulta.getRow() > 0){
            String localidade, uf, nomeEstado;
            localidade = consulta.getCurrentFieldValueAsString("localidade");
            uf = consulta.getCurrentFieldValueAsString("estado");

            nomeEstado = getNomeEstado(uf);

            String[] endereco = new String[6];
            endereco[0] = partes[0];
            endereco[1] = partes[1];
            endereco[2] = partes[2];
            endereco[3] = partes[3];
            endereco[4] = localidade;
            endereco[5] = nomeEstado;
            
            return endereco;
        }
        
        return null;
    }
    
    /**
     * Função para retornar a localidade e nome do estado de acordo com CEP informado.
     * @param cep Inteiro representando o CEP.
     * @return vetor com os campos informados na descrição da função.
     */
    public String[] getLocalidade(int cep){
        conexao.setConsulta(String.format(
                "SELECT localidade, estado " + 
                "FROM localidades WHERE cep=%s", cep));
        consulta = conexao.getQuery();
        consulta.setConcurUpdatable(false);
        consulta.execQuery();
        
        if(consulta.getRow() > 0){
            String localidade, uf, nomeEstado;
            localidade = consulta.getCurrentFieldValueAsString("localidade");
            uf = consulta.getCurrentFieldValueAsString("estado");

            nomeEstado = getNomeEstado(uf);
            
            String[] partes = {localidade, nomeEstado};
            
            return partes;
        }
        
        return null;
    }
}
