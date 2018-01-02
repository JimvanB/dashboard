package jim.spring.crypto.interfaces;

import jim.spring.crypto.entity.Wallet;

import java.util.List;

/**
 * Created by jim on 31-12-17.
 */
public interface WalletConverter<T> {

    List<Wallet> convert(List<T> wallet);

    Wallet convert(T wallet);

}
