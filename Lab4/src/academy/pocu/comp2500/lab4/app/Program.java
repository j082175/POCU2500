package academy.pocu.comp2500.lab4.app;

import academy.pocu.comp2500.lab4.EvictionPolicy;
import academy.pocu.comp2500.lab4.MemoryCache;

public class Program {

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

    public static void main(String[] args) {

        test();
        // test2();
        // test3();
        // test4();
        for (int i = 0; i < Integer.MAX_VALUE + 10; i++) {
            MemoryCache a = MemoryCache.getInstance("i");
        }

        MemoryCache.setMaxInstanceCount(Integer.MAX_VALUE);

        assert 1 > 2;

    }
}
