package jdk.internal.crac.priorities;

public enum X11Priorities {
    /**
     * Priority of the
     * sun.awt.X11.XRootWindow static resource
     */
    XROOTWINDOW,
    /**
     * Priority of the
     * sun.awt.X11.XWindow static resource
     */
    XWINDOW,
    /**
     * Priority of the
     * sun.awt.X11.XBaseWindow static resource
     */
    XBASEWINDOW,
    /**
     * Priority of the
     * sun.awt.X11.XGlobalCursorManager
     * static resource
     */
    XCURSORMANAGER,
    /**
     * Priority of the
     * sun.awt.X11.XWM static resource
     */
    XWM,
    /**
     * Priority of the
     * sun.awt.X11.XAtom static resource
     */
    XATOM,
    /**
     * Priority of the
     * sun.awt.X11.XToolkit static resource
     */
    XTOOLKIT,
}
