package jim.spring.crypto;

import com.coinbase.api.exception.CoinbaseException;
import jim.spring.crypto.entity.Wallet;
import jim.spring.crypto.apis.bittrex.api.BittrexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BittrexTests {

	@Autowired
	BittrexService bittrexService;


	@Test
	public void getWallets() throws IOException, CoinbaseException {
		List<Wallet> wallet =  bittrexService.getWallets();
		System.out.println(wallet);
	}

}
