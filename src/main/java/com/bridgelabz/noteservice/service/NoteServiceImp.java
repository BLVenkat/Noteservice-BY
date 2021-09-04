package com.bridgelabz.noteservice.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridgelabz.noteservice.dto.NoteDTO;
import com.bridgelabz.noteservice.entity.Note;

@Service
public class NoteServiceImp implements NoteService{

		
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	//@CachePut(value = "notes",key = "#token")
	public Note createNote(String token, NoteDTO noteDto) {
		
		Long userId = restTemplate.getForObject("http://localhost:8081/user/id/"+token, Long.class);
		Note note = new Note();
		BeanUtils.copyProperties(noteDto, note);
		note.setUserId(userId);
		return noteRepository.save(note);
	}	
	

	@Override
	//@Cacheable(value = "notes",key = "#token")
	public List<Note> getNotes(String token) {
		Long userId = restTemplate.getForObject("http://localhost:8081/user/id/"+token, Long.class);
		return noteRepository.findByUserId(userId);
	}
	
}