package jim.spring.crypto.repository;

import jim.spring.crypto.entity.TotalValue;
import jim.spring.crypto.entity.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jim on 1-12-17.
 */
@Repository
public interface WalletRepository extends CrudRepository<Wallet,Long> {

    List<Wallet> findByTimeBetween(LocalDateTime dayBegin, LocalDateTime dayEnd);

}
