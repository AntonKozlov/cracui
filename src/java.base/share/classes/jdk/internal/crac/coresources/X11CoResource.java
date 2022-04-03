package jdk.internal.crac.coresources;

import jdk.internal.crac.priorities.JDKPriorities;

public class X11CoResource extends JDKCoResource {

    public X11CoResource() {
        super();
    }

    @Override
    public int getPriority() {
        return JDKPriorities.X11.ordinal();
    }
}
