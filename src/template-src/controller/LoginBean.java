package br.com.cogerh.template.controller;

import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.cogerh.template.enumeration.EnumAtivo;
import br.com.cogerh.template.model.Usuario;
import br.com.cogerh.template.service.Autenticador;
import br.com.cogerh.template.service.UsuarioService;
import br.com.cogerh.template.util.Email;
import br.com.cogerh.template.util.FacesUtil;

@Controller
@Scope("view")
public class LoginBean extends AbstractBean
{
	private String login;
	private String senha;
	
	private UsuarioWeb usuarioWeb;
	private Autenticador autenticador;
	
	@Autowired
	private FacesUtil faces;
	
	private boolean exibirRecuperarSenha = false;
	
	@Autowired
	private Email email;
	
	@Autowired
	private UsuarioService UsuarioService;
	
	private String cpf;
	
	
	@Autowired
	public LoginBean(Autenticador aut, UsuarioWeb usuWeb)
	{
		this.autenticador = aut;
		this.usuarioWeb = usuWeb;
	}
	
	public void initForm(boolean recuperarSenha) {
		if(recuperarSenha) {
			exibirRecuperarSenha = true;
		}
		
		System.out.println();
	}
	
	public String logar() throws Exception
	{
		login = login.replace(".", "").replace("-","");
		Usuario usuario = autenticador.autentica(login, faces.convertStringToMd5(senha));
		System.out.println(faces.convertStringToMd5(senha));
		if (usuario != null)
		{
			if (usuario.getAtivo().equals(EnumAtivo.SIM))
			{				
				usuarioWeb.loga(usuario);

				return "principal?faces-redirect=true&usuarioId=" + usuarioWeb.getUsuario().getId();
				
			}
			else
			{
				this.adicionaMensagemDeErro("O Usuário informado está inativo");

				return null;
			}
		}

		this.adicionaMensagemDeErro("Login e/ou Senha inválidos");

		return null;
	}
	
	public void abrirrecuperarSenha(){
		
		System.out.println("oi");
		exibirRecuperarSenha = true;
	}
	
	/*public void voltarRecuperarSenha(){
		System.out.println("Entrou");
		exibirRecuperarSenha = false;

	}*/
	
	public String voltarRecuperarSenha() {
		return "login.xhtml?faces-redirect=true";
	}
	

	public String montarSenha(){
		Random gerador = new Random();
		String letras = "ABCDEFGHIJLMNOPQRSTUVXZ";
		String pt1 = String.valueOf(gerador.nextInt(1000));

		String pt2 = String.valueOf(letras.charAt(gerador.nextInt(23)));
		
		String pt3 = String.valueOf(gerador.nextInt(1000));
		String pt4 = String.valueOf(letras.charAt(gerador.nextInt(23)));

		String pt5 = String.valueOf(gerador.nextInt(23));
		String pt6 = String.valueOf(letras.charAt(gerador.nextInt(23)));

		
		String senha = pt1 + pt2 + pt3+ pt4+pt5+pt6;
		return senha;
	}
	
	public static void main(String[] args) {
		LoginBean l = new LoginBean(null,null);
		l.montarSenha();
	}
	
	
	
	public void recuperarSenha(){
		String s = montarSenha();
		Usuario usuario = null;
		try {
			
			usuario = UsuarioService.buscarPorCpf(cpf.replace(".", "").replace("-", ""));
			usuario.setSenha(faces.convertStringToMd5(s));
			usuario.setPrimeiroAcesso(true);
			UsuarioService.alterarUsuario(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		StringBuilder mensagemEmail = new StringBuilder();

		mensagemEmail.append("<h2 style=\"text-align: center;\"><span style=\"font-weight: bold; vertical-align: super; font-size: xx-large;\">Solicitação de Recuperação de senha</span></h2>");
		mensagemEmail.append("<div style=\"text-align: center;\"><span style=\"font-weight: bold; vertical-align: super; \">");
		mensagemEmail.append("Foi Solicitado a recuperação de senha para o Usuário com o CPF de "+usuario.getLogin()+"</span></div>");
		mensagemEmail.append("<div style=\"text-align: center;\"><span style=\"vertical-align: super; font-weight: bold;\">");
		mensagemEmail.append("Use a Senha a seguir para efetuar Login no Sistema</span>");
		mensagemEmail.append("</div><div style=\"text-align: center;\"><span style=\"vertical-align: super; font-weight: bold; color: rgb(255, 0, 0);\"><br>");
		mensagemEmail.append("</span></div><div style=\"text-align: center;\">");
		mensagemEmail.append("<h1><span style=\"vertical-align: super; font-weight: bold; background-color: rgb(255, 204, 51);\">"+ s+"</span><h1></div>");
		mensagemEmail.append("<div style=\"text-align: center;\"><span style=\"vertical-align: super; font-weight: bold; background-color: rgb(255, 204, 51);\"><br></span></div><div style=\"text-align: center;\"><span style=\"font-weight: 700; background-color: rgb(255, 255, 255); color: rgb(255, 0, 0);\">Ao Efetuar o Login com essa senha, o sistema solicitará que cadastre uma nova senha</span></div>");

	
		if(email.enviarEmail(usuario.getEmail(),null, "Recuperação de Senha do SysDiarias", mensagemEmail.toString())){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Solicitação realizada", "Um email com uma senha provisória foi enviado para o email deste usuário."));
			System.out.println("Email Enviado");
		}
        

	}
	
	public String deslogar()
	{
		usuarioWeb.desloga();

		return "/login?faces-redirect=true";
	}

	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}

	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}

	public UsuarioWeb getUsuarioWeb() {return usuarioWeb;}
	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {this.usuarioWeb = usuarioWeb;}

	public Autenticador getAutenticador() {return autenticador;}
	public void setAutenticador(Autenticador autenticador) {this.autenticador = autenticador;}

	public FacesUtil getFaces() {
		return faces;
	}

	public void setFaces(FacesUtil faces) {
		this.faces = faces;
	}

	public boolean isExibirRecuperarSenha() {
		return exibirRecuperarSenha;
	}

	public void setExibirRecuperarSenha(boolean exibirRecuperarSenha) {
		this.exibirRecuperarSenha = exibirRecuperarSenha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}