package com.example.demo.controllers.proxy;

import com.example.demo.models.User;

public abstract class AbstractAdminAccess {
    public abstract boolean adminAccess(String password, User user);
}
