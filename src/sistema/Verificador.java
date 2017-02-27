
package sistema;

public class Verificador {

    /**
     * Verifica se o valor informado é decimal.
     * @param valor Inteiro ou decimal para verificação
     * @return boolean: true=decimal, false=inteiro
     */
    public static boolean decimal(double valor){
        return valor > Math.floor(valor);
    }
    
    /**
     * Verifica se o texto informado pode ser convertido para decimal ou inteiro.
     * @param texto Valor expresso em texto
     * @return boolean: true= decimal, false=inteiro ou Texto
     */
    public static boolean decimal(String texto){
        double valor; 
        try{
            valor = Double.valueOf(texto);
            
            return decimal(valor);
        }catch(NumberFormatException e){
            return false;
        }
    }
}
