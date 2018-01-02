package jim.spring.crypto.apis.coinmarketcap;

import jim.spring.crypto.interfaces.CryptoApiCaller;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jim on 31-12-17.
 */
@Component
public class CoinmarketCapService {

    private CryptoApiCaller coinMarketCap;

    public CoinmarketCapService(CryptoApiCaller coinMarketCap) {
        this.coinMarketCap = coinMarketCap;
    }

    public List<Currency> getAllCurrencies(String currency) {
        return ((CoinmarketCapImpl) coinMarketCap).getAllCurrencies(currency);
    }


}
