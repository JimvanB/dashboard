package jim.spring.crypto;

import jim.spring.crypto.apis.neo.NeoService;
import jim.spring.crypto.builder.CryptoApiBuilder;
import jim.spring.crypto.entity.Wallet;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jim on 24-11-17.
 */
public class NeoWalletTest {

    NeoService neoService ;

    @Before
    public void setUp() throws Exception {
        neoService = new NeoService(new CryptoApiBuilder().withBaseApiURL(new URL("https://otcgo.cn/api/v1/balances/ASh6UPpqEUnwueDspXupgtd1a17wo93iy5/")).build());
    }

    @Test
    public void test() throws IOException {
        List<Wallet> wallets = neoService.getWallets();
        assertNotNull(wallets);
    }


}
