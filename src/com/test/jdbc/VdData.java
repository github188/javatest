/*
 * @(#)VdData.java 
 *
 * Copyright (C) 2010 ������ѧ��ͨϵͳ�����о���. All rights reserved.
 *
 * ��������ʱ�䣺[Tue May 29 17:25:47 CST 2012] ����
 */ 
package com.test.jdbc;
//���� java ��
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Blob;
import java.util.*;
/**
 * ����:������潻ͨ����������DataBean��
 *
 * @author  ������
 * @date    [Tue May 29 17:25:47 CST 2012]
 *
 * $Id: VdData.java,v 1.1 2012/06/01 03:15:55 matianpeng Exp $
 */
public class VdData implements Serializable {

      
    /** 
    * �� ���
    */
    private String id;
      
    /** 
    * �� ��·���
    */
    private String roadId;
      
    /** 
    * �� �豸���
    */
    private String vdId;
      
    /** 
    * �� ����ʱ��:YYYY-MM-DD hh:mm:ss
    */
    private String recTime;
      
    /** 
    * �� �������ڣ���λ����
    */
    private Integer recPeriod;
      
    /** 
    * �� ʵ���г������Ƿ��������г�����һ�£�һ��Ϊ1������Ϊ0
    */
    private String actualDirect;
      
    /** 
    * �� ������
    */
    private Integer lineNo;
      
    /** 
    * �� ��ͨ��
    */
    private Integer flux;
      
    /** 
    * �� ��������
    */
    private Integer longFlux;
      
    /** 
    * �� �г�����
    */
    private Integer middleFlux;
      
    /** 
    * �� �̳�����
    */
    private Integer shortFlux;
      
    /** 
    * �� ƽ���ٶ�
    */
    private Double speed;
      
    /** 
    * �� ����ƽ���ٶ�
    */
    private Double longSpeed;
      
    /** 
    * �� �г�ƽ���ٶ�
    */
    private Double middleSpeed;
      
    /** 
    * �� �̳�ƽ���ٶ�
    */
    private Double shortSpeed;
      
    /** 
    * �� ռ����
    */
    private Double occupancy;
      
    /** 
    * �� ����ռ����
    */
    private Double longOccupancy;
      
    /** 
    * �� �г�ռ����
    */
    private Double middleOccupancy;
      
    /** 
    * �� �̳�ռ����
    */
    private Double shortOccupancy;
      
    /** 
    * �� ��ע
    */
    private String remark;
      
    /** 
    * �� ��¼״̬,ȱʡΪ0
    */
    private Integer state;
    
    /**
    * VdData���캯��
    */
	public VdData() {
        super();
    }


    
    /**
    * ���� Id ��get����
    * @return String
    */
    public String getId()
    {
        return id;
    }

    /**
    * ���� Id ��set����
    * @return void
    */
    public void setId(String id)
    {
        this.id = id;
    }    
        
    
    /**
    * ���� RoadId ��get����
    * @return String
    */
    public String getRoadId()
    {
        return roadId;
    }

    /**
    * ���� RoadId ��set����
    * @return void
    */
    public void setRoadId(String roadId)
    {
        this.roadId = roadId;
    }    
        
    
    /**
    * ���� VdId ��get����
    * @return String
    */
    public String getVdId()
    {
        return vdId;
    }

    /**
    * ���� VdId ��set����
    * @return void
    */
    public void setVdId(String vdId)
    {
        this.vdId = vdId;
    }    
        
    
    /**
    * ���� RecTime ��get����
    * @return String
    */
    public String getRecTime()
    {
        return recTime;
    }

    /**
    * ���� RecTime ��set����
    * @return void
    */
    public void setRecTime(String recTime)
    {
        this.recTime = recTime;
    }    
        
    
    /**
    * ���� RecPeriod ��get����
    * @return Integer
    */
    public Integer getRecPeriod()
    {
        return recPeriod;
    }

    /**
    * ���� RecPeriod ��set����
    * @return void
    */
    public void setRecPeriod(Integer recPeriod)
    {
        this.recPeriod = recPeriod;
    }    
        
    
    /**
    * ���� ActualDirect ��get����
    * @return String
    */
    public String getActualDirect()
    {
        return actualDirect;
    }

    /**
    * ���� ActualDirect ��set����
    * @return void
    */
    public void setActualDirect(String actualDirect)
    {
        this.actualDirect = actualDirect;
    }    
        
    
    /**
    * ���� LineNo ��get����
    * @return Integer
    */
    public Integer getLineNo()
    {
        return lineNo;
    }

    /**
    * ���� LineNo ��set����
    * @return void
    */
    public void setLineNo(Integer lineNo)
    {
        this.lineNo = lineNo;
    }    
        
    
    /**
    * ���� Flux ��get����
    * @return Integer
    */
    public Integer getFlux()
    {
        return flux;
    }

    /**
    * ���� Flux ��set����
    * @return void
    */
    public void setFlux(Integer flux)
    {
        this.flux = flux;
    }    
        
    
    /**
    * ���� LongFlux ��get����
    * @return Integer
    */
    public Integer getLongFlux()
    {
        return longFlux;
    }

    /**
    * ���� LongFlux ��set����
    * @return void
    */
    public void setLongFlux(Integer longFlux)
    {
        this.longFlux = longFlux;
    }    
        
    
    /**
    * ���� MiddleFlux ��get����
    * @return Integer
    */
    public Integer getMiddleFlux()
    {
        return middleFlux;
    }

