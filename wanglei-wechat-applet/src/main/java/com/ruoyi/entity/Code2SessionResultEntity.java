package com.ruoyi.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: ruoyi
 * @description: 微信code2session实体类
 * @author: Mr.Kong
 * @create: 2019-04-01 11:02
 **/
@Data
public class Code2SessionResultEntity implements Serializable {
    private String openid;
    private String sessionKey;
    private String unionid;
    private Integer errcode;
    private String errmsg;
    private Boolean isRegister;
    public Code2SessionResultEntity() {
    }

    public Code2SessionResultEntity(String jsonString) {
        JSONObject res = JSONObject.parseObject(jsonString);
        this.openid = res.getString("openid");
        this.sessionKey = res.getString("session_key");
        this.unionid = res.getString("unionid");
        this.errmsg = res.getString("errmsg");
        this.errcode = res.getInteger("errcode");
    }
}
