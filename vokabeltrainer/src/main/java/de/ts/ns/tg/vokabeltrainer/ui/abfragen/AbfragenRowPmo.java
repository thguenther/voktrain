package de.ts.ns.tg.vokabeltrainer.ui.abfragen;

import org.linkki.core.binding.BindingContext;
import org.linkki.core.defaults.ui.aspects.types.CaptionType;
import org.linkki.core.defaults.ui.aspects.types.EnabledType;
import org.linkki.core.pmo.ModelObject;
import org.linkki.core.pmo.PresentationModelObject;
import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.element.annotation.UILabel;
import org.linkki.framework.ui.dialogs.OkCancelDialog;
import org.linkki.framework.ui.dialogs.PmoBasedDialogFactory;

import de.ts.ns.tg.vokabeltrainer.abfragen.Abfrage;
import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;
import de.ts.ns.tg.vokabeltrainer.vokabeln.Gruppe;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

public class AbfragenRowPmo implements PresentationModelObject {

	private Abfrage abfrage;
	private JpaVokabelRepsoitory repo;
	private GruppenProvider gruppeProvider;
	private OkCancelDialog dialog;
	private BindingContext bindingContext;

	public AbfragenRowPmo(JpaVokabelRepsoitory repo, Abfrage abfrage, GruppenProvider gruppeProvider,
			BindingContext bindingContext) {
		this.repo = repo;
		this.abfrage = abfrage;
		this.gruppeProvider = gruppeProvider;
		this.bindingContext = bindingContext;
	}

	@ModelObject
	public Abfrage getAbfrage() {
		return abfrage;
	}

	@UILabel(position = 10, label = "Name", modelAttribute = Abfrage.PROPERTY_NAME)
	public void name() {
		// binding
	}

	@UILabel(position = 20, label = "Art der Abfrage", modelAttribute = Abfrage.PROPERTY_ART)
	public void art() {
		// binding
	}

	@UIButton(position = 40, label = "Abfrage starten", captionType = CaptionType.DYNAMIC, enabled = EnabledType.DYNAMIC)
	public void start() {
		PmoBasedDialogFactory f = new PmoBasedDialogFactory();
		var abfrageAusfuehrenPmo = new AbfrageAusfuehrenPmo(repo, gruppeProvider, abfrage, () -> this.abfrageBeenden());
		dialog = f.newOkDialog("Vokabelabfrage zu " + abfrage.getName(), abfrageAusfuehrenPmo,
				new SonderzeichenPmo(abfrageAusfuehrenPmo::einfuegen));
		dialog.setOkCaption("Abfrage Abbrechen");
		dialog.open();
	}

	public boolean isStartEnabled() {
		return !abfrage.istErledigt(gruppeProvider);
	}

	public String getStartCaption() {
		if (isStartEnabled()) {
			return "Starten";
		} else {
			return "Alles erledigt :-)";
		}
	}

	public void abfrageBeenden() {
		if (dialog != null) {
			dialog.close();
		}
		bindingContext.updateUi();
	}

	@UIButton(position = 50, label = "Löschen", caption = "Löschen")
	public void loeschen() {
		Gruppe gruppe = gruppeProvider.getGruppe();
		gruppe.removeAbfrage(abfrage);
		gruppeProvider.setGruppe(repo.save(gruppe));
	}

}
