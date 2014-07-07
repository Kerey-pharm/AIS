package kz.kerey.loaders;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import kz.kerey.services.api.DocumentInterface;
import kz.kerey.services.api.FlowConfigurationInterface;
import kz.kerey.services.api.FlowInterface;
import kz.kerey.services.api.GoodInterface;
import kz.kerey.services.api.GoodTypeInterface;
import kz.kerey.services.api.LocationInterface;
import kz.kerey.services.api.UserInterface;

public abstract class Loader<T> {

	final private static String goodTypeJndiName = "ejb:/services//GoodTypeEJB!kz.kerey.services.api.GoodTypeInterface";
	final private static String docJndiName = "ejb:/services//DocumentEJB!kz.kerey.services.api.DocumentInterface";
	final private static String flowConfJndiName = "ejb:/services//FlowConfigurationEJB!kz.kerey.services.api.FlowConfigurationInterface";
	final private static String flowJndiName = "ejb:/services//FlowEJB!kz.kerey.services.api.FlowInterface";
	final private static String locationJndiName = "ejb:/services//LocationEJB!kz.kerey.services.api.LocationInterface";
	final private static String userJndiName = "ejb:/services//UserEJB!kz.kerey.services.api.UserInterface";
	final private static String goodJndiName = "ejb:/services//GoodEJB!kz.kerey.services.api.GoodInterface";
	
	static GoodTypeInterface goodTypeService;
	static DocumentInterface docService;
	static FlowConfigurationInterface flowConfigService;
	static FlowInterface flowService;
	static LocationInterface locationService;
	static UserInterface userService;
	static GoodInterface goodService;
	
	static {
		try {
			loadEJBs();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static void loadEJBs() throws NamingException {
		Properties jndiProps = new Properties();
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context ctx = new InitialContext(jndiProps);
        
        goodTypeService = (GoodTypeInterface) ctx.lookup(goodTypeJndiName);
        docService = (DocumentInterface) ctx.lookup(docJndiName);
        flowConfigService = (FlowConfigurationInterface) ctx.lookup(flowConfJndiName);
        flowService = (FlowInterface) ctx.lookup(flowJndiName);
        locationService = (LocationInterface) ctx.lookup(locationJndiName);
        userService = (UserInterface) ctx.lookup(userJndiName);
        goodService = (GoodInterface) ctx.lookup(goodJndiName);
	}
	
	public abstract List<T> loadElements();
	public abstract T loadById(Long id);
	public abstract void updateElement(T objWas, T objNew);
	public abstract void saveElement(T obj);
	public abstract void deleteElement(T obj);
	
}
