package thirdpartyanddefaultapitestin;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HTTPUrlConnectionExample {


	public void getAPIResponse() throws IOException {
		URL url = new URL("https://dummy.restapiexample.com/api/v1/employees");

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		int responseCode = connection.getResponseCode();
		System.out.println("Response Code is "+responseCode);

		String responseMessageString =  connection.getResponseMessage();
		System.out.println("Response Message "+responseMessageString);

		InputStream inputStream = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String lineString;
		StringBuffer lineBuffer = new StringBuffer();
		while((lineString=bufferedReader.readLine())!=null)
		{
			lineBuffer.append(lineString);
		}

		System.out.println("Output Response : "+lineBuffer);
	}


	public void postAPIMethod() throws IOException {
		URL url = new URL("https://dummy.restapiexample.com/api/v1/create");

		HttpsURLConnection connection =   (HttpsURLConnection) url.openConnection();

		connection.setRequestMethod("POST");

		connection.setRequestProperty("Content-type", "application/json");

		connection.setDoOutput(true);
		connection.connect();

		String jsonDataString = "{\"name\":\"Kowsalya S\",\"salary\":\"12564\",\"age\":\"26\"}";

		byte[] inputJsonByte = jsonDataString.getBytes();

		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(inputJsonByte);

		int responseCode = connection.getResponseCode();
		System.out.println("Response Code is "+responseCode);

		String responseMessageString =  connection.getResponseMessage();
		System.out.println("Response Message "+responseMessageString);


		InputStream inputStream = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String lineString;
		StringBuffer lineBuffer = new StringBuffer();
		while((lineString=bufferedReader.readLine())!=null)
		{
			lineBuffer.append(lineString);
		}

		System.out.println("Output Response : "+lineBuffer);


	}
	public void putAPIMethod() throws IOException {
		URL url = new URL("https://dummy.restapiexample.com/api/v1/update/12564");

		HttpsURLConnection connection =   (HttpsURLConnection) url.openConnection();

		connection.setRequestMethod("PUT");

		connection.setRequestProperty("Content-type", "application/json");

		connection.setDoOutput(true);
		connection.connect();

		String jsonDataString = "{\"name\":\"Kowsalya S\",\"salary\":\"12564\",\"age\":\"29\"}";

		byte[] inputJsonByte = jsonDataString.getBytes();

		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(inputJsonByte);

		int responseCode = connection.getResponseCode();
		System.out.println("Response Code is "+responseCode);

		String responseMessageString =  connection.getResponseMessage();
		System.out.println("Response Message "+responseMessageString);


		InputStream inputStream = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String lineString;
		StringBuffer lineBuffer = new StringBuffer();
		while((lineString=bufferedReader.readLine())!=null)
		{
			lineBuffer.append(lineString);
		}

		System.out.println("Output Response : "+lineBuffer);


	}
	/*Response Code is 200
Response Message OK
Output Response : {"status":"success","data":{"name":"Kowsalya S","salary":"12564","age":"29"},"message":"Successfully! Record has been updated."}
	 */
	public void deleteAPIMethod() throws IOException {
		URL url = new URL("https://dummy.restapiexample.com/api/v1/delete/12564");

		HttpsURLConnection connection =   (HttpsURLConnection) url.openConnection();

		connection.setRequestMethod("DELETE");

		connection.setRequestProperty("Content-type", "application/json");

		connection.setDoOutput(true);
		connection.connect();

		int responseCode = connection.getResponseCode();
		System.out.println("Response Code is "+responseCode);

		String responseMessageString =  connection.getResponseMessage();
		System.out.println("Response Message "+responseMessageString);

		InputStream inputStream = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String lineString;
		StringBuffer lineBuffer = new StringBuffer();
		while((lineString=bufferedReader.readLine())!=null)
		{
			lineBuffer.append(lineString);
		}

		System.out.println("Output Response : "+lineBuffer);

		/*
		 Response Code is 200
Response Message OK
Output Response : {"status":"success","data":"12564","message":"Successfully! Record has been deleted"}
		 */
	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HTTPUrlConnectionExample urlConnectionExample = new HTTPUrlConnectionExample();
		//urlConnectionExample.getAPIResponse();
		//urlConnectionExample.postAPIMethod();
		//urlConnectionExample.putAPIMethod();
		urlConnectionExample.deleteAPIMethod();
	}

}
