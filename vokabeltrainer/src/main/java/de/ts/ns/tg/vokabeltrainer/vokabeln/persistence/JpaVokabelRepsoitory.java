package de.ts.ns.tg.vokabeltrainer.vokabeln.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.ts.ns.tg.vokabeltrainer.vokabeln.Gruppe;

public interface JpaVokabelRepsoitory extends CrudRepository<Gruppe, Long> {

	default List<Gruppe> findAllGruppen() {
		List<Gruppe> result = new ArrayList<Gruppe>();
		findAll().forEach(g -> result.add(g));
		return result;
	}

}
