package com.xueqiu.model;

import java.io.Serializable;

/**
 * Created by lshi on 6/11/14.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 7009886701973242905L;

    private Long id;
    private String screenName;
    private String profile;
    private String profile_image_domain;
    private String profile_image_url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getProfile_image_domain() {
        return profile_image_domain;
    }

    public void setProfile_image_domain(String profile_image_domain) {
        this.profile_image_domain = profile_image_domain;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }
}
