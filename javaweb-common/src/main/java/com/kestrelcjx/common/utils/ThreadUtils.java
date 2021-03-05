package com.kestrelcjx.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 线程相关工具类
 */
public class ThreadUtils {
    private static final Logger logger = LoggerFactory.getLogger(ThreadUtils.class);

    /**
     * sleep等待，单位为毫秒
     *
     * @param milliseconds 等待时间
     */
    public static void sleep(Long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            return;
        }
    }

    /**
     * 停止线程池
     * 先使用shutdown，停止接受新任务并尝试完成所有已存在任务。
     * 如果超时，则调用shutdownNow，取消在workQueue中Pending的任务，并中断所有阻塞函数。
     * 如果仍超时，则强制退出。
     * 另对在shutdown时线程本身被调用中断做了处理。
     *
     * @param pool
     */
    public static void shutdownAndAwaitTermination(ExecutorService pool) {
        if (pool != null && !pool.isShutdown()) {
            pool.shutdown();
            try {
                if (!pool.awaitTermination(120, TimeUnit.SECONDS)) {
                    pool.shutdownNow();
                    if (!pool.awaitTermination(120, TimeUnit.SECONDS)) {
                        logger.info("Pool did not terminate");
                    }
                }
            } catch (InterruptedException e) {
                pool.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * 打印线程异常信息
     *
     * @param r
     * @param t
     */
    public static void printException(Runnable r, Throwable t) {
        if (null == t && r instanceof Future<?>) {
            try {
                Future<?> future = (Future<?>) r;
                if (future.isDone()) {
                    future.get();
                }
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        if (t != null) {
            logger.error(t.getMessage(), t);
        }
    }
}
