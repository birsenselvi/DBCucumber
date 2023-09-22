package com.guidersoft.config;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Data
public class TestConfig {

    private Application application;
    private List<User> users = new ArrayList<User>();
    private Tests tests;
    private Browser chrome;
    private Browser edge;
    private Map<String, String> variables;
    public User getUser(String userType){
        return users.stream().filter(u->u.getType().equalsIgnoreCase(userType)).findFirst().get();
    }
    @Data
    public static class Application {
        private String name;
        private String url;

    }
    @Data
    public static class Browser{
        private Integer version;
        private List<String> options = new ArrayList<>();
    }
/*
    @Data
    public static class Chrome {
        private Integer version;
        private Object options;

    }
    @Data

    public static class Edge {
        private Integer version;
        private Object options;

    }

 */
    @Data

    public static class Tests {
        private Browsers browser;
        private String features;
        private String tags;


    }
    @Data
    public static class User {
        private String type;
        private String name;
        private String username;
        private String password;

    }
    public enum Browsers{
        CHROME,
        EDGE,
        SAFARI,
        FIREFOX;
    }

    }

