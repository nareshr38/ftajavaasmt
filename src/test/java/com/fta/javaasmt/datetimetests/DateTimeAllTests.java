package com.fta.javaasmt.datetimetests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DateTimeAllTests {
    @DataProvider(name = "yesterdayDate")
    public Object[][] dateData() {
        return new Object[][]{
                {"2020-03-30"}
        };
    }

    @Test(dataProvider = "yesterdayDate")
    public void test(String localDate) {
        Predicate<LocalDate> localDatePredicate = localDate1 ->
                  LocalDate.now().minusDays(1).isEqual(localDate1);
        Assert.assertTrue(localDatePredicate.test(LocalDate.parse(localDate)));
    }

    @Test
    public void getNextThursday() {

        Supplier<LocalDate> localDateSupplier = () -> {
            LocalDate ld = LocalDate.now();
            while (!ld.getDayOfWeek().equals(DayOfWeek.THURSDAY))
                   ld = ld.plusDays(1);
            return ld;
        };
        System.out.println("Next Thursday ::" + localDateSupplier.get());
    }

    @Test
    public void testTimeInZones() {
        Supplier<LocalTime> localTimeSupplier = () -> LocalTime.now(ZoneId.of("America/New_York"));
        System.out.println("Time in EST::" + localTimeSupplier.get());
    }

    @DataProvider(name = "age")
    public Object[][] ageData() {
        return new Object[][]{
                {"1993-07-10"},
                {"1956-03-10"}
        };
    }

    @Test(dataProvider = "age")
    public void ageCalci(String strDate) {
        LocalDate localDate = LocalDate.now();
        Period period = Period.between(LocalDate.parse(strDate), localDate);
        System.out.println("Age :: " + period.getYears());
    }

}
