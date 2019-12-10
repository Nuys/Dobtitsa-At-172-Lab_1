package sample.classes;

public class AccountInfo {

    public long getAppRequests() {
        return appRequests;
    }

    public void setAppRequests(long appRequests) {
        this.appRequests = appRequests;
    }

    public long getFriends() {
        return friends;
    }

    public void setFriends(long friends) {
        this.friends = friends;
    }

    public long getFriendsRecomendations() {
        return friendsRecomendations;
    }

    public void setFriendsRecomendations(long friendsRecomendations) {
        this.friendsRecomendations = friendsRecomendations;
    }

    public long getMessages() {
        return messages;
    }

    public void setMessages(long messages) {
        this.messages = messages;
    }

    private long appRequests;
    private long friends;
    private long friendsRecomendations;
    private long gifts;
    private long messages;

    public AccountInfo(long appRequests, long friends, long friendsRecomendations, long messages){
        this.appRequests = appRequests;
        this.friends = friends;
        this.friendsRecomendations = friendsRecomendations;
        this.gifts = gifts;
        this.messages = messages;
    }

    public AccountInfo(){

    }
}
