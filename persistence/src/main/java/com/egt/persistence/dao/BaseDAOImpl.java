package com.egt.persistence.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.bean.Criteria;
import com.egt.persistence.bean.PagingBean;
import com.egt.persistence.bean.PagingBean.Order;
import com.egt.persistence.util.QueryHelper;

public class BaseDAOImpl implements BaseDAO{
	/**
	 * Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(BaseDAOImpl.class);
	
	protected EntityManager entityManager;

	@Required
    @PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
    protected String genQueryStringByExample( Class<?> clazz, List<Criteria> criteriaList, List<Order> orderList ) throws Exception{
    	return genQueryStringByExample( clazz, criteriaList, orderList, null );
    }
    
    protected String genQueryStringByExample( Class<?> clazz, List<Criteria> criteriaList, List<Order> orderList, String extraWhereClause ) throws Exception{
				
		StringBuilder queryString = new StringBuilder();
		queryString.append( "select model from " + clazz.getSimpleName() + " model " );
		if( criteriaList != null && criteriaList.size() > 0 ){
			queryString.append(" where 1 = 1 ");
			for( Criteria criteria : criteriaList ){
				queryString.append(" AND model." + criteria.getColumn() + " = :" + criteria.getParam() );
			}				
		}
		
		if( extraWhereClause != null && extraWhereClause.length() > 0 ){
			if( criteriaList == null || criteriaList.size() <= 0 ){
				queryString.append(" where 1 = 1 ");
			}			
			queryString.append(extraWhereClause);
		}
		
		if( orderList != null && orderList.size() > 0 ){
			queryString.append(" order by ");
			int i = 0;
			for( Order order : orderList ){
				queryString.append( BaseDAO.ENTITY_MODEL_ALIAS + "." + order.getOrderBy() + " " + order.getOrderMode() + ",");
				i++;
			}
			queryString.deleteCharAt(queryString.length()-1);
		}
		
		return queryString.toString();
	}

    protected String genQueryStringByExampleLike( Class<?> clazz, List<Criteria> criteriaList, List<Order> orderList ) throws Exception{
    	return genQueryStringByExampleLike( clazz, criteriaList, orderList, null );
    }	

    protected String genQueryStringByExampleLike( Class<?> clazz, List<Criteria> criteriaList, List<Order> orderList, String extraWhereClause ) throws Exception{
		
		StringBuilder queryString = new StringBuilder();
		queryString.append( "select model from " + clazz.getSimpleName() + " model " );
		if( criteriaList != null && criteriaList.size() > 0 ){
			queryString.append(" where 1 = 1 ");
			for( Criteria criteria : criteriaList ){
				if( criteria.getValue().getClass().equals(java.lang.String.class) ){
					queryString.append(" AND UPPER(model." + criteria.getColumn() + ") LIKE :" + criteria.getParam() + " ");
				}
				else{
					queryString.append(" AND model." + criteria.getColumn() + " = :" + criteria.getParam() + " ");
				}					
			}				
		}
		
		if( extraWhereClause != null && extraWhereClause.length() > 0 ){
			if( criteriaList == null || criteriaList.size() <= 0 ){
				queryString.append(" where 1 = 1 ");
			}
			queryString.append(extraWhereClause);
		}		
		
		if( orderList != null && orderList.size() > 0 ){
			queryString.append(" order by ");
			int i = 0;
			for( Order order : orderList ){
				queryString.append( BaseDAO.ENTITY_MODEL_ALIAS + "." + order.getOrderBy() + " " + order.getOrderMode() + ",");
				i++;
			}
			queryString.deleteCharAt(queryString.length()-1);
		}
		
		return queryString.toString();
	}	
	
    protected Query genQueryByExample( String queryString, List<Criteria> criteriaList, List<Order> orderList ) throws Exception{
		
		Query query = entityManager.createQuery(queryString);
		if( criteriaList != null && criteriaList.size() > 0 ){
			for( Criteria param : criteriaList ){
				param.getColumn();
				if (logger.isDebugEnabled()) {
					logger.debug("genQueryByExample() - param="
									+ param.getColumn()+", "+ param.getValue());
				}
				query.setParameter( param.getColumn(), param.getValue());
			}				
		}
		/*		
		if( orderList != null ){
			int i = 0;
			for( Order order : orderList ){
				query.setParameter( "ORDERBY" + i, order.getOrderBy() );
				i++;
			}
		}
		*/
		return query;
	}
	
    protected Query genQueryByExampleLike( String queryString, List<Criteria> criteriaList, List<Order> orderList ) throws Exception{
		
		Query query = entityManager.createQuery(queryString.toString());
		if( criteriaList != null && criteriaList.size() > 0 ){
			for( Criteria criteria : criteriaList ){
				if( criteria.getValue().getClass().equals(java.lang.String.class) ){
					query.setParameter( criteria.getColumn(), "%"+((String)criteria.getValue()).toUpperCase()+"%");
				}
				else{
					query.setParameter( criteria.getColumn(), criteria.getValue());
				}
			}				
		}
		/*		
		if( orderList != null ){
			int i = 0;
			for( Order order : orderList ){
				query.setParameter( "ORDERBY" + i, order.getOrderBy() );
				i++;
			}
		}
		*/
		return query;
	}	
	
    protected Long getTotalRowsByExample( Class<?> clazz, List<Criteria> criteriaList ){
		StringBuilder countQueryString = new StringBuilder();
		countQueryString.append( "select count(*) from " + clazz.getSimpleName() + " model " );
		if( criteriaList != null && criteriaList.size() > 0 ){
			countQueryString.append(" where 1 = 1 ");			
			for( Criteria param : criteriaList ){
				countQueryString.append(" AND model." + param.getColumn() + " = :" + param.getParam() );
			}				
		}
					
		Query countQuery = entityManager.createQuery(countQueryString.toString());
		if( criteriaList != null && criteriaList.size() > 0 ){
			for( Criteria param : criteriaList ){
				countQuery.setParameter( param.getColumn(), param.getValue());
			}				
		}		
		
		return (Long)countQuery.getSingleResult();
	}	
	
    protected Long getTotalRowsByExample( Class<?> clazz, List<Criteria> criteriaList, String extraWhereClause ){
		StringBuilder countQueryString = new StringBuilder();
		countQueryString.append( "select count(*) from " + clazz.getSimpleName() + " model " );
		if( criteriaList != null && criteriaList.size() > 0 ){
			countQueryString.append(" where 1 = 1 ");			
			for( Criteria param : criteriaList ){
				countQueryString.append(" AND model." + param.getColumn() + " = :" + param.getParam() + " " );
			}				
		}
		
		if( extraWhereClause != null && extraWhereClause.length() > 0 ){
			if( criteriaList == null || criteriaList.size() <= 0 ){
				countQueryString.append(" where 1 = 1 ");
			}
			countQueryString.append(extraWhereClause);
		}	
					
		Query countQuery = entityManager.createQuery(countQueryString.toString());
		if( criteriaList != null && criteriaList.size() > 0 ){
			for( Criteria param : criteriaList ){
				countQuery.setParameter( param.getColumn(), param.getValue());
			}				
		}		
		
		return (Long)countQuery.getSingleResult();
	}	
	
    protected Long getTotalRowsByExampleLike( Class<?> clazz, List<Criteria> criteriaList, String extraWhereClause ){
		StringBuilder countQueryString = new StringBuilder();
		countQueryString.append( "select count(*) from " + clazz.getSimpleName() + " model " );
		if( criteriaList != null && criteriaList.size() > 0 ){
			countQueryString.append(" where 1 = 1 ");			
			for( Criteria param : criteriaList ){
				if( param.getValue().getClass().equals(java.lang.String.class) ){
					countQueryString.append(" AND UPPER(model." + param.getColumn() + ") LIKE :" + param.getParam() + " ");
				}
				else{
					countQueryString.append(" AND model." + param.getColumn() + " = :" + param.getParam() + " ");
				}
			}				
		}
		
		if( extraWhereClause != null && extraWhereClause.length() > 0 ){
			if( criteriaList == null || criteriaList.size() <= 0 ){
				countQueryString.append(" where 1 = 1 ");
			}
			countQueryString.append(extraWhereClause);
		}	
					
		Query countQuery = entityManager.createQuery(countQueryString.toString());
		if( criteriaList != null && criteriaList.size() > 0 ){
			for( Criteria param : criteriaList ){
				if( param.getValue().getClass().equals(java.lang.String.class) ){
					countQuery.setParameter( param.getColumn(), "%"+((String)param.getValue()).toUpperCase()+"%");
				}
				else{
					countQuery.setParameter( param.getColumn(), param.getValue());
				}
			}				
		}		
		
		return (Long)countQuery.getSingleResult();
	}
    
    public void save(Object entity) throws DatabaseException {
		try {
			entityManager.persist( entity ); // Change persist to merge {Prueak}
			if(logger.isDebugEnabled()) {
				logger.debug(entity.getClass().getSimpleName()+" persist successful");
			}
		} catch (RuntimeException re) {
			if(logger.isErrorEnabled()) {
				logger.error("persist failed", re);
			}
			throw new DatabaseException(re);
		}
	}
	

    public Object update(Object entity) throws DatabaseException {
		try {
			Object result = entityManager.merge(entity);
			if(logger.isDebugEnabled()) {
				logger.debug(entity.getClass().getSimpleName()+" merge successful");
			}
			return result;
		} catch (DataIntegrityViolationException re) { 
			if(logger.isErrorEnabled()) {
				logger.error("persist failed", re);
			}
			throw new DatabaseException(re);
		} catch (RuntimeException re) {
			if(logger.isErrorEnabled()) {
				logger.error("merge failed", re);
			}
			throw new DatabaseException(re);
		}
	}
    

    public int update(final String jpql) {
		return entityManager.createQuery(jpql).executeUpdate();
	}
    

    public int update(final String jpql, Object... params) {
		Query q = entityManager.createQuery(jpql);
		for(int i=0; i<params.length;i++) {
			q.setParameter(i+1, params[i]);
		}
		return q.executeUpdate();
	}

	public void delete(Object entity) throws DatabaseException {
		try {
			entity = entityManager.merge(entity);
			entityManager.remove( entity );
			if(logger.isDebugEnabled()) {
				logger.debug(entity.getClass().getSimpleName()+" remove successful");
			}
		} catch (RuntimeException re) {
			if(logger.isErrorEnabled()) {
				logger.error(re);
			}
			throw re;
		}
	}

	public Object findById(Class<?> clazz, Object id) throws DatabaseException {
		try {
			Object instance = entityManager.find(clazz,id);
			return instance;
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw new DatabaseException(re);
		}
	}

	public List<? extends Object> findByProperty( Class<?> clazz, String propertyName, final Object value ) throws DatabaseException {
		try {
			final String queryString = "select model from " + clazz.getSimpleName() + " model where model."
					+ propertyName + "= :propertyValue";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException e) {
			throw new DatabaseException(e);
		}
	}	

	public List<? extends Object> findByExample( final Object example ) throws DatabaseException{	
		return findByExample( example, null, null );
	}	

	public List<? extends Object> findByExample( final Object example, final String extraWhereClause ) throws DatabaseException{	
		return findByExample( example, null, extraWhereClause );
	}		

	public List<? extends Object> findByExample( final Object example, PagingBean pagingBean ) throws DatabaseException{	
		return findByExample( example, pagingBean, null );
	}		

    @SuppressWarnings("unchecked")
	public List<? extends Object> findByExample( final Object example, PagingBean pagingBean, final String extraWhereClause ) throws DatabaseException {

		try {			
		
			if( pagingBean == null ){
				
				List<Criteria> parameterList = QueryHelper.beanToParameterList( example );
				
				String queryString = genQueryStringByExample( example.getClass(), parameterList, null, extraWhereClause );						
				Query query = genQueryByExample(queryString, parameterList, null);
					
				return query.getResultList();
			} else {
				
				List<Criteria> parameterList = QueryHelper.beanToParameterList( example );
							
				pagingBean.setTotalRows( getTotalRowsByExample(example.getClass(), parameterList, extraWhereClause) );
				
				String queryString = genQueryStringByExample( example.getClass(), parameterList, pagingBean.getOrderList(), extraWhereClause );						
				Query query = genQueryByExample(queryString, parameterList, pagingBean.getOrderList() );			
				
				query.setFirstResult( (int)pagingBean.getOffsetBegin() )
					 .setMaxResults( pagingBean.getRowsPerPage() );
				
				return query.getResultList();
			}			
		} catch( Exception e ) {
			throw new DatabaseException(e);
		} 		
	}		

	public List<? extends Object> findByExampleLike( final Object example ) throws DatabaseException{
		return findByExampleLike( example, null, null );
	}	

	public List<? extends Object> findByExampleLike( final Object example, final String extraWhereClause ) throws DatabaseException{
		return findByExampleLike( example, null, extraWhereClause );
	}	

	public List<? extends Object> findByExampleLike( final Object example, PagingBean pagingBean ) throws DatabaseException{
		return findByExampleLike( example, pagingBean, null );
	}	

    @SuppressWarnings("unchecked")
	public List<? extends Object> findByExampleLike( final Object example, PagingBean pagingBean, final String extraWhereClause ) throws DatabaseException {

		try {			
		
			if( pagingBean == null ) {
				List<Criteria> parameterList = QueryHelper.beanToParameterList( example ); 
					
				String queryString = genQueryStringByExampleLike( example.getClass(), parameterList, null, extraWhereClause );						
				Query query = genQueryByExampleLike(queryString, parameterList, null);
				return query.getResultList();
			} else {
				List<Criteria> parameterList = QueryHelper.beanToParameterList( example );
							
				pagingBean.setTotalRows( getTotalRowsByExampleLike(example.getClass(), parameterList, extraWhereClause) );
				
				String queryString = genQueryStringByExampleLike( example.getClass(), parameterList, pagingBean.getOrderList(), extraWhereClause );						
				Query query = genQueryByExampleLike(queryString, parameterList, pagingBean.getOrderList() );			
				
				query.setFirstResult( (int)pagingBean.getOffsetBegin() )
					 .setMaxResults( pagingBean.getRowsPerPage() );
				
				return query.getResultList();
			}			
		}
		catch( Exception e ){
			throw new DatabaseException(e);
		} 		
	}	

    @SuppressWarnings("unchecked")
	public List<? extends Object> findAll( Class<?> clazz ) throws DatabaseException{
		
		try{
			String queryString = genQueryStringByExample( clazz, null, null );						
			Query query = genQueryByExample( queryString, null, null );	
			return query.getResultList();
		}
		catch( Exception e ){
			throw new DatabaseException(e);
		}
	}

    @SuppressWarnings("unchecked")
	public List<? extends Object> findAll( Class<?> clazz, PagingBean pagingBean ) throws DatabaseException{

		if( pagingBean == null ){
			return findAll( clazz );
		} else {
			Query query;			
			
			try{			
				pagingBean.setTotalRows( getTotalRowsByExample( clazz, null ) );
				
				String queryString = genQueryStringByExample( clazz, null, pagingBean.getOrderList() );	
				query = genQueryByExample( queryString, null, null );			
				
				query.setFirstResult( (int)pagingBean.getOffsetBegin() )
					 .setMaxResults( pagingBean.getRowsPerPage() );
			}
			catch( Exception e ){
				throw new DatabaseException(e);
			}			
			
			return query.getResultList();
		}
	}

    @SuppressWarnings("unchecked")
	public List<? extends Object> query(String jpql) {
		return entityManager.createQuery(jpql).getResultList();
	}

    @SuppressWarnings("unchecked")
	public List<? extends Object> query(String jpql, final Object... params) {
		Query q = entityManager.createQuery(jpql);
		for(int i=0; i<params.length;i++) {
			if (logger.isDebugEnabled()) {
				logger.debug(i+":"+params[i]);
			}
			q.setParameter(i+1, params[i]);
		}
		return q.getResultList();
	}

    @SuppressWarnings("unchecked")
	public List<? extends Object> query(String jpql, String jpqlCount, PagingBean pagingBean, Object... params) throws DatabaseException {
		try{				
			
			if( pagingBean == null ){
				return query(jpql, params);
			} else {
				Query countQuery = entityManager.createQuery(jpqlCount);
				for(int i=0; i<params.length;i++) {
					countQuery.setParameter(i+1, params[i]);
				}				
				pagingBean.setTotalRows( (Long)countQuery.getSingleResult() );		
				
				Query query = entityManager.createQuery(jpql);						
				for(int i=0; i<params.length;i++) {
					if (logger.isDebugEnabled()) {
						logger.debug(i+":"+params[i]);
					}
					query.setParameter(i+1, params[i]);
				}									
				query.setFirstResult( (int)pagingBean.getOffsetBegin() )
					 .setMaxResults( pagingBean.getRowsPerPage() );

				return query.getResultList();					
			}
		}
		catch( Exception e ){			
			throw new DatabaseException(e);
		}
	}
    
