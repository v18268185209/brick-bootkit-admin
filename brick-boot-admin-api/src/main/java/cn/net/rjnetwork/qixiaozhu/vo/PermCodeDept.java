package cn.net.rjnetwork.qixiaozhu.vo;

import lombok.Data;

import java.util.List;

@Data
public class PermCodeDept {
    private String permCode;
    private List<Long> deptIds;
}
