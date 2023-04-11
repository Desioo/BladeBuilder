package com.example.bladebuilder.model.calculate;

import java.math.BigDecimal;
import java.util.List;

public interface SizeToDistanceMapper {

    List<BigDecimal> mapSizeToDistance(BigDecimal size);

}
