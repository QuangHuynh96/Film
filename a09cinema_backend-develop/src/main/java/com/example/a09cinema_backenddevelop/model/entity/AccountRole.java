package com.example.a09cinema_backenddevelop.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import lombok.Data;
//import com.voodoodyne.jackson.jsog.JSOGGenerator;
import javax.persistence.*;
@Entity
@Data
//@JsonIdentityInfo(generator= JSOGGenerator.class)
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @JsonBackReference("role-account")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @JsonBackReference("account-role")
    private Account account;


}
