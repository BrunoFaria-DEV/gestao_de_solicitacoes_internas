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

public class LoginPageAction extends Action{
	private UsuarioDao _usuarioDao = new UsuarioDao();
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if (usuarioLogado != null) {
			return mapping.findForward("inicio");
		}
		
		return mapping.findForward("login");
	}
}
