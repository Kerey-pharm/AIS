package kz.kerey.business.wrappers;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DocumentWrapper implements Serializable {

	private static final long serialVersionUID = -1625326160173185564L;
	
	private Long id;
	private String docType;
	private String docExtension;
	private String docName;
	private byte[] data;

	public Long getId() {
		return id;
	}
	public String getDocExtension() {
		return docExtension;
	}
	public void setDocExtension(String docExtension) {
		this.docExtension = docExtension;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
}
