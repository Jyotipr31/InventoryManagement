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
@Table(name="user")
public class User {


@Id
@Column(name="user_id")
@GeneratedValue(strategy = GenerationType.AUTO)
 private int userId;
@Size(min=2 , message = "Name should be atleast 4 characters")
 private String name;
 private String password;
 private String roles;
}
