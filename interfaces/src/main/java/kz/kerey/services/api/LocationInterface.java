package kz.kerey.services.api;

import java.util.List;

import kz.kerey.business.types.enums.LocationProperty;
import kz.kerey.business.wrappers.LocationWrapper;

public interface LocationInterface {

	public void createLocation(LocationWrapper location);
	public void deleteLocation(Long id);
	public void changeLocation(Long id, LocationProperty property, String newValue);
	public List<LocationWrapper> getLocationsList(Boolean paged, Integer pageNum, Integer perPage);
	
}
