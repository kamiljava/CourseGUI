package model;

public class Participant {

    private String participant_name;
    private String participant_lastname;

    @Override
    public String toString() {
        return "Participant{" +
                ", participant_name='" + participant_name + '\'' +
                ", participant_lastname='" + participant_lastname + '\'' +
                '}';
    }

    public Participant(String participant_name, String participant_lastname) {

        this.participant_name = participant_name;
        this.participant_lastname = participant_lastname;
    }

    public String getParticipant_name() {
        return participant_name;
    }

    public void setParticipant_name(String participant_name) {
        this.participant_name = participant_name;
    }

    public String getParticipant_lastname() {
        return participant_lastname;
    }

    public void setParticipant_lastname(String participant_lastname) {
        this.participant_lastname = participant_lastname;
    }
}
