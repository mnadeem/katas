package com.nadeem.app.kata;

import java.util.Date;

import org.junit.Test;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class GreedyConferencePlannerTest {

	@Test
	public void printTest() {

		Conference conference = GreedyConferencePlanner.planner()
												.name("The Ultimate Confrence")
												.startDate(new Date())
												.trackCountPerDay(1)
												.talks(talks())
												.build();

		ConferencePrinter printer = new ConsoleConferencePrinter();
		printer.print(conference);
	}

	private Talks talks() {
		return Talks.builder()
					.add("Talk one", 30)
					.add("Talk two", 60)
					.add("Talk three", 60)
					.add("Talk four", 60)
					.add("Talk five", 60)
					.add("Talk six", 180)
					.add("Talk seven", 120)
					.addAndBuild("Talk eight", 120);
	}
}
