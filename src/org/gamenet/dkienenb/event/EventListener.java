package org.gamenet.dkienenb.event;

public abstract class EventListener {

	public abstract void receiveEvent(Event nextEvent);

	private final EventListenerPriorityLevel priority;

	public EventListener(EventListenerPriorityLevel priority) {
		this.priority = priority;
	}

	public EventListenerPriorityLevel getPriority() {
		return priority;
	}

}
