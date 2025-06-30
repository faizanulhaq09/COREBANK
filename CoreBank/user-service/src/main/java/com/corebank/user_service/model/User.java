package com.corebank.user_service.model;
//
//import com.corebank.user_service.enums.Role;
//import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*; // Import JPA annotations
import lombok.AllArgsConstructor; // Import Lombok annotations
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Marks this class as a JPA entity, mapped to a database table
@Table(name = "users") // Specifies the table name in the database (optional, defaults to class name)
@Data // Lombok annotation to generate getters, setters, toString, equals, hashCode
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate an all-argument constructor
public class User {

    @Id // Marks the field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures primary key generation (auto-increment)
    private Long id;

    @Column(unique = true, nullable = false) // Defines column properties: must be unique and not null
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password; // In a real app, this would be hashed
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    @Schema(allowableValues = {"CUSTOMER", "ADMIN"})
//    private Role role = Role.CUSTOMER; // We will define this Role enum next

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
// You can add more fields like firstName, lastName, registrationDate, etc.
}