package de.ts.ns.tg.vokabeltrainer.ui.vokabeln;

import org.linkki.core.defaults.columnbased.pmo.SimpleTablePmo;
import org.linkki.core.ui.layout.annotation.UISection;

import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;
import de.ts.ns.tg.vokabeltrainer.vokabeln.Vokabel;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

@UISection(caption = "Vorhandene Vokabeln")
public class VokabelnPmo extends SimpleTablePmo<Vokabel, VokabelnRowPmo> {

	private JpaVokabelRepsoitory repo;
	private GruppenProvider gruppeProvider;

	public VokabelnPmo(JpaVokabelRepsoitory repo, GruppenProvider gruppeProvider) {
		super(() -> gruppeProvider.getGruppe().getVokabeln());
		this.repo = repo;
		this.gruppeProvider = gruppeProvider;
	}

	@Override
	protected VokabelnRowPmo createRow(Vokabel vokabel) {
		return new VokabelnRowPmo(repo, vokabel, gruppeProvider);
	}

}
