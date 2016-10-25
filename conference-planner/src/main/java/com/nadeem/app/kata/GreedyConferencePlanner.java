package com.nadeem.app.kata;

import java.util.Date;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class GreedyConferencePlanner {

	private static final int DURATION_FOUR_HOURS = 240;
	private static final int DURATION_THREE_HOURS = 180;
	private static final int DURATION_ONE_HOUR = 60;

	private GreedyConferencePlanner() {

	}

	public static NameStep planner() {
		return new Steps();
	}

	public static interface NameStep {
		StartDateStep name(final String confrenceName);
	}

	public static interface StartDateStep {
		TrackStep startDate(final Date date);
	}
	public static interface TrackStep {
		TalksStep trackCountPerDay(final int trackCountPerDay);
	}
	public static interface TalksStep {
		BuildStep talks(final Talks talks);
	}
	public static interface BuildStep {
		Conference build();
	}

	private static class Steps implements NameStep, StartDateStep, TrackStep, TalksStep, BuildStep {

		private static final String EVENING_SESSION = "Evening Session";
		private static final String AFTERNOON_SESSION = "Afternoon Session";
		private static final String LUNCH_SESSION = "Lunch Session";
		private static final String MORNING_SESSION = "Morning Session";

		private String name;
		private int trackCountPerDay;
		private Date startDate;
		private Talks talks;

		public BuildStep talks(final Talks talks) {
			this.talks = talks;
			return this;
		}

		public TalksStep trackCountPerDay(final int trackCountPerDay) {
			this.trackCountPerDay = trackCountPerDay;
			return this;
		}

		public TrackStep startDate(final Date date) {
			this.startDate = date;
			return this;
		}

		public StartDateStep name(final String confrenceName) {
			this.name = confrenceName;
			return this;
		}

		public Conference build() {
			Date confDate = this.startDate;
			Conference conference = new Conference(this.name);
			while (this.talks.enoughAvailable()) {
				for (int trackIndex = 0; trackIndex < this.trackCountPerDay; trackIndex++) {
					Date trackDate =  atNineAM(confDate);
					Track track = createTrack(trackIndex, trackDate);

					addMorningSession(track, this.talks, trackDate);
					addLunchSession(track, trackDate);
					Session afterNoonSession = addAfterNoonSession(track, this.talks, trackDate);
					Date eveningSessionDate = eveningSessionDate(trackDate, afterNoonSession);
					addEveningSession(track, eveningSessionDate);

					conference.addTrack(track);
				}
				confDate = DateTimeUtil.getNextDay(confDate);
			}		

			return conference;
		}

		private Track createTrack(final int trackIndex, final Date trackDate) {
			return new Track("Track " + trackIndex, trackDate);
		}
		
		// For the requirement does not make sense to move to track
		private Session addMorningSession(final Track track, final Talks talks, final Date trackDate) {
			Session session = new Session(MORNING_SESSION, atNineAM(trackDate), DURATION_THREE_HOURS);
			addTalks(talks, session);
			track.addSession(session);
			return session;
		}

		private Session addLunchSession(final Track track, final Date trackDate) {
			Session session = new Session(LUNCH_SESSION, atAfterNoon(trackDate), DURATION_ONE_HOUR);
			session.add("Lunch", DURATION_ONE_HOUR);
			track.addSession(session);
			return session;
		}

		private Session addAfterNoonSession(final Track track, final Talks talks, final Date trackDate) {
			Session session = new Session(AFTERNOON_SESSION, atOnePM(trackDate), DURATION_FOUR_HOURS);
			addTalks(talks, session);
			track.addSession(session);
			return session;
		}

		private Session addEveningSession(final Track track, final Date eveningSessionDate) {
			Session session = new Session(EVENING_SESSION, eveningSessionDate, DURATION_ONE_HOUR);
			session.add("Networking Event", DURATION_ONE_HOUR);
			track.addSession(session);
			return session;
		}

		private void addTalks(final Talks talks, final Session session) {

			talks.assign(new ResposiveAction<Talk>() {

				public void call(final Talk talk) {
					session.add(talk.getName(), talk.getDuration());				
				}

				public void onException(final Exception exception) {
					if (!shouldIgnore(exception)) {
						throw new RuntimeException(exception);
					}				
				}

				private boolean shouldIgnore(final Exception exception) {
					return exception instanceof IllegalArgumentException;
				}
			});		
		}

		private Date eveningSessionDate(final Date trackDate, final Session afterNoonSession) {
			Date eveningSessionDate = fourPM(trackDate);
			Date endDate = afterNoonSession.getEndTime();
			if (endDate.after(fourPM(trackDate))) {
				eveningSessionDate = fivePM(trackDate);
			}
			return eveningSessionDate;
		}

		private Date atNineAM(final Date confDate) {
			return DateTimeUtil.with(confDate, 9, 0);
		}

		private Date atOnePM(final Date trackDate) {
			return DateTimeUtil.with(trackDate, 13, 0);
		}

		private Date fivePM(final Date trackDate) {
			return DateTimeUtil.with(trackDate, 17, 0);
		}

		private Date fourPM(final Date trackDate) {
			return DateTimeUtil.with(trackDate, 16, 0);
		}

		private Date atAfterNoon(final Date trackDate) {
			return DateTimeUtil.with(trackDate, 12, 0);
		}
	}		
}
