import javafx.beans.property.SimpleStringProperty;

public class Mahasiswa {
    private final SimpleStringProperty nama;
    private final SimpleStringProperty nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = new SimpleStringProperty(nama);
        this.nim = new SimpleStringProperty(nim);
    }

    public SimpleStringProperty namaProperty() {
        return nama;
    }
    public SimpleStringProperty nimProperty() {
        return nim;
    }
}
