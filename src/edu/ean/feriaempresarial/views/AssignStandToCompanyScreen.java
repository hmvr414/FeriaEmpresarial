package edu.ean.feriaempresarial.views;

public class AssignStandToCompanyScreen implements IScreen {
    private AppState appState;

    public AssignStandToCompanyScreen(AppState appState) {
        this.appState = appState;
    }

    @Override
    public void show() {
        System.out.println("Assign Stand to Company Screen");
    }

    @Override
    public void update(AppState appState) {
        this.appState = appState;
    }
    
}
