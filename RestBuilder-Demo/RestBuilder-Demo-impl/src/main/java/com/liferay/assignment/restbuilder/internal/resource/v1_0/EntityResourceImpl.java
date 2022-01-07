package com.liferay.assignment.restbuilder.internal.resource.v1_0;

import com.liferay.assignment.entity.model.EntityService;
import com.liferay.assignment.entity.service.EntityServiceLocalService;
import com.liferay.assignment.restbuilder.dto.v1_0.Entity;
import com.liferay.assignment.restbuilder.resource.v1_0.EntityResource;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Argil DX
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/entity.properties", scope = ServiceScope.PROTOTYPE, service = EntityResource.class)
public class EntityResourceImpl extends BaseEntityResourceImpl {

	@Override
	public Page<Entity> getEntitiesPage() throws Exception {
		// TODO Auto-generated method stub

		List<EntityService> entityServices = _entityServiceLocalService.getAllEmployees();
		List<Entity> entities = new ArrayList<Entity>();

		// entities = entityServices;

		for (EntityService es : entityServices) {

			Entity entity = new Entity();
			entity.setId(es.getId());
			entity.setName(es.getName());
			entities.add(entity);

		}

		return Page.of(entities);
	}

	@Override
	public Entity getEntity(@NotNull Integer entityId) throws Exception {
		// TODO Auto-generated method stub
		return super.getEntity(entityId);
	}

	@Override
	public void deleteEntity(@NotNull Integer entityId) throws Exception {
		// TODO Auto-generated method stub
		super.deleteEntity(entityId);
	}

	@Override
	public Entity putEntity(@NotNull Integer entityId, Entity entity) throws Exception {
		// TODO Auto-generated method stub
		return super.putEntity(entityId, entity);
	}

	@Override
	public Entity postEntity(Entity entity) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Post called");
		return entity;
	}

	@Reference
	EntityServiceLocalService _entityServiceLocalService;

}