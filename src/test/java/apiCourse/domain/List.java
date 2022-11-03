package apiCourse.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class List {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("folder")
    private Object list_folder_info;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setListFolderInfo(Object list_folder_info){
        this.list_folder_info = list_folder_info;
    }

    public Object getListFolderInfo(){
        return list_folder_info;
    }
}
