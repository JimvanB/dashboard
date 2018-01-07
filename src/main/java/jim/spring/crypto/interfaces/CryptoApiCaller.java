package jim.spring.crypto.interfaces;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import jim.spring.crypto.entity.Wallet;

import java.io.IOException;
import java.util.List;

public interface CryptoApiCaller {

    List<Wallet> getWallets() throws IOException;

    void calculateWalletValue(Wallet wallet);
}
