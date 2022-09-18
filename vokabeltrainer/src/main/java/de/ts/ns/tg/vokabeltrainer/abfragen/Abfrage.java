package de.ts.ns.tg.vokabeltrainer.abfragen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.faktorips.runtime.ICopySupport;
import org.faktorips.runtime.IDeltaComputationOptions;
import org.faktorips.runtime.IDeltaSupport;
import org.faktorips.runtime.IDependantObject;
import org.faktorips.runtime.IModelObject;
import org.faktorips.runtime.IModelObjectDelta;
import org.faktorips.runtime.IModelObjectVisitor;
import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.runtime.IValidationContext;
import org.faktorips.runtime.IVisitorSupport;
import org.faktorips.runtime.Message;
import org.faktorips.runtime.MessageList;
import org.faktorips.runtime.ObjectProperty;
import org.faktorips.runtime.Severity;
import org.faktorips.runtime.annotation.IpsGenerated;
import org.faktorips.runtime.internal.AbstractModelObject;
import org.faktorips.runtime.internal.IpsStringUtils;
import org.faktorips.runtime.internal.ModelObjectDelta;
import org.faktorips.runtime.model.annotation.IpsAllowedValues;
import org.faktorips.runtime.model.annotation.IpsAssociation;
import org.faktorips.runtime.model.annotation.IpsAssociationAdder;
import org.faktorips.runtime.model.annotation.IpsAssociations;
import org.faktorips.runtime.model.annotation.IpsAttribute;
import org.faktorips.runtime.model.annotation.IpsAttributeSetter;
import org.faktorips.runtime.model.annotation.IpsAttributes;
import org.faktorips.runtime.model.annotation.IpsDocumented;
import org.faktorips.runtime.model.annotation.IpsInverseAssociation;
import org.faktorips.runtime.model.annotation.IpsPolicyCmptType;
import org.faktorips.runtime.model.annotation.IpsValidationRule;
import org.faktorips.runtime.model.annotation.IpsValidationRules;
import org.faktorips.runtime.model.type.AssociationKind;
import org.faktorips.runtime.model.type.AttributeKind;
import org.faktorips.runtime.model.type.ValueSetKind;
import org.faktorips.runtime.util.MessagesHelper;
import org.faktorips.valueset.StringLengthValueSet;
import org.faktorips.valueset.UnrestrictedValueSet;
import org.faktorips.valueset.ValueSet;
import org.w3c.dom.Element;

import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;
import de.ts.ns.tg.vokabeltrainer.vokabeln.Gruppe;
import de.ts.ns.tg.vokabeltrainer.vokabeln.Vokabel;

/**
 * Implementierung von Abfrage.
 * 
 * @since 0.0.1
 *
 * @generated
 */
