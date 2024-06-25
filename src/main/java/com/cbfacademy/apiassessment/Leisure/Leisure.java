package com.cbfacademy.apiassessment.Leisure;

import java.math.BigDecimal;
import java.util.UUID;

import com.cbfacademy.apiassessment.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "leisure")
public class Leisure {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "leisure_id")
private UUID id;

@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;

private BigDecimal entertainmentById; 
private BigDecimal diningOutById;
private BigDecimal travelById;
private BigDecimal sportsMembershipById;
private String frequency;

// Constructors: default and parameterized
public Leisure() {
this(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "monthly");
}

public Leisure(User user, BigDecimal entertainmentById, BigDecimal diningOutById, BigDecimal travelById, BigDecimal sportsMembershipById, String frequency) {
    this.user= user;
    this.entertainmentById = entertainmentById;
    this.diningOutById = diningOutById;
    this.travelById = travelById;
    this.sportsMembershipById = sportsMembershipById;
    this.frequency = frequency;
}

public UUID getId() {
    return id;
}

public User getUser(){
    return user;
}

public void setuser (User user) {
    this.user = user;
}
public BigDecimal getEntertainmentById() {
    return entertainmentById;
}

public void setEntertainmentById(BigDecimal entertainmentById) {
    this.entertainmentById = entertainmentById;
}

public BigDecimal getDiningOutById() {
    return diningOutById;
}

public void setDiningOutById(BigDecimal diningOutById) {
    this.diningOutById = diningOutById;
}

public BigDecimal getTravelById() {
    return travelById;
}

public void setTravelById(BigDecimal travelById) {
    this.travelById = travelById;
}

public BigDecimal getSportsMembershipById() {
    return sportsMembershipById;
}

public void setSportsMembershipById(BigDecimal sportsMembershipById) {
    this.sportsMembershipById = sportsMembershipById;
}

public String getFrequency() {
    return frequency;
}

public void setFrequency(String frequency) {
    this.frequency = frequency;
}
}
