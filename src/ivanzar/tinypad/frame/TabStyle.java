/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivanzar.tinypad.frame;

import javax.swing.plaf.basic.*;
import java.awt.*;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import static javax.swing.SwingConstants.TOP;

/**
 *
 * @author ivanzar
 */
public class TabStyle extends BasicTabbedPaneUI{
    
    
     /*@Override
     protected void paintTab(Graphics g, int tabPlacement,
                            Rectangle[] rects, int tabIndex,
                            Rectangle iconRect, Rectangle textRect) {
         super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
         
         g.setColor(Color.BLACK);
         g.fillRect(rects[tabIndex].x, 
                 rects[tabIndex].y, 
                 rects[tabIndex].width, 
                 rects[tabIndex].height);
         
         
     }*/

    /**
     *
     * @param g
     * @param tabPlacement
     * @param tabIndex
     * @param x
     * @param y
     * @param w
     * @param h
     * @param isSelected
     */

    
    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement,
                                      int tabIndex,
                                      int x, int y, int w, int h,
                                      boolean isSelected ){
    super.paintTabBackground(g, tabPlacement, tabIndex, x, y, w, h, isSelected);
    
    
        g.setColor(new Color(242, 241 ,240));
    
        switch(tabPlacement) {
          case LEFT:
              g.fillRect(x+1, y+1, w-1, h-3);
              break;
          case RIGHT:
              g.fillRect(x, y+1, w-2, h-3);
              break;
          case BOTTOM:
              g.fillRect(x+1, y, w-3, h-1);
              break;
          case TOP:
          default:
              g.fillRect(x+1, y+1, w-3, h-1);
        }
    
    
    }
    
    
    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement,
                                  int tabIndex,
                                  int x, int y, int w, int h,
                                  boolean isSelected ) {
        super.paintTabBorder(g, tabPlacement, tabIndex, x, y, w, h, isSelected);
        g.setColor(Color.GRAY);

        switch (tabPlacement) {
          case LEFT:
              g.drawLine(x+1, y+h-2, x+1, y+h-2); // bottom-left highlight
              g.drawLine(x, y+2, x, y+h-3); // left highlight
              g.drawLine(x+1, y+1, x+1, y+1); // top-left highlight
              g.drawLine(x+2, y, x+w-1, y); // top highlight

              //g.setColor(Color.GRAY);
              g.drawLine(x+2, y+h-2, x+w-1, y+h-2); // bottom shadow

              /*g.setColor(Color.GRAY);
              g.drawLine(x+2, y+h-1, x+w-1, y+h-1); // bottom dark shadow*/
              break;
          case RIGHT:
              g.drawLine(x, y, x+w-3, y); // top highlight

              //g.setColor(Color.GRAY);
              g.drawLine(x, y+h-2, x+w-3, y+h-2); // bottom shadow
              g.drawLine(x+w-2, y+2, x+w-2, y+h-3); // right shadow

              /*g.setColor(Color.GRAY);
              g.drawLine(x+w-2, y+1, x+w-2, y+1); // top-right dark shadow
              g.drawLine(x+w-2, y+h-2, x+w-2, y+h-2); // bottom-right dark shadow
              g.drawLine(x+w-1, y+2, x+w-1, y+h-3); // right dark shadow
              g.drawLine(x, y+h-1, x+w-3, y+h-1); // bottom dark shadow*/
              break;
          case BOTTOM:
              g.drawLine(x, y, x, y+h-3); // left highlight
              g.drawLine(x+1, y+h-2, x+1, y+h-2); // bottom-left highlight

              //g.setColor(Color.GRAY);
              g.drawLine(x+2, y+h-2, x+w-3, y+h-2); // bottom shadow
              g.drawLine(x+w-2, y, x+w-2, y+h-3); // right shadow

             /* g.setColor(Color.GRAY);
              g.drawLine(x+2, y+h-1, x+w-3, y+h-1); // bottom dark shadow
              g.drawLine(x+w-2, y+h-2, x+w-2, y+h-2); // bottom-right dark shadow
              g.drawLine(x+w-1, y, x+w-1, y+h-3); // right dark shadow
              */
              break;
          case TOP:
          default:
              g.drawLine(x, y+2, x, y+h-1); // left highlight
              g.drawLine(x+1, y+1, x+1, y+1); // top-left highlight
              g.drawLine(x+2, y, x+w-3, y); // top highlight

              //g.setColor(Color.GRAY);
              g.drawLine(x+w-2, y+2, x+w-2, y+h-1); // right shadow

              /*g.setColor(Color.GRAY);
              g.drawLine(x+w-1, y+2, x+w-1, y+h-1); // right dark-shadow
              g.drawLine(x+w-2, y+1, x+w-2, y+1); // top-right shadow*/
        }
    }
    
    /**
     *
     * @param g
     * @param tabPlacement
     * @param selectedIndex
     */
    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
       

        paintContentBorderTopEdge(g, tabPlacement, selectedIndex, 0, 0, 0, 0);
        paintContentBorderLeftEdge(g, tabPlacement, selectedIndex, 0, 0, 0, 0);
        paintContentBorderBottomEdge(g, tabPlacement, selectedIndex, 0, 0, 0, 0);
        paintContentBorderRightEdge(g, tabPlacement, selectedIndex, 0, 0, 0, 0);

    }
    
}
