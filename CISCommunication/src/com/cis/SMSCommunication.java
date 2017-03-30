package com.cis;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.cis.CISResults;

public class SMSCommunication {
	public CISResults sendSMS(String phoneNumber,int otpNumber) throws Throwable {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		String postData="";
         String retval = "";
         //KAP SYSTEMS PROVIDERS LOGIN DETAILS DEMO ACCOUNT DETAILS
         // TODO: Remove hard coded data.
         String Username =CISConstants.USERNAME;
         String Password = CISConstants.PASSWORD;
         String SenderID = CISConstants.SENDERID;
         String Type=CISConstants.TYPE;
         String Message = "Your OTP for Arcturus is "+otpNumber ;
         
       //  http://193.105.74.159/api/v3/sendsms/plain?user=internationalsms&password=HZlGhtj&sender=KAPNFO&SMSText=TEST&type=longsms&GSM=17325800762
         
         postData += "user=" + Username + "&password=" + Password + "&sender=" +           
        		 SenderID +"&SMSText=" +Message + "&type="+Type+ "&GSM="+phoneNumber;
		 URL url = new URL("http://193.105.74.159/api/v3/sendsms/plain?");
		 HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
         urlconnection.setRequestMethod("POST");
         urlconnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
         urlconnection.setDoOutput(true);
         OutputStreamWriter out = new            
         OutputStreamWriter(urlconnection.getOutputStream());
         out.write(postData);
         out.close();
         BufferedReader in = new BufferedReader( new  InputStreamReader(urlconnection.getInputStream()));
         String decodedString;
         while ((decodedString = in.readLine()) != null) {
               retval += decodedString;
         }
         in.close();
         System.out.println("SMS STATUS: "+retval);
	   
         
         
         
         // Get Status Of SMS 
         
         DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
         InputSource src = new InputSource();
         src.setCharacterStream(new StringReader(retval));

         Document doc = builder.parse(src);
         String status = doc.getElementsByTagName("status").item(0).getTextContent();
         String messageId = doc.getElementsByTagName("messageid").item(0).getTextContent();
         
       //  System.out.println(status);
        // System.out.println(messageId);
         // TODO: Remove hard coded data.
         String  wrongNumber= "-13";
         String noBal = "-2";
         String statusSucess="0";
        
         if(status.equalsIgnoreCase(wrongNumber))
         {   //System.out.println("SMS FAILED DUE TO WRONG NUMBER ENTER.");
        	  cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
  			  cisResult.setErrorMessage(CISConstants.WRONG_PHONE_NUMBER);
         }
         if(status.equalsIgnoreCase(noBal))  
         {
        	// System.out.println("SMS FAILED DUE TO No Balance in account.");    	 
        	 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
  			 cisResult.setErrorMessage(CISConstants.PHONE_NUMBER_SERVER_ISSUE);	 
         }
         if(status.equalsIgnoreCase(statusSucess))
         {
        	// System.out.println("SMS FAILED ");
        	 cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
         }     
         return cisResult;
	}
	
	public CISResults sendMessage(String phoneNumber,String firsName,String lastName) throws Throwable {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		String postData="";
         String retval = "";
         
         //KAP SYSTEMS PROVIDERS LOGIN DETAILS DEMO ACCOUNT DETAILS
         // TODO: Remove hard coded data.
         String Username ="arcturuscare";
         //String Password = "arcturus1@3";
         String Password = "";
        // String SenderID = "KAPNFO"; 
         String SenderID = ""; 
         String Type="longsms";
         String Message = "Arcturus :"+firsName +" "+lastName+ " " +"provided feedback" ;
        // Arcturus : John Vonn provided feedback.
       //  http://193.105.74.159/api/v3/sendsms/plain?user=internationalsms&password=HZlGhtj&sender=KAPNFO&SMSText=TEST&type=longsms&GSM=17325800762
         
         postData += "user=" + Username + "&password=" + Password + "&sender=" +           
        		 SenderID +"&SMSText=" +Message + "&type="+Type+ "&GSM="+phoneNumber;
		 URL url = new URL("http://193.105.74.159/api/v3/sendsms/plain?");
		 HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
         urlconnection.setRequestMethod("POST");
         urlconnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
         urlconnection.setDoOutput(true);
         OutputStreamWriter out = new            
         OutputStreamWriter(urlconnection.getOutputStream());
         out.write(postData);
         out.close();
         BufferedReader in = new BufferedReader( new  InputStreamReader(urlconnection.getInputStream()));
         String decodedString;
         while ((decodedString = in.readLine()) != null) {
               retval += decodedString;
         }
         in.close();
         System.out.println("SMS STATUS: "+retval);
         
	   	return cisResult;
	}

}
