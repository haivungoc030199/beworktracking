/*
package com.bework.beworktracking.service;

import com.bework.entity.CensorshipPost;
import com.bework.entity.Comment;
import com.bework.entity.Post;
import com.bework.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.bework.common.constants.Consts.PreauthorizeObjectType.*;

@Slf4j
@Service
public class PreAuthorizeService {

    private UserRepository userRepository;
    private NewfeedWorkspaceUserRepository newfeedWorkspaceUserRepository;
    private UserRoleRepository userRoleRepository;
    private PostRepository postRepository;
    private CensorshipPostRepository censorshipPostRepository;
    private CommentRepository commentRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public PreAuthorizeService(UserRepository userRepository, PostRepository postRepository, CensorshipPostRepository censorshipPostRepository,
                               NewfeedWorkspaceUserRepository newfeedWorkspaceUserRepository, UserRoleRepository userRoleRepository,
                               CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.newfeedWorkspaceUserRepository = newfeedWorkspaceUserRepository;
        this.userRoleRepository = userRoleRepository;
        this.postRepository = postRepository;
        this.censorshipPostRepository = censorshipPostRepository;
        this.commentRepository = commentRepository;
    }

    private Map<String, Object> decodeToken() throws IOException {
        String token = ((OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getTokenValue();
        Jwt jwt = JwtHelper.decode(token);
        Map<String, Object> claims = objectMapper.readValue(jwt.getClaims(), Map.class);
        return claims;
    }

    private boolean roleRequireConstraintRoleUser(String role, List<String> userRoles) {
        List<String> roleArr = Arrays.stream(role.split(",")).collect(Collectors.toList());
        for (String s : userRoles) {
            if (roleArr.contains(s)) return true;
        }
        return false;
    }

    */
/**
     * Called by
     * {
     * district/{districtId}/newfeed/workspace/{workspaceId}/post/{postId}/image,
     * district/{districtId}/newfeed/workspace/{workspaceId}/post/{postId}/attach
     * }
     *
     * @param newFeedWorkspaceId
     * @param role
     * @param objectId
     * @param objectType
     * @return
     *//*

    public boolean allowWorkspaceAndRole(Long newFeedWorkspaceId, String role, long objectId, String objectType) {
        try {
            log.info("Input: newFeedWorkspaceId, role : {}, {}", newFeedWorkspaceId, role);
            Map<String, Object> claims = decodeToken();
            Long id = Long.valueOf(claims.get("rfr_id").toString());
            if (isCreator(objectType, objectId, id)) return true;

            List<String> rolesInWorkspace =
                    userRoleRepository.findRolesInNewFeedWorkspaceByUserIdAndNewFeedWorkspaceId(id, newFeedWorkspaceId);

            if (!StringUtil.isBlank(role) &&
                    roleRequireConstraintRoleUser(role, rolesInWorkspace)) return true;

        } catch (Exception e) {
            log.error("User authentication failed");
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean allowByUserId(long userId) {
        try {
            Map<String, Object> claims = decodeToken();
            return (userId == Long.parseLong(claims.get("rfr_id").toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isCreator(String objectType, long objectId, long requesterId) {
        switch (objectType) {
            case POST:
            case UPLOAD_FILE:
                if (objectId < 0) {
                    CensorshipPost censorshipPost = censorshipPostRepository.findById(Math.abs(objectId));
                    if (censorshipPost == null || censorshipPost.getCreatedBy() != requesterId) return false;
                    return true;
                } else if (objectId > 0) {
                    Post post = postRepository.findById(objectId);
                    if (post == null || post.getCreatedBy() != requesterId) return false;
                    return true;
                }
                break;
            case COMMENT:
                Comment comment = commentRepository.findById(objectId);
                if (comment == null || comment.getCreatedBy() != requesterId) return false;
                return true;
            default:
                return false;
        }
        return false;
    }
}
*/
