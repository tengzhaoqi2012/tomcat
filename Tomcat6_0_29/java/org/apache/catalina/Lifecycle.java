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
     * ��������һ��Lifecycle�¼�������
     */
    public void addLifecycleListener(LifecycleListener listener);

    /**
     * ��ȡ��������е�lifecycle������ 
     */
    public LifecycleListener[] findLifecycleListeners();

    /**
     * ������Ƴ�һ��Lifecycle�¼�������
     */
    public void removeLifecycleListener(LifecycleListener listener);

    /**
     * Prepare for the beginning of active use of the public methods of this
     * component.
     * �÷���Ӧ�������еĹ�������ʹ��ǰ������
     * �ᷢ��һ��START_EVENT��Lifecycle�¼������еļ�����
     */
    public void start() throws LifecycleException;

    /**
     * Gracefully terminate the active use of the public methods of this
     * component.  This method should be the last one called on a given
     * instance of this component.  
     * �ᷢ��һ��STOP_EVENT��Lifecycle�¼������еļ�����
     */
    public void stop() throws LifecycleException;
}
