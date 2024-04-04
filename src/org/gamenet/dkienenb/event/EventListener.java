package org.gamenet.dkienenb.event;

import java.util.function.Consumer;

public class EventListener {

	public Consumer<Event> reaction;

	private final EventListenerPriorityLevel priority;

	private final Class<? extends Event> filter;

	public EventListener(Class<? extends Event> filter, EventListenerPriorityLevel priority, Consumer<Event> reaction) {
		this.priority = priority;
		this.reaction = reaction;
		this.filter = filter;
	}

	public EventListenerPriorityLevel getPriority() {
		return priority;
	}

	public void receiveEvent(Event nextEvent) {
		if(nextEvent.getClass().isAssignableFrom(filter)) {
			reaction.accept(nextEvent);
		}
	}
}
