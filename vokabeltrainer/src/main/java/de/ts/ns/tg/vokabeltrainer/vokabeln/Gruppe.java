package de.ts.ns.tg.vokabeltrainer.vokabeln;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.faktorips.runtime.ICopySupport;
import org.faktorips.runtime.IDeltaComputationOptions;
import org.faktorips.runtime.IDeltaSupport;
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

import de.ts.ns.tg.vokabeltrainer.abfragen.Abfrage;
import de.ts.ns.tg.vokabeltrainer.ui.GruppenProvider;

/**
 * Implementierung von Gruppe.
 * 
 * @since 0.0.1
 *
 * @generated
 */
@Entity
@Table(name = "GRUPPE")
@IpsPolicyCmptType(name = "vokabeln.Gruppe")
@IpsAttributes({ "name", "statusBeschreibung" })
@IpsAssociations({ "Vokabel", "Abfrage" })
@IpsValidationRules({ "pruefeName" })
@IpsDocumented(bundleName = "de.ts.ns.tg.vokabeltrainer.modell-label-and-descriptions", defaultLocale = "de")
public class Gruppe extends AbstractModelObject implements IDeltaSupport, ICopySupport, IVisitorSupport {

	/**
	 * Die maximale Multiplizitaet der Beziehung mit dem Rollennamen Vokabel.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final IntegerRange MAX_MULTIPLICITY_OF_VOKABEL = IntegerRange.valueOf(0, 2147483647);
	/**
	 * Diese Konstante enthaelt den Namen der Beziehung vokabeln.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String ASSOCIATION_VOKABELN = "vokabeln";
	/**
	 * Die maximale Multiplizitaet der Beziehung mit dem Rollennamen Abfrage.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final IntegerRange MAX_MULTIPLICITY_OF_ABFRAGE = IntegerRange.valueOf(0, 2147483647);
	/**
	 * Diese Konstante enthaelt den Namen der Beziehung abfragen.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String ASSOCIATION_ABFRAGEN = "abfragen";
	/**
	 * Konstante fuer den Fehlercode der Regel pruefeName.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String MSG_CODE_PRUEFE_NAME = "NAME_UNGUELTIG";
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
	 * Diese Konstante enthaelt den Namen der Eigenschaft statusBeschreibung.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String PROPERTY_STATUSBESCHREIBUNG = "statusBeschreibung";
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
	 * Member variable for id. The id is used as primary key.
	 */
	@Id
	@GeneratedValue(generator = "GruppeSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GruppeSeq", sequenceName = "GRUPPE_SEQ", allocationSize = 50)
	private Long id;

