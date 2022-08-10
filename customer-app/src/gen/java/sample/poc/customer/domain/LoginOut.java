/**
 * BX Cloud - IO Java Source Generator
 */

package sample.poc.customer.domain;

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
 * 로그인 출력 IO
 */
@XmlType(propOrder={
	"custId", "custNm"
}, name="LoginOut")
@XmlRootElement(name="LoginOut")
@BxmCategory(logicalName="로그인 출력 IO", description="로그인 출력 IO") 
public class LoginOut implements IOmmObject, Predictable, FieldInfo
{
	private static final long serialVersionUID= -466334387L;
	
	
	
	/**
	 * 고객ID
	 */
	@XmlElement
	@JsonProperty("custId")
	@BxmOmm_Field(length=20, decimal=0, description="고객ID", align="left", fill="")
	private String custId= "";
	
	
	/**
	 * 고객명
	 */
	@XmlElement
	@JsonProperty("custNm")
	@BxmOmm_Field(length=20, decimal=0, description="고객명", align="left", fill="")
	private String custNm= "";
	
	
	
	@XmlTransient
	@JsonIgnore
	private boolean isSet_custId= false;
	protected final boolean isSet_custId(){
		return this.isSet_custId;
	}
	private void setIsSet_custId(boolean value){
		this.isSet_custId= value;
	}
	/**
	 * 고객ID
	 */
	@XmlTransient
	public String getCustId(){
		return this.custId;
	}
	
	/**
	 * 고객ID
	 * 
	 * @param custId 고객ID
	 */
	public void setCustId(String custId){
		this.custId= custId;
		this.setIsSet_custId(true);
	}
	
	@XmlTransient
	@JsonIgnore
	private boolean isSet_custNm= false;
	protected final boolean isSet_custNm(){
		return this.isSet_custNm;
	}
	private void setIsSet_custNm(boolean value){
		this.isSet_custNm= value;
	}
	/**
	 * 고객명
	 */
	@XmlTransient
	public String getCustNm(){
		return this.custNm;
	}
	
	/**
	 * 고객명
	 * 
	 * @param custNm 고객명
	 */
	public void setCustNm(String custNm){
		this.custNm= custNm;
		this.setIsSet_custNm(true);
	}
				
	@Override
	public LoginOut clone(){
		try{
			LoginOut object= (LoginOut)super.clone();
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
		
		result= prime * result + ((this.custId==null)?0:this.custId.hashCode());
		result= prime * result + ((this.custNm==null)?0:this.custNm.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( this== obj ) return true;
		if ( obj== null ) return false;
		if ( getClass() != obj.getClass() ) return false;
		
		final LoginOut other= (LoginOut)obj;
		{
			Object _custId= getCustId();
			Object __custId= other.getCustId();
			if ( _custId== null ) { if ( __custId!= null ) return false; }
			else if ( !_custId.equals(__custId) ) return false;
		}
		{
			Object _custNm= getCustNm();
			Object __custNm= other.getCustNm();
			if ( _custNm== null ) { if ( __custNm!= null ) return false; }
			else if ( !_custNm.equals(__custNm) ) return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	
		sb.append("\n[").append(LoginOut.class.getName()).append(":\n");
		sb.append("\tcustId: ");
		sb.append(custId==null?"null":getCustId());
		sb.append("\n");
		sb.append("\tcustNm: ");
		sb.append(custNm==null?"null":getCustNm());
		sb.append("\n");
		sb.append("]\n");
	
		return sb.toString();
	}
	
	@Override
	public long predictMessageLength(){
		long messageLen= 0;
		
		messageLen+= 20; /* custId */
		messageLen+= 20; /* custNm */
	
		return messageLen;
	}
	
	@Override
	@JsonIgnore
	public List<String> getFieldNames(){
		List<String> list= new ArrayList<>();
	
		list.add("custId");
		list.add("custNm");
	
		return list;
	}
	
	@Override
	@JsonIgnore
	public Map<String, Object> getFieldValues(){
		Map<String, Object> map= new LinkedHashMap<>();
	
		map.put("custId", get("custId"));
		map.put("custNm", get("custNm"));
	
		return map;
	}
	
	
	@Override
	public Object get(String key) throws IllegalArgumentException{
		switch( key.hashCode() ){
		case -1349089586:/* custId */
			return getCustId();
		case -1349089422:/* custNm */
			return getCustNm();
		default:
			throw new IllegalArgumentException("Field name not found. : " + key);
		}
	}
	
	@Override
	public void set(String key, Object value){
		switch( key.hashCode() ){
		case -1349089586:/* custId */
			setCustId((String)value);
			break;
		case -1349089422:/* custNm */
			setCustNm((String)value);
			break;
		default:
			break;
		}
	}
	
}
