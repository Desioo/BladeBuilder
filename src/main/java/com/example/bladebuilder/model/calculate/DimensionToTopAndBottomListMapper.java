package com.example.bladebuilder.model.calculate;

import java.math.BigDecimal;
import java.util.List;

public interface DimensionToTopAndBottomListMapper {

    void mapDimensionsToTopAndBottomByRepeating(List<Dimension> dimensions);

    BigDecimal subtractKnifeAndThicknessFromSize(BigDecimal size);

}
