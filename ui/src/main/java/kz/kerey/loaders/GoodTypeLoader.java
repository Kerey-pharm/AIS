package kz.kerey.loaders;

import java.util.List;

import kz.kerey.business.types.enums.GoodTypeProperty;
import kz.kerey.business.wrappers.GoodTypeWrapper;

public class GoodTypeLoader extends Loader<GoodTypeWrapper> {

	final private static GoodTypeLoader self = new GoodTypeLoader();
	private GoodTypeLoader() {
	}
	public static GoodTypeLoader getLoader() {
		return self;
	}
	
	@Override
	public List<GoodTypeWrapper> loadElements() {
		return goodTypeService.getGoodTypeList(false, 0, 0);
	}

	@Override
	public GoodTypeWrapper loadById(Long id) {
		return null;
	}

	@Override
	public void updateElement(GoodTypeWrapper objWas, GoodTypeWrapper objNew) {
		if (objWas!=null && objNew!=null) {
			if (!objWas.getName().equals(objNew.getName())) {
				goodTypeService.changeGoodTypeProperty(objNew.getId(), GoodTypeProperty.name, objNew.getName());
			}
		}
	}

	@Override
	public void saveElement(GoodTypeWrapper obj) {
		goodTypeService.createGoodType(obj);
	}

}