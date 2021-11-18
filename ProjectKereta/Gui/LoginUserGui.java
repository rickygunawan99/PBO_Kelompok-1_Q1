package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginUserGui extends ComponentGUI {

    public LoginUserGui(){
        initComponent();
    }

    void initComponent(){
        String pathgambar = "src/Images/iconkereta.jpg";

        setTitle("Login Account");
        setSize(580,360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        bingkaigambar.setBounds(25,73,196,231);
        add(bingkaigambar);

        labeltitle.setText("LOGIN ACCOUNT");
        labeltitle.setFont(new Font("Times New Roman",Font.PLAIN,17));
        labeltitle.setBounds(210,17,159,30);
        add(labeltitle);

        labelnohp.setBounds(236,95,105,31);
        add(labelnohp);
        fieldnohp.setBounds(373,95,169,27);
        add(fieldnohp);

        labelpass.setBounds(236,165,105,31);
        add(labelpass);
        fieldpass.setBounds(373,162,169,27);
        add(fieldpass);

        btnlogin.setBounds(330,227,80,27);
        btnlogin.setFont(new Font("Times New Roman",Font.PLAIN,15));
        btnlogin.setBorder(null);
        btnlogin.setBackground(Color.BLACK);
        btnlogin.setForeground(Color.WHITE);
        btnlogin.setFocusPainted(false);
        add(btnlogin);

        btnregister.setBounds(290,280,158,24);
        btnregister.setBorder(null);
        btnregister.setFont(new Font("Times New Roman",Font.PLAIN,15));
        btnregister.setBackground(Color.WHITE);
        btnregister.setForeground(Color.BLACK);
        btnregister.setFocusPainted(false);
        add(btnregister);

        try {
            bufferedImage = ImageIO.read(new File(pathgambar));
            gambar = bufferedImage.getScaledInstance(196,231,Image.SCALE_SMOOTH);
            bingkaigambar.setIcon(new ImageIcon(gambar));
        }catch (IOException ex){
            Logger.getLogger(LoginUserGui.class.getName()).log(Level.SEVERE,null, ex);
        }

        setVisible(true);

        btnlogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnlogin.setBackground(Color.GREEN);
                btnlogin.setForeground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnlogin.setBackground(Color.BLACK);
                btnlogin.setForeground(Color.WHITE);
            }
        });

        btnregister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnregister.setForeground(Color.GREEN);
                btnregister.setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnregister.setBackground(Color.WHITE);
                btnregister.setForeground(Color.BLACK);
            }
        });

        btnregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterUserGui register = new RegisterUserGui();
                register.setVisible(true);
                dispose();
            }
        });

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String no_hp = fieldnohp.getText();
                String pass = fieldpass.getText();

                if(no_hp.length()!=0 && pass.length()!=0){
                    int cek = AllObjectController.userController.cekLogin(no_hp,pass);
                    if(cek!=-1){
                    JOptionPane.showMessageDialog(null,"Berhasil login "+ cek);
                    }else{
                        JOptionPane.showMessageDialog(null,"Gagal login");
                        clear();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Data kosong");
                }
            }
        });
    }
}
