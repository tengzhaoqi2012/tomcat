package org.apache.catalina.util;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

/**
 * һ��֧���࣬������ע��ļ����߷���LifecycleEvent֪ͨ
 */
public final class LifecycleSupport {
	/**
	 * ����һ���µ�LifecycleSupport���󣬹����ض���Lifecycle���
	 */
	public LifecycleSupport(Lifecycle lifecycle) {
		super();
		this.lifecycle = lifecycle;
	}

	/**
	 * The source component for lifecycle events that we will fire.
	 */
	private Lifecycle lifecycle = null;

	/**
	 * ע���Lifecycle������ [0]=org.apache.catalina.core.NamingContextListener
	 */
	private LifecycleListener listeners[] = new LifecycleListener[0];

	private final Object listenersLock = new Object(); // Lock object for
														// changes to listeners

	/**
	 * ��������һ��lifecycle�¼�������
	 */
	public void addLifecycleListener(LifecycleListener listener) {
		synchronized (listenersLock) {
			LifecycleListener results[] = new LifecycleListener[listeners.length + 1];
			for (int i = 0; i < listeners.length; i++) {
				results[i] = listeners[i];
			}
			results[listeners.length] = listener;
			listeners = results;
		}
	}

	/**
	 * Get the lifecycle listeners associated with this lifecycle.
	 */
	public LifecycleListener[] findLifecycleListeners() {
		return listeners;
	}

	/**
	 * ֪ͨ���е�lifecycle�¼��������ض����¼������ˡ�
	 * The default implementation performs this notification
	 * synchronously using the calling thread.
	 */
	public void fireLifecycleEvent(String type, Object data) {
		LifecycleEvent event = new LifecycleEvent(lifecycle, type, data);
		LifecycleListener interested[] = listeners;
		for (int i = 0; i < interested.length; i++)
			interested[i].lifecycleEvent(event);
	}

	/**
	 * �Ƴ�һ��lifecycle�¼�������
	 */
	public void removeLifecycleListener(LifecycleListener listener) {
		synchronized (listenersLock) {
			int n = -1;
			for (int i = 0; i < listeners.length; i++) {
				if (listeners[i] == listener) {
					n = i;
					break;
				}
			}
			if (n < 0)
				return;
			LifecycleListener results[] = new LifecycleListener[listeners.length - 1];
			int j = 0;
			for (int i = 0; i < listeners.length; i++) {
				if (i != n)
					results[j++] = listeners[i];
			}
			listeners = results;
		}
	}
}
