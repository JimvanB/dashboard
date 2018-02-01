package jim.spring.crypto.repository;

import jim.spring.crypto.domain.TotalValueStats;
import jim.spring.crypto.entity.TotalValue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jim on 1-12-17.
 */
@Repository
public interface TotalValueRepository extends CrudRepository<TotalValue,Long> {

    TotalValue findFirstByTimeBetween(LocalDateTime dayBegin, LocalDateTime dayEnd);

    @Query("SELECT max(tv.total), tv.time FROM TotalValue tv GROUP BY tv.time")
    TotalValue findMaxValue();

    TotalValue findFirstByOrderByTotalDesc();

    TotalValue findFirstByOrderByIdDesc();

    @Query("SELECT new jim.spring.crypto.domain.TotalValueStats( AVG(tv.total) as totalValueAvg, MAX(tv.total) as totalValueMax, MIN(tv.total) as totalValueMin,CONCAT(day(tv.time),'-',month(tv.time),'-',year(tv.time)) as timeString) FROM TotalValue tv GROUP BY year(tv.time), month(tv.time), day(tv.time)")
    List<TotalValueStats> findTotalValueStatsPerDay();

    @Query("SELECT new jim.spring.crypto.domain.TotalValueStats( AVG(tv.total) as totalValueAvg, MAX(tv.total) as totalValueMax, MIN(tv.total) as totalValueMin,CONCAT(week(tv.time),'-',year(tv.time)) as timeString) FROM TotalValue tv GROUP BY year(tv.time), week(tv.time)")
    List<TotalValueStats> findTotalValueStatsPerWeek();

    @Query("SELECT new jim.spring.crypto.domain.TotalValueStats( AVG(tv.total) as totalValueAvg, MAX(tv.total) as totalValueMax, MIN(tv.total) as totalValueMin,CONCAT(month(tv.time),'-',year(tv.time)) as timeString) FROM TotalValue tv GROUP BY year(tv.time), month(tv.time)")
    List<TotalValueStats> findTotalValueStatsPerMonth();

    @Query("SELECT new jim.spring.crypto.domain.TotalValueStats( AVG(tv.total) as totalValueAvg, MAX(tv.total) as totalValueMax, MIN(tv.total) as totalValueMin,CONCAT('',year(tv.time)) as timeString) FROM TotalValue tv GROUP BY year(tv.time)")
    List<TotalValueStats> findTotalValueStatsPerYear();

    @Query("SELECT new jim.spring.crypto.domain.TotalValueStats( AVG(tv.total) as totalValueAvg, MAX(tv.total) as totalValueMax, MIN(tv.total) as totalValueMin,CONCAT('',hour(tv.time),':00') as timeString) FROM TotalValue tv WHERE tv.time BETWEEN :dayBegin AND :dayEnd GROUP BY day(tv.time),hour(tv.time)")
    List<TotalValueStats> findTotalValueStatsPerHour(@Param("dayBegin") LocalDateTime dayBegin,@Param("dayEnd") LocalDateTime dayEnd);

    @Query("SELECT new jim.spring.crypto.domain.TotalValueStats( AVG(tv.total) as totalValueAvg, CONCAT(hour(tv.time),':',minute(tv.time)) as timeString) FROM TotalValue tv WHERE tv.time BETWEEN :dayBegin AND :dayEnd GROUP BY day(tv.time),hour(tv.time), minute(tv.time)")
    List<TotalValueStats> findTotalValueStatsPerMinute(@Param("dayBegin") LocalDateTime dayBegin,@Param("dayEnd") LocalDateTime dayEnd);


}
