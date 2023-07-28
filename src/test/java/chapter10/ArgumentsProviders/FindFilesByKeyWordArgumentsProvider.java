package chapter10.ArgumentsProviders;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FindFilesByKeyWordArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("file1.txt", 1);
        map.put("file2.txt", 1);
        map.put("file3.txt", 8);
//        Map<String, Integer> map1 = new HashMap<>();
//        map1.put("file1.txt", 1);
        return Stream.of(
                Arguments.of("src/test/resources/chapter10", "ipsum", map)
        );
    }
}
