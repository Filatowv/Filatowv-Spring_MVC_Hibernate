package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping(value = "/cars")
        public String getCarsList(Model modelMap, @RequestParam(required = false) Integer count) {
        if (count == null) {
            modelMap.addAttribute("result",carService.getCars());
        } else {
            modelMap.addAttribute("result", carService.getRequiredNumberOfCars(carService.getCars(), count));
        }
            return "cars";
        }
}

