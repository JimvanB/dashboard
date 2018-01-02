package jim.spring.crypto.apis.binance.api;

import jim.spring.crypto.entity.Wallet;

/**
 * Created by jim on 24-11-17.
 */
public class BinanceWallet extends Wallet {

    @Override
    public String getProvider() {
        return "Binance";
    }

    @Override
    public void setBalance(Double balance) {
    //    this.balance = (Double) balance;
    }
}
