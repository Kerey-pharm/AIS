package kz.kerey.loaders;

import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

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

	final private static String goodTypeJndiName = PropertiesLoader
			.getProperty("goodTypeJndiName");
	final private static String docJndiName = PropertiesLoader
			.getProperty("docJndiName");
	final private static String flowConfJndiName = PropertiesLoader
			.getProperty("flowConfJndiName");
	final private static String flowJndiName = PropertiesLoader
			.getProperty("flowJndiName");
	final private static String locationJndiName = PropertiesLoader
			.getProperty("locationJndiName");
	final private static String userJndiName = PropertiesLoader
			.getProperty("userJndiName");
	final private static String goodJndiName = PropertiesLoader
			.getProperty("goodJndiName");

	static GoodTypeInterface goodTypeService;
	static DocumentInterface docService;
	static FlowConfigurationInterface flowConfigService;
	static FlowInterface flowService;
	static LocationInterface locationService;
	static UserInterface userService;
	static GoodInterface goodService;

	private static Logger logger = Logger.getLogger("EJB_Loader");

	static {
		logger.addHandler(LoggerManager.getFileHandler());
		try {
			loadEJBs();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static void loadEJBs() throws NamingException {
		logger.info("Starting loading EJB Clients");
		Properties jndiProps = new Properties();
		jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context ctx = new InitialContext(jndiProps);

		goodTypeService = (GoodTypeInterface) ctx.lookup(goodTypeJndiName);
		docService = (DocumentInterface) ctx.lookup(docJndiName);
		flowConfigService = (FlowConfigurationInterface) ctx
				.lookup(flowConfJndiName);
		flowService = (FlowInterface) ctx.lookup(flowJndiName);
		locationService = (LocationInterface) ctx.lookup(locationJndiName);
		userService = (UserInterface) ctx.lookup(userJndiName);
		goodService = (GoodInterface) ctx.lookup(goodJndiName);

		logger.info("Ended loading EJB Clients");
	}

	public abstract List<T> loadElements();

	public abstract T loadById(Long id);

	public abstract void updateElement(T objWas, T objNew);

	public abstract void saveElement(T obj);

	public abstract void deleteElement(T obj);

}
