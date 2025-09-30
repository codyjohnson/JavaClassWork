package Sep_29_2025;

public class DifficultProblemNumberTwo {

        public static void main(String[] args) {
            int target = 15;
            int[] array = {1, 2};

            int result = countPossibilities(array, target);
            System.out.println(result);
        }

        public static int countPossibilities(int[] array, int target) {
            int arrayLength = array.length;
            int[][] resultArray = new int[arrayLength + 1][target + 1];

            for (int i = 0; i <= arrayLength; i++) {
                resultArray[i][0] = 1;
            }

            for (int i = 1; i <= arrayLength; i++) {
                int value = array[i - 1];
                for (int j = 0; j <= target; j++) {
                    resultArray[i][j] = resultArray[i - 1][j];
                    if (j >= value) {
                        resultArray[i][j] += resultArray[i][j - value];
                    }
                }
            }
            return resultArray[arrayLength][target];
        }
    }