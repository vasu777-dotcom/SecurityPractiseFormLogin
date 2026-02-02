package com.example.SecurityPractiseFormLogin.model;

import com.example.SecurityPractiseFormLogin.util.GeneratedVasuId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Set;


@Entity
@Table(name="user_table")
@Setter
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedVasuId
    @Column(name="user_id")
    private String id;

    @Column(name="mail_id")
    @NotBlank(message = "username is a required field")
    @Pattern(regexp = "^[a-zA-Z]+([._]?[a-zA-Z0-9]+)*@[a-zA-Z]+[.](com|in)$", message = "mailId pattern is not matching")
    @NonNull
    private String username;

    @Column(name="password")
    @NotBlank(message = "password is a required field")
    @NonNull
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles_table", joinColumns = @JoinColumn(name = "user_id_fk"))
    @Column(name = "roles")
    @NotEmpty(message = "roles of user cannot be empty")
    @NonNull
    private Set<String> roles;

}
