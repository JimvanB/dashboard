package jim.spring.crypto.apis.wallets.coinbase.api;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import jim.spring.crypto.apis.wallets.coinbase.response.CoinbaseJsonResponse;
import jim.spring.crypto.apis.wallets.coinbase.response.CoinbaseWallet;
import jim.spring.crypto.builder.CryptoApiBuilder;
import jim.spring.crypto.interfaces.CryptoApiCaller;
import jim.spring.crypto.entity.Wallet;
import org.apache.commons.codec.binary.Hex;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class CoinbaseImpl implements CryptoApiCaller {

    private URL _baseApiUrl;
    private String _apiKey;
    private String _apiSecret;

    public CoinbaseImpl(CryptoApiBuilder builder) {
        this._apiKey = builder.getApi_key();
        this._apiSecret = builder.getApi_secret();
        this._baseApiUrl = builder.getBase_api_url();
        try {
            if (this._baseApiUrl == null) {
                this._baseApiUrl = new URL("https://coinbase.com/api/v2/");
            }
        } catch (Exception ex) {
        }
    }

    public List<Wallet> getWallets() throws IOException {
        URL url = new URL(this._baseApiUrl, "accounts");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = doAuth(url, "GET", null);

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        List<CoinbaseWallet> balances = restTemplate.exchange(url.toString(), HttpMethod.GET, entity, CoinbaseJsonResponse.class).getBody().getData();
        return new CoinbaseWalletConverter().convert(balances);
    }

    @Override
    public void calculateWalletValue(Wallet wallet) {

    }

    private HttpHeaders doAuth(URL url, String method, String body) throws IOException {

        String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);
        String path = url.getFile();
        body = (body == null) ? "" : body;
        String message = timestamp + method + path + body;
        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(_apiSecret.getBytes(), "HmacSHA256"));
        } catch (Throwable t) {
            throw new IOException(t);
        }

        String signature = new String(Hex.encodeHex(mac.doFinal(message.getBytes())));
        System.out.println(signature);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("CB-ACCESS-KEY", _apiKey);
        headers.set("CB-ACCESS_SIGN", signature);
        headers.set("CB-ACCESS-TIMESTAMP", timestamp);
        return headers;
    }
}