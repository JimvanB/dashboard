package jim.spring.crypto.repository;

import jim.spring.crypto.entity.TotalValue;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jim on 1-12-17.
 */
@Repository
public interface TotalValueRepository extends CrudRepository<TotalValue,Long> {

    TotalValue findFirstByTimeBetween(LocalDateTime dayBegin, LocalDateTime dayEnd);

    @Query("SELECT max(tv.total) FROM TotalValue tv")
    TotalValue findMaxValue();

    TotalValue findFirstByOrderByIdDesc();

}
