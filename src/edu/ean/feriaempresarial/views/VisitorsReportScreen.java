package edu.ean.feriaempresarial.views;

import edu.ean.feriaempresarial.model.AppState;
import edu.ean.feriaempresarial.model.EntityRegister;
import edu.ean.feriaempresarial.model.Visit;
import edu.ean.feriaempresarial.model.Visitor;

public class VisitorsReportScreen implements IScreen {
    private EntityRegister<Visitor> visitorRegister;
    private EntityRegister<Visit> visitRegister;

    public VisitorsReportScreen(EntityRegister<Visitor> visitorRegister, EntityRegister<Visit> visitRegister) {
        this.visitorRegister = visitorRegister;
        this.visitRegister = visitRegister;
    }

    @Override
    public void show() {
        System.out.println("Reporte de visitantes y stands visitados");
        
        for (Visitor visitor : visitorRegister.getEntities()) {
            System.out.print(visitor.getName() + " - Stands visitados: ");
            for (Visit visit : visitRegister.getEntities()) {
                if (visit.getVisitor().equals(visitor)) {
                    System.out.print(visit.getStand().getId() + ", ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void update(AppState appState) {
        appState.setScreen(new ReportsScreen());
    }
    
}
