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
 * 고객 정보 출력 IO
 */
@XmlType(propOrder={
	"custNm", "custId", "custPasswd"
}, name="CustomerOut")
@XmlRootElement(name="CustomerOut")
@BxmCategory(logicalName="고객 정보 출력 IO", description="고객 정보 출력 IO") 
public class CustomerOut implements IOmmObject, Predictable, FieldInfo
{
	private static final long serialVersionUID= -1321826456L;
	
	
	
	/**
	 * 고객명
	 */
	@XmlElement
	@JsonProperty("custNm")
	@BxmOmm_Field(length=20, decimal=0, description="고객명", align="left", fill="")
	private String custNm= "";
	
	
	/**
	 * 고객ID
	 */
	@XmlElement
	@JsonProperty("custId")
	@BxmOmm_Field(length=20, decimal=0, description="고객ID", align="left", fill="")
	private String custId= "";
	
	
	/**
	 * 고객비밀번호
	 */
	@XmlElement
	@JsonProperty("custPasswd")
	@BxmOmm_Field(length=20, decimal=0, description="고객비밀번호", align="left", fill="")
	private String custPasswd= "";
	
	
	
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
	private boolean isSet_custPasswd= false;
	protected final boolean isSet_custPasswd(){
		return this.isSet_custPasswd;
	}
	private void setIsSet_custPasswd(boolean value){
		this.isSet_custPasswd= value;
	}
	/**
	 * 고객비밀번호
	 */
	@XmlTransient
	public String getCustPasswd(){
		return this.custPasswd;
	}
	
	/**
	 * 고객비밀번호
	 * 
	 * @param custPasswd 고객비밀번호
	 */
	public void setCustPasswd(String custPasswd){
		this.custPasswd= custPasswd;
		this.setIsSet_custPasswd(true);
	}
				
	@Override
	public CustomerOut clone(){
		try{
			CustomerOut object= (CustomerOut)super.clone();
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
		
		result= prime * result + ((this.custNm==null)?0:this.custNm.hashCode());
		result= prime * result + ((this.custId==null)?0:this.custId.hashCode());
		result= prime * result + ((this.custPasswd==null)?0:this.custPasswd.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( this== obj ) return true;
		if ( obj== null ) return false;
		if ( getClass() != obj.getClass() ) return false;
		
		final CustomerOut other= (CustomerOut)obj;
		{
			Object _custNm= getCustNm();
			Object __custNm= other.getCustNm();
			if ( _custNm== null ) { if ( __custNm!= null ) return false; }
			else if ( !_custNm.equals(__custNm) ) return false;
		}
		{
			Object _custId= getCustId();
			Object __custId= other.getCustId();
			if ( _custId== null ) { if ( __custId!= null ) return false; }
			else if ( !_custId.equals(__custId) ) return false;
		}
		{
			Object _custPasswd= getCustPasswd();
			Object __custPasswd= other.getCustPasswd();
			if ( _custPasswd== null ) { if ( __custPasswd!= null ) return false; }
			else if ( !_custPasswd.equals(__custPasswd) ) return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	
		sb.append("\n[").append(CustomerOut.class.getName()).append(":\n");
		sb.append("\tcustNm: ");
		sb.append(custNm==null?"null":getCustNm());
		sb.append("\n");
		sb.append("\tcustId: ");
		sb.append(custId==null?"null":getCustId());
		sb.append("\n");
		sb.append("\tcustPasswd: ");
		sb.append(custPasswd==null?"null":getCustPasswd());
		sb.append("\n");
		sb.append("]\n");
	
		return sb.toString();
	}
	
	@Override
	public long predictMessageLength(){
		long messageLen= 0;
		
		messageLen+= 20; /* custNm */
		messageLen+= 20; /* custId */
		messageLen+= 20; /* custPasswd */
	
		return messageLen;
	}
	
	@Override
	@JsonIgnore
	public List<String> getFieldNames(){
		List<String> list= new ArrayList<>();
	
		list.add("custNm");
		list.add("custId");
		list.add("custPasswd");
	
		return list;
	}
	
	@Override
	@JsonIgnore
	public Map<String, Object> getFieldValues(){
		Map<String, Object> map= new LinkedHashMap<>();
	
		map.put("custNm", get("custNm"));
		map.put("custId", get("custId"));
		map.put("custPasswd", get("custPasswd"));
	
		return map;
	}
	
	
	@Override
	public Object get(String key) throws IllegalArgumentException{
		switch( key.hashCode() ){
		case -1349089422:/* custNm */
			return getCustNm();
		case -1349089586:/* custId */
			return getCustId();
		case 1815616209:/* custPasswd */
			return getCustPasswd();
		default:
			throw new IllegalArgumentException("Field name not found. : " + key);
		}
	}
	
	@Override
	public void set(String key, Object value){
		switch( key.hashCode() ){
		case -1349089422:/* custNm */
			setCustNm((String)value);
			break;
		case -1349089586:/* custId */
			setCustId((String)value);
			break;
		case 1815616209:/* custPasswd */
			setCustPasswd((String)value);
			break;
		default:
			break;
		}
	}
	
}
