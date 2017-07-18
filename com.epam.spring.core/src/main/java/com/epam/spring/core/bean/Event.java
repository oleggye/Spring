package com.epam.spring.core.bean;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Event {

	private int id;
	private String msg;
	private Date date;
	private DateFormat format;

	public Event(Date date, DateFormat format) {
		this.date = date;
		this.format = format;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", msg=" + msg + ", date=" + format.format(date) + "]";
	}

	public static boolean isDay() {
		LocalTime currentTime = LocalTime.now();
		LocalTime leftBound = LocalTime.of(8, 0);
		LocalTime rightBound = LocalTime.of(16, 59);
		if (currentTime.isAfter(leftBound) && currentTime.isBefore(rightBound)) {
			return true;
		}
		return false;
	}
}