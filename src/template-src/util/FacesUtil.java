package br.com.cogerh.template.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class FacesUtil
{
	/**
	 * Metodo responsavel por converter uma string para md5
	 * 
	 * @param valor
	 * @return
	 */
	public String convertStringToMd5(String valor)
	{
		MessageDigest mDigest;

		try
		{
			// Instanciamos o nosso HASH MD5, poder�amos usar outro como
			// SHA, por exemplo, mas optamos por MD5.
			mDigest = MessageDigest.getInstance("MD5");

			// Convert a String valor para um array de bytes em MD5
			byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));

			// Convertemos os bytes para hexadecimal, assim podemos salvar
			// no banco para posterior compara��o se senhas
			StringBuffer sb = new StringBuffer();

			for (byte b : valorMD5)
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));

			return sb.toString();
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();

			return null;
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();

			return null;
		}
	}
}