package apiCourse.clients;

import apiCourse.helpers.TestCaseContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static apiCourse.constants.ProjectConstants.*;

public class ClickUpClients {
    public static Response createFolder(JSONObject obj){
        return RestAssured
            .given().log().all()
            .contentType(ContentType.JSON)
            .header("Authorization", API_KEY)
            .body(obj)
            .when()
            .post("https://api.clickup.com/api/v2/space/" + SPACE_ID + "/folder")
            .then().log().all()
            .statusCode(200)
            .extract().response();
    }


    public static Response createList(JSONObject obj, String folder_id){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/folder/" + folder_id + "/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createTask(JSONObject obj, String list_id){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/list/" + list_id + "/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response deleteTask(JSONObject obj, String task_id){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .delete("https://api.clickup.com/api/v2/task/" + task_id)
                .then().log().all()
                .statusCode(204)
                .extract().response();
    }

    public static Response getList(JSONObject obj, String list_id){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .get("https://api.clickup.com/api/v2/list/" + list_id + "/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response deleteFolder(String folder_id){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .when()
                .delete("https://api.clickup.com/api/v2/folder/" + folder_id)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }


}
