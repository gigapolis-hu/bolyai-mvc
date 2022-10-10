package hu.bolyaitechnikum.bolyaimvc.controller;

import hu.bolyaitechnikum.bolyaimvc.persistence.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class MessageController {

    // endpoint (adott URL-hez tartozó eseménykezelők)
    @GetMapping("/")
    public String homePage() {
        return "home"; // view (template) neve: home.html
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about"; // view (template) neve: about.html
    }

    @GetMapping("/test")
    public String testPage(Model model) {
        Message[] messages = {
                new Message(
                        LocalDateTime.now().minusMinutes(10),
                        "Lorem ipsum!", false
                ),
                new Message(
                        LocalDateTime.now().minusMinutes(20),
                        "Ma 30 perccel korábban haza lehet menni.", true
                )
        };

        // Végleges HTML = Thymeleaf sablon (view) + adatok (model)

        model.addAttribute("title", "TEST");
        model.addAttribute("messages", messages);

        return "messages";
    }

}
