package Gui;

import controller.AllObjectModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KeretaGui extends JFrame{
    AllObjectController objController = new AllObjectController();

    JTable tabel = new JTable(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    JScrollPane sp = new JScrollPane(tabel);

    public KeretaGui(){
        initComponent();
    }

    void initComponent(){
        setTitle("Pesan Kereta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(882,493));
        setLocationRelativeTo(null);
        setLayout(null);

        sp.setBounds(26,56,703,382);
        tabel.setModel(objController.keretaController.daftarKereta());
        add(sp);

        setVisible(true);

        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabel.getSelectedRow();
                JOptionPane.showMessageDialog(null,
                        objController.keretaController.getDataKereta().get(i).getRute_kereta());
            }
        });
    }
}
