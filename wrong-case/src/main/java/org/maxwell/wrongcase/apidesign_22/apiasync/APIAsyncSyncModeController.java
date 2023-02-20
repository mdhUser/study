package org.maxwell.wrongcase.apidesign_22.apiasync;

import lombok.extern.slf4j.Slf4j;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.request.AsyncUploadRequest;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.request.SyncQueryUploadTaskRequest;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.request.SyncUploadRequest;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.request.UploadRequest;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.response.AsyncUploadResponse;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.response.SyncQueryUploadTaskResponse;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.response.SyncUploadResponse;
import org.maxwell.wrongcase.apidesign_22.apiasync.dto.response.UploadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("apiasyncsyncmode")
@RestController
public class APIAsyncSyncModeController {

    @Autowired
    private FileService fileService;

    @GetMapping("wrong")
    public UploadResponse upload() {
        UploadRequest request = new UploadRequest();
        return fileService.upload(request);
    }

    @GetMapping("syncUpload")
    public SyncUploadResponse syncUpload() {
        SyncUploadRequest request = new SyncUploadRequest();
        return fileService.syncUpload(request);
    }

    @GetMapping("asyncUpload")
    public AsyncUploadResponse asyncUpload() {
        AsyncUploadRequest request = new AsyncUploadRequest();
        return fileService.asyncUpload(request);
    }

    @GetMapping("syncQuery")
    public SyncQueryUploadTaskResponse syncQuery(@RequestParam("taskId") String taskId) {
        SyncQueryUploadTaskRequest request = new SyncQueryUploadTaskRequest(taskId);
        return fileService.syncQuery(request);
    }

}
