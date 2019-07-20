package com.cg.frs.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class FRSExceptionController {

	@ExceptionHandler(TicketIdNotFoundException.class)
	public final ResponseEntity<Object> handleTicketIdNotFoundException(TicketIdNotFoundException exception,
			WebRequest request) {
		ServerError error = new ServerError("Ticket Id Not Found", exception.getMessage(), new Date(),
				request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public final ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException exception,
			WebRequest request) {
		ServerError error = new ServerError("Page Not Found", exception.getLocalizedMessage(), new Date(),
				request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// @ExceptionHandler(Exception.class)
	// public final ResponseEntity<Object> handleNoHandlerFoundException(Exception
	// exception,
	// WebRequest request) {
	// ServerError error = new ServerError("Page Not Found",
	// exception.getLocalizedMessage(), new Date(),
	// request.getDescription(false));
	// return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	// }

	// @ExceptionHandler(value = { TicketIdNotFoundException.class })
	// @ResponseStatus(HttpStatus.NOT_FOUND)
	// public ServerError unKnownException(TicketIdNotFoundException exception) {
	// return new ServerError(404, ExceptionMessages.MESSAGE9);
	// }

	// @ExceptionHandler(RecordNotFoundException.class)
	// public final ResponseEntity<Object>
	// handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
	// List<String> details = new ArrayList<>();
	// details.add(ex.getLocalizedMessage());
	// ErrorResponse error = new ErrorResponse("Record Not Found", details);
	// return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	// }
}
