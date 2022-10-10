package hu.bolyaitechnikum.bolyaimvc.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

// tábla felépítése (structure) + 1 sor / rekord adatai
@Entity
public class Message {
    // elsődleges kulcs
    @Id
    // ha null az id,
    // akkor az adatbázis automatikusan ad egy újat (növekvő sorrendben)
    @GeneratedValue
    private Long id;

    private LocalDateTime timestamp;

    private String text;

    private boolean important;

    public Message() {
    }

    public Message(LocalDateTime timestamp, String text, boolean important) {
        this.timestamp = timestamp;
        this.text = text;
        this.important = important;
    }

    public Message(Long id, LocalDateTime timestamp, String text, boolean important) {
        this.id = id;
        this.timestamp = timestamp;
        this.text = text;
        this.important = important;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", text='" + text + '\'' +
                ", important=" + important +
                '}';
    }
}
