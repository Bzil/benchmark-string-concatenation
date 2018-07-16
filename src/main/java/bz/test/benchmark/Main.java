package bz.test.benchmark;

import bz.test.benchmark.writer.StringConcatWriter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Main {

    private static final int ARRAY_SIZE = 10_000;
    // Destination buffer, the slayer
    private final StringConcatWriter writer = new StringConcatWriter();
    // experiment test input
    private List<String> datas;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Main.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void init() {
        datas = IntStream.range(0, ARRAY_SIZE)
                .mapToObj(i -> UUID.randomUUID().toString())
                .collect(Collectors.toList());
    }

    @Benchmark
    public String concatWithStringFormat() {
        return writer.concatWithStringFormat(datas);
    }

    @Benchmark
    public String concatWithPlus() {
        return writer.concatWithPlus(datas);
    }

    @Benchmark
    public String concatWithConcat() {
        return writer.concatWithConcat(datas);
    }

    @Benchmark
    public String concatWithStringBuilder() {
        return writer.concatWithStringBuilder(datas);
    }
}

