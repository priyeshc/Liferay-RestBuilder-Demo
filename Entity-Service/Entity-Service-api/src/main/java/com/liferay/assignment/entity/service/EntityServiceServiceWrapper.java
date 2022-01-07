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
 * Provides a wrapper for {@link EntityServiceService}.
 *
 * @author Brian Wing Shun Chan
 * @see EntityServiceService
 * @generated
 */
public class EntityServiceServiceWrapper
	implements EntityServiceService, ServiceWrapper<EntityServiceService> {

	public EntityServiceServiceWrapper(
		EntityServiceService entityServiceService) {

		_entityServiceService = entityServiceService;
	}

	@Override
	public com.liferay.assignment.entity.model.EntityService addEntityService(
		String name) {

		return _entityServiceService.addEntityService(name);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _entityServiceService.getOSGiServiceIdentifier();
	}

	@Override
	public EntityServiceService getWrappedService() {
		return _entityServiceService;
	}

	@Override
	public void setWrappedService(EntityServiceService entityServiceService) {
		_entityServiceService = entityServiceService;
	}

	private EntityServiceService _entityServiceService;

}