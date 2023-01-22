package com.lab.lab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.Signature;

import java.lang.annotation.Target;
import java.util.Date;
import java.sql.Time;

@Entity
@Table(name = "activity_logger")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    Date dateTime;
    String principle;
    String operation;
    String classPath;

    public Logger(Date dateTime, String principle, String operation, String classPath) {
        this.dateTime = dateTime;
        this.principle = principle;
        this.operation = operation;
        this.classPath = classPath;
    }
}
