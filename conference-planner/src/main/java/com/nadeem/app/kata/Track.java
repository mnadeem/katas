package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Track {

	private final String name;
	private final Date date;
	private Collection<Session> sessions;

	public Track(final String name, final Date date) {
		this.name = name;
		this.date = date;
		this.sessions = new ArrayList<Session>();
	}

	public void addSession(final Session session) {
		this.sessions.add(session);
	}

	public String getName() {
		return this.name;
	}

	public Date getDate() {
		return this.date;
	}

	public void forEachSession(final Action<Session> sessionAction) {
		for (Session session : this.sessions) {
			sessionAction.call(session);
		}		
	}
}
