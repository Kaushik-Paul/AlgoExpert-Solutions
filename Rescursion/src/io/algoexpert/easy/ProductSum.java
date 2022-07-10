package io.algoexpert.easy;


public class ProductSum {

    public int sum(Object[] arr, int multiplier) {
        int sum = 0;
        for (Object element : arr) {
            if (element instanceof Object[]) {
                sum += sum((Object[]) element, multiplier + 1);
            }
            if (element instanceof Integer) {
                sum += (Integer) element;
            }
        }
        return sum * multiplier;
    }

    public static void main(String[] args) {
        Integer[][][][] array = { { { { 1, 2, 3
        }, { 4, 5, 6
        }, { 7, 8, 9
        }
        }, { { 10, 11, 12,
        }, { 13, 14, 15
        }, { 16, 17, 19
        }
        }
        }, { { { 20, 21, 22
        }, { 23, 24, 25
        }
        }
        }
        };
        ProductSum productSum = new ProductSum();
        int sum = productSum.sum(array, 0);
        System.out.println(sum);
    }

}
