package com.goaltracker.goals.views;

import com.goaltracker.goals.models.Goal;
import com.goaltracker.goals.service.GoalService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("view-goals")
public class AddGoalView extends Composite<VerticalLayout> {

    private final GoalService goalService;

    @Autowired
    public AddGoalView(GoalService goalService) {
        this.goalService = goalService;

        // Toolbar with "Add Goal" button
        var toolbar = new HorizontalLayout(
                new Button("Add Goal")
        );

        // Grid to display goal data
        Grid<Goal> goalGrid = new Grid<>(Goal.class, false);

        goalGrid.addColumn(Goal::getGoalName).setHeader("Goal Name");
        goalGrid.addColumn(Goal::getStartDate).setHeader("Start Date");
        goalGrid.addColumn(Goal::getEndDate).setHeader("End Date");

        // Fetch goal data from the service
        goalGrid.setItems(goalService.getAllGoals());

        var mainLayout = getContent(); // returns vertical layout
        mainLayout.add(
                toolbar,
                goalGrid);
    }
}
