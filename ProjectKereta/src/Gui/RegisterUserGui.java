package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterUserGui extends JFrame{
    AllObjectController objController = new AllObjectController();

    JLabel labeltitle = new JLabel();


    JLabel labelnama = new JLabel("Nama");
    JLabel labelnohp = new JLabel("No HP");
    JLabel labelnoktp = new JLabel("No KTP");
    JLabel labelalamat = new JLabel("Alamat");
    JLabel labeltgllahir = new JLabel("Tanggal Lahir");
    JLabel labelpass = new JLabel("Password");

    JTextField fieldnama = new JTextField();
    JTextField fieldnohp = new JTextField();
    JTextField fieldnoktp = new JTextField();
    JTextField fieldpass = new JTextField();
    JTextField fieldalamat = new JTextField();
    JTextField fieldtgllahir = new JTextField();

    JButton btnregister = new JButton("Register pengguna baru ?");
    JButton btnback = new JButton();


    public RegisterUserGui(){
        initComponent();
    }

    void initComponent(){
        setTitle("REGISTER USER");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(375,535);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        labeltitle.setText("REGISTER PENGGUNA BARU");
        setFont(new Font("SEGOE UI",Font.PLAIN,20));
        labeltitle.setBounds(96,18,169,32);
        add(labeltitle);

        btnback.setText("<< Back");
        btnback.setBounds(6,8,57,31);
        btnback.setBorder(null);
        btnback.setFocusPainted(false);
        btnback.setBackground(Color.WHITE);
        btnback.setForeground(Color.BLUE);
        add(btnback);

        btnregister.setBounds(125,415,100,30);
        btnregister.setText("Register");
        btnregister.setBorder(null);
        btnregister.setFocusPainted(false);
        btnregister.setBackground(Color.BLACK);
        btnregister.setForeground(Color.WHITE);
        add(btnregister);

        labelnama.setBounds(14,91,107,31);
        labelnohp.setBounds(14,147,107,31);
        labelnoktp.setBounds(14,203,107,31);
        labeltgllahir.setBounds(14,259,107,31);
        labelalamat.setBounds(14,315,107,31);
        labelpass.setBounds(14,371,107,31);
        add(labelnama);
        add(labelnohp);
        add(labelnoktp);
        add(labeltgllahir);
        add(labelalamat);
        add(labelpass);

        fieldnama.setBounds(151,91,162,31);
        fieldnohp.setBounds(151,147,162,31);
        fieldnoktp.setBounds(151,203,162,31);
        fieldtgllahir.setBounds(151,259,162,31);
        fieldalamat.setBounds(151,315,162,31);
        fieldpass.setBounds(151,371,162,31);
        add(fieldnama);
        add(fieldnohp);
        add(fieldnoktp);
        add(fieldtgllahir);
        add(fieldalamat);
        add(fieldpass);

        setVisible(true);

        btnback.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnback.setBackground(Color.WHITE);
                btnback.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnback.setBackground(Color.WHITE);
                btnback.setForeground(Color.BLUE);
            }
        });

        btnregister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnregister.setBackground(Color.GREEN);
                btnregister.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnregister.setBackground(Color.BLACK);
                btnregister.setForeground(Color.white);
            }
        });

        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginUserGui().setVisible(true);
                dispose();
            }
        });

        btnregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = fieldnama.getText();
                String no_ktp = fieldnoktp.getText();
                String alamat = fieldalamat.getText();
                String no_hp = fieldnohp.getText();
                String tgl_lahir = fieldtgllahir.getText();
                String pass = fieldpass.getText();

                if(nama.length()!=0 && no_ktp.length()!=0 && alamat.length()!=0 &&
                no_hp.length()!=0&&tgl_lahir.length()!=0&&pass.length()!=0){
                    int cek = objController.userController.register(nama,no_ktp,
                            alamat,no_hp,pass,tgl_lahir);
                    if(cek!=-1){
                        JOptionPane.showMessageDialog(null,"Register berhasil," +
                                " Silahkan login kembali");
                        new LoginUserGui().setVisible(true);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Gagal register, " +
                                "No Hp telah terdaftar");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Data tidak boleh kosong");
                }
            }
        });


    }
}
