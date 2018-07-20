package apprunner;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import apiresponseparser.restapiparser;
import infogenerator.StateInfo;

public class runner 
{

	
	public static String GetJsonAttributeValue(JSONObject jsonobj, String sttributename)
	{
		String ReturnValue="";
		try
		{
			 ReturnValue = jsonobj.get(sttributename).toString();
		}
		catch(Exception e)
		{
			ReturnValue = "No " + sttributename + " Found..";
		}
		
		return ReturnValue;
	}
	public static boolean BuildStateInfofromRestResponseText(String jsonarray)
	{
		
		//Get data for Results array
		JSONObject responseJson = new JSONObject(jsonarray).getJSONObject("RestResponse");
 		JSONArray jsonarr_1 = responseJson.getJSONArray("result");

		for(int i=0;i<jsonarr_1.length();i++)
		{
			//Store the JSON objects in an array
			JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
			//System.out.println("Elements under results array");
			//System.out.println("\nPlace id: " +jsonobj_1.get("id"));
			//System.out.println("\nState Name  [" + (i) + "] :" +  jsonobj_1.get("name"));
			
			String statename = GetJsonAttributeValue(jsonobj_1,"name");
			String abbr = GetJsonAttributeValue(jsonobj_1,"abbr");
			String largest_city = GetJsonAttributeValue(jsonobj_1,"largest_city");
			String capital = GetJsonAttributeValue(jsonobj_1,"capital");
			
			StateInfo.statesByName.put(statename.toLowerCase(), new StateInfo(abbr, largest_city, capital));
			StateInfo.statesByAbbreviation.put(abbr.toLowerCase(), new StateInfo(statename, largest_city, capital));
		}
		
		return true;
	}
	
	
	
	public static void main(String[] args) throws IOException 
	{
		//======>> Check Application Dependent Rest Response and Build The State Information Library
		String RestRequestResponse = restapiparser.SendARestGetRequestWithUrl("http://services.groupkt.com/state/get/USA/all");
		if(!RestRequestResponse.toLowerCase().contains("error"))
		{
			boolean x = BuildStateInfofromRestResponseText(RestRequestResponse);
			
			if(x == false)
			{
				System.out.println("Failed To Build State Info From Response Json");
                System.exit(0);
			}
		}
		else
		{
			System.out.println("Rest Server Down Application Can't Start ");
			System.out.println("Error Reason \n" + RestRequestResponse );
            System.exit(0);
		}
		
		

        System.out.println("############## Started Application Infor Generator Application ##################\n");

		// Take Input & Print 
		Scanner userInput = new Scanner(System.in);
		Console c =System.console();  
		String stateNameOrAbbreviation;
        
		while (true) 
        {
        		try    //******** Special Try Catch if  system.console not load we can try the Scanner to Take Input 
        		{
        	       stateNameOrAbbreviation=c.readLine("\nEnter a State Name or Abbreviation [ None to exit ]:",args.toString());
        		}
        		catch(Exception e)
        		{
                    System.out.print("\nEnter a State Name or Abbreviation [ None to exit ]:");
                    stateNameOrAbbreviation = userInput.nextLine();
        		}
            
            
            if (stateNameOrAbbreviation.equalsIgnoreCase("None")) 
            {
                System.out.println("\n...........Thanks for using  Exiting.........");
                break;
            } 
            else 
            {
            		//==>>If State Name(EX.New York, Texas, Maryland) Given as Input
            		if(stateNameOrAbbreviation.length()>2)  
            		{
                    System.out.println("***********************************************************");
                        StateInfo stateInfo = StateInfo.getInfo(stateNameOrAbbreviation);
                        if (stateInfo != null ) 
                        {
                            System.out.println("\tState abbreviation	: " + stateInfo.state_abbr);
                            System.out.println("\tState largest_city	: " + stateInfo.state_largest_city);
                            System.out.println("\tState Capital		: " + stateInfo.State_Capital);
                        } 
                        else 
                        {
                            System.out.println("\tInvalid State Name [" + stateNameOrAbbreviation + "] Entered!!");
                        }
                    System.out.println("***********************************************************");
            		}
            		
            		//==>> If State Abbreviation [EX. NY, TX, MD] Given as Input 
            		if(stateNameOrAbbreviation.length() < 3) 
            		{
                     System.out.println("***********************************************************");
                        StateInfo stateInfo = StateInfo.getInfoByabbreviation(stateNameOrAbbreviation);
                        if (stateInfo != null ) 
                        {
                            System.out.println("\tState Name		: " + stateInfo.state_abbr);
                            System.out.println("\tState largest_city	: " + stateInfo.state_largest_city);
                            System.out.println("\tState Capital		: " + stateInfo.State_Capital);
                        } 
                        else 
                        {
                            System.out.println("\tInvalid State Abbreviation [" + stateNameOrAbbreviation + "] Entered!!");
                        }
                     System.out.println("***********************************************************");
            		}
            }
        }
		
		System.exit(0);
	}

}
