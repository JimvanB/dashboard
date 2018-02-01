package jim.spring.crypto.controllers;

import jim.spring.crypto.domain.TotalValueStats;
import jim.spring.crypto.repository.TotalValueRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jim on 28-1-18.
 */
@RestController
public class DataController {

    private TotalValueRepository totalValueRepository;

    public DataController(TotalValueRepository totalValueRepository) {
        this.totalValueRepository = totalValueRepository;
    }

    @GetMapping(value = "/totalvalue/{interval}", produces = "application/json")
    public Object[][] getTotalValues(@PathVariable("interval") String interval) {
        List<TotalValueStats> totalValueStats = null;
        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = end.minusDays(1);
        switch (interval) {
            case "minute":
                totalValueStats = totalValueRepository.findTotalValueStatsPerMinute(start, end);
                break;
            case "hour":
                totalValueStats = totalValueRepository.findTotalValueStatsPerHour(start, end);
                break;
            case "day":
                totalValueStats = totalValueRepository.findTotalValueStatsPerDay();
                break;
            case "week":
                totalValueStats = totalValueRepository.findTotalValueStatsPerWeek();
                break;
            case "month":
                totalValueStats = totalValueRepository.findTotalValueStatsPerMonth();
                break;
            case "year":
                totalValueStats = totalValueRepository.findTotalValueStatsPerYear();
                break;
            default:
                totalValueStats = totalValueRepository.findTotalValueStatsPerDay();
                break;
        }
        Object[][] values = null;
        if (!interval.equals("minute")) {
            values = new Object[totalValueStats.size() + 1][4];
            values[0][0] = interval;
            values[0][1] = "Min";
            values[0][2] = "Max";
            values[0][3] = "Avg";
            for (int i = 0; i < totalValueStats.size(); i++) {

                values[i + 1][0] = totalValueStats.get(i).getTimeString();
                values[i + 1][1] = round(totalValueStats.get(i).getTotalValueMin(), 0);
                values[i + 1][2] = round(totalValueStats.get(i).getTotalValueMax(), 0);
                values[i + 1][3] = round(totalValueStats.get(i).getTotalValueAvg(), 0);

            }
        } else {
            values = new Object[totalValueStats.size() + 1][2];
            values[0][0] = interval;
            values[0][1] = "Avg";
            for (int i = 0; i < totalValueStats.size(); i++) {

                values[i + 1][0] = totalValueStats.get(i).getTimeString();
                values[i + 1][1] = round(totalValueStats.get(i).getTotalValueAvg(), 0);

            }
        }


        return values;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
