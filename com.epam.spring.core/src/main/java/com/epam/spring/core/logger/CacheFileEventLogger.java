package com.epam.spring.core.logger;

import java.util.ArrayList;
import java.util.List;

import com.epam.spring.core.bean.Event;

public class CacheFileEventLogger extends FileEventLogger {
	private int cacheSize;
	private List<Event> eventList;

	public CacheFileEventLogger(String fileName, int cacheSize) {
		super(fileName);
		this.cacheSize = cacheSize;
		eventList = new ArrayList<>();
	}

	@Override
	public void logEvent(Event event) {
		eventList.add(event);
		if (cacheSize == eventList.size()) {
			writeEventsFromCache();
			eventList.clear();
		}
	}

	private void writeEventsFromCache() {
		for (Event elem : eventList) {
			super.logEvent(elem);
		}
	}

	public void destroy() {
		if (!eventList.isEmpty()) {
			writeEventsFromCache();
		}
	}

}
