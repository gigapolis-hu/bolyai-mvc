package hu.bolyaitechnikum.bolyaimvc.controller;

import hu.bolyaitechnikum.bolyaimvc.persistence.model.Message;
import hu.bolyaitechnikum.bolyaimvc.persistence.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

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

    @GetMapping("/unordered")
    public String listMessagesUnordered(Model model) {
        // (List<Message>): kasztolás / típusellenőrzés kikapcsolása
        List<Message> messages = (List<Message>) messageRepository.findAll();

        model.addAttribute("title", "LIST UNORDERED");
        model.addAttribute("messages", messages);

        return "messages";
    }

    @GetMapping("/ordered")
    public String listMessagesOrdered(Model model) {
        List<Message> messages = messageRepository.findByOrderByTimestampDesc();

        model.addAttribute("title", "LIST ORDERED");
        model.addAttribute("messages", messages);

        return "messages";
    }

    @GetMapping("/important")
    public String listMessagesImportant(Model model) {
        List<Message> messages = messageRepository.findByImportantOrderByTimestampDesc(true);

        model.addAttribute("title", "IMPORTANT");
        model.addAttribute("messages", messages);

        return "messages";
    }

    @GetMapping("/message/{id}")
    public String viewMessage(@PathVariable long id, Model model) {
        // orElseThrow: ha nincs találat, akkor hibát dob
        Message message = messageRepository.findById(id).orElseThrow();

        model.addAttribute("message", message);

        return "view_message";
    }
}
