package org.wb.leetcode.medium;

import java.util.Stack;

public class BrowserHistory {
    Stack<String> backStack;
    Stack<String> fwdStack;

    String currPage;

    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        currPage = homepage;

        fwdStack = new Stack<>();
    }

    public void visit(String url) {
        backStack.push(currPage);
        currPage = url;
        fwdStack.clear();
    }

    public String back(int steps) {
        int bound = Math.min(steps, backStack.size()), i = 0;

        while(i < bound){
            fwdStack.push(currPage);
            currPage = backStack.pop();
            i++;
        }

        return currPage;
    }

    public String forward(int steps) {
        int bound = Math.min(steps, fwdStack.size()), i = 0;

        while(i < bound){
            backStack.push(currPage);
            currPage = fwdStack.pop();
            i++;
        }
        return currPage;
    }
}
