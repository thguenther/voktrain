package de.ts.ns.tg.vokabeltrainer.abfragen;

import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.runtime.annotation.IpsGenerated;

/**
 * Diese Klasse stellt Methoden bereit, mit denen eine Instanz von Abfrage
 * erstellt und bearbeitet werden kann.
 *
 * @generated
 */
public class AbfrageBuilder {
	/**
	 * @generated
	 */
	private final Abfrage abfrage;

	/**
	 * @generated
	 */
	private IRuntimeRepository runtimeRepository;

	/**
	 * Erzeugt eine neue Instanz von AbfrageBuilder mit einem Runtime Repository.
	 * Dieser Konstruktor ist nur für den internen Gebrauch!
	 *
	 * @generated
	 */
	@IpsGenerated
	protected AbfrageBuilder(Abfrage policy, IRuntimeRepository runtimeRepository) {
		this.abfrage = policy;
		this.runtimeRepository = runtimeRepository;
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	public AbfrageBuilder setRepository(IRuntimeRepository runtimeRepository) {
		this.runtimeRepository = runtimeRepository;
		return this;
	}

	/**
	 * Setzt den Wert des Attributs name.
	 *
	 * @generated
	 */
	@IpsGenerated
	public AbfrageBuilder name(String newName) {
		abfrage.setName(newName);
		return this;
	}

	/**
	 * Setzt den Wert des Attributs art.
	 *
	 * @generated
	 */
	@IpsGenerated
	public AbfrageBuilder art(AbfrageTyp newArt) {
		abfrage.setArt(newArt);
		return this;
	}

	/**
	 * Gibt die Instanz von Abfrage zurück, die von diesem Builder gebaut wird.
	 *
	 * @generated
	 */
	@IpsGenerated
	public Abfrage getResult() {
		return abfrage;
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	public IRuntimeRepository getRepository() {
		return runtimeRepository;
	}

	/**
	 * 
	 *
	 * @generated
	 */
	@IpsGenerated
	public static Class<?> getPolicyClass() {
		return Abfrage.class;
	}

	/**
	 * Erzeugt einen neuen AbfrageBuilder mit einer Instanz von Abfrage.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static AbfrageBuilder from(Abfrage policy) {
		return new AbfrageBuilder(policy, null);
	}

	/**
	 * Erzeugt einen neuen AbfrageBuilder mit einer Instanz von Abfrage und einem
	 * Runtime Repository.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static AbfrageBuilder from(Abfrage policy, IRuntimeRepository runtimeRepository) {
		return new AbfrageBuilder(policy, runtimeRepository);
	}

}
