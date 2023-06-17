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

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UniRestExample {

	public void unirestGetRequestMethod() throws UnirestException {

		HttpResponse<JsonNode>  httpResponse =  Unirest.get("https://dummy.restapiexample.com/api/v1/employees").asJson();

		System.out.println("Status Code - "+
				httpResponse.getStatus()+"\nStatus Text - "+
				httpResponse.getStatusText()+"\n Status Message - "+
				httpResponse.getBody());
		/*Status Code - 200
Status Text - OK
 Status Message - {"data":[{"profile_image":"","employee_name":"Tiger Nixon","employee_salary":320800,"id":1,"employee_age":61},{"profile_image":"","employee_name":"Garrett Winters","employee_salary":170750,"id":2,"employee_age":63},{"profile_image":"","employee_name":"Ashton Cox","employee_salary":86000,"id":3,"employee_age":66},{"profile_image":"","employee_name":"Cedric Kelly","employee_salary":433060,"id":4,"employee_age":22},{"profile_image":"","employee_name":"Airi Satou","employee_salary":162700,"id":5,"employee_age":33},{"profile_image":"","employee_name":"Brielle Williamson","employee_salary":372000,"id":6,"employee_age":61},{"profile_image":"","employee_name":"Herrod Chandler","employee_salary":137500,"id":7,"employee_age":59},{"profile_image":"","employee_name":"Rhona Davidson","employee_salary":327900,"id":8,"employee_age":55},{"profile_image":"","employee_name":"Colleen Hurst","employee_salary":205500,"id":9,"employee_age":39},{"profile_image":"","employee_name":"Sonya Frost","employee_salary":103600,"id":10,"employee_age":23},{"profile_image":"","employee_name":"Jena Gaines","employee_salary":90560,"id":11,"employee_age":30},{"profile_image":"","employee_name":"Quinn Flynn","employee_salary":342000,"id":12,"employee_age":22},{"profile_image":"","employee_name":"Charde Marshall","employee_salary":470600,"id":13,"employee_age":36},{"profile_image":"","employee_name":"Haley Kennedy","employee_salary":313500,"id":14,"employee_age":43},{"profile_image":"","employee_name":"Tatyana Fitzpatrick","employee_salary":385750,"id":15,"employee_age":19},{"profile_image":"","employee_name":"Michael Silva","employee_salary":198500,"id":16,"employee_age":66},{"profile_image":"","employee_name":"Paul Byrd","employee_salary":725000,"id":17,"employee_age":64},{"profile_image":"","employee_name":"Gloria Little","employee_salary":237500,"id":18,"employee_age":59},{"profile_image":"","employee_name":"Bradley Greer","employee_salary":132000,"id":19,"employee_age":41},{"profile_image":"","employee_name":"Dai Rios","employee_salary":217500,"id":20,"employee_age":35},{"profile_image":"","employee_name":"Jenette Caldwell","employee_salary":345000,"id":21,"employee_age":30},{"profile_image":"","employee_name":"Yuri Berry","employee_salary":675000,"id":22,"employee_age":40},{"profile_image":"","employee_name":"Caesar Vance","employee_salary":106450,"id":23,"employee_age":21},{"profile_image":"","employee_name":"Doris Wilder","employee_salary":85600,"id":24,"employee_age":23}],"message":"Successfully! All records has been fetched.","status":"success"}
		 */
	}

	public void unirestPostRequestMethod() throws UnirestException {

		HttpResponse<JsonNode>  httpResponse =  Unirest.post("https://dummy.restapiexample.com/api/v1/create")
				.body("{\"name\":\"Kowsalya S\",\"salary\":\"950000\",\"age\":\"24\"}").asJson();

		System.out.println("Status Code - "+
				httpResponse.getStatus()+"\nStatus Text - "+
				httpResponse.getStatusText()+"\n Status Message - "+
				httpResponse.getBody());
		/*Status Code - 200
Status Text - OK
 Status Message - {"data":{"id":6444},"message":"Successfully! Record has been added.","status":"success"}
*/
	}

	public void unirestPutRequestMethod() throws UnirestException {

		HttpResponse<JsonNode>  httpResponse =  Unirest.put("https://dummy.restapiexample.com/api/v1/update/6444")
				.body("{\"name\":\"Kowsalya S\",\"salary\":\"985000\",\"age\":\"25\"}").asJson();

		System.out.println("Status Code - "+
				httpResponse.getStatus()+"\nStatus Text - "+
				httpResponse.getStatusText()+"\n Status Message - "+
				httpResponse.getBody());
		/*Status Code - 200
Status Text - OK
 Status Message - {"data":[],"message":"Successfully! Record has been updated.","status":"success"}
*/
	}
	


	public void unirestDeleteRequestMethod() throws UnirestException {

		HttpResponse<JsonNode>  httpResponse =  Unirest.delete("https://dummy.restapiexample.com/api/v1/delete/6444").asJson();

		System.out.println("Status Code - "+
				httpResponse.getStatus()+"\nStatus Text - "+
				httpResponse.getStatusText()+"\n Status Message - "+
				httpResponse.getBody());
		/*Status Code - 200
Status Text - OK
 Status Message - {"data":"6444","message":"Successfully! Record has been deleted","status":"success"}
*/
	}


	public static void main(String[] args) throws IOException, UnirestException {
		// TODO Auto-generated method stub
		UniRestExample urlConnectionExample = new UniRestExample();
		//urlConnectionExample.unirestGetRequestMethod();
		//urlConnectionExample.unirestPostRequestMethod();
		//urlConnectionExample.unirestPutRequestMethod();
		urlConnectionExample.unirestDeleteRequestMethod();
	}

}
