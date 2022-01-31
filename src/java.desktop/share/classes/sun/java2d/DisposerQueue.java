//package sun.java2d;
//
//import java.lang.ref.ReferenceQueue;
//
//import jdk.crac.Context;
//import jdk.crac.Resource;
//import jdk.crac.RestoreException;
//import jdk.internal.crac.JDKResource;
//
///**
// * ReferenceQueue extension for Java2D Disposer, to which registered reference objects
// * are appended by the garbage collector after the appropriate reachability changes are detected.
// *
// * @see     java.lang.ref.ReferenceQueue
// * @author  Ilya Kuznetsov
// */
//
//public class DisposerQueue extends ReferenceQueue<Object> implements JDKResource {
//
//    public DisposerQueue() {
//        jdk.internal.crac.Core.getJDKContext().register(this);
//    }
//
//    @Override
//    public int getPriority() {
//        return 1;
//    }
//
//    @Override
//    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
//        System.out.println("[" + Thread.currentThread().getName() + "] " + "GC1!");
//        System.gc();
//        System.out.println("[" + Thread.currentThread().getName() + "] " + "Sleep1 10000!");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException ignore) {
//        }
//        while (!checkEmptiness()) {
//            System.gc();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ignore) {
//            }
//        }
//    }
//
//    @Override
//    public void afterRestore(Context<? extends Resource> context) throws Exception {
//        if (!checkEmptiness()) {
//            throw new RestoreException();
//        }
//    }
//
//    /**
//     * @return boolean
//     */
//    private boolean checkEmptiness() {
//        synchronized (lock)
//        {
//            System.out.println("[" + Thread.currentThread().getName() + "] " + "DisposerQueue length in check: " + queueLength);
//            return queueLength == 0;
//        }
//    }
//}
