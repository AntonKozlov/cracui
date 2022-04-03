package jdk.internal.crac.coresources;

import jdk.internal.crac.priorities.JDKPriorities;

public class X11GECoResource extends JDKCoResource {

    public X11GECoResource() {
        super();
    }

    @Override
    public int getPriority() {
        return JDKPriorities.X11GE.ordinal();
    }
}
