package expense.management.tracker.dto.authentication;

public class LoginRequest {
    private String userName;

    private String password;

    public String getPassword() {
        return this.password;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
