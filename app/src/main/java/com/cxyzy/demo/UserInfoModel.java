package com.cxyzy.demo;

public class UserInfoModel {

    public int code;
    public UserInfo data;
    public String message;

    public static class UserInfo{
        public int id;
        public String username;
        public String email;
        public String tel;
    }

    @Override
    public String toString() {
        return "UserInfoModel{" +
                "code=" + code +
                "\n, data{ id=" + data.id +
                "\n, username=" + data.username +
                "\n, email=" + data.email +
                "\n, tel=" + data.tel +
                "},\n message='" + message + '}';
    }
}