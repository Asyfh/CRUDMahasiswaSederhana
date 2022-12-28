/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.crudmahasiswasederhana.views;

import com.mycompany.crudmahasiswasederhana.Controller.MahasiswaController;
import com.mycompany.crudmahasiswasederhana.interfc.MahasiswaInterface;
import com.mycompany.crudmahasiswasederhana.models.Mahasiswa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class MahasiswaFrame extends javax.swing.JFrame {
    List<Mahasiswa> record=new ArrayList<Mahasiswa>();
    MahasiswaInterface mhsServis;
    int row;
    /**
     * Creates new form MahasiswaFrame
     */
    public MahasiswaFrame() {
        initComponents();
        nimValidasiLabel.setVisible(false);
        namaValidasiLabel.setVisible(false);
        alamatValidasiLabel.setVisible(false);
        mhsServis = new MahasiswaController();
        
        MahasiswaTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                row=MahasiswaTable.getSelectedRow();
                if(row!=-1){
                    isiText();
                }
            }
        });
        this.statusAwal();
                
    }
    
    void loadData(){
        try{
            record = mhsServis.getAll();
        } catch (SQLException ex){
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel(){
        Object data[][]=new Object[record.size()][3];
        int x=0;
        for(Mahasiswa mhs:record){
            data[x][0]=mhs.getNim();
            data[x][1]=mhs.getNama();
            data[x][2]=mhs.getAlamat();
            x++;
        }
        String judul[]={"nim","nama","alamat"};
        MahasiswaTable.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(MahasiswaTable);

    }
    
        void isiText(){
        Mahasiswa mhs=record.get(row);
        NimText.setText(mhs.getNim());
        NamaText.setText(mhs.getNama());
        AlamatText.setText(mhs.getAlamat());
        
    }
        void kosongkanText(){
            NimText.setText("");
            NamaText.setText("");
            AlamatText.setText("");
        }
        void statusAwal(){
            kosongkanText();
            loadData();
            isiTabel();
    }
        void validasiInput(Mahasiswa o){
            if (NimText.getText().equals("")) {
                nimValidasiLabel.setText("Nim belum diisi");
                nimValidasiLabel.setVisible(true);
            }else if (!NimText.getText().matches("[0-9]*")) {
                nimValidasiLabel.setText("Nim harus berisi angka");
                nimValidasiLabel.setVisible(true);
            }else if (NimText.getText().length() < 5) {
                nimValidasiLabel.setText("Nim minimal berisi 5 angka");
                nimValidasiLabel.setVisible(true);
            }else if  (NimText.getText().length() > 12) {
                nimValidasiLabel.setText("Nim maksimal berisi 12 angka");
                nimValidasiLabel.setVisible(true);
            }else {
                o.setNim(NimText.getText());
                nimValidasiLabel.setVisible(false);
            }
            
            if (NamaText.getText().equals("")) {
                namaValidasiLabel.setText("Nama belum diisi");
                namaValidasiLabel.setVisible(true);
            }else {
                o.setNama(NamaText.getText());
                namaValidasiLabel.setVisible(false);
            }
            if (AlamatText.getText().equals("")) {
                alamatValidasiLabel.setText("Alamat belum diisi");
                alamatValidasiLabel.setVisible(true);
            }else {
                o.setAlamat(AlamatText.getText());
                alamatValidasiLabel.setVisible(false);
            }
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NimLabel = new javax.swing.JLabel();
        NamaLabel = new javax.swing.JLabel();
        AlamatLabel = new javax.swing.JLabel();
        NimText = new javax.swing.JTextField();
        NamaText = new javax.swing.JTextField();
        TambahBtn = new javax.swing.JButton();
        UbahBtn = new javax.swing.JButton();
        HapusBtn = new javax.swing.JButton();
        nimValidasiLabel = new javax.swing.JLabel();
        namaValidasiLabel = new javax.swing.JLabel();
        AlamatText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        MahasiswaTable = new javax.swing.JTable();
        alamatValidasiLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NimLabel.setText("Nim");

        NamaLabel.setText("Nama");

        AlamatLabel.setText("Alamat");

        NimText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NimTextActionPerformed(evt);
            }
        });

        NamaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaTextActionPerformed(evt);
            }
        });

        TambahBtn.setText("Tambah");
        TambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahBtnActionPerformed(evt);
            }
        });

        UbahBtn.setText("Ubah");
        UbahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbahBtnActionPerformed(evt);
            }
        });

        HapusBtn.setText("Hapus");
        HapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusBtnActionPerformed(evt);
            }
        });

        nimValidasiLabel.setForeground(new java.awt.Color(255, 0, 0));
        nimValidasiLabel.setText("jLabel1");

        namaValidasiLabel.setForeground(new java.awt.Color(255, 0, 0));
        namaValidasiLabel.setText("jLabel2");

        AlamatText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlamatTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NamaLabel)
                    .addComponent(NimLabel)
                    .addComponent(AlamatLabel))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nimValidasiLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NimText, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NamaText, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaValidasiLabel)
                            .addComponent(AlamatText, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UbahBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TambahBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(HapusBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NimText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NimLabel)
                    .addComponent(TambahBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nimValidasiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NamaText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UbahBtn))
                    .addComponent(NamaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaValidasiLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlamatText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AlamatLabel)
                    .addComponent(HapusBtn))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        MahasiswaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(MahasiswaTable);

        alamatValidasiLabel.setForeground(new java.awt.Color(255, 0, 0));
        alamatValidasiLabel.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(alamatValidasiLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alamatValidasiLabel)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NimTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NimTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NimTextActionPerformed

    private void NamaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaTextActionPerformed

    private void TambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahBtnActionPerformed
     try{   
    // TODO add your handling code here:
    Mahasiswa mhs = new Mahasiswa();
    validasiInput(mhs);
    mhsServis.insert(mhs);
    this.statusAwal();
    JOptionPane.showMessageDialog(this, "data tersimpan");
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(this, "data tidak berhasil tersimpan");
         Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_TambahBtnActionPerformed

    private void UbahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbahBtnActionPerformed
    try{
    // TODO add your handling code here:
    Mahasiswa mhs = new Mahasiswa();
    validasiInput(mhs);
    mhs.setNim(NimText.getText());
    mhs.setNama(NamaText.getText());
    mhs.setAlamat(AlamatText.getText());
    mhsServis.update(mhs);
    this.statusAwal();
    JOptionPane.showMessageDialog(this, "data berhasil diubah");
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(this, "data tidak berhasil tersimpan");
         Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_UbahBtnActionPerformed

    private void HapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusBtnActionPerformed
     try{   
    // TODO add your handling code here:
     String nim = NimText.getText();
     mhsServis.delete(nim);
     this.statusAwal();
     JOptionPane.showMessageDialog(this, "data berhasil dihapus");
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(this, "data berhasil dihapus");
         Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_HapusBtnActionPerformed

    private void AlamatTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlamatTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlamatTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlamatLabel;
    private javax.swing.JTextField AlamatText;
    private javax.swing.JButton HapusBtn;
    private javax.swing.JTable MahasiswaTable;
    private javax.swing.JLabel NamaLabel;
    private javax.swing.JTextField NamaText;
    private javax.swing.JLabel NimLabel;
    private javax.swing.JTextField NimText;
    private javax.swing.JButton TambahBtn;
    private javax.swing.JButton UbahBtn;
    private javax.swing.JLabel alamatValidasiLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel namaValidasiLabel;
    private javax.swing.JLabel nimValidasiLabel;
    // End of variables declaration//GEN-END:variables
}
