package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class CloudStorageSystemTest {
    public static void main(String[] args) {
        String[][] queries = {{"ADD_FILE", "/dir/file1.txt", "10"}, {"FIND_FILE", "/dir", ".txt"}};
        CloudStorageSystem cs = new CloudStorageSystem();
        String[] result = cs.cloudStorage(queries);

        ArraysUtils.printStrArr(result);
    }
}
