package apiresponseparser;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class restapiparser 
{
	
	public static String SendARestGetRequestWithUrl(String endpointurl) throws IOException
	{
		String responseBodyText = null;
		Response response = null;
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
							 .url(endpointurl)
							 .get()
							 .build();
		try 
		{
			response = client.newCall(request).execute();
			//System.out.println(response.code());
			if(response.code()==200)
			{
				responseBodyText = response.body().string();
				response.body().close();
			}
			else
			{
				responseBodyText = "Error : Rest Server Down Response Code : " + response.code() ;
				response.body().close();

			}	
		} 
		catch (Exception e) 
		{
			responseBodyText = "Error : Rest Server Down Response Code : " + e.getMessage();
			response.body().close();
		}
		
		return responseBodyText;
	}

}
