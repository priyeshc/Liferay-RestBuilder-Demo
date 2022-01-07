/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.assignment.entity.service.persistence;

import com.liferay.assignment.entity.exception.NoSuchEntityServiceException;
import com.liferay.assignment.entity.model.EntityService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the entity service service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityServiceUtil
 * @generated
 */
@ProviderType
public interface EntityServicePersistence
	extends BasePersistence<EntityService> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EntityServiceUtil} to access the entity service persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the entity service in the entity cache if it is enabled.
	 *
	 * @param entityService the entity service
	 */
	public void cacheResult(EntityService entityService);

	/**
	 * Caches the entity services in the entity cache if it is enabled.
	 *
	 * @param entityServices the entity services
	 */
	public void cacheResult(java.util.List<EntityService> entityServices);

	/**
	 * Creates a new entity service with the primary key. Does not add the entity service to the database.
	 *
	 * @param id the primary key for the new entity service
	 * @return the new entity service
	 */
	public EntityService create(int id);

	/**
	 * Removes the entity service with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the entity service
	 * @return the entity service that was removed
	 * @throws NoSuchEntityServiceException if a entity service with the primary key could not be found
	 */
	public EntityService remove(int id) throws NoSuchEntityServiceException;

	public EntityService updateImpl(EntityService entityService);

	/**
	 * Returns the entity service with the primary key or throws a <code>NoSuchEntityServiceException</code> if it could not be found.
	 *
	 * @param id the primary key of the entity service
	 * @return the entity service
	 * @throws NoSuchEntityServiceException if a entity service with the primary key could not be found
	 */
	public EntityService findByPrimaryKey(int id)
		throws NoSuchEntityServiceException;

	/**
	 * Returns the entity service with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the entity service
	 * @return the entity service, or <code>null</code> if a entity service with the primary key could not be found
	 */
	public EntityService fetchByPrimaryKey(int id);

	/**
	 * Returns all the entity services.
	 *
	 * @return the entity services
	 */
	public java.util.List<EntityService> findAll();

	/**
	 * Returns a range of all the entity services.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EntityServiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entity services
	 * @param end the upper bound of the range of entity services (not inclusive)
	 * @return the range of entity services
	 */
	public java.util.List<EntityService> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the entity services.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EntityServiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entity services
	 * @param end the upper bound of the range of entity services (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of entity services
	 */
	public java.util.List<EntityService> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EntityService>
			orderByComparator);

	/**
	 * Returns an ordered range of all the entity services.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EntityServiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entity services
	 * @param end the upper bound of the range of entity services (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of entity services
	 */
	public java.util.List<EntityService> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EntityService>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the entity services from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of entity services.
	 *
	 * @return the number of entity services
	 */
	public int countAll();

}