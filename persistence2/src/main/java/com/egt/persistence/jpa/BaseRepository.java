package com.egt.persistence.jpa;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.bean.Criteria;
import com.egt.persistence.bean.PagingBean;

import java.util.List;

public interface BaseRepository {

	public static final String ENTITY_MODEL_ALIAS = "model";
	/**
	 * Save method that make an entity instance managed and persistent. 
	 * @param entity - Entity object.
	 * @throws DatabaseException
	 */
	public void save(Object entity) throws DatabaseException;
	/**
	 * Update method that merge the state of the given entity into the current persistence context. 
	 * @param entity - Instant of an entity.
	 * @return The instance that the state was merged to .
	 * @throws DatabaseException
	 */
	public Object update(Object entity) throws DatabaseException;
	
	public int update(final String jpql);
	
	public int update(final String jpql, Object... params);
	/**
	 * Delete method that remove the entity instance. 
	 * @param entity- Instant of an entity.
	 * @throws DatabaseException
	 */
	public void delete(Object entity) throws DatabaseException;
	/**
	 * Find by primary key. 
	 * @param clazz - Entity class
	 * @param id - Primary key of entity class
	 * @return The found entity instance or null if the entity does not exist 
	 * @throws DatabaseException
	 */
	public Object findById(Class<?> clazz, Object id) throws DatabaseException;
	/**
	 * Find by property name. 
	 * Use with single property only and beware SQL injection in property name.
	 * @param clazz
	 * @param propertyName
	 * @param value
	 * @return
	 * @throws DatabaseException
	 */
	public List<? extends Object> findByProperty(Class<?> clazz, final String propertyName, final Object value) throws DatabaseException;
	/**
	 * Execute a query based on the given example entity object. 
	 * @param example
	 * @return
	 * @throws DatabaseException
	 */
	public List<? extends Object> findByExample(final Object example) throws DatabaseException;
	/**
	 * Execute a query based on the given example entity object. 
	 * Beware SQL injection in extraWhereClause.
	 * @param example - Entity object.
	 * @param extraWhereClause
	 * @return
	 * @throws DatabaseException
	 */
	public List<? extends Object> findByExample(final Object example, final String extraWhereClause) throws DatabaseException;
	/**
	 * Execute a query based on the given example entity object. Control paging by pagingBean.
	 * @param example - Entity object.
	 * @param pagingBean
	 * @return
	 * @throws DatabaseException
	 */
	public List<? extends Object> findByExample(final Object example, PagingBean pagingBean) throws DatabaseException;
	/**
	 * Execute a query based on the given example entity object. Control paging by pagingBean.
	 * Beware SQL injection in extraWhereClause.
	 * @param example
	 * @param pagingBean
	 * @param extraWhereClause
	 * @return
	 * @throws DatabaseException
	 */
	public List<? extends Object> findByExample(final Object example, PagingBean pagingBean, final String extraWhereClause) throws DatabaseException;
	
	public List<? extends Object> findByExampleLike( final Object example ) throws DatabaseException;

	public List<? extends Object> findByExampleLike( final Object example, final String extraWhereClause ) throws DatabaseException;

	public List<? extends Object> findByExampleLike( final Object example, PagingBean pagingBean ) throws DatabaseException;

	public List<? extends Object> findByExampleLike( final Object example, PagingBean pagingBean, final String extraWhereClause ) throws DatabaseException;
	/**
	 * Find all. 
	 * @param clazz
	 * @return
	 * @throws DatabaseException
	 */
	public List<? extends Object> findAll(Class<?> clazz) throws DatabaseException;
	/**
	 * Find all. Control paging by pagingBean.
	 * @param clazz
	 * @param pagingBean
	 * @return
	 * @throws DatabaseException
	 */
	public List<? extends Object> findAll(Class<?> clazz, PagingBean pagingBean) throws DatabaseException;
	
	public List<? extends Object> query(String jpql);
	
	public List<? extends Object> query(String jpql, final Object... params) throws DatabaseException;
	
	public List<? extends Object> query(String jpql, String jpqlCount, PagingBean pagingBean, Object... params)throws DatabaseException;

	public List<? extends Object> query(String jpql, final List<Criteria> list) throws DatabaseException;
	
	public List<? extends Object> query(String jpql, String jpqlCount, PagingBean pagingBean, final List<Criteria> criteriaList) throws DatabaseException;
	
	public List<? extends Object> queryLike(String jpql, final List<Criteria> criteriaList ) throws DatabaseException;
	
	public List<? extends Object> queryLike(String jpql, String jpqlCount, final List<Criteria> criteriaList, PagingBean pagingBean ) throws DatabaseException;

	public Object querySingleResult(String jpql) throws DatabaseException;
	
	public Object querySingleResult(String jpql, Object... params);
	
	public Object querySingleResult(String jpql, final List<Criteria> list) throws DatabaseException;
	
	public int executeBatch(String sql);
	
	public int executeNativeSQL(String sql);
	
	public int executeNativeSQL(String sql, Object... params);
	
	public List<? extends Object> nativeQuery(String sql) ;
	
	public List<? extends Object> nativeQuery(String sql, Class<?> clazz);
	
	public List<? extends Object> nativeQuery(String sql, Class<?> clazz, Object... params);
	
	public List<? extends Object> nativeQuery(String sql, Class<?> clazz, PagingBean pagingBean);

	public List<? extends Object> nativeQuery(String sql, Class<?> clazz, PagingBean pagingBean, Object... params);
	
	public Object nativeQuerySingleResult(String sql);
	
	public Object nativeQuerySingleResult(String sql, Object... params);
	
	public void flush();
	
	public void clear();
	
	public void refresh(Object entity);

	public Long getGeneratedValueBySequenceName(String sequenceName);
	
	public List<? extends Object> namedNativeQuery(String name, String[] paramNames, Object... params);
	
	public List<? extends Object> nativeQuery(String sql, String nameMapping, PagingBean pagingBean, String defaultOrder);
	
	public List<? extends Object> nativeQuery(String sql, Class c, String[] paramNames, Object... params);
	
	public List<? extends Object> nativeQuery(String sql, String nameMapping);
    public Object findSingleByExample( final Object example ) throws DatabaseException;

}
