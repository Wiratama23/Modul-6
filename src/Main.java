import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    GridPane panel1 = new GridPane();
    GridPane panel2 = new GridPane();
    Scene scene1 = new Scene(panel1,300,275);
    Scene scene2 = new Scene(panel2, 450,550);

    //firstPanel
    HBox hbBtn = new HBox(10);
    Text scenetitle = new Text("Welcome");
    Label lName = new Label("Nama:");
    Label lnim = new Label("NIM:");
    TextField nameTextField = new TextField();
    TextField nimTextField = new TextField();
    Button btn = new Button("Submit");

    //second Panel
    final VBox vbox = new VBox();
    final Label label = new Label("Daftar Mahasiswa");
    private final TableColumn<Mahasiswa,String> nameCol = new TableColumn<>("Nama");
    private final TableColumn<Mahasiswa,String> nimCol = new TableColumn<>("NIM");
    //membuat object tableview atau bisa di bilang untuk memunculkan tabelnya
    private final TableView<Mahasiswa> table = new TableView<>();
    public static ObservableList<Mahasiswa> data = FXCollections.observableArrayList();

    public void firstPanel(){
        panel1.setAlignment(Pos.CENTER);
        panel1.setHgap(10);
        panel1.setVgap(10);
        panel1.setPadding(new Insets(25, 25, 25, 25));
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);

        //menepelkan node ke scene
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        panel1.add(scenetitle, 0, 0, 2, 1);
        panel1.add(lName, 0, 1);
        panel1.add(nameTextField, 1, 1);
        panel1.add(lnim, 0, 2);
        panel1.add(nimTextField, 1, 2);
        panel1.add(hbBtn, 1, 4);

    }
    @SuppressWarnings("unchecked")
    public void secondPanel(){
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(20, 10, 10, 10));

        //opsional
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefWidth(380);

        //set value yang sudah ada di getset ke tabel
        //bisa menggunakan ini atau yang di bawahnya
        nameCol.setCellValueFactory(data -> data.getValue().namaProperty());
        nimCol.setCellValueFactory(data -> data.getValue().nimProperty());

//        nameCol.setCellValueFactory(
//                new PropertyValueFactory<>("nama")
//        );
//        nimCol.setCellValueFactory(
//                new PropertyValueFactory<>("nim")
//        );
//        table.setItems(data);

        //menempelkan kolom tabel
        table.getColumns().addAll(nameCol, nimCol);
        vbox.getChildren().addAll(label, table);
        panel2.getChildren().add(vbox);
    }
    @Override
    public void start(Stage stage){
        firstPanel();
        secondPanel();

        //untuk action tombol ada 2 tipe bisa yang di bawah ini
        btn.setOnAction((ActionEvent e) -> {
            data.add(new Mahasiswa(nameTextField.getText(),nimTextField.getText()));
            nameTextField.clear();
            nimTextField.clear();

            stage.setScene(scene2);
            stage.setTitle("Test TableView");
        });

        //atau yang di comment ini
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                stage.setScene(scene2);
//            }
//        });

        stage.setTitle("Form Pendaftaran");
        stage.setScene(scene1);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
