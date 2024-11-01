package com.mycompany.backend.trainer;

import com.mycompany.backend.general.Record;

public class Class implements Record {
    private String classId;
    private String className;
    private String trainerId;
    private int duration;
    private int availableSeats;

    public Class(String classId, String className, String trainerId, int duration, int availableSeats){
        this.classId = classId;
        this.className = className;
        this.trainerId = trainerId;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats(){
        return this.availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String LineRepresentation() {
        return this.classId+","+this.className+","+this.trainerId+","+this.duration+","+this.availableSeats;
    }

    @Override
    public String getSearchKey() {
        return this.classId;
    }
}
