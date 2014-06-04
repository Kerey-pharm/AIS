package kz.kerey.services.rs.impl;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import kz.kerey.services.api.GoodTypeInterface;
import kz.kerey.business.goodtype.GoodTypeValidator;
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
	public void createGoodType(GoodTypeWrapper goodType) throws IOException  {
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
			@QueryParam("paged")
			Boolean paged, 
			@QueryParam("pageNum")
			Integer pageNum, 
			@QueryParam("perPage")
			Integer perPage) throws IOException {
		if (paged==null || (paged && (pageNum==null || pageNum==0 || perPage==null || perPage==0))) {
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
