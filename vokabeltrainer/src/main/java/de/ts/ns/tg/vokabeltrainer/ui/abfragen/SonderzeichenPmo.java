package de.ts.ns.tg.vokabeltrainer.ui.abfragen;

import java.util.function.Consumer;

import org.linkki.core.pmo.PresentationModelObject;
import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.layout.annotation.UIFormSection;

@UIFormSection(caption = "Sonderzeichen", columns = 4)
public class SonderzeichenPmo implements PresentationModelObject {

	private Consumer<String> auswahlHandler;

	public SonderzeichenPmo(Consumer<String> auswahlHandler) {
		this.auswahlHandler = auswahlHandler;
	}

	@UIButton(position = 10, caption = "ç")
	public void petit_c_Cedille() {
		auswahlHandler.accept("ç");
	}

	@UIButton(position = 20, caption = "Ç")
	public void grand_c_Cedille() {
		auswahlHandler.accept("Ç");
	}

	@UIButton(position = 30, caption = "œ")
	public void petit_e_dans_lo() {
		auswahlHandler.accept("œ");
	}

	@UIButton(position = 40, caption = "Œ")
	public void grand_e_dans_lo() {
		auswahlHandler.accept("Œ");
	}

	@UIButton(position = 50, caption = "æ")
	public void petit_a_dans_la() {
		auswahlHandler.accept("æ");
	}

	@UIButton(position = 60, caption = "Æ")
	public void grand_a_dans_la() {
		auswahlHandler.accept("Æ");
	}

	@UIButton(position = 70, caption = "ë")
	public void petit_e_trema() {
		auswahlHandler.accept("ë");
	}

	@UIButton(position = 80, caption = "Ë")
	public void grand_e_trema() {
		auswahlHandler.accept("Ë");
	}

	@UIButton(position = 90, caption = "ï")
	public void petit_i_trema() {
		auswahlHandler.accept("ï");
	}

	@UIButton(position = 100, caption = "Ï")
	public void grand_i_trema() {
		auswahlHandler.accept("Ï");
	}

	@UIButton(position = 110, caption = "ü")
	public void petit_u_trema() {
		auswahlHandler.accept("ü");
	}

	@UIButton(position = 120, caption = "Ü")
	public void grand_u_trema() {
		auswahlHandler.accept("Ü");
	}

	@UIButton(position = 130, caption = "ÿ")
	public void petit_i_grec_trema() {
		auswahlHandler.accept("ÿ");
	}

	@UIButton(position = 140, caption = "Ÿ")
	public void grand_i_grec_trema() {
		auswahlHandler.accept("Ü");
	}

}
