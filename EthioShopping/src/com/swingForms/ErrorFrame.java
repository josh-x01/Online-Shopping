package com.swingForms;

public class ErrorFrame extends javax.swing.JFrame {

    public ErrorFrame() {
        super("Message");
        this.setLocationRelativeTo(null);
        initComponents();
        this.setResizable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {


        jPanel1 = new javax.swing.JPanel();
        okayButton = new javax.swing.JButton();
        canelButton = new javax.swing.JButton();
        messageField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        okayButton.setText("Ok");
        okayButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okayButtonMouseClicked(evt);
            }
        });
        canelButton.setText("Abort");
        canelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canelButtonMouseClicked(evt);
            }
        });

        messageField.setText("Username exits");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(91, Short.MAX_VALUE)
                                .addComponent(canelButton)
                                .addGap(63, 63, 63)
                                .addComponent(okayButton)
                                .addGap(87, 87, 87))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(messageField)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(okayButton)
                                        .addComponent(canelButton))
                                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void canelButtonMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void okayButtonMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
    }

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
    }


    // Variables declaration - do not modify
    private javax.swing.JButton canelButton;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel messageField;
    private javax.swing.JButton okayButton;
}
