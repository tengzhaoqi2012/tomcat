package org.apache.catalina;
/**
 * Common interface for component life cycle methods.  Catalina components
 * may, but are not required to, implement this interface (as well as the
 * appropriate interface(s) for the functionality they support) in order to
 * provide a consistent mechanism to start and stop the component.
 */
public interface Lifecycle {
    public static final String INIT_EVENT = "init";
    public static final String START_EVENT = "start";
    public static final String BEFORE_START_EVENT = "before_start";
    public static final String AFTER_START_EVENT = "after_start";
    public static final String STOP_EVENT = "stop";
    public static final String BEFORE_STOP_EVENT = "before_stop";
    public static final String AFTER_STOP_EVENT = "after_stop";
    public static final String DESTROY_EVENT = "destroy";
    public static final String PERIODIC_EVENT = "periodic";

    /**
     * 将组件添加一个Lifecycle事件监听器
     */
    public void addLifecycleListener(LifecycleListener listener);

    /**
     * 获取组件的所有的lifecycle监听器 
     */
    public LifecycleListener[] findLifecycleListeners();

    /**
     * 从组件移除一个Lifecycle事件监听器
     */
    public void removeLifecycleListener(LifecycleListener listener);

    /**
     * Prepare for the beginning of active use of the public methods of this
     * component.
     * 该方法应该在所有的公共方法使用前被调用
     * 会发布一个START_EVENT的Lifecycle事件给所有的监听者
     */
    public void start() throws LifecycleException;

    /**
     * Gracefully terminate the active use of the public methods of this
     * component.  This method should be the last one called on a given
     * instance of this component.  
     * 会发布一个STOP_EVENT的Lifecycle事件给所有的监听者
     */
    public void stop() throws LifecycleException;
}
