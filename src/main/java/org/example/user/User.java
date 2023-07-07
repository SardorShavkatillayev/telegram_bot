package org.example.user;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.common.BaseEntity;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class User extends BaseEntity<String> {
    private String firstname;
    private String lastaname;
    private String username;
    private String phoneNumber;
    private UserState userState;
    private UserRole userRole;

    @Builder
    public User(String id, LocalDateTime update, LocalDateTime created, String firstname,
                String lastaname, String username, String phoneNumber, UserState userState,
                UserRole userRole) {
        super(id, update, created);
        this.firstname = firstname;
        this.lastaname = lastaname;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.userState = userState;
        this.userRole=userRole;
    }

    public String getfulname() {
        return firstname + " " + lastaname;
    }


}
