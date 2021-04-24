package com.ellen.sdk;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

/**
 * 解决由非静态Handler带来的内存泄漏问题
 * @param <T>
 */
public class SuperHandler<T extends Activity> extends Handler {
    private WeakReference<T> activityWeakReference;
    private HandlerMessageCallback handlerMessageCallback;

    public SuperHandler(T activity){
        activityWeakReference = new WeakReference<>(activity);
    }

    public T getActivity(){
        return activityWeakReference.get();
    }

    public void setHandlerMessageCallback(HandlerMessageCallback handlerMessageCallback) {
        this.handlerMessageCallback = handlerMessageCallback;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        handlerMessageCallback.handleMessage(getActivity(),msg);
    }

    public interface HandlerMessageCallback<T extends Activity>{
        void  handleMessage(T activity,@NonNull Message msg);
    }
}
