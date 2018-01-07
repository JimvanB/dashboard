package jim.spring.crypto.apis.wallets.binance;

import jim.spring.crypto.interfaces.CryptoApiCaller;
import jim.spring.crypto.entity.Wallet;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by jim on 24-11-17.
 */
@Component
public class BinanceService {

    private CryptoApiCaller binance;

    public BinanceService(CryptoApiCaller binance) {
        this.binance = binance;
    }

    public List<Wallet> getWallets() throws IOException {
        return binance.getWallets();
    }


}
