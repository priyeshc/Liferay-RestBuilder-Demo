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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.assignment.entity.service.http.EntityServiceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EntityServiceSoap implements Serializable {

	public static EntityServiceSoap toSoapModel(EntityService model) {
		EntityServiceSoap soapModel = new EntityServiceSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static EntityServiceSoap[] toSoapModels(EntityService[] models) {
		EntityServiceSoap[] soapModels = new EntityServiceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EntityServiceSoap[][] toSoapModels(EntityService[][] models) {
		EntityServiceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EntityServiceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EntityServiceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EntityServiceSoap[] toSoapModels(List<EntityService> models) {
		List<EntityServiceSoap> soapModels = new ArrayList<EntityServiceSoap>(
			models.size());

		for (EntityService model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EntityServiceSoap[soapModels.size()]);
	}

	public EntityServiceSoap() {
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int pk) {
		setId(pk);
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private int _id;
	private String _name;

}