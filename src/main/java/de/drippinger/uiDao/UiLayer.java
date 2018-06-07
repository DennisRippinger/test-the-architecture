package de.drippinger.uiDao;

import de.drippinger.layer.service.ServiceLayer;

import javax.persistence.EntityManager;

/**
 * UiLayer
 *
 * @author Dennis Rippinger
 */
public class UiLayer {

	private ServiceLayer serviceLayer;

	private EntityManager em;

	public void addDataFromUser(String userData) {
		serviceLayer.doServiceLogic(userData);
	}

	public void addDataFromUserHack(String userData) {
		em.persist(userData);
	}

}
