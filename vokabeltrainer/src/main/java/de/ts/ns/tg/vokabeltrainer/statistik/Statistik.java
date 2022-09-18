package de.ts.ns.tg.vokabeltrainer.statistik;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
import org.faktorips.runtime.MessageList;
import org.faktorips.runtime.annotation.IpsGenerated;
import org.faktorips.runtime.internal.AbstractModelObject;
import org.faktorips.runtime.internal.IpsStringUtils;
import org.faktorips.runtime.internal.ModelObjectDelta;
import org.faktorips.runtime.model.annotation.IpsAssociation;
import org.faktorips.runtime.model.annotation.IpsAssociationAdder;
import org.faktorips.runtime.model.annotation.IpsAssociations;
import org.faktorips.runtime.model.annotation.IpsAttribute;
import org.faktorips.runtime.model.annotation.IpsAttributeSetter;
import org.faktorips.runtime.model.annotation.IpsAttributes;
import org.faktorips.runtime.model.annotation.IpsDocumented;
import org.faktorips.runtime.model.annotation.IpsInverseAssociation;
import org.faktorips.runtime.model.annotation.IpsPolicyCmptType;
import org.faktorips.runtime.model.type.AssociationKind;
import org.faktorips.runtime.model.type.AttributeKind;
import org.faktorips.runtime.model.type.ValueSetKind;
import org.w3c.dom.Element;

import de.ts.ns.tg.vokabeltrainer.vokabeln.Vokabel;

/**
 * Implementierung von Statistik.
 * 
 * @since 0.0.1
 *
 * @generated
 */
