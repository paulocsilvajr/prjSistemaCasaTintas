
package sistema;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data {

    /**
     * Retorna data atual.
     * @return Date da data atual.
     */
    public static Date getAtual(){
        return new Date(System.currentTimeMillis());  
    }
    
    /**
     * Retorna data no formato yyyy-MM-dd.
     * @return String com data atual formatada.
     */
    public static String getAtualFormatada(){
        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
        return formatarData.format(getAtual());
    }
    
    public static String getAtualSQL(){
        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatarData.format(getAtual());
    }
    
    /**
     * Retorna data no formato informado pelo usuário.
     * @param formato String do formato da data. Ex: dd/MM/yyyy.
     * @return String com data atual formatada.
     */
    public static String getAtualFormatada(String formato){
        SimpleDateFormat formatarData = new SimpleDateFormat(formato);
        return formatarData.format(getAtual());
    }
    
    public static String formatarData(Date data, String formato){
        SimpleDateFormat formatar = new SimpleDateFormat(formato);
        return formatar.format(data);
    }
    
    public static Date getAcrescimoDias(Date data, int dias){
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + dias);
        return cal.getTime();
    }
    
    public static String getAtualAcrescimoDiasSQL(int dias){
        Date data = getAcrescimoDias(getAtual(), dias);
        SimpleDateFormat formatar = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatar.format(data);
    }
}
