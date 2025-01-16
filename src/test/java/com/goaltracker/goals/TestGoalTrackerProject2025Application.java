package com.goaltracker.goals;

import org.springframework.boot.SpringApplication;

public class TestGoalTrackerProject2025Application {

	public static void main(String[] args) {
		SpringApplication.from(GoalTrackerProject2025Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
