package com.example.equestrian_event.service;

import com.example.equestrian_event.core.common.req.PageReqDto;
import com.example.equestrian_event.core.common.resp.PageRespDto;
import com.example.equestrian_event.core.common.resp.RestResp;
import com.example.equestrian_event.dto.req.UserInfoUptReqDto;
import com.example.equestrian_event.dto.req.UserLoginReqDto;
import com.example.equestrian_event.dto.req.UserRegisterReqDto;
import com.example.equestrian_event.dto.resp.HorseInfoRespDto;
import com.example.equestrian_event.dto.resp.UserInfoRespDto;
import com.example.equestrian_event.dto.resp.UserLoginRespDto;
import com.example.equestrian_event.dto.resp.UserRegisterRespDto;

/**
 * 马匹模块 服务类
 */
public interface HorseService {

    /**
     * 马匹列表
     *
     * @param dto 请求参数
     * @return list
     */
    RestResp<PageRespDto<HorseInfoRespDto>> list(PageReqDto dto);
}
