package kz.kerey.services.api;

import java.util.List;

import kz.kerey.business.types.PageParam;
import kz.kerey.business.types.enums.GoodProperty;
import kz.kerey.business.wrappers.GoodWrapper;

public interface GoodInterface {

	public void createGood(GoodWrapper obj);
	public void deleteGood(Long id);
	public List<GoodWrapper> getGoodList(PageParam params, String nameFilter, String barcode);
	public void changeGoodProperty(Long id, GoodProperty property, String newValue);
	public void changeGoodType(Long id, Long goodTypeId);
	
}