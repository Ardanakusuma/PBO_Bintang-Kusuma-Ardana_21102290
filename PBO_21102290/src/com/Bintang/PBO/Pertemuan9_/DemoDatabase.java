package com.Bintang.PBO.Pertemuan9_;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DemoDatabase extends JFrame {

    // < Komponen-komponen GUI >
    private static Connection c;
    private static Statement s;
    private static ResultSet rs;
    private JTabbedPane tabbedPane;
    private JPanel mainPanel;
    private JTextField NIM;
    private JTextField Nama;
    private JSpinner Nilai;
    private JButton ClearAdd;
    private JButton Submit;
    private JTable dataTable;
    private JButton clearTableButton;
    private JButton deleteRowButton;
    private JButton editRowButton;
    private JPanel addDataTab;
    private JPanel seeDataTab;
    private JScrollPane dataScrollPane;
    private DefaultTableModel model;

    private static void openDb() throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://localhost:3306/dbdemo";
        String username = "root";
        String password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection(URL, username, password);
        s = c.createStatement();
    }

    private static void closeDB(){
        try{
            rs.close();
            s.close();
            c.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // < Komponen-komponen >
    public DemoDatabase(){
        super("Demo Database");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,300);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = NIM.getText();
                String nama = Nama.getText();
                int nilai = (int) Nilai.getValue();

                try{
                    openDb();
                    s.executeUpdate(
                            "INSERT INTO tabel VALUES ('"+ nim +"', '"+ nama +"', '"+ nilai +"')"
                    );
                    Object[] row = {nim, nama, nilai};
                    model.addRow(row);

                    JOptionPane.showMessageDialog(null, "Data added!");

                }catch(SQLException | ClassNotFoundException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error coy!");
                    // ex.getLocalizedMessage()
                }finally{
                    closeDB();
                }
            }
        });
        ClearAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NIM.setText("");
                Nama.setText("");
                Nilai.setValue(0);
                JOptionPane.showMessageDialog(null, "Form cleared!");
            }
        });
    }

    private void createUIComponents() {
        model = new DefaultTableModel();
        dataTable = new JTable(model);
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Nilai");

        try {
            openDb();
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

    public static void main(String[] args) {
        JFrame mainFrame = new DemoDatabase();
        mainFrame.setVisible(true);
    }
}
