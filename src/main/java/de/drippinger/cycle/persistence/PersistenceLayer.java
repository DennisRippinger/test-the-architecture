package de.drippinger.cycle.persistence;

import de.drippinger.cycle.ui.UiLayer;

/**
 * PeristenceLayer
 *
 * @author Dennis Rippinger
 */
public class PersistenceLayer {

	private UiLayer uiLayer;


	public void storeToDatabase(String userData) {
		// Log is enough :P
		System.out.printf(userData);

		// Layer violation
		uiLayer.setValueStores(true);
	}

}
