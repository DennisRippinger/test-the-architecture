package de.drippinger.cycle.ui;

import de.drippinger.cycle.service.ServiceLayer;

/**
 * UiLayer
 *
 * @author Dennis Rippinger
 */
public class UiLayer {

	private ServiceLayer serviceLayer;

	private boolean valueStores = false;

	public void addDataFromUser(String userData) {
		serviceLayer.doServiceLogic(userData);
	}

	public void setValueStores(boolean valueStores) {
		this.valueStores = valueStores;
	}
}
