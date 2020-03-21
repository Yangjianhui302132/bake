package com.jimfly.bake.entity.login;

import lombok.Data;

@Data
public class MemberSession {
    //用户会话token key
    public static String BAKE_MEMBER_SESSION_TOKEN = "JIMFLY_BAKE_MEMBER_SESSION";
    //用户cookie的key
    public static String BAKE_MEMBER_COOKIE_TOKEN = "JIMFLY_BAKE_TOKEN";
    //用户会话过期时间
    public static Long BAKE_MEMBER_SESSION_TIMEOUT = 30*60L;
}
