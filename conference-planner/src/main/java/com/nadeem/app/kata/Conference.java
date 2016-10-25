package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Conference {

	private final String name;
	private Collection<Track> tracks;

	public Conference(final String name) {
		this.name = name;
		this.tracks = new ArrayList<Track>();
	}

	public void addTrack(final Track track) {
		this.tracks.add(track);
	}

	public String getName() {
		return this.name;
	}

	public void forEachTrack(final Action<Track> trackAction) {
		for (Track track : this.tracks) {
			trackAction.call(track);
		}		
	}
}
