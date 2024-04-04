package org.gamenet.dkienenb.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {

	private final List<Event> queue = new ArrayList<>();
	private final Map<EventListenerPriorityLevel, List<EventListener>> priorityLevelToListenerListMap = new HashMap<>();

	public void addEvent(Event event) {
		queue.add(event);
	}

	public void addListener(EventListener listener) {
		EventListenerPriorityLevel priority = listener.getPriority();
		List<EventListener> currentListeners = priorityLevelToListenerListMap.computeIfAbsent(priority, k -> new ArrayList<>());
		currentListeners.add(listener);
	}

	public boolean hasNextEvent() {
		return !queue.isEmpty();
	}

	public void callNextEvent() {
		Event nextEvent = queue.remove(0);
		List<EventListenerPriorityLevel> availablePriorityLevels = new ArrayList<>(priorityLevelToListenerListMap.keySet());
		availablePriorityLevels.sort(new EventListenerPriorityLevel.HighestLevelComparator());
		for (EventListenerPriorityLevel eventListenerPriorityLevel : availablePriorityLevels) {
			List<EventListener> listeners = priorityLevelToListenerListMap.get(eventListenerPriorityLevel);
			listeners.forEach(listener -> listener.receiveEvent(nextEvent));
		}
	}
}
