package de.ts.ns.tg.vokabeltrainer.ui.gruppe;

import java.util.List;
import java.util.function.Supplier;

import org.linkki.core.defaults.columnbased.pmo.SimpleTablePmo;
import org.linkki.core.ui.layout.annotation.UISection;

import de.ts.ns.tg.vokabeltrainer.vokabeln.Gruppe;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

@UISection(caption = "Vorhandene Vokabel-Gruppierungen")
public class GruppenPmo extends SimpleTablePmo<Gruppe, GruppenRowPmo> {

	private JpaVokabelRepsoitory repo;

	public GruppenPmo(JpaVokabelRepsoitory repo, Supplier<List<? extends Gruppe>> modelObjectsSupplier) {
		super(modelObjectsSupplier);
		this.repo = repo;
	}

	@Override
	protected GruppenRowPmo createRow(Gruppe gruppe) {
		return new GruppenRowPmo(repo, gruppe);
	}

}
