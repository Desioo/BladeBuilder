package com.example.bladebuilder.model.calculate;

import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Knife implements CenterCalculator, SizeToDistanceMapper, DimensionToTopAndBottomListMapper {
    private static final BigDecimal FULL_SHAFT_SIZE = new BigDecimal("1740");
    private static final BigDecimal CENTER_DIVIDER = new BigDecimal("2");
    private static final BigDecimal DOUBLE = new BigDecimal("2");
    private static final BigDecimal KNIFE_CORRECTION = new BigDecimal("0.04");
    private static final BigDecimal TEN_PERCENT = new BigDecimal("0.1");

    private BigDecimal distanceThree;
    private BigDecimal distanceFive;

    private final MeasurementRequestDTO measurementRequestDTO;
    @Getter
    private List<BigDecimal> centerTop;
    @Getter
    private BigDecimal centerBottom;
    @Getter
    private List<List<BigDecimal>> topSizesList = new ArrayList<>();
    @Getter
    private List<List<BigDecimal>> bottomSizesList = new ArrayList<>();

    @Override
    public void countCenter2() {

        centerBottom = FULL_SHAFT_SIZE.subtract(measurementRequestDTO.getFullSize())
                .divide(CENTER_DIVIDER, 0, RoundingMode.HALF_EVEN);

    }

    @Override
    public void countCenter1() {

        BigDecimal result = centerBottom.subtract(measurementRequestDTO.getKnivesSize())
                .subtract(measurementRequestDTO.getThickness().multiply(TEN_PERCENT))
                .subtract(KNIFE_CORRECTION)
                .setScale(2, RoundingMode.HALF_EVEN).stripTrailingZeros();

        centerTop = mapSizeToDistance(result);

    }

    @Override
    public List<BigDecimal> mapSizeToDistance(BigDecimal size) {

        distanceThree = new BigDecimal("3");
        distanceFive = new BigDecimal("5");

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

    @Override
    public void mapDimensionsToTopAndBottomByRepeating() {

        int index = 0;

        for (Dimension dimension : measurementRequestDTO.getDimensionsList()) {

            int quantity = Integer.parseInt(String.valueOf(dimension.getQuantity()));

            for (int i = 0; i < quantity; i++) {

                if (index % 2 == 0) {
                    topSizesList.add(mapSizeToDistance(dimension.getSize()));
                    bottomSizesList.add(mapSizeToDistance(subtractKnifeAndThicknessFromSize(dimension.getSize())));
                } else {
                    bottomSizesList.add(mapSizeToDistance(dimension.getSize()));
                    topSizesList.add(mapSizeToDistance(subtractKnifeAndThicknessFromSize(dimension.getSize())));
                }

                index++;

            }
        }
    }

    @Override
    public BigDecimal subtractKnifeAndThicknessFromSize(BigDecimal size) {

        return size.subtract(DOUBLE.multiply(measurementRequestDTO.getKnivesSize()))
                .subtract(measurementRequestDTO.getThickness().multiply(TEN_PERCENT).multiply(DOUBLE));

    }
}
