package com.acme.todolist.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;

public class TodoItemTest {
	static final String LATE = "[LATE!] ";
	
	@Test
	public void finalContent_todoIsLate() {
		LocalDate date = LocalDate.parse("2000-01-01");
		Instant late = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		TodoItem todo = new TodoItem("1", late, "late");

		assertTrue(todo.finalContent().contains(LATE));
	}

	@Test
	public void finalContent_todoIsNotLate() {
		Instant notLate = Instant.now();
		TodoItem todo = new TodoItem("2", notLate, "not late");

		assertTrue(!todo.finalContent().contains(LATE));
	}
}
