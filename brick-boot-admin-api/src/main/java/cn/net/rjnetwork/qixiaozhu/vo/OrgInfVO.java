package cn.net.rjnetwork.qixiaozhu.vo;

import lombok.Data;

@Data
public class OrgInfVO {
    private Long id;
    private String code;
    private String parentCode;
    private String name;
    private Integer type;
}
