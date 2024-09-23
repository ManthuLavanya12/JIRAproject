package com.jira.stepdefinition;

import com.jira.services.JIRAservices;
import com.matschie.general.utils.PropertiesHandler;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class JiraSteps {
	private JIRAservices service=new JIRAservices();

	@Given("set base path and base uri")
	public void set_base_path_and_base_uri() {
		RestAssured.baseURI=PropertiesHandler.config("jira.now.instance.uri");
		RestAssured.basePath=PropertiesHandler.config("jira.now.instance.basePath");
	}
	@Given("set authentication")
	public void set_authentication() {
		RestAssured.authentication=RestAssured.preemptive().basic(PropertiesHandler.config("jira.now.instance.username"), PropertiesHandler.config("jira.now.password"));
		
		}
	
	@When("send post request to create issue with attachments")
	public void send_post_request_to_create_issue_with_attachments() {
		service.create();
		
	}
	@Then("should receive a status code of {int}")
	public void should_receive_a_status_code_of(Integer int1) {
		service.validateStatusCode(200);
	}
	@Then("the issue should be created with the specified attachments")
	public void the_issue_should_be_created_with_the_specified_attachments() {
		service.validatecontentType("application/json");
		service.validateStatusLine("OK");
		service.validatefilename("file1.txt", "file2.txt");
	}


}
