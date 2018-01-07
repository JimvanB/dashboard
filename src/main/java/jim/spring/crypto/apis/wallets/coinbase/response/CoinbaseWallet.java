
package jim.spring.crypto.apis.wallets.coinbase.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jim.spring.crypto.interfaces.ApiWallet;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "primary",
    "type",
    "currency",
    "balance",
    "created_at",
    "updated_at",
    "resource",
    "resource_path",
    "native_balance"
})
public class CoinbaseWallet implements ApiWallet {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("primary")
    private Boolean primary;
    @JsonProperty("type")
    private String type;
    @JsonProperty("currency")
    private CoinbaseCurrency coinbaseCurrency;
    @JsonProperty("balance")
    private CoinbaseBalance coinbaseBalance;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("resource")
    private String resource;
    @JsonProperty("resource_path")
    private String resourcePath;
    @JsonProperty("native_balance")
    private CoinbaseNativeBalance coinbaseNativeBalance;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("primary")
    public Boolean getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("currency")
    public CoinbaseCurrency getCoinbaseCurrency() {
        return coinbaseCurrency;
    }

    @JsonProperty("currency")
    public void setCoinbaseCurrency(CoinbaseCurrency coinbaseCurrency) {
        this.coinbaseCurrency = coinbaseCurrency;
    }

    @JsonProperty("balance")
    public CoinbaseBalance getCoinbaseBalance() {
        return coinbaseBalance;
    }

    @JsonProperty("balance")
    public void setCoinbaseBalance(CoinbaseBalance coinbaseBalance) {
        this.coinbaseBalance = coinbaseBalance;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    @JsonProperty("resource_path")
    public String getResourcePath() {
        return resourcePath;
    }

    @JsonProperty("resource_path")
    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    @JsonProperty("native_balance")
    public CoinbaseNativeBalance getCoinbaseNativeBalance() {
        return coinbaseNativeBalance;
    }

    @JsonProperty("native_balance")
    public void setCoinbaseNativeBalance(CoinbaseNativeBalance coinbaseNativeBalance) {
        this.coinbaseNativeBalance = coinbaseNativeBalance;
    }

}
