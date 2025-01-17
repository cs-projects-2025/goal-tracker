package com.goaltracker.goals.views;

import com.goaltracker.goals.models.Goal;
import com.goaltracker.goals.service.GoalService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

@Route("view-goals")
public class AddGoalView extends Composite<VerticalLayout> {

    private final GoalService goalService;
    private final Div navbar; // Define the navbar container
    private Grid<Goal> goalGrid;

    @Autowired
    public AddGoalView(GoalService goalService) {
        this.goalService = goalService;

        // Initialize navbar container
        navbar = new Div();
        navbar.setClassName("navbar"); // Add CSS class for styling if needed
        navbar.setWidthFull(); // Make it full-width

        // Create tabs and link them to your views
        Tab homeTab = new Tab(new RouterLink("Home", HomeView.class));
        Tab goalsTab = new Tab(new RouterLink("My Goals", AddGoalView.class));

        // Ensure the RouterLink fills the entire tab for better clickability
        homeTab.getElement().getStyle().set("flex-grow", "1");
        goalsTab.getElement().getStyle().set("flex-grow", "1");

        // Create a Tabs component and set it to expand equally
        Tabs tabs = new Tabs(homeTab, goalsTab);
        tabs.setWidthFull();
        tabs.setFlexGrowForEnclosedTabs(1);

        // Add the tabs to the navbar
        addToNavbar(tabs);

        // Toolbar with "Add Goal" button
        // Create the "Add Goal" button and form layout
        var toolbar = new HorizontalLayout(
                new Button("Add Goal", event -> openGoalForm())
        );

        // Grid to display goal data
        goalGrid = new Grid<>(Goal.class, false);

        goalGrid.addColumn(Goal::getGoalName).setHeader("Goal Name");
        goalGrid.addColumn(Goal::getStartDate).setHeader("Start Date");
        goalGrid.addColumn(Goal::getEndDate).setHeader("End Date");

        // Fetch goal data from the service
        goalGrid.setItems(goalService.getAllGoals());

        var mainLayout = getContent(); // returns vertical layout
        mainLayout.add(navbar, toolbar, goalGrid); // Add navbar, toolbar, and grid to the main layout
    }

    public void addToNavbar(Component... components) {
        navbar.add(components); // Add components to the navbar
    }

    private void openGoalForm() {
        // Create a form layout
        FormLayout formLayout = new FormLayout();

        // Input fields for Goal attributes
        TextField goalNameField = new TextField("Goal Name");
        DatePicker startDatePicker = new DatePicker("Start Date");
        DatePicker endDatePicker = new DatePicker("End Date");

        // Submit button to save goal data
        Button submitButton = new Button("Create Goal", event -> saveGoal(goalNameField, startDatePicker, endDatePicker));

        // Add fields and submit button to form layout
        formLayout.add(goalNameField, startDatePicker, endDatePicker, submitButton);

        // Display the form in a dialog or overlay (for simplicity, using a Div here)
        Div formContainer = new Div(formLayout);
        formContainer.setWidth("400px");
        formContainer.setHeight("300px");

        // Show the form (you can open it in a dialog as well)
        getContent().add(formContainer);
    }

    // Method to save the goal data and reload the grid
    private void saveGoal(TextField goalNameField, DatePicker startDatePicker, DatePicker endDatePicker) {
        Goal newGoal = new Goal();
        newGoal.setGoalName(goalNameField.getValue());
        newGoal.setStartDate(startDatePicker.getValue());
        newGoal.setEndDate(endDatePicker.getValue());

        // Save the new goal to the database
        goalService.createGoal(newGoal);

        // Refresh the grid with the updated data
        goalGrid.setItems(goalService.getAllGoals());

        // Optionally, close the form after submission
        goalNameField.getUI().ifPresent(ui -> ui.access(() -> {
            goalNameField.getParent().ifPresent(parent -> getContent().remove(parent));
        }));
    }
}
