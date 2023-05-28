package com.proxym.prospection.backend.features.DTO;

import com.proxym.prospection.backend.features.user.dao.entities.User;
import com.proxym.prospection.backend.features.user.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDTO extends User {

    private Role accessRole;

//    public UserRoleDTO(User user, Role accessRole) {
//        this(user.getId(),user.getFirstname(), user.getLastname(),user.getJoiningDate(),user.getDesignation(),user.getDepartments(),user.getUsername(),user.getEmail(),user.getPassword(),user.getConfirmPassword(), user.getOldPassword(),user.getRole(), accessRole);
//    }
//
//    public UserRoleDTO(Long id,String firstname,String lastname,String JoiningDate,String username,  String email,String password,String confirmPassword,String oldPassword,String Designation, String Departments , Role role, Role accessRole) {
//        super(id ,firstname,lastname,JoiningDate,Designation, Departments,username,email,password,confirmPassword,oldPassword, role);
//        this.accessRole = accessRole;
//    }

}
