package com.example.manvi.restfulwebservices.User;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

public class FilteringController {
    @Autowired
    private UserDaoService service;

    @GetMapping("/filtering")
    //want to send only id and name.
    public MappingJacksonValue retrieveSomeUserValues() {
        User user = new User(555, "Manvi", new Date());
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);
        mappingJacksonValue.setFilters(getFilteredValues("name", "id"));

        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    //want to send only name and birthdate
    public MappingJacksonValue retrieveListOfUsers() {
        List<User> users = service.findAll();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users);
        mappingJacksonValue.setFilters(getFilteredValues("name", "birthDate"));

        return mappingJacksonValue;
    }

    private FilterProvider getFilteredValues(String... strings) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(strings);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("userFilter", filter);
        return filterProvider;
    }
}
