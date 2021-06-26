package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import sample.db.DB;
import sample.model.Student;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField text_name;

    @FXML
    private TextField text_surname;

    @FXML
    private Button btn_add_user;

    @FXML
    private VBox paneVBox;

    @FXML
    private TextField text_age;

    @FXML
    private Label lbl_info;
        DB db = new DB();
    List<Student> students = db.getStudents();
    int lengthListSrudent;

    @FXML
    void initialize() throws IOException {
             lengthListSrudent = students.size();
            for (int i = 0; i< lengthListSrudent; i++) {
                refresList(i);
            }
              btn_add_user.setOnAction(event ->{

              String name  = text_name.getCharacters().toString();
              String surname  = text_surname.getCharacters().toString();
              int age  = Integer.parseInt(text_age.getCharacters().toString());

                Student student = new Student(name, surname, age);
               System.out.println(student);
               students.add(student);

                  try {
                      lengthListSrudent = students.size();
                      refresList(lengthListSrudent-1);
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              });

    }
    public void refresList(int lengthListSrudent) throws IOException {
        Node node = null;

            node = FXMLLoader.load(getClass().getResource("/sample/scene/sceneStudent.fxml"));
            Label name = (Label)node.lookup("#name");
            Label surname = (Label)node.lookup("#surname");
            Label age = (Label) node.lookup("#age");
            name.setText(students.get(lengthListSrudent).getName());
            surname.setText(students.get(lengthListSrudent).getSurname());
            age.setText(""+ students.get(lengthListSrudent).getAge());
            final Node nodeSet = node;
            node.setOnMouseEntered(event-> {
                nodeSet.setStyle("-fx-background-color: #707173");
            });
            nodeSet.setOnMouseExited(mouseEvent -> {
                nodeSet.setStyle("-fx-background-color: #343434");
            });



            HBox hBox = new HBox();
            hBox.getChildren().add(node);
            hBox.setAlignment(Pos.BASELINE_CENTER);
            paneVBox.getChildren().add(hBox);
            paneVBox.setSpacing(10);

            paneVBox.getChildren().add(node);

        }

    }





