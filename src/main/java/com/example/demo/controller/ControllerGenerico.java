package com.example.demo.controller;


import com.example.demo.service.IservicioGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

public class ControllerGenerico <E, S extends IservicioGenerico<E>> {
    @Autowired
    protected S service;

    @GetMapping("/count")
    @Transactional
    public ResponseEntity<?> getCount(@RequestParam(value = "size", defaultValue = "10") int size) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body("{\"pages\": " + service.countPages(size) + "}");
        } catch (Exception e) {
            return null;
        }

    }

    @GetMapping("")
    @Transactional
    public ResponseEntity<?> getAll(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value =  "size", defaultValue = "10") int size){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(page, size));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
        }
    }


    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    @Transactional
    public ResponseEntity getOne(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \""+e.getMessage()+"\"}");
        }
    }


    @PostMapping("/")
    @Transactional
    public ResponseEntity<?> post(@RequestBody E entidadForm) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entidadForm));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \""+e.getMessage()+"\"}");
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> put(@PathVariable int id, @RequestBody E entidadForm) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entidadForm));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \""+e.getMessage()+"\"}");
        }
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \""+e.getMessage()+"\"}");
        }
    }
}
