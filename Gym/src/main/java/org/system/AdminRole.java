package org.system;

import org.general.Record;

import java.io.IOException;
import java.util.ArrayList;

public class AdminRole{
    private final TrainerDatabase trainerDatabase;

    // Constructor for class using trainerDatabase
    public AdminRole() {
        this.trainerDatabase = new TrainerDatabase("Trainers.txt");
    }

    // Adding new trainers to database after checking if they exist or not.
    public void addTrainer(String trainId, String name, String email, String speciality, String phoneNumber) {
        if (trainerDatabase.contains(trainId))
            System.out.println("Trainer "+trainId+" already exists.");
        else{
            Trainer trainer = new Trainer(trainId, name, email, speciality, phoneNumber);
            this.trainerDatabase.insertRecord(trainer);
            System.out.println("Trainer " + trainId + " was added successfully.");
        }
    }

    // Getter for records array in database class
    public ArrayList<Record> getListOfTrainers() {
        return this.trainerDatabase.returnAllRecords();
    }

    // Removing trainers from database
    public void removeTrainer(String key) {
        if (this.trainerDatabase.contains(key)) {
            this.trainerDatabase.deleteRecord(key);
            System.out.println("Trainer " +key+ " was removed successfully.");
        }
        else
            System.out.println("Trainer "+key+" already exists");
    }

    // Saving to file (???????????????)
    public void logout() throws IOException {
        this.trainerDatabase.saveToFile();
    }
}

