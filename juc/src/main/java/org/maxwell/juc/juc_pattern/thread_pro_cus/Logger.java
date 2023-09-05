package org.maxwell.juc.juc_pattern.thread_pro_cus;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.*;

@Slf4j
public class Logger {
    //任务队列
    final BlockingQueue<LogMsg> bq = new LinkedBlockingQueue<>(100);
    //flush批量
    static final int batchSize = 500;
    //只需要一个线程写日志
    ExecutorService es =
            Executors.newFixedThreadPool(1);

    //用于终止日志执行的“毒丸”
    final LogMsg poisonPill = new LogMsg(LEVEL.ERROR, "");

    //启动写日志线程
    void start() throws IOException {
        File file = File.createTempFile(
                "foo", ".log");
        final FileWriter writer = new FileWriter(file);

        this.es.execute(() -> {
            try {
                //未刷盘日志数量
                int curIdx = 0;
                long preFT = System.currentTimeMillis();
                while (true) {
                    LogMsg log = bq.poll(
                            5, TimeUnit.SECONDS);

                    if (poisonPill.equals(log))
                        break;

                    //写日志
                    if (log != null) {
                        System.out.println("write~~~");
                        writer.write(log.toString());
                        ++curIdx;
                    }
                    //如果不存在未刷盘数据，则无需刷盘
                    if (curIdx <= 0) {
                        continue;
                    }
                    //根据规则刷盘
                    if (log != null && log.level == LEVEL.ERROR ||
                            curIdx == batchSize ||
                            System.currentTimeMillis() - preFT > 5000) {
                        System.out.println("flush~~~");
                        writer.flush();
                        curIdx = 0;
                        preFT = System.currentTimeMillis();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //写INFO级别日志
    void info(String msg) throws InterruptedException {
        bq.put(new LogMsg(
                LEVEL.INFO, msg));
    }

    //写ERROR级别日志
    void error(String msg) throws InterruptedException {
        bq.put(new LogMsg(
                LEVEL.ERROR, msg));
    }

    /**
     * 终止写线程日志
     */
    public void stop(){
        bq.add(poisonPill);
        es.shutdown();
    }


}

//日志级别
enum LEVEL {
    INFO, ERROR
}

class LogMsg {
    LEVEL level;
    String msg;

    //省略构造函数实现
    LogMsg(LEVEL lvl, String msg) {
        this.level=lvl;
        this.msg=msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogMsg logMsg = (LogMsg) o;
        return level == logMsg.level && Objects.equals(msg, logMsg.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, msg);
    }

    @Override
    public String toString() {
        return "LogMsg{" +
                "level=" + level +
                ", msg='" + msg + '\'' +
                '}';
    }
}