    /**
    * ���� MiddleFlux ��set����
    * @return void
    */
    public void setMiddleFlux(Integer middleFlux)
    {
        this.middleFlux = middleFlux;
    }    
        
    
    /**
    * ���� ShortFlux ��get����
    * @return Integer
    */
    public Integer getShortFlux()
    {
        return shortFlux;
    }

    /**
    * ���� ShortFlux ��set����
    * @return void
    */
    public void setShortFlux(Integer shortFlux)
    {
        this.shortFlux = shortFlux;
    }    
        
    
    /**
    * ���� Speed ��get����
    * @return Double
    */
    public Double getSpeed()
    {
        return speed;
    }

    /**
    * ���� Speed ��set����
    * @return void
    */
    public void setSpeed(Double speed)
    {
        this.speed = speed;
    }    
        
    
    /**
    * ���� LongSpeed ��get����
    * @return Double
    */
    public Double getLongSpeed()
    {
        return longSpeed;
    }

    /**
    * ���� LongSpeed ��set����
    * @return void
    */
    public void setLongSpeed(Double longSpeed)
    {
        this.longSpeed = longSpeed;
    }    
        
    
    /**
    * ���� MiddleSpeed ��get����
    * @return Double
    */
    public Double getMiddleSpeed()
    {
        return middleSpeed;
    }

    /**
    * ���� MiddleSpeed ��set����
    * @return void
    */
    public void setMiddleSpeed(Double middleSpeed)
    {
        this.middleSpeed = middleSpeed;
    }    
        
    
    /**
    * ���� ShortSpeed ��get����
    * @return Double
    */
    public Double getShortSpeed()
    {
        return shortSpeed;
    }

    /**
    * ���� ShortSpeed ��set����
    * @return void
    */
    public void setShortSpeed(Double shortSpeed)
    {
        this.shortSpeed = shortSpeed;
    }    
        
    
    /**
    * ���� Occupancy ��get����
    * @return Double
    */
    public Double getOccupancy()
    {
        return occupancy;
    }

    /**
    * ���� Occupancy ��set����
    * @return void
    */
    public void setOccupancy(Double occupancy)
    {
        this.occupancy = occupancy;
    }    
        
    
    /**
    * ���� LongOccupancy ��get����
    * @return Double
    */
    public Double getLongOccupancy()
    {
        return longOccupancy;
    }

    /**
    * ���� LongOccupancy ��set����
    * @return void
    */
    public void setLongOccupancy(Double longOccupancy)
    {
        this.longOccupancy = longOccupancy;
    }    
        
    
    /**
    * ���� MiddleOccupancy ��get����
    * @return Double
    */
    public Double getMiddleOccupancy()
    {
        return middleOccupancy;
    }

    /**
    * ���� MiddleOccupancy ��set����
    * @return void
    */
    public void setMiddleOccupancy(Double middleOccupancy)
    {
        this.middleOccupancy = middleOccupancy;
    }    
        
    
    /**
    * ���� ShortOccupancy ��get����
    * @return Double
    */
    public Double getShortOccupancy()
    {
        return shortOccupancy;
    }

    /**
    * ���� ShortOccupancy ��set����
    * @return void
    */
    public void setShortOccupancy(Double shortOccupancy)
    {
        this.shortOccupancy = shortOccupancy;
    }    
        
    
    /**
    * ���� Remark ��get����
    * @return String
    */
    public String getRemark()
    {
        return remark;
    }

    /**
    * ���� Remark ��set����
    * @return void
    */
    public void setRemark(String remark)
    {
        this.remark = remark;
    }    
        
    
    /**
    * ���� State ��get����
    * @return Integer
    */
    public Integer getState()
    {
        return state;
    }

    /**
    * ���� State ��set����
    * @return void
    */
    public void setState(Integer state)
    {
        this.state = state;
    }    
        

  
   	public String toString()
   	{
   	    StringBuffer sb = new StringBuffer();
        sb.append(" [ id="+ id);
        sb.append(", roadId="+ roadId);
        sb.append(", vdId="+ vdId);
        sb.append(", recTime="+ recTime);
        sb.append(", recPeriod="+ recPeriod);
        sb.append(", actualDirect="+ (actualDirect==null?null:actualDirect.trim()));
        sb.append(", lineNo="+ lineNo);
        sb.append(", flux="+ flux);
        sb.append(", longFlux="+ longFlux);
        sb.append(", middleFlux="+ middleFlux);
        sb.append(", shortFlux="+ shortFlux);
        sb.append(", speed="+ speed);
        sb.append(", longSpeed="+ longSpeed);
        sb.append(", middleSpeed="+ middleSpeed);
        sb.append(", shortSpeed="+ shortSpeed);
        sb.append(", occupancy="+ occupancy);
        sb.append(", longOccupancy="+ longOccupancy);
        sb.append(", middleOccupancy="+ middleOccupancy);
        sb.append(", shortOccupancy="+ shortOccupancy);
        sb.append(", remark="+ remark);
        sb.append(", state="+ state);
        sb.append("]");
        
        return sb.toString();
   	}
   	

   	@Override
   	public boolean equals(Object obj) {
   		VdData other=(VdData)obj;
   		return this.toString().equals(other.toString());
   	}
   	
   	//ȡ�汾��Ϣ
    public static String getVERInfo()
    {
        return "$Date: 2012/06/01 03:15:55 $,$Author: matianpeng $,$Revision: 1.1 $";
    }
            
    
}