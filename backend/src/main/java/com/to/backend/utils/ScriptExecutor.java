package com.to.backend.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
@Component

public class ScriptExecutor {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ScriptExecutor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer checkIfRecordsExists(){
        String query="SELECT COUNT(*) FROM public.items";
        return jdbcTemplate.queryForObject(query,Integer.class);
    }
    public void executeScript(String scriptPath) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(scriptPath);
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                StringBuilder scriptContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    scriptContent.append(line).append("\n");
                }
                jdbcTemplate.execute(scriptContent.toString());
                reader.close();
            } else {
                System.err.println("Script file not found: " + scriptPath);
            }
        } catch (IOException e) {
            System.err.println("Failed to execute script: " + e.getMessage());
        }
    }

}

