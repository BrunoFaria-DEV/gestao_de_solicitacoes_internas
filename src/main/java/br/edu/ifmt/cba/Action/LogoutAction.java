package br.edu.ifmt.cba.Action;

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

public class LogoutAction extends Action{
	private UsuarioDao _usuarioDao = new UsuarioDao();
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginDto loginForm = (LoginDto) form;
        Usuario usuario = _usuarioDao.getByEmail(loginForm.getEmail());
		
        if (usuario == null) {
        	System.out.println("usuario não encontrado");
        	//adicionar erros
    		return mapping.getInputForward();
        }

        if (!usuario.getSenha().equals(loginForm.getSenha())) {
        	System.out.println("usuario ou senha incorretos");
        	//adicionar erros
    		return mapping.getInputForward();
		}
        
        HttpSession session = request.getSession(true);
        session.setAttribute("usuarioLogado", usuario);
		return mapping.findForward("inicio");
	}
}
