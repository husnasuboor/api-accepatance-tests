package uk.kainos.acceptance.test;

import static io.restassured.RestAssured.given;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import uk.kainos.utils.PayloadReaderUtil;
import uk.kainos.utils.ReadConfig;

public class PostPayrollTest {

	@Test
	public void createEmployeePayrollRequest() throws Exception {
		given().when().contentType(ContentType.JSON)
		.body(PayloadReaderUtil.readPayload("sample-post-requests/post-create-request-sample1.json"))
		.post(ReadConfig.POST_END_POINT_URL)
		 .then()
		 .statusCode(HttpStatus.SC_OK)
		 .header(HttpHeaders.CONTENT_TYPE, String.valueOf(ContentType.JSON))
		 .assertThat().body("message", Matchers.equalTo("Successfully! Record has been added."));

	}
}
