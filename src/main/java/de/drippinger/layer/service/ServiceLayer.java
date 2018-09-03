package de.drippinger.layer.service;

import de.drippinger.layer.persistence.PersistenceLayer;

import java.util.Date;

/**
 * ServiceLayer
 *
 * @author Dennis Rippinger
 */
public class ServiceLayer {

	private PersistenceLayer persistenceLayer;

	public void doServiceLogic(String userData) {
        Date date = new Date();

        String finalValue = userData + date;


        persistenceLayer.storeToDatabase(finalValue);
	}

}
