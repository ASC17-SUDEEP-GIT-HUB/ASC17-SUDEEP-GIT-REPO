package com.demo.lab4.EmployeeManagementApp;

public class StorageFactory {

    private static final Storage storage = new StorageImpl();

    public static Storage getStorage() {

        return storage;
    }
}