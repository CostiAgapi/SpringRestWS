package controllers;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Car;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ConstantinAgapi on 21/09/2017.
 */
@RestController
public class GreetController {

    @RequestMapping(value = "/getString", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String asd(){
        Car car = new Car();
        car.setId("dsafs");
        car.setName("sadfs");
        Car car2 = new Car();
        car2.setId("123");
        car2.setName("sad1231fs");
        List<Car> list = new ArrayList<Car>();
        list.add(car);
        list.add(car2);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            mapper.writeValue(out, list);
            final byte[] data = out.toByteArray();
            result = new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
