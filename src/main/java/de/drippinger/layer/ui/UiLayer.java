package de.drippinger.layer.ui;

import de.drippinger.layer.persistence.PersistenceLayer;
import de.drippinger.layer.service.ServiceLayer;

/**
 * UiLayer
 *
 * @author Dennis Rippinger
 */
public class UiLayer {

	private ServiceLayer serviceLayer;

	private PersistenceLayer persistenceLayer;

	public void addDataFromUser(String userData) {
		serviceLayer.doServiceLogic(userData);
	}

	public void addDataFromUserHack(String userData) {
		persistenceLayer.storeToDatabase(userData);
	}

}
