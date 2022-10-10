package hu.bolyaitechnikum.bolyaimvc.runner;

import hu.bolyaitechnikum.bolyaimvc.persistence.model.Message;
import hu.bolyaitechnikum.bolyaimvc.persistence.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// ApplicationRunner implementációk indulásnál automatikusan meghívásra kerülnek.
// Pl. alkalmazás inicializálására használhatók.
// @Component annotáció alapján tudja a Spring, hogy meg kell találni a Runnert-t.
@Component
public class SetupRunner implements ApplicationRunner {

    // Dependency injection (field injection).
    // Spring automatikusan elérhetővé teszi a Contextben létező MessageRepositoryImpl példányt.
    // (Interfész alapján automatikusan generált egy példányt.)
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Message[] messages = {
                new Message(
                        LocalDateTime.now(),
                        "Hello World!", false
                ),
                new Message(
                        LocalDateTime.now().minusMinutes(10),
                        "Lorem ipsum!", false
                ),
                new Message(
                        LocalDateTime.now().minusMinutes(20),
                        "Ma 30 perccel korábban haza lehet menni.", true
                ),
                new Message(
                        LocalDateTime.now().minusMinutes(30),
                        "Tanulni kell a dolgozatra.", true
                ),
        };

        for (Message message : messages) {
            messageRepository.save(message);
        }

        System.out.println("Adatok létrehozva.");
    }
}
