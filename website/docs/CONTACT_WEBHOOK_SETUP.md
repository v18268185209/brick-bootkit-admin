# Contact Strategy (Static Site)

本项目官网部署在 GitHub Pages，采用纯静态模式。

## 结论

- 不提供项目内后端 API。
- 不在前端存放 webhook/token/签名密钥。
- 在线咨询表单使用 `mailto` 方式：提交后自动生成邮件草稿。

## 当前表单行为

- 页面：`/contact/`
- 提交按钮会生成邮件草稿并打开本地邮件客户端。
- 默认收件人：`admin@zqzqq.com`

表单可通过以下属性配置：

- `data-recipient-email`
- `data-mail-subject-zh`
- `data-mail-subject-en`

## 为什么不用 DingTalk Webhook 直连

纯静态站无法安全保存 webhook 相关密钥，任何前端内参数都可被查看和滥用。

## 如需自动通知（未来可选）

在保持官网静态的前提下，可接入外部表单 SaaS 或 Serverless 中转。该能力不在当前仓库内实现。
