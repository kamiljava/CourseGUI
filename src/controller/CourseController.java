package controller;

import animatefx.animation.FadeIn;
import animatefx.animation.RubberBand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Course;
import model.Participant;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;

public class CourseController {
    //Obiekt listy Kursów
    ObservableList<Course> courses = FXCollections.observableArrayList();
    public static int id;
    ////////

    @FXML
    private TableView<Course> tbl_course;

    @FXML
    private TableColumn<Course, String> col_course_name;

    @FXML
    private TableColumn<Course, String> col_course_category;

    @FXML
    private TextField tf_course_name;

    @FXML
    private TextField tf_course_category;

    @FXML
    private TextField tf_course_trainer;

    @FXML
    private DatePicker dp_course_date;

    @FXML
    Button btn_add, btn_delate, btn_view;

    @FXML
    void addCourse(ActionEvent event) {
        //walidacja danych
        if (!tf_course_name.getText().equals("") && !tf_course_category.getText().equals("") && dp_course_date.getValue() != null) {
            //pobieranie wartosci z kontrolki TextField
            String course_name = tf_course_name.getText();
            String course_category = tf_course_category.getText();
            LocalDate course_date = dp_course_date.getValue();
            String course_trainer = tf_course_trainer.getText();
            //Tworzenie obiektu klasy Course
            Course c = new Course(++id, course_name, course_category, course_date, course_trainer);
            courses.add(c);
            //Zerowanie wartosci po dodaniu kursu
            tf_course_name.setText("");
            tf_course_category.setText("");
            tf_course_trainer.setText("");
            dp_course_date.setValue(null);
            //Odswiezenie TableView
            new FadeIn(btn_add).play();
            insertCoursesIntoTableView();

        } else {
            //JOptionPane.showMessageDialog(null, "Błąd.
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Błąd");
            a.setHeaderText("Błąd dodawania nowego kursu");
            a.setContentText("Musisz podać wszystkie dane");
            a.show();
            new RubberBand(btn_add).play();
        }
    }

    @FXML
    void deleteCourse(ActionEvent event) {
        //odczyt zaznaczonego rekordu z tabeli
        Course c_deleted = tbl_course.getSelectionModel().getSelectedItem();
        courses.remove(c_deleted);
        new RubberBand(btn_delate).play();
        insertCoursesIntoTableView();
    }

    //przekazywanie obiektu statycznego do innego widoku
    static Course c_selected;

    @FXML
    void getCourse(ActionEvent event) throws IOException {
        c_selected = tbl_course.getSelectionModel().getSelectedItem();
        Stage courseStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/detailCourseView.fxml"));
        courseStage.setTitle("Wybrany kurs");
        courseStage.setScene(new Scene(root));
        courseStage.getScene().getStylesheets().add("Style.css");
        Image image = new Image("/view/img/logo.png");
        courseStage.getIcons().add(image);
        courseStage.setResizable(false);
        new FadeIn(btn_view).play();
        courseStage.show();
    }

    //metoda do wprowadzania zawartosci kursow do tabelki
    private void insertCoursesIntoTableView() {
        //konfiguracja zmiennych do klolumn
        col_course_name.setCellValueFactory(new PropertyValueFactory<Course, String>("course_name"));
        col_course_category.setCellValueFactory(new PropertyValueFactory<Course, String>("course_category"));
        //wprowadzenie danych do tabeli z listy ObservedList
        tbl_course.setItems(courses);

    }
    private void addSampleData(){
        courses.add(new Course(++id,"Java FX" , "Programowanie", LocalDate.of(2019,01,12),"Roman Taczka"));
        courses.add(new Course(++id,"CSS i HTML" , "Strony WWW", LocalDate.of(2019,01,12),"Grzegorz Wiadro"));
        courses.add(new Course(++id,"ISTQB" , "Testowanie", LocalDate.of(2019,01,12),"Stanisław Szybki"));
        courses.add(new Course(++id,"Javascript" , "Programowanie", LocalDate.of(2019,01,12),"Wojciech Mojżesz"));
        courses.add(new Course(++id,"MY SQL" , "Bazy Danych", LocalDate.of(2019,01,12),"Maciej Borek"));
        courses.add(new Course(++id,"Android studio" , "Programowanie", LocalDate.of(2019,01,12),"Radosław Kałuża"));

        courses.get(1).addParticipant(new Participant("Janusz", "Kowalski"));
        courses.get(0).addParticipant(new Participant("Grażyna", "Nowak"));
        courses.get(2).addParticipant(new Participant("Jakub", "Dudek"));
        courses.get(3).addParticipant(new Participant("Grzegorz", "Szczęsny"));
        courses.get(4).addParticipant(new Participant("Maciej", "Glik"));
        courses.get(5).addParticipant(new Participant("Władysław", "Jagiełło"));
        courses.get(0).addParticipant(new Participant("Mariola", "Kownacka"));
        courses.get(1).addParticipant(new Participant("Ździsław", "Sosna"));
        courses.get(2).addParticipant(new Participant("Michał", "Warzycha"));
        courses.get(3).addParticipant(new Participant("Teresa", "Maj"));
        courses.get(4).addParticipant(new Participant("Benedykt", "Lewandpwski"));
        courses.get(5).addParticipant(new Participant("Andrzej", "Piszczel"));
    }
    public void initialize() {
        addSampleData();
        insertCoursesIntoTableView();
    }
}

