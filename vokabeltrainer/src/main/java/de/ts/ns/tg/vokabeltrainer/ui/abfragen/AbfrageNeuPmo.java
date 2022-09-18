package de.ts.ns.tg.vokabeltrainer.ui.abfragen;

import org.faktorips.runtime.ValidationContext;
import org.linkki.core.defaults.ui.aspects.types.AvailableValuesType;
import org.linkki.core.defaults.ui.aspects.types.EnabledType;
import org.linkki.core.pmo.ModelObject;
import org.linkki.core.pmo.PresentationModelObject;
import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.element.annotation.UIComboBox;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;

import de.ts.ns.tg.vokabeltrainer.abfragen.Abfrage;
import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

@UISection(caption = "Neue Abfrage")
public class AbfrageNeuPmo implements PresentationModelObject {

	private JpaVokabelRepsoitory repo;

	private Abfrage neueAbfrage;

	private GruppenProvider gruppeProvider;

	public AbfrageNeuPmo(JpaVokabelRepsoitory repo, GruppenProvider gruppeProvider) {
		this.repo = repo;
		this.gruppeProvider = gruppeProvider;
		neueAbfrage = new Abfrage();
	}

	@ModelObject
	public Abfrage getNeueAbfrage() {
		return neueAbfrage;
	}

	@UITextField(label = "Name", position = 10, modelAttribute = Abfrage.PROPERTY_NAME)
	public void name() {
		// binding
	}

	@UIComboBox(label = "Typ", position = 20, modelAttribute = Abfrage.PROPERTY_ART, content = AvailableValuesType.ENUM_VALUES_EXCL_NULL)
	public void typ() {
		// binding
	}

	@UIButton(caption = "Hinzufügen", position = 30, enabled = EnabledType.DYNAMIC)
	public void hinzufuegen() {
		gruppeProvider.getGruppe().addAbfrage(neueAbfrage);
		gruppeProvider.setGruppe(repo.save(gruppeProvider.getGruppe()));
		neueAbfrage = new Abfrage();
	}

	public boolean isHinzufuegenEnabled() {
		return !neueAbfrage.validate(new ValidationContext()).containsErrorMsg();
	}

}
