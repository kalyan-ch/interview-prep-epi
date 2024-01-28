package org.wb.Misc.rateLimiter;

public class TokenBucket {

    private long maxBucketSize;
    private long refillRate;
    private long lastRefillTimeStamp;
    private double currentBucketSize;

    public TokenBucket(long maxBucketSize, long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;

        this.currentBucketSize = maxBucketSize;
        this.lastRefillTimeStamp = System.currentTimeMillis();
    }

    // synchronized to remove race conditions between threads
    public synchronized boolean allowRequest(int tokens) {
        refill();
        if(currentBucketSize > tokens) {
            currentBucketSize -= tokens;
            return true;
        }

        return false;
    }

    public void refill() {
        long now = System.currentTimeMillis();
        double tokensToAdd = (now - lastRefillTimeStamp) * refillRate / 1e9;
        currentBucketSize = Math.min(currentBucketSize + tokensToAdd, maxBucketSize);
        lastRefillTimeStamp = now;
    }

}
