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

package com.liferay.assignment.entity.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EntityService}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityService
 * @generated
 */
public class EntityServiceWrapper
	extends BaseModelWrapper<EntityService>
	implements EntityService, ModelWrapper<EntityService> {

	public EntityServiceWrapper(EntityService entityService) {
		super(entityService);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	 * Returns the ID of this entity service.
	 *
	 * @return the ID of this entity service
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this entity service.
	 *
	 * @return the name of this entity service
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this entity service.
	 *
	 * @return the primary key of this entity service
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this entity service.
	 *
	 * @param id the ID of this entity service
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the name of this entity service.
	 *
	 * @param name the name of this entity service
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this entity service.
	 *
	 * @param primaryKey the primary key of this entity service
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected EntityServiceWrapper wrap(EntityService entityService) {
		return new EntityServiceWrapper(entityService);
	}

}