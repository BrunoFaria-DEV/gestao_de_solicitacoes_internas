package br.edu.ifmt.cba.Helper.Paginate;

import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;

public class SimplePagination {
	public static Query hibernateSimplePagination(Query query, int pageNumber, int pageSize) {
        pageNumber = pageNumber < 0 ? 0 : pageNumber;
        pageSize = pageSize <= 0 ? 10 : pageSize;
		
		return query.setFirstResult(pageNumber).setMaxResults(pageSize);
	}
	
	public static <T> PaginatedResult<T> HibernateCompletePagination(Query query, Query countQuery, int pageNumber, int pageSize) throws HibernateException{
		pageNumber = pageNumber < 0 ? 0 : pageNumber;
        pageSize = pageSize <= 0 ? 10 : pageSize;
		
        System.out.println("pageNumber: " + pageNumber
        					+ "\n pageSize: " + pageSize
        		);
        
        int totalItems = (int) countQuery.uniqueResult();
        int totalPages = (int) Math.ceil((double)totalItems / pageSize);
        
        @SuppressWarnings("unchecked")
        List<T> usuarios = query.setFirstResult(pageNumber * pageSize)
					        	  .setMaxResults(pageSize)
					        	  .list();

        return new PaginatedResult<>(usuarios, totalItems, totalPages, pageNumber, pageSize);
	}
}
