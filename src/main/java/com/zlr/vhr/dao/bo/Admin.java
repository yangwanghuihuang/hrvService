package com.zlr.vhr.dao.bo;

import java.io.Serializable;

public class Admin implements Serializable {
    private Long adminId;

    private String authority;

    private String passowrd;

    private String username;

    private static final long serialVersionUID = 1L;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}