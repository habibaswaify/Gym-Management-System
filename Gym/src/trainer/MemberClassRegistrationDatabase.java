package Gym.src.trainer;

import Gym.src.general.Database;
import Gym.src.system.Trainer;

import java.time.LocalDate;

public class MemberClassRegistrationDatabase extends Database {
    public MemberClassRegistrationDatabase(String filename) {
        super(filename);
    }

    @Override
    public MemberClassRegistration createRecordFrom(String line) {
        String[] memberClassRegistrationData = line.split(",");
        String memberId = memberClassRegistrationData[0];
        String classId = memberClassRegistrationData[1];
        LocalDate registrationDate = LocalDate.parse(memberClassRegistrationData[2]);
        String status = memberClassRegistrationData[3];
        return new MemberClassRegistration(memberId, classId, status, registrationDate);
    }
    @Override
    public MemberClassRegistration getRecord(String key) {
        return (MemberClassRegistration) super.getRecord(key);
    }
}
