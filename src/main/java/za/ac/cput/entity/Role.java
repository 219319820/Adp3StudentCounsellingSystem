/*  Role.java
        Entity for Role
        *  Author: Vuyisa Nkangana(218192215)
        *  Date: 4 October 2021
        */
package za.ac.cput.entity;

import java.io.Serializable;

public class Role {
    private String roleId;
    private String roleDescription;

    private Role(){
    }
    private Role(Builder builder) {
        this.roleId = builder.roleId;
        this.roleDescription = builder.roleDescription;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    @Override
    public String toString() {

        return "Role{" +
                "roleId=" + roleId +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }

    public static class Builder {
        private String roleId;
        private String roleDescription;


        public Builder setRoleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder setRoleDescription(String roleDescription){
            this.roleDescription = roleDescription;
            return this;
        }

        public Builder copy(Role Role) {
            this.roleId = Role.roleId;
            this.roleDescription = Role.roleDescription;
            return this;
        }
        public Role build() {
            return new Role(this);
        }
    }
}
