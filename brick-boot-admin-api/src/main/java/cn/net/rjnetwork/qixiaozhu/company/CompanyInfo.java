package cn.net.rjnetwork.qixiaozhu.company;

import lombok.Data;

import java.io.Serializable;

/**
 * Public company or department info snapshot used by plugins.
 */
@Data
public class CompanyInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String company;
    private String companyCode;
    private String type;
    private Long parentId;
    private String status;
}
