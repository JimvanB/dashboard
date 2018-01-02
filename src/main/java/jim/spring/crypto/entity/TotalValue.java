package jim.spring.crypto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by jim on 1-12-17.
 */
@Entity
public class TotalValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Double total;
    LocalDateTime time;

    public TotalValue() {
    }

    public TotalValue(Double total) {
        this.total = total;
    }

    public TotalValue(Double total, LocalDateTime time) {
        this.total = total;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
