
package sistema;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Mensagem {
    public static int showConfirmDialog(
            Component componentePai, 
            Object mensagem,
            String titulo){
        Object[] options = { "Sim", "Não" };
        return JOptionPane.showOptionDialog(
                componentePai, 
                mensagem,
                titulo, 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, options, options[0]);
    }
}
