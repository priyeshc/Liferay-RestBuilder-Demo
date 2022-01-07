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

package com.liferay.assignment.entity.service.persistence.impl;

import com.liferay.assignment.entity.exception.NoSuchEntityServiceException;
import com.liferay.assignment.entity.model.EntityService;
import com.liferay.assignment.entity.model.impl.EntityServiceImpl;
import com.liferay.assignment.entity.model.impl.EntityServiceModelImpl;
import com.liferay.assignment.entity.service.persistence.EntityServicePersistence;
import com.liferay.assignment.entity.service.persistence.impl.constants.entityServicePersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the entity service service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EntityServicePersistence.class)
public class EntityServicePersistenceImpl
	extends BasePersistenceImpl<EntityService>
	implements EntityServicePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EntityServiceUtil</code> to access the entity service persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EntityServiceImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public EntityServicePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EntityService.class);

		setModelImplClass(EntityServiceImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the entity service in the entity cache if it is enabled.
	 *
	 * @param entityService the entity service
	 */
	@Override
	public void cacheResult(EntityService entityService) {
		entityCache.putResult(
			EntityServiceImpl.class, entityService.getPrimaryKey(),
			entityService);
	}

	/**
	 * Caches the entity services in the entity cache if it is enabled.
	 *
	 * @param entityServices the entity services
	 */
	@Override
	public void cacheResult(List<EntityService> entityServices) {
		for (EntityService entityService : entityServices) {
			if (entityCache.getResult(
					EntityServiceImpl.class, entityService.getPrimaryKey()) ==
						null) {

				cacheResult(entityService);
			}
		}
	}

	/**
	 * Clears the cache for all entity services.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EntityServiceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the entity service.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EntityService entityService) {
		entityCache.removeResult(EntityServiceImpl.class, entityService);
	}

	@Override
	public void clearCache(List<EntityService> entityServices) {
		for (EntityService entityService : entityServices) {
			entityCache.removeResult(EntityServiceImpl.class, entityService);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EntityServiceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new entity service with the primary key. Does not add the entity service to the database.
	 *
	 * @param id the primary key for the new entity service
	 * @return the new entity service
	 */
	@Override
	public EntityService create(int id) {
		EntityService entityService = new EntityServiceImpl();

		entityService.setNew(true);
		entityService.setPrimaryKey(id);

		return entityService;
	}

	/**
	 * Removes the entity service with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the entity service
	 * @return the entity service that was removed
	 * @throws NoSuchEntityServiceException if a entity service with the primary key could not be found
	 */
	@Override
	public EntityService remove(int id) throws NoSuchEntityServiceException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the entity service with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the entity service
	 * @return the entity service that was removed
	 * @throws NoSuchEntityServiceException if a entity service with the primary key could not be found
	 */
	@Override
	public EntityService remove(Serializable primaryKey)
		throws NoSuchEntityServiceException {

		Session session = null;

		try {
			session = openSession();

			EntityService entityService = (EntityService)session.get(
				EntityServiceImpl.class, primaryKey);

			if (entityService == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntityServiceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(entityService);
		}
		catch (NoSuchEntityServiceException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EntityService removeImpl(EntityService entityService) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(entityService)) {
				entityService = (EntityService)session.get(
					EntityServiceImpl.class, entityService.getPrimaryKeyObj());
			}

			if (entityService != null) {
				session.delete(entityService);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (entityService != null) {
			clearCache(entityService);
		}

		return entityService;
	}

	@Override
	public EntityService updateImpl(EntityService entityService) {
		boolean isNew = entityService.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(entityService);
			}
			else {
				entityService = (EntityService)session.merge(entityService);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EntityServiceImpl.class, entityService, false, true);

		if (isNew) {
			entityService.setNew(false);
		}

		entityService.resetOriginalValues();

		return entityService;
	}

	/**
	 * Returns the entity service with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the entity service
	 * @return the entity service
	 * @throws NoSuchEntityServiceException if a entity service with the primary key could not be found
	 */
	@Override
	public EntityService findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntityServiceException {

		EntityService entityService = fetchByPrimaryKey(primaryKey);

		if (entityService == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntityServiceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return entityService;
	}

	/**
	 * Returns the entity service with the primary key or throws a <code>NoSuchEntityServiceException</code> if it could not be found.
	 *
	 * @param id the primary key of the entity service
	 * @return the entity service
	 * @throws NoSuchEntityServiceException if a entity service with the primary key could not be found
	 */
	@Override
	public EntityService findByPrimaryKey(int id)
		throws NoSuchEntityServiceException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the entity service with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the entity service
	 * @return the entity service, or <code>null</code> if a entity service with the primary key could not be found
	 */
	@Override
	public EntityService fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the entity services.
	 *
	 * @return the entity services
	 */
	@Override
	public List<EntityService> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<EntityService> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<EntityService> findAll(
		int start, int end,
		OrderByComparator<EntityService> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<EntityService> findAll(
		int start, int end, OrderByComparator<EntityService> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<EntityService> list = null;

		if (useFinderCache) {
			list = (List<EntityService>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ENTITYSERVICE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ENTITYSERVICE;

				sql = sql.concat(EntityServiceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EntityService>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the entity services from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EntityService entityService : findAll()) {
			remove(entityService);
		}
	}

	/**
	 * Returns the number of entity services.
	 *
	 * @return the number of entity services
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ENTITYSERVICE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ENTITYSERVICE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EntityServiceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the entity service persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new EntityServiceModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EntityService.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EntityServiceImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = entityServicePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = entityServicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = entityServicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ENTITYSERVICE =
		"SELECT entityService FROM EntityService entityService";

	private static final String _SQL_COUNT_ENTITYSERVICE =
		"SELECT COUNT(entityService) FROM EntityService entityService";

	private static final String _ORDER_BY_ENTITY_ALIAS = "entityService.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EntityService exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		EntityServicePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class EntityServiceModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			EntityServiceModelImpl entityServiceModelImpl =
				(EntityServiceModelImpl)baseModel;

			long columnBitmask = entityServiceModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(entityServiceModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						entityServiceModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(entityServiceModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EntityServiceModelImpl entityServiceModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						entityServiceModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = entityServiceModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}