package Market;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class MarketClock {
	private static MarketClock instance = new MarketClock();
    private MarketClock() {}

    public static MarketClock getInstance() {
        return instance;
    }

    public boolean isStockMarketOpen() {
    	LocalDateTime now = LocalDateTime.now();
    	DayOfWeek day = now.getDayOfWeek();
        boolean isWeekday = day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY;
        boolean isWorkingHours = now.getHour() >= 9 && now.getHour() < 18;

        return isWeekday && isWorkingHours;
    }
}