@Entity
@Table(name = "STATISTIK")
@IpsPolicyCmptType(name = "statistik.Statistik")
@IpsAttributes({ "zeitstempel", "uebereinstimmung", "abfrageId" })
@IpsAssociations({ "Vokabel" })
@IpsDocumented(bundleName = "de.ts.ns.tg.vokabeltrainer.modell-label-and-descriptions", defaultLocale = "de")
public class Statistik extends AbstractModelObject
		implements IDeltaSupport, ICopySupport, IVisitorSupport, IDependantObject {

	/**
	 * Diese Konstante enthaelt den Namen der Beziehung vokabel.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String ASSOCIATION_VOKABEL = "vokabel";
	/**
	 * Diese Konstante enthaelt den Namen der Eigenschaft zeitstempel.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String PROPERTY_ZEITSTEMPEL = "zeitstempel";
	/**
	 * Diese Konstante enthaelt den Namen der Eigenschaft uebereinstimmung.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String PROPERTY_UEBEREINSTIMMUNG = "uebereinstimmung";

	/**
	 * Diese Konstante enthaelt den Namen der Eigenschaft abfrageId.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	public static final String PROPERTY_ABFRAGEID = "abfrageId";
	/**
	 * Member variable for id. The id is used as primary key.
	 */
	@Id
	@GeneratedValue(generator = "StatistikSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "StatistikSeq", sequenceName = "STATISTIK_SEQ", allocationSize = 50)
	private Long id;

	/**
	 * Membervariable fuer zeitstempel.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@Column(name = "ZEITSTEMPEL", nullable = true, unique = false)
	private LocalDateTime zeitstempel = null;
	/**
	 * Membervariable fuer uebereinstimmung.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@Column(name = "UEBEREINSTIMMUNG", nullable = true, unique = false)
	private Integer uebereinstimmung = null;

	/**
	 * Membervariable fuer abfrageId.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@Column(name = "ABFRAGE_ID", nullable = true, unique = false)
	private Long abfrageId = null;
	/**
	 * Membervariable fuer das Parent-Objekt: Vokabel.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Vokabel.class)
	@JoinColumn(name = "VOKABEL")
	private Vokabel vokabel;

	/**
	 * Erzeugt eine neue Instanz von Statistik.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsGenerated
	public Statistik() {
		super();
	}

	/**
	 * Gibt den Wert des Attributs zeitstempel zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttribute(name = "zeitstempel", kind = AttributeKind.CHANGEABLE, valueSetKind = ValueSetKind.AllValues)
	@IpsGenerated
	public LocalDateTime getZeitstempel() {
		return zeitstempel;
	}

	/**
	 * Setzt den Wert des Attributs zeitstempel.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttributeSetter("zeitstempel")
	@IpsGenerated
	public void setZeitstempel(LocalDateTime newValue) {
		this.zeitstempel = newValue;
	}

	/**
	 * Gibt den Wert des Attributs uebereinstimmung zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttribute(name = "uebereinstimmung", kind = AttributeKind.CHANGEABLE, valueSetKind = ValueSetKind.AllValues)
	@IpsGenerated
	public Integer getUebereinstimmung() {
		return uebereinstimmung;
	}

	/**
	 * Setzt den Wert des Attributs uebereinstimmung.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttributeSetter("uebereinstimmung")
	@IpsGenerated
	public void setUebereinstimmung(Integer newValue) {
		this.uebereinstimmung = newValue;
	}

	/**
	 * Gibt den Wert des Attributs abfrageId zurueck.
	 * <p>
	 * ID der Abfrage, durch welche diese Statistik erzeugt wurde.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttribute(name = "abfrageId", kind = AttributeKind.CHANGEABLE, valueSetKind = ValueSetKind.AllValues)
	@IpsGenerated
	public Long getAbfrageId() {
		return abfrageId;
	}

	/**
	 * Setzt den Wert des Attributs abfrageId.
	 * <p>
	 * ID der Abfrage, durch welche diese Statistik erzeugt wurde.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAttributeSetter("abfrageId")
	@IpsGenerated
	public void setAbfrageId(Long newValue) {
		this.abfrageId = newValue;
	}

	/**
	 * Gibt das referenzierte Vokabel-Objekt zurueck.
	 * 
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociation(name = "Vokabel", pluralName = "", kind = AssociationKind.CompositionToMaster, targetClass = Vokabel.class, min = 0, max = 1)
	@IpsInverseAssociation("Statistik")
	@IpsGenerated
	public Vokabel getVokabel() {
		return vokabel;
	}

	/**
	 * @since 0.0.1
	 *
	 * @generated
	 */
	@IpsAssociationAdder(association = "Vokabel")
	@IpsGenerated
	public void setVokabelInternal(Vokabel newParent) {
		if (getVokabel() == newParent) {
			return;
		}
		IModelObject parent = getParentModelObject();
		if (newParent != null && parent != null) {
			throw new IllegalStateException(String.format(
					"Statistik (\"%s\") kann nicht dem Parent-Objekt der Klasse Vokabel (\"%s\") hinzugefügt werden, da das Objekt bereits dem Parent-Objekt (\"%s\") zugeordnet ist.",
					toString(), newParent.toString(), parent.toString()));
		}
		this.vokabel = newParent;
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
		if (vokabel != null) {
			return vokabel;
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
		doInitZeitstempel(propMap);
		doInitUebereinstimmung(propMap);
		doInitAbfrageId(propMap);
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	private void doInitZeitstempel(Map<String, String> propMap) {
		if (propMap.containsKey(PROPERTY_ZEITSTEMPEL)) {
			this.zeitstempel = IpsStringUtils.isEmpty(propMap.get(PROPERTY_ZEITSTEMPEL)) ? null
					: LocalDateTime.parse(propMap.get(PROPERTY_ZEITSTEMPEL));
		}
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	private void doInitUebereinstimmung(Map<String, String> propMap) {
		if (propMap.containsKey(PROPERTY_UEBEREINSTIMMUNG)) {
			this.uebereinstimmung = IpsStringUtils.isEmpty(propMap.get(PROPERTY_UEBEREINSTIMMUNG)) ? null
					: Integer.valueOf(propMap.get(PROPERTY_UEBEREINSTIMMUNG));
		}
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	private void doInitAbfrageId(Map<String, String> propMap) {
		if (propMap.containsKey(PROPERTY_ABFRAGEID)) {
			this.abfrageId = IpsStringUtils.isEmpty(propMap.get(PROPERTY_ABFRAGEID)) ? null
					: Long.valueOf(propMap.get(PROPERTY_ABFRAGEID));
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
		if (!Statistik.class.isAssignableFrom(otherObject.getClass())) {
			return delta;
		}
		Statistik otherStatistik = (Statistik) otherObject;
		delta.checkPropertyChange(Statistik.PROPERTY_ZEITSTEMPEL, zeitstempel, otherStatistik.zeitstempel, options);
		delta.checkPropertyChange(Statistik.PROPERTY_UEBEREINSTIMMUNG, uebereinstimmung,
				otherStatistik.uebereinstimmung, options);
		delta.checkPropertyChange(Statistik.PROPERTY_ABFRAGEID, abfrageId, otherStatistik.abfrageId, options);
		return delta;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public Statistik newCopy() {
		Map<IModelObject, IModelObject> copyMap = new HashMap<>();
		Statistik newCopy = newCopyInternal(copyMap);
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
	public Statistik newCopyInternal(Map<IModelObject, IModelObject> copyMap) {
		Statistik newCopy = (Statistik) copyMap.get(this);
		if (newCopy == null) {
			newCopy = new Statistik();
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
		Statistik concreteCopy = (Statistik) copy;
		concreteCopy.zeitstempel = zeitstempel;
		concreteCopy.uebereinstimmung = uebereinstimmung;
		concreteCopy.abfrageId = abfrageId;
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
	 * Validierung von Objekten der Klasse Statistik. Gibt <code>true</code>
	 * zurueck, wenn dieses Objekt mit der Validierung fortfahren soll,
	 * <code>false</code> sonst.
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public boolean validateSelf(MessageList ml, IValidationContext context) {
		if (!super.validateSelf(ml, context)) {
			return STOP_VALIDATION;
		}
		return CONTINUE_VALIDATION;
	}

	/**
	 * Validierung von abhaengigen Objekten fuer Instanzen der Klasse Statistik.
	 *
	 * @generated
	 */
	@Override
	@IpsGenerated
	public void validateDependants(MessageList ml, IValidationContext context) {
		super.validateDependants(ml, context);
	}

	/**
	 * Erzeugt einen neuen StatistikBuilder um diesen Vertrag zu bearbeiten.
	 *
	 * @generated
	 */
	@IpsGenerated
	public StatistikBuilder modify() {
		return StatistikBuilder.from(this, null);
	}

	/**
	 * Das Runtime Repository wird benutzt um die konfigurierten Ziele von
	 * Assoziationen mit Hilfe eines bestehenden Produkts zu erstellen.
	 *
	 * @generated
	 */
	@IpsGenerated
	public StatistikBuilder modify(IRuntimeRepository runtimeRepository) {
		return StatistikBuilder.from(this, runtimeRepository);
	}

	/**
	 * Erzeugt eine neue Instanz von StatistikBuilder von einer neuen
	 * Vertragsinstanz. Runtime Repository wird null gesetzt.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static StatistikBuilder builder() {
		return StatistikBuilder.from(new Statistik(), null);
	}

	/**
	 * Erzeugt eine neue Instanz von StatistikBuilder von einer neuen
	 * Vertragsinstanz. Runtime Repository wird null gesetzt. Das Runtime Repository
	 * wird gebraucht, wenn Ziele der Assoziationen durch Produkte konfiguriert
	 * werden. Diese müssen entsprechend in diesem Runtime Repository liegen.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static StatistikBuilder builder(IRuntimeRepository runtimeRepository) {
		return StatistikBuilder.from(new Statistik(), runtimeRepository);
	}

}
