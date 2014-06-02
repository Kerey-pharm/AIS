package kz.bee.kudos.idp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.security.Base64Utils;

import java.io.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: nurlan.rakhimzhanov@bee.kz
 * Date: 1/17/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(urlPatterns = "/metadata")
public class IdpMetadataServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml");
        PrintWriter out = resp.getWriter();


        String X509CertificateString = "";
        String entityID = System.getProperty("idp.url");
        if (entityID == null || entityID.isEmpty())
            entityID = "http://localhost:8080/idp/";

        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(this.getClass().getClassLoader().getResourceAsStream("/keystore.jks"), "toPSecret2010".toCharArray());
            X509Certificate cert = (X509Certificate) keyStore.getCertificate("servercert");
            
            //BASE64Encoder encoder = new BASE64Encoder();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //PrintStream printStream = new PrintStream(baos);
            baos.write(Base64Utils.tob64(cert.getEncoded()).getBytes());
            
            //encoder.encodeBuffer(cert.getEncoded(), printStream);
            X509CertificateString = baos.toString("UTF-8");
        } catch (KeyStoreException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (CertificateException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        InputStream idpMetadataDaftInputStream = this.getClass().getClassLoader().getResourceAsStream("/idp-metadata.xml");
        Scanner scanner = new Scanner(idpMetadataDaftInputStream);

        StringBuilder outputText = new StringBuilder();
        while (scanner.hasNext()) {
            outputText.append(scanner.nextLine().replace("${entityID}", entityID).replace("${x509certificate}", X509CertificateString));
        }

        String xmlString = outputText.toString();

        out.print(xmlString);
    }
}
