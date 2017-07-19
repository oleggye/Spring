package com.epam.spring.core.logger;

import com.epam.spring.core.bean.Event;

public class ConsoleEventLogger implements EventLogger {

	public void logEvent(Event event) {
		System.out.println(event);
	}
}