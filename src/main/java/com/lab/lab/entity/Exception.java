package com.lab.lab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "exception_logger")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    Date dateTime;
    String principle;
    String operation;
    String classPath;
    String exceptionType;

    public Exception(Date dateTime, String principle, String operation, String classPath, String exceptionType) {
        this.dateTime = dateTime;
        this.principle = principle;
        this.operation = operation;
        this.classPath = classPath;
        this.exceptionType = exceptionType;
    }
}
