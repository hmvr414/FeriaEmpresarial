package edu.ean.feriaempresarial.model;

import edu.ean.feriaempresarial.views.IScreen;
import edu.ean.feriaempresarial.views.MainMenuScreen;

public class AppState {
    private boolean isRunning = true;
    private IScreen currentScreen = new MainMenuScreen();
    private String userInput;

    private EntityRegister<Company> companyRegister = new EntityRegister<>();
    private EntityRegister<Stand> standRegister = new EntityRegister<>();
    private EntityRegister<Visitor> visitorRegister = new EntityRegister<>();
    private EntityRegister<StandOccupancy> standOccupancyRegister = new EntityRegister<>();
    private EntityRegister<Visit> visitRegister = new EntityRegister<>();

    public boolean isRunning() {
        return isRunning;
    }

    public EntityRegister<Company> getCompanyRegister() {
        return companyRegister;
    }

    public EntityRegister<Stand> getStandRegister() {
        return standRegister;
    }

    public EntityRegister<Visitor> getVisitorRegister() {
        return visitorRegister;
    }

    public EntityRegister<StandOccupancy> getStandOccupancyRegister() {
        return standOccupancyRegister;
    }

    public EntityRegister<Visit> getVisitRegister() {
        return visitRegister;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getUserInput() {
        return userInput;
    }

    public void showScreen() {
        currentScreen.show();
    }

    public void showMainMenu() {
        currentScreen = new MainMenuScreen();
    }

    public void setScreen(IScreen screen) {
        currentScreen = screen;
    }

    public void update(String option) {
        userInput = option;
        currentScreen.update(this);
    }

    public void loadCompanyStandsVisitorsTestData() {
        try {
            companyRegister.add(new Company("EAN", "Educacion", "luisgui@ean.com"));
            companyRegister.add(new Company("Google", "Tech", "larry@google.com"));
            companyRegister.add(new Company("Microsoft", "Tech", "bill@microsoft.com"));
    
            standRegister.add(new Stand("L1", "Pabellon A", "pequeño"));
            standRegister.add(new Stand("L2", "Pabellon A", "pequeño"));
            standRegister.add(new Stand("L3", "Pabellon B", "mediano"));
    
            visitorRegister.add(new Visitor("1234567890", "Juan", "juan@gmail.com"));
            visitorRegister.add(new Visitor("0987654321", "Pedro", "pedro@gmail.com"));
            visitorRegister.add(new Visitor("1357924680", "Maria", "maria@gmail.com"));
    
            // standOccupancyRegister.add(new StandOccupancy(standRegister.get("Stand 1").get(), 10));
            // standOccupancyRegister.add(new StandOccupancy(standRegister.get("Stand 2").get(), 20));
            // standOccupancyRegister.add(new StandOccupancy(standRegister.get("Stand 3").get(), 30));
        } catch (Exception e) {
            System.out.println("Error cargando datos de prueba");
            e.printStackTrace();
        }
    }

    public void loadStandOccupancyVisitsTestData() {
        try {
            companyRegister = new EntityRegister<>();
            standRegister = new EntityRegister<>();
            visitorRegister = new EntityRegister<>();
            standOccupancyRegister = new EntityRegister<>();
            visitRegister = new EntityRegister<>();

            loadCompanyStandsVisitorsTestData();

            standOccupancyRegister.add(new StandOccupancy(standRegister.get("L1").get(), companyRegister.get("EAN").get()));
            standOccupancyRegister.add(new StandOccupancy(standRegister.get("L2").get(), companyRegister.get("Google").get()));
            standOccupancyRegister.add(new StandOccupancy(standRegister.get("L3").get(), companyRegister.get("Microsoft").get()));
            
            
            visitRegister.add(new Visit(visitorRegister.get("1357924680").get(), standRegister.get("L1").get(), "13-01-2025 14:30:00", "Muy bueno", 5));
            visitRegister.add(new Visit(visitorRegister.get("1234567890").get(), standRegister.get("L1").get(), "13-01-2025 15:30:00", "Esta bien", 4));
            visitRegister.add(new Visit(visitorRegister.get("0987654321").get(), standRegister.get("L2").get(), "13-01-2025 16:30:00", "Excelente", 5));
            visitRegister.add(new Visit(visitorRegister.get("1357924680").get(), standRegister.get("L3").get(), "13-01-2025 17:30:00", "Muy interesante", 4));
            visitRegister.add(new Visit(visitorRegister.get("1234567890").get(), standRegister.get("L3").get(), "13-01-2025 18:30:00", "Regular", 3));
        } catch (Exception e) {
            System.out.println("Error cargando datos de prueba");
            e.printStackTrace();
        }
    }
}
