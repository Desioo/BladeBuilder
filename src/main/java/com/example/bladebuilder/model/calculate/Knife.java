package com.example.bladebuilder.model.calculate;

import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Knife implements CenterCalculator, SizeToDistanceMapper {
    private static final BigDecimal FULL_SHAFT_SIZE = new BigDecimal("1740");
    private static final BigDecimal CENTER_DIVIDER = new BigDecimal("2");
    private static final BigDecimal DOUBLE = new BigDecimal("2");
    private static final BigDecimal KNIFE_CORRECTION = new BigDecimal("0.04");
    private static final BigDecimal TEN_PERCENT = new BigDecimal("0.1");

    private BigDecimal distanceThree = new BigDecimal("3");
    private BigDecimal distanceFive = new BigDecimal("5");

    private final MeasurementRequestDTO measurementRequestDTO;
    @Getter
    private List<BigDecimal> center1;
    @Getter
    private BigDecimal center2;

    @Override
    public void countCenter2() {

        center2 = FULL_SHAFT_SIZE.subtract(measurementRequestDTO.getFullSize())
                .divide(CENTER_DIVIDER, 0, RoundingMode.HALF_EVEN);

    }

    @Override
    public void countCenter1() {

        BigDecimal result = center2.subtract(measurementRequestDTO.getKnivesSize())
                .subtract(measurementRequestDTO.getThickness().multiply(TEN_PERCENT))
                .subtract(KNIFE_CORRECTION)
                .setScale(2, RoundingMode.HALF_EVEN).stripTrailingZeros();

        center1 = mapSizeToDistance(result);

    }

    @Override
    public List<BigDecimal> mapSizeToDistance(BigDecimal size) {

        String sizeToString = size.toString();
        List<BigDecimal> sizeWithDistances = new ArrayList<>();

        if (sizeToString.matches("\\d+\\.\\d[1-9]")) {
            distanceFive = distanceFive.add(new BigDecimal(".0" + sizeToString.charAt(sizeToString.length() - 1)));
            size = size.subtract(distanceFive);
        }

        if (sizeToString.matches("\\d+\\.[1-9]?")) {
            distanceThree = distanceThree.add(new BigDecimal("." + sizeToString.charAt(sizeToString.length() - 1)));
            size = size.subtract(distanceThree);
        } else if (sizeToString.matches("\\d+\\.[1-9]\\d")) {
            distanceThree = distanceThree.add(new BigDecimal("." + sizeToString.charAt(sizeToString.length() - 2)));
            size = size.subtract(distanceThree);
        }

        sizeWithDistances.add(size);
        checkDistanceAndAddToList(sizeWithDistances, distanceThree);
        checkDistanceAndAddToList(sizeWithDistances, distanceFive);

        return sizeWithDistances;
    }

    private void checkDistanceAndAddToList(List<BigDecimal> list, BigDecimal distance) {

        if (distance.toString().matches("\\d+.\\d+")) {
            list.add(distance);
        }

    }
}
