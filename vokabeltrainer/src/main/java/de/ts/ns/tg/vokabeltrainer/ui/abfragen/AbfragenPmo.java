package de.ts.ns.tg.vokabeltrainer.ui.abfragen;

import org.linkki.core.binding.BindingContext;
import org.linkki.core.defaults.columnbased.pmo.SimpleTablePmo;
import org.linkki.core.ui.layout.annotation.UISection;

import de.ts.ns.tg.vokabeltrainer.abfragen.Abfrage;
import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

@UISection(caption = "Vorhandene Abfragen")
public class AbfragenPmo extends SimpleTablePmo<Abfrage, AbfragenRowPmo> {

	private JpaVokabelRepsoitory repo;
	private GruppenProvider gruppeProvider;
	private BindingContext bindingContext;

	public AbfragenPmo(JpaVokabelRepsoitory repo, GruppenProvider gruppeProvider, BindingContext bindingContext) {
		super(() -> gruppeProvider.getGruppe().getAbfragen());
		this.repo = repo;
		this.gruppeProvider = gruppeProvider;
		this.bindingContext = bindingContext;
	}

	@Override
	protected AbfragenRowPmo createRow(Abfrage abfrage) {
		return new AbfragenRowPmo(repo, abfrage, gruppeProvider, bindingContext);
	}

}
