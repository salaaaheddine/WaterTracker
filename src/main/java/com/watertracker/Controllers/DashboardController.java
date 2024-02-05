package com.watertracker.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.watertracker.Entities.WaterIntake;
import com.watertracker.Services.WaterIntakeService;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private WaterIntakeService waterIntakeService;

    @GetMapping
    public String showDashboard(Model model, Principal principal) {
        String username = "";
        if (principal != null) {
            username = principal.getName();
        }

        // Fetch user's water intake history
        List<WaterIntake> waterIntakeHistory = waterIntakeService.getUserWaterIntakeHistory(username);

        model.addAttribute("waterIntakeHistory", waterIntakeHistory);
        return "dashboard";
    }

    @PostMapping("/recordWater")
    public String recordWaterIntake(@RequestParam("quantity") int quantity, Principal principal) {
        // get the username from connected user

        String username = principal.getName();

        // Save the water intake record
        waterIntakeService.recordWaterIntake(username, quantity);

        // Redirect back to the dashboard after recording water intake
        return "redirect:/dashboard";
    }
}
