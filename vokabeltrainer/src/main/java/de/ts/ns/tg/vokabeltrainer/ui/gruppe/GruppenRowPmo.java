package de.ts.ns.tg.vokabeltrainer.ui.gruppe;

import org.linkki.core.pmo.ModelObject;
import org.linkki.core.pmo.PresentationModelObject;
import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.element.annotation.UILabel;
import org.linkki.core.ui.element.annotation.UILink;

import de.ts.ns.tg.vokabeltrainer.vokabeln.Gruppe;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

public class GruppenRowPmo implements PresentationModelObject {

	private Gruppe gruppe;
	private JpaVokabelRepsoitory repo;

	public GruppenRowPmo(JpaVokabelRepsoitory repo, Gruppe gruppe) {
		this.repo = repo;
		this.gruppe = gruppe;
	}

	@ModelObject
	public Gruppe getGruppe() {
		return gruppe;
	}

	@UILabel(position = 10, label = "Name", modelAttribute = Gruppe.PROPERTY_NAME)
	public void name() {
		// binding
	}

	@UILabel(position = 20, label = "Status", modelAttribute = Gruppe.PROPERTY_STATUSBESCHREIBUNG)
	public void status() {
		// binding
	}

	@UILink(position = 30, label = "Vokabeln bearbeiten", caption = "Vokabeln bearbeiten")
	public String getStartLink() {
		return "Vokabeln/" + gruppe.getId();
	}

	@UILink(position = 40, label = "Abfragen", caption = "Abfragen")
	public String getAbfragenLink() {
		return "Abfragen/" + gruppe.getId();
	}

	@UIButton(position = 50, label = "Löschen", caption = "Löschen")
	public void loeschen() {
		repo.delete(gruppe);
	}

}
