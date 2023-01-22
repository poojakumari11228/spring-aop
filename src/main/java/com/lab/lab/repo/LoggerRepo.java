package com.lab.lab.repo;

import com.lab.lab.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LoggerRepo extends JpaRepository<Logger, Long> {

}
