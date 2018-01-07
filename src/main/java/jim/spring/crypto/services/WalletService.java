package jim.spring.crypto.services;

import jim.spring.crypto.apis.wallets.binance.BinanceService;
import jim.spring.crypto.apis.wallets.bittrex.api.BittrexService;
import jim.spring.crypto.apis.wallets.coinbase.api.CoinbaseService;
import jim.spring.crypto.apis.value.coinmarketcap.CoinmarketCapService;
import jim.spring.crypto.apis.value.coinmarketcap.Currency;
import jim.spring.crypto.apis.wallets.neo.NeoService;
import jim.spring.crypto.entity.Wallet;
import jim.spring.crypto.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jim on 15-12-17.
 */
@Service
public class WalletService {


    private CoinmarketCapService coinmarketCapService;
    private CoinbaseService coinbaseService;
    private NeoService neoService;
    private BittrexService bittrexService;
    private BinanceService binanceService;
    private WalletRepository walletRepository;

    public WalletService(CoinmarketCapService coinmarketCapService, CoinbaseService coinbaseService, NeoService neoService, BittrexService bittrexService, BinanceService binanceService, WalletRepository walletRepository) {
        this.coinmarketCapService = coinmarketCapService;
        this.coinbaseService = coinbaseService;
        this.neoService = neoService;
        this.bittrexService = bittrexService;
        this.binanceService = binanceService;
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getWallets(@PathVariable String currency) throws IOException {
        String cur = (currency != null) ? currency : "EUR";
        List<Currency> currencies = coinmarketCapService.getAllCurrencies(cur);

        List<Wallet> wallets = new ArrayList<>();
        wallets.addAll(coinbaseService.getWallets());
        wallets.addAll(bittrexService.getWallets());
        wallets.addAll(neoService.getWallets());
        wallets.addAll(binanceService.getWallets());
        Iterator<Wallet> walletIterator = wallets.iterator();
        while (walletIterator.hasNext()) {
            Wallet wallet = walletIterator.next();
            if (wallet.getBalance() == 0 || wallet.getBalance() == null) {
                walletIterator.remove();
                continue;
            }
            if (wallet.getCurrency().equals("EUR")) {
                wallet.setEuroValue(wallet.getBalance());
                wallet.setBtcValue(round(getBtcValue(currencies, wallet.getBalance()), 6));
                wallet.setTotalValueBtc(round(wallet.getBalance() * getBtcValue(currencies, wallet.getBalance()), 6));
                wallet.setPriceChange1h(0D);
                wallet.setPriceChange24h(0D);
                wallet.setPriceChange7d(0D);
            }
            for (Currency curren : currencies) {
                if (wallet.getCurrency().equals(curren.getSymbol())) {
                    wallet.setBalance(round(wallet.getBalance(), 6));
                    wallet.setBtcValue(round(Double.valueOf(curren.getPriceBtc()), 6));
                    wallet.setTotalValueBtc(round(wallet.getBalance() * Double.valueOf(curren.getPriceBtc()), 6));
                    wallet.setEuroValue(round(wallet.getBalance() * Double.valueOf(curren.getPrice_eur()), 2));
                    wallet.setPriceChange1h(Double.valueOf(curren.getPercentChange1h()));
                    wallet.setPriceChange24h(Double.valueOf(curren.getPercentChange24h()));
                    wallet.setPriceChange7d(Double.valueOf(curren.getPercentChange7d()));
                    break;
                }
                if (wallet.getCurrency().equals("IOTA") && curren.getSymbol().equals("MIOTA")) {
                    wallet.setBalance(round(wallet.getBalance(), 6));
                    wallet.setBtcValue(round(Double.valueOf(curren.getPriceBtc()), 6));
                    wallet.setTotalValueBtc(round(wallet.getBalance() * Double.valueOf(curren.getPriceBtc()), 6));
                    wallet.setEuroValue(round(wallet.getBalance() * Double.valueOf(curren.getPrice_eur()), 2));
                    wallet.setPriceChange1h(Double.valueOf(curren.getPercentChange1h()));
                    wallet.setPriceChange24h(Double.valueOf(curren.getPercentChange24h()));
                    wallet.setPriceChange7d(Double.valueOf(curren.getPercentChange7d()));
                    break;
                }
            }
            if (wallet.getValue() == null) {
                wallet.setEuroValue(0.0);
                wallet.setBtcValue(0.0);
            }
        }

        Wallet smallCoinsWallet = new Wallet();
        smallCoinsWallet.setCurrency("Others");
        smallCoinsWallet.setEuroValue(0.0D);
        smallCoinsWallet.setBtcValue(0.0D);
        wallets.forEach(wallet -> {
            if (wallet.getValue() <= 2.50) {
                smallCoinsWallet.setEuroValue(smallCoinsWallet.getValue() + wallet.getValue());
                smallCoinsWallet.setBtcValue(smallCoinsWallet.getBtcValue() + wallet.getBtcValue());
                smallCoinsWallet.setProvider("Multiple");
            }
        });
        wallets.add(smallCoinsWallet);

        return wallets;
    }

    public Double getTotalWallets(List<Wallet> wallets) throws IOException {
        Double total = 0D;
        for (Wallet wallet : wallets) {
            if (wallet.getValue() != null) {
                total += wallet.getValue();
            }
        }
        return total;
    }


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private Double getBtcValue(List<Currency> currencies, double euros) {
        Currency cur = currencies.stream().filter(currency -> currency.getSymbol().contains("BTC")).findFirst().get();
        return round(euros / Double.parseDouble(cur.getPrice_eur()), 8);
    }

    public void saveWallets(List<Wallet> wallets) {
        walletRepository.save(wallets);
    }

}
