package br.com.cogerh.template.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.text.Normalizer;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import com.lowagie.text.DocumentException;
import com.sun.org.apache.xerces.internal.parsers.SAXParser;

public class CalculadorDistancia {
	public static void main(String[] args) {
		int count = 0;
		for(int i= 0; i< 1000000000; i++) {
			String dist = calcular("crato-CE", "maracanau-CE");
			if( dist != null) {
				count++;
			} else { 
				count = 0;
			}
			System.out.println(count);
			System.out.println(dist);
			
		}
	}

	public static String calcular(String origem, String destino) {
		Document document = null;

		origem = origem.replace("-null", "");
		destino = destino.replace("-null", "");
		
		try {

			System.setProperty("java.net.useSystemProxies", "true");
			System.setProperty("https.proxyHost","proxy.cogerh.com.br");
	//		System.setProperty("https.proxyHost","172.31.136.30");
	//		System.setProperty("https.proxyHost","172.31.136.3");
			System.setProperty("https.proxyPort","128");
			System.setProperty("https.proxyUser","Diarias");
			System.setProperty("https.proxyPassword","Sistemasdiariascogerh");

			Authenticator.setDefault(new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("Diarias",
							"Sistemasdiariascogerh".toCharArray());
				}
			});

			URL url = new URL("https://maps.google.es/maps/api/directions/xml?origin="
							+ origem + "&destination=" + destino
							+ "&key=AIzaSyAQdZy1TGztV74CiGWZ06ccWwijyLAp8bE&amp;sensor=false");//&sensor=false
			System.out.println(url);

			HttpsURLConnection httpConn = (HttpsURLConnection) url.openConnection();
			httpConn.setReadTimeout(4000);
			httpConn.setRequestMethod("GET");
			String resp = getResponse(httpConn);
			document = getDocumento(criarArquivo(resp));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return analisaXml(document);
	}

	public static File criarArquivo(String texto) {
		texto = removeAcentos(texto);
		FileWriter arquivo;
		File file = null;
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();  
			ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
			String arqui = scontext.getRealPath("/WEB-INF/Arquivo.xml"); 
			
			arquivo = new FileWriter(arqui);

			arquivo.write(texto);
			arquivo.close();
			file = new File(arqui);

			InputStream inputStream = new FileInputStream(file);
			Reader reader = new InputStreamReader(inputStream, "UTF-8");

			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");
			SAXParser saxParser = new SAXParser();
			saxParser.parse(is);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}

	public static Document getDocumento(File file) throws DocumentException,
			org.dom4j.DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		return document;
	}

	public static String analisaXml(Document document) {
		List list = document.selectNodes("//DirectionsResponse/route/leg/distance/text");
		
		Element element = null;
		
		if(list.size() > 0)
			element = (Element) list.get(list.size() - 1);

		return (element != null ? element.getText() : null);
	}
	
	/*public static String analisaXmlLocalidade(Document document) {
		List list = document.selectNodes("//GeocodeResponse/result");
		list = ((Element)list.get(0)).selectNodes("//address_component");
		
		Element element = null;
		
		for(int i = 0 ; i < list.size() ; i++){
			System.out.println(list.get(0));
		}
		
		System.out.println(element.getText());

		return (element != null ? element.getText() : null);
	}*/

	private static String getResponse(HttpsURLConnection Conn)
			throws IOException {

		InputStream is;
		int teste = Conn.getResponseCode();
		if (Conn.getResponseCode() >= 400) {
			is = Conn.getErrorStream();
		} else {
			is = Conn.getInputStream();
		}

		String response = "";
		byte buff[] = new byte[512];
		int b = 0;
		while ((b = is.read(buff, 0, buff.length)) != -1) {
			response += new String(buff, 0, b);

		}
		is.close();

		return response;
	}

	private static String getContextPath() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getServletContext().getContextPath();
	}

	private static String getDiretorioReal(String diretorio) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getServletContext().getRealPath(diretorio);
	}

	public static void criptografar() {

	}
	
	public static String removeAcentos(String string) {
	    if (string != null){
	        string = Normalizer.normalize(string, Normalizer.Form.NFD);
	        string = string.replaceAll("[^\\p{ASCII}]", "");
	    }
	    return string;
	}
	
	
	
	/*public static String obterDistanciaBanco(Integer idCidadeOrigem,Integer localidade) throws ClassNotFoundException, SQLException{
		String distancia = "0";
		Conexao conexao = new Conexao();
		
		Statement stmt = conexao.getConexao().createStatement();
		
		String sql = "select dis_distancia from distancia_cidades where loc_cidade_origem_fk = "+idCidadeOrigem+ " and loc_cidade_destino_fk ="+localidade;
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			distancia = rs.getString("dis_distancia");
		}

	return distancia;	
	}*/
	
	/*public static String verificarLocalidade(String latitude, String longitude) {
		Document document = null;
		
		try {

			System.setProperty("java.net.useSystemProxies", "true");
			System.setProperty("https.proxyHost","proxy.cogerh.com.br");
	//		System.setProperty("https.proxyHost","172.31.136.30");
	//		System.setProperty("https.proxyHost","172.31.136.3");
			System.setProperty("https.proxyPort","128");
			System.setProperty("https.proxyUser","Diarias");
			System.setProperty("https.proxyPassword","Sistemasdiariascogerh");

			Authenticator.setDefault(new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("Diarias",
							"Sistemasdiariascogerh".toCharArray());
				}
			});

			URL url = new URL("https://maps.googleapis.com/maps/api/geocode/xml?latlng="+ latitude + "," + longitude + "&key=AIzaSyAQdZy1TGztV74CiGWZ06ccWwijyLAp8bE");//&sensor=false
			System.out.println(url);

			HttpsURLConnection httpConn = (HttpsURLConnection) url.openConnection();
			httpConn.setReadTimeout(4000);
			httpConn.setRequestMethod("GET");
			String resp = getResponse(httpConn);
			document = getDocumento(criarArquivo(resp));
			
			JsonObject jsonObject = new JsonObject().getAsJsonObject(resp);
			System.out.println(jsonObject);
			


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return analisaXmlLocalidade(document);
	}*/

}
