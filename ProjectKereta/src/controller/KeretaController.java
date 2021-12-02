package controller;

import entities.*;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class KeretaController extends AllObjectModel{

    public ArrayList<KeretaEntity> getDataKereta(){
        return kereta.getDataKereta();
    }

    /**
     * Method untuk mengambil semua data didalam kereta kemudian mencari rute yang sama
     * sesuai dengan rute awal dan rute tujuan dari user / pemesan kereta
     * @param stasiun_awal : rute awal keberangkatan yang dipilih user
     * @param stasiun_tujuan : rute tujuan keberangkatan yang dipilih user
     * @return ArrayList dari kereta yang punya jadwal keberangkatan dan tujuan sesuai
     * dengan yang dicari user
     */
    public ArrayList<KeretaEntity> getKereta(String stasiun_awal, String stasiun_tujuan){
        return kereta.getKereta(stasiun_awal,stasiun_tujuan);
    }

    /**
     *
     * @param id_kereta merupakan id kereta yg dipilih
     */
    public int tambahPenumpang(int id_kereta){

        if(kereta.getJumlahPenumpangKereta(id_kereta) <
                kereta.getMaxPenumpangKereta(id_kereta)){

            if(kereta.tambahPenumpang(id_kereta)>0)
                return 1;
        }
        return -1;
    }

    public DefaultTableModel daftarKereta(){
        DefaultTableModel dataKereta = new DefaultTableModel();
        Object[] kolom = {"id","Nama Kereta", "Rute Kereta", "Jam Operasi"};
        dataKereta.setColumnIdentifiers(kolom);
        int size = getDataKereta().size();
        for(int i=0 ; i < size ; i++){
            Object[] data = new Object[4];
            data[0] = kereta.getDataKereta().get(i).getId();
            data[1] = kereta.getDataKereta().get(i).getNama_kereta();
            data[2] = kereta.getDataKereta().get(i).getRute_kereta();
            data[3] = kereta.getDataKereta().get(i).getJam_operasi();
            dataKereta.addRow(data);
        }
        return dataKereta;
    }
}
