package com.example.equestrian_event.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 马匹信息 响应DTO
 *
 * @author xiongxiaoyang
 * @date 2022/5/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HorseInfoRespDto {

    /**
     * ID
     */
    @Schema(description = "马匹ID")
    private Long id;

    /**
     * 名称
     */
    @Schema(description = "名称")
    private String name;

    /**
     * 马匹头像
     */
    @Schema(description = "马匹头像")
    private String headImg;

    /**
     * 性别
     */
    @Schema(description = "性别")
    private Integer gender;

    /**
     * 血统信息
     */
    @Schema(description = "血统信息")
    private String pedigree;

}
