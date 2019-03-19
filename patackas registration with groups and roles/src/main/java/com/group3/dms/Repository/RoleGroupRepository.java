package com.group3.dms.Repository;

import com.group3.dms.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("role_groupRepository")
public interface RoleGroupRepository extends JpaRepository<RoleGroup, Integer> {
    RoleGroup findByRoleGroup(String role_group);

}
