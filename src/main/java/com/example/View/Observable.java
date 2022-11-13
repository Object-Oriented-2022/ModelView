package com.example.View;

import com.example.Teams.Team;
import com.example.ViewModel.Observer;

import java.util.LinkedList;

public abstract class Observable implements Observables{
    LinkedList<Observer> observers = new LinkedList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void updateObservers(Observable object, Team newTeam){
        for (Observer observer : observers) {
            observer.update(object, newTeam);
        }
    }
}
