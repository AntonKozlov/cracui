package jdk.internal.crac.coresources;

import jdk.internal.crac.priorities.JDKPriorities;

public class AWTCoResource extends JDKCoResource {

    public AWTCoResource() {
        super();
    }

    @Override
    public int getPriority() {
        return JDKPriorities.AWT.ordinal();
    }
}
