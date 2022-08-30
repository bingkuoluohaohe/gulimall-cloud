package com.jnu.gulimall.auth.constant;


public class GiteeConstant {
    /**
     *  第三方权限认证的步骤
     *  1. 通过client_id 和回调方法获取指定的第三方授权页面
     *  2. 第三方页面授权成功,通过回调方法 获取返回的通行code
     *  3. 通过 code和回调等 从第三方服务换取登录成功票据  token
     *  4. 通过第三方服务的票据 token 获取用户的基本信息返回到前端页面
     */

    // 码云我的应用中对应的 客户端id
    public static final String clientId = "43966d65b7e3920a830bec212333df3a81e3fceb673520996db1d9265a0c26e6";
    // 码云我的应用中对应的
    public static final String  secret = "ae61069114274623b35156b3d059d42aba061bc04ae4ac07f9fb9230949c32a5";
    // 配置的回调接口地址
    public static final String callback ="http://auth.gulimall.com/oauth2.0/gitee/success";
    // 跳转码云的授权页面
    public static final String GiteeURI = "https://gitee.com/oauth/authorize?client_id=" + clientId + "&redirect_uri="+ callback+"&response_type=code";
    // 通过码云的code换取他的token凭据
    public static final String address = "https://gitee.com";
    public static final String path = "/oauth/token";
    // 通过码云服务的token凭据 获取用户信息
    public static final String userInfo = "https://gitee.com/api/v5/user";

}
