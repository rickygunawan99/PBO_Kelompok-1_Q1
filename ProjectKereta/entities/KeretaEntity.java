package entities;

public class KeretaEntity {
    private int id;
    private String nama_kereta, rute_kereta, jam_operasi;
    private int kapasitas, jml_penumpang, harga;

    public KeretaEntity() {
    }

    public KeretaEntity(String nama_kereta, String rute_kereta, String jam_operasi, int kapasitas) {
        this.nama_kereta = nama_kereta;
        this.rute_kereta = rute_kereta;
        this.jam_operasi = jam_operasi;
        this.kapasitas = kapasitas;

    }

    /**
     * Method getter dan setter
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_kereta() {
        return nama_kereta;
    }

    public void setNama_kereta(String nama_kereta) {
        this.nama_kereta = nama_kereta;
    }

    public String getRute_kereta() {
        return rute_kereta;
    }

    public void setRute_kereta(String rute_kereta) {
        this.rute_kereta = rute_kereta;
    }

    public String getJam_operasi() {
        return jam_operasi;
    }

    public void setJam_operasi(String jam_operasi) {
        this.jam_operasi = jam_operasi;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public int getJml_penumpang() {
        return jml_penumpang;
    }

    public void setJml_penumpang(int jml_penumpang) {
        this.jml_penumpang = jml_penumpang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
