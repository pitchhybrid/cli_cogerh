package br.com.cogerh.template.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import br.com.cogerh.template.service.ClienteFTPService;
import br.com.cogerh.template.util.ClienteFTPConstantes;

@Service
public class ClienteFTPServiceImpl implements ClienteFTPService {

	/*
	 * private static final String URL_SERVER_FTP = "localhost"; private static
	 * final String USER_SERVER_FTP = "novodiarias"; private static final String
	 * PASSWORD_SERVER_FTP = "ftpcliente"; private static final String DIRETORIO
	 * = "root";
	 */

	public static void main(String[] args) {
		ClienteFTPServiceImpl c = new ClienteFTPServiceImpl();
		FTPClient ftp = new FTPClient();
		InputStream is;

		File arqExcecao = new File("E:/arqExcecao.txt");

		FileWriter fw = null;

		BufferedWriter bw = null;

		try {

			fw = new FileWriter(arqExcecao);

			bw = new BufferedWriter(fw);

			ftp.connect(ClienteFTPConstantes.URL_SERVER_FTP, ClienteFTPConstantes.PORT_SERVER_FTP);

			ftp.login(ClienteFTPConstantes.USER_SERVER_FTP, ClienteFTPConstantes.PASSWORD_SERVER_FTP);

			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

			ftp.enterLocalPassiveMode();

			ftp.changeWorkingDirectory("/documentossysdiarias/acompanhamentodiaria/");

			File dir = new File("E:/SysDiarias Imagens Producao");

			File[] listaArquivos = null;

			if (dir.isDirectory()) {
				listaArquivos = dir.listFiles();
			}

			String nomeArquivo = null;

			for (int i = 0; i < listaArquivos.length; i++) {
				try {

					nomeArquivo = listaArquivos[i].getName();

					FileInputStream arqEnviar;

					arqEnviar = new FileInputStream(dir + "\\" + nomeArquivo);

					if (ftp.storeFile(nomeArquivo, arqEnviar)) {
						System.out.println("Diária " + nomeArquivo
								+ "Arquivo armazenado com sucesso!");
					} else {
						System.out.println("Erro ao armazenar o arquivo."
								+ nomeArquivo);
					}

				} catch (IOException e) {
					e.printStackTrace();
					bw.write("arquivo " + nomeArquivo);
					bw.newLine();
					continue;
				}
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.logout();
					ftp.disconnect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<String> listar(String diretorio) {
		FTPClient ftp = new FTPClient();
		List<String> ftpFileList = null;

		try {

			ftp.connect(ClienteFTPConstantes.URL_SERVER_FTP);

			if (ftp.login(ClienteFTPConstantes.USER_SERVER_FTP,
					ClienteFTPConstantes.PASSWORD_SERVER_FTP)) {
				ftp.changeWorkingDirectory(diretorio);

				ftpFileList = Arrays.asList(ftp.listNames());
			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ftp.isConnected()) {
					// ftp.logout();
					ftp.disconnect();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return ftpFileList;
	}

	@Override
	public boolean enviar(String dirRemoto, String arqNome,
			InputStream arqConteudo) {
		boolean bool = false;

		FTPClient ftp = new FTPClient();

		try {

			ftp.connect(ClienteFTPConstantes.URL_SERVER_FTP, ClienteFTPConstantes.PORT_SERVER_FTP);

			if (ftp.login(ClienteFTPConstantes.USER_SERVER_FTP,
					ClienteFTPConstantes.PASSWORD_SERVER_FTP)) {

				if (dirRemoto != null) {
					ftp.changeWorkingDirectory(dirRemoto);
				}

				ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

				ftp.enterLocalPassiveMode();

				if (ftp.storeFile(arqNome, arqConteudo))
					bool = true;

			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ftp.isConnected()) {
					// ftp.logout();
					ftp.disconnect();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return bool;
	}

	@Override
	public boolean baixar(String dirRemoto, String arqNome, String local) {

		FTPClient ftp = new FTPClient();
		boolean bool = false;

		try {

			ftp.connect(ClienteFTPConstantes.URL_SERVER_FTP);

			if (ftp.login(ClienteFTPConstantes.USER_SERVER_FTP,
					ClienteFTPConstantes.PASSWORD_SERVER_FTP)) {
				if (dirRemoto != null) {
					ftp.changeWorkingDirectory(dirRemoto);
				}

				ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

				ftp.enterLocalPassiveMode();

				FileOutputStream arqLocal = new FileOutputStream(
						new File(local));

				if (ftp.retrieveFile(arqNome, arqLocal)) {
					bool = true;
				}

			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ftp.isConnected()) {
					// ftp.logout();
					ftp.disconnect();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return bool;
	}

	@Override
	public InputStream baixar(String dirRemoto, String arqNome) {
		FTPClient ftp = new FTPClient();
		InputStream inputStream = null;
		try {

			ftp.connect(ClienteFTPConstantes.URL_SERVER_FTP);

			if (ftp.login(ClienteFTPConstantes.USER_SERVER_FTP,
					ClienteFTPConstantes.PASSWORD_SERVER_FTP)) {

				if (dirRemoto != null) {
					ftp.changeWorkingDirectory(dirRemoto);
				}

				ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

				ftp.enterLocalPassiveMode();

				inputStream = ftp.retrieveFileStream(arqNome);
			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ftp.isConnected()) {
					// ftp.logout();
					ftp.disconnect();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return inputStream;
	}

	@Override
	public boolean excluir(String dirRemoto, String arqNome) {

		FTPClient ftp = new FTPClient();

		boolean bool = false;
		try {

			ftp.connect(ClienteFTPConstantes.URL_SERVER_FTP);

			if (ftp.login(ClienteFTPConstantes.USER_SERVER_FTP,
					ClienteFTPConstantes.PASSWORD_SERVER_FTP)) {

				if (dirRemoto != null) {
					ftp.changeWorkingDirectory(dirRemoto);
				}

				if (ftp.deleteFile(arqNome))
					bool = true;
			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ftp.isConnected()) {
					// ftp.logout();
					ftp.disconnect();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return bool;
	}

}
