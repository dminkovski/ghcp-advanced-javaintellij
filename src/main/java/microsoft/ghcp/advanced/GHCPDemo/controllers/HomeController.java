package microsoft.ghcp.advanced.GHCPDemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Welcome to the GHCP Demo Application!";
    }
}
