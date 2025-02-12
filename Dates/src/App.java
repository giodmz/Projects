import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) throws Exception {
        
        LocalDate date = LocalDate.now();
        LocalDateTime date2 = LocalDateTime.now();
        Instant date3 = Instant.now();
        Instant date7 = Instant.parse("2022-07-20T01:30:26.03Z");
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter formatterTimezone = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
        .withZone(ZoneId.systemDefault());
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter isoFormatterInstant = DateTimeFormatter.ISO_INSTANT;
        
        LocalDate date8 = LocalDate.parse("12/02/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        LocalDateTime date9 = LocalDateTime.parse("12/02/2025 15:30", formatterHour);
        
        LocalDate date10 = LocalDate.of(2025, 02, 12);
        LocalDateTime date11 = LocalDateTime.of(2025, 02, 12, 15, 45);
        LocalDate date12 = LocalDate.parse("2025-02-12");
        
        // System.out.println("d1 = " + date);
        // System.out.println("d2 = " + date2);
        // System.out.println("d3 = " + date3);
        // System.out.println("d4 = " + date4);
        // System.out.println("d5 = " + date5.format(formatter));
        // System.out.println("d5 = " + date5.format(formatter2));
        // System.out.println("d6 = " + date6);
        // System.out.println("d6 = " + formatterTimezone.format(date6));
        // System.out.println("d6 = " + isoFormatterInstant.format(date6));
        // System.out.println("d7 = " + date7);
        // System.out.println("d8 = " + date8);
        // System.out.println("d9 = " + date9);
        // System.out.println("d10 = " + date10);
        // System.out.println("d11 = " + date11);
        // System.out.println("d11 = " + date11.format(isoFormatter));
        // System.out.println("d11 = " + date12.format(formatter));
        
        // for(String s : ZoneId.getAvailableZoneIds()){
            //     System.out.println(s);
            // }
            
            
            LocalDate date4 = LocalDate.parse("2025-02-12");
            LocalDateTime date5 = LocalDateTime.parse("2025-02-12T15:30:02");
            Instant date6 = Instant.parse("2025-02-12T15:30:02Z");

            // somar/subtrair dias
            LocalDate pastWeek = date4.minusDays(7);
            LocalDate nextWeek = date4.plusDays(7);

            LocalDateTime pastWeekLd = date5.minusDays(7);
            LocalDateTime nextWeekLd = date5.plusDays(7);

            System.out.println("past week: " + pastWeek);
            System.out.println("next week: " + nextWeek);
            
            // somar/subtrair dias (Instant)
            Instant pastWeekInstant = date6.minus(7, ChronoUnit.DAYS);
            Instant nextWeekInstant = date6.plus(7, ChronoUnit.DAYS);

            Duration t1 = Duration.between(pastWeekLd, date5);
            System.out.println("t1 dias = " + t1.toDays());

            // LocalDate deve ser convertido para LocalDateTime
            Duration t2 = Duration.between(pastWeek.atStartOfDay(), date4.atStartOfDay());
            System.out.println("t2 dias = " + t2.toDays());

            Duration t3 = Duration.between(pastWeekInstant, date6);
            System.out.println("t2 dias = " + t3.toDays());


            // LocalDate r2 = date6.atZone(ZoneId.of("Portugal")).toLocalDate();
            
            // LocalDate r1 = Instant.ofEpochMilli(date6.toEpochMilli())
            // .atZone(ZoneId.systemDefault())
            // .toLocalDate();
            
            // System.out.println("r1 = " + r1);
            // System.out.println("r2 = " + r2);

            // System.out.println("d4 dia = " + date4.getDayOfMonth());
            // System.out.println("d4 mes = " + date4.getMonthValue());
            // System.out.println("d4 ano = " + date4.getYear());

            // System.out.println("d5 hora = " + date5.getHour());
            // System.out.println("d5 minuto = " + date5.getMinute());

        }
    }
