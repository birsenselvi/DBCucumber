package com.guidersoft;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;


import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TestConfig config1 = TestConfigReader.instance().getConfig();
        System.out.println("config1.getApplication().getName() = " + config1.getApplication().getName());

    }
    public static void main1(String[] args) throws IOException {
        File file = new File("testconfig.yml");

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TestConfig config = mapper.readValue(file, TestConfig.class);
        System.out.println("config.getApplication().getName() "+ config.getApplication().getName());
        String pass= "";
        pass = config.getUsers().stream()
                .filter(user->user.getType().equalsIgnoreCase("admin"))
                .findFirst()
                .get()
                .getPassword();
        System.out.println("password = " + pass);
    }
}