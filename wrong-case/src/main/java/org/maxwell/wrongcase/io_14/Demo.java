package org.maxwell.wrongcase.io_14;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.springframework.util.StopWatch;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.*;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/31 14:25
 */
@Slf4j
public class Demo {


    public static void main(String[] args) throws IOException {
        //createFile();
        //readCharset();
        //readLinesStream();
        //readLinesCloseable();


        //Files.write(Paths.get("src.txt"),
        //        IntStream.rangeClosed(1, 1000000).mapToObj(i -> UUID.randomUUID().toString()).collect(Collectors.toList())
        //        , UTF_8, CREATE, TRUNCATE_EXISTING);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perByteOperation");
        perByteOperation();
        stopWatch.stop();
        stopWatch.start("bufferOperationWith100Buffer");
        bufferOperationWith100Buffer();
        stopWatch.stop();
        stopWatch.start("bufferedStreamByteOperation");
        bufferedStreamByteOperation();
        stopWatch.stop();
        stopWatch.start("bufferedStreamBufferOperation");
        bufferedStreamBufferOperation();
        stopWatch.stop();
        stopWatch.start("largerBufferOperation");
        largerBufferOperation();
        stopWatch.stop();
        stopWatch.start("fileChannelOperation");
        fileChannelOperation();
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());

    }

    private static void fileChannelOperation() throws IOException {
        Files.deleteIfExists(Paths.get("dest.txt"));
        FileChannel in = FileChannel.open(Paths.get("src.txt"), StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get("dest.txt"), CREATE, WRITE);
        in.transferTo(0, in.size(), out);
    }


    //使用BufferedInputStream和BufferedOutputStream
    private static void bufferedStreamByteOperation() throws IOException {
        Files.deleteIfExists(Paths.get("dest.txt"));
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src.txt"));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("dest.txt"))) {
            int i;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        }
    }

    //额外使用一个8KB缓冲，再使用BufferedInputStream和BufferedOutputStream
    private static void bufferedStreamBufferOperation() throws IOException {
        Files.deleteIfExists(Paths.get("dest.txt"));
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src.txt"));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("dest.txt"))) {
            byte[] buffer = new byte[8192];
            int len = 0;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        }
    }
    //直接使用FileInputStream和FileOutputStream，再使用一个8KB的缓冲
    private static void largerBufferOperation() throws IOException {
        Files.deleteIfExists(Paths.get("dest.txt"));
        try (FileInputStream fileInputStream = new FileInputStream("src.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("dest.txt")) {
            byte[] buffer = new byte[8192];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        }
    }

    private static void perByteOperation() throws IOException {
        Files.deleteIfExists(Paths.get("dest.txt"));

        try (FileInputStream fileInputStream = new FileInputStream("src.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("dest.txt")) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                fileOutputStream.write(i);
            }
        }
    }

    //缓冲IO提高性能
    private static void bufferOperationWith100Buffer() throws IOException {
        Files.deleteIfExists(Paths.get("dest.txt"));
        try (FileInputStream fileInputStream = new FileInputStream("src.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("dest.txt")) {
            byte[] buffer = new byte[100];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        }
    }

    private static void readLinesCloseable() throws IOException {
        Files.write(Paths.get("demo.txt"), IntStream.rangeClosed(1, 10)
                        .mapToObj(__ -> UUID.randomUUID().toString()).collect(Collectors.toList()),
                UTF_8, CREATE, TRUNCATE_EXISTING);

        LongAdder adder = new LongAdder();
        long start = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000000).forEach(__ -> {
            try {
                //设置文件资源的释放
                try (Stream<String> lines = Files.lines(Paths.get("demo.txt"))) {
                    lines.forEach(i -> adder.increment());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("---costTime: " + (System.currentTimeMillis() - start) + "ms");
        log.info("total : {}", adder.longValue());
    }

    private static void readLinesStream() throws IOException {
        //输出文件大小
        log.info("file size:{}", Files.size(Paths.get("test.txt")));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("read 200000 lines");
        //使用Files.lines方法读取20万行数据
        log.info("lines {}", Files.lines(Paths.get("test.txt")).limit(200000).collect(Collectors.toList()).size());
        stopWatch.stop();
        stopWatch.start("read 2000000 lines");
        //使用Files.lines方法读取200万行数据
        log.info("lines {}", Files.lines(Paths.get("test.txt")).limit(2000000).collect(Collectors.toList()).size());
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        AtomicLong atomicLong = new AtomicLong();
        //使用Files.lines方法统计文件总行数
        Files.lines(Paths.get("test.txt")).forEach(line -> atomicLong.incrementAndGet());
        log.info("total lines {}", atomicLong.get());
    }

    private static void readCharset() throws IOException {
        String content = "";
        char[] chars = new char[10];
        try (FileInputStream in = new FileInputStream("hello.txt");
             InputStreamReader reader = new InputStreamReader(in, Charset.forName("GBK"))) {
            int count;
            while ((count = reader.read(chars)) != -1) {
                content += new String(chars, 0, count);
            }
        }
        log.info("result {}", content);

        //1.8特性
        log.info("result {}",
                Files.readAllLines(Paths.get("hello.txt"), Charset.forName("GBK")).stream().findFirst().orElse(""));
    }

    private static void createFile() throws IOException {
        Files.deleteIfExists(Paths.get("hello.txt"));
        log.info("charset: {}", Charset.defaultCharset());
        Files.write(Paths.get("hello.txt"), "你好 hi".getBytes("GBK"));
        log.info("bytes:{}", Hex.encodeHexString(Files.readAllBytes(Paths.get("hello.txt"))).toUpperCase());
    }


}
