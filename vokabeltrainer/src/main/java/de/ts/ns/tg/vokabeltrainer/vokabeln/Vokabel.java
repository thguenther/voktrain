package de.ts.ns.tg.vokabeltrainer.vokabeln;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
import org.faktorips.runtime.internal.ModelObjectDelta;
import org.faktorips.runtime.model.annotation.IpsAllowedValues;
import org.faktorips.runtime.model.annotation.IpsAssociation;
import org.faktorips.runtime.model.annotation.IpsAssociationAdder;
import org.faktorips.runtime.model.annotation.IpsAssociationRemover;
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
import org.faktorips.valueset.IntegerRange;
import org.faktorips.valueset.StringLengthValueSet;
import org.faktorips.valueset.ValueSet;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.w3c.dom.Element;

import de.ts.ns.tg.vokabeltrainer.statistik.Statistik;

/**
 * Implementierung von Vokabel.
 * 
 * @since 0.0.1
 *
 * @generated
 */
@Entity
@Table(name = "VOKABEL")
@IpsPolicyCmptType(name = "vokabeln.Vokabel")
@IpsAttributes({ "ausgangswert", "zielwert", "abgeschlosseneAbfragen", "offeneAbfragen" })
@IpsAssociations({ "Gruppe", "Statistik" })
@IpsValidationRules({ "pruefeAusgangswert", "pruefeZielwert" })
@IpsDocumented(bundleName = "de.ts.ns.tg.vokabeltrainer.modell-label-and-descriptions", defaultLocale = "de")
public class Vokabel extends AbstractModelObject
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
	 * Die maximale Multiplizitaet der Beziehung mit dem Rollennamen Statistik.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final IntegerRange MAX_MULTIPLICITY_OF_STATISTIK = IntegerRange.valueOf(0, 2147483647);
	/**
	 * Diese Konstante enthaelt den Namen der Beziehung statistiken.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String ASSOCIATION_STATISTIKEN = "statistiken";
	/**
	 * Konstante fuer den Fehlercode der Regel pruefeAusgangswert.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String MSG_CODE_PRUEFE_AUSGANGSWERT = "AUSGANGSWERT_UNGUELTIG";
	/**
	 * Konstante fuer den Fehlercode der Regel pruefeZielwert.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String MSG_CODE_PRUEFE_ZIELWERT = "ZIELWERT_UNGUELTIG";
	/**
	 * Diese Konstante enthaelt den Namen der Eigenschaft ausgangswert.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String PROPERTY_AUSGANGSWERT = "ausgangswert";
	/**
	 * Gibt die maximal erlaubten Werte fuer die Eigenschaft ausgangswert zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final ValueSet<String> MAX_ALLOWED_STRING_LENGTH_FOR_AUSGANGSWERT = new StringLengthValueSet(255,
			false);
	/**
	 * Diese Konstante enthaelt den Namen der Eigenschaft zielwert.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String PROPERTY_ZIELWERT = "zielwert";
	/**
	 * Gibt die maximal erlaubten Werte fuer die Eigenschaft zielwert zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final ValueSet<String> MAX_ALLOWED_STRING_LENGTH_FOR_ZIELWERT = new StringLengthValueSet(255, false);

	/**
	 * Diese Konstante enthaelt den Namen der Eigenschaft abgeschlosseneAbfragen.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String PROPERTY_ABGESCHLOSSENEABFRAGEN = "abgeschlosseneAbfragen";
	/**
	 * Diese Konstante enthaelt den Namen der Eigenschaft offeneAbfragen.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String PROPERTY_OFFENEABFRAGEN = "offeneAbfragen";
	/**
	 * Member variable for id. The id is used as primary key.
	 */
	@Id
	@GeneratedValue(generator = "VokabelSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "VokabelSeq", sequenceName = "VOKABEL_SEQ", allocationSize = 50)
	private Long id;

	/**
	 * Membervariable fuer ausgangswert.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@Column(name = "AUSGANGSWERT", nullable = true, unique = false, length = 255)
	private String ausgangswert = null;
	/**
	 * Membervariable fuer zielwert.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@Column(name = "ZIELWERT", nullable = true, unique = false, length = 255)
	private String zielwert = null;

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
	 * Membervariable fuer die Beziehung Statistik.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 * @customizedAnnotations
	 */
	@OneToMany(mappedBy = "vokabel", cascade = CascadeType.ALL, targetEntity = Statistik.class, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Statistik> statistiken = new ArrayList<>();

	/**
	 * Erzeugt eine neue Instanz von Vokabel.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public Vokabel() {
		super();
	}

	/**
	 * Gibt den erlaubten Wertebereich fuer das Attribut ausgangswert zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAllowedValues("ausgangswert")
	@IpsGenerated
	public ValueSet<String> getSetOfAllowedValuesForAusgangswert(IValidationContext context) {
		return MAX_ALLOWED_STRING_LENGTH_FOR_AUSGANGSWERT;
	}

	/**
	 * Gibt den Wert des Attributs ausgangswert zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttribute(name = "ausgangswert", kind = AttributeKind.CHANGEABLE, valueSetKind = ValueSetKind.AllValues)
	@IpsGenerated
	public String getAusgangswert() {
		return ausgangswert;
	}

	/**
	 * Setzt den Wert des Attributs ausgangswert.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttributeSetter("ausgangswert")
	@IpsGenerated
	public void setAusgangswert(String newValue) {
		this.ausgangswert = newValue;
	}

	/**
	 * Gibt den erlaubten Wertebereich fuer das Attribut zielwert zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAllowedValues("zielwert")
	@IpsGenerated
	public ValueSet<String> getSetOfAllowedValuesForZielwert(IValidationContext context) {
		return MAX_ALLOWED_STRING_LENGTH_FOR_ZIELWERT;
	}

	/**
	 * Gibt den Wert des Attributs zielwert zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttribute(name = "zielwert", kind = AttributeKind.CHANGEABLE, valueSetKind = ValueSetKind.AllValues)
	@IpsGenerated
	public String getZielwert() {
		return zielwert;
	}

	/**
	 * Setzt den Wert des Attributs zielwert.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttributeSetter("zielwert")
	@IpsGenerated
	public void setZielwert(String newValue) {
		this.zielwert = newValue;
	}

	/**
	 * Gibt den Wert des Attributs abgeschlosseneAbfragen zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @restrainedmodifiable
	 */
	@IpsAttribute(name = "abgeschlosseneAbfragen", kind = AttributeKind.DERIVED_ON_THE_FLY, valueSetKind = ValueSetKind.AllValues)
	@IpsGenerated
	public Integer getAbgeschlosseneAbfragen() {
		// begin-user-code
		return (int) statistiken.stream().filter(s -> s.getUebereinstimmung() == 100).count();
		// end-user-code
	}

	/**
	 * Gibt den Wert des Attributs offeneAbfragen zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @restrainedmodifiable
	 */
	@IpsAttribute(name = "offeneAbfragen", kind = AttributeKind.DERIVED_ON_THE_FLY, valueSetKind = ValueSetKind.AllValues)
	@IpsGenerated
	public Integer getOffeneAbfragen() {
		// begin-user-code
		return (int) statistiken.stream().filter(s -> s.getUebereinstimmung() != 100).count();
		// end-user-code
	}

	/**
	 * Gibt das referenzierte Gruppe-Objekt zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociation(name = "Gruppe", pluralName = "", kind = AssociationKind.CompositionToMaster, targetClass = Gruppe.class, min = 0, max = 1)
	@IpsInverseAssociation("Vokabel")
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
					"Vokabel (\"%s\") kann nicht dem Parent-Objekt der Klasse Gruppe (\"%s\") hinzugefügt werden, da das Objekt bereits dem Parent-Objekt (\"%s\") zugeordnet ist.",
					toString(), newParent.toString(), parent.toString()));
		}
		this.gruppe = newParent;
	}

	/**
	 * Gibt die Anzahl der Statistiken zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public int getNumOfStatistiken() {
		return statistiken.size();
	}

	/**
	 * Gibt <code>true</code> zurueck, falls das uebergebene Objekt in der Beziehung
	 * enthalten ist, ansonsten <code>false</code>.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public boolean containsStatistik(Statistik objectToTest) {
		return statistiken.contains(objectToTest);
	}

	/**
	 * Gibt die referenzierten Statistiken zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociation(name = "Statistik", pluralName = "Statistiken", kind = AssociationKind.Composition, targetClass = Statistik.class, min = 0, max = Integer.MAX_VALUE)
	@IpsInverseAssociation("Vokabel")
	@IpsGenerated
	public List<? extends Statistik> getStatistiken() {
		return Collections.unmodifiableList(statistiken);
	}

	/**
	 * Gibt das Objekt aus der Beziehung Statistik an der indizierten Stelle
	 * zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public Statistik getStatistik(int index) {
		return statistiken.get(index);
	}

	/**
	 * Fuegt das uebergebene Objekt zu der Beziehung Statistik hinzu.
	 * 
	 * @throws ClassCastException Wenn die Beziehung eingeschränkt wurde und das
	 *                            uebergebene Objekt nicht vom passenden Typ ist.
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociationAdder(association = "Statistik")
	@IpsGenerated
	public void addStatistik(Statistik objectToAdd) {
		if (objectToAdd == null) {
			throw new NullPointerException("Can't add null to association Statistik of " + this);
		}
		if (statistiken.contains(objectToAdd)) {
			return;
		}
		objectToAdd.setVokabelInternal(this);
		statistiken.add(objectToAdd);
	}

	/**
	 * Erzeugt ein neues Statistik-Objekt und fuegt es zu diesem Objekt in der Rolle
	 * Statistik hinzu.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public Statistik newStatistik() {
		Statistik newStatistik = new Statistik();
		addStatistik(newStatistik);
		newStatistik.initialize();
		return newStatistik;
	}

	/**
	 * Entfernt das uebergebene Objekt aus der Beziehung Statistik.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociationRemover(association = "Statistik")
	@IpsGenerated
	public void removeStatistik(Statistik objectToRemove) {
		if (objectToRemove == null) {
			return;
		}
		if (statistiken.remove(objectToRemove)) {
			objectToRemove.setVokabelInternal(null);
		}
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
		doInitAusgangswert(propMap);
		doInitZielwert(propMap);
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	private void doInitAusgangswert(Map<String, String> propMap) {
		if (propMap.containsKey(PROPERTY_AUSGANGSWERT)) {
			this.ausgangswert = propMap.get(PROPERTY_AUSGANGSWERT);
		}
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	private void doInitZielwert(Map<String, String> propMap) {
		if (propMap.containsKey(PROPERTY_ZIELWERT)) {
			this.zielwert = propMap.get(PROPERTY_ZIELWERT);
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
		if ("Statistik".equals(childEl.getNodeName())) {
			return doInitStatistik(childEl);
		}
		return null;
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	private AbstractModelObject doInitStatistik(Element childEl) {
		String className = childEl.getAttribute("class");
		if (className.length() > 0) {
			try {
				Statistik statistikLocalVar = (Statistik) Class.forName(className).getConstructor().newInstance();
				addStatistik(statistikLocalVar);
				return statistikLocalVar;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return newStatistik();
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
		if (!Vokabel.class.isAssignableFrom(otherObject.getClass())) {
			return delta;
		}
		Vokabel otherVokabel = (Vokabel) otherObject;
		delta.checkPropertyChange(Vokabel.PROPERTY_AUSGANGSWERT, ausgangswert, otherVokabel.ausgangswert, options);
		delta.checkPropertyChange(Vokabel.PROPERTY_ZIELWERT, zielwert, otherVokabel.zielwert, options);
		ModelObjectDelta.createChildDeltas(delta, statistiken, otherVokabel.statistiken, ASSOCIATION_STATISTIKEN,
				options);
		return delta;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public Vokabel newCopy() {
		Map<IModelObject, IModelObject> copyMap = new HashMap<>();
		Vokabel newCopy = newCopyInternal(copyMap);
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
	public Vokabel newCopyInternal(Map<IModelObject, IModelObject> copyMap) {
		Vokabel newCopy = (Vokabel) copyMap.get(this);
		if (newCopy == null) {
			newCopy = new Vokabel();
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
		Vokabel concreteCopy = (Vokabel) copy;
		concreteCopy.ausgangswert = ausgangswert;
		concreteCopy.zielwert = zielwert;
		for (Iterator<Statistik> it = statistiken.iterator(); it.hasNext();) {
			Statistik statistik = it.next();
			Statistik copyStatistik = statistik.newCopyInternal(copyMap);
			copyStatistik.setVokabelInternal(concreteCopy);
			concreteCopy.statistiken.add(copyStatistik);
		}
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
		for (Statistik statistik : statistiken) {
			Statistik copyStatistik = (Statistik) copyMap.get(statistik);
			statistik.copyAssociationsInternal(copyStatistik, copyMap);
		}
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
		for (Statistik statistik : statistiken) {
			statistik.accept(visitor);
		}
		return true;
	}

	/**
	 * Validierung von Objekten der Klasse Vokabel. Gibt <code>true</code> zurueck,
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
		if (!pruefeAusgangswert(ml, context)) {
			return STOP_VALIDATION;
		}
		if (!pruefeZielwert(ml, context)) {
			return STOP_VALIDATION;
		}
		return CONTINUE_VALIDATION;
	}

	/**
	 * Validierung von abhaengigen Objekten fuer Instanzen der Klasse Vokabel.
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public void validateDependants(MessageList ml, IValidationContext context) {
		super.validateDependants(ml, context);
		if (getNumOfStatistiken() > 0) {
			for (Statistik rel : getStatistiken()) {
				ml.add(rel.validate(context));
			}
		}
	}

	/**
	 * Fuehrt die Regel pruefeAusgangswert aus und fuegt eine Message an die
	 * uebergebene MessageList an, wenn die Regel einen nicht validen Zustand
	 * feststellt.
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
	@IpsValidationRule(name = "pruefeAusgangswert", msgCode = MSG_CODE_PRUEFE_AUSGANGSWERT, severity = Severity.ERROR)
	@IpsGenerated
	protected boolean pruefeAusgangswert(MessageList ml, IValidationContext context) {
		if (!getSetOfAllowedValuesForAusgangswert(context).contains(getAusgangswert())) {

			// begin-user-code
			ml.add(createMessageForRulePruefeAusgangswert(context));
			// end-user-code
		}
		return CONTINUE_VALIDATION;
	}

	/**
	 * Erzeugt die Message, die in das Ergebnis der Validierung aufgenommen wird,
	 * wenn die Regel pruefeAusgangswert einen nicht validen Zustand melden soll.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	protected Message createMessageForRulePruefeAusgangswert(IValidationContext context) {
		List<ObjectProperty> invalidObjectProperties = Arrays.asList(new ObjectProperty(this, PROPERTY_AUSGANGSWERT));
		MessagesHelper messageHelper = new MessagesHelper("de.ts.ns.tg.vokabeltrainer.internal.validation-messages",
				getClass().getClassLoader(), Locale.GERMAN);
		String msgText = messageHelper.getMessage("vokabeln.Vokabel-pruefeAusgangswert", context.getLocale());

		Message.Builder builder = new Message.Builder(msgText, Severity.ERROR).code(MSG_CODE_PRUEFE_AUSGANGSWERT)
				.invalidObjects(invalidObjectProperties);
		return builder.create();
	}

	/**
	 * Fuehrt die Regel pruefeZielwert aus und fuegt eine Message an die uebergebene
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
	@IpsValidationRule(name = "pruefeZielwert", msgCode = MSG_CODE_PRUEFE_ZIELWERT, severity = Severity.ERROR)
	@IpsGenerated
	protected boolean pruefeZielwert(MessageList ml, IValidationContext context) {
		if (!getSetOfAllowedValuesForZielwert(context).contains(getZielwert())) {

			// begin-user-code
			ml.add(createMessageForRulePruefeZielwert(context));
			// end-user-code
		}
		return CONTINUE_VALIDATION;
	}

	/**
	 * Erzeugt die Message, die in das Ergebnis der Validierung aufgenommen wird,
	 * wenn die Regel pruefeZielwert einen nicht validen Zustand melden soll.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	protected Message createMessageForRulePruefeZielwert(IValidationContext context) {
		List<ObjectProperty> invalidObjectProperties = Arrays.asList(new ObjectProperty(this, PROPERTY_ZIELWERT));
		MessagesHelper messageHelper = new MessagesHelper("de.ts.ns.tg.vokabeltrainer.internal.validation-messages",
				getClass().getClassLoader(), Locale.GERMAN);
		String msgText = messageHelper.getMessage("vokabeln.Vokabel-pruefeZielwert", context.getLocale());

		Message.Builder builder = new Message.Builder(msgText, Severity.ERROR).code(MSG_CODE_PRUEFE_ZIELWERT)
				.invalidObjects(invalidObjectProperties);
		return builder.create();
	}

	/**
	 * Erzeugt einen neuen VokabelBuilder um diesen Vertrag zu bearbeiten.
	 *
	 * @generated
	 */
	@IpsGenerated
	public VokabelBuilder modify() {
		return VokabelBuilder.from(this, null);
	}

	/**
	 * Das Runtime Repository wird benutzt um die konfigurierten Ziele von
	 * Assoziationen mit Hilfe eines bestehenden Produkts zu erstellen.
	 *
	 * @generated
	 */
	@IpsGenerated
	public VokabelBuilder modify(IRuntimeRepository runtimeRepository) {
		return VokabelBuilder.from(this, runtimeRepository);
	}

	/**
	 * Erzeugt eine neue Instanz von VokabelBuilder von einer neuen Vertragsinstanz.
	 * Runtime Repository wird null gesetzt.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static VokabelBuilder builder() {
		return VokabelBuilder.from(new Vokabel(), null);
	}

	/**
	 * Erzeugt eine neue Instanz von VokabelBuilder von einer neuen Vertragsinstanz.
	 * Runtime Repository wird null gesetzt. Das Runtime Repository wird gebraucht,
	 * wenn Ziele der Assoziationen durch Produkte konfiguriert werden. Diese müssen
	 * entsprechend in diesem Runtime Repository liegen.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static VokabelBuilder builder(IRuntimeRepository runtimeRepository) {
		return VokabelBuilder.from(new Vokabel(), runtimeRepository);
	}

	public long getErfolgreicheAbfragen(Long abfrageId) {
		return statistiken.stream().filter(s -> s.getAbfrageId().equals(abfrageId))
				.filter(s -> s.getUebereinstimmung() == 100).count();
	}

}
