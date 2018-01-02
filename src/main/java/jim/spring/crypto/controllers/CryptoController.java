package jim.spring.crypto.controllers;

import com.coinbase.api.exception.CoinbaseException;
import jim.spring.crypto.apis.bittrex.api.BittrexService;
import jim.spring.crypto.apis.coinbase.api.CoinbaseService;
import jim.spring.crypto.apis.coinmarketcap.CoinmarketCapService;
import jim.spring.crypto.apis.neo.NeoService;
import jim.spring.crypto.entity.Wallet;
import jim.spring.crypto.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 8-8-17.
 */
@RestController
public class CryptoController {

    private CoinmarketCapService coinmarketCapService;
    private CoinbaseService coinbaseService;
    private BittrexService bittrexService;
    private NeoService neoService;
    private WalletService walletService;

    @Autowired
    public CryptoController(CoinmarketCapService coinmarketCapService, CoinbaseService coinbaseService, BittrexService bittrexService, NeoService neoService, WalletService walletService) {
        this.coinmarketCapService = coinmarketCapService;
        this.coinbaseService = coinbaseService;
        this.bittrexService = bittrexService;
        this.neoService = neoService;
        this.walletService = walletService;
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @ResponseBody
    @RequestMapping(value = "/wallets", method = RequestMethod.GET, produces = "application/json")
    public List<Wallet> wallets() throws IOException, CoinbaseException {
        List<Wallet> wallets = new ArrayList<>();
        wallets.addAll(coinbaseService.getWallets());
        wallets.addAll(bittrexService.getWallets());
        wallets.addAll(neoService.getWallets());
        return wallets;
    }


    @CrossOrigin(origins = "http://localhost:8100")
    @ResponseBody
    @RequestMapping(value = "/wallets/{currency}", method = RequestMethod.GET, produces = "application/json")
    public List<Wallet> walletsWithCurrency(@PathVariable String currency) throws IOException {

        return walletService.getWallets(currency);
    }


    @GetMapping(value = "/total/{currency}", produces = "application/json")
    public Double getTotal(@PathVariable("currency") String currency) throws IOException {
        List<Wallet> wallets = walletService.getWallets(currency);
        return walletService.getTotalWallets(wallets);
    }


}
