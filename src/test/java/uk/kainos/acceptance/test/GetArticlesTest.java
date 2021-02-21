package uk.kainos.acceptance.test;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import uk.kainos.utils.ReadConfig;
import static io.restassured.RestAssured.given;

public class GetArticlesTest {
	
	private static String QUERTY_PARAM="page";
	private static String CHAR_SET="utf-8";
	private static String DATA_SIZE="data.size()";
	
	@Test
	public void getArticlesForPage1() {
		given().when().queryParam(QUERTY_PARAM, 1).get(ReadConfig.TEST_END_POINT_URL)
		 .then()
		 .statusCode(HttpStatus.SC_OK)
		 .header(HttpHeaders.CONTENT_TYPE, String.valueOf(ContentType.JSON.withCharset(CHAR_SET)))
		 .assertThat().body(QUERTY_PARAM, Matchers.equalTo("1"))
		 .assertThat().body(DATA_SIZE, Matchers.equalTo(10));

	}
	
	@Test
	public void getArticlesForPage5() {
		given().when().queryParam(QUERTY_PARAM, 5).get(ReadConfig.TEST_END_POINT_URL)
		 .then()
		 .statusCode(HttpStatus.SC_OK)
		 .header(HttpHeaders.CONTENT_TYPE, String.valueOf(ContentType.JSON.withCharset(CHAR_SET)))
		 .assertThat().body(QUERTY_PARAM, Matchers.equalTo("5"))
		 .assertThat().body(DATA_SIZE, Matchers.equalTo(1));
	}
	
	@Test
	public void getEmptyArticlesForPage10() {
		given().when().queryParam(QUERTY_PARAM, 10).get(ReadConfig.TEST_END_POINT_URL)
		 .then()
		 .statusCode(HttpStatus.SC_OK)
		 .header(HttpHeaders.CONTENT_TYPE, String.valueOf(ContentType.JSON.withCharset(CHAR_SET)))
		 .assertThat().body(QUERTY_PARAM, Matchers.equalTo("10"))
		 .assertThat().body(DATA_SIZE, Matchers.equalTo(0));
	}
	
	@Test
	public void getArticlesBadRequest() {
		given().when().queryParam(QUERTY_PARAM, 5).get(ReadConfig.TEST_BAD_END_POINT_URL)
		 .then()
		 .statusCode(HttpStatus.SC_BAD_REQUEST);
	}

}
