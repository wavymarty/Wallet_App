package edu.itstep.blockchain.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  //domain-name:port/support-system?title=test&name=test2
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
  @GetMapping("/issue/{id}")
  public ResponseEntity<SupportSystem> getTutorialById(@PathVariable("id") long id) throws ResourceNotFoundException {
	  SupportSystem tutorial = ssr.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found issue with id = " + id));

    return new ResponseEntity<>(tutorial, HttpStatus.OK);
  }
  @GetMapping("/issues/resolved")
  public ResponseEntity<List<SupportSystem>> findByPublished() {
    List<SupportSystem> listIssue = ssr.findByStatus(true);

    if (listIssue.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    return new ResponseEntity<>(listIssue, HttpStatus.OK);
  }
}

