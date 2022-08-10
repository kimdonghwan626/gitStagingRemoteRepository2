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
 * 고객 정보 입력 IO
 */
@XmlType(propOrder={
	"custId"
}, name="CustomerIn")
@XmlRootElement(name="CustomerIn")
@BxmCategory(logicalName="고객 정보 입력 IO", description="고객 정보 입력 IO") 
public class CustomerIn implements IOmmObject, Predictable, FieldInfo
{
	private static final long serialVersionUID= -1289565749L;
	
	
	
	/**
	 * 고객ID
	 */
	@XmlElement
	@JsonProperty("custId")
	@BxmOmm_Field(length=20, decimal=0, description="고객ID", align="left", fill="")
	private String custId= "";
	
	
	
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
				
	@Override
	public CustomerIn clone(){
		try{
			CustomerIn object= (CustomerIn)super.clone();
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
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( this== obj ) return true;
		if ( obj== null ) return false;
		if ( getClass() != obj.getClass() ) return false;
		
		final CustomerIn other= (CustomerIn)obj;
		{
			Object _custId= getCustId();
			Object __custId= other.getCustId();
			if ( _custId== null ) { if ( __custId!= null ) return false; }
			else if ( !_custId.equals(__custId) ) return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	
		sb.append("\n[").append(CustomerIn.class.getName()).append(":\n");
		sb.append("\tcustId: ");
		sb.append(custId==null?"null":getCustId());
		sb.append("\n");
		sb.append("]\n");
	
		return sb.toString();
	}
	
	@Override
	public long predictMessageLength(){
		long messageLen= 0;
		
		messageLen+= 20; /* custId */
	
		return messageLen;
	}
	
	@Override
	@JsonIgnore
	public List<String> getFieldNames(){
		List<String> list= new ArrayList<>();
	
		list.add("custId");
	
		return list;
	}
	
	@Override
	@JsonIgnore
	public Map<String, Object> getFieldValues(){
		Map<String, Object> map= new LinkedHashMap<>();
	
		map.put("custId", get("custId"));
	
		return map;
	}
	
	
	@Override
	public Object get(String key) throws IllegalArgumentException{
		switch( key.hashCode() ){
		case -1349089586:/* custId */
			return getCustId();
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
		default:
			break;
		}
	}
	
}
