package jim.spring.crypto.apis.wallets.neo;

import jim.spring.crypto.interfaces.CryptoApiCaller;
import jim.spring.crypto.entity.Wallet;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by jim on 24-11-17.
 */
@Component
public class NeoService {

    private CryptoApiCaller neo;

    public NeoService(CryptoApiCaller neo) {
        this.neo = neo;
    }

    public List<Wallet> getWallets() throws IOException {
        return neo.getWallets();
    }


}
