package com.kt.spi;

import com.kt.libinterface.LDisplay;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author: dr
 * @Data: 2020/3/18
 */
public class DisplayFactory {
    private static DisplayFactory mDisplayFactory;

    private Iterator<LDisplay> mIterator;

    private DisplayFactory() {
        ServiceLoader<LDisplay> loader = ServiceLoader.load(LDisplay.class);
        mIterator = loader.iterator();
    }

    static DisplayFactory getSingleton() {
        if (null == mDisplayFactory) {
            synchronized (DisplayFactory.class) {
                if (null == mDisplayFactory) {
                    mDisplayFactory = new DisplayFactory();
                }
            }
        }
        return mDisplayFactory;
    }

    LDisplay getDisplay() {
        return mIterator.next();
    }

    boolean hasNextDisplay() {
        return mIterator.hasNext();
    }
}
