package zaifi.springframework.spring5recipeapp.convertors;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import zaifi.springframework.spring5recipeapp.commands.UnitOfMeasureCommand;
import zaifi.springframework.spring5recipeapp.domain.UnitOfMeasure;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

        if (unitOfMeasure != null) {
            final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
            unitOfMeasureCommand.setId(unitOfMeasure.getId());
            unitOfMeasureCommand.setDescription(unitOfMeasure.getDescription());
            return unitOfMeasureCommand;
        }
        return null;
    }
}
