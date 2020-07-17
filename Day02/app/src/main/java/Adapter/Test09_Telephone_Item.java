package Adapter;

public class Test09_Telephone_Item {

    private int profile_iv;
    private String name,number;

    public Test09_Telephone_Item(int iv, String name, String number){
        this.profile_iv = iv;
        this.name = name;
        this.number= number;
    }

    public int getProfile_iv() {
        return profile_iv;
    }

    public void setProfile_iv(int profile_iv) {
        this.profile_iv = profile_iv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }




}
