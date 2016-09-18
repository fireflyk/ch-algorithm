package com.codinghero.interview.ood.restaurant;

import java.util.List;

public class Reservation {

    private ReserveApplication application;

    private List<Table> tables;

    public ReserveApplication getApplication() {
        return application;
    }

    public void setApplication(ReserveApplication application) {
        this.application = application;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

}
