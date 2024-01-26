package com.cbfacademy.apiassessment.file;

public class FileUser {
    
    private String id;
    private String userName;


    public FileUser(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }


    public FileUser() {
    }


    public String getId() {
        return id;
    }


    public String getUserName() {
        return userName;
    }


    public void setId(String id) {
        this.id = id;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Override
    public String toString() {
        return "FileUser [id=" + id + ", userName=" + userName + "]";
    }

    

    


    
    
}
