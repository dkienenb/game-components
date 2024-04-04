package org.gamenet.dkienenb.event;

import java.util.Comparator;

public enum EventListenerPriorityLevel {

	CANCEL(5),
	MODIFY(4),
	REACT_HIGH(3),
	REACT(2),
	REACT_LOW(1);

	public static class HighestLevelComparator implements Comparator<EventListenerPriorityLevel> {

		@Override
		public int compare(EventListenerPriorityLevel first, EventListenerPriorityLevel second) {
			return second.getPriority() - first.getPriority();
		}
		
	}

	private final int priority;

	EventListenerPriorityLevel(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

}
