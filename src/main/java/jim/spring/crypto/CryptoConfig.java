package jim.spring.crypto;

import jim.spring.crypto.builder.CryptoApiBuilder;
import jim.spring.crypto.interfaces.CryptoApiCaller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jim on 31-12-17.
 */
@Configuration
public class CryptoConfig {

    @Value("${BINANCE_API}")
    private String binanceApiKey;
    @Value("${BINANCE_SECRET}")
    private String binanceApiKeySecret;
    @Value("${BITTREX_API_KEY}")
    private String bittrexApiKey;
    @Value("${BITTEX_API_SECRET}")
    private String bittrexApiSecret;
    @Value("${API_KEY}")
    private String coinbaseApiKey;
    @Value("${API_SECRET}")
    private String coinbaseApiKeySecret;
    @Value("${NEO_ADDRESS}")
    private String neoAddress;

    @Bean
    CryptoApiCaller binance() throws MalformedURLException {
        return new CryptoApiBuilder()
                .withApiKey(binanceApiKey, binanceApiKeySecret)
                .withBaseApiURL(new URL("https://api.binance.com/api/v3/"))
                .withApiService("binance")
                .build();
    }

    @Bean
    CryptoApiCaller bittrex() throws MalformedURLException {
        return new CryptoApiBuilder()
                .withApiKey(bittrexApiKey, bittrexApiSecret)
                .withBaseApiURL(new URL("https://bittrex.com/api/v1.1/"))
                .withApiService("bittrex")
                .build();
    }

    @Bean
    CryptoApiCaller coinbase() throws MalformedURLException {
        return new CryptoApiBuilder()
                .withApiKey(coinbaseApiKey, coinbaseApiKeySecret)
                .withBaseApiURL(new URL("https://coinbase.com/api/v2/"))
                .withApiService("coinbase")
                .build();
    }

    @Bean
    CryptoApiCaller coinMarketCap() throws MalformedURLException {
        return new CryptoApiBuilder()
                .withBaseApiURL(new URL("https://api.coinmarketcap.com/v1/ticker/"))
                .withApiService("coinmarketcap")
                .build();
    }

    @Bean
    public CryptoApiCaller neo() throws MalformedURLException {
        return new CryptoApiBuilder()
                .withApiService("neo")
                .withBaseApiURL(new URL("https://otcgo.cn/api/v1/balances/"+neoAddress+"/")).build();
    }
}
