package controller;

public interface ControllerInterface {
    public int cekLogin(String no_hp, String password);
    public int register(String nama, String noKtp, String alamat, String no_hp, String pass, String tgl_lahir);
}
