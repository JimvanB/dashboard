package jim.spring.crypto.apis.wallets.neo;

import jim.spring.crypto.apis.wallets.neo.response.NeoWallet;
import jim.spring.crypto.entity.Wallet;
import jim.spring.crypto.interfaces.WalletConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 31-12-17.
 */
public class NeoWalletConverter implements WalletConverter<NeoWallet> {

    @Override
    public List<Wallet> convert(List<NeoWallet> wallet) {
        List<Wallet> wallets = new ArrayList<>();
        wallet.forEach(neoWallet -> {
            Wallet newWallet = convert(neoWallet);
            if (newWallet != null) {
                wallets.add(newWallet);
            }
        });
        return wallets;
    }

    @Override
    public Wallet convert(NeoWallet apiWallet) {
        Wallet wallet = new Wallet();
        if (apiWallet.getName().equals("NEO") || apiWallet.getName().equals("GAS")) {
            wallet.setBalance(Double.parseDouble(apiWallet.getTotal()));
            wallet.setCurrency(apiWallet.getName());
            wallet.setAddress(apiWallet.getAssetId());
            wallet.setProvider("NeoCLI");
            return wallet;
        }
        return null;
    }
}
