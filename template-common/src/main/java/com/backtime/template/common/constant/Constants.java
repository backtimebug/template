package com.backtime.template.common.constant;

/**
 * @Author backtime
 * @Date 2021/2/3 23:12
 * @Description 通用常量
 */
public class Constants {

    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    public static final boolean SUCCESS = true;

    public static final boolean FAIL = false;

    /**
     * 成功标记
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 失败标记
     */
    public static final int FAIL_CODE = 500;

    public static final int UNAUTHORIZED_CODE = 401;

    public static final int SYSTEM_ERROR_CODE = 500;

    /**
     * 成功提示
     */
    public static final String SUCCESS_INFO = "操作成功";

    public static final String SAVE_SUCCESS = "保存成功";

    public static final String UPDATE_SUCCESS = "更新成功";

    public static final String QUERY_SUCCESS = "获取成功";

    public static final String DELETE_SUCCESS = "删除成功";

    /**
     * 失败提示
     */
    public static final String FAIL_INFO = "操作失败";

    public static final String SAVE_FAIL = "保存失败";

    public static final String UPDATE_FAIL = "更新失败";

    public static final String QUERY_FAIL = "获取失败";

    public static final String DELETE_FAIL = "删除失败";

    public static final String SYSTEM_ERROR = "系统内部错误，请稍后重试!";

    /**
     * token过期
     */
    public static final int EXPIRED_TOKEN = 402;

    /**
     * 登录过期
     */
    public static final String LOGIN_EXPIRED = "登录过期";

    /**
     * 验证码
     */
    public static final String CAPTCHA_KEY = "CAPTCHA_KEY";

    /**
     * token令牌
     */
    public static final String TOKEN = "Authorization";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * base64 jpg前缀
     */
    public static final String BASE64_JPG = "data:image/jpg;base64,";

    /**
     * 用戶session key
     */
    public static final String SESSION_KEY = "accountInfo";

    /**
     * 默认顶级菜单parent_id
     */
    public static final String DEFAULT_MENU_PARENT = "0";
}
