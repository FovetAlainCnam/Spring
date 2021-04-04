package com.example.demo.controllers.proxy;

import com.example.demo.models.User;

public class ProxyAdminAccess extends AbstractAdminAccess {
    private RealAdminAccess realAdminAccess;

    public ProxyAdminAccess() {
        this.realAdminAccess = new RealAdminAccess();
    }

    @Override
    public boolean adminAccess(String password, User user) {
        if (password.equals("12345678")) {
            return realAdminAccess.adminAccess(password, user);
        }
        return false;
    }
}
