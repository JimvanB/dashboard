package jim.spring.crypto.apis.wallets.bittrex.api;

import jim.spring.crypto.apis.wallets.bittrex.response.BittrexJsonResponse;
import jim.spring.crypto.apis.wallets.bittrex.response.BittrexWallet;
import jim.spring.crypto.entity.Wallet;
import jim.spring.crypto.interfaces.*;
import jim.spring.crypto.builder.CryptoApiBuilder;
import org.apache.commons.codec.binary.Hex;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by jim on 3-9-17.
 */
public class BittrexImpl implements CryptoApiCaller {

    private URL _baseApiUrl;
    private String _apiKey;
    private String _apiSecret;

    public BittrexImpl(CryptoApiBuilder builder) {
        this._baseApiUrl = builder.getBase_api_url();
        this._apiKey = builder.getApi_key();
        this._apiSecret = builder.getApi_secret();

    }

    @Override
    public List<Wallet> getWallets() throws IOException {
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);
        URL url = new URL(this._baseApiUrl, "account/getbalances?apikey=" + _apiKey + "&nonce=" + timestamp);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = doAuth(url, timestamp);
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        List<BittrexWallet> bittrexWallets = restTemplate.exchange(url.toString(), HttpMethod.GET, entity, BittrexJsonResponse.class).getBody().getBittrexWallet();
        return new BittrexWalletConverter().convert(bittrexWallets);
    }

    @Override
    public void calculateWalletValue(Wallet wallet) {

    }

    private HttpHeaders doAuth(URL url, String timestamp) throws IOException {

        String path = url.toString();
        String message = path;
        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA512");
            mac.init(new SecretKeySpec(_apiSecret.getBytes(), "HmacSHA512"));
        } catch (Throwable t) {
            throw new IOException(t);
        }

        String signature = new String(Hex.encodeHex(mac.doFinal(message.getBytes())));
        System.out.println(signature);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apisign", signature);
        headers.set("nonce", timestamp);
        return headers;
    }

}
