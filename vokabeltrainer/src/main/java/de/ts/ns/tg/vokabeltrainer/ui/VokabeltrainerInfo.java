package de.ts.ns.tg.vokabeltrainer.ui;

import java.time.Year;

import org.linkki.framework.ui.application.ApplicationInfo;

public class VokabeltrainerInfo implements ApplicationInfo {

	public static final String APPLICATION_NAME = "Vokabeltrainer";

	@Override
	public String getApplicationName() {
		return APPLICATION_NAME;
	}

	@Override
	public String getApplicationVersion() {
		return "1.0";
	}

	@Override
	public String getApplicationDescription() {
		return "Vokabeltrainer";
	}

	@Override
	public String getCopyright() {
		return "© Thorsten Günther " + Year.now();
	}
}