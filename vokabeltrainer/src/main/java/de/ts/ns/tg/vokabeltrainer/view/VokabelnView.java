package de.ts.ns.tg.vokabeltrainer.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;
import de.ts.ns.tg.vokabeltrainer.ui.VokabeltrainerLayout;
import de.ts.ns.tg.vokabeltrainer.ui.vokabeln.VokabelnPage;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

@PageTitle("Vokabeln")
@Route(value = "Vokabeln", layout = VokabeltrainerLayout.class)
public class VokabelnView extends VerticalLayout implements HasUrlParameter<Long> {

	private static final long serialVersionUID = 1L;

	private JpaVokabelRepsoitory repo;

	@Autowired
	public VokabelnView(JpaVokabelRepsoitory repo) {
		this.repo = repo;
	}

	@Override
	public void setParameter(BeforeEvent event, @OptionalParameter Long parameter) {
		VokabelnPage abfragePage = new VokabelnPage(repo, new GruppenProvider(repo.findById(parameter)));
		abfragePage.init();
		add(abfragePage);
	}

}