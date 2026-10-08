package com.codinghero.interview.tiktok;

public class MultipleRequestAccessSharedObjects {
/**
 * api system
 * multiple requests access multiple shared objects
 * performance
 */
    // hostA thread1 , hostB thread2
    // access resource X
    // xLock (Redis) setnx
    // each thread, lock(xLock)
    // queue, lock, compare and set
    // very fast ,

    // CAS atomic
}
