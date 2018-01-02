

package jim.spring.crypto.apis.binance.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "symbol",
        "rank",
        "price_usd",
        "price_btc",
        "24h_volume_usd",
        "market_cap_usd",
        "available_supply",
        "total_supply",
        "percent_change_1h",
        "percent_change_24h",
        "percent_change_7d",
        "last_updated",
        "price_eur",
        "24h_volume_eur",
        "market_cap_eur"
})
public class Currency {


    private String id;
    private String name;
    private String symbol;
    private String rank;
    private String priceUsd;
    private String priceBtc;
    private String _24hVolumeUsd;
    private String marketCapUsd;
    private String availableSupply;
    private String totalSupply;
    private String percentChange1h;
    private String percentChange24h;
    private String percentChange7d;
    private String lastUpdated;
    private String price_eur;
    private String h_volume_eur;
    private String market_cap_eur;

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

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("rank")
    public String getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(String rank) {
        this.rank = rank;
    }

    @JsonProperty("price_usd")
    public String getPriceUsd() {
        return priceUsd;
    }

    @JsonProperty("price_usd")
    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    @JsonProperty("price_btc")
    public String getPriceBtc() {
        return priceBtc;
    }

    @JsonProperty("price_btc")
    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    @JsonProperty("24h_volume_usd")
    public String get24hVolumeUsd() {
        return _24hVolumeUsd;
    }

    @JsonProperty("24h_volume_usd")
    public void set24hVolumeUsd(String _24hVolumeUsd) {
        this._24hVolumeUsd = _24hVolumeUsd;
    }

    @JsonProperty("market_cap_usd")
    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    @JsonProperty("market_cap_usd")
    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    @JsonProperty("available_supply")
    public String getAvailableSupply() {
        return availableSupply;
    }

    @JsonProperty("available_supply")
    public void setAvailableSupply(String availableSupply) {
        this.availableSupply = availableSupply;
    }

    @JsonProperty("total_supply")
    public String getTotalSupply() {
        return totalSupply;
    }

    @JsonProperty("total_supply")
    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    @JsonProperty("percent_change_1h")
    public String getPercentChange1h() {
        return percentChange1h;
    }

    @JsonProperty("percent_change_1h")
    public void setPercentChange1h(String percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    @JsonProperty("percent_change_24h")
    public String getPercentChange24h() {
        return percentChange24h;
    }

    @JsonProperty("percent_change_24h")
    public void setPercentChange24h(String percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    @JsonProperty("percent_change_7d")
    public String getPercentChange7d() {
        return percentChange7d;
    }

    @JsonProperty("percent_change_7d")
    public void setPercentChange7d(String percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    @JsonProperty("last_updated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("last_updated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("price_eur")
    public String getPrice_eur() {
        return price_eur;
    }

    @JsonProperty("price_eur")
    public void setPrice_eur(String price_eur) {
        this.price_eur = price_eur;
    }

    @JsonProperty("24h_volume_eur")
    public String getH_volume_eur() {
        return h_volume_eur;
    }

    @JsonProperty("24h_volume_eur")
    public void setH_volume_eur(String h_volume_eur) {
        this.h_volume_eur = h_volume_eur;
    }

    @JsonProperty("last_updated")
    public String getMarket_cap_eur() {
        return market_cap_eur;
    }

    @JsonProperty("market_cap_eur")
    public void setMarket_cap_eur(String market_cap_eur) {
        this.market_cap_eur = market_cap_eur;
    }


}