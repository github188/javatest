package com.test.ssl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Simple_SSLSocket {
	
	private final static String CERT_STORE = "E:/test.keystore";// Ҫʹ�õ�֤����
	private final static String CERT_STORE_PASSWORD = "123456";// ֤������
	private final static String KEY_STORE_PASSWORD = "admin.123";// ֤������ʹ�õ���Ҫ����
	// ����Ҫ���ӵķ��������Ͷ˿ں�
	private static final String DEFAULT_HOST = "192.168.0.33";
	private static final int DEFAULT_PORT = 54321;

	public static void main(String args[]) {
		SSLSocket socket = null;
		// ʹ��Ĭ�ϵķ�ʽ��ȡ����ʵ��
		SSLSocketFactory sf = getSSLSocketFactory();
		try {
			// ���ӷ���˵Ķ˿ڣ�������ֹ���
			socket = (SSLSocket) sf.createSocket(DEFAULT_HOST, DEFAULT_PORT);
			socket.startHandshake();
			System.out.println("Connected to " + DEFAULT_HOST + ":"+ DEFAULT_PORT + " !");
			// �ӿ���̨����Ҫ���͸�����˵�����
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Writer writer = new OutputStreamWriter(socket.getOutputStream());
			// ���Է��������˷�����Ϣ
			boolean done = false;
			while (!done) {
				System.out.print("Send Message: ");
				String line = reader.readLine();
				if (line != null) {
					writer.write(line + "\n");
					writer.flush();
				} else {
					done = true;
				}
			}
			socket.close();
		} catch (Exception e) {
			System.out.println("Connection failed: " + e);
			try {
				socket.close();
			} catch (IOException ioe) {
			}
			socket = null;
		}
	}
	
	private static SSLSocketFactory getSSLSocketFactory() {
		System.setProperty("javax.net.ssl.trustStore", CERT_STORE);//��װ֤��
		SSLSocketFactory ssf = null;
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
			ssf = (SSLSocketFactory) context.getSocketFactory();
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