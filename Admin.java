public class Admin {
    private String adminID;
    private String password;


    public Admin(String adminID, String password) {
        this.adminID = adminID;
        this.password = password;
    }


    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
