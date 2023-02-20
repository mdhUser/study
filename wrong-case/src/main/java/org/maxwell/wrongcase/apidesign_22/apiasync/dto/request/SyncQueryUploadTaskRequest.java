package org.maxwell.wrongcase.apidesign_22.apiasync.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SyncQueryUploadTaskRequest {
    private final String taskId;
}
