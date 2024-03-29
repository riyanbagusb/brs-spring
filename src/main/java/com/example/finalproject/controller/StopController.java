package com.example.finalproject.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalproject.models.Stop;
import com.example.finalproject.repository.StopRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/stop")
public class StopController {
	@Autowired
	StopRepository stopRepository;
	
	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
	public ResponseEntity<?> getAllStops() {
        return ResponseEntity.ok(stopRepository.findAll());
	}
	
//	@GetMapping("/{id}")
//	@ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
//    @PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<?> getStopById(@PathVariable(value="id") Long id){
//        Stop stop = stopRepository.findById(id).get();
//		if(stop == null) {
//			return ResponseEntity.notFound().build();
//		} else {
//            return ResponseEntity.ok(stop);
//		}
//	}
//	
//	@GetMapping("/code")
//	@ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<?> getStopByCode (@RequestParam(value="code") String code){
//        return ResponseEntity.ok(stopRepository.findByCode(code));
//	}
//	
//	@GetMapping("/name")
//	@ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<?> getStopByName(@RequestParam(value="name") String name){
//        return ResponseEntity.ok(stopRepository.findByName(name));
//	}
	
	@PostMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
	public ResponseEntity<?> addStop(@Valid @RequestBody Stop stop) {
        return ResponseEntity.ok(stopRepository.save(stop));
	}
	
//	@PutMapping("/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
//	@ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
//	public ResponseEntity<?> updateStop(@PathVariable(value="id") Long id, @Valid @RequestBody Stop stopDetail){
//		Stop stop = stopRepository.findById(id).get();
//		if(stop == null) {
//			return ResponseEntity.notFound().build();
//		}
//        stop.setCode(stopDetail.getCode());
//        stop.setName(stopDetail.getName());
//        stop.setDetail(stopDetail.getDetail());
//
//        Stop updatedStop = stopRepository.save(stop);
//
//        return ResponseEntity.ok(updatedStop);
//	}
//	
//	@DeleteMapping("/{id}")
//	@ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
//    @PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<?> deleteStop(@PathVariable(value="id") Long id) {
//		String result = "";
//		try {
//            stopRepository.findById(id).get();
//			
//			result = "Success Deleting Data with Id: " + id;
//            stopRepository.deleteById(id);
//
//            return ResponseEntity.ok(result);
//		} catch(Exception e) {
//			result = "Data with Id: " + id + " Not Found";
//            return ResponseEntity.ok(result);
//		}
//	}
}
