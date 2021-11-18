package controller;

import entities.PendudukEntities;
import entities.UserEntities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserController implements ControllerInterface{

    @Override
    public int cekLogin(String no_hp, String password) {
        return AllObjectModel.user.cekLogin(no_hp,password);
    }


    @Override
    public int register(String nama, String no_ktp, String alamat,
                         String no_hp, String pass, String tgl_lahir){

        if(AllObjectModel.user.cekRegister(no_hp) == -1){
            AllObjectModel.penduduk.register(nama,no_ktp,alamat);
            int id_penduduk = AllObjectModel.penduduk.getPendudukId(no_ktp);
            AllObjectModel.user.register(no_hp, pass, tgl_lahir, id_penduduk);
            return 1;
        }else{
            System.out.println("No hp sudah didaftarkan");
        }
        return -1;
    }

    public UserEntities getDataUser(int id){
        UserEntities user = AllObjectModel.user.getUser(id);
        user.setNama(AllObjectModel.penduduk.getPenduduk(user.getId()).getNama());
        user.setNoKtp(AllObjectModel.penduduk.getPenduduk(user.getId()).getNoKtp());

        if(AllObjectModel.penduduk.getPenduduk(user.getId()).getAlamat()!=null){
            user.setAlamat(AllObjectModel.penduduk.getPenduduk(user.getId()).getAlamat());
        }else{
            user.setAlamat("-");
        }

        if(user.getTgl_lahir()!=null){
            try {
            long date = new Date().getTime() - (new SimpleDateFormat("dd-MM-yyyy").
                    parse(String.valueOf(user.getTgl_lahir())).getTime());
                user.setUmur(String.valueOf((date/(24 * 60 * 60 * 1000))/365));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            user.setTgl_lahir("-");
            user.setUmur("-");
        }
        return user;
    }


    public void editData(int pilih, String input, int id){
        switch (pilih){
            case 1 -> AllObjectModel.user.editPassword(input,id); // id = user login
            case 2 -> AllObjectModel.user.editTanggalLahir(input,id); //id = user login
            case 3 -> AllObjectModel.user.editAlamat(input,id); //id = user.getId()
        }
    }
}
