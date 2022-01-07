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

package com.liferay.assignment.entity.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EntityServiceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EntityServiceLocalService
 * @generated
 */
public class EntityServiceLocalServiceWrapper
	implements EntityServiceLocalService,
			   ServiceWrapper<EntityServiceLocalService> {

	public EntityServiceLocalServiceWrapper(
		EntityServiceLocalService entityServiceLocalService) {

		_entityServiceLocalService = entityServiceLocalService;
	}

	/**
	 * Adds the entity service to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EntityServiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityService the entity service
	 * @return the entity service that was added
	 */
	@Override
	public com.liferay.assignment.entity.model.EntityService addEntityService(
		com.liferay.assignment.entity.model.EntityService entityService) {

		return _entityServiceLocalService.addEntityService(entityService);
	}

	@Override
	public com.liferay.assignment.entity.model.EntityService addEntityService(
		String name) {

		return _entityServiceLocalService.addEntityService(name);
	}

	/**
	 * Creates a new entity service with the primary key. Does not add the entity service to the database.
	 *
	 * @param id the primary key for the new entity service
	 * @return the new entity service
	 */
	@Override
	public com.liferay.assignment.entity.model.EntityService
		createEntityService(int id) {

		return _entityServiceLocalService.createEntityService(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _entityServiceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the entity service from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EntityServiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityService the entity service
	 * @return the entity service that was removed
	 */
	@Override
	public com.liferay.assignment.entity.model.EntityService
		deleteEntityService(
			com.liferay.assignment.entity.model.EntityService entityService) {

		return _entityServiceLocalService.deleteEntityService(entityService);
	}

	/**
	 * Deletes the entity service with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EntityServiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the entity service
	 * @return the entity service that was removed
	 * @throws PortalException if a entity service with the primary key could not be found
	 */
	@Override
	public com.liferay.assignment.entity.model.EntityService
			deleteEntityService(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _entityServiceLocalService.deleteEntityService(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _entityServiceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _entityServiceLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _entityServiceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.assignment.entity.model.impl.EntityServiceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _entityServiceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.assignment.entity.model.impl.EntityServiceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _entityServiceLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _entityServiceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _entityServiceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.assignment.entity.model.EntityService fetchEntityService(
		int id) {

		return _entityServiceLocalService.fetchEntityService(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _entityServiceLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.assignment.entity.model.EntityService>
		getAllEmployees() {

		return _entityServiceLocalService.getAllEmployees();
	}

	/**
	 * Returns the entity service with the primary key.
	 *
	 * @param id the primary key of the entity service
	 * @return the entity service
	 * @throws PortalException if a entity service with the primary key could not be found
	 */
	@Override
	public com.liferay.assignment.entity.model.EntityService getEntityService(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _entityServiceLocalService.getEntityService(id);
	}

	/**
	 * Returns a range of all the entity services.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.assignment.entity.model.impl.EntityServiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entity services
	 * @param end the upper bound of the range of entity services (not inclusive)
	 * @return the range of entity services
	 */
	@Override
	public java.util.List<com.liferay.assignment.entity.model.EntityService>
		getEntityServices(int start, int end) {

		return _entityServiceLocalService.getEntityServices(start, end);
	}

	/**
	 * Returns the number of entity services.
	 *
	 * @return the number of entity services
	 */
	@Override
	public int getEntityServicesCount() {
		return _entityServiceLocalService.getEntityServicesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _entityServiceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _entityServiceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _entityServiceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the entity service in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EntityServiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityService the entity service
	 * @return the entity service that was updated
	 */
	@Override
	public com.liferay.assignment.entity.model.EntityService
		updateEntityService(
			com.liferay.assignment.entity.model.EntityService entityService) {

		return _entityServiceLocalService.updateEntityService(entityService);
	}

	@Override
	public EntityServiceLocalService getWrappedService() {
		return _entityServiceLocalService;
	}

	@Override
	public void setWrappedService(
		EntityServiceLocalService entityServiceLocalService) {

		_entityServiceLocalService = entityServiceLocalService;
	}

	private EntityServiceLocalService _entityServiceLocalService;

}