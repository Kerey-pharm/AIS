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

	private static String goodTypeJndiName = "ejb:/services//GoodTypeEJB!kz.kerey.services.api.GoodTypeInterface";
	private static String docJndiName = "ejb:/services//DocumentEJB!kz.kerey.services.api.DocumentInterface";
	private static String flowConfJndiName = "ejb:/services//FlowConfigurationEJB!kz.kerey.services.api.FlowConfigurationInterface";
	private static String flowJndiName = "ejb:/services//FlowEJB!kz.kerey.services.api.FlowInterface";
	private static String locationJndiName = "ejb:/services//LocationEJB!kz.kerey.services.api.LocationInterface";
	private static String userJndiName = "ejb:/services//UserEJB!kz.kerey.services.api.UserInterface";
	private static String goodJndiName = "ejb:/services//GoodEJB!kz.kerey.services.api.GoodInterface";
	
	public static GoodTypeInterface goodTypeService;
	public static DocumentInterface docService;
	public static FlowConfigurationInterface flowConfigService;
	public static FlowInterface flowService;
	public static LocationInterface locationService;
	public static UserInterface userService;
	public static GoodInterface goodService;

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
	
}
