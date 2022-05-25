package academy.pocu.comp2500.lab4;

import java.time.OffsetDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import javax.swing.text.Keymap;

public class MemoryCache {
    
    private static int createdOrder = 0;
    
    private static int maxInstanceCount = 10;
    private int maxEntryCount = 10;
    
    private int createdCount;
    private static int addCount = 0;

    
    private static TreeMap<String, MemoryCache> instance = new TreeMap<>();
    // private static ArrayList<MemoryCache> instance = new ArrayList<>();
    private static ArrayList<String> instanceManagerLRU = new ArrayList<>();
    private static ArrayList<String> instanceManagerFIFO = new ArrayList<>();
    private static ArrayList<String> instanceManagerLIFO = new ArrayList<>();

    private TreeMap<String, String> keyValue = new TreeMap<>();
    private ArrayList<String> keyValueManagerLRU = new ArrayList<>();
    private ArrayList<String> keyValueManagerFIFO = new ArrayList<>();
    private ArrayList<String> keyValueManagerLIFO = new ArrayList<>();

    private static EvictionPolicy policy = EvictionPolicy.LEAST_RECENTLY_USED;

    private OffsetDateTime revisedTime;

    private MemoryCache() {
        addCount++;
        createdOrder++;
        revisedTime = OffsetDateTime.now();
        createdCount = addCount;
    }

    public static MemoryCache getInstance(String hardDiskName) {

        // 지정된 하드디스크 전용 인스턴스가 존재할때

        if (instance.containsKey(hardDiskName)) {
            instance.get(hardDiskName).revisedTime = OffsetDateTime.now();
            instance.get(hardDiskName).createdCount = addCount;
            return instance.get(hardDiskName);
        }

        // 지정된 하드디스크 전용 인스턴스가 존재하지 않을때

        if (createdOrder < maxInstanceCount) {
            instance.put(hardDiskName, new MemoryCache());
            instanceManagerLRU.add(hardDiskName);
            instanceManagerFIFO.add(hardDiskName);
            instanceManagerLIFO.add(hardDiskName);
            // instance.put(createdOrder, new MemoryCache(hardDiskName));
        } else if (createdOrder >= maxInstanceCount && instance.size() > 2) {

            int index = 0;
                    int min = instance.get(instanceManagerLRU.get(0)).createdCount;
                    for (int i = 1; i < instance.size(); i++) {
                        if (min > instance.get(instanceManagerLRU.get(i)).createdCount) {
                            min = instance.get(instanceManagerLRU.get(i)).createdCount;
                            index = i;
                        }
                    }
                    // 제일 안쓰인놈 지우기
                    createdOrder--;
                    instance.remove(instanceManagerLRU.get(index));

                    instanceManagerLRU.remove(index);

                    // 새로 만들어주기
                    instance.put(hardDiskName, new MemoryCache());

                    instanceManagerLRU.add(index, hardDiskName);

                    ////////////////////////////////////////////////////////////////////
                    for (int i = 0; i < instanceManagerFIFO.size(); i++) {
                        if (instanceManagerFIFO.get(i).equals(instanceManagerLRU.get(index))) {
                            instanceManagerFIFO.remove(i);
                            break;
                        }
                    }
                    instanceManagerFIFO.add(hardDiskName);

                    for (int i = 0; i < instanceManagerLIFO.size(); i++) {
                        if (instanceManagerLIFO.get(i).equals(instanceManagerLRU.get(index))) {
                            instanceManagerLIFO.remove(i);
                            break;
                        }
                    }
                    instanceManagerLIFO.add(hardDiskName);
                    ////////////////////////////////////////////////////////////////////

        }
        return instance.get(hardDiskName);
    }

    public static void clear() {
        instance.clear();
        instanceManagerFIFO.clear();
        instanceManagerLIFO.clear();
        instanceManagerLRU.clear();

    }

    public static void setMaxInstanceCount(int count) {
        maxInstanceCount = count;

        while (instance.size() > maxInstanceCount) { // = 추가
            // lru에 기초하여 초과분 제거
            switch (policy) {
                case FIRST_IN_FIRST_OUT:
                    instance.remove(instanceManagerFIFO.get(0));
                    instanceManagerFIFO.remove(0);
                    break;
                case LAST_IN_FIRST_OUT:
                    instance.remove(instanceManagerLIFO.get(instanceManagerLIFO.size() - 1));
                    instanceManagerLIFO.remove(instanceManagerLIFO.size() - 1);
                    break;
                case LEAST_RECENTLY_USED:
                    // 제일 안쓰인놈 지우기
                    instance.remove(instanceManagerLRU.get(instanceManagerLRU.size() - 1));
                    instanceManagerLRU.remove(instanceManagerLRU.size() - 1);
                    break;
                default:
                    break;
            }
        }
    }

