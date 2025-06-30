

// File: user-service/src/main/java/com/corebank/user_service/enums/Role.java
package com.corebank.user_service.enums;

import com.fasterxml.jackson.annotation.JsonCreator; // <-- Import this
import com.fasterxml.jackson.annotation.JsonValue; // <-- Import this (good for serialization)

public enum Role {
    CUSTOMER,
    ADMIN; // <-- Semicolon is needed here because we are adding methods

    // Optional: If you want to customize how it's serialized (e.g., lowercase)
    // @JsonValue
    // public String toValue() {
    //     return this.name().toLowerCase();
    // }

    // This method tells Jackson how to deserialize the string to an enum
    @JsonCreator
    public static Role fromString(String value) {
        for (Role role : Role.values()) {
            if (role.name().equalsIgnoreCase(value)) { // Case-insensitive matching
                return role;
            }
        }
        // If the string doesn't match any enum constant, throw an exception
        throw new IllegalArgumentException("Unknown role: " + value);
    }
}
