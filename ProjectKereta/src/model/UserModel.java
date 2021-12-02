package model;

import entities.UserEntity;

import java.sql.SQLException;

public class UserModel extends ModelAbstract {


    public int cekLogin(String no_hp, String pass){
        sql = "SELECT * FROM user where no_hp = ? AND password = ?";
        try {
            int cek;
            stat = conn.prepareStatement(sql);
            stat.setString(1,no_hp);
            stat.setString(2,pass);

            rs = stat.executeQuery();

            if(rs.next()){
                cek = rs.getInt("id");
                return cek;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }


    public UserEntity getUser(int id){
        sql = "SELECT * FROM user where id = ?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setInt(1,id);

            rs = stat.executeQuery();

            if(rs.next()){
                UserEntity user = new UserEntity();
                user.setPassword(rs.getString("password"));
                user.setTgl_lahir(rs.getString("tgl_lahir"));
                user.setId(rs.getInt("id_penduduk"));
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void editPassword(String password_baru, int id_user){
        sql = "UPDATE user SET password = ? WHERE id = ?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1,password_baru);
            stat.setInt(2,id_user);
            int row = stat.executeUpdate();
            System.out.println(row + " row(s) updated");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void editTanggalLahir(String tgl_baru, int id_user){
        sql = "UPDATE user SET tgl_lahir = ? WHERE id = ?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1,tgl_baru);
            stat.setInt(2,id_user);
            int row = stat.executeUpdate();
            System.out.println(row + " row(s) updated");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public int cekRegister(String no_hp){
        int cek = -1;
        sql = "SELECT * FROM user WHERE no_hp = ?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1,no_hp);
            rs = stat.executeQuery();

            if(rs.next()){
                cek = rs.getInt("id");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cek;
    }

    public void register(String no_hp, String pass, String tgl_lahir, int id_penduduk){
        sql = "SELECT * FROM user WHERE no_hp = ?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1,no_hp);
            rs = stat.executeQuery();

            if(!rs.next()){
                sql = "INSERT INTO user(no_hp, password, tgl_lahir, id_penduduk) VALUES (?,?,?,?)";
                stat = conn.prepareStatement(sql);
                stat.setString(1,no_hp);
                stat.setString(2,pass);
                stat.setString(3,tgl_lahir);
                stat.setInt(4,id_penduduk);
                int row = stat.executeUpdate();
                System.out.println(row + " updated");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void editAlamat(String input, int id){
        sql = "UPDATE penduduk SET alamt = ? WHERE id = ?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1,input);
            stat.setInt(2,id);
            int row = stat.executeUpdate();
            System.out.println(row + " row(s) updated");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
