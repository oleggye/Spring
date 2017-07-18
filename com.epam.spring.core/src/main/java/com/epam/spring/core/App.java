package com.epam.spring.core;

import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.core.bean.Client;
import com.epam.spring.core.bean.Event;
import com.epam.spring.core.bean.EventType;
import com.epam.spring.core.logger.EventLogger;

public class App {
	private Client client;
	private EventLogger eventLogger;
	private Map<EventType, EventLogger> eventLoggers;

	private static ConfigurableApplicationContext context;

	public App() {
	}

	public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> eventLoggers) {
		this.client = client;
		this.eventLogger = eventLogger;
		this.eventLoggers = eventLoggers;
	}

	public void logEvent(EventType type, String msg) {
		EventLogger logger = eventLoggers.get(type);
		if (logger == null) {
			logger = this.eventLogger;
		}

		Event event = context.getBean(Event.class);
		String message = msg.replaceAll(client.getId(), client.getName());
		// String message = client.toString();
		event.setMsg(message);
		logger.logEvent(event);
	}

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("spring.xml");
		App app = context.getBean(App.class);

		app.logEvent(EventType.ERROR, "Some event for user 1");
		app.logEvent(EventType.INFO, "Some event for user 2");
		app.logEvent(null, "Some event for user 3");

		Map<Class<?>, Integer> counter = (Map<Class<?>, Integer>) context.getBean("counterMap");
		System.out.println(counter);
		context.close();
	}
}