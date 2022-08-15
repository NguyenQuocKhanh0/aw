package Controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.Insets;
import Model.SinhVien;
import javafx.animation.SequentialTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.beans.value.*;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class MainSceneController  {
  //  @FXML private Button mhc;
  
    @FXML 
    void SinhVienProcess(MouseEvent event) throws IOException {
      Button back = new Button();
      back.setText("BACK");
      back.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
          try {
            Parent dash = FXMLLoader.load(getClass().getResource("/View/qlsv1.fxml"));
            Scene dashScene = new Scene(dash);
            Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            window.setScene(dashScene);
            window.show();
            
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
         
      });

    //  SVButton.setFont(Font.font("Verdana", 15));
   // SVButton.setDisable(true);

   //   flow.getChildren().add(SVButton);
    //  Parent dash = FXMLLoader.load(getClass().getResource("sinhvien.fxml"));
      
      
        TableView<SinhVien> table = new TableView<SinhVien>();
      TableColumn<SinhVien, String> fullNameCol = new TableColumn<SinhVien, String>("Full Name");
      fullNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
      TableColumn<SinhVien, Integer> BirthdayCol = new TableColumn<SinhVien, Integer>("ID");
      BirthdayCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
      TableColumn<SinhVien, String> IDCol = new TableColumn<SinhVien, String>("Ngày sinh");
      IDCol.setCellValueFactory(new PropertyValueFactory<>("Birthday"));
      TableColumn<SinhVien, String> SDTCol = new TableColumn<SinhVien, String>("SDT");
      SDTCol.setCellValueFactory(new PropertyValueFactory<>("SDT"));
      TableColumn<SinhVien, Boolean> GTCol = new TableColumn<SinhVien, Boolean>("Giới tính");
      GTCol.setCellValueFactory(new PropertyValueFactory<>("GT"));
      TableColumn<SinhVien, String> DiaChiCol = new TableColumn<SinhVien, String>("Địa chỉ");
      DiaChiCol.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));
      TableColumn<SinhVien, Boolean> TinhTrangCol = new TableColumn<SinhVien, Boolean>("Tình Trạng");
      TinhTrangCol.setCellValueFactory(new PropertyValueFactory<>("TinhTrang"));
      ObservableList<SinhVien> list = getUserList();
      table.setItems(list);

      table.getColumns().addAll( IDCol,fullNameCol,GTCol,DiaChiCol,SDTCol,BirthdayCol,TinhTrangCol);
      FlowPane pane = new FlowPane();
      //flowpane.setPadding(new Insets(1));
      pane.getChildren().add(table);
      pane.getChildren().add(back);

      Scene dashScene = new Scene(pane);
      Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
      window.setScene(dashScene);
      window.show();
      
    }
 
    public ObservableList<SinhVien> getUserList() {

      SinhVien user1 = new SinhVien(1,"Khanh","0345650928","26/08/2002",true,"Hà Nội",true);
      SinhVien user2 = new SinhVien(2,"Tien","123456789","26/08/2000",true,"Nghệ An",true);

      ObservableList<SinhVien> list = FXCollections.observableArrayList(user1,user2);
      return list;
  }
    

}