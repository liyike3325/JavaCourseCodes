# 不同GC和堆内存的总结

## 串行GC
-XX:+UseSerialGC
串行GC对年轻代使用mark-copy（标记-复制）算法，对老年代使用mark-sweep-compact（标记-清除-整理）算法。
两者都是单线程的垃圾收集器，不能进行并行处理，所以都会触发全线暂停（STW），停止所有的应用线程。
因此这种GC算法不能充分利用多核CPU。不管有多少CPU内核，JVM在垃圾收集时都只能使用单个核心。
CPU利用率高，暂停时间长。简单粗暴，就像老式的电脑，动不动就卡死。
该选项只适合几百MB堆内存的JVM，而且是单核CPU时比较有用。

压测gateway-server-0.0.1-SNAPSHOT.jar
设置512MB堆内存
java -XX:+PrintGCDetails -Xmx512m -Xms512m -XX:+UseSerialGC -jar gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
GC时间基本是在几毫秒，最长用时16毫秒，只发生2次Full GC（在启动后没多久，最长用时60毫秒）
年轻代分配157MB，基本上使用了140MB左右，清理后500KB左右
堆内存分配512MB，基本上使用了188MB左右，清理后48MB左右
老年代基本上使用了48MB左右

设置1g堆内存
java -XX:+PrintGCDetails -Xmx1g -Xms1g -XX:+UseSerialGC -jar gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
GC时间基本是在几毫秒至10几毫秒，最长用时24毫秒，只发生1次Full GC（在启动后没多久，用时84毫秒）
年轻代分配314MB，基本上使用了280MB左右，清理后1MB左右
堆内存分配1g，基本上使用了330MB左右，清理后51MB左右
老年代基本上使用了50MB左右

设置4g堆内存
java -XX:+PrintGCDetails -Xmx4g -Xms4g -XX:+UseSerialGC -jar gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
GC次数明显变少，GC时间基本是在十几毫秒至二十几毫秒，最长用时31毫秒，只发生2次Full GC（在启动后没多久，最长用时135毫秒）
年轻代分配1.25g，基本上使用了1.14g左右，清理后25MB左右
堆内存分配4g，基本上使用了1.17g左右，清理后57MB左右
老年代基本上使用了30MB左右


## 并行GC
-XX:+UseParallelGC
-XX:+UseParallelOldGC
-XX:+UseParallelGC -XX:+UseParallelOldGC
年轻代和老年代的垃圾回收都会触发STW事件。
对年轻代使用mark-copy（标记-复制）算法，对老年代使用mark-sweep-compact（标记-清除-整理）算法。
-XX:ParallelGCThreads=N 来指定GC线程数，其默认值为CPU核心数。
并行垃圾收集器适用于多核服务器，主要目标是增加吞吐量。因为对系统资源的有效使用，能达到更高的吞吐量
更高吞吐量：
在GC期间，所有CPU内核都在并行清理垃圾，所以总暂停时间更短
在两次GC周期的间隔期，没有GC线程在运行，不会消耗任何系统资源

压测gateway-server-0.0.1-SNAPSHOT.jar
设置512MB堆内存
java -XX:+PrintGCDetails -Xmx512m -Xms512m -XX:+UseParallelGC -jar gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
GC时间基本是在几毫秒，最长用时12毫秒，只发生2次Full GC（在启动后没多久，最长用时54毫秒）
年轻代分配173MB，基本上使用了171MB左右，清理后160KB左右
堆内存分配512MB，基本上使用了220MB左右，清理后49MB左右
老年代基本上使用了48MB左右

设置1g堆内存
java -XX:+PrintGCDetails -Xmx1g -Xms1g -XX:+UseParallelGC -jar gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
GC时间基本是在几毫秒至10几毫秒，最长用时12毫秒，只发生2次Full GC（在启动后没多久，最长用时52毫秒）
年轻代最高分配335MB，最高使用了322MB左右，清理后224KB左右
堆内存分配1g，最高使用了370MB左右，清理后48MB左右
老年代基本上使用了50MB左右

设置4g堆内存
java -XX:+PrintGCDetails -Xmx4g -Xms4g -XX:+UseParallelGC -jar gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
GC次数明显变少，GC时间基本是在十几毫秒至二十几毫秒，最长用时21毫秒，只发生2次Full GC（在启动后没多久，最长用时58毫秒）
年轻代最高分配1.35g，最高使用了1.34g左右，清理后800KB左右
堆内存分配4g，最高使用了1.37g左右，清理后49MB左右
老年代基本上使用了30MB左右


