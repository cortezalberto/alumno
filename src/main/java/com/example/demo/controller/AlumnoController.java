package com.example.demo.controller;

import com.example.demo.entities.Alumno;
import com.example.demo.service.AlumnoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",
        methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping(path = "api/v1/alumno")
public class AlumnoController extends ControllerGenerico<Alumno, AlumnoService>{


}

