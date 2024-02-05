package com.watertracker.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.watertracker.Entities.Users;
import com.watertracker.Entities.WaterIntake;

public interface WaterIntakeRepository  extends JpaRepository<WaterIntake, Long> {
    List<WaterIntake> findByUserOrderByDateDesc(Users user);
}
