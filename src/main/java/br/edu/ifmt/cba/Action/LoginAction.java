package br.edu.ifmt.cba.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.edu.ifmt.cba.DAO.UsuarioDao;
import br.edu.ifmt.cba.DTO.LoginDto;
import br.edu.ifmt.cba.Model.Usuario;

public class LoginAction extends Action{
	private UsuarioDao _usuarioDao = new UsuarioDao();
	
	private void loadFormData(HttpServletRequest request) {
		List<String> perfis = List.of("ADMIN", "PADRAO");
		request.setAttribute("perfis", perfis);
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginDto loginForm = (LoginDto) form;
        Usuario usuario = _usuarioDao.getByEmail(loginForm.getEmail());
		
        if (usuario == null) {
        	System.out.println("usuario não encontrado");
    		return mapping.getInputForward();
        }
        
        if (usuario.getSenha() == loginForm.getSenha()) {
            HttpSession session = request.getSession(true);
            session.setAttribute("usuarioLogado", usuario);
    		return mapping.findForward("index");
		}
    		
		HttpSession session = request.getSession(false);
		
		if(session == null || request.getRequestedSessionId() == "") {
			
		}
		
		return mapping.findForward("login");
	}
}
