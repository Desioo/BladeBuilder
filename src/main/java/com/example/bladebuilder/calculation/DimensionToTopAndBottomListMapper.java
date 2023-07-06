package com.example.bladebuilder.calculation;

import java.math.BigDecimal;

public interface DimensionToTopAndBottomListMapper {

    void mapDimensionsToTopAndBottomByRepeating();

    BigDecimal subtractKnifeAndThicknessFromSize(BigDecimal size);

}
