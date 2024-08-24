import static io.restassured.RestAssured.*;
import java.io.IOException;
import io.restassured.response.Response;
import static com.util.TestUtil.*;

public class RB_GetAllBookings {
	public static void main(String[] args) throws IOException {
		baseURI=getqaProperties("qa.properties","BASE_URL");
	Response response=	given()
								.log().all()
								.get("booking");
	System.out.println(response.asPrettyString());
		
	}

}
