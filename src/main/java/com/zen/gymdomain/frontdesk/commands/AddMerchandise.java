package com.zen.gymdomain.frontdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.frontdesk.entities.Merchandise;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;

public class AddMerchandise extends Command {
    private final FrontDeskID frontDeskID;
    private final Merchandise merchandise;

    public AddMerchandise(FrontDeskID frontDeskID, Merchandise merchandise) {
        this.frontDeskID = frontDeskID;
        this.merchandise = merchandise;
    }

    public FrontDeskID getFrontDeskID() {
        return frontDeskID;
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }
}