    public void setMaxEntryCount(int count) {
        this.maxEntryCount = count;
        revisedTime = OffsetDateTime.now();
        createdCount = addCount;

        int count1 = keyValue.size();
        while (count1 > maxEntryCount) { // = 추가
            // lru에 기초하여 초과분 제거
            String backup = null;
            switch (policy) {
                case FIRST_IN_FIRST_OUT:
                    keyValue.remove(keyValueManagerFIFO.get(keyValueManagerFIFO.size() - 1));
                    backup = keyValueManagerFIFO.get(keyValueManagerFIFO.size() - 1);
                    keyValueManagerFIFO.remove(keyValueManagerFIFO.size() - 1);

                    /////////////////////////////////////////////////////////////////////
                    for (int i = 0; i < keyValueManagerLRU.size(); i++) {
                        if (backup.equals(keyValueManagerLRU.get(i))) {
                            keyValueManagerLRU.remove(i);
                        }
                    }

                    for (int i = 0; i < keyValueManagerLIFO.size(); i++) {
                        if (backup.equals(keyValueManagerLIFO.get(i))) {
                            keyValueManagerLIFO.remove(i);
                        }
                    }

                    /////////////////////////////////////////////////////////////////////
                    count1--;
                    break;
                case LAST_IN_FIRST_OUT:
                    keyValue.remove(keyValueManagerLIFO.get(0));
                    backup = keyValueManagerLIFO.get(0);
                    keyValueManagerLIFO.remove(0);

                    /////////////////////////////////////////////////////////////////////
                    for (int i = 0; i < keyValueManagerFIFO.size(); i++) {
                        if (backup.equals(keyValueManagerFIFO.get(i))) {
                            keyValueManagerLRU.remove(i);
                        }
                    }


                    for (int i = 0; i < keyValueManagerLRU.size(); i++) {
                        if (backup.equals(keyValueManagerLRU.get(i))) {
                            keyValueManagerLRU.remove(i);
                        }
                    }

                    /////////////////////////////////////////////////////////////////////
                    count1--;
                    break;
                case LEAST_RECENTLY_USED:
                    // 제일 안쓰인놈 지우기
                    keyValue.remove(keyValueManagerLRU.get(keyValue.size() - 1));
                    backup = keyValueManagerLRU.get(keyValueManagerLRU.size() - 1);
                    keyValueManagerLRU.remove(keyValueManagerLRU.size() - 1);

                    /////////////////////////////////////////////////////////////////////
                    for (int i = 0; i < keyValueManagerFIFO.size(); i++) {
                        if (backup.equals(keyValueManagerFIFO.get(i))) {
                            keyValueManagerFIFO.remove(i);
                        }
                    }



                    for (int i = 0; i < keyValueManagerLIFO.size(); i++) {
                        if (backup.equals(keyValueManagerLIFO.get(i))) {
                            keyValueManagerLIFO.remove(i);
                        }
                    }


                    /////////////////////////////////////////////////////////////////////
                    count1--;
                    break;
                default:
                    break;
            }
        }
    }

    public void setEvictionPolicy(EvictionPolicy e) {
        policy = e;
        revisedTime = OffsetDateTime.now();
        createdCount = addCount;
    }

