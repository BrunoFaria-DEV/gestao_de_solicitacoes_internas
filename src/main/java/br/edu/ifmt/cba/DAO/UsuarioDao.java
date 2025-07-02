package br.edu.ifmt.cba.DAO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.Model.Usuario;
import br.edu.ifmt.cba.DAO.SessionUtil;
import br.edu.ifmt.cba.DAO.HibernateUtil;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;

public class UsuarioDao {
	private SessionFactory _sessionFactory = HibernateUtil.getSessionFactory();
	
	public List<Usuario> get(){
        List<Usuario> usuarios = new ArrayList<Usuario>();
		Session session = SessionUtil.sessionOpen(_sessionFactory);
        
        if (session == null) {
			return usuarios;
		}
        
        try {
			usuarios = session.createQuery("from Usuario").list();
		} catch (Exception e) {
			e.printStackTrace();			
		} finally {
			SessionUtil.sessionClose(session);
		}
        
		return usuarios;
	}
	
	public List<Usuario> getByName(){
		
		return new ArrayList<>();
	}
	
	public List<Usuario> getById(){
		
		return new ArrayList<>();
	}
	
	public boolean add(Usuario usuario){
		
		
		return false;
	}
}
