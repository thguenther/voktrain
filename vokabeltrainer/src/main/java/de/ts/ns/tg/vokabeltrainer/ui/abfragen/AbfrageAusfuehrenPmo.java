package de.ts.ns.tg.vokabeltrainer.ui.abfragen;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.linkki.core.pmo.PresentationModelObject;
import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.element.annotation.UILabel;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;
import org.linkki.util.handler.Handler;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;

import de.ts.ns.tg.vokabeltrainer.abfragen.Abfrage;
import de.ts.ns.tg.vokabeltrainer.statistik.Statistik;
import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;
import de.ts.ns.tg.vokabeltrainer.vokabeln.Vokabel;
import de.ts.ns.tg.vokabeltrainer.vokabeln.persistence.JpaVokabelRepsoitory;

@UISection(caption = "Abfrage")
public class AbfrageAusfuehrenPmo implements PresentationModelObject {

	private GruppenProvider gruppeProvider;
	private Random zufall = new Random();
	private Vokabel vokabel;
	private String zielwert;
	private JpaVokabelRepsoitory repo;
	private Abfrage abfrage;
	private Handler endeHandler;

	public AbfrageAusfuehrenPmo(JpaVokabelRepsoitory repo, GruppenProvider gruppeProvider, Abfrage abfrage,
			Handler endeHandler) {
		this.repo = repo;
		this.gruppeProvider = gruppeProvider;
		this.abfrage = abfrage;
		this.endeHandler = endeHandler;
		init();
	}

	public void init() {
		List<Vokabel> vokabelnZurAbfrage = abfrage.getAbzufragendeVokabeln(gruppeProvider);

		if (vokabelnZurAbfrage.size() == 0) {
			Notification.show("Sensationell, alle Vokabeln erledigt");
			endeHandler.apply();
			return;
		}

		vokabel = vokabelnZurAbfrage.get(zufall.nextInt(vokabelnZurAbfrage.size()));
		zielwert = "";
	}

	@UILabel(position = 10)
	public String getAusgangswert() {
		return vokabel.getAusgangswert();
	}

	@UITextField(position = 20, label = "Deine Eingabe")
	public String getZielwert() {
		return zielwert;
	}

	public void setZielwert(String zielwert) {
		this.zielwert = zielwert;
	}

	public void einfuegen(String text) {
		setZielwert(getZielwert() + text);
	}

	@UIButton(position = 30, caption = "Prüfen")
	public void pruefen() {
		Statistik statistik = new Statistik();
		statistik.setZeitstempel(LocalDateTime.now());
		statistik.setAbfrageId(abfrage.getId());
		if (vokabel.getZielwert().equals(zielwert)) {
			Notification.show("Super!");
			statistik.setUebereinstimmung(100);
		} else {
			Notification.show("Durchhalten, das wird schon! Richtig wäre " + vokabel.getZielwert(), 5000,
					Position.TOP_CENTER);
			statistik.setUebereinstimmung(0);
		}
		vokabel.addStatistik(statistik);

		gruppeProvider.setGruppe(repo.save(gruppeProvider.getGruppe()));
		init();
	}

}
