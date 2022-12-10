package platform.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class CodeSnippet {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;
    private String code;
    private LocalDateTime date;
    private LocalDateTime expiryDate;
    private long availableViews;

    public CodeSnippet() {
    }

    public CodeSnippet(String code, LocalDateTime date, long availableSeconds, long availableViews) {
        this.code = code;
        this.date = date;
        this.expiryDate = date.plusSeconds(availableSeconds);
        this.availableViews = availableViews;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCode() {
        return code;
    }

    public long getAvailableViews() {
        return availableViews;
    }

    public void setAvailableViews(long availableViews) {
        this.availableViews = availableViews;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
