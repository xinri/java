import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

class Triangle {

    private double side1;
    private double side2;
    private double side3;
    private int uniqueSides;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        if (allSidesAreZero() || hasImpossibleSides() || violatesTriangleInequality()) {
            throw new TriangleException();
        }

        this.uniqueSides = getNumberOfUniqueSides();
    }

    boolean isEquilateral() {
        return uniqueSides == 1;
    }

    boolean isIsosceles() {
        return (uniqueSides == 2 || isEquilateral());
    }

    boolean isScalene() {
        return uniqueSides == 3;
    }

    private boolean allSidesAreZero() {
        return side1 == 0 && side2 == 0 && side3 == 0;
    }

    private boolean hasImpossibleSides() {
        return side1 < 0 || side2 < 0 || side3 < 0;
    }

    private boolean violatesTriangleInequality() {
        BigDecimal bdSide1 = BigDecimal.valueOf(side1);
        BigDecimal bdSide2 = BigDecimal.valueOf(side2);
        BigDecimal bdSide3 = BigDecimal.valueOf(side3);

        return bdSide1.add(bdSide2).compareTo(bdSide3) <= 0 ||
            bdSide1.add(bdSide3).compareTo(bdSide2) <= 0 ||
            bdSide2.add(bdSide3).compareTo(bdSide1) <= 0;
    }

    private int getNumberOfUniqueSides() {
        Set<Double> sides = new HashSet<>();

        sides.add(side1);
        sides.add(side2);
        sides.add(side3);

        return sides.size();
    }

}
