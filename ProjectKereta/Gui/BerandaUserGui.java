package Gui;

import controller.AllObjectModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class BerandaUserGui extends ComponentGUI{
    JLabel labelasal = new JLabel("Stasiun asal");
    JLabel labeltujuan = new JLabel("Stasiun tujuan");
    JTextField fieldasal = new JTextField();
    JTextField fieldtujuan = new JTextField();
    JLabel labeltglberangkat = new JLabel("Tgl keberangkatan");
    JTextField fieldtglberangkat = new JTextField();
    JButton btncektiket = new JButton("Cek pemesanan");
    JButton btnbatalkan = new JButton("Batalkan tiket");
    JButton btnberanda = new JButton();
    JButton btntiket = new JButton();
    JButton btnprofil = new JButton();
    JLabel labelprofil = new JLabel("Profile");

    public BerandaUserGui(){
        initComponent();
    }

    void initComponent(){
        setTitle("Beranda");
        setSize(450,570);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        labelasal.setBounds(59,92,120,23);
        labelasal.setFont(new Font("Segoe UI",Font.BOLD,17));
        add(labelasal);
        fieldasal.setBounds(59,128,127,24);
        fieldasal.setFont(new Font("Segoe UI",Font.BOLD,17));
        fieldasal.setForeground(Color.BLUE);
        add(fieldasal);

        labeltujuan.setBounds(249,92,120,23);
        labeltujuan.setFont(new Font("Segoe UI",Font.BOLD,17));
        add(labeltujuan);
        fieldtujuan.setBounds(249,126,127,24);
        fieldtujuan.setFont(new Font("Segoe UI",Font.BOLD,17));
        fieldtujuan.setForeground(Color.BLUE);
        add(fieldtujuan);

        labeltglberangkat.setBounds(145,182,164,23);
        labeltglberangkat.setFont(new Font("Segoe UI",Font.BOLD,15));
        add(labeltglberangkat);
        fieldtglberangkat.setBounds(175,218,77,27);
        add(fieldtglberangkat);

        btncari.setBounds(170,270,90,25);
        btncari.setBorder(null);
        btncari.setBackground(Color.WHITE);
        btncari.setForeground(Color.BLUE);
        btncari.setFocusPainted(false);
        btncari.setFont(new Font("Times new roman", Font.BOLD,18));
        add(btncari);

        btncektiket.setBounds(85,364,115,37);
        btncektiket.setBorder(null);
        btncektiket.setFocusPainted(false);
        btncektiket.setBackground(Color.WHITE);
        btncektiket.setForeground(Color.BLUE);
        btncektiket.setFont(new Font("Segoe UI",Font.BOLD,15));
        add(btncektiket);

        btnbatalkan.setBounds(222,364,115,37);
        btnbatalkan.setBorder(null);
        btnbatalkan.setFocusPainted(false);
        btnbatalkan.setBackground(Color.WHITE);
        btnbatalkan.setForeground(Color.BLUE);
        btnbatalkan.setFont(new Font("Segoe UI",Font.BOLD,15));
        add(btnbatalkan);

        btnberanda.setBounds(34,444,66,45);
        btnberanda.setBorder(null);
        btnberanda.setFocusPainted(false);
        add(btnberanda);

        btntiket.setBounds(178,444,66,45);
        btntiket.setBorder(null);
        btntiket.setFocusPainted(false);
        add(btntiket);

        btnprofil.setBounds(322,444,60,55);
        btnprofil.setBackground(Color.WHITE);
        btnprofil.setBorder(null);
        btnprofil.setFocusPainted(false);
        try {
            String path = "src/Images/iconprofil.jpg";
            bufferedImage = ImageIO.read(new File(path));
            gambar = bufferedImage.getScaledInstance(50,45,Image.SCALE_SMOOTH);
            btnprofil.setIcon(new ImageIcon(gambar));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        add(btnprofil);

        labelprofil.setBounds(334,485,50,40);
        add(labelprofil);

        btncari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> angka = new ArrayList<>();
                String asal = fieldasal.getText();
                String tujuan = fieldtujuan.getText();
                for(int i =0; i< AllObjectModel.kereta.getKereta(asal,tujuan).size();i++){
                    angka.add(AllObjectModel.kereta.getKereta(asal,tujuan).get(i).getId());
                }

                JOptionPane.showMessageDialog(null,angka);

            }
        });

        btncari.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btncari.setBackground(Color.WHITE);
                btncari.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btncari.setBackground(Color.WHITE);
                btncari.setForeground(Color.BLUE);
            }
        });

        btncektiket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btncektiket.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btncektiket.setForeground(Color.BLUE);
            }
        });

        btnbatalkan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnbatalkan.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnbatalkan.setForeground(Color.BLUE);
            }
        });

        btnprofil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnprofil.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnprofil.setBackground(Color.WHITE);
            }
        });


        btnprofil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"a");
            }
        });
        setVisible(true);
    }

}
