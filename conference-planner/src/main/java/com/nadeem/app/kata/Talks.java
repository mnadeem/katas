package com.nadeem.app.kata;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Talks {

	private static final int DEFAULT_TASKS_COUNT = 500;
	private PriorityQueue<Talk> talks;

	private Talks() {
		this.talks = new PriorityQueue<Talk>(DEFAULT_TASKS_COUNT, maxHeap());
	}

	private Comparator<Talk> maxHeap() {
		return new Comparator<Talk>() {

			public int compare(Talk talk1, Talk talk2) {
				return talk2.getDuration() - talk1.getDuration();
			}			
		};
	}

	private void addTalk(final String name, final int duration) {
		this.talks.add(new Talk(name, duration));
	}

	public void assign(final ResposiveAction<Talk> talkAction) {

		for (Iterator<Talk> iterator = this.talks.iterator(); iterator.hasNext();) {
			Talk talk = iterator.next();
			try {
				talkAction.call(talk);
				iterator.remove();
			} catch (Exception e) {
				talkAction.onException(e);
			}
		}
	}

	public boolean enoughAvailable() {
		return !this.talks.isEmpty();
	}

	public static AddAndBuildStep builder() {
		return new Steps();
	}

	public static interface AddAndBuildStep {
		AddAndBuildStep add(String name, int duration);
		Talks addAndBuild(String name, int duration);
	}

	private static class Steps implements AddAndBuildStep {

		private Talks talks;

		public Steps() {
			this.talks = new Talks();
		}

		public AddAndBuildStep add(final String name, final int duration) {
			this.talks.addTalk(name, duration);
			return this;
		}

		public Talks addAndBuild(final String name, final int duration) {
			this.talks.addTalk(name, duration);
			return this.talks;
		}
	}
}
