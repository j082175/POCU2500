package academy.pocu.comp2500.lab4.app;

import academy.pocu.comp2500.lab4.EvictionPolicy;
import academy.pocu.comp2500.lab4.MemoryCache;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    public static void test() {
        {
            // 똑같은거 접근하는것도 사용된 거로 처리됨 (??? ㅡ,.ㅡ)
            MemoryCache memCacheA = MemoryCache.getInstance("A");

            MemoryCache memCacheB = MemoryCache.getInstance("B");
            MemoryCache memCacheC = MemoryCache.getInstance("C");

            assert memCacheA == MemoryCache.getInstance("A"); // 이미 존재
            assert memCacheB == MemoryCache.getInstance("B"); // 이미 존재
            assert memCacheC == MemoryCache.getInstance("C"); // 이미 존재

            MemoryCache.setMaxInstanceCount(3);

            MemoryCache memCacheD = MemoryCache.getInstance("D"); // a 제거된 b c d 상태

            assert memCacheA != MemoryCache.getInstance("A"); // 0 // c d a
            assert memCacheC == MemoryCache.getInstance("C"); // 2 // d a c
            assert memCacheB != MemoryCache.getInstance("B"); // a c b
            assert memCacheD != MemoryCache.getInstance("D"); // c b d
        }

        {
            MemoryCache memCache = MemoryCache.getInstance("A");
            memCache.addEntry("key1", "value1");
            memCache.addEntry("key2", "value2");
            memCache.addEntry("key3", "value3");
            memCache.addEntry("key4", "value4");
            memCache.addEntry("key5", "value5");

            memCache.setMaxEntryCount(3);

            assert memCache.getEntryOrNull("key1") == null;
            assert memCache.getEntryOrNull("key2") == null;
            assert memCache.getEntryOrNull("key3") != null;
            assert memCache.getEntryOrNull("key4") != null;
            assert memCache.getEntryOrNull("key5") != null;

            memCache.addEntry("key6", "value6");

            assert memCache.getEntryOrNull("key3") == null;

            memCache.getEntryOrNull("key4");
            memCache.getEntryOrNull("key5");
            memCache.getEntryOrNull("key4");

            memCache.addEntry("key7", "value7");

            assert memCache.getEntryOrNull("key6") == null;

            memCache.addEntry("key5", "value5_updated");
            memCache.addEntry("key8", "value8");

            assert memCache.getEntryOrNull("key4") == null;

            assert memCache.getEntryOrNull("key5").equals("value5_updated");

            memCache.setEvictionPolicy(EvictionPolicy.FIRST_IN_FIRST_OUT);

            memCache.addEntry("key9", "value9");
            assert memCache.getEntryOrNull("key5") == null;

            memCache.addEntry("key10", "value10");
            assert memCache.getEntryOrNull("key7") == null;

            memCache.setMaxEntryCount(1);

            assert memCache.getEntryOrNull("key8") == null;
            assert memCache.getEntryOrNull("key9") == null;
            assert memCache.getEntryOrNull("key10").equals("value10");

            memCache.setMaxEntryCount(5);
            memCache.setEvictionPolicy(EvictionPolicy.LAST_IN_FIRST_OUT);

            memCache.addEntry("key11", "value11");
            memCache.addEntry("key12", "value12");
            memCache.addEntry("key13", "value13");
            memCache.addEntry("key14", "value14");

            assert memCache.getEntryOrNull("key10") != null;
            assert memCache.getEntryOrNull("key11") != null;
            assert memCache.getEntryOrNull("key12") != null;
            assert memCache.getEntryOrNull("key13") != null;
            assert memCache.getEntryOrNull("key14") != null;

            memCache.addEntry("key15", "value15");

            assert memCache.getEntryOrNull("key14") == null;

            assert memCache.getEntryOrNull("key13") != null;
            assert memCache.getEntryOrNull("key11") != null;
            assert memCache.getEntryOrNull("key12") != null;
            assert memCache.getEntryOrNull("key10") != null;
            assert memCache.getEntryOrNull("key15") != null;

            memCache.setEvictionPolicy(EvictionPolicy.LEAST_RECENTLY_USED);

            memCache.addEntry("key16", "value16");

            assert memCache.getEntryOrNull("key13") == null;
            assert memCache.getEntryOrNull("key10") != null;
            assert memCache.getEntryOrNull("key11") != null;
            assert memCache.getEntryOrNull("key12") != null;
            assert memCache.getEntryOrNull("key15") != null;
            assert memCache.getEntryOrNull("key16") != null;
        }

    }

    public static void test2() {
        {
            MemoryCache.clear();
            MemoryCache.setMaxInstanceCount(5); // 여기 삭제하고도 잘 작동하는지??

            MemoryCache memCacheA = MemoryCache.getInstance("A");
            MemoryCache memCacheB = MemoryCache.getInstance("B");
            MemoryCache memCacheC = MemoryCache.getInstance("C");
            MemoryCache memCacheD = MemoryCache.getInstance("D");
            MemoryCache memCacheE = MemoryCache.getInstance("E");

            assert memCacheA != null;
            assert memCacheB != null;
            assert memCacheC != null;
            assert memCacheD != null;
            assert memCacheE != null;

            assert memCacheA == MemoryCache.getInstance("A");
            assert memCacheB == MemoryCache.getInstance("B");
            assert memCacheC == MemoryCache.getInstance("C");
            assert memCacheD == MemoryCache.getInstance("D");
            assert memCacheE == MemoryCache.getInstance("E");

            memCacheA.addEntry("test", "test");
            assert memCacheA.getEntryOrNull("test").equals("test");
            memCacheA.addEntry("test", "test2");
            assert memCacheA.getEntryOrNull("test").equals("test2");

            memCacheB.addEntry("test", "test");
            assert memCacheB.getEntryOrNull("test").equals("test");

            MemoryCache.setMaxInstanceCount(3);

            assert memCacheC == MemoryCache.getInstance("C");
            assert memCacheD == MemoryCache.getInstance("D");
            assert memCacheE == MemoryCache.getInstance("E");
            assert memCacheA != MemoryCache.getInstance("A");
            assert memCacheB != MemoryCache.getInstance("B");

            // A, B는 삭제후 새로 생성된 instance이니 위에서 추가했던 entry가 없을것임
            memCacheA = MemoryCache.getInstance("A");
            memCacheB = MemoryCache.getInstance("B");
            assert memCacheA.getEntryOrNull("test") == null;
            assert memCacheB.getEntryOrNull("test") == null;

            MemoryCache.clear();
        }

    }

    public static void test3() {
        MemoryCache.clear();
        MemoryCache.setMaxInstanceCount(5); // 여기 삭제하고도 잘 작동하는지??

        MemoryCache memCacheA = MemoryCache.getInstance("A");
        MemoryCache memCacheB = MemoryCache.getInstance("B");
        MemoryCache memCacheC = MemoryCache.getInstance("C");
        MemoryCache memCacheD = MemoryCache.getInstance("D");
        MemoryCache memCacheE = MemoryCache.getInstance("E");

        assert memCacheA != null;
        assert memCacheB != null;
        assert memCacheC != null;
        assert memCacheD != null;
        assert memCacheE != null;

        assert memCacheA == MemoryCache.getInstance("A");
        assert memCacheB == MemoryCache.getInstance("B");
        assert memCacheC == MemoryCache.getInstance("C");
        assert memCacheD == MemoryCache.getInstance("D");
        assert memCacheE == MemoryCache.getInstance("E");

        memCacheA.addEntry("test", "test");
        assert memCacheA.getEntryOrNull("test").equals("test");
        memCacheA.addEntry("test", "test2");
        assert memCacheA.getEntryOrNull("test").equals("test2");

        memCacheB.addEntry("test", "test");
        assert memCacheB.getEntryOrNull("test").equals("test");

        MemoryCache.setMaxInstanceCount(3);

        assert memCacheC == MemoryCache.getInstance("C");
        assert memCacheD == MemoryCache.getInstance("D");
        assert memCacheE == MemoryCache.getInstance("E");
        assert memCacheA != MemoryCache.getInstance("A");
        assert memCacheB != MemoryCache.getInstance("B");

        // A, B는 삭제후 새로 생성된 instance이니 위에서 추가했던 entry가 없을것임
        memCacheA = MemoryCache.getInstance("A");
        memCacheB = MemoryCache.getInstance("B");
        assert memCacheA.getEntryOrNull("test") == null;
        assert memCacheB.getEntryOrNull("test") == null;

        MemoryCache.clear();

    }

    public static void test4() {
        MemoryCache A = MemoryCache.getInstance("one");
        MemoryCache B = MemoryCache.getInstance("two");
        MemoryCache C = MemoryCache.getInstance("three");
        MemoryCache D = MemoryCache.getInstance("four");
        MemoryCache E = MemoryCache.getInstance("five");

        assert A == MemoryCache.getInstance("one");
        assert B == MemoryCache.getInstance("two");
        assert C == MemoryCache.getInstance("three");
        assert D == MemoryCache.getInstance("four");
        assert E == MemoryCache.getInstance("five");

        MemoryCache.clear();
        MemoryCache.setMaxInstanceCount(Integer.MAX_VALUE);

        A = MemoryCache.getInstance("one");
        B = MemoryCache.getInstance("two");
        C = MemoryCache.getInstance("three");
        D = MemoryCache.getInstance("four");
        E = MemoryCache.getInstance("five");

        assert A == MemoryCache.getInstance("one");
        assert B == MemoryCache.getInstance("two");
        assert C == MemoryCache.getInstance("three");
        assert D == MemoryCache.getInstance("four");
        assert E == MemoryCache.getInstance("five");

        MemoryCache.clear();
        assert A != MemoryCache.getInstance("one");
        assert B != MemoryCache.getInstance("two");
        assert C != MemoryCache.getInstance("three");
        assert D != MemoryCache.getInstance("four");
        assert E != MemoryCache.getInstance("five");
    }

    void test5() {
        {
            /*
             * COMP2500 202005 Lab4 시간복잡도 테스트 케이스(seolbeen)
             *
             * maxN: 총 반복 횟수
             * count: setMaxInstanceCount/setMaxEntryCount에서 사용하는 매개 변수
             * step: step 만큼의 시간 측정
             */
            int maxN = 100000;
            int count = 70000;
            int step = 10000;

            System.out.printf("===================================\n");
            System.out.printf("Time complexity test(MAX N: %d)\n", maxN);
            System.out.printf("===================================\n");
            ArrayList<String> strings = new ArrayList<>(maxN);
            for (int i = 0; i < maxN; i++) {
                strings.add(Integer.toString(i));
            }

            // initialization for instance test
            MemoryCache.clear();
            MemoryCache.setMaxInstanceCount(count);

            // test getInstance()
            System.out.printf("\ngetInstance() test\n");
            for (int n = 0; n < maxN; n += step) {
                System.out.printf("%6d ~ %6d: ", n, n + step - 1);

                long start = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    MemoryCache.getInstance(strings.get(i));
                }
                long end = System.currentTimeMillis();

                System.out.printf("%dms\n", end - start);
            }

            // initialization for entry test
            MemoryCache.clear();
            MemoryCache.setMaxInstanceCount(3);

            MemoryCache memCacheFifo = MemoryCache.getInstance("FIFO");
            MemoryCache memCacheFilo = MemoryCache.getInstance("FILO");
            MemoryCache memCacheLru = MemoryCache.getInstance("LRU");

            memCacheFifo.setEvictionPolicy(EvictionPolicy.FIRST_IN_FIRST_OUT);
            memCacheFilo.setEvictionPolicy(EvictionPolicy.LAST_IN_FIRST_OUT);
            memCacheLru.setEvictionPolicy(EvictionPolicy.LEAST_RECENTLY_USED);

            memCacheFifo.setMaxEntryCount(count);
            memCacheFilo.setMaxEntryCount(count);
            memCacheLru.setMaxEntryCount(count);

            // test addEntry()
            System.out.printf("\naddEntry() test [FIFO / FILO / LRU]\n");
            for (int n = 0; n < maxN; n += step) {
                System.out.printf("%6d ~ %6d: ", n, n + step - 1);

                long startFifo = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    memCacheFifo.addEntry(strings.get(i), strings.get(i));
                }
                long endFifo = System.currentTimeMillis();

                long startFilo = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    memCacheFilo.addEntry(strings.get(i), strings.get(i));
                }
                long endFilo = System.currentTimeMillis();

                long startLru = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    memCacheLru.addEntry(strings.get(i), strings.get(i));
                }
                long endLru = System.currentTimeMillis();

                System.out.printf("%dms / %dms / %dms\n", endFifo - startFifo, endFilo - startFilo, endLru - startLru);
            }

            // test getEntryOrNull()
            System.out.printf("\ngetEntryOrNull() test [FIFO / FILO / LRU]\n");
            for (int n = 0; n < maxN; n += step) {
                System.out.printf("%6d ~ %6d: ", n, n + step - 1);

                long startFifo = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    memCacheFifo.getEntryOrNull(strings.get(i));
                }
                long endFifo = System.currentTimeMillis();

                long startFilo = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    memCacheFilo.getEntryOrNull(strings.get(i));
                }
                long endFilo = System.currentTimeMillis();

                long startLru = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    memCacheLru.getEntryOrNull(strings.get(i));
                }
                long endLru = System.currentTimeMillis();

                System.out.printf("%dms / %dms / %dms\n", endFifo - startFifo, endFilo - startFilo, endLru - startLru);
            }
        }
    }

    public class MemoryCacheTest {

        @Test
        public void testGetHardisk() {
            MemoryCache memCacheA = MemoryCache.getInstance("A");
            String a = memCacheA.getHardDisk();
            assertEquals("A", a);
        }

        @Test
        public void testGetInstance() {
            MemoryCache memCacheA = MemoryCache.getInstance("A");
            MemoryCache memCacheB = MemoryCache.getInstance("B");
            MemoryCache memCacheC = MemoryCache.getInstance("C");

            assertEquals(true, (memCacheA != memCacheB) && memCacheA != memCacheC);
            assertEquals(true, memCacheB != memCacheC);
        }

        @Test
        public void testClear() {
            MemoryCache memCacheA = MemoryCache.getInstance("A");
            MemoryCache memCacheB = MemoryCache.getInstance("B");
            MemoryCache memCacheC = MemoryCache.getInstance("C");

            MemoryCache.clear();
            assert (memCacheA != MemoryCache.getInstance("A"));
            assert (memCacheB != MemoryCache.getInstance("B"));
            assert (memCacheC != MemoryCache.getInstance("C"));
        }

        @Test
        public void testSetMaxInstanceCount() {

            MemoryCache memCacheA = MemoryCache.getInstance("A");
            MemoryCache memCacheB = MemoryCache.getInstance("B");
            MemoryCache memCacheC = MemoryCache.getInstance("C");
            MemoryCache.setMaxInstanceCount(3);
            MemoryCache memCacheD = MemoryCache.getInstance("D"); // memCacheA가 제거됨
            assert memCacheA == null;
            //memCacheA = null;
            assertEquals(null, memCacheA);
        }

        @Test
        public void testGetMaxInstanceCount() {
            MemoryCache.setMaxInstanceCount(3);
            int count = MemoryCache.getMaxInstanceCount();
            assertEquals(3, count);
        }

        @Test
        public void testSetEvictionPolicy() {
            MemoryCache memCache = MemoryCache.getInstance("A");

            memCache.setEvictionPolicy(EvictionPolicy.FIRST_IN_FIRST_OUT);
            memCache.setEvictionPolicy(EvictionPolicy.LAST_IN_FIRST_OUT);
            memCache.setEvictionPolicy(EvictionPolicy.LEAST_RECENTLY_USED);

            assertEquals(EvictionPolicy.LEAST_RECENTLY_USED, memCache.getEvictionPolicy());
        }

        @Test
        public void testGetEvictionPolicy() {
            MemoryCache memCache = MemoryCache.getInstance("A");
            EvictionPolicy e = memCache.getEvictionPolicy();
            assertEquals(EvictionPolicy.LEAST_RECENTLY_USED, e);
        }

        @Test
        public void testAddEntry() {
            MemoryCache memCache = MemoryCache.getInstance("A");

            memCache.addEntry("key1", "value1");
            assertEquals("value1", memCache.getEntryOrNull("key1"));

            memCache.addEntry("key1", "value11");
            memCache.addEntry("key2", "value2");

            assertEquals("value11", memCache.getEntryOrNull("key1"));
            assertEquals("value2", memCache.getEntryOrNull("key2"));
        }

        @Test
        public void testSetMaxEntryCount() {
            MemoryCache memCache = MemoryCache.getInstance("A");
            memCache.setMaxEntryCount(3);

            memCache.addEntry("key1", "value1");
            memCache.addEntry("key2", "value2");
            memCache.addEntry("key3", "value3");

            memCache.addEntry("key4", "value4"); // 캐시로부터 key1이 제거됨
            assertEquals(null, memCache.getEntryOrNull("key1"));
        }

        @Test
        public void testGetMaxEntryCount() {
            MemoryCache memCacheA = MemoryCache.getInstance("A");
            memCacheA.addEntry("key1", "value1");
            memCacheA.addEntry("key2", "value2");
            memCacheA.addEntry("key3", "value3");
            int count = memCacheA.getMaxEntryCount();
            assertEquals(3, count);
        }

        @Test
        public void testGetEntryOrNull() {
            MemoryCache memCache = MemoryCache.getInstance("A");

            memCache.addEntry("key1", "value1");

            String value = memCache.getEntryOrNull("key1"); // value: value1
            String valueNull = memCache.getEntryOrNull("keyNull");

            assertEquals("value1", value);
            assertEquals(null, valueNull);
        }
    }

    @Test
    void main() {
/*        test();
        test2();
        test3();*/
        //test4();
        //test5();
        MemoryCacheTest test = new MemoryCacheTest();
        test.testSetMaxInstanceCount();


/*        MemoryCache memCacheA = MemoryCache.getInstance("A");

        MemoryCache memCacheB = MemoryCache.getInstance("B");
        MemoryCache memCacheC = MemoryCache.getInstance("C");
        MemoryCache memCacheD = MemoryCache.getInstance("D");
        MemoryCache memCacheE = MemoryCache.getInstance("E");

        MemoryCache.setMaxInstanceCount(2);
        assert memCacheA == MemoryCache.getInstance("A"); // 이미 존재
        assert memCacheB == MemoryCache.getInstance("B"); // 이미 존재
        assert memCacheC != MemoryCache.getInstance("C"); // 이미 존재
        assert memCacheD != MemoryCache.getInstance("D"); // 이미 존재
        assert memCacheE != MemoryCache.getInstance("E"); // 이미 존재*/
    }
}