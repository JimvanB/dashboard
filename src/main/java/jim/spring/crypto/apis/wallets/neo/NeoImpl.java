package jim.spring.crypto.apis.wallets.neo;

import jim.spring.crypto.apis.wallets.neo.response.NeoJsonResponse;
import jim.spring.crypto.apis.wallets.neo.response.NeoWallet;
import jim.spring.crypto.builder.CryptoApiBuilder;
import jim.spring.crypto.interfaces.CryptoApiCaller;
import jim.spring.crypto.entity.Wallet;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by jim on 31-12-17.
 */
public class NeoImpl implements CryptoApiCaller {

    private URL baseUrl;

    public NeoImpl(CryptoApiBuilder builder) {
        this.baseUrl = builder.getBase_api_url();
    }

    @Override
    public List<Wallet> getWallets() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        List<NeoWallet> neoWallets = restTemplate.getForEntity(baseUrl.toString(), NeoJsonResponse.class).getBody().getNeoWallets();
        return new NeoWalletConverter().convert(neoWallets);
    }

    @Override
    public void calculateWalletValue(Wallet wallet) {

    }
}
