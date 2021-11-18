package entities;

public class UserEntities extends PendudukEntities{
    private String no_hp, password, tgl_lahir;
    private String umur;

    public UserEntities() {}

    public UserEntities(int id, String nama, String noKtp,
                        String alamat, String no_hp, String password, String tgl_lahir) {
        super(id, nama, noKtp, alamat);
        this.no_hp = no_hp;
        this.password = password;
        this.tgl_lahir = tgl_lahir;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }
}
