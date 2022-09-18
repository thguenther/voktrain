package de.ts.ns.tg.vokabeltrainer.vokabeln;

import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.runtime.annotation.IpsGenerated;

import de.ts.ns.tg.vokabeltrainer.statistik.Statistik;
import de.ts.ns.tg.vokabeltrainer.statistik.StatistikBuilder;

/**
 * Diese Klasse stellt Methoden bereit, mit denen eine Instanz von Vokabel
 * erstellt und bearbeitet werden kann.
 *
 * @generated
 */
public class VokabelBuilder {
	/**
	 * @generated
	 */
	private final Vokabel vokabel;

	/**
	 * @generated
	 */
	private IRuntimeRepository runtimeRepository;

	/**
	 * Erzeugt eine neue Instanz von VokabelBuilder mit einem Runtime Repository.
	 * Dieser Konstruktor ist nur für den internen Gebrauch!
	 *
	 * @generated
	 */
	@IpsGenerated
	protected VokabelBuilder(Vokabel policy, IRuntimeRepository runtimeRepository) {
		this.vokabel = policy;
		this.runtimeRepository = runtimeRepository;
	}

	/**
	 * @generated
	 */
	@IpsGenerated
	public VokabelBuilder setRepository(IRuntimeRepository runtimeRepository) {
		this.runtimeRepository = runtimeRepository;
		return this;
	}

	/**
	 * Setzt den Wert des Attributs ausgangswert.
	 *
	 * @generated
	 */
	@IpsGenerated
	public VokabelBuilder ausgangswert(String newAusgangswert) {
		vokabel.setAusgangswert(newAusgangswert);
		return this;
	}

	/**
	 * Setzt den Wert des Attributs zielwert.
	 *
	 * @generated
	 */
	@IpsGenerated
	public VokabelBuilder zielwert(String newZielwert) {
		vokabel.setZielwert(newZielwert);
		return this;
	}

	/**
	 * Gibt die Instanz von Vokabel zurück, die von diesem Builder gebaut wird.
	 *
	 * @generated
	 */
	@IpsGenerated
	public Vokabel getResult() {
		return vokabel;
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
		return Vokabel.class;
	}

	/**
	 * Erzeugt einen neuen VokabelBuilder mit einer Instanz von Vokabel.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static VokabelBuilder from(Vokabel policy) {
		return new VokabelBuilder(policy, null);
	}

	/**
	 * Erzeugt einen neuen VokabelBuilder mit einer Instanz von Vokabel und einem
	 * Runtime Repository.
	 *
	 * @generated
	 */
	@IpsGenerated
	public static VokabelBuilder from(Vokabel policy, IRuntimeRepository runtimeRepository) {
		return new VokabelBuilder(policy, runtimeRepository);
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
		private VokabelBuilder policyBuilder;

		/**
		 * @generated
		 */
		@IpsGenerated
		protected AssociationBuilder(VokabelBuilder policyBuilder) {
			this.policyBuilder = policyBuilder;
		}

		/**
		 * Erzeugt eine neue Instanz einer Subklasse von Statistik mit dem gegebenen
		 * Builder und setzt diese als Statistik.
		 *
		 * @generated
		 */
		@IpsGenerated
		public <T extends StatistikBuilder> T statistik(T targetBuilder) {
			getResult().addStatistik(targetBuilder.getResult());
			return targetBuilder;
		}

		/**
		 * Erzeugt eine neue Instanz von Statistik und setzt diese als Statistik.
		 *
		 * @generated
		 */
		@IpsGenerated
		public StatistikBuilder statistik() {
			StatistikBuilder targetBuilder = Statistik.builder();
			getResult().addStatistik(targetBuilder.getResult());
			return targetBuilder;
		}

		/**
		 * @generated
		 */
		@IpsGenerated
		protected Vokabel getResult() {
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
	 * in dieser Klasse geben wieder den ursprünglichen VokabelBuilder zurück.
	 *
	 * @generated
	 */
	public static class AddAssociationBuilder {

		/**
		 * @generated
		 */
		private VokabelBuilder policyBuilder;

		/**
		 * @generated
		 */
		@IpsGenerated
		protected AddAssociationBuilder(VokabelBuilder policyBuilder) {
			this.policyBuilder = policyBuilder;
		}

		/**
		 * Setzt eine existierende Instanz von Statistik als Statistik.
		 *
		 * @generated
		 */
		@IpsGenerated
		public VokabelBuilder statistik(Statistik targetPolicy) {
			getResult().addStatistik(targetPolicy);
			return done();
		}

		/**
		 * Erzeugt eine neue Instanz einer Subklasse von Statistik mit dem gegebenen
		 * Builder und setzt diese als Statistik.
		 *
		 * @generated
		 */
		@IpsGenerated
		public VokabelBuilder statistik(StatistikBuilder targetBuilder) {
			getResult().addStatistik(targetBuilder.getResult());
			return done();
		}

		/**
		 * Erzeugt eine neue Instanz von Statistik und setzt diese als Statistik.
		 *
		 * @generated
		 */
		@IpsGenerated
		public VokabelBuilder statistik() {
			StatistikBuilder targetBuilder = Statistik.builder();
			getResult().addStatistik(targetBuilder.getResult());
			return done();
		}

		/**
		 * @generated
		 */
		@IpsGenerated
		protected VokabelBuilder done() {
			return policyBuilder;
		}

		/**
		 * @generated
		 */
		@IpsGenerated
		protected Vokabel getResult() {
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
