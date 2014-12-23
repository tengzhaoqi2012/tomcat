package org.apache.catalina.util;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

/**
 * 一个支持类，帮助向注册的监听者发布LifecycleEvent通知
 */
public final class LifecycleSupport {
	/**
	 * 构造一个新的LifecycleSupport对象，关联特定的Lifecycle组件
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
	 * 注册的Lifecycle监听器 [0]=org.apache.catalina.core.NamingContextListener
	 */
	private LifecycleListener listeners[] = new LifecycleListener[0];

	private final Object listenersLock = new Object(); // Lock object for
														// changes to listeners

	/**
	 * 向组件添加一个lifecycle事件监听器
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
	 * 通知所有的lifecycle事件监听器特定的事件发生了。
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
	 * 移除一个lifecycle事件监听器
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
