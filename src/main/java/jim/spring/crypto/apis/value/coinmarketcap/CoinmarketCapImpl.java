package jim.spring.crypto.apis.value.coinmarketcap;

import jim.spring.crypto.builder.CryptoApiBuilder;
import jim.spring.crypto.interfaces.CryptoApiCaller;
import jim.spring.crypto.entity.Wallet;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jim on 4-9-17.
 */
public class CoinmarketCapImpl implements CryptoApiCaller{

    private final URL baseUrl;

    public CoinmarketCapImpl(CryptoApiBuilder builder) {
        this.baseUrl = builder.getBase_api_url();
    }

    public List<Currency> getAllCurrencies(String currency) {
        RestTemplate restTemplate = new RestTemplate();
        Currency[] balances = restTemplate.getForEntity(baseUrl.toString()+"?convert="+ currency + "&limit=200", Currency[].class).getBody();
        return Arrays.asList(balances);
    }

    @Override
    public List<Wallet> getWallets() throws IOException {
        return null;
    }

    @Override
    public void calculateWalletValue(Wallet wallet) {

    }
}
