package de.ts.ns.tg.vokabeltrainer.ui;

import java.util.Optional;

import de.ts.ns.tg.vokabeltrainer.vokabeln.Gruppe;

public class GruppenProvider {

	private Gruppe gruppe;

	public GruppenProvider(Optional<Gruppe> foundGruppe) {
		if (foundGruppe.isPresent())
			gruppe = foundGruppe.get();
	}

	public Gruppe getGruppe() {
		return gruppe;
	}

	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}

}
