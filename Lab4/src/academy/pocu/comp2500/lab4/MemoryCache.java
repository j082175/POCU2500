package academy.pocu.comp2500.lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemoryCache {
    private static HashMap<Integer, MemoryCache> instance = new HashMap<>();
    private static int createdOrder = 0;
    private static int maxInstanceCount = 10;
    private int maxEntryCount = 10;

    public String name;

    private HashMap<String, String> keyValue = new HashMap<>();

    private static EvictionPolicy policy = EvictionPolicy.LEAST_RECENTLY_USED;

    private int revisedTime;

    private MemoryCache(String name) {

        createdOrder++;
        this.name = name;
    }

    public static MemoryCache getInstance(String hardDiskName) {
        if (instance.get(createdOrder) == null || createdOrder < maxInstanceCount) {
            instance.put(createdOrder, new MemoryCache(hardDiskName));
        } else if (createdOrder >= maxInstanceCount) {
            // lru에 기초하여 초과분 제거
            switch (policy) {
                case FIRST_IN_FIRST_OUT:
                    
                    break;
                case LAST_IN_FIRST_OUT:

                    break;
                case LEAST_RECENTLY_USED:

                    break;
                default:
                    break;
            }
        }

        return instance.get(createdOrder - 1);
    }

    public static void clear() {
        for (int i = 0; i < createdOrder; i++) {
            instance.get(i).instance.remove(i);
        }
        createdOrder = 0;
    }

    public static void setMaxInstanceCount(int count) {
        maxInstanceCount = count;
    }

    public void setEvictionPolicy(EvictionPolicy e) {
        policy = e;
    }

    public void addEntry(String key, String value) {
        if (this.keyValue.get(key).equals(key)) {
            this.keyValue.put(key, value);
        } else if (keyValue.size() < maxEntryCount) {
            this.keyValue.put(key, value);
        }
    }

    public String getEntryOrNull(String key) {
        return this.keyValue.get(key);
    }

    public void setMaxEntryCount(int count) {
        this.maxEntryCount = count;
    }

}
