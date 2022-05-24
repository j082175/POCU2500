package academy.pocu.comp2500.lab4;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemoryCache {
    //private static HashMap<Integer, MemoryCache> instance = new HashMap<>();
    private static ArrayList<MemoryCache> instance = new ArrayList<>();

    private static int createdOrder = 0;
    private static int maxInstanceCount = 1;
    private int maxEntryCount = 10;

    public String name;

    private HashMap<String, String> keyValue = new HashMap<>();

    private static EvictionPolicy policy = EvictionPolicy.LEAST_RECENTLY_USED;



    private OffsetDateTime revisedTime;

    private MemoryCache(String name) {

        createdOrder++;
        this.name = name;
        revisedTime = OffsetDateTime.now();
    }

    public static MemoryCache getInstance(String hardDiskName) {

        // 지정된 하드디스크 전용 인스턴스가 존재할때

        for (int i = 0; i < instance.size(); i++) {
            if (instance.get(i).name.equals(hardDiskName)) {
                return instance.get(i);
            }
        }

        // 지정된 하드디스크 전용 인스턴스가 존재하지 않을때

        if (createdOrder < maxInstanceCount) {
            instance.add(new MemoryCache(hardDiskName));
            //instance.put(createdOrder, new MemoryCache(hardDiskName));
        } else if (createdOrder >= maxInstanceCount && instance.size() > 2) {
            int index = 0;
            int min = instance.get(0).revisedTime.getNano();
            for (int i = 1; i < instance.size(); i++) {
                if (min > instance.get(i).revisedTime.getNano()) {
                    min = instance.get(i).revisedTime.getNano();
                    index = i;
                }
            }
            // 제일 안쓰인놈 지우기
            createdOrder--;
            instance.remove(index);

            // 새로 만들어주기
            instance.add(new MemoryCache(hardDiskName));

            // lru에 기초하여 초과분 제거
            // switch (policy) {
            //     case FIRST_IN_FIRST_OUT:

            //         break;
            //     case LAST_IN_FIRST_OUT:

            //         break;
            //     case LEAST_RECENTLY_USED:
            //         int index = 0;
            //         int min = instance.get(0).revisedTime.getNano();
            //         for (int i = 1; i < instance.size(); i++) {
            //             if (min > instance.get(i).revisedTime.getNano()) {
            //                 min = instance.get(i).revisedTime.getNano();
            //                 index = i;
                            
            //             }
            //         }
            //         createdOrder--;
            //         instance.get(index).name = null;
            //         instance.remove(index);
            //         break;
            //     default:
            //         break;
            // }
        }
        return instance.get(createdOrder - 1);
    }

    public static void clear() {
        for (int i = 0; i < instance.size(); i++) {
            instance.set(i, null);
        }
        createdOrder = 0;
    }

    public static void setMaxInstanceCount(int count) {
        maxInstanceCount = count;
    }

    public void setEvictionPolicy(EvictionPolicy e) {
        policy = e;
        revisedTime = OffsetDateTime.now();
    }

    public void addEntry(String key, String value) {
        if (this.keyValue.get(key).equals(key)) {
            this.keyValue.put(key, value);
        } else if (keyValue.size() < maxEntryCount) {
            this.keyValue.put(key, value);
        }
        revisedTime = OffsetDateTime.now();
    }

    public String getEntryOrNull(String key) {
        revisedTime = OffsetDateTime.now();
        return this.keyValue.get(key);
        
    }

    public void setMaxEntryCount(int count) {
        this.maxEntryCount = count;
        revisedTime = OffsetDateTime.now();
    }

}
