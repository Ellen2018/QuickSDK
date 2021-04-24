package com.ellen.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Intent Api封装
 * 发送数据采用链式调用
 */
public class SuperIntent {
    private Intent intent;
    private HashMap<String,Object> objectHashMap;

    private ArrayList<Integer> integerArrayList;
    private String integerArrayListKey;

    private ArrayList<String> stringArrayList;
    private String stringArrayListKey;

    private ArrayList<Parcelable> parcelableArrayList;
    private String parcelableArrayListKey;


    public void startActivity(Context context, Class<? extends Activity> activityClass){
        intent = new Intent(context,activityClass);
        for(String key:objectHashMap.keySet()){
            Object obj = objectHashMap.get(key);
            if(obj instanceof Byte){
                byte value = (byte) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Short){
                short value = (short) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Integer){
                int value = (int) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Long){
                long value = (long) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Float){
                float value = (float) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Double){
                double value = (double) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Character){
                char value = (char) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof String){
                String value = (String) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Boolean){
                boolean value = (boolean) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Parcelable){
                Parcelable value = (Parcelable) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Serializable){
                Serializable value = (Serializable) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Byte[]){
                byte[] value = (byte[]) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Short[]){
                short[] value = (short[]) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Integer[]){
                int[] value = (int[]) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Long[]){
                long[] value = (long[]) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Float[]){
                float[] value = (float[]) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Double[]){
                double[] value = (double[]) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Character[]){
                char[] value = (char[]) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof String[]){
                String[] value = (String[]) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Serializable[]){
                Serializable[] value = (Serializable[]) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Parcelable[]){
                Parcelable[] value = (Parcelable[]) obj;
                intent.putExtra(key,value);
            }else if(obj instanceof Boolean[]){
                boolean[] value = (boolean[]) obj;
                intent.putExtra(key,value);
            }
        }

        //处理ArrayList<String>
        if(stringArrayList != null) {
            intent.putStringArrayListExtra(stringArrayListKey,stringArrayList);
        }

        //处理ArrayList<Integer>
        if(integerArrayList != null){
            intent.putIntegerArrayListExtra(integerArrayListKey,integerArrayList);
        }

        //处理ArrayList<Parcelable>
        if(parcelableArrayList != null) {
            intent.putParcelableArrayListExtra(parcelableArrayListKey,parcelableArrayList);
        }

        //启动界面
        context.startActivity(intent);
    }

    public String getIntegerArrayListKey() {
        return integerArrayListKey;
    }

    public void setIntegerArrayList(String integerArrayListKey,ArrayList<Integer> integerArrayList) {
        this.integerArrayListKey = integerArrayListKey;
        this.integerArrayList = integerArrayList;
    }

    public void setStringArrayList(String stringArrayListKey,ArrayList<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
        this.stringArrayListKey = stringArrayListKey;
    }

    public void setParcelableArrayList(String parcelableArrayListKey,ArrayList<Parcelable> parcelableArrayList) {
        this.parcelableArrayList = parcelableArrayList;
        this.parcelableArrayListKey = parcelableArrayListKey;
    }

    public ArrayList<Integer> getIntegerArrayList() {
        return integerArrayList;
    }

    public HashMap<String, Object> getObjectHashMap() {
        return objectHashMap;
    }

    public void setObjectHashMap(HashMap<String, Object> objectHashMap) {
        this.objectHashMap = objectHashMap;
    }

    public static void main(String[] args) {

    }

    public static class Builder{
        private HashMap<String,Object> objectHashMap;

        private String integerArrayListKey;
        private ArrayList<Integer> integerArrayList;

        private String stringArrayListKey;
        private ArrayList<String> stringArrayList;

        private ArrayList<Parcelable> parcelableArrayList;
        private String parcelableArrayListKey;

        public Builder(){
           objectHashMap = new HashMap<>();
        }

        public <T> Builder  putData(String key,T value){
            objectHashMap.put(key,value);
            return this;
        }

        public Builder putIntegerArrayList(String key,ArrayList<Integer> value){
            this.integerArrayListKey = key;
            this.integerArrayList = value;
            return this;
        }

        public Builder putStringArrayList(String key,ArrayList<String> value){
            this.stringArrayListKey = key;
            this.stringArrayList = value;
            return this;
        }

        public Builder putParcelableArrayList(String key,ArrayList<Parcelable> value){
            this.parcelableArrayListKey = key;
            this.parcelableArrayList = value;
            return this;
        }

        public SuperIntent build(){
            SuperIntent superIntent = new SuperIntent();
            superIntent.setObjectHashMap(objectHashMap);
            if(integerArrayList != null){
                superIntent.setIntegerArrayList(integerArrayListKey,integerArrayList);
            }
            if(stringArrayList != null){
                superIntent.setStringArrayList(stringArrayListKey,stringArrayList);
            }
            if(parcelableArrayList != null){
                superIntent.setParcelableArrayList(parcelableArrayListKey,parcelableArrayList);
            }
            return superIntent;
        }
    }

}
