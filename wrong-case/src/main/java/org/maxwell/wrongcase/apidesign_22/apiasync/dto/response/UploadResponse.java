package org.maxwell.wrongcase.apidesign_22.apiasync.dto.response;

import lombok.Data;

@Data
    public class UploadResponse {
        private String downloadUrl;
        private String thumbnailDownloadUrl;
    }