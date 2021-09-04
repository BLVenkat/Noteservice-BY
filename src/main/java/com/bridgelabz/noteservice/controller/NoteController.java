package com.bridgelabz.noteservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.noteservice.dto.NoteDTO;
import com.bridgelabz.noteservice.entity.Note;
import com.bridgelabz.noteservice.response.Response;
import com.bridgelabz.noteservice.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(value = {"","/"})
	public ResponseEntity<Response> createNote(@RequestHeader String token, @RequestBody NoteDTO noteDto) {
				noteService.createNote(token, noteDto);
		return new ResponseEntity<Response>(
				new Response(HttpStatus.CREATED.value(), "Note Created Successfully", ""), HttpStatus.CREATED);
	}
	
	
	
	@GetMapping()
	public ResponseEntity<Response> getNotes(@RequestHeader String token) {
		List<Note> notes = noteService.getNotes(token);
		return new ResponseEntity<Response>(
				new Response(HttpStatus.OK.value(), "Notes Fetched Successfully", notes), HttpStatus.OK);
	}
	
	@GetMapping("/user/port")
	public String getUserServicePort() {
		String userServicePort = restTemplate.getForObject("http://USERSERVICE/user/port", String.class);
		return userServicePort;
	}
	
}
