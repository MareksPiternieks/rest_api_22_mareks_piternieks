package apiCourse.stepdefinitions;

import apiCourse.domain.Folder;
import apiCourse.domain.List;

import apiCourse.domain.Task;
import apiCourse.domain.Tasks;
import apiCourse.helpers.NameGenerator;
import apiCourse.helpers.TestCaseContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;

import java.util.Map;

import static apiCourse.clients.ClickUpClients.*;
import static apiCourse.constants.ProjectConstants.*;


public class ClickUpSteps {

    @Given("Create new folder with name {string}, save it`s data and verify it`s name")
    public void createNewFolderAndCheckInfo(String folderName){
        JSONObject obj = new JSONObject();
        obj.put("name", folderName);
        Response resp = createFolder(obj);
        Folder folder = resp.as(Folder.class);
        TestCaseContext.setFolder(folder);

        Assertions.assertThat(folder.getName())
                .as("We assert that the folder Name is correct")
                .isEqualTo(folderName);

        TestCaseContext.getScenario().log("The folder name is " + folder.getName());
    }

    @Then("Create new list")
    public void createNewList() {
        JSONObject obj = new JSONObject();
        obj.put("name", LIST_NAME);
        obj.put("content", CONTENT);
        obj.put("assignee", ASSIGNEE);
        Response resp = createList(obj, TestCaseContext.getFolder().getId());
        List list = resp.as(List.class);
        TestCaseContext.setList(list);

        TestCaseContext.getScenario().log("The list name is " + list.getName());
    }

    @And("Verify list name is correct and it is added in correct folder")
    public void verifyListNameAndLocation() {
        Assertions.assertThat(TestCaseContext.getList().getName())
                .as("We check that the list name was updated to " + LIST_NAME)
                .isEqualTo(LIST_NAME);
        JSONObject obj = new JSONObject((Map) TestCaseContext.getList().getListFolderInfo());
        String id = (String) obj.get("id");
        Assertions.assertThat(TestCaseContext.getFolder().getId())
                .as("We verify that the list is added to correct folder " + TestCaseContext.getFolder().getId())
                .isEqualTo(id);

        TestCaseContext.getScenario().log("List is added to correct folder with ID: " + id);
    }

    @Then("Create new task in list")
    public void createNewTaskInList() {
        NameGenerator randomName = new NameGenerator();
        randomName.setName();
        TestCaseContext.setTaskName(randomName);
        JSONObject obj = new JSONObject();
        obj.put("name", randomName.getName());
        obj.put("description", TASK_DESCRIPTION);
        Response resp = createTask(obj, TestCaseContext.getList().getId());
        Task task = resp.as(Task.class);
        TestCaseContext.setTask(task);

        TestCaseContext.getScenario().log("Task name is " + task.getName());
    }

    @And("Verify task name is correct")
    public void verifyTaskNameIsCorrect() {
        Assertions.assertThat(TestCaseContext.getTask().getName())
                .as("We check that the Task name was updated to " + TestCaseContext.getTaskName().getName())
                .isEqualTo(TestCaseContext.getTaskName().getName());
    }

    @Then("Remove task from list")
    public void removeTaskFromList() {
        JSONObject obj = new JSONObject();
        Response resp = deleteTask(obj, TestCaseContext.getTask().getId());
    }

    @And("Fetch the List and verify that the Task can't be found there")
    public void getListInfoAndVerifyTaskIsNotAvailable() {
        JSONObject obj = new JSONObject();
        Response resp = getList(obj, TestCaseContext.getList().getId());
        Tasks list_info = resp.as(Tasks.class);

        Assertions.assertThat(0)
                .as("We assert that task is removed from list and it is empty")
                .isEqualTo(list_info.getTasks().size());

        TestCaseContext.getScenario().log("Information about tasks in list " + list_info.getTasks());
    }
}
