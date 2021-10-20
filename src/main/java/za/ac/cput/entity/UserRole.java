/*  UserRole.java
    Entity for User Role
 *  Author: Vuyisa Nkangana
 *  Date: 4 October 2021
 */

package za.ac.cput.entity;

import java.io.Serializable;

public class UserRole {
    private String roleId;
    private String userId;

    private UserRole(){

    }
    private UserRole(Builder builder) {
        this.roleId = builder.roleId;
        this.userId = builder.userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                ", roleId='" + roleId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
    public static class Builder {
        public String roleId;
        private String userId;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setRoleId(String roleId) {
            this.roleId = roleId;
            return this;

        }
        public Builder copy(UserRole userRole) {
            this.userId = userRole.userId;
            this.roleId = userRole.roleId;
            return this;
        }
        public UserRole build() {
            return new UserRole(this);
        }


    }
}
