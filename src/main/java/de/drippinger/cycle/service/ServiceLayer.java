package de.drippinger.cycle.service;

import de.drippinger.cycle.persistence.PersistenceLayer;

import java.util.Random;

/**
 * ServiceLayer
 *
 * @author Dennis Rippinger
 */
public class ServiceLayer {

	private PersistenceLayer persistenceLayer;

	public void doServiceLogic(String userData) {
		String finalValue = userData + randomValue();

		persistenceLayer.storeToDatabase(finalValue);
	}

	private String randomValue() {
		return String.valueOf(new Random().nextInt());
	}

}
