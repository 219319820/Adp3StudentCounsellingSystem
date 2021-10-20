/*  Role.java
        Entity for Role
        *  Author: Vuyisa Nkangana(218192215)
        *  Date: 4 October 2021
        */
package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Role {
    @Id
    private String roleId;
    private String roleName;
    private String roleDescription;


    private Role(){

    }
    private Role(Builder builder) {
        this.roleId = builder.roleId;
        this.roleName = builder.roleName;
        this.roleDescription = builder.roleDescription;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }


    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }

    public static class Builder {
        private String roleId;
        private String roleName;
        private String roleDescription;


        public Builder setRoleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder setRoleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public Builder setRoleDescription(String roleDescription){
            this.roleDescription = roleDescription;
            return this;
        }

        public Builder copy(Role role) {
            this.roleId = role.roleId;
            this.roleName = role.roleName;
            this.roleDescription = role.roleDescription;
            return this;
        }
        public Role build() {
            return new Role(this);
        }
    }
}
