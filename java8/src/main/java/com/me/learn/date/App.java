package com.me.learn.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.Stream;

public class App {
	
	public static void main(String[] args) {
		Stream.iterate(LocalDate.of(1985, Month.JULY, 5), d -> d.plusYears(1))
		.map(LocalDate::getDayOfWeek)
		.limit(32)
		.forEach(System.out::println);
		
		
		LocalDate date = LocalDate.of(2015, Month.OCTOBER, 25);
		System.out.println(date);
		
		System.out.println(date.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println(date.with(TemporalAdjusters.firstDayOfYear()));
		System.out.println(date.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY)));
		
		
		
	}

}
