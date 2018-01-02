package jim.spring.crypto.apis.binance.api;

import jim.spring.crypto.builder.CryptoApiBuilder;
import jim.spring.crypto.interfaces.CryptoApiCaller;
import jim.spring.crypto.entity.Wallet;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 31-12-17.
 */
public class BinanceImpl implements CryptoApiCaller {

    private final URL baseUrl;

    public BinanceImpl(CryptoApiBuilder cryptoApiBuilder) {
        this.baseUrl = cryptoApiBuilder.getBase_api_url();
    }

    @Override
    public List<Wallet> getWallets() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        BinanceResponse balances = restTemplate.getForEntity(baseUrl.toString(), BinanceResponse.class).getBody();
        List<Wallet> wallets = new ArrayList<>();
        for (Balance balance : balances.getBalances()) {
            BinanceWallet binanceWallet = new BinanceWallet();
            binanceWallet.setBalance(Double.parseDouble(balance.getFree()) + Double.parseDouble(balance.getLocked()));
            binanceWallet.setCurrency(balance.getAsset());
            wallets.add(binanceWallet);
        }

        return wallets;
    }
}
