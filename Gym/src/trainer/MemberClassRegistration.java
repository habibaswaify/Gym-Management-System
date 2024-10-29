package Gym.src.trainer;

import Gym.src.general.Record;

import java.time.LocalDate;

public class MemberClassRegistration implements Record {

    private String memberId;
    private String classId;
    private String status;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberId, String classId, String status, LocalDate registrationDate){
        this.memberId = memberId;
        this.classId = classId;
        this.status = status;
        this.registrationDate = registrationDate;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public String getClassId() {
        return this.classId;
    }

    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate;}

    public void setRegistrationStatus(String status) {this.status = status;}

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    @Override
    public String LineRepresentation() {
        return this.memberId+","+this.classId+","+this.registrationDate+","+this.status;
    }

    @Override
    public String getSearchKey() {
        return this.memberId+"-"+this.classId;
    }
}
