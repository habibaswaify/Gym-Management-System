package Gym.src.backend.trainer;

import Gym.src.backend.general.Database;

public class MemberDatabase extends Database {

    public MemberDatabase(String filename) {
        super(filename);
    }

    @Override
    public Member createRecordFrom(String line) {
        String[] memberData = line.split(",");
        String memberId = memberData[0];
        String name = memberData[1];
        String memberType = memberData[2];
        String email = memberData[3];
        String phoneNumber = memberData[4];
        String status = memberData[5];
        return new Member(memberId, name, memberType, email, phoneNumber, status);
    }

    @Override
    public Member getRecord(String key) {
        return (Member) super.getRecord(key);
    }
}
