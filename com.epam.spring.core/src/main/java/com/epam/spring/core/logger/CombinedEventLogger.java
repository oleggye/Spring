package com.epam.spring.core.logger;

import java.util.Collection;
import com.epam.spring.core.bean.Event;

public class CombinedEventLogger implements EventLogger {
	private Collection<EventLogger> loggers;

	public CombinedEventLogger(Collection<EventLogger> loggers) {
		this.loggers = loggers;
	}

	@Override
	public void logEvent(Event event) {
		for (EventLogger logger : loggers) {
			logger.logEvent(event);
		}
	}
}