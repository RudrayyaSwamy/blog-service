package com.vismotechnologies.blogsservice.model;

import com.vismotechnologies.blogsservice.entity.CommentsDetails;
import com.vismotechnologies.blogsservice.entity.UserDetailsInfo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.sql.Timestamp;
import java.util.concurrent.ConcurrentSkipListSet;

@Data
public class CommentsDetailsModel {

    private String comment;
    private Timestamp commentOn;
    private UserDetailsInfoModel userDetailsInfoModel;

    public CommentsDetailsModel(CommentsDetails commentsDetails){
        comment = commentsDetails.getComment();
        commentOn = commentsDetails.getCommentOn();
        userDetailsInfoModel = new UserDetailsInfoModel(commentsDetails.getUserDetailsInfo());
    }

}
