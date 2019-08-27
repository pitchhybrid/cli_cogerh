package br.com.cogerh.template.util;

import br.com.cogerh.template.model.Usuario;

public class RenderizadorItensMenu {
	
	public Usuario usuario;
	
	public boolean administracao;
	
	public boolean diaria;
	
	public boolean aprovacao;
	
	public boolean aprovacao1;
	
	public boolean aprovacao2;
	
	public boolean relatorio;
	
	public boolean cadastros;
	
	public boolean contas;
	
	public boolean bi;
	
	public String redirectDiaria;
	
	public boolean editarDiaria;
	
	public RenderizadorItensMenu(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isAdministracao() {
		String grupo = usuario.getGrupo().getNome();
		if(grupo.equals(TipoGrupo.ADMINISTRADOR)) {
			return true;
		}
		return false;
	}

	public boolean isDiaria() {
		String grupo = usuario.getGrupo().getNome();
		if(grupo.equals(TipoGrupo.ADMINISTRADOR) 
				|| grupo.equals(TipoGrupo.APROVADOR) 
				|| grupo.equals(TipoGrupo.RH) 
				|| grupo.equals(TipoGrupo.SOLICITANTE) 
				|| grupo.equals(TipoGrupo.CONSULTA)
				|| grupo.equals(TipoGrupo.APROVADOR_N1)
				|| grupo.equals(TipoGrupo.APROVADOR_N2)
				|| grupo.equals(TipoGrupo.CADASTRO_DIARIA)
				|| grupo.equals(TipoGrupo.CADASTRO_DIARIA_RELATORIOS)){
			return true;
		}
		return false;
	}

	public boolean isRelatorio() {
		String grupo = usuario.getGrupo().getNome();
		if(grupo.equals(TipoGrupo.ADMINISTRADOR) 
				|| grupo.equals(TipoGrupo.RH) 
				|| grupo.equals(TipoGrupo.RELATORIOS)
				|| grupo.equals(TipoGrupo.CADASTRO_DIARIA_RELATORIOS)){
			return true;
		}
		return false;
	}

	public boolean isCadastros() {
		String grupo = usuario.getGrupo().getNome();
		if(grupo.equals(TipoGrupo.ADMINISTRADOR) 
				|| grupo.equals(TipoGrupo.RH) ) {
			return true;
		}
		return false;
	}

	public boolean isContas() {
		String grupo = usuario.getGrupo().getNome();
		if(grupo.equals(TipoGrupo.ADMINISTRADOR) 
				|| grupo.equals(TipoGrupo.RH)) {
			return true;
		}
		return false;
	}

	public boolean isBi() {
		String grupo = usuario.getGrupo().getNome();
		if(grupo.equals(TipoGrupo.ADMINISTRADOR)) {
			return true;
		}
		return false;
	}

	public String getRedirectDiaria() {
		if(usuario.getGrupo().getNome().equals(TipoGrupo.SOLICITANTE) 
				|| usuario.getGrupo().getNome().equals(TipoGrupo.APROVADOR_N1)
				|| usuario.getGrupo().getNome().equals(TipoGrupo.APROVADOR_N2)) {
			return "/pages/diaria/listaEspecifica?tipo=1";
		} else {
			return "/pages/diaria/lista";
		}
	}

	public boolean isEditarDiaria() {
		if(!(this.usuario.getGrupo().getNome().equals(TipoGrupo.SOLICITANTE) ||
				this.usuario.getGrupo().getNome().equals(TipoGrupo.APROVADOR_N1) ||
				this.usuario.getGrupo().getNome().equals(TipoGrupo.APROVADOR_N2))) {
			return true;
		}
		return false;
	}
	
	public boolean isAprovacao() {
		String grupo = usuario.getGrupo().getNome();
		if(grupo.equals(TipoGrupo.ADMINISTRADOR) 
				|| grupo.equals(TipoGrupo.APROVADOR)) {
			return true;
		}
		return false;
	}

	public boolean isAprovacao1() {
		String grupo = usuario.getGrupo().getNome();
		if(grupo.equals(TipoGrupo.ADMINISTRADOR) 
				|| grupo.equals(TipoGrupo.APROVADOR)
				|| grupo.equals(TipoGrupo.APROVADOR_N1)) {
			return true;
		}
		return false;
	}

	public boolean isAprovacao2() {
		String grupo = usuario.getGrupo().getNome();
		if(grupo.equals(TipoGrupo.ADMINISTRADOR) 
				|| grupo.equals(TipoGrupo.APROVADOR)
				|| grupo.equals(TipoGrupo.APROVADOR_N2)) {
			return true;
		}
		return false;
	}
	
}