## CMS GC
-XX:+UseConcMarkSweepGC
对年轻代采用并行STW方式的mark-copy（标记-复制）算法，对老年代主要使用并发mark-sweep（标记-清除）算法。
CMS GC的设计目标是避免在老年代垃圾收集时出现长时间的卡顿，主要通过两种手段来达成此目标：
1、不对老年代进行整理，而是使用空闲列表（free-list）来管理内存空间的回收。
2、在mark-and-sweep（标记-清除）阶段的大部分工作和应用线程一起并发执行。
也就是说，在这些阶段并没有明显的应用线程暂停。但值得注意的是，它仍然和应用线程争抢CPU时。
默认情况下，CMS使用的并发线程数等于CPU核心数的1/4。
如果服务器是多核CPU，并且主要调优目标是降低GC停顿导致的系统延迟，那么使用CMS是个很明智的选择。进行老年代的并发回收时，可能会伴随着多次年轻代的minor GC。
最大young区大小：
ParallelGC:1024M / 3 = 341.3M
CMS:64M * GC线程数4 * 13 / 10 = 332.8M

压测gateway-server-0.0.1-SNAPSHOT.jar
设置512MB堆内存
java -XX:+PrintGCDetails -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC -jar gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
GC时间基本是在几毫秒至10几毫秒，最长用时37毫秒
年轻代分配157MB，基本上使用了140MB左右，清理后400-700KB左右
堆内存分配512MB，最高使用了187MB左右，清理后47MB左右
老年代基本上使用了47MB左右

设置1g堆内存
java -XX:+PrintGCDetails -Xmx1g -Xms1g -XX:+UseConcMarkSweepGC -jar gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
GC时间基本是在几毫秒至10几毫秒，最长用时34毫秒
年轻代最高分配306MB，基本使用了273MB左右，清理后785KB左右
堆内存分配1g，基本使用了316MB左右，清理后44MB左右
老年代基本上使用了43MB左右

设置4g堆内存
java -XX:+PrintGCDetails -Xmx4g -Xms4g -XX:+UseConcMarkSweepGC -jar gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
GC次数没有变少，GC时间基本是在十几毫秒至二十几毫秒，最长用时51毫秒
虽然堆内存设置了4g，但是young区分配的大小是306MB，基本使用了273MB左右，清理后800KB左右
堆内存分配4g，基本使用了316MB左右，清理后44MB左右
老年代基本上使用了10MB左右


## G1 GC
-XX:+UseG1GC -XX:MaxGCPauseMillis=50
G1的全称是Garbage-First，意为垃圾优先，哪一块的垃圾最多就优先清理它。
G1 GC最主要的设计目标是：将STW停顿的时间和分布，变成可预期且可配置的。
事实上，G1 GC是一款软实时垃圾收集器，可以为其设置某项特定的性能指标。为了达到可预期停顿时间的指标，G1有一些独特的实现。
首先，堆不再分成年轻代和老年代，而是划分为多个（通常是2048个）可以存放对象的小块堆区域。每个小块，可能一会被定义为Eden区，一会被指定为Survivor区或者old区。在逻辑上，所有的Eden区和Survivor区合起来就是年轻代，所有的Old区拼在一起那就是老年代。
这样划分之后，使得G1不必每次都去收集整个堆空间，而是以增量的方式进行处理：每次只处理一部分内存块，称为此次GC的回收集。每次GC暂停都会收集所有年轻代的内存块，但一般只包含部分老年代的内存块。
G1的另一项创新是，在并发阶段估算每个小堆块存活对象的总数。构建回收集的原则是：垃圾最多的小块会被优先收集。

压测gateway-server-0.0.1-SNAPSHOT.jar
设置512MB堆内存
java -XX:+PrintGCDetails -Xmx512m -Xms512m -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -jar gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
GC时间基本是在几毫秒，最长用时29毫秒
年轻代分配307MB，基本使用了307MB左右，清理后1024KB
堆内存分配512MB，最高使用了353MB左右，清理后47MB左右
老年代基本上使用了47MB左右

设置1g堆内存
java -XX:+PrintGCDetails -Xmx1g -Xms1g -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -jar gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
GC时间基本是在几毫秒至10几毫秒，最长用时18毫秒
年轻代最高分配618MB，清理后7MB左右
堆内存分配1g，最高使用了655MB左右，清理后48MB左右
老年代基本上使用了37MB左右
最大年轻代占整个Java heap的大小，默认值为60%，所以当堆内存1g时，年轻代最高使用600多MB

设置4g堆内存
java -XX:+PrintGCDetails -Xmx4g -Xms4g -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -jar gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
GC时间基本是在十几毫秒，最长用时89毫秒
年轻代最大分配2.4g
堆内存分配4g，基本使用了316MB左右
内存变大以后，gc次数减少，但是gc的暂停时间变长


## 测试场景总结：
使用程序gateway-server-0.0.1-SNAPSHOT.jar
使用压测 wrk -c400 -d30s http://localhost:8088/api/hello
分别配置堆内存512MB、1GB、4GB三种进行测试
测试了串行GC、并行GC、CMS GC、G1 GC

## 堆内存总结：
1、各GC下默认最大young区大小
-串行GC、并行GC年轻代大概分配三分之一的内存，默认年轻代和老年代比例值为1:2
-ParallelGC:1024M / 3 = 341.3M
-CMS:64M * GC线程数4 * 13 / 10 = 332.8M
-G1 GC最大年轻代占整个Java heap的大小，默认值为60%
2、堆内存越大GC次数越少，但是GC时间会更长