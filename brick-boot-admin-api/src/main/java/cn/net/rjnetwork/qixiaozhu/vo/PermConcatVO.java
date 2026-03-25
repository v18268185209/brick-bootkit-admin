package cn.net.rjnetwork.qixiaozhu.vo;

import lombok.Data;

import java.util.List;

@Data
public class PermConcatVO {
    private Long userId;
    private List<Long> deptIds;
    private String permCode;
}
