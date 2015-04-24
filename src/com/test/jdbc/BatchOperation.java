package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.test.jdbc.VdData;

public class BatchOperation {

	final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	final String url = "jdbc:sqlserver://192.168.0.12:1433;databaseName=localTest";

	final String user = "sa";

	final String password = "123";

	public void insertBatch(List<VdData> datas){
		String sql = getInsertSql();
		Connection conn =null;
		PreparedStatement ps=null;
		int loopNum=datas.size();
    	try {
    		conn=getConn();
			conn.setAutoCommit(false);
			ps =conn.prepareStatement(sql);
			for(int i=0;i<loopNum;i++){
				setParamValue(ps,datas.get(i));
				ps.addBatch();
				if(loopNum%1000==0){
					ps.executeBatch();
					conn.commit();
					ps.clearBatch();
				}
			}
			ps.executeBatch();
			conn.commit();
			ps.clearBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					if(conn!=null){
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	//һ�������ӳ�
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
	
	 public static String getInsertSql()
	    {
	        StringBuffer sb = new StringBuffer();
	        sb.append("INSERT INTO ");
	        sb.append("VDDATA");
	        sb.append("(");
	    	sb.append("ID"); //���
	    	sb.append(",");
	    	sb.append("ROAD_ID"); //��·���
	    	sb.append(",");
	    	sb.append("VD_ID"); //�豸���
	    	sb.append(",");
	    	sb.append("REC_TIME"); //����ʱ��:YYYY-MM-DD hh:mm:ss
	    	sb.append(",");
	    	sb.append("REC_PERIOD"); //�������ڣ���λ����
	    	sb.append(",");
	    	sb.append("ACTUAL_DIRECT"); //ʵ���г������Ƿ��������г�����һ�£�һ��Ϊ1������Ϊ0
	    	sb.append(",");
	    	sb.append("LINE_NO"); //������
	    	sb.append(",");
	    	sb.append("FLUX"); //��ͨ��
	    	sb.append(",");
	    	sb.append("LONG_FLUX"); //��������
	    	sb.append(",");
	    	sb.append("MIDDLE_FLUX"); //�г�����
	    	sb.append(",");
	    	sb.append("SHORT_FLUX"); //�̳�����
	    	sb.append(",");
	    	sb.append("SPEED"); //ƽ���ٶ�
	    	sb.append(",");
	    	sb.append("LONG_SPEED"); //����ƽ���ٶ�
	    	sb.append(",");
	    	sb.append("MIDDLE_SPEED"); //�г�ƽ���ٶ�
	    	sb.append(",");
	    	sb.append("SHORT_SPEED"); //�̳�ƽ���ٶ�
	    	sb.append(",");
	    	sb.append("OCCUPANCY"); //ռ����
	    	sb.append(",");
	    	sb.append("LONG_OCCUPANCY"); //����ռ����
	    	sb.append(",");
	    	sb.append("MIDDLE_OCCUPANCY"); //�г�ռ����
	    	sb.append(",");
	    	sb.append("SHORT_OCCUPANCY"); //�̳�ռ����
	    	sb.append(",");
	    	sb.append("REMARK"); //��ע
	    	sb.append(",");
	    	sb.append("STATE"); //��¼״̬,ȱʡΪ0
	    	sb.append(") VALUES(");
	    	sb.append("?");  //���
	    	sb.append(",");
	    	sb.append("?");  //��·���
	    	sb.append(",");
	    	sb.append("?");  //�豸���
	    	sb.append(",");
	    	sb.append("?");  //����ʱ��:YYYY-MM-DD hh:mm:ss
	    	sb.append(",");
	    	sb.append("?");  //�������ڣ���λ����
	    	sb.append(",");
	    	sb.append("?");  //ʵ���г������Ƿ��������г�����һ�£�һ��Ϊ1������Ϊ0
	    	sb.append(",");
	    	sb.append("?");  //������
	    	sb.append(",");
	    	sb.append("?");  //��ͨ��
	    	sb.append(",");
	    	sb.append("?");  //��������
	    	sb.append(",");
	    	sb.append("?");  //�г�����
	    	sb.append(",");
	    	sb.append("?");  //�̳�����
	    	sb.append(",");
	    	sb.append("?");  //ƽ���ٶ�
	    	sb.append(",");
	    	sb.append("?");  //����ƽ���ٶ�
	    	sb.append(",");
	    	sb.append("?");  //�г�ƽ���ٶ�
	    	sb.append(",");
	    	sb.append("?");  //�̳�ƽ���ٶ�
	    	sb.append(",");
	    	sb.append("?");  //ռ����
	    	sb.append(",");
	    	sb.append("?");  //����ռ����
	    	sb.append(",");
	    	sb.append("?");  //�г�ռ����
	    	sb.append(",");
	    	sb.append("?");  //�̳�ռ����
	    	sb.append(",");
	    	sb.append("?");  //��ע
	    	sb.append(",");
	    	sb.append("?");  //��¼״̬,ȱʡΪ0
	    	sb.append(")");
	    	return sb.toString();
	    }
	 
	 public void setParamValue(PreparedStatement ps,VdData vd){
	    	try {
				ps.setString(1, vd.getId());
				ps.setString(2, vd.getRoadId());
				ps.setString(3, vd.getVdId());
				ps.setString(4, vd.getRecTime());
				ps.setInt(5, vd.getRecPeriod());
				ps.setObject(6, vd.getActualDirect());
				ps.setObject(7, vd.getLineNo());
				ps.setObject(8, vd.getFlux());
				ps.setObject(9, vd.getLongFlux());
				ps.setObject(10, vd.getMiddleFlux());
				ps.setObject(11, vd.getShortFlux());
				ps.setObject(12, vd.getSpeed());
				ps.setObject(13, vd.getLongSpeed());
				ps.setObject(14, vd.getMiddleSpeed());
				ps.setObject(15, vd.getShortSpeed());
				ps.setObject(16, vd.getOccupancy());
				ps.setObject(17, vd.getLongOccupancy());
				ps.setObject(18, vd.getMiddleOccupancy());
				ps.setObject(19, vd.getShortOccupancy());
				ps.setString(20, vd.getRemark());
				ps.setObject(21, vd.getState());
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
}
