package backend.trainer;


import backend.general.Record;
import constants.FileNames;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TrainerRole {
    private final MemberDatabase memberDatabase;
    private final ClassDatabase classDatabase;
    private final MemberClassRegistrationDatabase registrationDatabase;

    // Constructor for class using trainerDatabase
    public TrainerRole() throws IOException {
        this.memberDatabase = new MemberDatabase(FileNames.MEMBER_FILENAME);
        this.classDatabase = new ClassDatabase(FileNames.CLASS_FILENAME);
        this.registrationDatabase = new MemberClassRegistrationDatabase(FileNames.REGISTRATION_FILENAME);
        this.memberDatabase.readFromFile();
        this.classDatabase.readFromFile();
        this.registrationDatabase.readFromFile();
    }

    // Adding new members to database after checking if they exist or not.
    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        if (memberDatabase.contains(memberID))
            System.out.println("Member " + memberID + " already exists.");
        else {
            Member member = new Member(memberID, name, membershipType, email, phoneNumber, status);
            this.memberDatabase.insertRecord(member);
            System.out.println("Member " + memberID + " was added successfully.");
        }
    }

    // Getter for records array in database class
    public ArrayList<Member> getListOfMembers() {
        ArrayList<Member> members = new ArrayList<>();
        for (Record record : memberDatabase.returnAllRecords()) {
            members.add((Member) record);
        }
        return members;
    }

    // Adding new classes to database after checking if they exist or not.
    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        if (classDatabase.contains(classID))
            System.out.println("Class " + classID + " already exists.");
        else {
            boolean validInput = true;
            if (duration < 15) {
                System.out.println("Minimum duration is 15 minutes.");
                validInput = false;
            }
            if (maxParticipants <= 0) {
                System.out.println("Maximum participants should be a positive integer.");
                validInput = false;
            }
            if (validInput) {
                Class classRecord = new Class(classID, className, trainerID, duration, maxParticipants);
                this.classDatabase.insertRecord(classRecord);
                System.out.println("Class " + classID + " was added successfully.");
            }

        }
    }

    // Getter for records array in database class
    public ArrayList<Class> getListOfClasses() {
        ArrayList<Class> classes = new ArrayList<>();
        for (Record record : classDatabase.returnAllRecords()) {
            classes.add((Class) record);
        }
        return classes;
    }

    // Registering members for classes if both the member and class IDs exist in the records
    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        if (!classDatabase.contains(classID)) {
            System.out.println("Class " + classID + " does not exist.");
            return false;
        }
        if (!memberDatabase.contains(memberID)) {
            System.out.println("Member " + memberID + " does not exist.");
            return false;
        }
        int availableSeats = classDatabase.getRecord(classID).getAvailableSeats();
        if (availableSeats > 0) {
            MemberClassRegistration registration = new MemberClassRegistration(memberID, classID, "active", registrationDate);
            this.registrationDatabase.insertRecord(registration);
            System.out.println("Registration "+memberID+classID+" was added successfully");
            this.classDatabase.getRecord(classID).setAvailableSeats(availableSeats - 1);
        } else {
            System.out.println("No available seats!");
            return false;
        }
        return true;
    }
    // Cancelling registrations if both the member and class IDs exist in the records
    public boolean cancelRegistration(String memberID, String classID) {
        String key = memberID +"-"+ classID;
        if (!memberDatabase.contains(memberID)) {
            System.out.println("Member with ID " + memberID + " does not exist.");
            return false;
        }
        if (!classDatabase.contains(classID)) {
            System.out.println("Class with ID " + classID + " does not exist.");
            return false;
        }
        if (!registrationDatabase.contains(key)) {
            System.out.println("Registration with ID " + key + " does not exist");
            return false;
        }
        if (registrationDatabase.returnAllRecords().isEmpty()) {
            System.out.println("No registrations to cancel.");
            return false;
        }
        MemberClassRegistration memberClassRegistration = registrationDatabase.getRecord(key);
        LocalDate registrationDate = memberClassRegistration.getRegistrationDate();
        LocalDate currentDate = LocalDate.now();

        long daysDifference = currentDate.toEpochDay() - registrationDate.toEpochDay();
        if (daysDifference <= 3) {
            memberClassRegistration.setRegistrationStatus("cancelled");
            int availableSeats = classDatabase.getRecord(classID).getAvailableSeats();
            //    Increment the available seats
            classDatabase.getRecord(classID).setAvailableSeats(availableSeats + 1);
            System.out.println("Registration cancelled.");
            registrationDatabase.deleteRecord(key);
            return true;

        } else {
            System.out.println("Cannot cancel after exceeding 3 days.");
            return false;
        }

    }

    // Getter for records array in database class
    public ArrayList<MemberClassRegistration> getListOfRegistrations() {
        ArrayList<MemberClassRegistration> registrations = new ArrayList<>();
        for (Record record : registrationDatabase.returnAllRecords()) {
            registrations.add((MemberClassRegistration) record);
        }
        return registrations;
    }
    public void logout() throws IOException{
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
    }

}
