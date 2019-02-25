package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String course_name;
    private String course_category;
    private LocalDate course_date;
    private String course_trainer;
    //LISTA KURSANTOW
    private List<Participant> course_participant = new ArrayList<>();

    public List<Participant> getCourse_participant() {
        return course_participant;
    }

    public int getNoParticipant(){
        return course_participant.size();
    }
    public void addParticipant(Participant p){
        course_participant.add(p);

    }
    public void deleteParticipant(Participant p){
        course_participant.remove(p);

    }



    //////////////////////////////////
    public Course(int id, String course_name, String course_category, LocalDate course_date, String course_trainer) {
        this.id = id;
        this.course_name = course_name;
        this.course_category = course_category;
        this.course_date = course_date;
        this.course_trainer = course_trainer;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                ", course_category='" + course_category + '\'' +
                ", course_date=" + course_date +
                ", course_trainer='" + course_trainer + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_category() {
        return course_category;
    }

    public void setCourse_category(String course_category) {
        this.course_category = course_category;
    }

    public LocalDate getCourse_date() {
        return course_date;
    }

    public void setCourse_date(LocalDate course_date) {
        this.course_date = course_date;
    }

    public String getCourse_trainer() {
        return course_trainer;
    }

    public void setCourse_trainer(String course_trainer) {
        this.course_trainer = course_trainer;
    }
}
