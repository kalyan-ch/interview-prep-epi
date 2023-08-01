package org.wb.Misc.metaPrep;

public class ReverseToEqual {
    public static void main(String[] args) {
        int[] array_a_1 = {1, 2, 3, 7, 9, 4};
        int[] array_b_1 = {1, 3, 2, 3, 9, 7};
        System.out.println(areTheyEqual(array_a_1, array_b_1));
    }

    public static boolean areTheyEqual(int[] array_a, int[] array_b) {
        int i = 0, j = 0;

        while(i < array_a.length && j < array_b.length) {
            if(array_a[i] == array_b[j]) {
                i++; j++;
            } else {
                int k = 0, temp = 0, temp_i = i;
                for(k = j + 1; k < array_b.length; k++) {
                    if (array_a[i] == array_b[k]) {
                        temp = k;
                        break;
                    }
                }

                if(k >= array_a.length) {
                    return false;
                }

                while(k >= temp_i) {
                    if(array_a[i++] != array_b[k--]) {
                        return false;
                    }
                }

                i = temp + 1;
                j = i;
            }
        }

        return true;
    }
}
