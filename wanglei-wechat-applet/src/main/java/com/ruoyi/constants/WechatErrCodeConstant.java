package com.ruoyi.constants;

/**
 * @program: xinggou
 * @description: 微信异常码
 * @author: Mr.Kong
 * @create: 2018-10-15 15:35
 **/
public class WechatErrCodeConstant {
    public static final Integer CODE2SESSION_SUCCESS = 0;
    // 请求超时
    public static final Integer CODE2SESSION_SYSTEMBUSY = -1;
    // code无效
    public static final Integer CODE2SESSION_INVALID = 40029;
    // 限制次数
    public static final Integer CODE2SESSION_LIMITEDNUM = 45011;
    // 微信支付失败
    public static final Integer PAY_FAIL = 112;
}
