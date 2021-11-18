package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ComponentGUI extends JFrame {
    JLabel labeltitle = new JLabel();

    JLabel bingkaigambar = new JLabel();

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

    JButton btnlogin = new JButton("LOGIN");
    JButton btnregister = new JButton("Register pengguna baru ?");
    JButton btnback = new JButton();

    JButton btnpilih = new JButton("Pilih");
    JButton btnedit = new JButton("Edit");
    JButton btncari = new JButton("Cari");

    JTable tabel = new JTable(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    BufferedImage bufferedImage = null;
    Image gambar;

    void clear(){
        fieldnama.setText(null);
        fieldnohp.setText(null);
        fieldalamat.setText(null);
        fieldnoktp.setText(null);
        fieldpass.setText(null);
        fieldtgllahir.setText(null);
    }
}
