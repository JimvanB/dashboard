
package jim.spring.crypto.apis.coinbase.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pagination",
    "data",
    "warnings"
})
public class CoinbaseJsonResponse {

    @JsonProperty("pagination")
    private CoinbasePagination coinbasePagination;
    @JsonProperty("data")
    private List<CoinbaseWallet> data = null;
    @JsonProperty("warnings")
    private List<CoinbaseWarning> coinbaseWarnings = null;

    @JsonProperty("pagination")
    public CoinbasePagination getCoinbasePagination() {
        return coinbasePagination;
    }

    @JsonProperty("pagination")
    public void setCoinbasePagination(CoinbasePagination coinbasePagination) {
        this.coinbasePagination = coinbasePagination;
    }

    @JsonProperty("data")
    public List<CoinbaseWallet> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<CoinbaseWallet> data) {
        this.data = data;
    }

    @JsonProperty("warnings")
    public List<CoinbaseWarning> getCoinbaseWarnings() {
        return coinbaseWarnings;
    }

    @JsonProperty("warnings")
    public void setCoinbaseWarnings(List<CoinbaseWarning> coinbaseWarnings) {
        this.coinbaseWarnings = coinbaseWarnings;
    }

}
