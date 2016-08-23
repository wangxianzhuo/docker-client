package com.github.wangxianzhuo.docker.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Image in docker
 * Created by shangjie
 * 16-8-23
 */
public class Image {
    @Expose
    private String id;
    @Expose
    private String parentId;
    @Expose
    private ArrayList<String> repoTags;
    @Expose
    private ArrayList<String> repoDigests;
    @Expose
    private Date created;
    @Expose
    private Long size;
    @Expose
    private Long virtualSize;
    @Expose
    private HashMap<String, Object> labels;

    public Image() {
    }

    public Image(String id, String parentId, ArrayList<String> repoTags, ArrayList<String> repoDigests, Date created, Long size, Long virtualSize, HashMap<String, Object> labels) {
        this.id = id;
        this.parentId = parentId;
        this.repoTags = repoTags;
        this.repoDigests = repoDigests;
        this.created = created;
        this.size = size;
        this.virtualSize = virtualSize;
        this.labels = labels;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public ArrayList<String> getRepoTags() {
        return repoTags;
    }

    public void setRepoTags(ArrayList<String> repoTags) {
        this.repoTags = repoTags;
    }

    public ArrayList<String> getRepoDigests() {
        return repoDigests;
    }

    public void setRepoDigests(ArrayList<String> repoDigests) {
        this.repoDigests = repoDigests;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getVirtualSize() {
        return virtualSize;
    }

    public void setVirtualSize(Long virtualSize) {
        this.virtualSize = virtualSize;
    }

    public HashMap<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(HashMap<String, Object> labels) {
        this.labels = labels;
    }
}
