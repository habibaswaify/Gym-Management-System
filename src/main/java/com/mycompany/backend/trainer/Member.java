package com.mycompany.backend.trainer;

import com.mycompany.backend.general.Record;

public class Member implements Record {
    private String memberId;
    private String name;
    private String memberType;
    private String email;
    private String phoneNumber;
    private String status;

    public Member(String memberId, String name, String memberType, String email, String phoneNumber, String status){
        this.memberId = memberId;
        this.name = name;
        this.memberType = memberType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    @Override
    public String LineRepresentation() {
        return this.memberId+","+this.name+","+this.memberType+","+this.email+","+this.phoneNumber+","+this.status;
    }

    @Override
    public String getSearchKey() {
        return this.memberId;
    }
}
