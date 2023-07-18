package edu.itstep.blockchain.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.itstep.blockchain.domain.SupportSystem;
import edu.itstep.blockchain.repository.SuportSystemRepository;

@RestController
//domain-name:port/support-system
@RequestMapping("/support-system")
public class SupportSystemController {
  	
  SuportSystemRepository ssr;
  
  public SupportSystemController(SuportSystemRepository ssr) {
	  this.ssr = ssr;
  }
  @GetMapping("/all")
  public ResponseEntity<List<SupportSystem>> getAll(@RequestParam(required=false)String title){
	  List<SupportSystem> systems = new ArrayList<>();
	  if(title == null) {
		  ssr.findAll().forEach(systems::add);
	  }else {
		  ssr.findByTitleContaining(title).forEach(systems::add);
	  }
	  if(systems.isEmpty())return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  return new ResponseEntity<>(systems, HttpStatus.OK);
  }
}
