package com.watertracker.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watertracker.Entities.Users;
import com.watertracker.Entities.WaterIntake;
import com.watertracker.Repositories.UsersRepository;
import com.watertracker.Repositories.WaterIntakeRepository;

@Service
public class WaterIntakeService {

    @Autowired
    private WaterIntakeRepository waterIntakeRepository;

    @Autowired
    private UsersRepository usersRepository;

    public List<WaterIntake> getUserWaterIntakeHistory(String username) {
        Users user = usersRepository.findByUsername(username);
        return waterIntakeRepository.findByUserOrderByDateDesc(user);
    }

    public void recordWaterIntake(String username, int quantity) {
        Users user = usersRepository.findByUsername(username);

        // Create a new water intake record
        WaterIntake waterIntake = new WaterIntake();
        waterIntake.setUser(user);
        waterIntake.setAmount(quantity);

        // Save the water intake record to the database
        waterIntakeRepository.save(waterIntake);
    }
}

