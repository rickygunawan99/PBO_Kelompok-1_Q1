package Gui;

import controller.AllObjectModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KeretaGui extends ComponentGUI{

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
        tabel.setModel(AllObjectController.keretaController.daftarKereta());
        add(sp);

        btncari.setBounds(555,92,82,28);


        btnpilih.setBounds(555,149,82,28);


        btnedit.setBounds(555,206,82,28);


        setVisible(true);

        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabel.getSelectedRow();
                JOptionPane.showMessageDialog(null,
                        AllObjectModel.kereta.getDataKereta().get(i).getRute_kereta());
            }
        });


    }
}
