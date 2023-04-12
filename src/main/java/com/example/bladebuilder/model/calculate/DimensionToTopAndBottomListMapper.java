package com.example.bladebuilder.model.calculate;

import java.math.BigDecimal;

public interface DimensionToTopAndBottomListMapper {

    void mapDimensionsToTopAndBottomByRepeating();

    BigDecimal subtractKnifeAndThicknessFromSize(BigDecimal size);

}
