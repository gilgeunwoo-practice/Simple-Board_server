package com.example.feed.domain.feed.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FeedDetailResponse {

    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String memberName;
    private String imageUrl;
}
