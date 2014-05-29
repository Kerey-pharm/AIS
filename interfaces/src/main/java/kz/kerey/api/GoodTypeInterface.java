package kz.kerey.api;

import java.util.List;

import kz.kerey.business.wrappers.GoodTypeWrapper;

public interface GoodTypeInterface {

	public List<GoodTypeWrapper> getGoodTypeList(boolean paged, Integer pageNum, Integer perPage);
	
	public void deleteGoodType(Long id);
	
	public void createGoodType(GoodTypeWrapper type);
	
}