//    @Deprecated
//	public List<? extends Object> query(String jpql, final List<Criteria> list) {
//		Query q = entityManager.createQuery(jpql);
//		for (Criteria criteria : list) {
//			q.setParameter(criteria.getParam(), criteria.getValue());
//		}
//		return q.getResultList();
//	}

    @SuppressWarnings("unchecked")
	public List<? extends Object> query(String jpql, List<Criteria> list) throws DatabaseException{
		
		try{				
					
			String orderBy = "";		
			int k = jpql.toUpperCase().indexOf("ORDER BY");
			if(  k > -1) {
				orderBy = " " + jpql.substring(k, jpql.length());
				jpql = jpql.substring(0, k);
				
			}

			if( jpql.toUpperCase().indexOf("WHERE") == -1 ){
				jpql += " WHERE 1 = 1 ";
			}

//			if( jpqlCount.toUpperCase().indexOf("WHERE") == -1 ){
//				jpqlCount += " WHERE 1 = 1 ";
//			}
			
			String criteriaString = QueryHelper.genCriteriaString(list); 

//			Query countQuery = entityManager.createQuery(jpqlCount + criteriaString.toString() + orderBy);
//			countQuery = QueryHelper.setParameter(countQuery, list );					
			
			Query query = entityManager.createQuery(jpql + criteriaString.toString() + orderBy);						
			query = QueryHelper.setParameter(query, list, null);												

			return query.getResultList();			
		}
		catch( Exception e ){			
			throw new DatabaseException(e);
		}
	}	

    @SuppressWarnings("unchecked")
	public List<? extends Object> query( String jpql, String jpqlCount, PagingBean pagingBean, List<Criteria> criteriaList ) throws DatabaseException {
		
		try{				
					
			if( pagingBean == null ){
				return query( jpql, criteriaList );
			} else {

				if( jpql.indexOf("WHERE") == -1 ){
					jpql += " WHERE 1 = 1 ";
				}
				if( jpqlCount.indexOf("WHERE") == -1 ){
					jpqlCount += " WHERE 1 = 1 ";
				}
				
				String criteriaString = QueryHelper.genCriteriaString(criteriaList); 
				String orderString = QueryHelper.genOrderString(pagingBean.getOrderList());

				Query countQuery = entityManager.createQuery(jpqlCount + criteriaString.toString());
				countQuery = QueryHelper.setParameter(countQuery, criteriaList );				
				pagingBean.setTotalRows( (Long)countQuery.getSingleResult() );		
				
				Query query = entityManager.createQuery(jpql + criteriaString.toString() + orderString);						
				query = QueryHelper.setParameter(query, criteriaList, pagingBean.getOrderList());												
				query.setFirstResult( (int)pagingBean.getOffsetBegin() ).setMaxResults( pagingBean.getRowsPerPage() );

				return query.getResultList();					
			}
		}
		catch( Exception e ){			
			throw new DatabaseException(e);
		}
	}

    @SuppressWarnings("unchecked")
	public List<? extends Object> queryLike( String jpql, List<Criteria> criteriaList ) throws DatabaseException {
		
		try{				
					
			if( jpql.indexOf("WHERE") == -1 ){
				jpql += " WHERE 1 = 1 ";
			}
//			if( countQueryString.indexOf("WHERE") == -1 ){
//				countQueryString += " WHERE 1 = 1 ";
//			}
			
			String criteriaString = QueryHelper.genCriteriaStringLike(criteriaList); 

//			Query countQuery = entityManager.createQuery(countQueryString + criteriaString.toString());
//			countQuery = QueryHelper.setParameterLike(countQuery, criteriaList );					
			
			Query query = entityManager.createQuery(jpql + criteriaString.toString());						
			query = QueryHelper.setParameterLike(query, criteriaList, null);												
			
			return query.getResultList();			
		}
		catch( Exception e ){			
			throw new DatabaseException(e);
		}
	}		

    @SuppressWarnings("unchecked")
	public List<? extends Object> queryLike( String jpql, String jpqlCount, List<Criteria> criteriaList, PagingBean pagingBean ) throws DatabaseException {
		
		try{				
					
			if( pagingBean == null ){
				return queryLike( jpql, criteriaList );
			}
			else{

				if( jpql.indexOf("WHERE") == -1 ){
					jpql += " WHERE 1 = 1 ";
				}
				if( jpqlCount.indexOf("WHERE") == -1 ){
					jpqlCount += " WHERE 1 = 1 ";
				}
				
				String criteriaString = QueryHelper.genCriteriaStringLike(criteriaList); 
				String orderString = QueryHelper.genOrderString(pagingBean.getOrderList());
				Query countQuery = entityManager.createQuery(jpqlCount + criteriaString.toString());
				countQuery = QueryHelper.setParameterLike(countQuery, criteriaList );				
				pagingBean.setTotalRows( (Long)countQuery.getSingleResult() );		
				
				Query query = entityManager.createQuery(jpql + criteriaString.toString() + orderString);						
				query = QueryHelper.setParameterLike(query, criteriaList, pagingBean.getOrderList());												
				query.setFirstResult( (int)pagingBean.getOffsetBegin() )
					 .setMaxResults( pagingBean.getRowsPerPage() );

				return query.getResultList();					
			}
		}
		catch( Exception e ){			
			throw new DatabaseException(e);
		}
	}	

    public Object querySingleResult(String jpql) {
		return entityManager.createQuery(jpql).getSingleResult();
	}

	public Object querySingleResult(String jpql, Object... params) {
		Query q = entityManager.createQuery(jpql);
		for(int i=0; i<params.length;i++) {
			q.setParameter(i+1, params[i]);
		}
		return q.getSingleResult();
	}

    public Object querySingleResult(String jpql, List<Criteria> list) throws DatabaseException {
		try{				
			
			String orderBy = "";		
			int k = jpql.toUpperCase().indexOf("ORDER BY");
			if(  k > -1) {
				orderBy = " " + jpql.substring(k, jpql.length());
				jpql = jpql.substring(0, k);
				
			}

			if( jpql.toUpperCase().indexOf("WHERE") == -1 ){
				jpql += " WHERE 1 = 1 ";
			}

//			if( jpqlCount.toUpperCase().indexOf("WHERE") == -1 ){
//				jpqlCount += " WHERE 1 = 1 ";
//			}
			
			String criteriaString = QueryHelper.genCriteriaString(list); 

//			Query countQuery = entityManager.createQuery(jpqlCount + criteriaString.toString() + orderBy);
//			countQuery = QueryHelper.setParameter(countQuery, list );					
			
			Query query = entityManager.createQuery(jpql + criteriaString + orderBy);						
			query = QueryHelper.setParameter(query, list, null);												

			return query.getSingleResult();			
		}
		catch( Exception e ){			
			throw new DatabaseException(e);
		}
	}

	public int executeBatch(String sql) {
		return executeNativeSQL(sql.split("\\;"));
	}

	public int executeNativeSQL(String sql) {
		return entityManager.createNativeQuery(sql).executeUpdate();
	}

	public int executeNativeSQL(String sql, Object... params) {
		Query q = entityManager.createNativeQuery(sql);
		for(int i=0; i<params.length;i++) {
			q.setParameter(i+1, params[i]);
		}
		return q.executeUpdate();
	}	
	
	protected int executeNativeSQL(String[] sqlCommands) {
		for (String sqlCommand : sqlCommands) {
			sqlCommand = sqlCommand.trim();
			if(sqlCommand.length() > 0) {
				int r = entityManager.createNativeQuery(sqlCommand).executeUpdate();
				if (logger.isDebugEnabled()) {
					logger.debug(r+":"+sqlCommand);
				}
			}
		}
		return 0;
	}

	public List<? extends Object> nativeQuery(String sql)
	{
		return entityManager.createNativeQuery(sql).getResultList();
	}

	public List<? extends Object> nativeQuery(String sql, Class<?> clazz)
	{
		return entityManager.createNativeQuery(sql, clazz).getResultList();
	}

	public List<? extends Object> nativeQuery(String sql, Class<?> clazz, Object... params) {
		Query q = entityManager.createNativeQuery(sql, clazz);
		for(int i=0; i<params.length;i++) {
			q.setParameter(i+1, params[i]);
		}
		return q.getResultList();
	}

	public List<? extends Object> nativeQuery(String sql, Class<?> clazz, PagingBean pagingBean) {
		
		Query query = entityManager.createNativeQuery(sql, clazz);
		String countQuery = "Select count(*) from ("+sql+") data"; //20091020 by Mix
		Query countQ = entityManager.createNativeQuery(countQuery);
		pagingBean.setTotalRows( ((Number)countQ.getSingleResult()).longValue() );				
		query.setFirstResult( (int)pagingBean.getOffsetBegin() )
			 .setMaxResults( pagingBean.getRowsPerPage() );

		return query.getResultList();					
	}

	public List<? extends Object> nativeQuery(String sql, Class<?> clazz, PagingBean pagingBean, Object... params) {
	
		Query query = entityManager.createNativeQuery(sql, clazz);
		for(int i=0; i<params.length;i++) {
			query.setParameter(i+1, params[i]);
		}		
		String countQuery = "Select count(*) from ("+sql+") data";
		Query countQ = entityManager.createNativeQuery(countQuery);
		for(int i=0; i<params.length;i++) {
			countQ.setParameter(i+1, params[i]);
		}		
		
		pagingBean.setTotalRows( ((Number)countQ.getSingleResult()).longValue() );				
		query.setFirstResult( (int)pagingBean.getOffsetBegin() )
			 .setMaxResults( pagingBean.getRowsPerPage() );

		return query.getResultList();					
	}

	public Object nativeQuerySingleResult(String sql) {
		Query q = entityManager.createNativeQuery(sql);
		q.setFirstResult( 0 )
		 .setMaxResults( 1 ); //20091020 Mix: Fix bug in SQL Server.
		return q.getSingleResult();
	}

	public Object nativeQuerySingleResult(String sql, Object... params) {
		Query q = entityManager.createNativeQuery(sql);
		for(int i=0; i<params.length;i++) {
			q.setParameter(i+1, params[i]);
		} 
		q.setFirstResult( 0 )
		 .setMaxResults( 1 ); //20090325 Mix: Fix bug in SQL Server.
		return q.getSingleResult();
	}

	public void flush() {
		entityManager.flush();
	}

	public void refresh(Object entity) {
		entityManager.refresh(entity);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Long getGeneratedValueBySequenceName(String sequenceName) {
		try
		{
			String sql = "select "+sequenceName+".nextval from dual";
			/*
			Query query = entityManager.createNativeQuery(sql);
			BigDecimal result = (BigDecimal)query.getSingleResult();
			return result.longValue();
			*/
			List l = entityManager.createNativeQuery(sql).getResultList();
			if(l!=null && l.size()>0){
				return ((BigDecimal)l.get(0)).longValue();
			}
			return null;
		}catch (Exception e) {
			return null;
		}
	}

	public List<? extends Object> namedNativeQuery(String name, String[] paramNames, Object... params) {
		Query q = entityManager.createNamedQuery(name);
		q = setParameter(q, paramNames, params);
		return q.getResultList();
	}

	private Query setParameter(Query query, String[] paramNames, Object[] params) {
		for(int i=0; i<paramNames.length;i++) {
			query.setParameter(paramNames[i], params[i]);
			if(logger.isDebugEnabled()) {
				logger.debug("Param => " + paramNames[i] + " : " + params[i]);
			}
		}
		return query;
	}
	
	public void clear() {
		try {
			entityManager.clear();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<? extends Object> nativeQuery(String sql, String nameMapping, PagingBean pagingBean, String defaultOrder) {
		String orderBy = "";
		if(pagingBean != null)
		{
			if( pagingBean.getOrderList() != null && pagingBean.getOrderList().size() > 0 ){
				orderBy += " ORDER BY " + pagingBean.getOrderBy() + " " + pagingBean.getOrderMode();
			}
			else {
				if (StringUtils.isNotEmpty(defaultOrder)) {
					orderBy += " ORDER BY " + defaultOrder;
				}
			}
		}
		Query query = (Query)entityManager.createNativeQuery(sql+orderBy, nameMapping);
		Query queryCount = entityManager.createNativeQuery(QueryHelper.genCountQueryString(sql));
		
		if(pagingBean != null)
		{
			BigDecimal bigTotalRows = (BigDecimal)queryCount.getSingleResult();
			pagingBean.setTotalRows(new Long(bigTotalRows.longValue()));

			query.setFirstResult( (int)pagingBean.getOffsetBegin() ).setMaxResults( pagingBean.getRowsPerPage() );
		}
		return query.getResultList();
	}
	
	public List<? extends Object> nativeQuery(String sql, Class c, String[] paramNames, Object... params) {
		Query q = entityManager.createNativeQuery(sql, c);
		q = setParameter(q, paramNames, params);
		return q.getResultList();
	}

	public List<? extends Object> nativeQuery(String sql, String nameMapping) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(sql,nameMapping);
		return query.getResultList();
	}	
}
