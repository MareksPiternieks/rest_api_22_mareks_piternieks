package apiCourse.helpers;

import apiCourse.domain.Folder;
import apiCourse.domain.List;
import apiCourse.domain.Task;
import io.cucumber.java.Scenario;

public class TestCaseContext {
    private static Folder folder;
    private static List list;
    private static Task task;
    private static NameGenerator name;
    private static Scenario scenario;
    private static NameGenerator task_name;

    public static void init(){
        folder = null;
        list = null;
        name = null;
        task = null;
        task_name = null;
    }

    public static void setFolder(Folder folder){
        TestCaseContext.folder = folder;
    }

    public static Folder getFolder(){
        return folder;
    }


    public static void setList(List list){
        TestCaseContext.list = list;
    }

    public static List getList(){
        return list;
    }


    public static void setTask(Task task){
        TestCaseContext.task = task;
    }

    public static Task getTask(){
        return task;
    }

    public static void setTaskName(NameGenerator task_name){
        TestCaseContext.task_name = task_name;
    }

    public static NameGenerator getTaskName(){
        return task_name;
    }


    public static void setName(){
        TestCaseContext.name = name;
    }

    public static NameGenerator getName(){
        return name;
    }


    public static void setScenario(Scenario scenario){
        TestCaseContext.scenario = scenario;
    }

    public static Scenario getScenario(){
        return scenario;
    }
}
