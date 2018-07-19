package org.gamenet.dkienenb.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
		List<EventListener> currentListeners = priorityLevelToListenerListMap.get(priority);
		if (null == currentListeners) {
			currentListeners = new ArrayList<>();
			priorityLevelToListenerListMap.put(priority, currentListeners);
		}
		currentListeners.add(listener);
	}

	public void callNextEvent() {
		Event nextEvent = queue.remove(0);
		List<EventListenerPriorityLevel> avaiblePriorityLevels = new ArrayList<>(priorityLevelToListenerListMap.keySet());
		Collections.sort(avaiblePriorityLevels, new EventListenerPriorityLevel.HighestLevelComparator());
		for (Iterator<EventListenerPriorityLevel> iterator = avaiblePriorityLevels.iterator(); iterator.hasNext();) {
			EventListenerPriorityLevel eventListenerPriorityLevel = iterator.next();
			List<EventListener> listeners = priorityLevelToListenerListMap.get(eventListenerPriorityLevel);
			listeners.forEach(listener -> listener.receiveEvent(nextEvent));
		}
	}
}
