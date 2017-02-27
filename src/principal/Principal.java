package principal;

public class Principal {
    public static FrmLogin login;
    public static sistema.Conexao conexao;

    public static void main(String[] args) {
        conexao = new sistema.Conexao("casa_tintas");

        login = new FrmLogin();
        login.setVisible(true);
    }
    
}
