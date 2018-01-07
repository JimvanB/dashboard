package jim.spring.crypto.apis.wallets.binance;

import jim.spring.crypto.builder.CryptoApiBuilder;
import jim.spring.crypto.interfaces.CryptoApiCaller;
import jim.spring.crypto.entity.Wallet;
import jim.spring.crypto.services.ValueCalculator;
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

/**
 * Created by jim on 31-12-17.
 */
public class BinanceImpl implements CryptoApiCaller {

    private String apiKey;
    private String apiSecret;
    private final URL baseUrl;
    private final ValueCalculator valueCalculator;

    public BinanceImpl(CryptoApiBuilder cryptoApiBuilder) {
        this.apiKey = cryptoApiBuilder.getApi_key();
        this.apiSecret = cryptoApiBuilder.getApi_secret();
        this.baseUrl = cryptoApiBuilder.getBase_api_url();
        this.valueCalculator = cryptoApiBuilder.getValueCalculator();
    }

    public List<Wallet> getWallets() throws IOException {
        URL url = new URL(this.baseUrl, "account");
        RestTemplate restTemplate = new RestTemplate();
        String params = "timestamp="+System.currentTimeMillis();
        HttpHeaders headers = doAuth(params);

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        String finalUrl = url.toString()+"?"+params+"&signature="+getSignature(params);
        List<BalanceWallet> balanceWallets = restTemplate.exchange(finalUrl, HttpMethod.GET, entity, BinanceResponse.class).getBody().getBalanceWallets();
        return new BinanceWalletConverter().convert(balanceWallets);
    }

    @Override
    public void calculateWalletValue(Wallet wallet) {
    }

    private HttpHeaders doAuth(String params) throws IOException {

        String signature = getSignature(params);
        System.out.println(signature);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("X-MBX-APIKEY", apiKey);
        return headers;
    }

    private String getSignature(String params) throws IOException {
        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(apiSecret.getBytes(), "HmacSHA256"));
        } catch (Throwable t) {
            throw new IOException(t);
        }

        return new String(Hex.encodeHex(mac.doFinal(params.getBytes())));
    }

}
