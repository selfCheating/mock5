package Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonMethods.API_Trigger;
import POJO.RestfulGetAPIParentPOJO;
import io.restassured.response.Response;

public class RestfulGetAPIScript extends API_Trigger {

	Response response;
	RestfulGetAPIParentPOJO[] res_body;
	int statuscode;

	@Test(description = "Validate status code for Restful Get API")
	public void validateResponseStatuscode() {
		response = API_Trigger.TriggerGetAPI(GetAPIENV());
		res_body = response.as(RestfulGetAPIParentPOJO[].class);
		statuscode = response.getStatusCode();
		System.out.println("Status Code is : " + statuscode);
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(200, statuscode);
	}
	public void validateResponseBodyParameters() {
		String expectedId[] = {"3","5","10"};
		String expectedname[] = {"Apple iPhone 12 Pro Max","Samsung Galaxy Z Fold2","Apple iPad Mini 5th Gen"};
		String expectedcolor[] = {"Cloudy White","Brown","null"};
		
		Assert.assertEquals(res_body.length, expectedId.length, "Number of items does not match please check your array");
		
		for(int i =0; i<res_body.length; i++) {
			RestfulGetAPIParentPOJO ActualItem = res_body[i];
			
			Assert.assertEquals(ActualItem.getId(),expectedId[i]);
			Assert.assertEquals(ActualItem.getName(), expectedname[i]);
			
			if(ActualItem.getData() != null) {
				Assert.assertEquals(ActualItem.getData().getPrice(),expectedcolor[i]);
			} else {
				Assert.assertNull(expectedcolor[i],"Expected color should be null at index " + i);
			}
		}
	}
}