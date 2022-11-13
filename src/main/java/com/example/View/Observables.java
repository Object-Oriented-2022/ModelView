package com.example.View;

import com.example.Teams.Team;
import com.example.ViewModel.Observer;

public interface Observables {
    void addObserver(Observer observer);
    void updateObservers(Observable object, Team newTeam);
    void update(Object object);
}
