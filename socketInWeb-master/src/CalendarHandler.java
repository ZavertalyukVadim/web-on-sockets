import print.Print;
import print.PrintInWeb;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/11/16.
 */
public class CalendarHandler implements Handler {
    private HttpRequest request;
    static String form =
            "<form method=\"LINK\" action=\"http://greater.local:8080\">\n" +
                    "    <input type=\"submit\" value=\"Home\">\n" +
                    "</form>" ;

    public CalendarHandler(HttpRequest request) {
        this.request = request;
    }

    @Override
    public String print(HttpRequest httpRequest) {
        List<DayOfWeek> dayOfWeeks = new ArrayList<>();
        Print print = new PrintInWeb();
        System.out.println("httpRequest in Calendar Hadler="+httpRequest.getParam().size());
        System.out.println(httpRequest.getParam());
        if(httpRequest.getParam().size()>=1) {
            System.out.println(httpRequest.getParam().get("day"));
            System.out.println(httpRequest.getParam().get("month"));
            System.out.println(httpRequest.getParam().get("year"));
            System.out.println(httpRequest.getParam().get("dayOfWeek"));
            String weekend = httpRequest.getParam().get("weekends");
            List<DayOfWeek> weekList = add(weekend, dayOfWeeks);
            print.setToday(LocalDate.of(Integer.parseInt(httpRequest.getParam().get("year")), Integer.parseInt(httpRequest.getParam().get("month")), Integer.parseInt(httpRequest.getParam().get("day"))));
            print.setDayOfWeek(DayOfWeek.of(Integer.parseInt(httpRequest.getParam().get("dayOfWeek"))));
            print.setWeekends(weekList);
        }
//        print.setToday(LocalDate.of(Integer.parseInt(httpRequest.getParam().get("year")));
        return print.print();
    }

    private static List<DayOfWeek> add(String s, List<DayOfWeek> dayOfWeeks) {
        String[] numbersArray = s.split("[ ,]");
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                DayOfWeek weekends = DayOfWeek.of(Integer.parseInt(number.trim()));
                dayOfWeeks.add(weekends);
            }
        }
        return dayOfWeeks;
    }
}
