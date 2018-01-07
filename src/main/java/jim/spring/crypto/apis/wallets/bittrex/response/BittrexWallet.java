
package jim.spring.crypto.apis.wallets.bittrex.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jim.spring.crypto.interfaces.ApiWallet;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Currency",
        "Balance",
        "Available",
        "Pending",
        "CryptoAddress"
})
public class BittrexWallet implements ApiWallet {

    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("Balance")
    private Double balance;
    @JsonProperty("Available")
    private Double available;
    @JsonProperty("Pending")
    private Double pending;
    @JsonProperty("CryptoAddress")
    private Object cryptoAddress;

    @JsonProperty("Currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("Currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("Balance")
    public Double getBalance() {
        return balance;
    }

    @JsonProperty("Balance")
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @JsonProperty("Available")
    public Double getAvailable() {
        return available;
    }

    @JsonProperty("Available")
    public void setAvailable(Double available) {
        this.available = available;
    }

    @JsonProperty("Pending")
    public Double getPending() {
        return pending;
    }

    @JsonProperty("Pending")
    public void setPending(Double pending) {
        this.pending = pending;
    }

    @JsonProperty("CryptoAddress")
    public Object getCryptoAddress() {
        return cryptoAddress;
    }

    @JsonProperty("CryptoAddress")
    public void setCryptoAddress(Object cryptoAddress) {
        this.cryptoAddress = cryptoAddress;
    }

}
