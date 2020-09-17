package com.mavenmodak.coronatracker.controllers;


import com.mavenmodak.coronatracker.models.LocationStat;
import com.mavenmodak.coronatracker.services.CoronaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaDataService coronaDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStat> allStat = coronaDataService.getAllStat();
        int totalReportedCases = allStat.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStat.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStat", allStat);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases",totalNewCases);

        return "home";
    }
}
