package Gym.src.backend.general;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public Utils(){}

    public String capitalize(String input){
        String[] words  = input.split(" ");
        StringBuilder output = new StringBuilder(words[0].substring(0, 1).toUpperCase() + words[0].substring(1));
        String word;
        for (int i = 1; i < words.length; i++) {
            word = words[i];
            output.append(" ").append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
        }
        return output.toString();
    }

    public boolean validateName(String name){
        return name.matches("^[a-zA-Z][a-zA-Z '-]+$");
    }

    public boolean validateDate(String date){
        return date.matches("^\\d{4}-\\d{2}-\\d{2}$");

    }
    public boolean validateMembership(String membership){
        List<String> membershipTypes = List.of("monthly","yearly","premium");
        return membershipTypes.contains(membership.toLowerCase());

    }
    public boolean validateStatus(String status){
        List<String> statusTypes = List.of("active","expired");
        return statusTypes.contains(status.toLowerCase());

    }
    public boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+[.][a-z]{2,6}$");
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^01[0-9]{9}$");
    }

    public boolean validateTrainerID(String trainerID) {
        return trainerID.matches("^T\\d{3}$");
    }

    public boolean validateMemberID(String memberID) {
        return memberID.matches("^M\\d{4}$");
    }

    public boolean validateClassID(String classID) {
        return classID.matches("^C\\d{3}$");
    }
    public boolean recordExists(ArrayList<? extends Record> records,String key){
        for(Record record:records){
            if (record.getSearchKey().equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;
    }
}
