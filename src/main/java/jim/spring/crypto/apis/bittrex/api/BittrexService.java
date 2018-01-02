package jim.spring.crypto.apis.bittrex.api;

import jim.spring.crypto.interfaces.CryptoApiCaller;
import jim.spring.crypto.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by jim on 3-9-17.
 */
@Component
public class BittrexService {

    @Autowired
    CryptoApiCaller bittrex;

    public List<Wallet> getWallets() throws IOException {
        return bittrex.getWallets();
    }
}
