package sun.java2d;

import java.lang.ref.ReferenceQueue;

import jdk.crac.CheckpointException;
import jdk.crac.Context;
import jdk.crac.Resource;
import jdk.crac.RestoreException;
import jdk.internal.crac.JDKResource;

/**
 * Reference queue extension for Java2D Disposer, to which registered reference objects
 * are appended by the garbage collector after the appropriate reachability changes are detected.
 *
 * @see     java.lang.ref.ReferenceQueue
 * @author  Ilya Kuznetsov
 */
public class DisposerQueue extends ReferenceQueue<Object> {
    private final JDKResource jdkResource = new JDKResource() {
        @Override
        public int getPriority() {
            return 0;
        }

        @Override
        public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
            System.gc();
            Thread.sleep(10000);
            while (!checkEmptiness()) {
                System.gc();
                Thread.sleep(100);
            }
        }

        @Override
        public void afterRestore(Context<? extends Resource> context) throws Exception {
            if (!checkEmptiness()) {
                throw new RestoreException();
            }
        }
    };

    public DisposerQueue() {
        jdk.internal.crac.Core.getJDKContext().register(jdkResource);
    }

    /**
     * @return boolean
     */
    private boolean checkEmptiness() {
        synchronized (lock)
        {
            return queueLength == 0;
        }
    }
}
