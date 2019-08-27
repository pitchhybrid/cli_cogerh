package br.com.cogerh.template.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Email implements Serializable
{
    @Autowired
    private JavaMailSender mailSender;

    private final String REMETENTE = "sysdiarias@cogerh.com.br"; 

    /**
     * Metodo responsavel por enviar o email
     * 
     * @param destinatario
     * @param destinatarioCc
     * @param assunto
     * @param texto
     */
    public boolean enviarEmail(String destinatario, String destinatarioCc, String assunto, String texto) 
    {
    	MimeMessage message = mailSender.createMimeMessage();

    	try
 		{
    		MimeMessageHelper helper = new MimeMessageHelper(message, true);

    		helper.setFrom(REMETENTE);
    		helper.setTo(destinatario);
    		
    		if(destinatarioCc != null){
    			helper.setCc(destinatarioCc);
    		}
			helper.setSubject(assunto);
	        helper.setText(texto, true);

	        mailSender.send(message);
	        
	        return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			 FacesContext context = FacesContext.getCurrentInstance();
			 FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foi possível enviar o email com a nova senha.",  "Procure a GETIN para esclarecimentos.");
			 context.addMessage(null, facesMessage);
			 
			 return false;
		}
    }
    
    /**
     * Metodo responsavel por enviar o email
     * 
     * @param destinatario
     * @param destinatarioCc
     * @param assunto
     * @param texto
     */
    public void enviarEmail(String destinatario, String destinatarioCc, String assunto, String texto, String arquivo) 
    {
    	MimeMessage message = mailSender.createMimeMessage();

    	try
 		{
    		MimeMessageHelper mineMessage = new MimeMessageHelper(message, true);

    		mineMessage.setFrom(REMETENTE);
    		mineMessage.setTo(destinatario);
			mineMessage.setCc(destinatarioCc);
			mineMessage.setSubject(assunto);
	        mineMessage.setText(texto, true);

	        FileSystemResource file = new FileSystemResource(arquivo);
			mineMessage.addAttachment(file.getFilename(), file);

	        mailSender.send(message);
		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
    }
}