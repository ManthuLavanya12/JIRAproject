package com.jira.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	@CucumberOptions (
			
			 features= {"src/test/java/com/jira/features/jira.feature"},

			 glue={"com.jira.stepdefinition"},
					 dryRun=false,
					 plugin= {
			        		  "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
			        		  
			        		  }
		)
		            
		public class JIRAtestrunner extends AbstractTestNGCucumberTests {
			
		}



