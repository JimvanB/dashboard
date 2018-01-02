package jim.spring.crypto.apis.bittrex.api;

import jim.spring.crypto.apis.bittrex.response.BittrexWallet;
import jim.spring.crypto.apis.coinbase.response.CoinbaseWallet;
import jim.spring.crypto.entity.Wallet;
import jim.spring.crypto.interfaces.WalletConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 31-12-17.
 */
public class BittrexWalletConverter implements WalletConverter<BittrexWallet> {

    @Override
    public List<Wallet> convert(List<BittrexWallet> wallet) {
        List<Wallet> wallets = new ArrayList<>();
        wallet.forEach(coinbaseWallet -> wallets.add(convert(coinbaseWallet)));
        return wallets;
    }

    @Override
    public Wallet convert(BittrexWallet bitWallet) {
        Wallet wallet = new Wallet();
        wallet.setCurrency(bitWallet.getCurrency());
        wallet.setBalance(bitWallet.getBalance());
        if(bitWallet.getCryptoAddress() != null) {
            wallet.setAddress(bitWallet.getCryptoAddress().toString());
        }
        wallet.setProvider("Bittrex");
        return wallet;
    }
}
