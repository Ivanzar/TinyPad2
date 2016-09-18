package ivanzar.tinypad;

import ivanzar.tinypad.frame.TinyFrame;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;

/**
 *
 * @author ivanzar
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
       
        try {
            
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
        
        TinyFrame f = new TinyFrame();
        f.setTitle("TinyPad");
        
        
    }
    
}
