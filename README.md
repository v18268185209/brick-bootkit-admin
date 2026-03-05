# brick-bootkit-admin

企业级官网与发布工作区，当前官网站点位于 `website/`，采用纯静态架构（Vite 多页面）。

## 项目定位

- 官网用途：推广 `brick-bootkit-admin` 产品能力与场景价值（非安装文档站）。
- 部署方式：GitHub Pages（静态托管）。
- 联系方式：页面表单采用 `mailto` 生成邮件草稿，不依赖仓库内后端。

## 目录结构

```text
brick-bootkit-admin/
  website/                       # 官网源码（Vite MPA）
    public/                      # 静态资源（SEO 文件、图片、CNAME）
    src/                         # 前端样式与交互脚本
    capability/                  # 平台能力页
    scenarios/                   # 行业场景页
    security/                    # 安全治理页
    ecosystem/                   # 生态扩展页
    faq/                         # 常见问题页
    contact/                     # 联系咨询页
  .github/workflows/
    website-pages.yml            # GitHub Pages 自动部署
    website-ci.yml               # 站点构建校验
```

## 本地开发

```bash
cd website
npm ci
npm run dev
```

本地打包：

```bash
npm run build
```

图片优化（生成 WebP）：

```bash
npm run images:optimize
```

## GitHub Pages 自动部署

仓库已提供：

- `/.github/workflows/website-pages.yml`
- `website/public/CNAME`

触发条件：

- 推送到 `main` 且变更命中 `website/**` 或 `website-pages.yml`
- 手动触发 `workflow_dispatch`

部署产物：`website/dist`。

## 自定义域名（yc.zqzqq.com）

### 1. CNAME 值

你的仓库远程为：`https://github.com/v18268185209/brick-bootkit-admin.git`，
因此 GitHub Pages 解析目标应为：

- `v18268185209.github.io`

### 2. DNS 配置

在域名服务商添加记录：

- 记录类型：`CNAME`
- 主机记录：`yc`
- 记录值：`v18268185209.github.io`
- TTL：默认即可

### 3. GitHub 仓库设置

进入：`Settings -> Pages`

- Source 选择：`GitHub Actions`
- Custom domain 填写：`yc.zqzqq.com`
- 勾选：`Enforce HTTPS`（证书生效后）

## 发布检查清单

- `website/public/CNAME` 内容为 `yc.zqzqq.com`
- `website-pages` workflow 运行成功
- `https://v18268185209.github.io/brick-bootkit-admin/`（若项目页）或 Pages URL 可访问
- `https://yc.zqzqq.com` 访问正常并自动 HTTPS

## 备注

- 官网当前为纯静态实现，不在前端存放 webhook/token 等敏感信息。
- 若未来需要自动消息推送，建议接入独立外部服务（保持官网静态）。
