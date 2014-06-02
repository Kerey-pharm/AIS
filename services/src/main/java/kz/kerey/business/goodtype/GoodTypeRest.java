package kz.kerey.business.goodtype;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import kz.kerey.api.GoodTypeInterface;
import kz.kerey.business.wrappers.GoodTypeWrapper;
import kz.kerey.exceptions.ValidatorException;

@Path("/goodType")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class GoodTypeRest {

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;
	
	@EJB
	GoodTypeInterface bean;
	
	@Inject
	GoodTypeValidator validator;

	@POST
	public void createGoodType(
			@FormParam("goodType") 
			GoodTypeWrapper goodType) throws IOException  {
		try {
			validator.validate(goodType);
			bean.createGoodType(goodType);
		} catch (ValidatorException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,e.getComment());
			return;
		}
		
	}
	
	@GET
	public List<GoodTypeWrapper> getGoodTypeList(
			@PathParam("paged")
			Boolean paged, 
			@PathParam("pageNum")
			Integer pageNum, 
			@PathParam("perPage")
			Integer perPage) throws IOException {
		if (paged && (pageNum==null || pageNum==0 || perPage==null || perPage==0)) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,"rangeIsIncorrect");
			return null;
		}
		return bean.getGoodTypeList(paged, pageNum, perPage);
	}
	
	@DELETE
	public void deleteGoodType(
			@PathParam("id")
			Long id) throws IOException {
		if (id==null || id==0L) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,"ID is null");
			return;
		}
		bean.deleteGoodType(id);
	}
	
}
