package com.example.equestrian_event.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.equestrian_event.core.common.constant.ErrorCodeEnum;
import com.example.equestrian_event.core.common.exception.BusinessException;
import com.example.equestrian_event.core.common.req.PageReqDto;
import com.example.equestrian_event.core.common.resp.PageRespDto;
import com.example.equestrian_event.core.common.resp.RestResp;
import com.example.equestrian_event.core.constant.DatabaseConsts;
import com.example.equestrian_event.core.constant.SystemConfigConsts;
import com.example.equestrian_event.core.util.ImageUtils;
import com.example.equestrian_event.core.util.JwtUtils;
import com.example.equestrian_event.dao.mapper.HorseInfoMapper;
import com.example.equestrian_event.dao.mapper.UserInfoMapper;
import com.example.equestrian_event.dao.model.HorseInfo;
import com.example.equestrian_event.dao.model.UserInfo;
import com.example.equestrian_event.dto.req.UserInfoUptReqDto;
import com.example.equestrian_event.dto.req.UserLoginReqDto;
import com.example.equestrian_event.dto.req.UserRegisterReqDto;
import com.example.equestrian_event.dto.resp.HorseInfoRespDto;
import com.example.equestrian_event.dto.resp.UserInfoRespDto;
import com.example.equestrian_event.dto.resp.UserLoginRespDto;
import com.example.equestrian_event.dto.resp.UserRegisterRespDto;
import com.example.equestrian_event.manager.redis.VerifyCodeManager;
import com.example.equestrian_event.service.HorseService;
import com.example.equestrian_event.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 马匹模块 服务实现类
 */
@Service
@RequiredArgsConstructor
public class HorseServiceImpl implements HorseService {

    private final HorseInfoMapper horseInfoMapper;

    @Override
    public RestResp<PageRespDto<HorseInfoRespDto>> list(PageReqDto dto) {
        IPage<HorseInfo> page = new Page<>();
        page.setCurrent(dto.getPageNum());
        page.setSize(dto.getPageSize());
        QueryWrapper<HorseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc(DatabaseConsts.CommonColumnEnum.CREATE_TIME.getName());
        IPage<HorseInfo> horseInfoPage = horseInfoMapper.selectPage(page, queryWrapper);
        return RestResp.ok(PageRespDto.of(dto.getPageNum(), dto.getPageSize(), page.getTotal(),
                horseInfoPage.getRecords().stream().map(v -> HorseInfoRespDto.builder()
                        .id(v.getId())
                        .name(v.getName())
                        .headImg(v.getHeadImg())
                        .gender(v.getGender())
                        .pedigree(v.getPedigree())
                        .build()).toList()));
    }
}
