package jim.spring.crypto;

import jim.spring.crypto.builder.CryptoApiBuilder;
import jim.spring.crypto.interfaces.CryptoApiCaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jim on 31-12-17.
 */
@Configuration
public class CryptoConfig {

    @Bean
    CryptoApiCaller binance() throws MalformedURLException {

        return new CryptoApiBuilder()
                .withApiKey(System.getenv("BIN_API_KEY"), System.getenv("BIN_API_SECRET"))
                .withBaseApiURL(new URL("https://api.binance.com/api/v1/"))
                .withApiService("binance")
                .build();
    }

    @Bean
    CryptoApiCaller bittrex() throws MalformedURLException {

        return new CryptoApiBuilder()
                .withApiKey(System.getenv("BITTREX_API_KEY"), System.getenv("BITTEX_API_SECRET"))
                .withBaseApiURL(new URL("https://bittrex.com/api/v1.1/"))
                .withApiService("bittrex")
                .build();
    }

    @Bean
    CryptoApiCaller coinbase() throws MalformedURLException {
        return new CryptoApiBuilder()
                .withApiKey(System.getenv("API_KEY"), System.getenv("API_SECRET"))
                .withBaseApiURL(new URL("https://coinbase.com/api/v2/"))
                .withAccountId(System.getenv("API_ACCOUNT"))
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
                .withBaseApiURL(new URL("https://otcgo.cn/api/v1/balances/"+System.getenv("NEO_ADDRESS")+"/")).build();
    }
}
