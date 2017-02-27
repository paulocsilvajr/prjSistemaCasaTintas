
package sistema;

import java.io.File;
import java.io.IOException;

public class Backup {
    private final Conexao conexao;
    private final String os;
    
    public Backup(Conexao conexao){
        this.conexao = conexao;
        
        os = (String)System.getProperties().get("os.name");
    }
    
    public void salvar(){
        operacao(0, "");
    }
    
    public void restaurar(String arquivo){
        operacao(1, arquivo);
    }
    
    public boolean salvar(File arquivo){
        return operacao(0, arquivo);
    }
    
    public boolean restaurar(File arquivo){
        return operacao(1, arquivo);
    }
    
    public void operacao(int op, String arquivo){
        boolean operacao = operacao(op, new File(arquivo));
    }
    
    public boolean operacao(int op, File arquivo){
        String comando, direcionador;
        File arq;
        
        if(op == 1){
            comando = "mysql";
            direcionador = " < ";
            
            arq = arquivo;
        }else{
            comando = "mysqldump";
            direcionador = " > ";
            
            arq = new File(arquivo.getPath() + 
                    sistema.Data.getAtualFormatada("/yyyyMMdd_HHmmss") + 
                    "_casa_tintas.sql");
        }
        
        String parametros, parametrosWin;
        parametros = " -u " + conexao.getUsuarioConectado() + 
                        " -p" + conexao.getSenha() + " " + conexao.getBanco() + 
                        direcionador + arq.getPath();
        parametrosWin = " " + conexao.getBanco() + direcionador + arq.getPath() +
                        " -h " + conexao.getHost() + " -u " + conexao.getUsuarioConectado() + 
                        " -p" + conexao.getSenha();

        String[] bkpLinux = {"/bin/sh", "-c","/opt/lampp/bin/" + comando + parametros};
        String[] bkpWin = {"cmd", "/c", "c:\\xampp\\mysql\\bin\\" + comando + parametrosWin};       

        try{
            if(os.equals("Linux")){
                Process p = Runtime.getRuntime().exec(bkpLinux);
            }else{
                Process p = Runtime.getRuntime().exec(bkpWin);
            }
            
            return true;
        }catch(IOException ex){
            System.err.println(ex.getMessage());
            
            return false;
        }
    }
}
