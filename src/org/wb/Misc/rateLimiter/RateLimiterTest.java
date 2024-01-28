package org.wb.Misc.rateLimiter;

public class RateLimiterTest {
    public static void main(String[] args) {
        TokenBucket tb = new TokenBucket(10, 20);

        for (int i = 0; i < 10; i++) {
            RequestThread thread = new RequestThread(tb, 2);
            thread.setName("thread "+i);
            thread.start();
        }
    }
}
