package sample.classes;

import java.util.ArrayList;

public class Friends {

    public ArrayList<Friend> getListFriends() {
        return listFriends;
    }

    private ArrayList<Friend> listFriends;

    public Friends(){
        listFriends = new ArrayList<>();
    }

    public void add(Friend friend){
        this.listFriends.add(friend);
    }

}
