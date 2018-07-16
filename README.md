# Benchmark String Concatenation

The purpose of this project is to see the impact a different concatenation style

How use me
----------
Clone repo and go inside 
```bash

mvn clean install
java -jar target/string-concat-benchmarks.jar Main -f 1

```

Output result 
-------------

Result : 
```
Benchmark                     Mode  Cnt   Score   Error  Units
Main.concatWithConcat         avgt   10   2,311 ? 0,215  ms/op
Main.concatWithPlus           avgt   10   1,925 ? 0,226  ms/op
Main.concatWithStringBuilder  avgt   10   2,087 ? 0,286  ms/op
Main.concatWithStringFormat   avgt   10  12,275 ? 1,058  ms/op

```

We can see that String.format is not really a good way to concat strings
