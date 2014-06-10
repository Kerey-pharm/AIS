package kz.kerey.services.api;

import kz.kerey.business.wrappers.DocumentWrapper;

public interface DocumentInterface {

	public void saveDocument(DocumentWrapper doc);
	public void deleteDocument(Long id);
	public DocumentWrapper getDocument(Long id);
	
}
