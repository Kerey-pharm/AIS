package kz.kerey.loaders;

import java.util.List;

import javax.swing.SwingWorker;

import kz.kerey.business.types.enums.GoodProperty;
import kz.kerey.business.wrappers.GoodWrapper;

public class GoodLoader extends Loader<GoodWrapper> {

	final private static GoodLoader self = new GoodLoader();

	private GoodLoader() {
	}

	public static GoodLoader getLoader() {
		return self;
	}

	@Override
	public List<GoodWrapper> loadElements() {
		return goodService.getGoodList(null, null, null);
	}

	@Override
	public GoodWrapper loadById(Long id) {
		return null;
	}

	@Override
	public void updateElement(GoodWrapper objWas, GoodWrapper objNew) {
		if (objWas != null && objNew != null) {
			if (!objWas.getName().equals(objNew.getName())) {
				goodService.changeGoodProperty(objNew.getId(),
						GoodProperty.name, objNew.getName());
			}

			if (!objWas.getPartialSelling().equals(objNew.getPartialSelling())) {
				goodService.changeGoodProperty(objNew.getId(),
						GoodProperty.partialSelling,
						String.valueOf(objNew.getPartialSelling()));
			}

			if (!objWas.getCountPerBox().equals(objNew.getCountPerBox())) {
				goodService.changeGoodProperty(objNew.getId(),
						GoodProperty.countPerBox,
						String.valueOf(objNew.getCountPerBox()));
			}

			if (!objWas.getCountSellable().equals(objNew.getCountSellable())) {
				goodService.changeGoodProperty(objNew.getId(),
						GoodProperty.countSellable,
						String.valueOf(objNew.getCountSellable()));
			}

			if (!objWas.getPrimaryBarcode().equals(objNew.getPrimaryBarcode())) {
				goodService
						.changeGoodProperty(objNew.getId(),
								GoodProperty.primaryBarcode,
								objNew.getPrimaryBarcode());
			}

			if (objWas.getGoodTypeId() == null
					|| !objWas.getGoodTypeId().equals(objNew.getGoodTypeId())) {
				goodService.changeGoodType(objNew.getId(),
						objNew.getGoodTypeId());
			}
		}
	}

	@Override
	public void saveElement(GoodWrapper obj) {
		goodService.createGood(obj);
	}

	@Override
	public void deleteElement(GoodWrapper obj) {
		goodService.deleteGood(obj.getId());
	}
	
}