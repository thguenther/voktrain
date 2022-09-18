package de.ts.ns.tg.vokabeltrainer.abfragen;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AbfrageTypConverter implements AttributeConverter<AbfrageTyp, Integer> {

	@Override
	public Integer convertToDatabaseColumn(AbfrageTyp attribute) {
		return attribute.getId();
	}

	@Override
	public AbfrageTyp convertToEntityAttribute(Integer dbData) {
		return AbfrageTyp.getValueById(dbData);
	}

}
