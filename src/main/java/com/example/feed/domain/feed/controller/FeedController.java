package com.example.feed.domain.feed.controller;

import com.example.feed.domain.feed.controller.dto.request.CreateFeedRequest;
import com.example.feed.domain.feed.controller.dto.request.SearchFeedRequest;
import com.example.feed.domain.feed.controller.dto.request.UpdateFeedRequest;
import com.example.feed.domain.feed.controller.dto.response.FeedDetailResponse;
import com.example.feed.domain.feed.controller.dto.response.FeedListResponse;
import com.example.feed.domain.feed.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;
    private final DeleteFeedService deleteFeedService;
    private final QueryFeedListService queryFeedListService;
    private final QueryFeedDetailService queryFeedDetailService;
    private final UpdateFeedService updateFeedService;
    private final QueryLikedFeedService queryLikedFeedService;
    private final SearchFeedService searchFeedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{board-id}")
    public void create(@RequestBody @Valid CreateFeedRequest request, @PathVariable("board-id") Long boardId) {
        createFeedService.execute(request, boardId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void delete(@PathVariable("feed-id") Long feedId) {
        deleteFeedService.execute(feedId);
    }

    @GetMapping
    public FeedListResponse list(@PathVariable("board-id") Long boardId) {
        return queryFeedListService.execute(boardId);
    }

    @GetMapping("/{feed-id}")
    public FeedDetailResponse detail(@PathVariable("feed-id") Long feedId) {
        return queryFeedDetailService.execute(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{feed-id}")
    public void update(@RequestBody @Valid UpdateFeedRequest request, @PathVariable("feed-id") Long feedId) {
        updateFeedService.execute(request, feedId);
    }

    @GetMapping("/{board-id}")
    public FeedListResponse likedList(@PathVariable("board-id") Long boardId) {
        return queryLikedFeedService.execute(boardId);
    }

    @GetMapping("/search/{board-id}")
    public FeedListResponse search(@PathVariable("board-id") Long boardId, @RequestBody @Valid SearchFeedRequest request) {
        return searchFeedService.execute(boardId, request);
    }
}
