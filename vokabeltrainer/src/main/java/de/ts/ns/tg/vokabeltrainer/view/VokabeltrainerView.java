package de.ts.ns.tg.vokabeltrainer.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import de.ts.ns.tg.vokabeltrainer.ui.VokabeltrainerLayout;
import de.ts.ns.tg.vokabeltrainer.ui.gruppe.GruppenPage;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

@PageTitle("Vokabeltrainer")
@Route(value = "", layout = VokabeltrainerLayout.class)
public class VokabeltrainerView extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    @Autowired
    public VokabeltrainerView(JpaVokabelRepsoitory repo) {
    	GruppenPage gruppenPage = new GruppenPage(repo);
    	gruppenPage.init();
    	add(gruppenPage);
    }
    
}