package jim.spring.crypto.apis.wallets.binance;

import jim.spring.crypto.entity.Wallet;
import jim.spring.crypto.interfaces.WalletConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 31-12-17.
 */
public class BinanceWalletConverter implements WalletConverter<BalanceWallet> {

    @Override
    public List<Wallet> convert(List<BalanceWallet> wallet) {
        List<Wallet> wallets = new ArrayList<>();
        wallet.forEach(coinbaseWallet -> wallets.add(convert(coinbaseWallet)));
        return wallets;
    }

    @Override
    public Wallet convert(BalanceWallet bitWallet) {
        Wallet wallet = new Wallet();
        wallet.setCurrency(bitWallet.getAsset());
        wallet.setBalance(Double.parseDouble(bitWallet.getFree()));
        wallet.setProvider("Binance");
        return wallet;
    }
}
