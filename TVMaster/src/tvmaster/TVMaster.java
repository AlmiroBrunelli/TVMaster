package tvmaster;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Canal;
/*import model.Categoria;
import model.Chamado;
import model.Cliente;
import model.Contrato;
import model.Ilimitado;
import model.Regular;
import model.Top;*/
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.TelaLogin;
//import view.TelaLogin;


public class TVMaster {

    public static void main(String[] args) {
        
        String style = "";
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TVMaster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TVMaster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TVMaster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TVMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        TelaLogin t = new TelaLogin();
        t.setVisible(true);
    }
    
    public static String format(double x) {  
        DecimalFormat df = new DecimalFormat("#0.00");  
        return df.format(x);
    }
    
    public static Canal pegarCanal(String nome, ArrayList<Canal> c) {
        Canal teste = new Canal("Teste", 10f, 24);
        for(Canal canal : c) {
            if(canal.getNome().equals(nome)) {
                return canal;
            }
            
        }
        return teste;    
    }

}
