package de.ts.ns.tg.vokabeltrainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

@Theme("linkki")
@SpringBootApplication
public class VokabeltrainerApplication implements AppShellConfigurator {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		SpringApplication.run(VokabeltrainerApplication.class, args);
	}

}
