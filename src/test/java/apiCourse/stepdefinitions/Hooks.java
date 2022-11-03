package apiCourse.stepdefinitions;

import apiCourse.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static apiCourse.clients.ClickUpClients.deleteFolder;


public class Hooks {

    @Before
    public void beforeHook(Scenario scenario){
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
        System.out.println("THE SCENARIO HAS STARTED");
    }

    @After
    public void afterHook(){
        deleteFolder(TestCaseContext.getFolder().getId());
        System.out.println("THE SCENARIO HAS ENDED");
    }
}
