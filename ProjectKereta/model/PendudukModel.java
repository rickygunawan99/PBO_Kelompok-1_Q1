package model;

import entities.PendudukEntities;

import java.sql.SQLException;

public class PendudukModel extends ModelAbstract{

    public void register(String nama, String no_ktp, String alamat){
        sql = "SELECT * FROM penduduk WHERE no_ktp = ?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1,no_ktp);
            rs = stat.executeQuery();

            if(!rs.next()){
                sql = "INSERT INTO penduduk(nama,no_ktp,alamat) VALUES (?,?,?)";
                stat = conn.prepareStatement(sql);
                stat.setString(1,nama);
                stat.setString(2,no_ktp);
                stat.setString(3,alamat);
                stat.executeUpdate();
            }else{
                int temp = rs.getInt("id");
                sql = "UPDATE penduduk SET nama = ?, no_ktp = ?, alamat = ? WHERE id = ?";
                stat = conn.prepareStatement(sql);
                stat.setString(1,nama);
                stat.setString(2,no_ktp);
                stat.setString(3,alamat);
                stat.setInt(4,temp);
                stat.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public PendudukEntities getPenduduk(int id){
        sql = "SELECT * FROM penduduk WHERE id = ?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            rs = stat.executeQuery();
            if(rs.next()){
                PendudukEntities penduduk = new PendudukEntities();
                penduduk.setNama(rs.getString("nama"));
                penduduk.setNoKtp(rs.getString("no_ktp"));
                penduduk.setAlamat(rs.getString("alamat"));
                return penduduk;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int getPendudukId(String no_ktp){
        sql = "SELECT * FROM penduduk WHERE no_ktp = ?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1,no_ktp);
            rs = stat.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                return id;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
