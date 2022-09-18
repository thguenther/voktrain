package de.ts.ns.tg.vokabeltrainer.abfragen;

import org.faktorips.runtime.model.annotation.IpsDocumented;
import org.faktorips.runtime.model.annotation.IpsEnumType;
import java.util.Map;
import java.util.HashMap;
import org.faktorips.runtime.model.annotation.IpsEnumAttribute;
import org.faktorips.runtime.annotation.IpsGenerated;

/**
 * @since 0.0.1
 *
 * @generated
 */
@IpsDocumented(bundleName = "de.ts.ns.tg.vokabeltrainer.modell-label-and-descriptions", defaultLocale = "de")
@IpsEnumType(name = "abfragen.AbfrageTyp", attributeNames = { "id", "name", "benoetigteKorrekteEingaben" })
public enum AbfrageTyp {
	/**
	 * @generated
	 */
	LERNEN(Integer.valueOf(1), "Lernen", Integer.valueOf(3)),
	/**
	 * @generated
	 */
	WIEDERHOLEN(Integer.valueOf(2), "Wiederholen", Integer.valueOf(1))

	;

	/**
	 * Eine Map um schnell zu einer ID auf den passenden Enum-Wert zu bekommen.
	 *
	 * @generated
	 */
	private static final Map<Integer, AbfrageTyp> ID_MAP;
	/**
	 * In diesem static Block wird die ID-Map mit allen Enum-Werten initialisiert.
	 *
	 * @generated
	 */
	static {
		ID_MAP = new HashMap<>();
		for (AbfrageTyp value : values()) {
			ID_MAP.put(value.id, value);
		}
	}

	/**
	 * @since 0.0.1
	 *
	 * @generated
	 */
	private final Integer id;
	/**
	 * @since 0.0.1
	 *
	 * @generated
	 */
	private final String name;

	/**
	 * @since 0.0.1
	 *
	 * @generated
	 */
	private final Integer benoetigteKorrekteEingaben;

	/**
	 * Erzeugt eine neue Instanz von AbfrageTyp.
	 *
	 * @generated
	 */
	@IpsGenerated
	private AbfrageTyp(Integer id, String name, Integer benoetigteKorrekteEingaben) {
		this.id = id;
		this.name = name;
		this.benoetigteKorrekteEingaben = benoetigteKorrekteEingaben;
	}

	/**
	 * Gibt den Aufzählungswert für den angegebenen Parameter <code>id</code>
	 * zurueck. Gibt <code>null</code> zurück, wenn kein entsprechender
	 * Aufzählungswert gefunden wird, oder der Parameter <code>id</code>
	 * <code>null</code> ist.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static final AbfrageTyp getValueById(Integer id) {
		return ID_MAP.get(id);
	}

	/**
	 * Gibt den Aufzählungswert für den angegebenen Parameter <code>name</code>
	 * zurueck. Gibt <code>null</code> zurück, wenn kein entsprechender
	 * Aufzählungswert gefunden wird, oder der Parameter <code>name</code>
	 * <code>null</code> ist.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static final AbfrageTyp getValueByName(String name) {
		for (AbfrageTyp currentValue : values()) {
			if (currentValue.name.equals(name)) {
				return currentValue;
			}
		}
		return null;
	}

	/**
	 * Gibt den Aufzählungswert für den angegebenen Parameter <code>id</code>
	 * zurück. Falls für den gegebenen Parameter kein entsprechender Aufzählungswert
	 * gefunden wird, wird eine {@link IllegalArgumentException} geworfen.
	 *
	 * @throws IllegalArgumentException falls kein passender Aufzählungswert
	 *                                  existiert
	 *
	 * @generated
	 */
	@IpsGenerated
	public static final AbfrageTyp getExistingValueById(Integer id) {
		if (ID_MAP.containsKey(id)) {
			return ID_MAP.get(id);
		} else {
			throw new IllegalArgumentException("No enum value with id " + id);
		}
	}

	/**
	 * Gibt den Aufzählungswert für den angegebenen Parameter <code>name</code>
	 * zurück. Falls für den gegebenen Parameter kein entsprechender Aufzählungswert
	 * gefunden wird, wird eine {@link IllegalArgumentException} geworfen.
	 *
	 * @throws IllegalArgumentException falls kein passender Aufzählungswert
	 *                                  existiert
	 *
	 * @generated
	 */
	@IpsGenerated
	public static final AbfrageTyp getExistingValueByName(String name) {
		for (AbfrageTyp currentValue : values()) {
			if (currentValue.name.equals(name)) {
				return currentValue;
			}
		}
		throw new IllegalArgumentException("No enum value with name " + name);
	}

	/**
	 * Gibt <code>true</code> zurueck, falls der Parameterwert einen Wert dieser
	 * Aufzählung identifiziert.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static final boolean isValueById(Integer id) {
		return getValueById(id) != null;
	}

	/**
	 * Gibt <code>true</code> zurueck, falls der Parameterwert einen Wert dieser
	 * Aufzählung identifiziert.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static final boolean isValueByName(String name) {
		return getValueByName(name) != null;
	}

	/**
	 * Gibt den Wert des Attributs id zurück.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsEnumAttribute(name = "id", identifier = true, unique = true)
	@IpsGenerated
	public Integer getId() {
		return id;
	}

	/**
	 * Gibt den Wert des Attributs name zurück.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsEnumAttribute(name = "name", unique = true, displayName = true)
	@IpsGenerated
	public String getName() {
		return name;
	}

	/**
	 * Gibt den Wert des Attributs benoetigteKorrekteEingaben zurück.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsEnumAttribute(name = "benoetigteKorrekteEingaben")
	@IpsGenerated
	public Integer getBenoetigteKorrekteEingaben() {
		return benoetigteKorrekteEingaben;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public String toString() {
		return "AbfrageTyp: " + id + '(' + name + ')';
	}
}
