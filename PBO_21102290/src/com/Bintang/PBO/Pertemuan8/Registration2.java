package com.Bintang.PBO.Pertemuan8;

import com.Bintang.PBO.Pertemuan7.Registration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration2 extends JFrame{
    private JTextField Nama;
    private JTextField NIM;
    private JTextField Telp;
    private JTextArea Alamat;
    private JComboBox Prodi;
    private JRadioButton lakiLaki;
    private JRadioButton perempuan;
    private JButton saveButton;
    private JButton clearButton;
    private JPanel mainPanel;
    private ButtonGroup JK;

    public Registration2() {
        super("Forumulir Registrasi");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(800, 600);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Nama.setText("");
                NIM.setText("");
                Telp.setText("");
                Alamat.setText("");
                Prodi.setSelectedIndex(0);
                // lakiLaki.setSelected(false);
                // perempuan.setSelected(false);
                JK.clearSelection();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = Nama.getText();
                String nim = NIM.getText();
                String prodi = (String) Prodi.getSelectedItem();
                String telp = Telp.getText();
                String alamat = Alamat.getText();
                String jk;
                if(lakiLaki.isSelected()){
                    jk = "Laki - laki";
                }else if (perempuan.isSelected()){
                    jk = "Perempuan";
                }else{
                    jk = "Tidak diketahui";
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame mainFrame = new Registration2();
        mainFrame.setVisible(true);
    }
}
