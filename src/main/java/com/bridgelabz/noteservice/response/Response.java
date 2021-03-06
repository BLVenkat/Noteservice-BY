package com.bridgelabz.noteservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

	private int statusCode;
	private String statusMessage;
	private Object data;
}
