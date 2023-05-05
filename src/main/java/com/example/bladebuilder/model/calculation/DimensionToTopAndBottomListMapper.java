package com.example.bladebuilder.model.calculation;

import java.math.BigDecimal;

public interface DimensionToTopAndBottomListMapper {

    void mapDimensionsToTopAndBottomByRepeating();

    BigDecimal subtractKnifeAndThicknessFromSize(BigDecimal size);

}
