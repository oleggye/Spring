package com.epam.spring.core.logger;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.epam.spring.core.bean.Event;

public class FileEventLogger implements EventLogger {

	private String fileName;
	private File file;

	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}

	public void init() throws IOException {
		this.file = new File(fileName);
		if (!file.canWrite()) {
			throw new IOException("can't write to file: " + fileName);
		}
	}

	public void logEvent(Event event) {
		File file = new File(fileName);
		try {
			FileUtils.writeStringToFile(file, event.getMsg(), true);
			FileUtils.writeStringToFile(file, "\n", true);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}