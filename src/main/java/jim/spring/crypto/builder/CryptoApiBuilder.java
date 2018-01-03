package jim.spring.crypto.builder;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import jim.spring.crypto.apis.binance.api.BinanceImpl;
import jim.spring.crypto.apis.bittrex.api.BittrexImpl;
import jim.spring.crypto.apis.coinbase.api.CoinbaseImpl;
import jim.spring.crypto.apis.coinmarketcap.CoinmarketCapImpl;
import jim.spring.crypto.apis.neo.NeoImpl;
import jim.spring.crypto.interfaces.CryptoApiCaller;

import java.net.URL;

public class CryptoApiBuilder {

    private String api_key;
    private String api_secret;
    private URL base_api_url;
    private String apiService;

    public CryptoApiBuilder() {
    }

    public CryptoApiCaller build() {

        switch(apiService){
            case "neo":
                return new NeoImpl(this);
            case "coinbase":
                return new CoinbaseImpl(this);
            case "bittrex":
                return new BittrexImpl(this);
            case "binance":
                return new BinanceImpl(this);
            case "coinmarketcap":
                return new CoinmarketCapImpl(this);
        }

        return new CoinbaseImpl(this);
    }

    public CryptoApiBuilder withApiService(String apiService) {
        this.apiService = apiService;
        return this;
    }

    public CryptoApiBuilder withApiKey(String api_key, String api_secret) {
        this.api_key = api_key;
        this.api_secret = api_secret;
        return this;
    }

    public CryptoApiBuilder withBaseApiURL(URL base_api_url) {
        this.base_api_url = base_api_url;
        return this;
    }

    public String getApi_key() {
        return api_key;
    }

    public String getApi_secret() {
        return api_secret;
    }

    public URL getBase_api_url() {
        return base_api_url;
    }

}
