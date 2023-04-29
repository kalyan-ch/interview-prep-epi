package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.*;

public class AccountsMerge {
    static class DSU {
        int[] rep;
        int[] size;

        public DSU(int size) {
            this.size = new int[size];
            this.rep = new int[size];

            for(int i = 0; i < size; i++){
                // size of all groups is 1
                this.size[i] = 1;

                //each group is its own representative
                this.rep[i] = i;
            }
        }

        public int findRep(int x){
            if(x == rep[x]) {
                return x;
            }

            //path compression
            return rep[x] = findRep(rep[x]);
        }

        public void unionBySize(int a, int b) {
            int repA = findRep(a);
            int repB = findRep(b);

            if(repA == repB){
                return;
            }

            if(size[repA] >= size[repB]) {
                size[repA] += size[repB];
                rep[repB] = repA;
            } else {
                size[repB] += size[repA];
                rep[repA] = repB;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"), Arrays.asList("John","johnsmith@mail.com","john00@mail.com"), Arrays.asList("Mary","mary@mail.com"), Arrays.asList("John","johnnybravo@mail.com"));

        List<List<String>> mergedAccounts = accountsMerge(accounts);
        for(List<String> acc: mergedAccounts){
            ArraysUtils.printStrList(acc);
        }

    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        // email to component index
        Map<String, Integer> emailGroup = new HashMap<>();
        DSU dsu = new DSU(n);

        for(int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);

            for(int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);

                if(emailGroup.containsKey(email)){
                    dsu.unionBySize(i, emailGroup.get(email));
                } else {
                    emailGroup.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> components = new HashMap<>();
        for (String email: emailGroup.keySet()) {
            int group = emailGroup.get(email);
            int groupRep = dsu.findRep(group);

            List<String> emails = components.getOrDefault(groupRep, new ArrayList<>());
            emails.add(email);
            components.put(groupRep, emails);
        }

        List<List<String>> result = new ArrayList<>();

        for (int group: components.keySet()) {
            List<String> emails = components.get(group);
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(group).get(0));
            account.addAll(emails);
            result.add(account);
        }

        return result;

    }
}
