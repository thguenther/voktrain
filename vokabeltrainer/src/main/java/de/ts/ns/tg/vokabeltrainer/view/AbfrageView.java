package de.ts.ns.tg.vokabeltrainer.view;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;
import de.ts.ns.tg.vokabeltrainer.ui.VokabeltrainerLayout;
import de.ts.ns.tg.vokabeltrainer.ui.abfragen.AbfragenPage;
import de.ts.ns.tg.vokabeltrainer.vokabeln.Gruppe;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

@PageTitle("Abfragen")
@Route(value = "Abfragen", layout = VokabeltrainerLayout.class)
public class AbfrageView extends VerticalLayout implements HasUrlParameter<Long> {

	public static final String ROUTE = "Abfragen";

	private static final long serialVersionUID = 1L;

	private JpaVokabelRepsoitory repo;
	private Optional<Gruppe> aktuelleGruppe = Optional.empty();

	@Autowired
	public AbfrageView(JpaVokabelRepsoitory repo) {
		this.repo = repo;
	}

	public Optional<Gruppe> getAktuelleGruppe() {
		return aktuelleGruppe;
	}

	@Override
	public void setParameter(BeforeEvent event, @OptionalParameter Long parameter) {
		AbfragenPage abfragePage = new AbfragenPage(repo, new GruppenProvider(repo.findById(parameter)));
		abfragePage.init();
		add(abfragePage);
	}

}