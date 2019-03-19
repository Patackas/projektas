package com.group3.dms.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role_Group")
public class RoleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_group_id")
    private int role_group_id;
    @Column(name = "role_group")
    private String roleGroup;
}
