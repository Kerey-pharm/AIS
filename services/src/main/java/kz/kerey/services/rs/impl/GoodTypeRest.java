package kz.kerey.services.rs.impl;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

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
import kz.kerey.exceptions.ServicesException;
import kz.kerey.exceptions.ValidatorException;

@Path("goodType")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class GoodTypeRest {

	public static Logger logger = Logger.getLogger(DocumentRS.class.getName());
	
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
		} catch (ValidatorException ex) {
			try {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST,
						ex.getComment());
			} catch (IOException e) {
				logger.severe(e.getMessage());
			}
		} catch (ServicesException ex) {
			try {
				response.sendError(HttpServletResponse.SC_CONFLICT,
						ex.getComment());
			} catch (IOException e) {
				logger.severe(e.getMessage());
			}
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
			try {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Range is incorrect");
			} catch (IOException e) {
				logger.severe(e.getMessage());
			}
			return null;
		}
		try {
			return bean.getGoodTypeList(paged, pageNum, perPage);
		}
		catch (ServicesException ex) {
			try {
				response.sendError(HttpServletResponse.SC_CONFLICT, ex.getComment());
			} catch (IOException e) {
				logger.severe(e.getMessage());
			}
			return null;
		}
	}
	
	@DELETE
	public void deleteGoodType(
			@QueryParam("id")
			Long id) throws IOException {
		if (id == null || id == 0) {
			try {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST,
						"ID is NULL or EMPTY");
			} catch (IOException e) {
				logger.severe(e.getMessage());
			}
			return;
		}
		try {
			bean.deleteGoodType(id);
		} catch (ServicesException ex) {
			try {
				response.sendError(HttpServletResponse.SC_CONFLICT,
						ex.getComment());
			} catch (IOException e) {
				logger.severe(e.getMessage());
			}
		}
	}
	
}
