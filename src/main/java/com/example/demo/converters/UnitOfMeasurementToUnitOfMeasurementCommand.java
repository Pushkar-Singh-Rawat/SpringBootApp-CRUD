package com.example.demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.demo.commands.UnitOfMeasurementCommand;
import com.example.demo.model.UnitOfMeasurement;

import lombok.Synchronized;

@Component
public class UnitOfMeasurementToUnitOfMeasurementCommand
		implements Converter<UnitOfMeasurement, UnitOfMeasurementCommand> {

	@Synchronized
	@Nullable
	@Override
	public UnitOfMeasurementCommand convert(UnitOfMeasurement uom) {
		if(uom!=null){
		final UnitOfMeasurementCommand command=new UnitOfMeasurementCommand();
		command.setUomID(uom.getUomID());
		command.setDescription(uom.getDescription());
		return command;
		}
		return null;
	}

}
