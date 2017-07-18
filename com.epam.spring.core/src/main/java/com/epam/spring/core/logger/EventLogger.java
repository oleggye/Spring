package com.epam.spring.core.logger;

import com.epam.spring.core.bean.Event;

public interface EventLogger {

	public void logEvent(Event event);
}