@Entity
@Table(name = "ABFRAGE")
@IpsPolicyCmptType(name = "abfragen.Abfrage")
@IpsAttributes({ "name", "art" })
@IpsAssociations({ "Gruppe" })
@IpsValidationRules({ "pruefeArt" })
@IpsDocumented(bundleName = "de.ts.ns.tg.vokabeltrainer.modell-label-and-descriptions", defaultLocale = "de")
public class Abfrage extends AbstractModelObject
		implements IDeltaSupport, ICopySupport, IVisitorSupport, IDependantObject {

	/**
	 * Diese Konstante enthaelt den Namen der Beziehung gruppe.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String ASSOCIATION_GRUPPE = "gruppe";
	/**
	 * Konstante fuer den Fehlercode der Regel pruefeArt.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String MSG_CODE_PRUEFE_ART = "ART_UNGUELTIG";
	/**
	 * Diese Konstante enthaelt den Namen der Eigenschaft art.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String PROPERTY_ART = "art";

	/**
	 * Gibt die maximal erlaubten Werte fuer die Eigenschaft art zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final ValueSet<AbfrageTyp> MAX_ALLOWED_VALUES_FOR_ART = new UnrestrictedValueSet<>(false);
	/**
	 * Diese Konstante enthaelt den Namen der Eigenschaft name.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String PROPERTY_NAME = "name";
	/**
	 * Gibt die maximal erlaubten Werte fuer die Eigenschaft name zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final ValueSet<String> MAX_ALLOWED_STRING_LENGTH_FOR_NAME = new StringLengthValueSet(255, false);
	/**
	 * Member variable for id. The id is used as primary key.
	 */
	@Id
	@GeneratedValue(generator = "AbfrageSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "AbfrageSeq", sequenceName = "ABFRAGE_SEQ", allocationSize = 50)
	private Long id;

	/**
	 * Membervariable fuer art.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@Column(name = "ART", nullable = true, unique = false)
	private AbfrageTyp art = null;

	/**
	 * Membervariable fuer name.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@Column(name = "NAME", nullable = true, unique = false, length = 255)
	private String name = null;
	/**
	 * Membervariable fuer das Parent-Objekt: Gruppe.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Gruppe.class)
	@JoinColumn(name = "GRUPPE")
	private Gruppe gruppe;

	/**
	 * Erzeugt eine neue Instanz von Abfrage.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public Abfrage() {
		super();
	}

	/**
	 * Gibt den Wert des Attributs art zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttribute(name = "art", kind = AttributeKind.CHANGEABLE, valueSetKind = ValueSetKind.AllValues)
	@IpsGenerated
	public AbfrageTyp getArt() {
		return art;
	}

	/**
	 * Setzt den Wert des Attributs art.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttributeSetter("art")
	@IpsGenerated
	public void setArt(AbfrageTyp newValue) {
		this.art = newValue;
	}

	/**
	 * Gibt den erlaubten Wertebereich fuer das Attribut name zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAllowedValues("name")
	@IpsGenerated
	public ValueSet<String> getSetOfAllowedValuesForName(IValidationContext context) {
		return MAX_ALLOWED_STRING_LENGTH_FOR_NAME;
	}

	/**
	 * Gibt den Wert des Attributs name zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttribute(name = "name", kind = AttributeKind.CHANGEABLE, valueSetKind = ValueSetKind.AllValues)
	@IpsGenerated
	public String getName() {
		return name;
	}

	/**
	 * Setzt den Wert des Attributs name.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttributeSetter("name")
	@IpsGenerated
	public void setName(String newValue) {
		this.name = newValue;
	}

	/**
	 * Gibt den erlaubten Wertebereich fuer das Attribut art zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAllowedValues("art")
	@IpsGenerated
	public ValueSet<AbfrageTyp> getSetOfAllowedValuesForArt(IValidationContext context) {
		return MAX_ALLOWED_VALUES_FOR_ART;
	}

	/**
	 * Gibt das referenzierte Gruppe-Objekt zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociation(name = "Gruppe", pluralName = "", kind = AssociationKind.CompositionToMaster, targetClass = Gruppe.class, min = 0, max = 1)
	@IpsInverseAssociation("Abfrage")
	@IpsGenerated
	public Gruppe getGruppe() {
		return gruppe;
	}

	/**
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociationAdder(association = "Gruppe")
	@IpsGenerated
	public void setGruppeInternal(Gruppe newParent) {
		if (getGruppe() == newParent) {
			return;
		}
		IModelObject parent = getParentModelObject();
		if (newParent != null && parent != null) {
			throw new IllegalStateException(String.format(
					"Abfrage (\"%s\") kann nicht dem Parent-Objekt der Klasse Gruppe (\"%s\") hinzugefügt werden, da das Objekt bereits dem Parent-Objekt (\"%s\") zugeordnet ist.",
					toString(), newParent.toString(), parent.toString()));
		}
		this.gruppe = newParent;
	}

	/**
	 * Initialisiert Attribute mit ihren Vorgabewerten.
	 *
	 * @restrainedmodifiable
	 */
	@IpsGenerated
	public void initialize() {
		// begin-user-code
		// end-user-code
	}

	/**
	 * {@inheritDoc}
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public IModelObject getParentModelObject() {
		if (gruppe != null) {
			return gruppe;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	protected void initPropertiesFromXml(Map<String, String> propMap, IRuntimeRepository productRepository) {
		super.initPropertiesFromXml(propMap, productRepository);
		doInitName(propMap);
		doInitArt(propMap);
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	private void doInitArt(Map<String, String> propMap) {
		if (propMap.containsKey(PROPERTY_ART)) {
			this.art = IpsStringUtils.isEmpty(propMap.get(PROPERTY_ART)) ? null
					: AbfrageTyp.getValueById(Integer.valueOf(propMap.get(PROPERTY_ART)));
		}
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	private void doInitName(Map<String, String> propMap) {
		if (propMap.containsKey(PROPERTY_NAME)) {
			this.name = propMap.get(PROPERTY_NAME);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	protected AbstractModelObject createChildFromXml(Element childEl) {
		AbstractModelObject newChild = super.createChildFromXml(childEl);
		if (newChild != null) {
			return newChild;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public IModelObjectDelta computeDelta(IModelObject otherObject, IDeltaComputationOptions options) {
		ModelObjectDelta delta = ModelObjectDelta.newDelta(this, otherObject, options);
		if (!Abfrage.class.isAssignableFrom(otherObject.getClass())) {
			return delta;
		}
		Abfrage otherAbfrage = (Abfrage) otherObject;
		delta.checkPropertyChange(Abfrage.PROPERTY_NAME, name, otherAbfrage.name, options);
		delta.checkPropertyChange(Abfrage.PROPERTY_ART, art, otherAbfrage.art, options);
		return delta;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public Abfrage newCopy() {
		Map<IModelObject, IModelObject> copyMap = new HashMap<>();
		Abfrage newCopy = newCopyInternal(copyMap);
		copyAssociationsInternal(newCopy, copyMap);
		return newCopy;
	}

	/**
	 * Interne Kopiermethode mit einer {@link Map} der bisher kopierten Instanzen
	 * 
	 * @param copyMap die Map enthaelt die bisher kopierten Instanzen.
	 *
	 * @generated
	 */
	@IpsGenerated
	public Abfrage newCopyInternal(Map<IModelObject, IModelObject> copyMap) {
		Abfrage newCopy = (Abfrage) copyMap.get(this);
		if (newCopy == null) {
			newCopy = new Abfrage();
			copyMap.put(this, newCopy);
			copyProperties(newCopy, copyMap);
		}
		return newCopy;
	}

	/**
	 * Diese Methode setzt alle Werte in der Kopie (copy) auf die Werte aus diesem
	 * Objekt. Kopierte Assoziationen werden in {@link #newCopyInternal(Map)} zur
	 * copyMap hinzugefügt.
	 * 
	 * @param copy    Das kopierte Object
	 * @param copyMap Eine Map mit kopierten assoziierten Objekten
	 *
	 * @generated
	 */
	@IpsGenerated
	protected void copyProperties(IModelObject copy, Map<IModelObject, IModelObject> copyMap) {
		Abfrage concreteCopy = (Abfrage) copy;
		concreteCopy.name = name;
		concreteCopy.art = art;
	}

	/**
	 * Interne Methode zum Setzen kopierter Assoziationen. Wenn das Ziel der
	 * Assoziation kopiert wurde, wird die Assoziation auf die neue Kopie gesetzt,
	 * ansonsten bleibt die Assoziation unveraendert. Die Methode ruft ausserdem
	 * {@link #copyAssociationsInternal(IModelObject, Map)} in allen durch
	 * Komposition verknuepften Instanzen auf.
	 * 
	 * @param abstractCopy die Kopie dieser PolicyCmpt
	 * @param copyMap      die Map mit den kopierten Instanzen
	 *
	 * @generated
	 */
	@IpsGenerated
	public void copyAssociationsInternal(IModelObject abstractCopy, Map<IModelObject, IModelObject> copyMap) {
		// Keine Implementierung notwendig.
	}

	/**
	 * {@inheritDoc}
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public boolean accept(IModelObjectVisitor visitor) {
		if (!visitor.visit(this)) {
			return false;
		}
		return true;
	}

	/**
	 * Validierung von Objekten der Klasse Abfrage. Gibt <code>true</code> zurueck,
	 * wenn dieses Objekt mit der Validierung fortfahren soll, <code>false</code>
	 * sonst.
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public boolean validateSelf(MessageList ml, IValidationContext context) {
		if (!super.validateSelf(ml, context)) {
			return STOP_VALIDATION;
		}
		if (!pruefeArt(ml, context)) {
			return STOP_VALIDATION;
		}
		return CONTINUE_VALIDATION;
	}

	/**
	 * Validierung von abhaengigen Objekten fuer Instanzen der Klasse Abfrage.
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public void validateDependants(MessageList ml, IValidationContext context) {
		super.validateDependants(ml, context);
	}

	/**
	 * Fuehrt die Regel pruefeArt aus und fuegt eine Message an die uebergebene
	 * MessageList an, wenn die Regel einen nicht validen Zustand feststellt.
	 * 
	 * @param ml      Liste, der Fehler bei der Validierung in Form von Messages
	 *                hinzugefügt werden
	 * @param context der Kontext der Validierung
	 * @return <code>true</code>, wenn die Validierung nach Ausführung dieser Regel
	 *         fortgesetzt werden soll, <code>false</code> wenn sie abgebrochen
	 *         werden soll.
	 * @since 0.0.1
	 *
	 * @restrainedmodifiable
	 */
	@IpsValidationRule(name = "pruefeArt", msgCode = MSG_CODE_PRUEFE_ART, severity = Severity.ERROR)
	@IpsGenerated
	protected boolean pruefeArt(MessageList ml, IValidationContext context) {
		if (!getSetOfAllowedValuesForArt(context).contains(getArt())) {

			// begin-user-code
			ml.add(createMessageForRulePruefeArt(context));
			// end-user-code
		}
		return CONTINUE_VALIDATION;
	}

	/**
	 * Erzeugt die Message, die in das Ergebnis der Validierung aufgenommen wird,
	 * wenn die Regel pruefeArt einen nicht validen Zustand melden soll.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	protected Message createMessageForRulePruefeArt(IValidationContext context) {
		List<ObjectProperty> invalidObjectProperties = Arrays.asList(new ObjectProperty(this, PROPERTY_ART));
		MessagesHelper messageHelper = new MessagesHelper("de.ts.ns.tg.vokabeltrainer.internal.validation-messages",
				getClass().getClassLoader(), Locale.GERMAN);
		String msgText = messageHelper.getMessage("abfragen.Abfrage-pruefeArt", context.getLocale());

		Message.Builder builder = new Message.Builder(msgText, Severity.ERROR).code(MSG_CODE_PRUEFE_ART)
				.invalidObjects(invalidObjectProperties);
		return builder.create();
	}

	/**
	 * Erzeugt einen neuen AbfrageBuilder um diesen Vertrag zu bearbeiten.
	 *
	 * @generated
	 */
	@IpsGenerated
	public AbfrageBuilder modify() {
		return AbfrageBuilder.from(this, null);
	}

	/**
	 * Das Runtime Repository wird benutzt um die konfigurierten Ziele von
	 * Assoziationen mit Hilfe eines bestehenden Produkts zu erstellen.
	 *
	 * @generated
	 */
	@IpsGenerated
	public AbfrageBuilder modify(IRuntimeRepository runtimeRepository) {
		return AbfrageBuilder.from(this, runtimeRepository);
	}

	/**
	 * Erzeugt eine neue Instanz von AbfrageBuilder von einer neuen Vertragsinstanz.
	 * Runtime Repository wird null gesetzt.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static AbfrageBuilder builder() {
		return AbfrageBuilder.from(new Abfrage(), null);
	}

	/**
	 * Erzeugt eine neue Instanz von AbfrageBuilder von einer neuen Vertragsinstanz.
	 * Runtime Repository wird null gesetzt. Das Runtime Repository wird gebraucht,
	 * wenn Ziele der Assoziationen durch Produkte konfiguriert werden. Diese müssen
	 * entsprechend in diesem Runtime Repository liegen.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static AbfrageBuilder builder(IRuntimeRepository runtimeRepository) {
		return AbfrageBuilder.from(new Abfrage(), runtimeRepository);
	}

	public long getId() {
		return id;
	}

	public List<Vokabel> getAbzufragendeVokabeln(GruppenProvider gruppenProvider) {
		return gruppenProvider.getGruppe().getVokabeln().stream()
				.filter(v -> v.getErfolgreicheAbfragen(getId()) < getArt().getBenoetigteKorrekteEingaben())
				.collect(Collectors.toList());
	}

	public boolean istErledigt(GruppenProvider gruppenProvider) {
		return getAbzufragendeVokabeln(gruppenProvider).isEmpty();
	}

}
