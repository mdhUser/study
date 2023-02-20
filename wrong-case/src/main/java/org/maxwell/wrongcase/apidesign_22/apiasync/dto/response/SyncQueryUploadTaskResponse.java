package org.maxwell.wrongcase.apidesign_22.apiasync.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SyncQueryUploadTaskResponse {
    private final String taskId;
    private String downloadUrl;
    private String thumbnailDownloadUrl;
}
