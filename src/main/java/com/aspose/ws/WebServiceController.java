package com.aspose.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class WebServiceController {

	private String contextForGet;
	private String contextForPost;
	private String contextBodyForPost;

	AsposeWebServiceController asposeWebServiceController = new AsposeWebServiceController();

	public String callGetAction() {

		// calling WS
//		this.asposeWebServiceController.getRESTService(this.getContextForGet());

		System.out.println("calling controller get Action "
		+ this.getContextForGet());
		
		this.clearAll();

		return "";
	}

	public String callPostAction() {

		// calling WS
//		this.asposeWebServiceController.postRESTService(
//				this.getContextForPost(), this.getContextBodyForPost());

		
		System.out.println("calling controller post Action "
				+ this.getContextForPost());
		this.clearAll();

		return "";
	}

	private void clearAll() {

		this.contextForGet = "";
		this.contextForPost = "";
		this.contextBodyForPost = "";

	}

	public String callPutAction() {

		// calling WS
//		this.asposeWebServiceController.putRESTService();

		System.out.println("calling controller put Action");
		return "";
	}

	
	public String getContextForGet() {
		return contextForGet;
	}

	public void setContextForGet(String contextForGet) {
		this.contextForGet = contextForGet;
	}

	public String getContextForPost() {
		return contextForPost;
	}

	public void setContextForPost(String contextForPost) {
		this.contextForPost = contextForPost;
	}

	public String getContextBodyForPost() {
		return contextBodyForPost;
	}

	public void setContextBodyForPost(String contextBodyForPost) {
		this.contextBodyForPost = contextBodyForPost;
	}

}
