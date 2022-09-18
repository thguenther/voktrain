package de.ts.ns.tg.vokabeltrainer.statistik;

import org.faktorips.runtime.IRuntimeRepository;
import java.time.LocalDateTime;
import org.faktorips.runtime.annotation.IpsGenerated;

/**
 * Diese Klasse stellt Methoden bereit, mit denen eine Instanz von Statistik
 * erstellt und bearbeitet werden kann.
 *
 * @generated
 */
public class StatistikBuilder {
	/**
	 * @generated
	 */
	private final Statistik statistik;

	/**
	 * @generated
	 */
	private IRuntimeRepository runtimeRepository;

	/**
	 * Erzeugt eine neue Instanz von StatistikBuilder mit einem Runtime Repository.
	 * Dieser Konstruktor ist nur für den internen Gebrauch!
	 *
	 * @generated
	 */
	@IpsGenerated
	protected StatistikBuilder(Statistik policy, IRuntimeRepository runtimeRepository) {
		this.statistik = policy;
		this.runtimeRepository = runtimeRepository;
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	public StatistikBuilder setRepository(IRuntimeRepository runtimeRepository) {
		this.runtimeRepository = runtimeRepository;
		return this;
	}

	/**
	 * Setzt den Wert des Attributs zeitstempel.
	 *
	 * @generated
	 */
	@IpsGenerated
	public StatistikBuilder zeitstempel(LocalDateTime newZeitstempel) {
		statistik.setZeitstempel(newZeitstempel);
		return this;
	}

	/**
	 * Setzt den Wert des Attributs uebereinstimmung.
	 *
	 * @generated
	 */
	@IpsGenerated
	public StatistikBuilder uebereinstimmung(Integer newUebereinstimmung) {
		statistik.setUebereinstimmung(newUebereinstimmung);
		return this;
	}

	/**
	 * Setzt den Wert des Attributs abfrageId.
	 * <p>
	 * ID der Abfrage, durch welche diese Statistik erzeugt wurde.
	 *
	 * @generated
	 */
	@IpsGenerated
	public StatistikBuilder abfrageId(Long newAbfrageId) {
		statistik.setAbfrageId(newAbfrageId);
		return this;
	}

	/**
	 * Gibt die Instanz von Statistik zurück, die von diesem Builder gebaut wird.
	 *
	 * @generated
	 */
	@IpsGenerated
	public Statistik getResult() {
		return statistik;
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
		return Statistik.class;
	}

	/**
	 * Erzeugt einen neuen StatistikBuilder mit einer Instanz von Statistik.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static StatistikBuilder from(Statistik policy) {
		return new StatistikBuilder(policy, null);
	}

	/**
	 * Erzeugt einen neuen StatistikBuilder mit einer Instanz von Statistik und
	 * einem Runtime Repository.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static StatistikBuilder from(Statistik policy, IRuntimeRepository runtimeRepository) {
		return new StatistikBuilder(policy, runtimeRepository);
	}

}
