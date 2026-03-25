package cn.net.rjnetwork.qixiaozhu.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserPerm {
    private List<PermCodeDept> permCodeDepts;
    private List<Long> deptIds = new ArrayList<>();
    private List<Long> companyIds = new ArrayList<>();
    private List<String> permCodes = new ArrayList<>();
    private Boolean selfPerm = false;
    private Boolean allPerm = false;
}
