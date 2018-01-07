package jim.spring.crypto.apis.wallets.coinbase.api;

import jim.spring.crypto.apis.wallets.coinbase.response.CoinbaseWallet;
import jim.spring.crypto.entity.Wallet;
import jim.spring.crypto.interfaces.WalletConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 31-12-17.
 */
public class CoinbaseWalletConverter implements WalletConverter<CoinbaseWallet> {

    @Override
    public List<Wallet> convert(List<CoinbaseWallet> wallet) {
        List<Wallet> wallets = new ArrayList<>();
        wallet.forEach(coinbaseWallet -> wallets.add(convert(coinbaseWallet)));
        return wallets;
    }

    @Override
    public Wallet convert(CoinbaseWallet cbWallet) {
        Wallet wallet = new Wallet();
        wallet.setCurrency(cbWallet.getCoinbaseBalance().getCurrency());
        wallet.setBalance(Double.parseDouble(cbWallet.getCoinbaseBalance().getAmount()));
        wallet.setAddress(cbWallet.getId());
        wallet.setProvider("Coinbase");
        return wallet;
    }
}
