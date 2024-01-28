package org.wb.Misc.rateLimiter;

public class RequestThread extends Thread{
    private final TokenBucket tb;
    private final int tokens;

    public RequestThread(TokenBucket tb, int tokens) {
        this.tb = tb;
        this.tokens = tokens;
    }
    @Override
    public void run() {
        if(tb.allowRequest(tokens)) {
            System.out.println("request allowed "+Thread.currentThread().getName());
        } else {
            System.out.println("server too busy "+Thread.currentThread().getName());
        }
    }
}
