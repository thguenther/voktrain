package de.ts.ns.tg.vokabeltrainer.ui.gruppe;

import org.linkki.core.binding.manager.BindingManager;
import org.linkki.core.binding.manager.DefaultBindingManager;
import org.linkki.core.vaadin.component.page.AbstractPage;

import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

public class GruppenPage extends AbstractPage {

	private static final long serialVersionUID = 1L;
	private final BindingManager bindingManager = new DefaultBindingManager();
	private JpaVokabelRepsoitory repo;

	public GruppenPage(JpaVokabelRepsoitory repo) {
		this.repo = repo;
	}

	@Override
	public void createContent() {
		addSection(new GruppeNeuPmo(repo));
		addSection(new GruppenPmo(repo, () -> repo.findAllGruppen()));
	}

	@Override
	protected BindingManager getBindingManager() {
		return bindingManager;
	}

}
