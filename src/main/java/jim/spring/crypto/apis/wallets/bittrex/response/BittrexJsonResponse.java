
package jim.spring.crypto.apis.wallets.bittrex.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "success",
    "message",
    "result"
})
public class BittrexJsonResponse {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message")
    private String message;
    @JsonProperty("result")
    private List<BittrexWallet> bittrexWallet = null;

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("result")
    public List<BittrexWallet> getBittrexWallet() {
        return bittrexWallet;
    }

    @JsonProperty("result")
    public void setBittrexWallet(List<BittrexWallet> bittrexWallet) {
        this.bittrexWallet = bittrexWallet;
    }

}
