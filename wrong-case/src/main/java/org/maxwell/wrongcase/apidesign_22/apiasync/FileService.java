package org.maxwell.wrongcase.apidesign_22.apiasync;

import org.maxwell.wrongcase.apidesign_22.apiasync.dto.request.AsyncUploadRequest;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.request.SyncQueryUploadTaskRequest;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.request.SyncUploadRequest;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.request.UploadRequest;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.response.AsyncUploadResponse;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.response.SyncQueryUploadTaskResponse;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.response.SyncUploadResponse;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.response.UploadResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/20 13:40
 */
@Service
public class FileService {


    private ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public UploadResponse upload(UploadRequest request) {
        UploadResponse response = new UploadResponse();
        //上传原始文件任务提交到线程池处理
        Future<String> uploadFile = threadPool.submit(() -> uploadFile(request.getFile()));
        //上传缩略图任务提交到线程池处理
        Future<String> uploadThumbnailFile = threadPool.submit(() -> uploadThumbnailFile(request.getFile()));
        //等待上传原始文件任务完成，最多等待1秒
        try {
            response.setDownloadUrl(uploadFile.get(1, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //等待上传缩略图任务完成，最多等待1秒
        try {
            response.setThumbnailDownloadUrl(uploadThumbnailFile.get(1, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public SyncUploadResponse syncUpload(SyncUploadRequest request) {
        SyncUploadResponse response = new SyncUploadResponse();
        response.setDownloadUrl(uploadFile(request.getFile()));
        response.setThumbnailDownloadUrl(uploadThumbnailFile(request.getFile()));
        return response;
    }


    //计数器，作为上传任务的ID
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //暂存上传操作的结果，生产代码需要考虑数据持久化
    private ConcurrentHashMap<String, SyncQueryUploadTaskResponse> downloadUrl = new ConcurrentHashMap<>();

    //异步上传操作
    public AsyncUploadResponse asyncUpload(AsyncUploadRequest request) {
        AsyncUploadResponse response = new AsyncUploadResponse();
        //生成唯一的上传任务ID
        String taskId = "upload" + atomicInteger.incrementAndGet();
        //异步上传操作只返回任务ID
        response.setTaskId(taskId);
        //提交上传原始文件操作到线程池异步处理
        threadPool.execute(() -> {
            String url = uploadFile(request.getFile());
            //如果ConcurrentHashMap不包含Key，则初始化一个SyncQueryUploadTaskResponse，然后设置DownloadUrl
            downloadUrl.computeIfAbsent(taskId, SyncQueryUploadTaskResponse::new).setDownloadUrl(url);
        });
        //提交上传缩略图操作到线程池异步处理
        threadPool.execute(() -> {
            String url = uploadThumbnailFile(request.getFile());
            downloadUrl.computeIfAbsent(taskId, SyncQueryUploadTaskResponse::new).setThumbnailDownloadUrl(url);
        });
        return response;
    }


    /**
     * 查询任务函数
     *
     * @param request
     * @return
     */
    public SyncQueryUploadTaskResponse syncQuery(SyncQueryUploadTaskRequest request) {
        SyncQueryUploadTaskResponse response = new SyncQueryUploadTaskResponse(request.getTaskId());
        response.setDownloadUrl(downloadUrl.getOrDefault(request.getTaskId(), response).getDownloadUrl());
        response.setThumbnailDownloadUrl(downloadUrl.getOrDefault(request.getTaskId(), response).getThumbnailDownloadUrl());
        return response;
    }


    private String uploadFile(byte[] data) {
        try {
            TimeUnit.MILLISECONDS.sleep(500 + ThreadLocalRandom.current().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "http://www.demo.com/download/" + UUID.randomUUID();
    }

    private String uploadThumbnailFile(byte[] data) {
        try {
            TimeUnit.MILLISECONDS.sleep(1500 + ThreadLocalRandom.current().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "http://www.demo.com/download/" + UUID.randomUUID();
    }


}
