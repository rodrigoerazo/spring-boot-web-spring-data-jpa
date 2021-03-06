package com.danielme.springboot.services;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:db-test.properties")
@Sql("/test-mysql.sql")
public class CountryServiceTest {

    @Autowired
    CountryService countryService;

    @Test
    public void test() {
        assertEquals(3, countryService.findAll().size());
        //assertj
        assertThat(countryService.findAll()).hasSize(3);
    }

}
