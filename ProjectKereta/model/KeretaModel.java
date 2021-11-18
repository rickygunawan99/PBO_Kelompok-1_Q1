package model;

import entities.KeretaEntity;

import java.sql.*;
import java.util.ArrayList;

public class KeretaModel extends ModelAbstract{

    /**
     * Method untuk mendapatkan semua data kereta dalam tabel
     * @return listKereta adalah array list dari semua data kereta dalam tabel
     */
    public ArrayList<KeretaEntity> getDataKereta() {
        ArrayList<KeretaEntity> dataKereta = new ArrayList<>();
        try {
            sql = "SELECT * FROM kereta";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                KeretaEntity kereta = new KeretaEntity();
                kereta.setId(rs.getInt("id"));
                kereta.setNama_kereta(rs.getString("nama_kereta"));
                kereta.setRute_kereta(rs.getString("rute_kereta"));
                kereta.setJam_operasi(rs.getString("jam_operasi"));
                kereta.setKapasitas(rs.getInt("kapasitas"));
                kereta.setJml_penumpang(rs.getShort("jml_penumpang"));
                dataKereta.add(kereta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataKereta;
    }

    /**
     * mengambil nilai jumlah penumpang sekarang
     * @param id_kereta adalah id dari kereta
     * @return kapasitas penumpang
     */
    public int getJumlahPenumpangKereta(int id_kereta){
        sql = "SELECT * FROM kereta WHERE id = ?";
        int ctr = -1;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id_kereta);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ctr = rs.getInt("jml_penumpang");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ctr;
    }

    /**
     * mengambil nilai dari kapasitas maksimal kereta
     * @param id adalah id dari kereta
     * @return jumlah maks penumpang yg dapat ditampung kereta
     */
    public int getMaxPenumpangKereta(int id){
        sql = "SELECT * FROM kereta WHERE id = ?";
        int ctr = -1;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ctr = rs.getInt("kapasitas");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ctr;
    }

    public ArrayList<KeretaEntity> getKereta(String stasiun_asal, String stasiun_tujuan){
        ArrayList<KeretaEntity> listKereta = new ArrayList<>();
        sql = "SELECT * FROM kereta";
        try {
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();

            while (rs.next()){
                int idx_awal = -1, idx_tujuan = -1;
                int ctr = 0;
                String rute = rs.getString("rute_kereta");
                String[] arrRute = rute.split("-");
                for(int j=0; j< arrRute.length; j++){
                    if(arrRute[j].equals(stasiun_asal)){
                        idx_awal = j;
                        ctr++;
                        j = arrRute.length;
                    }
                }

                if(idx_awal!=-1){
                    for(int j=idx_awal+1; j<arrRute.length;j++){
                        if(arrRute[j].equals(stasiun_tujuan)){
                            idx_tujuan = j;
                            ctr++;
                            j = arrRute.length;
                        }
                    }

                    if(ctr==2){
                        KeretaEntity kereta = new KeretaEntity();
                        kereta.setId(rs.getInt("id"));
                        kereta.setNama_kereta(rs.getString("nama_kereta"));
                        String ruteSama = arrRute[idx_awal] + "-" + arrRute[idx_tujuan];
                        kereta.setRute_kereta(ruteSama);
                        String[] waktuBerangkat = rs.getString("jam_operasi").split("-");
                        kereta.setJam_operasi(waktuBerangkat[idx_awal] + "-" + waktuBerangkat[idx_tujuan]);
                        kereta.setHarga(rs.getInt("harga_kereta"));
                        listKereta.add(kereta);
                    }
                }
            }
            return listKereta;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * method untuk menambah jumlah penumpang dalam kereta
     * @param id_kereta merupakan id dari kereta
     * @return
     */
    public int tambahPenumpang(int id_kereta){
        sql = "SELECT * FROM kereta WHERE id = ?";
        try {
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1,id_kereta);
          ResultSet rs = ps.executeQuery();
          if(rs.next()){
              int jml = rs.getInt("jml_penumpang");
              sql = "UPDATE kereta SET jml_penumpang = ? WHERE id = ?";
              ps = conn.prepareStatement(sql);
              ps.setInt(1,jml+1);
              ps.setInt(2,id_kereta);
              return ps.executeUpdate();
          }
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }


}
