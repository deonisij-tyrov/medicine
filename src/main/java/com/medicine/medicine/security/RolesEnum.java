package com.medicine.medicine.security;

public enum RolesEnum {

    ADMIN_ROLE("ADMIN");

    private String role;

    private RolesEnum(final String role) {
        this.role = role;
    }

    public String getValue() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }

}

