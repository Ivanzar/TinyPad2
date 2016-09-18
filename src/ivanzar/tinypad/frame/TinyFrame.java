package ivanzar.tinypad.frame;

import ivanzar.tinypad.Syntax;
import ivanzar.tinypad.variable.Variables;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.*;

import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rtextarea.RTextScrollPane;

import ivanzar.tinypad.Syntax;

/**
 *
 * @author ivanzar
 */
public class TinyFrame extends JFrame{
    
    JPanel mPanel = null;
    static JTabbedPane mTabbedPane = new JTabbedPane(JTabbedPane.TOP);
    
    /**
     *
     */
    public TinyFrame(){
    
        SwingUtilities.invokeLater(() -> {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setTitle("TinyPad");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        });
        
         SwingUtilities.invokeLater(() -> {
             add(showPanel());
        });
    
    }
    
    /**
     *
     * @return
     */
    public JPanel showPanel(){
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(showSplitPane(), BorderLayout.CENTER);
    panel.add(showToolBar(), BorderLayout.PAGE_START);
    
    return mPanel = panel;
    }
    
    ArrayList<RSyntaxTextArea> mTextArea = new ArrayList<>();
    
    
    //Code area

    /**
     *
     * @return
     */
    public JScrollPane showTextArea(){
      
      RSyntaxTextArea textArea = new RSyntaxTextArea(20, 30);
      mTextArea.add(textArea);
      
      textArea.setSyntaxEditingStyle(Variables.SYNTAX);
      textArea.setCodeFoldingEnabled(true);
      RTextScrollPane scroll = new RTextScrollPane(textArea);
      
    return scroll;
    }
    
    /**
     *
     * @param text
     * @return
     */
    public JScrollPane showTextArea(String text){
      
      RSyntaxTextArea textArea = new RSyntaxTextArea(20, 30);
      mTextArea.add(textArea);
      
      textArea.setSyntaxEditingStyle(Variables.SYNTAX);
      textArea.setCodeFoldingEnabled(true);
      textArea.setText(text);
      RTextScrollPane scroll = new RTextScrollPane(textArea);
      
    return scroll;
    }
    
    /**
     *
     * @return
     */
    public JToolBar showToolBar() {
    
        JToolBar toolBar = new JToolBar("Code editor");
    
         BufferedImage logo = null;
         
         JButton butOpenFile = new JButton();//choose file
         JButton butSaveHow = new JButton();//save file
        
        try {
            logo = ImageIO.read(new File("images/ofolder.png"));
            butOpenFile.setIcon(new ImageIcon(logo));
            
            logo = ImageIO.read(new File("images/save-all.png"));
            butSaveHow.setIcon(new ImageIcon(logo));
            
        } catch (IOException ex) {
            Logger.getLogger(TinyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        toolBar.add(butOpenFile);
        toolBar.add(butSaveHow);
        
        openFileListener(butOpenFile);
        saveFileHowListener(butSaveHow);
        
        return toolBar;
    }
    
    /**
     *
     * @return
     */
    public JSplitPane showSplitPane(){
    
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    
        tabbedPane.add("Files", new Label("Comming soon"));
        tabbedPane.add("Plugins", new Label("Comming soon"));
        
        addTabb("Hello", mTabbedPane, showTextArea());
      
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabbedPane, mTabbedPane);
        sp.setPreferredSize(new Dimension(100, 400));
        
        return sp;
    }
                
    /**
     *
     * @param text
     * @param tabbedPane
     * @param comp
     */
    public static void addTabb(String text, JTabbedPane tabbedPane, JComponent comp){
        tabbedPane.addTab(text, comp);
        //System.out.println("DEB"+tabbedPane.getTabCount());
        tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, new TabbClose(tabbedPane));
    }
    
    
    private void openFileListener(JButton button){
        
        button.addActionListener(ActionEvent->{
            
            FileChooser fl = new FileChooser();
            String[] opneTab = fl.open(mPanel);
            if(opneTab[0] != null){
            
            Variables.SYNTAX = Syntax.getSyntax(opneTab[0]);
            addTabb(opneTab[0], mTabbedPane, showTextArea(opneTab[1]));
            }
            
        });
        
    }
    
   private void saveFileHowListener(JButton button){
       
        button.addActionListener(ActionListner->{
            //System.out.println("DEBUG "+mTabbedPane.getSelectedIndex());
            new FileChooser().
                    saveHow(
                            mTextArea.
                                    get(mTabbedPane.getSelectedIndex()).getText(), mPanel);
            
        });
       
   }
    
    
}
