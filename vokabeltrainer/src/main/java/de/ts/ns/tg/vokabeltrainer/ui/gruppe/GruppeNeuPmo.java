package de.ts.ns.tg.vokabeltrainer.ui.gruppe;

import org.faktorips.runtime.ValidationContext;
import org.linkki.core.defaults.ui.aspects.types.EnabledType;
import org.linkki.core.pmo.ModelObject;
import org.linkki.core.pmo.PresentationModelObject;
import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;

import de.ts.ns.tg.vokabeltrainer.vokabeln.Gruppe;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

@UISection(caption = "Neue Vokabel-Gruppierung")
public class GruppeNeuPmo implements PresentationModelObject {

	private JpaVokabelRepsoitory repo;

	private Gruppe neueGruppe;

	public GruppeNeuPmo(JpaVokabelRepsoitory repo) {
		this.repo = repo;
		neueGruppe = new Gruppe();
	}

	@ModelObject
	public Gruppe getNeueGruppe() {
		return neueGruppe;
	}

	@UITextField(label = "Name", position = 10, modelAttribute = Gruppe.PROPERTY_NAME)
	public void name() {
		// binding
	}

	@UIButton(caption = "Hinzufügen", position = 20, enabled = EnabledType.DYNAMIC)
	public void hinzufuegen() {
		repo.save(neueGruppe);
		neueGruppe = new Gruppe();
	}

	public boolean isHinzufuegenEnabled() {
		return !neueGruppe.validate(new ValidationContext()).containsErrorMsg();
	}

}
