package com.reto_bci.BCI_RETO.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data.sql");
        if (inputStream == null) {
            throw new IllegalStateException("No se encontró 'data.sql' dentro del classpath.");
        }

        String sql = new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining("\n"));

        jdbcTemplate.execute(sql);
        System.out.println("✅ `data.sql` ejecutado correctamente.");
    }
}
