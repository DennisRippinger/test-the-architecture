package de.drippinger.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logging
 *
 * @author Dennis Rippinger
 */
public class Logging {

	Logger logger = LoggerFactory.getLogger(Logging.class);

	public void doLogic() {
		logger.error("Something Happened");
	}

}
