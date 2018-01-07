
package jim.spring.crypto.apis.wallets.neo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jim.spring.crypto.interfaces.ApiWallet;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "assetType",
    "name",
    "assetId",
    "marketSign",
    "divisible",
    "frozen",
    "valid",
    "total"
})
public class NeoWallet implements ApiWallet {

    @JsonProperty("assetType")
    private String assetType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("assetId")
    private String assetId;
    @JsonProperty("marketSign")
    private String marketSign;
    @JsonProperty("divisible")
    private Boolean divisible;
    @JsonProperty("frozen")
    private String frozen;
    @JsonProperty("valid")
    private String valid;
    @JsonProperty("total")
    private String total;

    @JsonProperty("assetType")
    public String getAssetType() {
        return assetType;
    }

    @JsonProperty("assetType")
    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("assetId")
    public String getAssetId() {
        return assetId;
    }

    @JsonProperty("assetId")
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    @JsonProperty("marketSign")
    public String getMarketSign() {
        return marketSign;
    }

    @JsonProperty("marketSign")
    public void setMarketSign(String marketSign) {
        this.marketSign = marketSign;
    }

    @JsonProperty("divisible")
    public Boolean getDivisible() {
        return divisible;
    }

    @JsonProperty("divisible")
    public void setDivisible(Boolean divisible) {
        this.divisible = divisible;
    }

    @JsonProperty("frozen")
    public String getFrozen() {
        return frozen;
    }

    @JsonProperty("frozen")
    public void setFrozen(String frozen) {
        this.frozen = frozen;
    }

    @JsonProperty("valid")
    public String getValid() {
        return valid;
    }

    @JsonProperty("valid")
    public void setValid(String valid) {
        this.valid = valid;
    }

    @JsonProperty("total")
    public String getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(String total) {
        this.total = total;
    }

}
