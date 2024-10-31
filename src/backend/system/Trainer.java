package backend.system;

import backend.general.Record;

public class Trainer implements Record {
    String trainerId;
    String name;
    String email;
    String speciality;
    String phoneNumber;

    public Trainer(String trainerId, String name, String  email, String speciality, String phoneNumber){
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String LineRepresentation() {
        return this.trainerId+","+this.name+","+this.email+","+this.speciality+this.phoneNumber;
    }

    @Override
    public String getSearchKey() {
        return this.trainerId;
    }
}
