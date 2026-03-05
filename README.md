# brick-bootkit-admin

`brick-bootkit-admin` 官网仓库（纯静态站点）。

当前仓库核心目标：

- 展示产品能力、场景、治理与咨询入口（中文官网）。
- 使用 GitHub Pages 自动部署。
- 自定义域名为 `yc.zqzqq.com`。

## 技术栈

- Vite（多页面静态站）
- 原生 HTML/CSS/JS
- GitHub Actions（Pages 部署）

## 仓库结构

```text
brick-bootkit-admin/
  .github/workflows/
    website-pages.yml           # GitHub Pages 自动部署工作流（已启用）
  website/
    capability/                 # 平台能力页
    contact/                    # 联系咨询页
    ecosystem/                  # 生态扩展页
    faq/                        # 常见问题页
    facts/                      # 产品事实页
    scenarios/                  # 行业场景页
    security/                   # 安全治理页
    public/                     # 静态资源（含 CNAME、图片、SEO 文件）
    scripts/                    # 辅助脚本（如图片优化）
    src/                        # 全局样式与交互脚本
    index.html                  # 首页
    package.json
```

## 本地开发

```bash
cd website
npm ci
npm run dev
```

本地构建：

```bash
npm run build
```

图片优化（生成 WebP）：

```bash
npm run images:optimize
```

## GitHub Pages 部署

工作流文件：

- `.github/workflows/website-pages.yml`

触发条件：

- `main` 分支推送且命中 `website/**`。
- 手动触发 `workflow_dispatch`。

部署产物：

- `website/dist`

## 自定义域名配置（yc.zqzqq.com）

仓库已包含：

- `website/public/CNAME`，内容为：`yc.zqzqq.com`

你在 DNS 服务商需要配置：

- 记录类型：`CNAME`
- 主机记录：`yc`
- 记录值：`v18268185209.github.io`
- TTL：默认

GitHub 仓库设置：

- `Settings -> Pages`
- Source 选择 `GitHub Actions`
- Custom domain 填 `yc.zqzqq.com`
- 证书签发后勾选 `Enforce HTTPS`

## 访问说明

- 主访问域名：`https://yc.zqzqq.com`
- 当绑定了自定义域名后，`github.io` 地址可能会重定向到自定义域名，属正常行为。

## 说明

- 官网为纯静态架构，前端不存放 webhook/token 等敏感信息。
- 表单采用静态安全策略（邮件草稿方式），不依赖仓库内后端服务。
