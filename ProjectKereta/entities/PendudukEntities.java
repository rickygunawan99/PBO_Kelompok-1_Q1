package entities;

public class PendudukEntities {
    private int id;
    private String nama, noKtp,alamat;

    public PendudukEntities() {
    }

    public PendudukEntities(int id, String nama, String noKtp, String alamat) {
        this.id = id;
        this.nama = nama;
        this.noKtp = noKtp;
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
