import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    @Test
    public void 테스트() {
        List<String> name = new ArrayList<>(Arrays.asList("동현", "정윤", "태정", "문기", "윤지", "수연"));
        List<String> collects = name.stream()
                .sorted()
                .collect(Collectors.toList());
        for(String collect : collects) {
            System.out.println(collect);
        }
    }
}
