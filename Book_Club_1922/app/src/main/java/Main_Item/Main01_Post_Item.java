package Main_Item;

import java.util.ArrayList;

public class Main01_Post_Item {
    private String name,content,date,title;
    private int profile_res;
    public ArrayList<String> subjects = new ArrayList<>();

    public Main01_Post_Item(String name, String content, String date, String title,int profile_res){
        this.name = name;
        this.content = content;
        this.date = date;
        this.title = title;
        this.profile_res = profile_res;
    }

    public void add_subjects(String subject){
        this.subjects.add(subject);
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public int getProfile_res() {
        return profile_res;
    }
}
