package org.apache.catalina;

import java.util.EventObject;
/**
 * 定义了一个生命周期事件
 */
public final class LifecycleEvent extends EventObject {
    public LifecycleEvent(Lifecycle lifecycle, String type) {
        this(lifecycle, type, null);
    }
    
    public LifecycleEvent(Lifecycle lifecycle, String type, Object data) {
        super(lifecycle);
        this.lifecycle = lifecycle;
        this.type = type;
        this.data = data;
    }

    private Object data = null;
    private Lifecycle lifecycle = null;
    private String type = null;
    
    public Object getData() {
        return (this.data);
    }

    public Lifecycle getLifecycle() {
        return (this.lifecycle);
    }

    public String getType() {
        return (this.type);
    }
}
