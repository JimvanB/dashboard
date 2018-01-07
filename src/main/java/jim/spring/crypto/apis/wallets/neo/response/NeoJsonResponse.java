
package jim.spring.crypto.apis.wallets.neo.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "balances",
    "address"
})
public class NeoJsonResponse {

    @JsonProperty("balances")
    private List<NeoWallet> neoWallets = null;
    @JsonProperty("address")
    private String address;

    @JsonProperty("balances")
    public List<NeoWallet> getNeoWallets() {
        return neoWallets;
    }

    @JsonProperty("balances")
    public void setNeoWallets(List<NeoWallet> neoWallets) {
        this.neoWallets = neoWallets;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

}
