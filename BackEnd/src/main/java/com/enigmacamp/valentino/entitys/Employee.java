package com.enigmacamp.valentino.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @Column(name = "BIRTH_DATE")
    @NotNull
    private Date birthDate;
    @ManyToOne
    @JoinColumn(name = "POSITION_ID")
    @JsonIgnoreProperties(value = {"employees"})
    @NotNull
    private Position position;
    @Transient
    private Integer transientPositionId;
    @Column(name = "ID_NUMBER")
    @NotNull
    private Integer idNumber;
    @NotNull
    private Integer gender;
    @Column(name = "IS_DELETE")
    private Integer isDelete;

    public Integer getTransientPositionId() {
        return transientPositionId;
    }

    public void setTransientPositionId(Integer transientPositionId) {
        this.transientPositionId = transientPositionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
