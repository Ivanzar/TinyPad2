package ivanzar.tinypad.frame;

import ivanzar.tinypad.Syntax;
import ivanzar.tinypad.variable.Variables;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author ivanzar
 */
public class FileChooser {
    
    private static JFileChooser mFC = null;
    
    /**
     *
     */
    public FileChooser(){
    
        JFileChooser fc = new JFileChooser();
        mFC = fc;
        
    }
    
    /**
     *
     * @param panel
     * @return
     */
    public String[] open(JPanel panel){
        
        String[] result = new String[2];
    
             mFC.setDragEnabled(true);
        if(mFC.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION){
        
            System.out.println(mFC.getSelectedFile());
            
            try {
                BufferedReader in = new BufferedReader(new FileReader(mFC.getSelectedFile()));
                String redaText = "";
                String text = "";
                while((redaText = in.readLine()) !=null ) text = text.concat(redaText.concat("\n"));
                
                //System.out.println(text);
                
                result[0] = mFC.getName(mFC.getSelectedFile());
                result[1] = text;
                        result[0] = mFC.getName(mFC.getSelectedFile());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileChooser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileChooser.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        
        }
        
        return result;
             
    }
    
    /**
     *
     * @param text
     * @param panel
     */
    public void saveHow(String text, JPanel panel){
    
        mFC.setDragEnabled(true);
        if(mFC.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION){
        
            try {
                PrintWriter out = new PrintWriter(mFC.getSelectedFile());
        
        try{
            
            out.print(text);
            
        }finally{out.close();}
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileChooser.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
