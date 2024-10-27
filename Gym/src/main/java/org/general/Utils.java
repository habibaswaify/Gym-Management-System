package org.general;

import java.util.List;

public class Utils {

    public Utils(){}

    private String capitalize(String input){
        String[] words  = input.split(" ");
        StringBuilder output = new StringBuilder(words[0].substring(0, 1).toUpperCase() + words[0].substring(1));
        String word;
        for (int i = 1; i < words.length; i++) {
            word = words[i];
            output.append(" ").append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
        }
        return output.toString();
    }

    private boolean validateName(String name){
        return name.matches("^[a-zA-Z][a-zA-Z '-]+$");
    }

    private boolean validateDate(String date){
        return date.matches("^\\d{4}-\\d{2}-\\d{2}$");

    }
    private boolean validateMembership(String membership){
        List<String> membershipTypes = List.of("monthly","yearly","premium");
        return membershipTypes.contains(membership.toLowerCase());

    }
    private boolean validateStatus(String status){
        List<String> statusTypes = List.of("active","expired");
        return statusTypes.contains(status.toLowerCase());

    }
    private boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+[.][a-z]{2,6}$");
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^01[0-9]{9}$");
    }

    private boolean validateTrainerID(String trainerID) {
        return trainerID.matches("^T\\d{3}$");
    }

    private boolean validateMemberID(String memberID) {
        return memberID.matches("^M\\d{4}$");
    }

    private boolean validateClassID(String classID) {
        return classID.matches("^C\\d{3}$");
    }
}
