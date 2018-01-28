package jim.spring.crypto.domain;

import java.time.LocalDateTime;

/**
 * Created by jim on 28-1-18.
 */
public class TotalValueStats {

    Double totalValueAvg;
    Double totalValueMax;
    Double totalValueMin;
    Integer week;
    Integer day;
    Integer month;
    Integer year;
    LocalDateTime time;

    public TotalValueStats() {
    }

    public TotalValueStats(Double totalValueAvg, Double totalValueMax, Double totalValueMin, Integer year) {
        this.totalValueAvg = totalValueAvg;
        this.totalValueMax = totalValueMax;
        this.totalValueMin = totalValueMin;
        this.year = year;
    }

    public TotalValueStats(Double totalValueAvg, Double totalValueMax, Double totalValueMin, Integer week, Integer year) {
        this.totalValueAvg = totalValueAvg;
        this.totalValueMax = totalValueMax;
        this.totalValueMin = totalValueMin;
        this.week = week;
        this.year = year;
    }

    public TotalValueStats(Double totalValueAvg, Double totalValueMax, Double totalValueMin, Integer day, Integer month, Integer year) {
        this.totalValueAvg = totalValueAvg;
        this.totalValueMax = totalValueMax;
        this.totalValueMin = totalValueMin;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Double getTotalValueAvg() {
        return totalValueAvg;
    }

    public void setTotalValueAvg(Double totalValueAvg) {
        this.totalValueAvg = totalValueAvg;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getTotalValueMax() {
        return totalValueMax;
    }

    public void setTotalValueMax(Double totalValueMax) {
        this.totalValueMax = totalValueMax;
    }

    public Double getTotalValueMin() {
        return totalValueMin;
    }

    public void setTotalValueMin(Double totalValueMin) {
        this.totalValueMin = totalValueMin;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public LocalDateTime getTime() {
        LocalDateTime time = LocalDateTime.now();
        time.withMonth(month);
        time.withDayOfMonth(day);
        time.withYear(year);
        return time;
    }

    public String getTimeString(String interval){
            switch (interval){
                case "day":
                    return ""+getYear()+'-'+getMonth()+'-'+getDay();
                case "week":
                   return ""+getYear()+'-'+getWeek();
                case "month":
                    return ""+getYear()+'-'+getWeek();
                case "year":
                    return ""+getYear();
                default:
                    return ""+getYear()+'-'+getMonth()+'-'+getDay();
            }
    }

}
