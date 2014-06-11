package kz.kerey.services.api;

import java.util.List;

import kz.kerey.business.types.enums.GoodTypeProperty;
import kz.kerey.business.wrappers.GoodTypeWrapper;

public interface GoodTypeInterface {

	public void createGoodType(GoodTypeWrapper type);
	public void deleteGoodType(Long id);
	public List<GoodTypeWrapper> getGoodTypeList(Boolean paged, Integer pageNum, Integer perPage);
	public void changeGoodTypeProperty(Long id, GoodTypeProperty property, String newValue);
	
}
