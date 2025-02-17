package edu.ean.feriaempresarial.views;

import edu.ean.feriaempresarial.model.AppState;

public interface IScreen {
    void show();
    void update(AppState appState);
}
