//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007 Openbravo, S.L.
//    http://sourceforge.net/projects/openbravopos
//
//    This program is free software; you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation; either version 2 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package com.openbravo.pos.forms;

import javax.swing.JComponent;
import javax.swing.JPanel;
import com.openbravo.basic.BasicException;
import java.awt.Component;

/**
 *
 * @author adrianromero
 */
public class JPanelMenu extends JPanel implements JPanelView {
    
    private MenuDefinition m_menu;
    private boolean created = false;
    
    /** Creates new form JStockMenu */
    public JPanelMenu(MenuDefinition menu) {
        
        m_menu = menu;
        created = false;
        
        initComponents();       
    }

    public JComponent getComponent() {
        return this;
    }
    
    public String getTitle() {
        return m_menu.getTitle();
    }  
    
    public void activate() throws BasicException {
        
        if (created == false) {

            for(int i = 0; i < m_menu.countMenuElements(); i++) {
                MenuElement menuitem = m_menu.getMenuElement(i);
                menuitem.addComponent(this);
            }            
            created = true;
        }
    }    
    
    public boolean deactivate() {  
        return true;
    }
    
    public void addTitle(Component title) {
        
        currententrypanel = null;
        
        JPanel titlepanel = new JPanel();
        titlepanel.setLayout(new java.awt.BorderLayout());
        titlepanel.add(title, java.awt.BorderLayout.CENTER);     
        titlepanel.applyComponentOrientation(getComponentOrientation());
        
        menucontainer.add(titlepanel);
    }
    
    public void addEntry(Component entry) {
        
        if (currententrypanel == null) {
            currententrypanel = new JPanel();                    
            currententrypanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 20, 0));
            currententrypanel.setLayout(new java.awt.GridLayout(0, 3, 5, 5));
            menucontainer.add(currententrypanel);
        }
        
        currententrypanel.add(entry);
        currententrypanel.applyComponentOrientation(getComponentOrientation());
        
    }
    
    private JPanel currententrypanel = null;
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menucontainer = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setLayout(new java.awt.BorderLayout());

        menucontainer.setLayout(new javax.swing.BoxLayout(menucontainer, javax.swing.BoxLayout.Y_AXIS));
        add(menucontainer, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel menucontainer;
    // End of variables declaration//GEN-END:variables
    
}
