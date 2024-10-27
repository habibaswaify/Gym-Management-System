package org.trainer;

import org.general.Database;
import org.general.Record;
import org.system.Trainer;

public class MemberDatabase extends Database{

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
        String status = memberData[4];
        return new Member(memberId, name, memberType, email, phoneNumber, status);
    }
}
