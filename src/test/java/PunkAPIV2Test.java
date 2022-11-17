import controller.PunkApiV2Controller;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PunkAPIV2Test {
    public static void main(String args[]) {
        PunkApiV2Controller punkApiV2Controller = new PunkApiV2Controller();

        final String baseUrl = "https://api.punkapi.com/v2/beers";
        Response response = given().when().get(baseUrl);

        //Scenario 4 - verify that the amount of data returned for each example is valid (no need to verify the contents).
        int[] numberOfData = {20, 5, 1};
        System.out.println("Scenario 4 is success");
        for (int i = 0; i < numberOfData.length; i++) {
            punkApiV2Controller.getDataBasedOnNumberOfPage(numberOfData[i], baseUrl);
        }

        //Scenario 5 - Verify JSON schema
        System.out.println("Scenario 5 is success");
        punkApiV2Controller.schemaValidation(baseUrl);

        //5a - Verify that the amount of data returned
        System.out.println("Scenario 5a result :");
        punkApiV2Controller.getDataAmount(response);

        //5b - Print all returned “name” of list that endpoint data
        System.out.println("Scenario 5b result :");
        punkApiV2Controller.getDataName(response);
    }


}
