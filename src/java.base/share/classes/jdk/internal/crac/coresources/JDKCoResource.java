package jdk.internal.crac.coresources;

import jdk.crac.CheckpointException;
import jdk.crac.Context;
import jdk.crac.Resource;
import jdk.crac.RestoreException;
import jdk.internal.crac.JDKContext;
import jdk.internal.crac.JDKResource;

/**
 * Class {@code JDKCoResource} is the JDK context resource.
 * It is used in the top-level {@code JDKContext} as a @code JDKResource}
 * with nested {@code JDKContext}. It means that it has other
 * {@code JDKResource}(s) registered in it. Thus, any subsequences can be ordered.
 *
 * {@code JDKCoResource} are useful to include prioritized subsequences
 * of {@code JDKResource}(s) in a top-level {@code JDKContext}.
 *
 * In {@link jdk.internal.crac.priorities} package {@code JDKResource}
 * and {@code JDKCoResource} priorities are defined.
 *
 * @see     jdk.internal.crac.coresources.JDKCoResource
 * @see     jdk.internal.crac.JDKContext
 * @see     jdk.internal.crac.JDKResource
 */
public abstract class JDKCoResource extends JDKContext implements JDKResource {

    protected JDKCoResource() {
        super();
    }

    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws CheckpointException {
        super.beforeCheckpoint(this);
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws RestoreException {
        super.afterRestore(this);
    }
}
