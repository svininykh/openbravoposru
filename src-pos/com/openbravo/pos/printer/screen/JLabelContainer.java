package com.openbravo.pos.printer.screen;

import java.awt.*;

class JLabelContainer extends javax.swing.JPanel {

    protected int H_GAP_SCREEN = 8; // Отступ от левого края окна до этикетки
    protected int V_GAP_SCREEN = 8; // Отступ от верхнего края окна до этикетки
    public int iGap;

    public JLabelContainer() {
        initComponents();
        setLayout(null);
    }

    public Dimension getPreferredSize() {

        Insets ins = getInsets();
        int iMaxx = 0;
        int iMaxy = ins.top + V_GAP_SCREEN;
        int n = getComponentCount();
        for (int i = 0; i < n; i++) {
            Component comp = getComponent(i);
            Dimension dc = comp.getPreferredSize();
            if (dc.width > iMaxx) {
                iMaxx = dc.width;
            }
            iMaxy += V_GAP_SCREEN + dc.height;
        }

        return new Dimension(iMaxx + 2 * H_GAP_SCREEN + ins.left + ins.right, iMaxy + ins.bottom + iGap * n);
    }

    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    public void doLayout() {
        Insets ins = getInsets();
        int x = ins.left + H_GAP_SCREEN;
        int y = ins.top + V_GAP_SCREEN;

        int n = getComponentCount();
        for (int i = 0; i < n; i++) {
            Component comp = getComponent(i);
            Dimension dc = comp.getPreferredSize();

            comp.setBounds(x, y, dc.width, dc.height);
//            y += V_GAP_SCREEN + dc.height;            
            y += dc.height + iGap; // Задаёт размер отступа между этикетками
        }
    }

    public void addLabel(JLabel label, String sGap) {

        iGap = Integer.parseInt(sGap);
        add(label);

        doLayout();
        revalidate();
        scrollRectToVisible(new Rectangle(0, getPreferredSize().height - 1, 1, 1));
    }

    public void removeAllLabels() {

        removeAll();

        doLayout();
        revalidate();
        scrollRectToVisible(new Rectangle(0, 0, 1, 1));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
