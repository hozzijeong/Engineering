package Item;

public class Phone_Item {
    private String user_name;
    private String user_num;

    public Phone_Item(String name,String num){
        this.user_name = name;
        this.user_num = num;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_num() {
        return user_num;
    }
}
