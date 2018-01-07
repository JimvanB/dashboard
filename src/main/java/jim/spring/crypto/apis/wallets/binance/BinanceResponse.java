
package jim.spring.crypto.apis.wallets.binance;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "makerCommission",
    "takerCommission",
    "buyerCommission",
    "sellerCommission",
    "canTrade",
    "canWithdraw",
    "canDeposit",
    "balances"
})
public class BinanceResponse {

    @JsonProperty("makerCommission")
    private Integer makerCommission;
    @JsonProperty("takerCommission")
    private Integer takerCommission;
    @JsonProperty("buyerCommission")
    private Integer buyerCommission;
    @JsonProperty("sellerCommission")
    private Integer sellerCommission;
    @JsonProperty("canTrade")
    private Boolean canTrade;
    @JsonProperty("canWithdraw")
    private Boolean canWithdraw;
    @JsonProperty("canDeposit")
    private Boolean canDeposit;
    @JsonProperty("balances")
    private List<BalanceWallet> balanceWallets = null;

    @JsonProperty("makerCommission")
    public Integer getMakerCommission() {
        return makerCommission;
    }

    @JsonProperty("makerCommission")
    public void setMakerCommission(Integer makerCommission) {
        this.makerCommission = makerCommission;
    }

    @JsonProperty("takerCommission")
    public Integer getTakerCommission() {
        return takerCommission;
    }

    @JsonProperty("takerCommission")
    public void setTakerCommission(Integer takerCommission) {
        this.takerCommission = takerCommission;
    }

    @JsonProperty("buyerCommission")
    public Integer getBuyerCommission() {
        return buyerCommission;
    }

    @JsonProperty("buyerCommission")
    public void setBuyerCommission(Integer buyerCommission) {
        this.buyerCommission = buyerCommission;
    }

    @JsonProperty("sellerCommission")
    public Integer getSellerCommission() {
        return sellerCommission;
    }

    @JsonProperty("sellerCommission")
    public void setSellerCommission(Integer sellerCommission) {
        this.sellerCommission = sellerCommission;
    }

    @JsonProperty("canTrade")
    public Boolean getCanTrade() {
        return canTrade;
    }

    @JsonProperty("canTrade")
    public void setCanTrade(Boolean canTrade) {
        this.canTrade = canTrade;
    }

    @JsonProperty("canWithdraw")
    public Boolean getCanWithdraw() {
        return canWithdraw;
    }

    @JsonProperty("canWithdraw")
    public void setCanWithdraw(Boolean canWithdraw) {
        this.canWithdraw = canWithdraw;
    }

    @JsonProperty("canDeposit")
    public Boolean getCanDeposit() {
        return canDeposit;
    }

    @JsonProperty("canDeposit")
    public void setCanDeposit(Boolean canDeposit) {
        this.canDeposit = canDeposit;
    }

    @JsonProperty("balances")
    public List<BalanceWallet> getBalanceWallets() {
        return balanceWallets;
    }

    @JsonProperty("balances")
    public void setBalanceWallets(List<BalanceWallet> balanceWallets) {
        this.balanceWallets = balanceWallets;
    }

}
