package br.edu.ifmt.cba.DAO;

import br.edu.ifmt.cba.Helper.Paginate.PaginatedResult;
import br.edu.ifmt.cba.Helper.Paginate.SimplePagination;
import br.edu.ifmt.cba.Model.Usuario;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;

public class UsuarioDao {
	private SessionFactory _sessionFactory = HibernateUtil.getSessionFactory();

	public PaginatedResult<Usuario> get(int pageNumber, int pageSize){
		PaginatedResult<Usuario> paginatedResult = null;
		Session session = SessionUtil.sessionOpen(_sessionFactory);
		
        if (session == null) 
			return paginatedResult;
        
        try {
			Query query = session.createQuery("from Usuario");
	        Query countQuery = session.createQuery("select count(*) from Usuario");		
	        
	        paginatedResult = SimplePagination.HibernateCompletePagination(query, countQuery, pageNumber, pageSize);
	        return paginatedResult;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			SessionUtil.sessionClose(session);
		}

		return paginatedResult;
	}

	public PaginatedResult<Usuario> getListByName(String nome, int pageNumber, int pageSize){
		PaginatedResult<Usuario> paginatedResult = null;
		Session session = SessionUtil.sessionOpen(_sessionFactory);
		
        if (session == null) 
			return paginatedResult;
        
        try {
			Query query = session.createQuery("from Usuario");
	        Query countQuery = session.createQuery("select count(*) from Usuario");		
	        
	        paginatedResult = SimplePagination.HibernateCompletePagination(query, countQuery, pageNumber, pageSize);
	        return paginatedResult;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			SessionUtil.sessionClose(session);
		}

		return paginatedResult;
	}
	
	public Usuario getByEmail(String email) {
		Usuario usuario = null;
		Session session = SessionUtil.sessionOpen(_sessionFactory);
		
        if (session == null) 
			return usuario;
		
        try {
        	return (Usuario) session.createQuery("select usuario where senha = : email")
				                    .setParameter("email", email)
				                    .uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			SessionUtil.sessionClose(session);
		}
		
		return usuario;
	}

	public Usuario getById(int id){
		Usuario usuario = null;
		Session session = SessionUtil.sessionOpen(_sessionFactory);
		
        if (session == null) 
			return usuario;
		
        try {
        	return (Usuario) session.get(Usuario.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			SessionUtil.sessionClose(session);
		}
		
		return usuario;
	}

	public boolean add(Usuario usuario){
		Session session = SessionUtil.sessionOpen(_sessionFactory);
	    Transaction transaction = null;
		
        if (session == null) 
			return false;
		
        try {
        	transaction = session.beginTransaction();
        	session.save(usuario);
        	transaction.commit();
        	return true;
		} catch (HibernateException e) {
			SessionUtil.sessionTransactionRollback(transaction);
			e.printStackTrace();
		} finally {
			SessionUtil.sessionClose(session);
		}
		
		return false;
	}
	
	public boolean update(Usuario usuario) {
		Session session = SessionUtil.sessionOpen(_sessionFactory);
	    Transaction transaction = null;

        if (session == null) 
			return false;
	    
		try {
        	transaction = session.beginTransaction();
			session.update(usuario);
        	transaction.commit();
        	return true;
		} catch (HibernateException e) {
			SessionUtil.sessionTransactionRollback(transaction);
			e.printStackTrace();
		} finally {
			SessionUtil.sessionClose(session);		
		}
		
		return false;
	}
	
	public boolean delete(Usuario usuario) {
		Session session = SessionUtil.sessionOpen(_sessionFactory);
	    Transaction transaction = null;

        if (session == null) 
			return false;
	    
		try {
        	transaction = session.beginTransaction();
			session.delete(usuario);
        	transaction.commit();
        	return true;
		} catch (HibernateException e) {
			SessionUtil.sessionTransactionRollback(transaction);
			e.printStackTrace();
		} finally {
			SessionUtil.sessionClose(session);		
		}
		
		return false;
	}
}
