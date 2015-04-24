package com.test.serversocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketTests {

	private static int PORT = 3131; // �˿ں�
	private List<RecieveTask> clientList = new ArrayList<RecieveTask>(); // �������Ӷ���
	private ExecutorService pool;
	private static ServerSocketTests socketServer;
	
	private boolean stoped=false;
	private Thread serverThread;
	
	private ServerSocketTests() {

	}
	
	public static synchronized ServerSocketTests getInstance() {
		if (socketServer==null) {
			socketServer = new ServerSocketTests();
		}
		return socketServer;
	}
	private ServerSocket server;
	public void startServer(){
		serverThread = new Thread("stratServer"){
			@Override
			public void run() {
				try {
					server = new ServerSocket(PORT);
					System.out.println(server.getReceiveBufferSize()/1024);//8k
					System.out.println(server.getReuseAddress());
					pool = Executors.newCachedThreadPool();
					Socket client = null;
					String ip;
					while (!stoped) {
						client = server.accept(); // ���տͻ�����
						ip = client.getInetAddress().getHostAddress();
						RecieveTask task = new RecieveTask(client,ip);
						addClient(task);
						System.out.println("���յ�һ������:"+ip);
						pool.execute(task);
					}
				} catch (Exception e) {
					System.out.println("���տͻ����ӳ���"+e);
				}
			}};
			serverThread.start();
	}
	
	public void stopServer(){
		stoped=true;
		pool.shutdown();
		pool=null;
		if(server!=null){
			try {
				server.close();
				server=null;
			} catch (IOException e) {
				System.out.println("�����豸�ɼ�ֹͣ"+e);
			}
		}
		if(serverThread!=null&&serverThread.isAlive()){
			serverThread.interrupt();
			serverThread=null;
		}
	}
	
	private synchronized void addClient(RecieveTask task) {
		int index = getTask(task);
		if(index>-1){
			clientList.get(index).destroy();
		}
		clientList.add(task);
	}

	private synchronized void removeTask(RecieveTask task){
		int index = getTask(task);
		if(index>-1){
			clientList.remove(index);
		}
	}
	
	private synchronized int getTask(RecieveTask rt){
		for(int i=0;i<clientList.size();i++){
			if(clientList.get(i).clientIp.equals(rt.clientIp)){
				return i;
			}
		}
		return -1;
	}
	
	class RecieveTask implements Runnable {
		private Socket socket;
		private InputStream  iis;
		private String clientIp;
		private byte[] responses;
		private boolean isAcceptData=true;
		
		public void destroy(){
			try {
				isAcceptData=false;
				removeTask(this);
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public RecieveTask(Socket socket,String clientIp) throws IOException {
			this.socket = socket;
			this.clientIp = clientIp;
		}

		public void run() {
			while(isAcceptData){
				dealData();
			}
		}

		private void dealData() {
			try{
				iis = socket.getInputStream();
				int availabeLength = iis.available();//��ȡ�ɽ������ݳ���
				if(availabeLength>0){
					responses = new byte[availabeLength];
					int result = iis.read(responses);//�������ݳ���
					if(result==-1){//�����жϿͻ����Ƿ������ӣ�һ���ͻ����쳣�жϣ��˴�Ϊ-1
						destroy();
						throw new RuntimeException();
					}
				}
				/*
				 * ���ݴ���-------------------------------
				 */
			}catch(Exception e){
				throw new RuntimeException("��socket���Ӷ�ȡ���ݳ����������ڿͻ��������жϵ��¡�ip:"+clientIp);
			}
		}

		public Socket getSocket() {
			return socket;
		}

		public void setSocket(Socket socket) {
			this.socket = socket;
		}

		public String getClientIp() {
			return clientIp;
		}

		public void setClientIp(String clientIp) {
			this.clientIp = clientIp;
		}

		public boolean isAcceptData() {
			return isAcceptData;
		}

		public void setAcceptData(boolean isAcceptData) {
			this.isAcceptData = isAcceptData;
		}
	}
}
