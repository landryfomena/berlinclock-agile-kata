package com.example.agilekata.controler;

import com.example.agilekata.service.BerlinClickService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/timeConverter")
public class BerlinClockController {

    @GetMapping
    public String index() {
        return "index";

    }

    @PostMapping("/berlin")
    public String getBerlinTimeFromDigitaltime(@RequestParam String digital_time, Model model) {

        try {
            System.out.println("Route was added" + digital_time);

            String result = BerlinClickService.digitalTimeToBerlinTime(digital_time);
            model.addAttribute("converted_berlin_time", result);
        } catch (IllegalArgumentException e) {

            model.addAttribute("converted_berlin_time", "Error "+ e.getMessage());
        }

        return "index";

    }

    @PostMapping("/digital")
    public String getDigitaltimeFromBerlinTime(@RequestParam String berlin_time, Model model) {
        try {
            String result = BerlinClickService.getDigitalTimeFromBerlinTime(berlin_time);
            model.addAttribute("converted_digital_time", result);
        } catch (IllegalArgumentException e) {
            model.addAttribute("converted_digital_time", "Error "+e.getMessage());
        }
        System.out.println("Route was added");

        return "index";

    }
}
