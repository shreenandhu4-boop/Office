package com.org.office.practice.examples;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateDifferenceExmp {
	public static void main(String[] args) {
		
		LocalDate currentDate = LocalDate.now(); // Gets the current date human readable
        System.out.println("Current Date: " + currentDate);
		
        Instant i = Instant.now(); // machine readable , now()static method, gmt time(greenwich mean time)
        System.out.println("Instant time: " + i);
        
        LocalDate d = LocalDate.of(2025,Month.AUGUST,07); 
        System.out.println("Current Date: " + d);
        
        LocalDateTime currentDateTime = LocalDateTime.now(); // Gets the current date and time
        System.out.println("Current Date and Time: " + currentDateTime);
		
        
        LocalTime currentTime = LocalTime.now(); // Gets the current time
        System.out.println("Current Time: " + currentTime);
        
        
         LocalDate date1 = LocalDate.of(2024, 5, 10);//gets difference between two dates
         LocalDate date2 = LocalDate.of(2025, 8, 15);
         Period period = Period.between(date1, date2);
         int years = period.getYears();
         int months = period.getMonths();
         int days = period.getDays();
         System.out.println("Difference: " + years + " years, " + months + " months, " + days + " days.");
    
         long daysBetween = ChronoUnit.DAYS.between(date1, date2);//total days between...
         System.out.println("Total days between: " + daysBetween);
         
         LocalDateTime now = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         String formattedDateTime = now.format(formatter);
         System.out.println("Formatted Date and Time: " + formattedDateTime);
         
         //gets all countries 
       //  for(String val : ZoneId.getAvailableZoneIds()) { //this method returns set<string>  so return type is string 
       // 	 System.out.println("all countries : " + val);
      //   }
         	
         LocalDateTime europeTime = LocalDateTime.now(ZoneId.of("Europe/Madrid"));
         System.out.println("EuropeTime: " + europeTime);
	
         LocalDate ld  = LocalDate.now(); 
         System.out.println("local date: " + ld);
         System.out.println("year: " + ld.getYear());
         System.out.println("month: " + ld.getMonth());
         System.out.println("day of week: " + ld.getDayOfWeek());
         System.out.println("day of month: " + ld.getDayOfMonth());
         System.out.println("days of year: " + ld.getDayOfYear());
         
         LocalDate daysCount = LocalDate.of(2025,12,31);
         System.out.println("number of days in 2025: " + daysCount.getDayOfYear() );
         
         //get date, month, year for given date value
         LocalDate l = LocalDate.of(2015,8,23);
         System.out.println("local date: " + l);
         System.out.println("year: " + l.getYear());
         System.out.println("month: " + l.getMonth());
         System.out.println("day of week: " + l.getDayOfWeek());
         System.out.println("day of month: " + l.getDayOfMonth());
         
         LocalTime lt = LocalTime.now();
         System.out.println("current time: " + lt);
         System.out.println("hour: " + lt.getHour());
         System.out.println("minutes: " + lt.getMinute());
         System.out.println("seconds: " + lt.getSecond());
         
         
	}

}
