package com.example.feed.domain.feed.domain;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.member.domain.Member;
import com.example.feed.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Feed extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean nonMemberShowing;

    @Column(nullable = false)
    private Integer likeCounts;

    @Column
    private String feedImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Builder
    public Feed(String title, String content, boolean nonMemberShowing, Integer likeCounts, String feedImage, Member member, Board board) {
        this.title = title;
        this.content = content;
        this.nonMemberShowing = nonMemberShowing;
        this.likeCounts = likeCounts;
        this.feedImage = feedImage;
        this.member = member;
        this.board = board;
    }

    public void update(String title, String content, boolean nonMemberShowing, String feedImage) {
        this.title = title;
        this.content = content;
        this.nonMemberShowing = nonMemberShowing;
        this.feedImage = feedImage;
    }

    public void addLikeCounts() {
        this.likeCounts += 1;
    }

    public void subLikeCounts() {
        this.likeCounts -= 1;
    }
}
