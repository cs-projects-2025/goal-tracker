package com.goaltracker.goals.views;

import com.goaltracker.goals.models.Goal;
import com.goaltracker.goals.service.GoalService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class HomeView extends Composite<VerticalLayout> {

    private final Div navbar; // Define the navbar container

    @Autowired
    public HomeView(GoalService goalService) {

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
        var toolbar = new HorizontalLayout(
                new Button("Add Goal")
        );



        var mainLayout = getContent(); // returns vertical layout
        mainLayout.add(navbar, toolbar); // Add navbar, toolbar, and grid to the main layout
    }

    public void addToNavbar(Component... components) {
        navbar.add(components); // Add components to the navbar
    }
}
