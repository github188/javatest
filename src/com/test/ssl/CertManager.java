package com.test.ssl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/**
 * Java�����Զ���ȡ����װ֤�鹤����
 * 
 * @author �ų�
 * 
 * Jan 26, 2014
 */
public class CertManager {

	public static void main(String[] args) {
		try {
			trustCert("d:\\", "www.google.com.hk", 443, "changeit");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param dir
	 *            ֤������·��
	 * @param host
	 *            ������ַ
	 * @param port
	 *            �˿�
	 * @param password
	 *            ֤������
	 * @throws Exception
	 */
	public static void trustCert(String dir, String host, int port,
			String password) throws Exception {
		// ���֤���̸�����������ͨ�ŵ�������һ�µĻ�����ô��Ҫ��дУ�鷽��
		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String urlHostName, SSLSession session) {
				return urlHostName.equals(session.getPeerHost());
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);

		// ���ι���������
		TrustManagerFactory tmf = TrustManagerFactory
				.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		File file = new File(dir + host + ".cer");
		file = makeSureFile(file);
		KeyStore ks = getKeyStore(file, password);
		tmf.init(ks);

		SSLContext context = SSLContext.getInstance("SSL");
		X509TrustManager defaultTrustManager = (X509TrustManager) tmf
				.getTrustManagers()[0];
		SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);
		context.init(null, new TrustManager[] { tm }, null);

		// ����ʹ��socket��Ŀ����������ͨ��
		SSLSocketFactory factory = context.getSocketFactory();
		SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
		socket.setSoTimeout(1000);
		try {
			// ���ֱ��ͨ��û����Ļ�,�Ͳ��ᱨ��,Ҳ���ػ�ȡ֤��
			// �������Ļ�,���п���û��֤��
			socket.startHandshake();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (Exception e) {
				}
				socket = null;
			}
			X509Certificate[] chain = tm.getChain();
			if (chain != null) {
				System.out.println("���������أ�" + chain.length + " ��֤��");
				OutputStream out = null;
				for (int i = 0; i < chain.length; i++) {
					try {
						X509Certificate x509Cert = chain[i];
						String alias = host + (i > 0 ? i + "" : "");
						ks.setCertificateEntry(alias, x509Cert);

						String certFile = dir + alias + ".cer";
						out = new FileOutputStream(certFile);
						ks.store(out, password.toCharArray());
						out.close();

						System
								.setProperty("javax.net.ssl.trustStore",
										certFile);
						System.out.println("��" + (i + 1) + "��֤�鰲װ�ɹ�");
					} catch (Exception e) {
						e.printStackTrace();
						continue;
					} finally {
						try {
							if (out != null) {
								out.close();
							}
							out = null;
						} catch (Exception e) {
						}
					}
				}
			}
		}
	}

	/**
	 * ȷ���ļ�����
	 * 
	 * @param file
	 * @return
	 */
	private static File makeSureFile(File file) {
		if (file.isFile() == false) {
			char SEP = File.separatorChar;
			File dir = new File(System.getProperty("java.home") + SEP + "lib"
					+ SEP + "security");
			file = new File(dir, file.getName());
			if (file.isFile() == false) {
				file = new File(dir, "cacerts");
			}
		}
		return file;
	}

	/**
	 * ��ȡkeystore
	 * 
	 * @param file
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private static KeyStore getKeyStore(File file, String password)
			throws Exception {
		InputStream in = new FileInputStream(file);
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		char[] passphrase = password.toCharArray();
		ks.load(in, passphrase);
		in.close();
		return ks;
	}

	public static class SavingTrustManager implements X509TrustManager {
		private final X509TrustManager tm;
		private X509Certificate[] chain;

		public SavingTrustManager(X509TrustManager tm) {
			this.tm = tm;
		}

		public X509TrustManager getTM() {
			return tm;
		}

		public X509Certificate[] getChain() {
			return chain;
		}

		public X509Certificate[] getAcceptedIssuers() {
			throw new UnsupportedOperationException();
		}

		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
			throw new UnsupportedOperationException();
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
			this.chain = chain;
			tm.checkServerTrusted(chain, authType);
		}
	}
}
