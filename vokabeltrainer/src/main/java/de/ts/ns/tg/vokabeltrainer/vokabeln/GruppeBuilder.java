package de.ts.ns.tg.vokabeltrainer.vokabeln;

import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.runtime.annotation.IpsGenerated;

import de.ts.ns.tg.vokabeltrainer.abfragen.Abfrage;
import de.ts.ns.tg.vokabeltrainer.abfragen.AbfrageBuilder;

/**
 * Diese Klasse stellt Methoden bereit, mit denen eine Instanz von Gruppe
 * erstellt und bearbeitet werden kann.
 *
 * @generated
 */
public class GruppeBuilder {
	/**
	 * @generated
	 */
	private final Gruppe gruppe;

	/**
	 * @generated
	 */
	private IRuntimeRepository runtimeRepository;

	/**
	 * Erzeugt eine neue Instanz von GruppeBuilder mit einem Runtime Repository.
	 * Dieser Konstruktor ist nur für den internen Gebrauch!
	 *
	 * @generated
	 */
	@IpsGenerated
	protected GruppeBuilder(Gruppe policy, IRuntimeRepository runtimeRepository) {
		this.gruppe = policy;
		this.runtimeRepository = runtimeRepository;
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	public GruppeBuilder setRepository(IRuntimeRepository runtimeRepository) {
		this.runtimeRepository = runtimeRepository;
		return this;
	}

	/**
	 * Setzt den Wert des Attributs name.
	 *
	 * @generated
	 */
	@IpsGenerated
	public GruppeBuilder name(String newName) {
		gruppe.setName(newName);
		return this;
	}

	/**
	 * Gibt die Instanz von Gruppe zurück, die von diesem Builder gebaut wird.
	 *
	 * @generated
	 */
	@IpsGenerated
	public Gruppe getResult() {
		return gruppe;
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
		return Gruppe.class;
	}

	/**
	 * Erzeugt einen neuen GruppeBuilder mit einer Instanz von Gruppe.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static GruppeBuilder from(Gruppe policy) {
		return new GruppeBuilder(policy, null);
	}

	/**
	 * Erzeugt einen neuen GruppeBuilder mit einer Instanz von Gruppe und einem
	 * Runtime Repository.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static GruppeBuilder from(Gruppe policy, IRuntimeRepository runtimeRepository) {
		return new GruppeBuilder(policy, runtimeRepository);
	}

	/**
	 * Erzeugt einen {@link AssociationBuilder} mit dem ein Zielobjekt erstellt und
	 * direkt an eine Beziehung gehängt werden kann. Der {@link AssociationBuilder}
	 * gibt daraufhin immer den Builder des Zielobjekts zurück. Um eine Beziehungen
	 * aufzubauen und immer zu diesem aktuellen Builder zurück zu kehren, kann die
	 * Methode {@link #add()} verwendet werden.
	 * 
	 * @see #add()
	 *
	 * @generated
	 */
	@IpsGenerated
	public AssociationBuilder associate() {
		return new AssociationBuilder(this);
	}

	/**
	 * Erzeugt einen {@link AddAssociationBuilder} mit dem ein Zielobjekt erstellt
	 * und direkt an eine Beziehung gehängt werden kann. Der
	 * {@link AddAssociationBuilder} gibt daraufhin immer wieder diesen Builder
	 * zurück um z.B. weitere Beziehungen aufbauen zu können. Um stattdessen den
	 * Builder des Zielobjekts zu erhalten kann die Methode {@link #associate()}
	 * verwendet werden.
	 * 
	 * @see #associate()
	 *
	 * @generated
	 */
	@IpsGenerated
	public AddAssociationBuilder add() {
		return new AddAssociationBuilder(this);
	}

	/**
	 * Dies ist eine Wrapper-Klasse für die Setter für Assoziationen. Die Methoden
	 * in dieser Klasse geben einen Builder für die jeweilige Zielklasse zurück.
	 *
	 * @generated
	 */
	public static class AssociationBuilder {

		/**
		 * @generated
		 */
		private GruppeBuilder policyBuilder;

		/**
		 * @generated
		 */
		@IpsGenerated
		protected AssociationBuilder(GruppeBuilder policyBuilder) {
			this.policyBuilder = policyBuilder;
		}

		/**
		 * Erzeugt eine neue Instanz einer Subklasse von Vokabel mit dem gegebenen
		 * Builder und setzt diese als Vokabel.
		 *
		 * @generated
		 */
		@IpsGenerated
		public <T extends VokabelBuilder> T vokabel(T targetBuilder) {
			getResult().addVokabel(targetBuilder.getResult());
			return targetBuilder;
		}

		/**
		 * Erzeugt eine neue Instanz von Vokabel und setzt diese als Vokabel.
		 *
		 * @generated
		 */
		@IpsGenerated
		public VokabelBuilder vokabel() {
			VokabelBuilder targetBuilder = Vokabel.builder();
			getResult().addVokabel(targetBuilder.getResult());
			return targetBuilder;
		}

		/**
		 * Erzeugt eine neue Instanz einer Subklasse von Abfrage mit dem gegebenen
		 * Builder und setzt diese als Abfrage.
		 *
		 * @generated
		 */
		@IpsGenerated
		public <T extends AbfrageBuilder> T abfrage(T targetBuilder) {
			getResult().addAbfrage(targetBuilder.getResult());
			return targetBuilder;
		}

		/**
		 * Erzeugt eine neue Instanz von Abfrage und setzt diese als Abfrage.
		 *
		 * @generated
		 */
		@IpsGenerated
		public AbfrageBuilder abfrage() {
			AbfrageBuilder targetBuilder = Abfrage.builder();
			getResult().addAbfrage(targetBuilder.getResult());
			return targetBuilder;
		}

		/**
		 * @generated
		 */
		@IpsGenerated
		protected Gruppe getResult() {
			return policyBuilder.getResult();
		}

		/**
		 * @generated
		 */
		@IpsGenerated
		protected IRuntimeRepository getRepository() {
			return policyBuilder.getRepository();
		}
	}

	/**
	 * Dies ist eine Wrapper-Klasse für die Setter für Assoziationen. Die Methoden
	 * in dieser Klasse geben wieder den ursprünglichen GruppeBuilder zurück.
	 *
	 * @generated
	 */
	public static class AddAssociationBuilder {

		/**
		 * @generated
		 */
		private GruppeBuilder policyBuilder;

		/**
		 * @generated
		 */
		@IpsGenerated
		protected AddAssociationBuilder(GruppeBuilder policyBuilder) {
			this.policyBuilder = policyBuilder;
		}

		/**
		 * Setzt eine existierende Instanz von Vokabel als Vokabel.
		 *
		 * @generated
		 */
		@IpsGenerated
		public GruppeBuilder vokabel(Vokabel targetPolicy) {
			getResult().addVokabel(targetPolicy);
			return done();
		}

		/**
		 * Erzeugt eine neue Instanz einer Subklasse von Vokabel mit dem gegebenen
		 * Builder und setzt diese als Vokabel.
		 *
		 * @generated
		 */
		@IpsGenerated
		public GruppeBuilder vokabel(VokabelBuilder targetBuilder) {
			getResult().addVokabel(targetBuilder.getResult());
			return done();
		}

		/**
		 * Erzeugt eine neue Instanz von Vokabel und setzt diese als Vokabel.
		 *
		 * @generated
		 */
		@IpsGenerated
		public GruppeBuilder vokabel() {
			VokabelBuilder targetBuilder = Vokabel.builder();
			getResult().addVokabel(targetBuilder.getResult());
			return done();
		}

		/**
		 * Setzt eine existierende Instanz von Abfrage als Abfrage.
		 *
		 * @generated
		 */
		@IpsGenerated
		public GruppeBuilder abfrage(Abfrage targetPolicy) {
			getResult().addAbfrage(targetPolicy);
			return done();
		}

		/**
		 * Erzeugt eine neue Instanz einer Subklasse von Abfrage mit dem gegebenen
		 * Builder und setzt diese als Abfrage.
		 *
		 * @generated
		 */
		@IpsGenerated
		public GruppeBuilder abfrage(AbfrageBuilder targetBuilder) {
			getResult().addAbfrage(targetBuilder.getResult());
			return done();
		}

		/**
		 * Erzeugt eine neue Instanz von Abfrage und setzt diese als Abfrage.
		 *
		 * @generated
		 */
		@IpsGenerated
		public GruppeBuilder abfrage() {
			AbfrageBuilder targetBuilder = Abfrage.builder();
			getResult().addAbfrage(targetBuilder.getResult());
			return done();
		}

		/**
		 * @generated
		 */
		@IpsGenerated
		protected GruppeBuilder done() {
			return policyBuilder;
		}

		/**
		 * @generated
		 */
		@IpsGenerated
		protected Gruppe getResult() {
			return policyBuilder.getResult();
		}

		/**
		 * @generated
		 */
		@IpsGenerated
		protected IRuntimeRepository getRepository() {
			return policyBuilder.getRepository();
		}
	}

}
