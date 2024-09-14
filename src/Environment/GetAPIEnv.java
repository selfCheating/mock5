package Environment;
public class GetAPIEnv {

	public static String GetAPIENV() {
		String hostname = "https://api.restful-api.dev";
		String resource = "/objects?id=3&id=5&id=10";
		String endpoint = hostname+resource;
		return endpoint;
		
		
	}
}