	/**
	 * Membervariable fuer die Beziehung Vokabel.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 * @customizedAnnotations
	 */
	@OneToMany(mappedBy = "gruppe", cascade = CascadeType.ALL, targetEntity = Vokabel.class, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Vokabel> vokabeln = new ArrayList<>();

	/**
	 * Membervariable fuer die Beziehung Abfrage.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 * @customizedAnnotations
	 */
	@OneToMany(mappedBy = "gruppe", cascade = CascadeType.ALL, targetEntity = Abfrage.class, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Abfrage> abfragen = new ArrayList<>();

	/**
	 * Erzeugt eine neue Instanz von Gruppe.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public Gruppe() {
		super();
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
	 * Gibt die Anzahl der Vokabeln zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public int getNumOfVokabeln() {
		return vokabeln.size();
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
	public boolean containsVokabel(Vokabel objectToTest) {
		return vokabeln.contains(objectToTest);
	}

	/**
	 * Gibt die referenzierten Vokabeln zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociation(name = "Vokabel", pluralName = "Vokabeln", kind = AssociationKind.Composition, targetClass = Vokabel.class, min = 0, max = Integer.MAX_VALUE)
	@IpsInverseAssociation("Gruppe")
	@IpsGenerated
	public List<? extends Vokabel> getVokabeln() {
		return Collections.unmodifiableList(vokabeln);
	}

	/**
	 * Gibt das Objekt aus der Beziehung Vokabel an der indizierten Stelle zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public Vokabel getVokabel(int index) {
		return vokabeln.get(index);
	}

	/**
	 * Fuegt das uebergebene Objekt zu der Beziehung Vokabel hinzu.
	 * 
	 * @throws ClassCastException Wenn die Beziehung eingeschränkt wurde und das
	 *                            uebergebene Objekt nicht vom passenden Typ ist.
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociationAdder(association = "Vokabel")
	@IpsGenerated
	public void addVokabel(Vokabel objectToAdd) {
		if (objectToAdd == null) {
			throw new NullPointerException("Can't add null to association Vokabel of " + this);
		}
		if (vokabeln.contains(objectToAdd)) {
			return;
		}
		objectToAdd.setGruppeInternal(this);
		vokabeln.add(objectToAdd);
	}

	/**
	 * Erzeugt ein neues Vokabel-Objekt und fuegt es zu diesem Objekt in der Rolle
	 * Vokabel hinzu.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public Vokabel newVokabel() {
		Vokabel newVokabel = new Vokabel();
		addVokabel(newVokabel);
		newVokabel.initialize();
		return newVokabel;
	}

	/**
	 * Entfernt das uebergebene Objekt aus der Beziehung Vokabel.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociationRemover(association = "Vokabel")
	@IpsGenerated
	public void removeVokabel(Vokabel objectToRemove) {
		if (objectToRemove == null) {
			return;
		}
		if (vokabeln.remove(objectToRemove)) {
			objectToRemove.setGruppeInternal(null);
		}
	}

	/**
	 * Gibt die Anzahl der Abfragen zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public int getNumOfAbfragen() {
		return abfragen.size();
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
	public boolean containsAbfrage(Abfrage objectToTest) {
		return abfragen.contains(objectToTest);
	}

	/**
	 * Gibt die referenzierten Abfragen zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociation(name = "Abfrage", pluralName = "Abfragen", kind = AssociationKind.Composition, targetClass = Abfrage.class, min = 0, max = Integer.MAX_VALUE)
	@IpsInverseAssociation("Gruppe")
	@IpsGenerated
	public List<? extends Abfrage> getAbfragen() {
		return Collections.unmodifiableList(abfragen);
	}

	/**
	 * Gibt das Objekt aus der Beziehung Abfrage an der indizierten Stelle zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public Abfrage getAbfrage(int index) {
		return abfragen.get(index);
	}

	/**
	 * Fuegt das uebergebene Objekt zu der Beziehung Abfrage hinzu.
	 * 
	 * @throws ClassCastException Wenn die Beziehung eingeschränkt wurde und das
	 *                            uebergebene Objekt nicht vom passenden Typ ist.
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociationAdder(association = "Abfrage")
	@IpsGenerated
	public void addAbfrage(Abfrage objectToAdd) {
		if (objectToAdd == null) {
			throw new NullPointerException("Can't add null to association Abfrage of " + this);
		}
		if (abfragen.contains(objectToAdd)) {
			return;
		}
		objectToAdd.setGruppeInternal(this);
		abfragen.add(objectToAdd);
	}

	/**
	 * Erzeugt ein neues Abfrage-Objekt und fuegt es zu diesem Objekt in der Rolle
	 * Abfrage hinzu.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public Abfrage newAbfrage() {
		Abfrage newAbfrage = new Abfrage();
		addAbfrage(newAbfrage);
		newAbfrage.initialize();
		return newAbfrage;
	}

	/**
	 * Entfernt das uebergebene Objekt aus der Beziehung Abfrage.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociationRemover(association = "Abfrage")
	@IpsGenerated
	public void removeAbfrage(Abfrage objectToRemove) {
		if (objectToRemove == null) {
			return;
		}
		if (abfragen.remove(objectToRemove)) {
			objectToRemove.setGruppeInternal(null);
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
	protected void initPropertiesFromXml(Map<String, String> propMap, IRuntimeRepository productRepository) {
		super.initPropertiesFromXml(propMap, productRepository);
		doInitName(propMap);
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
		if ("Vokabel".equals(childEl.getNodeName())) {
			return doInitVokabel(childEl);
		}
		if ("Abfrage".equals(childEl.getNodeName())) {
			return doInitAbfrage(childEl);
		}
		return null;
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	private AbstractModelObject doInitVokabel(Element childEl) {
		String className = childEl.getAttribute("class");
		if (className.length() > 0) {
			try {
				Vokabel vokabelLocalVar = (Vokabel) Class.forName(className).getConstructor().newInstance();
				addVokabel(vokabelLocalVar);
				return vokabelLocalVar;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return newVokabel();
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	private AbstractModelObject doInitAbfrage(Element childEl) {
		String className = childEl.getAttribute("class");
		if (className.length() > 0) {
			try {
				Abfrage abfrageLocalVar = (Abfrage) Class.forName(className).getConstructor().newInstance();
				addAbfrage(abfrageLocalVar);
				return abfrageLocalVar;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return newAbfrage();
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
		if (!Gruppe.class.isAssignableFrom(otherObject.getClass())) {
			return delta;
		}
		Gruppe otherGruppe = (Gruppe) otherObject;
		delta.checkPropertyChange(Gruppe.PROPERTY_NAME, name, otherGruppe.name, options);
		ModelObjectDelta.createChildDeltas(delta, vokabeln, otherGruppe.vokabeln, ASSOCIATION_VOKABELN, options);
		ModelObjectDelta.createChildDeltas(delta, abfragen, otherGruppe.abfragen, ASSOCIATION_ABFRAGEN, options);
		return delta;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public Gruppe newCopy() {
		Map<IModelObject, IModelObject> copyMap = new HashMap<>();
		Gruppe newCopy = newCopyInternal(copyMap);
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
	public Gruppe newCopyInternal(Map<IModelObject, IModelObject> copyMap) {
		Gruppe newCopy = (Gruppe) copyMap.get(this);
		if (newCopy == null) {
			newCopy = new Gruppe();
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
		Gruppe concreteCopy = (Gruppe) copy;
		concreteCopy.name = name;
		for (Iterator<Vokabel> it = vokabeln.iterator(); it.hasNext();) {
			Vokabel vokabel = it.next();
			Vokabel copyVokabel = vokabel.newCopyInternal(copyMap);
			copyVokabel.setGruppeInternal(concreteCopy);
			concreteCopy.vokabeln.add(copyVokabel);
		}
		for (Iterator<Abfrage> it = abfragen.iterator(); it.hasNext();) {
			Abfrage abfrage = it.next();
			Abfrage copyAbfrage = abfrage.newCopyInternal(copyMap);
			copyAbfrage.setGruppeInternal(concreteCopy);
			concreteCopy.abfragen.add(copyAbfrage);
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
		for (Vokabel vokabel : vokabeln) {
			Vokabel copyVokabel = (Vokabel) copyMap.get(vokabel);
			vokabel.copyAssociationsInternal(copyVokabel, copyMap);
		}
		for (Abfrage abfrage : abfragen) {
			Abfrage copyAbfrage = (Abfrage) copyMap.get(abfrage);
			abfrage.copyAssociationsInternal(copyAbfrage, copyMap);
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
		for (Vokabel vokabel : vokabeln) {
			vokabel.accept(visitor);
		}
		for (Abfrage abfrage : abfragen) {
			abfrage.accept(visitor);
		}
		return true;
	}

	/**
	 * Validierung von Objekten der Klasse Gruppe. Gibt <code>true</code> zurueck,
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
		if (!pruefeName(ml, context)) {
			return STOP_VALIDATION;
		}
		return CONTINUE_VALIDATION;
	}

	/**
	 * Validierung von abhaengigen Objekten fuer Instanzen der Klasse Gruppe.
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public void validateDependants(MessageList ml, IValidationContext context) {
		super.validateDependants(ml, context);
		if (getNumOfVokabeln() > 0) {
			for (Vokabel rel : getVokabeln()) {
				ml.add(rel.validate(context));
			}
		}
		if (getNumOfAbfragen() > 0) {
			for (Abfrage rel : getAbfragen()) {
				ml.add(rel.validate(context));
			}
		}
	}

	/**
	 * Fuehrt die Regel pruefeName aus und fuegt eine Message an die uebergebene
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
	@IpsValidationRule(name = "pruefeName", msgCode = MSG_CODE_PRUEFE_NAME, severity = Severity.ERROR)
	@IpsGenerated
	protected boolean pruefeName(MessageList ml, IValidationContext context) {
		if (!getSetOfAllowedValuesForName(context).contains(getName())) {

			// begin-user-code
			ml.add(createMessageForRulePruefeName(context));
			// end-user-code
		}
		return CONTINUE_VALIDATION;
	}

	/**
	 * Erzeugt die Message, die in das Ergebnis der Validierung aufgenommen wird,
	 * wenn die Regel pruefeName einen nicht validen Zustand melden soll.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	protected Message createMessageForRulePruefeName(IValidationContext context) {
		List<ObjectProperty> invalidObjectProperties = Arrays.asList(new ObjectProperty(this, PROPERTY_NAME));
		MessagesHelper messageHelper = new MessagesHelper("de.ts.ns.tg.vokabeltrainer.internal.validation-messages",
				getClass().getClassLoader(), Locale.GERMAN);
		String msgText = messageHelper.getMessage("vokabeln.Gruppe-pruefeName", context.getLocale());

		Message.Builder builder = new Message.Builder(msgText, Severity.ERROR).code(MSG_CODE_PRUEFE_NAME)
				.invalidObjects(invalidObjectProperties);
		return builder.create();
	}

	/**
	 * Erzeugt einen neuen GruppeBuilder um diesen Vertrag zu bearbeiten.
	 *
	 * @generated
	 */
	@IpsGenerated
	public GruppeBuilder modify() {
		return GruppeBuilder.from(this, null);
	}

	/**
	 * Das Runtime Repository wird benutzt um die konfigurierten Ziele von
	 * Assoziationen mit Hilfe eines bestehenden Produkts zu erstellen.
	 *
	 * @generated
	 */
	@IpsGenerated
	public GruppeBuilder modify(IRuntimeRepository runtimeRepository) {
		return GruppeBuilder.from(this, runtimeRepository);
	}

	/**
	 * Erzeugt eine neue Instanz von GruppeBuilder von einer neuen Vertragsinstanz.
	 * Runtime Repository wird null gesetzt.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static GruppeBuilder builder() {
		return GruppeBuilder.from(new Gruppe(), null);
	}

	/**
	 * Erzeugt eine neue Instanz von GruppeBuilder von einer neuen Vertragsinstanz.
	 * Runtime Repository wird null gesetzt. Das Runtime Repository wird gebraucht,
	 * wenn Ziele der Assoziationen durch Produkte konfiguriert werden. Diese müssen
	 * entsprechend in diesem Runtime Repository liegen.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static GruppeBuilder builder(IRuntimeRepository runtimeRepository) {
		return GruppeBuilder.from(new Gruppe(), runtimeRepository);
	}

	@IpsAttribute(name = "statusBeschreibung", kind = AttributeKind.DERIVED_ON_THE_FLY, valueSetKind = ValueSetKind.AllValues)
	public String getStatusBeschreibung() {
		return getNumOfVokabeln() + " Vokabeln, " + getNumOfAbfragen() + " Abfragen (" + getAbfrageStatus()
				+ "% erledigt)";
	}

	private int getAbfrageStatus() {
		if (getNumOfAbfragen() == 0) {
			return 100;
		}
		var erledigt = abfragen.stream().filter(a -> a.istErledigt(new GruppenProvider(Optional.of(this)))).count();
		return (int) (100 * erledigt / getNumOfAbfragen());
	}

	public Long getId() {
		return id;
	}

}
