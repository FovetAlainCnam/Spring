package com.example.demo.controllers.proxy;

import com.example.demo.models.User;

public class RealAdminAccess extends AbstractAdminAccess {


    @Override
    public boolean adminAccess(String password, User user) {
        user.setAdmin(true);
        return true;
    }
}
