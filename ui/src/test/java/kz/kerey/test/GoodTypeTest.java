package kz.kerey.test;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import kz.kerey.business.wrappers.GoodTypeWrapper;
import kz.kerey.business.wrappers.GoodWrapper;
import kz.kerey.services.api.DocumentInterface;
import kz.kerey.services.api.FlowConfigurationInterface;
import kz.kerey.services.api.FlowInterface;
import kz.kerey.services.api.GoodInterface;
import kz.kerey.services.api.GoodTypeInterface;
import kz.kerey.services.api.LocationInterface;
import kz.kerey.services.api.UserInterface;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GoodTypeTest {

	private static String goodTypeJndiName = "ejb:/services//GoodTypeEJB!kz.kerey.services.api.GoodTypeInterface";
	private static String docJndiName = "ejb:/services//DocumentEJB!kz.kerey.services.api.DocumentInterface";
	private static String flowConfJndiName = "ejb:/services//FlowConfigurationEJB!kz.kerey.services.api.FlowConfigurationInterface";
	private static String flowJndiName = "ejb:/services//FlowEJB!kz.kerey.services.api.FlowInterface";
	private static String locationJndiName = "ejb:/services//LocationEJB!kz.kerey.services.api.LocationInterface";
	private static String userJndiName = "ejb:/services//UserEJB!kz.kerey.services.api.UserInterface";
	private static String goodJndiName = "ejb:/services//GoodEJB!kz.kerey.services.api.GoodInterface";
	
	private GoodTypeInterface goodTypeService;
	private DocumentInterface docService;
	private FlowConfigurationInterface flowConfigService;
	private FlowInterface flowService;
	private LocationInterface locationService;
	private UserInterface userService;
	private GoodInterface goodService;
	
	@Before
	public void beforeTest() throws NamingException {
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
	
	@Test
	public void goodTypeTest1() {
		GoodTypeWrapper goodType1 = new GoodTypeWrapper();
		goodType1.setName("GoodType1");
		
		GoodTypeWrapper goodType2 = new GoodTypeWrapper();
		goodType2.setName("GoodType2");
		
		goodTypeService.createGoodType(goodType1);
		goodTypeService.createGoodType(goodType2);
		List<GoodTypeWrapper> goodTypes = goodTypeService.getGoodTypeList(false, 1, 1);
		Assert.assertTrue(goodTypes.size()==2);
		
		GoodWrapper good1 = new GoodWrapper();
		good1.setCountPerBox(1L);
		good1.setCountSellable(1L);
		good1.setGoodTypeId(goodTypes.get(0).getId());
		good1.setName("Good1");
		good1.setPartialSelling(false);
		good1.setPrimaryBarcode("000000000001");
		
		GoodWrapper good2 = new GoodWrapper();
		good2.setCountPerBox(10L);
		good2.setCountSellable(1L);
		good2.setGoodTypeId(goodTypes.get(1).getId());
		good2.setName("Good2");
		good2.setPartialSelling(true);
		good2.setPrimaryBarcode("000000000002");
		
		GoodWrapper good3 = new GoodWrapper();
		good3.setCountPerBox(100L);
		good3.setCountSellable(10L);
		good3.setGoodTypeId(goodTypes.get(0).getId());
		good3.setName("Super Good2");
		good3.setPartialSelling(true);
		good3.setPrimaryBarcode("000000000003");
		
		goodService.createGood(good1);
		goodService.createGood(good2);
		goodService.createGood(good3);
		
		List<GoodWrapper> goods = goodService.getGoodList(null, null, null);
		Assert.assertTrue(goods.size()==3);
		
	}
	
}
