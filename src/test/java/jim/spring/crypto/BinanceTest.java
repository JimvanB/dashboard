package jim.spring.crypto;

import com.coinbase.api.exception.CoinbaseException;
import jim.spring.crypto.apis.binance.api.BinanceService;
import jim.spring.crypto.builder.CryptoApiBuilder;
import jim.spring.crypto.entity.Wallet;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class BinanceTest {


    private BinanceService binanceService;


    @Before
    public void setUp() throws Exception {
        binanceService=  new BinanceService(new CryptoApiBuilder()
                .withBaseApiURL(new URL("https://api.binance.com/api/v3/"))
                .withApiService("binance")
                .build());
    }

    @Test
    public void getWallets() throws IOException, CoinbaseException {
        List<Wallet> wallet = binanceService.getWallets();
        System.out.println(wallet);
    }

}
