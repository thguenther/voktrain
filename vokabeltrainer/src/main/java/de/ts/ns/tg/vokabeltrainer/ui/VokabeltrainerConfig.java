package de.ts.ns.tg.vokabeltrainer.ui;

import org.linkki.framework.ui.application.ApplicationConfig;
import org.linkki.framework.ui.application.menu.ApplicationMenuItemDefinition;
import org.linkki.util.Sequence;

import de.ts.ns.tg.vokabeltrainer.view.VokabeltrainerView;

public class VokabeltrainerConfig implements ApplicationConfig {

	@Override
	public VokabeltrainerInfo getApplicationInfo() {
		return new VokabeltrainerInfo();
	}

	@Override
	public Sequence<ApplicationMenuItemDefinition> getMenuItemDefinitions() {
		return Sequence.of(new ApplicationMenuItemDefinition("Start", "home", VokabeltrainerView.class));
	}

}