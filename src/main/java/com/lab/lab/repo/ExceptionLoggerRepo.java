package com.lab.lab.repo;

import com.lab.lab.entity.Exception;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionLoggerRepo extends JpaRepository<Exception, Long> {
}
