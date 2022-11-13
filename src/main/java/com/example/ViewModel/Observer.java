package com.example.ViewModel;

import com.example.Teams.Team;
import com.example.View.Observable;

public interface Observer {
    void update(Observable object, Team team);
}
