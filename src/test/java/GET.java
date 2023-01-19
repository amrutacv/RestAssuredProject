import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.net.HttpHeaders;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class GET {
	
	
	private static final String JsonPayload = null;

	@Test
	public void get_stvgoal() throws ParseException {
		
		RestAssured.baseURI = "http://149.24.167.55:8083/BannerAdminAPI.ws/api";
		RequestSpecification request = RestAssured.given().log().all();
		String credentials = "saisusr:u_pick_it";
		byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
		String encodedCredentialsAsString = new String(encodedCredentials);
		request.header("Authorization","Basic "+encodedCredentialsAsString)
			.header("Accept", "application/json")
				.contentType("application/json")
				.when().log().all()
					.get("/level-codes")
						.then().log().all()
							.assertThat()
								.statusCode(200)
									.and()
										.body("[0].code", equalTo("00"));
		Response res = given()
		.baseUri("http://149.24.167.55:8083/BannerAdminAPI.ws/api")
		.header("Accept", "application/json")
		.contentType("application/json")
		 .when().log().all()
		 .get("/level-codes")
		 .then().log().all()
		 .extract().response(); 
		
		
	}
	
	@Test
	public void f2() throws IOException {
		URL obj = new URL("http://149.24.167.55:8083/BannerAdminAPI.ws/api/applicant-information?id=VET333333");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("X-Content-Expand", "true");
		con.setRequestProperty("Accept-Language", "ar");
		con.setRequestProperty("content-type", "text/plain; charset=UTF-8");
		String credentials= "saisusr:u_pick_it";
		
		byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
		String encodedCredentialsAsString = new String(encodedCredentials);
		con.setRequestProperty("Authorization", "Basic "+encodedCredentialsAsString);

		System.out.println(	con.getResponseCode());
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer sb = new StringBuffer();
		while((inputLine=br.readLine())!=null) {
			sb.append(inputLine);
		}
		br.close();
		String str = sb.toString();
		
		System.out.println( new String(str.getBytes("ISO-8859-1"), "UTF-8"));
	}
	
	@Test
	public void f3() throws ClientProtocolException, IOException {
		CredentialsProvider cp = new BasicCredentialsProvider();
		cp.setCredentials(new AuthScope("http://149.24.167.55",8083), new UsernamePasswordCredentials("saisusr","u_pick_it"));
		CloseableHttpClient client = HttpClients.custom().setDefaultCredentialsProvider(cp).build();
		HttpGet get = new HttpGet("http://149.24.167.55:8083/BannerAdminAPI.ws/api/level-codes");
		get.setHeader(HttpHeaders.ACCEPT, "application/json");
		HttpResponse response = client.execute(get);
		System.out.println(response.getStatusLine().getStatusCode());
		
	}
}