    public void addEntry(String key, String value) {
        revisedTime = OffsetDateTime.now();
        createdCount = addCount;
        String backup = null;

        // 지정된 키가 존재할때 (LRU 는 수정시간 초기화까지 수행하는 기능 포함 FIFO, LIFO 는 상관x)

        if (keyValue.containsKey(key)) {
            keyValue.put(key, value);
            for (int i = 0; i < keyValueManagerLRU.size(); i++) {
                if (keyValueManagerLRU.get(i).equals(key)) {
                    keyValueManagerLRU.remove(i);
                    break;
                }
            }
            keyValueManagerLRU.add(0, key);
            // keyValueManagerFIFO.add(0, key);
            // keyValueManagerLIFO.add(0, key);
            return;
        }

        // 지정된 키가 존재하지 않을때

        if (keyValue.size() < maxEntryCount) {
            keyValue.put(key, value);
            keyValueManagerLRU.add(0, key);

            keyValueManagerFIFO.add(0, key);
            keyValueManagerLIFO.add(0, key);

        } else {
            int count = keyValue.size();
        while (count >= maxEntryCount && keyValue.size() >= 2) { // = 추가

            // lru에 기초하여 초과분 제거
            switch (policy) {
                case FIRST_IN_FIRST_OUT:
                    keyValue.remove(keyValueManagerFIFO.get(keyValueManagerFIFO.size() - 1));
                    backup = keyValueManagerFIFO.get(keyValueManagerFIFO.size() - 1);
                    keyValueManagerFIFO.remove(keyValueManagerFIFO.size() - 1);

                    /////////////////////////////////////////////////////////////////////
                    for (int i = 0; i < keyValueManagerLRU.size(); i++) {
                        if (backup.equals(keyValueManagerLRU.get(i))) {
                            keyValueManagerLRU.remove(i);
                        }
                    }
                    
                    keyValueManagerLRU.add(0, key);
                    
                    for (int i = 0; i < keyValueManagerLIFO.size(); i++) {
                        if (backup.equals(keyValueManagerLIFO.get(i))) {
                            keyValueManagerLIFO.remove(i);
                        }
                    }
                    
                    keyValueManagerLIFO.add(0, key);
                    /////////////////////////////////////////////////////////////////////
                    
                    keyValue.put(key, value);
                    keyValueManagerFIFO.add(0, key);
                    count--;
                    break;
                case LAST_IN_FIRST_OUT:
                    keyValue.remove(keyValueManagerLIFO.get(0));
                    backup = keyValueManagerLIFO.get(0);
                    keyValueManagerLIFO.remove(0);

                    /////////////////////////////////////////////////////////////////////
                    for (int i = 0; i < keyValueManagerFIFO.size(); i++) {
                        if (backup.equals(keyValueManagerFIFO.get(i))) {
                            keyValueManagerFIFO.remove(i);
                        }
                    }
                    
                    keyValueManagerFIFO.add(0, key);
                    
                    for (int i = 0; i < keyValueManagerLRU.size(); i++) {
                        if (backup.equals(keyValueManagerLRU.get(i))) {
                            keyValueManagerLRU.remove(i);
                        }
                    }
                    
                    keyValueManagerLRU.add(0, key);
                    /////////////////////////////////////////////////////////////////////
                    
                    
                    keyValueManagerLIFO.add(0, key);
                    keyValue.put(key, value);
                    count--;
                    break;
                case LEAST_RECENTLY_USED:
                    // 제일 안쓰인놈 지우기
                    keyValue.remove(keyValueManagerLRU.get(keyValueManagerLRU.size() - 1));
                    backup = keyValueManagerLRU.get(keyValueManagerLRU.size() - 1);
                    keyValueManagerLRU.remove(keyValueManagerLRU.size() - 1);

                    /////////////////////////////////////////////////////////////////////
                    for (int i = 0; i < keyValueManagerFIFO.size(); i++) {
                        if (backup.equals(keyValueManagerFIFO.get(i))) {
                            keyValueManagerFIFO.remove(i);
                        }
                    }

                    keyValueManagerFIFO.add(0, key);

                    for (int i = 0; i < keyValueManagerLIFO.size(); i++) {
                        if (backup.equals(keyValueManagerLIFO.get(i))) {
                            keyValueManagerLIFO.remove(i);
                        }
                    }

                    keyValueManagerLIFO.add(0, key);
                    /////////////////////////////////////////////////////////////////////

                    // 새로 만들어주기
                    keyValue.put(key, value);
                    keyValueManagerLRU.add(0, key);
                    count--;

                    break;
                default:
                    break;
            }
        }
    }
    }

    public String getEntryOrNull(String key) {
        revisedTime = OffsetDateTime.now();
        createdCount = addCount;

        
        for (int i = 0; i < keyValueManagerLRU.size(); i++) {
            if (keyValueManagerLRU.get(i).equals(key)) {
                keyValueManagerLRU.remove(i);
                keyValueManagerLRU.add(0, key);
            }
        }
        

        // keyValueManagerLRU.remove(keyValueManagerLRU.size() - 1);
        // keyValueManagerLRU.add(0, key);

        return this.keyValue.get(key);

    }

}
