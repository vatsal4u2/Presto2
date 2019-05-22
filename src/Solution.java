public class Solution {

    public int solution(int[] cars, int X, int Y, int Z) {
        int maxT = 0, carCount = 0;
        int minCarTimeInGas;
        int carInA = 0;
        int carInB = 0;
        int carInC = 0;

        while (carCount < cars.length) {
            if (carInA != 0 && carInB != 0 && carInC != 0) {
                minCarTimeInGas = getMin(carInA, carInB, carInC);
                carInA = carInA - minCarTimeInGas;
                carInB = carInB - minCarTimeInGas;
                carInC = carInC - minCarTimeInGas;
                X = X - minCarTimeInGas;
                Y = Y - minCarTimeInGas;
                Z = Z - minCarTimeInGas;
                if (minCarTimeInGas > maxT) {
                    maxT = minCarTimeInGas;
                }

            }

            if (carInA == 0) {
                if (cars[carCount] <= X) {
                    carInA = cars[carCount++];
                    continue;
                } else
                    return -1;

            } else if (carInB == 0) {
                if (cars[carCount] <= Y) {
                    carInB = cars[carCount++];
                    continue;
                } else
                    return -1;
            } else if (carInC == 0) {
                if (cars[carCount] <= Z) {
                    carInC = cars[carCount++];
                    continue;
                } else
                    return -1;
            }

        }
        return maxT;
    }


    private int getMin(int carInA, int carInB, int carInC) {
        int minCarT;
        if (carInA < carInB) {
            minCarT = carInA;
        } else {
            minCarT = carInB;
        }
        if (minCarT > carInC) {
            minCarT = carInC;
        }
        return minCarT;
    }



}