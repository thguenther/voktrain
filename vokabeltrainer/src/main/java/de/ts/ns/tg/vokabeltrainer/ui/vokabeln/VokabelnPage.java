package de.ts.ns.tg.vokabeltrainer.ui.vokabeln;

import org.linkki.core.binding.manager.BindingManager;
import org.linkki.core.binding.manager.DefaultBindingManager;
import org.linkki.core.vaadin.component.page.AbstractPage;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;

import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;
import de.ts.ns.tg.vokabeltrainer.ui.abfragen.SonderzeichenPmo;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

public class VokabelnPage extends AbstractPage {

	private static final long serialVersionUID = 1L;
	private final BindingManager bindingManager = new DefaultBindingManager();
	private GruppenProvider gruppeProvider;
	private JpaVokabelRepsoitory repo;

	public VokabelnPage(JpaVokabelRepsoitory repo, GruppenProvider gruppenProvider) {
		this.repo = repo;
		this.gruppeProvider = gruppenProvider;
	}

	@Override
	public void createContent() {
		if (gruppeProvider.getGruppe() == null) {
			add(createErrorLayout());
		} else {
			var neueVokabeln = new VokabelNeuPmo(repo, gruppeProvider);
			addSection(neueVokabeln);
			addSection(new SonderzeichenPmo(neueVokabeln::einfuegen));
			var gruppenPmo = new VokabelnPmo(repo, gruppeProvider);
			addSection(gruppenPmo);
		}
	}

	private Component createErrorLayout() {
		return new Div(new Text("Es wurde keine Gruppe ausgewählt, es können daher keine Vokabeln angzeigt werden."));
	}

	@Override
	protected BindingManager getBindingManager() {
		return bindingManager;
	}

}
