package cn.net.rjnetwork.qixiaozhu.spi.company;

import cn.net.rjnetwork.qixiaozhu.company.CompanyInfo;

/**
 * Public company provider contract for plugins.
 */
public interface CompanyProvider {

    CompanyInfo getById(Long id);

    Long queryCompanyIdByDeptId(Long deptId);
}
