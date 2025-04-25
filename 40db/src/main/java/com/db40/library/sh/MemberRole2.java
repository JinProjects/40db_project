package com.db40.library.sh;

import lombok.Getter;

@Getter
public enum MemberRole2 {
	
    ADMIN("ROLE_ADMIN"),
    MEMBER("ROLE_MEMBER");

    MemberRole2(String value) {
        this.value = value;
    }

    private String value;

}
