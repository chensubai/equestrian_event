package com.example.equestrian_event.controller;

import com.example.equestrian_event.core.auth.UserHolder;
import com.example.equestrian_event.core.common.req.PageReqDto;
import com.example.equestrian_event.core.common.resp.PageRespDto;
import com.example.equestrian_event.core.common.resp.RestResp;
import com.example.equestrian_event.core.constant.ApiRouterConsts;
import com.example.equestrian_event.core.constant.SystemConfigConsts;
import com.example.equestrian_event.dto.resp.HorseInfoRespDto;
import com.example.equestrian_event.service.HorseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 马匹模块 API 控制器
 */
@Tag(name = "HorseController", description = "马匹模块")
@SecurityRequirement(name = SystemConfigConsts.HTTP_AUTH_HEADER_NAME)
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_HORSE_URL_PREFIX)
@RequiredArgsConstructor
public class HorseController {

    private final HorseService horseService;

    /**
     * 马匹列表接口
     */
    @Operation(summary = "马匹列表接口")
    @GetMapping("list")
    public RestResp<PageRespDto<HorseInfoRespDto>>list(@Valid @RequestBody PageReqDto dto) {
        return horseService.list(dto);
    }
}

