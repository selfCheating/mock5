package CommonMethods;

import Environment.GetAPIEnv;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Trigger extends GetAPIEnv{

	public static Response TriggerGetAPI(String endpoint) {
		RequestSpecification reqspec = RestAssured.given();
		reqspec.header("Content-Type","application/json");
		Response response = reqspec.get(endpoint);
		return response;
	}
}