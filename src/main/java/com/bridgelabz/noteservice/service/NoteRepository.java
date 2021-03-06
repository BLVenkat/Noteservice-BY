package com.bridgelabz.noteservice.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.noteservice.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

	public List<Note> findByUserId(Long userId);
}
