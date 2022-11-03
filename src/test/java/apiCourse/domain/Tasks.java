package apiCourse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Tasks {
    @JsonProperty("tasks")
    private List tasks;


    public void setTasks(List tasks){
        this.tasks = tasks;
    }

    public List getTasks(){
        return tasks;
    }
}
