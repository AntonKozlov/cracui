package jdk.internal.crac.priorities;

/**
 * {@code JDKResource} priorities.
 *
 * Priorities are defined in the order from lowest to highest.
 * Most resources should use priority NORMAL (the lowest priority).
 * Other priorities define sequence of checkpoint notification
 * for dependent resources.
 *
 * Checkpoint notification will be processed in the order from the lowest
 * to the highest priorities.
 * Restore notification will be processed in the revers order:
 * from the highest to the lowest priorities.
 *
 * JDK resources with the same priority will be notified about checkpoint
 * in the reverse order of registration.
 * JDK resources with the same priority will be notified about restore
 * in the direct order of registration.
 */
public enum JDKPriorities {

    /* Keep next priorities first to reinitialize
    AWT and X11 resources correctly */

    AWT,
    X11,


    /* Use this priority in most cases. */

    /**
     * Most resources should use this option.
     */
    NORMAL,


    /**
     * Priority of the
     * sun.nio.ch.EPollSelectorImpl resource
     */
    EPOLLSELECTOR,
    /**
     * Priority of the
     * sun.security.provider.NativePRNG resource
     */
    NATIVE_PRNG,
    /**
     * Priority of the
     * sun.security.provider.SecureRandom resource
     */
    SECURE_RANDOM,
    /**
     * Priority of the
     * sun.security.provider.SecureRandom.SeederHolder resource
     */
    SEEDER_HOLDER,


    /* Keep next priorities here to ensure handling of pending References
     * appeared on earlier priorities. */

    /**
     * Priority of the
     * java.lan.ref.Reference static resource
     */
    REFERENCE_HANDLER,
    /**
     * Priority of the
     * sun.java2d.Disposer resources
     */
    DISPOSERS,
    /**
     * Priority of the
     * jdk.internal.ref.CleanerImpl resources
     */
    CLEANERS,


    /* Keep next priority last to reinitialize
    X11 connection correctly */

    X11GE
}