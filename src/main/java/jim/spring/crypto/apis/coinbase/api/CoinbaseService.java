package jim.spring.crypto.apis.coinbase.api;


import jim.spring.crypto.interfaces.CryptoApiCaller;
import jim.spring.crypto.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by jim on 5-8-17.
 */

@Component
public class CoinbaseService {

    @Autowired
    CryptoApiCaller coinbase;

    public List<Wallet> getWallets() throws IOException {
        return coinbase.getWallets();
    }

}



