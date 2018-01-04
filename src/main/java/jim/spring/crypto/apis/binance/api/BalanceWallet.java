
package jim.spring.crypto.apis.binance.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jim.spring.crypto.interfaces.ApiWallet;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "asset",
    "free",
    "locked"
})
public class BalanceWallet implements ApiWallet {

    @JsonProperty("asset")
    private String asset;
    @JsonProperty("free")
    private String free;
    @JsonProperty("locked")
    private String locked;

    @JsonProperty("asset")
    public String getAsset() {
        return asset;
    }

    @JsonProperty("asset")
    public void setAsset(String asset) {
        this.asset = asset;
    }

    @JsonProperty("free")
    public String getFree() {
        return free;
    }

    @JsonProperty("free")
    public void setFree(String free) {
        this.free = free;
    }

    @JsonProperty("locked")
    public String getLocked() {
        return locked;
    }

    @JsonProperty("locked")
    public void setLocked(String locked) {
        this.locked = locked;
    }

}
