package cn.net.rjnetwork.qixiaozhu.install;

import lombok.Data;

/**
 * Public install agreement status model.
 */
@Data
public class InstallAgreementStatus {
    private boolean required = true;
    private boolean accepted;
    private String version;
    private Long acceptedAt;
    private String title;
    private String confirmText;
    private String contentHtml;
}
