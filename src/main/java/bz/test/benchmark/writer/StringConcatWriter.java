package bz.test.benchmark.writer;

import java.util.List;
import java.util.stream.Collectors;

public class StringConcatWriter {
    private static final String EMPTY_STRING = "";
    private static final String SEPARATOR = "|";
    private static final String CSV_SEPARATOR = ",";

    public String concatWithStringFormat(List<String> datas) {
        if (datas == null || datas.isEmpty()) {
            return EMPTY_STRING;
        }
        return datas
                .stream()
                .map(s -> String.format("%s%s%s", s, SEPARATOR, s))
                .collect(Collectors.joining(CSV_SEPARATOR));
    }

    public String concatWithPlus(List<String> datas) {
        if (datas == null || datas.isEmpty()) {
            return EMPTY_STRING;
        }
        return datas
                .stream()
                .map(s -> s + SEPARATOR + s)
                .collect(Collectors.joining(CSV_SEPARATOR));
    }

    public String concatWithConcat(List<String> datas) {
        if (datas == null || datas.isEmpty()) {
            return EMPTY_STRING;
        }
        return datas
                .stream()
                .map(s -> s.concat(SEPARATOR).concat(s))
                .collect(Collectors.joining(CSV_SEPARATOR));
    }

    public String concatWithStringBuilder(List<String> datas) {
        if (datas == null || datas.isEmpty()) {
            return EMPTY_STRING;
        }

        return datas
                .stream()
                .map(s -> new StringBuilder(s).append(SEPARATOR).append(s).toString())
                .collect(Collectors.joining(CSV_SEPARATOR));
    }
}
