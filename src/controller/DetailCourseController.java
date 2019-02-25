package controller;

import animatefx.animation.FadeIn;
import animatefx.animation.RubberBand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Course;
import model.Participant;

public class DetailCourseController {

    @FXML
    private Label lbl_course_name;

    @FXML
    private Label lbl_course_category;

    @FXML
    private Label lbl_course_date;

    @FXML
    private Label lbl_course_trainer;

    @FXML
    private Label lbl_course_participants;

    @FXML
    private TextField tf_particip_firstname;

    @FXML
    private TextField tf_particip_lastname;

    @FXML
    private TableView<Participant> lbl_particip;

    @FXML
    private TableColumn<Participant, String> col_particip_firstname;

    @FXML
    private TableColumn<Participant, String> col_particip_lastname;
    @FXML
    Button btn_save,btn_deleteuser;

    ObservableList<Participant> participants = FXCollections.observableArrayList();

    private void insertParticipantIntoTableView(){
        col_particip_firstname.setCellValueFactory(new PropertyValueFactory<Participant,String >("participant_name"));
        col_particip_lastname.setCellValueFactory(new PropertyValueFactory<Participant, String>("participant_lastname"));
        lbl_particip.setItems(participants);
    }


    @FXML
    void delete_participant(ActionEvent event) {
        Participant c_clear = lbl_particip.getSelectionModel().getSelectedItem();
        participants.remove(c_clear);
        lbl_course_participants.setText(String.valueOf(participants.size()));
        new RubberBand(btn_deleteuser).play();
        insertParticipantIntoTableView();
    }

    @FXML
    void save_participant(ActionEvent event) {
        String particip_firstname = tf_particip_firstname.getText();
        String particip_lastname = tf_particip_lastname.getText();
        Participant p = new Participant(particip_firstname,particip_lastname);
        CourseController.c_selected.addParticipant(p);
        participants.add(p);
        insertParticipantIntoTableView();
        lbl_course_participants.setText(String.valueOf(CourseController.c_selected.getNoParticipant()));
        tf_particip_firstname.setText("");
        tf_particip_lastname.setText("");

        new FadeIn(btn_save).play();

    }

    public void initialize() {
        lbl_course_name.setText(CourseController.c_selected.getCourse_name());
        lbl_course_category.setText(CourseController.c_selected.getCourse_category());
        lbl_course_date.setText(CourseController.c_selected.getCourse_date().toString());
        lbl_course_trainer.setText(CourseController.c_selected.getCourse_trainer());
        lbl_course_participants.setText(String.valueOf(CourseController.c_selected.getNoParticipant()));
        participants.addAll(CourseController.c_selected.getCourse_participant());
        insertParticipantIntoTableView();
    }

}
