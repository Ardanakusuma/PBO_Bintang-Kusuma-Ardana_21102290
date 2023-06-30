package com.Bintang.PBO.Pertemuan9;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class DemoDatabase extends JFrame{
    private JButton saveButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JTable dataTable;
    private JTextField txt_nim;
    private JTextField txt_nama;
    private JSpinner spr_nilai;
    private JLabel NIM;
    private JLabel Nama;
    private JLabel Nilai;
    private static Connection c;
    private static Statement s;
    private static ResultSet rs;
    private JPanel mainPanel;
    private DefaultTableModel model;

    public DemoDatabase() {
        super("Demo Database");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,400);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txt_nama.getText();
                String nim = txt_nim.getText();
                int nilai = (int) spr_nilai.getValue();

                try{
                    openDB();
                    s.executeUpdate(
                            "INSERT INTO tabel VALUES ('" + nim + "','" + nama + "','" + nilai + "')"
                    );

                    Object[] row = {nim, nama, nilai};
                    model.addRow(row);
                    JOptionPane.showMessageDialog(null, "Data added!");
                }catch (SQLException | ClassNotFoundException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                }finally {
                    closeDB();
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_nim.setText("");
                txt_nama.setText("");
                spr_nilai.setValue(0);
            }
        });

        dataTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = dataTable.getSelectedRow();

                String nim = dataTable.getValueAt(row, 0).toString();
                String nama = dataTable.getValueAt(row, 1).toString();
                int nilai = dataTable.getValueAt(row, 2).hashCode();

                txt_nim.setText(nim);
                txt_nama.setText(nama);
                spr_nilai.setValue(nilai);



            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txt_nama.getText();
                String nim = txt_nim.getText();
                int nilai = (int) spr_nilai.getValue();

                try{
                    openDB();
                    s.executeUpdate(
                            "UPDATE tabel SET nama = '" + nama + "', nilai = '" + nilai + "' WHERE nim = '" + nim + "';"
                    );

                    model.setValueAt(nim,dataTable.getSelectedRow(),0);
                    model.setValueAt(nama,dataTable.getSelectedRow(),1);
                    model.setValueAt(nilai,dataTable.getSelectedRow(),2);

                    txt_nim.setText("");
                    txt_nama.setText("");
                    spr_nilai.setValue(0);

                    JOptionPane.showMessageDialog(null, "Data updated!");
                }catch (SQLException | ClassNotFoundException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                }finally {
                    closeDB();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = txt_nim.getText();

                try{
                    openDB();
                    s.executeUpdate(
                            "DELETE FROM tabel WHERE nim = '" + nim + "';"
                    );

                    txt_nim.setText("");
                    txt_nama.setText("");
                    spr_nilai.setValue(0);

                    model.removeRow(dataTable.getSelectedRow());

                    JOptionPane.showMessageDialog(null, "Data deleted!");

                }catch (SQLException | ClassNotFoundException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                }finally {
                    closeDB();
                }
            }
        });
    }

    public static void main(String[] args) {
        DemoDatabase frame = new DemoDatabase();
        frame.setVisible(true);
    }

    private static void openDB() throws ClassNotFoundException, SQLException{
        String URL = "jdbc:mysql://localhost:3306/dbdemo";
        String Username = "root";
        String Password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection(URL,Username,Password);
        s = c.createStatement();
    }

    private static void closeDB() {
        try{
            rs.close();
            s.close();
            c.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void createUIComponents() {
        model = new DefaultTableModel();
        dataTable = new JTable(model);
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Nilai");

        try {
            openDB();
            rs = s.executeQuery("SELECT * FROM tabel");

            while(rs.next()){
                Object[] row = {
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getInt("nilai")
                };
                model.addRow(row);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();

        }finally{
            closeDB();
        }
    }
}
