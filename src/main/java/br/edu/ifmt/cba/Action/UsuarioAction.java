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

import br.edu.ifmt.cba.DAO.UsuarioDao;
import br.edu.ifmt.cba.DTO.UsuarioDto;
import br.edu.ifmt.cba.Helper.Paginate.PaginatedResult;
import br.edu.ifmt.cba.Model.Usuario;

public class UsuarioAction extends DispatchAction{
	private UsuarioDao _usuarioDao = new UsuarioDao();
	
	private void loadFormData(HttpServletRequest request) {
		List<String> perfis = List.of("ADMIN", "PADRAO");
		request.setAttribute("perfis", perfis);
	}
	
	public ActionForward inicio(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		int pageNumber 	= request.getParameter("page_number") != null ? Integer.parseInt(request.getParameter("page_number")) : 0;
		int pageSize 	= request.getParameter("page_size") != null ? Integer.parseInt(request.getParameter("page_size")) : 10;
		
		PaginatedResult<Usuario> paginatedResult = _usuarioDao.get(pageNumber, pageSize);
		if (paginatedResult == null)
			return mapping.findForward("inicio");
		
		List<UsuarioDto> usuariosDto = new ArrayList<>();

		for (Usuario usuario : paginatedResult.getItems()) {
			usuariosDto.add(new UsuarioDto(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPerfil()));
		}
		
		System.out.println("usuario->id: " + usuariosDto.get(0).getId());

		request.setAttribute("usuarios", usuariosDto);
		return mapping.findForward("inicio");
	}

	public ActionForward novo(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		loadFormData(request);
		return mapping.findForward("novo");
	}

	public ActionForward salvar(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		UsuarioDto usuarioDto = (UsuarioDto) form;
		
        ActionErrors errors = usuarioDto.validate(mapping, request);
        if (errors != null) {
        	loadFormData(request);
            saveErrors(request, errors);
            return mapping.findForward("novo");
        }
        
        Usuario usuario = new Usuario(usuarioDto.getNome(), usuarioDto.getEmail(), usuarioDto.getSenha(), usuarioDto.getPerfil());

		boolean result = _usuarioDao.add(usuario);
		if (result == false) {
			loadFormData(request);
            saveErrors(request, errors);
            return mapping.findForward("novo");
		}
        
		return new ActionForward("usuarios.do?parameter=inicio", true);
	}

	public ActionForward editar(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("usuario_id"));
		
		Usuario usuario = _usuarioDao.getById(id);
		if (usuario == null) {
			return mapping.findForward("inicio");
		}
		
		UsuarioDto usuarioDto = (UsuarioDto) form;
		usuarioDto.setId(usuario.getId());
		usuarioDto.setNome(usuario.getNome());
		usuarioDto.setEmail(usuario.getEmail());
		usuarioDto.setPerfil(usuario.getPerfil());
		
		loadFormData(request);
		request.setAttribute("usuario", usuarioDto);

		return mapping.findForward("editar");
	}
	
	public ActionForward atualizar(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("usuario_id"));		
		UsuarioDto usuarioDto = (UsuarioDto) form;
		
        ActionErrors errors = usuarioDto.validate(mapping, request);
        if (errors != null) {
        	loadFormData(request);
            saveErrors(request, errors);
            return mapping.findForward("editar");
        }
		
		Usuario usuario = _usuarioDao.getById(id);
		if (usuario == null) {
			saveErrors(request, errors);
			loadFormData(request);
			return mapping.getInputForward();
		}
        
		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());
		if (usuarioDto.getSenha() != null || usuarioDto.getSenha() != "") 
			usuario.setSenha(usuarioDto.getSenha());
		usuario.setPerfil(usuarioDto.getPerfil());

		boolean result = _usuarioDao.update(usuario);
		if (result == false) {
			loadFormData(request);
            saveErrors(request, errors);
            return mapping.findForward("editar");
		}

		return new ActionForward("usuarios.do?parameter=inicio", true);
	}
	
	public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("usuario_id"));		
		UsuarioDto usuarioDto = (UsuarioDto) form;
		
        ActionErrors errors = usuarioDto.validate(mapping, request);
        if (errors != null) {
        	loadFormData(request);
            saveErrors(request, errors);
            return mapping.findForward("inicio");
        }
		
		Usuario usuario = _usuarioDao.getById(id);
		if (usuario == null) {
			saveErrors(request, errors);
			loadFormData(request);
			return mapping.getInputForward();
		}

		boolean result = _usuarioDao.delete(usuario);
		if (result == false) {
			loadFormData(request);
            saveErrors(request, errors);
            return mapping.findForward("inicio");
		}

		return new ActionForward("usuarios.do?parameter=inicio", true);
	}
}
