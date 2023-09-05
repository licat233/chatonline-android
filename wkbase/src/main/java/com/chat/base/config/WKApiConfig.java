package com.chat.base.config;

import android.text.TextUtils;

import com.xinbida.wukongim.entity.WKChannelType;

/**
 * 2019-11-20 10:11
 * api地址
 */
public class WKApiConfig {
    public static String defaultBaseUrl = "http://api.im.catli.net/v1/";
    public static String defaultBaseWebUrl = "http://web.im.catli.net/";

    public static String baseUrl = defaultBaseUrl;
    public static String baseWebUrl = defaultBaseWebUrl;

    public static void initBaseURL(String apiURL) {
        baseUrl = defaultBaseUrl;
        baseWebUrl = defaultBaseWebUrl;
    }

    public static void initBaseURLIncludeIP(String apiURL) {
        if (apiURL.startsWith("http") || apiURL.startsWith("HTTP")) {
            baseUrl = apiURL + "/v1/";
            baseWebUrl = apiURL + "/web/";
        } else if (!TextUtils.isEmpty(apiURL)) {
            baseUrl = "http://" + apiURL + "/v1/";
            baseWebUrl = "http://" + apiURL + "/web/";
        }
    }

    public static String getAvatarUrl(String uid) {
        return baseUrl + "users/" + uid + "/avatar";
    }

    public static String getGroupUrl(String groupId) {
        return baseUrl + "groups/" + groupId + "/avatar";
    }

    public static String getShowAvatar(String channelID, byte channelType) {
        return channelType == WKChannelType.PERSONAL ? getAvatarUrl(channelID) : getGroupUrl(channelID);
    }

    public static String getShowUrl(String url) {
        if (TextUtils.isEmpty(url) || url.startsWith("http") || url.startsWith("HTTP")) {
            return url;
        } else {
            return baseUrl + url;
        }
    }

}
