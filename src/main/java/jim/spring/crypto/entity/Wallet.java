package jim.spring.crypto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by jim on 3-9-17.
 */
@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String currency;
    private Double balance;
    private String address;
    private Double value;
    private Double priceChange24h;
    private Double priceChange1h;
    private Double priceChange7d;
    private Double totalValueBtc;
    private Double btcValue;
    private String provider;
    private LocalDateTime time;

    public Wallet() {
        time = LocalDateTime.now();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getValue() {
        return value;
    }

    public void setEuroValue(Double value) {
        this.value = value;
    }

    public Double getPriceChange24h() {
        return priceChange24h;
    }

    public void setPriceChange24h(Double priceChange24h) {
        this.priceChange24h = priceChange24h;
    }

    public Double getPriceChange1h() {
        return priceChange1h;
    }

    public void setPriceChange1h(Double priceChange1h) {
        this.priceChange1h = priceChange1h;
    }

    public Double getPriceChange7d() {
        return priceChange7d;
    }

    public void setPriceChange7d(Double priceChange7d) {
        this.priceChange7d = priceChange7d;
    }

    public Double getBtcValue() {
        return btcValue;
    }

    public void setBtcValue(Double btcValue) {
        this.btcValue = btcValue;
    }

    public String getProvider() {
        return provider;
    }


    public void setProvider(String provider) {
        this.provider = provider;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Double getTotalValueBtc() {
        return totalValueBtc;
    }

    public void setTotalValueBtc(Double totalValueBtc) {
        this.totalValueBtc = totalValueBtc;
    }

}
