package de.ts.ns.tg.vokabeltrainer.ui.abfragen;

import org.linkki.core.binding.manager.BindingManager;
import org.linkki.core.binding.manager.DefaultBindingManager;
import org.linkki.core.vaadin.component.page.AbstractPage;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;

import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

public class AbfragenPage extends AbstractPage {

	private static final long serialVersionUID = 1L;
	private final BindingManager bindingManager = new DefaultBindingManager();
	private GruppenProvider gruppeProvider;
	private JpaVokabelRepsoitory repo;

	public AbfragenPage(JpaVokabelRepsoitory repo, GruppenProvider gruppenProvider) {
		this.repo = repo;
		this.gruppeProvider = gruppenProvider;
	}

	@Override
	public void createContent() {
		if (gruppeProvider.getGruppe() == null) {
			add(createErrorLayout());
		} else {
			addSection(new AbfrageNeuPmo(repo, gruppeProvider));
			var abfragenPmo = new AbfragenPmo(repo, gruppeProvider, getBindingContext());
			addSection(abfragenPmo);
		}
	}

	private Component createErrorLayout() {
		return new Div(new Text("Es wurde keine Gruppe ausgewählt, es können daher keine Abfragen angezeigt werden."));
	}

	@Override
	protected BindingManager getBindingManager() {
		return bindingManager;
	}

}
