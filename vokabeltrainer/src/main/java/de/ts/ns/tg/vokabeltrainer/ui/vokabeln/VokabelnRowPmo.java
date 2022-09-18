package de.ts.ns.tg.vokabeltrainer.ui.vokabeln;

import org.linkki.core.pmo.ModelObject;
import org.linkki.core.pmo.PresentationModelObject;
import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.element.annotation.UILabel;

import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;
import de.ts.ns.tg.vokabeltrainer.vokabeln.Gruppe;
import de.ts.ns.tg.vokabeltrainer.vokabeln.Vokabel;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

public class VokabelnRowPmo implements PresentationModelObject {

	private Vokabel vokabel;
	private JpaVokabelRepsoitory repo;
	private GruppenProvider gruppeProvider;

	public VokabelnRowPmo(JpaVokabelRepsoitory repo, Vokabel abfrage, GruppenProvider gruppeProvider) {
		this.repo = repo;
		this.vokabel = abfrage;
		this.gruppeProvider = gruppeProvider;
	}

	@ModelObject
	public Vokabel getVokabel() {
		return vokabel;
	}

	@UILabel(position = 10, label = "Ausgangswert", modelAttribute = Vokabel.PROPERTY_AUSGANGSWERT)
	public void ausgangswert() {
		// binding
	}

	@UILabel(position = 20, label = "Zielwert", modelAttribute = Vokabel.PROPERTY_ZIELWERT)
	public void zielwert() {
		// binding
	}

	@UILabel(position = 30, label = "Abgeschlossene Abfragen", modelAttribute = Vokabel.PROPERTY_ABGESCHLOSSENEABFRAGEN)
	public void abgeschlossen() {
		// binding
	}

	@UILabel(position = 40, label = "Offene Abfragen", modelAttribute = Vokabel.PROPERTY_OFFENEABFRAGEN)
	public void offen() {
		// binding
	}

	@UIButton(position = 50, label = "Löschen", caption = "Löschen")
	public void loeschen() {
		Gruppe gruppe = gruppeProvider.getGruppe();
		gruppe.removeVokabel(vokabel);
		gruppeProvider.setGruppe(repo.save(gruppe));
	}

}
