package com.example.webservice;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class CarsController {

    private HashMap<String, Car> cars;

    public CarsController() {
        this.cars = new HashMap<String, Car>();
        cars.put("LK-865-MP", new Car("LK-865-MP"));
        cars.put("VC-217-SQ", new Car("VC-217-SQ"));
        cars.put("XD-873-NC", new Car("XD-873-NC"));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String index() {
        return "Spring Boot Web Service";
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Collection<Car> getCars() throws Exception {
        return this.cars.values();
    }

    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car getCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
        return this.cars.get(plateNumber);
    }

    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void rent(@PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent, @RequestBody(required = false) Rent dates) throws Exception {
        this.cars.get(plateNumber).setRent(rent ? dates : null);
    }

    @RequestMapping(value = "/cars/{plateNumber}/rent", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Rent getRents(@PathVariable("plateNumber") String plateNumber) throws Exception {
        return this.cars.get(plateNumber).getRent();
    }

}