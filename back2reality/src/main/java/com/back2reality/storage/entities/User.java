package com.back2reality.storage.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author FLIGHT
 */

@Entity
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user")
  @SequenceGenerator(name = "user", sequenceName = "s_user", allocationSize = 1)
  private long id;

  private String username;

  private String password;

  private String fullname;

  private String email;

  @Enumerated(EnumType.STRING)
  private Role role;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public String getFullname() {
    return fullname;
  }

  public String getEmail() {
    return email;
  }

  public Role getRole() {
    return role;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
