package br.com.cogerh.template.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.cogerh.template.enumeration.EnumAtivo;
import br.com.cogerh.template.model.Grupo;
import br.com.cogerh.template.model.Usuario;
import br.com.cogerh.template.service.ClienteFTPService;
import br.com.cogerh.template.service.GrupoService;
import br.com.cogerh.template.service.UsuarioService;
import br.com.cogerh.template.util.ClienteFTPConstantes;
import br.com.cogerh.template.util.FacesUtil;
import br.com.cogerh.template.util.HasValue;

@Controller
@Scope("view")
public class UsuarioBean extends AbstractBean
{
	private Usuario usuario;
	private String pesquisa;
	
	private UploadedFile uploadedFile;
	//private InputStream inputStream;
	private byte[] image;
	private String imagePath;

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private FacesUtil faces;
	
	@Autowired
	private UsuarioWeb usuarioWeb;
	
	@Autowired
	private ClienteFTPService clienteFTPService;
	
	private List<Usuario> usuarioList = new ArrayList<Usuario>();
	private List<Grupo> grupoList = new ArrayList<Grupo>();
	
	private boolean modoEdicao;
	private String senhaAtual;
	private String senhaNova;

	@PostConstruct
	public void init()
	{
		try
		{
			this.usuario = new Usuario();
			this.usuarioList = usuarioService.listarUsuarios(null);
			this.grupoList = grupoService.listarGrupos(null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	
	
    public void initForm(Integer usuarioId) 
    {
    	
    	try
		{
    		InputStream is = null;
    		if(usuarioWeb.getUsuario().getGrupo().getNome().equals("ADMINISTRADOR")  || usuarioWeb.getUsuario().getId().equals(usuarioId)) {
			
	    		// Popula a lista de grupos para exibicao no select
		        this.grupoList = grupoService.listarGrupos(null);
		        
		        if (null == usuario || usuarioId == 0)
		        {
		        	this.viewState = ViewState.NOVO;
	
		            this.usuario = new Usuario();
		            
		            is = clienteFTPService.baixar(ClienteFTPConstantes.DIRETORIO_IMAGEM_PERFIL, ClienteFTPConstantes.IMAGEM_PERFIL_PADRAO);
		            
		        } else {
		        	
		        	this.viewState = ViewState.EDITAR;
		        	
		        	this.usuario = this.usuarioService.buscarPorId(usuarioId);
		        	
		            is = clienteFTPService.baixar(ClienteFTPConstantes.DIRETORIO_IMAGEM_PERFIL, usuario.getCaminhoImagem().toUpperCase());
		        }
		        
				image = IOUtils.toByteArray(is);
		        
    		} else {
				FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
		                + "/principal.xhtml");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    }

	public void salvar()
	{
		try
		{
			this.usuario.setDtCadastro(new Date());
			this.usuario.setAtivo(EnumAtivo.SIM);
			this.usuario.setSenha(faces.convertStringToMd5(this.usuario.getSenha()));
			
			/*if(uploadedFile != null) {
				File arq = new File(imagePath + uploadedFile.getFileName());
				BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image));
				boolean ok = ImageIO.write(bufferedImage, uploadedFile.getContentType().split("/")[1], arq);
				if(!ok) throw new Exception();
				this.usuario.setCaminhoImagem(arq.getPath());
			}*/
	
			usuario.setCaminhoImagem(ClienteFTPConstantes.IMAGEM_PERFIL_PADRAO);
			
			usuarioService.salvarUsuario(this.usuario);

			this.usuario = new Usuario();

			this.adicionaMensagemDeSucesso("Usuário adicionado com sucesso");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
			this.adicionaMensagemDeErro("Ocorreu um erro ao tentar salvar o registro");
		}
	}

	public void listar()
	{
		try{			
			if(HasValue.execute(this.usuario)){
				
				if((HasValue.execute(this.usuario.getNome()))
					|| (HasValue.execute(this.usuario.getLogin()))
					|| (HasValue.execute(this.usuario.getEmail()))
					|| (HasValue.execute(this.usuario.getGrupo()))
					|| (HasValue.execute(this.usuario.getAtivo()))) {
					
					this.usuarioList = usuarioService.buscarUsuarios(this.usuario);
					
				}else{
					
					this.adicionaMensagemDeErro("Preencha pelo menos um  filtro para realizar a pesquisa");
					
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void remover(Usuario usuario)
	{
		try
		{
			usuarioService.removerUsuario(usuario);

			this.usuarioList = usuarioService.listarUsuarios(null);

			this.adicionaMensagemDeSucesso("Usuário removido com sucesso");
		}
		catch (Exception e)
		{
			e.printStackTrace();

			this.adicionaMensagemDeErro("Ocorreu um erro ao tentar remover o registro");
		}
	}

	public void alterar()
	{
		try
		{
			// Caso o usuario esteja ativo seta a data de inativacao para null
			// Caso o usuario esteja inativo seta a data de inativacao para a data do dia
			
			if (this.usuario.getAtivo().equals(EnumAtivo.SIM))
				this.usuario.setDtInativacao(null);
			else
				this.usuario.setDtInativacao(new Date());
			
			if(uploadedFile != null) {
				
				InputStream imageContent = new ByteArrayInputStream(image);
				
				String dirRemoto = ClienteFTPConstantes.DIRETORIO_IMAGEM_PERFIL;
				
				int i = usuario.getCaminhoImagem().split("[.]").length;
				
				String ext = usuario.getCaminhoImagem().split("[.]")[i-1];
				
				String imageNome = ("user" + usuario.getId() + "." + ext).toUpperCase();
				
				if(clienteFTPService.enviar(dirRemoto, imageNome, imageContent)){
					this.usuario.setCaminhoImagem(imageNome);
				} 
				
			}
			
			this.usuario = usuarioService.alterarUsuario(this.usuario);

			this.adicionaMensagemDeSucesso("Usuário atualizado com sucesso");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
			this.adicionaMensagemDeErro("Ocorreu um erro ao tentar atualizar o registro");
		}
	}	

	public String showFormNovo() 
	{
        return "novo.xhtml?faces-redirect=true";
    }

	public String showFormListar() 
	{
        return "lista.xhtml?faces-redirect=true";
    }

	public String showFormEditar(Integer usuarioId) 
	{
		return "novo.xhtml?faces-redirect=true&usuarioId=" + usuarioId;
	}

	public EnumAtivo[] getEnumAtivoList() 
	{
	    return EnumAtivo.values();
	}

	public Usuario getUsuario() {return usuario;}
	public void setUsuario(Usuario usuario) {this.usuario = usuario;}

	public List<Usuario> getUsuarioList() {return usuarioList;}
	public void setUsuarioList(List<Usuario> usuarioList) {this.usuarioList = usuarioList;}

	public String getPesquisa() {return pesquisa;}
	public void setPesquisa(String pesquisa) {this.pesquisa = pesquisa;}

	public List<Grupo> getGrupoList() {return grupoList;}
	public void setGrupoList(List<Grupo> grupoList) {this.grupoList = grupoList;}
	
	/*public void upload() {
        if(photo != null) {
            FacesMessage message = new FacesMessage("Succesful, " + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }*/
	
	/*public StreamedContent carregaFotoCapa() {
		String caminhoFoto = "C:/Users/kauecarvalho/workspace/ProjTemplate/WebContent/resources/img/avatar.png";
		StreamedContent fotoCapa = null;
		try {
			final File arquivoFotoCapa = new File(caminhoFoto);
			final FileInputStream fileInputStream = new FileInputStream(arquivoFotoCapa);
			final InputStream is = new BufferedInputStream(fileInputStream);
			fotoCapa = new DefaultStreamedContent(is);
		} catch (Exception e) {
			e.printStackTrace();
			//LOGGER.error("Problema ao recuperar a foto de capa!", e);
		}
		return fotoCapa;
	}*/
	
	public void handleFileUpload(FileUploadEvent event) {
		this.uploadedFile = event.getFile();
		this.setImageContents(event.getFile().getContents());
    }
	
	public void atualizarSenha(/*String senhaAtual, String senhaNova, String senhaNovaConf*/) {
		String msg = null;
		System.out.println(usuario.getSenha());
		try {
			if(usuario.getSenha().equals(faces.convertStringToMd5(senhaAtual))) {
				if(senhaNova.equals("")) {
					msg = "Nova senha não pode ser vazia";
					throw new Exception(msg);
				} else {
					usuario.setSenha(faces.convertStringToMd5(senhaNova));
					this.usuario = usuarioService.alterarUsuario(this.usuario);
					this.adicionaMensagemDeSucesso("Senha atualizada com sucesso");
				}
			} else {
				msg = "Senha digitada diferente da cadastrada.";
				throw new Exception(msg);
			}
			
		} catch (Exception e) {
			adicionaMensagemDeErro(e.getMessage());
		}
	}
	
	public void atualizarSenha(Usuario usuario) {
		String msg = null;
		System.out.println(usuario.getSenha());
		try {
			if(usuario.getSenha().equals(faces.convertStringToMd5(senhaAtual))) {
				if(senhaNova.equals("")) {
					msg = "Nova senha não pode ser vazia";
					throw new Exception(msg);
				} else {
					usuario.setSenha(faces.convertStringToMd5(senhaNova));
					if(usuario.isPrimeiroAcesso()){
						usuario.setPrimeiroAcesso(false);
					}
					
					usuario = usuarioService.alterarUsuario(usuario);
					this.adicionaMensagemDeSucesso("Senha atualizada com sucesso");
				}
			} else {
				msg = "Senha digitada diferente da cadastrada.";
				throw new Exception(msg);
			}
			
		} catch (Exception e) {
			adicionaMensagemDeErro(e.getMessage());
		}
	}
	
	public String getImageContentsAsBase64() {
		return DatatypeConverter.printBase64Binary(this.image); 
	}


	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImageContents(byte[] imageContents) {
		this.image = imageContents;
	}
	
	/*public InputStream getInputStream() {
		return inputStream;
	}F

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}*/

	public boolean isModoEdicao() {
		return modoEdicao;
	}

	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getSenhaNova() {
		return senhaNova;
	}

	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}
	
	/*public void constructImage() {
		BufferedImage bufferedImg;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
       	bufferedImg = ImageIO.read(this.file.getInputstream());
			ImageIO.write(bufferedImg, "png", os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       photo = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png");
       
	}*/
	
	/*public void editarConta() {
		this.usuario = usuarioWeb.getUsuario();
		
		ExternalContext externalContext = FacesContext.getCurrentInstance()
	                .getExternalContext();
	    try {
	          externalContext.redirect(externalContext.getRequestContextPath()
	                + "/pages/usuario/atualiza.xhtml?usuarioId=" + usuario.getId());
	    } catch (IOException e) {
	          e.printStackTrace();
	    }
    
	}
	
	public void sair() {
		usuarioWeb.desloga();
		
		ExternalContext externalContext = FacesContext.getCurrentInstance()
	            .getExternalContext();
	    try {
	          externalContext.redirect(externalContext.getRequestContextPath()
	                + "/login.xhtml");
	    } catch (IOException e) {
	          e.printStackTrace();
	    }
	}*/
	
}