package controller;

import entities.UserEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserController extends AllObjectModel{


    public int cekLogin(String no_hp, String password) {
        return user.cekLogin(no_hp,password);
    }


    public int register(UserEntity dataUser){

        if(user.cekRegister(dataUser.getNo_hp()) == -1){
            penduduk.register(dataUser.getNama(), dataUser.getNoKtp(), dataUser.getAlamat());
            int id_penduduk = penduduk.getPendudukId(dataUser.getNoKtp());
            user.register(dataUser.getNo_hp(), dataUser.getPassword(), dataUser.getTgl_lahir(), id_penduduk);
            return 1;
        }else{
            System.out.println("No hp sudah didaftarkan");
        }
        return -1;
    }

    public UserEntity getDataUser(int id){
        UserEntity userEntities = user.getUser(id);
        userEntities.setNama(penduduk.getPenduduk(userEntities.getId()).getNama());
        userEntities.setNoKtp(penduduk.getPenduduk(userEntities.getId()).getNoKtp());

        if(penduduk.getPenduduk(userEntities.getId()).getAlamat()!=null){
            userEntities.setAlamat(penduduk.getPenduduk(userEntities.getId()).getAlamat());
        }else{
            userEntities.setAlamat("-");
        }

        if(userEntities.getTgl_lahir()!=null){
            try {
            long date = new Date().getTime() - (new SimpleDateFormat("dd-MM-yyyy").
                    parse(String.valueOf(userEntities.getTgl_lahir())).getTime());
                userEntities.setUmur(String.valueOf((date/(24 * 60 * 60 * 1000))/365));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            userEntities.setTgl_lahir("-");
            userEntities.setUmur("-");
        }
        return userEntities;
    }


    public void editData(int pilih, String input, int id){
        switch (pilih){
            case 1 -> user.editPassword(input,id); // id = user login
            case 2 -> user.editTanggalLahir(input,id); //id = user login
            case 3 -> user.editAlamat(input,id); //id = user.getId()
        }
    }
}
