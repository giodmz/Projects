using System.Globalization;

class Program
{
    static void Main(string[] args)
    {
        Console.Clear();

        //var data = DateTime.Now;
        //Console.WriteLine(data);

        //var formatada = String.Format("{0:yyyy/MM/dd hh:mm:ss ff z}", data);
        //var formatada = String.Format("{0:D}", data);
        //Console.WriteLine(formatada);

        //Console.WriteLine(data.AddDays(12));
        //Console.WriteLine(data.AddMonths(1));
        //Console.WriteLine(data.AddYears(1));

        //var pt = new CultureInfo("pt-BR");
        //var en = new CultureInfo("en-US");
        //var kr = new CultureInfo("ko-KR");
        //var de = new CultureInfo("de-DE");
        //var atual = CultureInfo.CurrentCulture;

        //Console.WriteLine(DateTime.Now.ToString("D", atual));

        var utcDate = DateTime.UtcNow;
        //Console.WriteLine(utcDate);
        //Console.WriteLine(DateTime.Now);
        //Console.WriteLine(utcDate.ToLocalTime());

        //var timezoneAustralia = TimeZoneInfo.FindSystemTimeZoneById("Pacific/Auckland");
        //Console.WriteLine(timezoneAustralia);

        //var horaAustralia = TimeZoneInfo.ConvertTimeFromUtc(utcDate, timezoneAustralia);
        //Console.WriteLine(horaAustralia);

        /// Exibir todos os TimeZones

        //var timezones = TimeZoneInfo.GetSystemTimeZones();
        //foreach (var timezone in timezones)
        //{
        //    Console.WriteLine(timezone.Id);
        //    Console.WriteLine(timezone);
        //Console.WriteLine(TimeZoneInfo.ConvertTimeFromUtc(utcDate, timezone));
        //    Console.WriteLine("________________");
        //}

        //var timeSpan = new TimeSpan();
        //Console.WriteLine(timeSpan);

        //var timeSpanNanosegundos = new TimeSpan(1);
        //Console.WriteLine(timeSpanNanosegundos);

        //var timeSpanHoraMinutoSegundo = new TimeSpan(5, 10, 9);
        //Console.WriteLine(timeSpanHoraMinutoSegundo);

        //var timeSpanDiaHoraMinutoSegundo = new TimeSpan(3, 4, 20, 9);
        //Console.WriteLine(timeSpanDiaHoraMinutoSegundo);

        //var timeSpanDiaHoraMinutoSegundoMilissegundo = new TimeSpan(3, 4, 20, 9, 7);
        //Console.WriteLine(timeSpanDiaHoraMinutoSegundoMilissegundo);

        //Console.WriteLine(timeSpanHoraMinutoSegundo - timeSpanDiaHoraMinutoSegundo);
        //Console.WriteLine(timeSpanDiaHoraMinutoSegundo.Days);
        //Console.WriteLine(timeSpanDiaHoraMinutoSegundo.Add(new TimeSpan(10, 0, 0)));

        Console.WriteLine(DateTime.DaysInMonth(2023, 11));
        Console.WriteLine(IsWeekend(DateTime.Now.DayOfWeek));
        Console.WriteLine(DateTime.Now.IsDaylightSavingTime());


    }

    static bool IsWeekend(DayOfWeek today)
    {
        return today == DayOfWeek.Saturday || today == DayOfWeek.Sunday;
    }

}

// y = year
// M = month
// d = day
// h = hour
// m = minute
// s = second
// ff = fração de s
// z = timezone