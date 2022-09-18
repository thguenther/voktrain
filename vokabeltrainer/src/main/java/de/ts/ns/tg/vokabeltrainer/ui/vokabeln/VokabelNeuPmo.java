package de.ts.ns.tg.vokabeltrainer.ui.vokabeln;

import org.faktorips.runtime.ValidationContext;
import org.linkki.core.defaults.ui.aspects.types.EnabledType;
import org.linkki.core.pmo.ModelObject;
import org.linkki.core.pmo.PresentationModelObject;
import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;

import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;
import de.ts.ns.tg.vokabeltrainer.vokabeln.Vokabel;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

@UISection(caption = "Neue Vokabel")
public class VokabelNeuPmo implements PresentationModelObject {

	private JpaVokabelRepsoitory repo;

	private Vokabel neueVokabel;

	private GruppenProvider gruppeProvider;

	public VokabelNeuPmo(JpaVokabelRepsoitory repo, GruppenProvider gruppeProvider) {
		this.repo = repo;
		this.gruppeProvider = gruppeProvider;
		neueVokabel = new Vokabel();
	}

	@ModelObject
	public Vokabel getNeueAbfrage() {
		return neueVokabel;
	}

	@UITextField(label = "Ausgangswert", position = 10, modelAttribute = Vokabel.PROPERTY_AUSGANGSWERT)
	public void ausgangswert() {
		// binding
	}

	public void einfuegen(String text) {
		getNeueAbfrage().setZielwert(getZielwert() == null ? text : getZielwert() + text);
	}

	private String getZielwert() {
		return getNeueAbfrage().getZielwert();
	}

	@UITextField(label = "Zielwert", position = 20, modelAttribute = Vokabel.PROPERTY_ZIELWERT)
	public void zielwert() {
		// binding
	}

	@UIButton(caption = "Hinzufügen", position = 30, enabled = EnabledType.DYNAMIC)
	public void hinzufuegen() {
		gruppeProvider.getGruppe().addVokabel(neueVokabel);
		gruppeProvider.setGruppe(repo.save(gruppeProvider.getGruppe()));
		neueVokabel = new Vokabel();
	}

	public boolean isHinzufuegenEnabled() {
		return !neueVokabel.validate(new ValidationContext()).containsErrorMsg();
	}

}
