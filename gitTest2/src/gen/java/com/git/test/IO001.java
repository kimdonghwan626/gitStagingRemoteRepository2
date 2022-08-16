/**
 * BX Cloud - IO Java Source Generator
 */

package com.git.test;

import bxm.common.annotaion.BxmCategory;
import bxm.omm.annotation.BxmOmm_Field;
import bxm.omm.exception.CloneFailedException;
import bxm.omm.predict.FieldInfo;
import bxm.omm.predict.Predictable;
import bxm.omm.root.IOmmObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * IO001
 */
@XmlType(propOrder={
	"srch", "cust"
}, name="IO001")
@XmlRootElement(name="IO001")
@BxmCategory(logicalName="IO001", description="IO001") 
public class IO001 implements IOmmObject, Predictable, FieldInfo
{
	private static final long serialVersionUID= 1167355544L;
	
	
	
	/**
	 * 검색
	 */
	@XmlElement
	@JsonProperty("srch")
	@BxmOmm_Field(length=99, decimal=0, description="검색", align="left", fill="")
	private String srch= "";
	
	
	/**
	 * 고객
	 */
	@XmlElement
	@JsonProperty("cust")
	@BxmOmm_Field(length=50, decimal=0, description="고객", align="left", fill="")
	private String cust= "";
	
	
	
	@XmlTransient
	@JsonIgnore
	private boolean isSet_srch= false;
	protected final boolean isSet_srch(){
		return this.isSet_srch;
	}
	private void setIsSet_srch(boolean value){
		this.isSet_srch= value;
	}
	/**
	 * 검색
	 */
	@XmlTransient
	public String getSrch(){
		return this.srch;
	}
	
	/**
	 * 검색
	 * 
	 * @param srch 검색
	 */
	public void setSrch(String srch){
		this.srch= srch;
		this.setIsSet_srch(true);
	}
	
	@XmlTransient
	@JsonIgnore
	private boolean isSet_cust= false;
	protected final boolean isSet_cust(){
		return this.isSet_cust;
	}
	private void setIsSet_cust(boolean value){
		this.isSet_cust= value;
	}
	/**
	 * 고객
	 */
	@XmlTransient
	public String getCust(){
		return this.cust;
	}
	
	/**
	 * 고객
	 * 
	 * @param cust 고객
	 */
	public void setCust(String cust){
		this.cust= cust;
		this.setIsSet_cust(true);
	}
				
	@Override
	public IO001 clone(){
		try{
			IO001 object= (IO001)super.clone();
			return object;
		}
		catch(CloneNotSupportedException e){
			throw new CloneFailedException(e);
		}
	}
	
	@Override
	public int hashCode(){
		final int prime=31;
		int result= 1;
		
		result= prime * result + ((this.srch==null)?0:this.srch.hashCode());
		result= prime * result + ((this.cust==null)?0:this.cust.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( this== obj ) return true;
		if ( obj== null ) return false;
		if ( getClass() != obj.getClass() ) return false;
		
		final IO001 other= (IO001)obj;
		{
			Object _srch= getSrch();
			Object __srch= other.getSrch();
			if ( _srch== null ) { if ( __srch!= null ) return false; }
			else if ( !_srch.equals(__srch) ) return false;
		}
		{
			Object _cust= getCust();
			Object __cust= other.getCust();
			if ( _cust== null ) { if ( __cust!= null ) return false; }
			else if ( !_cust.equals(__cust) ) return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	
		sb.append("\n[").append(IO001.class.getName()).append(":\n");
		sb.append("\tsrch: ");
		sb.append(srch==null?"null":getSrch());
		sb.append("\n");
		sb.append("\tcust: ");
		sb.append(cust==null?"null":getCust());
		sb.append("\n");
		sb.append("]\n");
	
		return sb.toString();
	}
	
	@Override
	public long predictMessageLength(){
		long messageLen= 0;
		
		messageLen+= 99; /* srch */
		messageLen+= 50; /* cust */
	
		return messageLen;
	}
	
	@Override
	@JsonIgnore
	public List<String> getFieldNames(){
		List<String> list= new ArrayList<>();
	
		list.add("srch");
		list.add("cust");
	
		return list;
	}
	
	@Override
	@JsonIgnore
	public Map<String, Object> getFieldValues(){
		Map<String, Object> map= new LinkedHashMap<>();
	
		map.put("srch", get("srch"));
		map.put("cust", get("cust"));
	
		return map;
	}
	
	
	@Override
	public Object get(String key) throws IllegalArgumentException{
		switch( key.hashCode() ){
		case 3538692:/* srch */
			return getSrch();
		case 3065427:/* cust */
			return getCust();
		default:
			throw new IllegalArgumentException("Field name not found. : " + key);
		}
	}
	
	@Override
	public void set(String key, Object value){
		switch( key.hashCode() ){
		case 3538692:/* srch */
			setSrch((String)value);
			break;
		case 3065427:/* cust */
			setCust((String)value);
			break;
		default:
			break;
		}
	}
	
}
