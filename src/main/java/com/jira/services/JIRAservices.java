package com.jira.services;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;


import io.restassured.response.Response;

public class JIRAservices {
	private Response response;

	public Response createJIRAissue() {
		return given()
		.header("X-Atlassian-Token","no-check")
	    .when()
	    .multiPart("file",new File("src/test/resources/resources/file1.txt"))
	    .multiPart("file",new File("src/test/resources/resources/file2.txt"))
	    .post("/10009/attachments");

}
	public JIRAservices create() {
		response = createJIRAissue();
		System.out.println(response.asPrettyString());
		return this;
	}
	public JIRAservices validateStatusCode(int statuscode) {
	    assertThat(response.getStatusCode(),equalTo(statuscode));
	    return this ;
		
	}
	public JIRAservices validateStatusLine(String statusline) {
	    assertThat(response.getStatusLine(),containsString(statusline));
	    return this ;
		
	}
	public JIRAservices validatecontentType(String content) {
	    assertThat(response.getContentType(),containsString(content));
	    return this ;
		
	}
	public JIRAservices validatefilename(String file1, String file2) {
	    assertThat(response.body().jsonPath().getString("filename"),containsString(file1));
	    assertThat(response.body().jsonPath().getString("filename"),containsString(file2));

		return this;
	}


	
}
