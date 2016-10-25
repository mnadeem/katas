package com.nadeem.app.kata;

import java.util.Date;
/**
 * 
 * @author Nadeem Mohammad
 *
 */
class Talk {

	private final String name;
	private Date start;
	private final int duration;

	public Talk(final String newName, final int newDuration) {
		this.name = newName;
		this.duration = newDuration;
	}

	public void setStart(final Date start) {
		this.start = start;
	}

	public int getDuration() {
		return this.duration;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", DateTimeUtil.getHourMinuteString(this.start), this.name, this.duration);
	}
}
