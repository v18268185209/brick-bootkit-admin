package cn.net.rjnetwork.qixiaozhu.spi.account;

import cn.net.rjnetwork.qixiaozhu.account.CurrentAccount;

/**
 * Public current-account provider contract for plugins.
 */
public interface CurrentAccountProvider {

    CurrentAccount getCurrentAccount();

    CurrentAccount getAccount(Long userId);
}
