package br.edu.ifmt.cba.Action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.edu.ifmt.cba.DTO.UsuarioDto;
import br.edu.ifmt.cba.Model.Usuario;

public class UsuarioAction extends DispatchAction{
	public ActionForward inicio(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<UsuarioDto> usuarios = new ArrayList<>();
		usuarios.add(new UsuarioDto(1, "Bruno", "bruno@email.com", "senha", "ADMIN"));
		
		request.setAttribute("usuarios", usuarios);
		return mapping.findForward("inicio");
	}
	
	public ActionForward novo(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<Usuario> usuarios = new ArrayList<>();

		return mapping.findForward("novo");
	}
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		 UsuarioDto userDto = (UsuarioDto) form;
		
        ActionErrors errors = userDto.validate(mapping, request);
        if (errors != null) {
            saveErrors(request, errors);
            return mapping.findForward("novo");
        }

		return new ActionForward("usuarios.do?parameter=inicio", true);
	}
	
	public ActionForward editar(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<UsuarioDto> usuarios = new ArrayList<>();
		usuarios.add(new UsuarioDto(1, "Bruno", "bruno@email.com", "senha", "ADMIN"));

		int id = Integer.parseInt(request.getParameter("id"));
		
		usuarios.stream();
		
		return mapping.findForward("novo");
	}
}
