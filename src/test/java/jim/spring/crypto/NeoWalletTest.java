package jim.spring.crypto;

import jim.spring.crypto.apis.neo.NeoService;
import jim.spring.crypto.builder.CryptoApiBuilder;
import jim.spring.crypto.entity.Wallet;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jim on 24-11-17.
 */
@SpringBootTest
@TestPropertySource(value = "classpath:test-properties.properties")
public class NeoWalletTest {

    NeoService neoService ;
    @Value("NEO_ADDRESS")
    String neoAddress;

    @Before
    public void setUp() throws Exception {
        neoService = new NeoService(new CryptoApiBuilder().withBaseApiURL(new URL("https://otcgo.cn/api/v1/balances/"+neoAddress+"/")).build());
    }

    @Test
    public void test() throws IOException {
        List<Wallet> wallets = neoService.getWallets();
        assertNotNull(wallets);
    }


}
