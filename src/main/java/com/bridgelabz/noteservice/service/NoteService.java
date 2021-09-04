package com.bridgelabz.noteservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.noteservice.dto.NoteDTO;
import com.bridgelabz.noteservice.entity.Note;

public interface NoteService {

	public Note createNote(String token,NoteDTO noteDto);

	public List<Note> getNotes(String token);
	

}
