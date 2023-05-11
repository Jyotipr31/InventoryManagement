package com.gl.inventorymanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="admin")
public class Admin {


@Id
@Column(name="user_id")
@GeneratedValue(strategy = GenerationType.AUTO)
 private int userId;
@Size(min=2 , message = "Name should be atleast 4 characters")
 private String username;
 private String password;
 private String email;
 private String location;
 private String roles;
}
