package com.test.ssl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class Simple_SSLServerSocket {
	
	private final static int LISTEN_PORT = 54321;// �����˼����˿ں�
	private final static String CERT_STORE = "E:/test.keystore";// Ҫʹ�õ�֤����
	private final static String CERT_STORE_PASSWORD = "123456";// ֤������
	private final static String KEY_STORE_PASSWORD = "admin.123";// ֤������ʹ�õ���Ҫ����

	public static void main(String args[]) throws Exception {
		startServer();
	}

	public static void startServer() throws Exception, IOException {
		SSLServerSocket serverSocket = null;
		SSLSocket clientSocket = null;
		// ʹ��Ĭ�Ϸ�ʽ��ȡ�׽��ֹ���ʵ��
		// SSLServerSocketFactory ssf = (SSLServerSocketFactory)
		// SSLServerSocketFactory.getDefault();

		// ��ص� jks �ļ��������붨��
		// ���� jks �ļ�
		SSLServerSocketFactory ssf = getSSLServerSocketFactory();

		try {
			serverSocket = (SSLServerSocket) ssf.createServerSocket(LISTEN_PORT);
			// ���ò���Ҫ��֤�ͻ������
			serverSocket.setNeedClientAuth(false);
			System.out.println("SSLServer is listening on " + LISTEN_PORT+ " port");
			// ѭ�������˿ڣ�����пͻ���������¿�һ���߳���֮ͨ��
			while (true) {
				// �����µĿͻ�������
				clientSocket = (SSLSocket) serverSocket.accept();
				ClientConnection clientConnection = new ClientConnection(clientSocket);
				// ����һ���µ��߳�
				Thread clientThread = new Thread(clientConnection);
				System.out.println("Client " + clientThread.getId()+ " is connected");
				clientThread.run();
			}
		} catch (IOException ioExp) {
			ioExp.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			serverSocket.close();
		}
	}

	private static SSLServerSocketFactory getSSLServerSocketFactory() {
		System.setProperty("javax.net.ssl.trustStore", CERT_STORE);
		SSLServerSocketFactory ssf = null;
		try {
			FileInputStream f_certStore = new FileInputStream(CERT_STORE);
			// ����JKS��Կ��
			KeyStore ks = KeyStore.getInstance("JKS");
			ks.load(f_certStore, CERT_STORE_PASSWORD.toCharArray());
			// ��������JKS��Կ���X.509��Կ������
			KeyManagerFactory kf = KeyManagerFactory.getInstance("SunX509");
			kf.init(ks, KEY_STORE_PASSWORD.toCharArray());

			KeyManager[] kms = kf.getKeyManagers();

			// ����SSL������ָ��SSL�汾Ϊ3.0��Ҳ����ʹ��TLSv1������SSLv3���ӳ��á�
			SSLContext context = SSLContext.getInstance("SSLv3");
			context.init(kms, null, null);
			ssf = (SSLServerSocketFactory) context.getServerSocketFactory();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		return ssf;
	}
}

class ClientConnection implements Runnable {
	private Socket clientSocket = null;

	public ClientConnection(SSLSocket sslsocket) {
		clientSocket = sslsocket;
	}

	public void run() {
		BufferedReader reader = null;
		// �����յ������Կͻ��˵����ִ�ӡ����
		try {
			reader = new BufferedReader(new InputStreamReader(clientSocket
					.getInputStream()));
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					System.out.println("Communication end.");
					break;
				}
				System.out.println("Receive message: " + line);
			}
			reader.close();
			clientSocket.close();
		} catch (IOException ioExp) {
			ioExp.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}