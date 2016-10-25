package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Session {

	private final String name;
	private final Date start;
	private final int duration;
	private Collection<Talk> talks;
	private int durationSoFar = 0;

	public Session(final String name, final Date start, final int duration) {
		this.name = name;
		this.start =  start;
		this.duration = duration;
		this.talks = new ArrayList<Talk>();
	}

	public void add(final String name, final int taskDuration) {
		validate(taskDuration);
		Talk newTalk = newTalk(name, taskDuration, DateTimeUtil.addMinutes(this.start, this.durationSoFar));
		this.talks.add(newTalk);
		this.durationSoFar = this.durationSoFar + taskDuration;	
	}

	private void validate(final int taskDuration) {
		if (this.durationSoFar + taskDuration > this.duration) {
			throw new IllegalArgumentException("Can't Add Task to this session");
		}
	}

	private Talk newTalk(final String name, final int taskDuration, final Date start) {
		Talk talk = new Talk(name, taskDuration);
		talk.setStart(start);
		return talk;
	}

	public Date getEndTime() {		
		return DateTimeUtil.addMinutes(this.start, this.durationSoFar);
	}

	public String getName() {
		return this.name;
	}

	public Date getStart() {
		return this.start;
	}

	public void forEachTalk(final Action<Talk> talkAction) {
		for (Talk talk : talks) {
			talkAction.call(talk);
			
		}		
	}
}
