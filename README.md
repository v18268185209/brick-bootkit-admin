# brick-bootkit-admin

`brick-bootkit-admin` 现在同时承担两类职责：

- 官网静态站点仓库
- 对外公开的 Maven 公共契约层仓库

私有实现仓库保留在内部，不放在本仓库中。当前公开仓只发布可以安全公开的 API、注解、常量和通用结果模型。

## License

本仓库保持 `GPLv3`，同时对公开契约模块附加 `Section 7 additional permission`，用于允许私有实现或其他独立模块链接、依赖这些公共契约模块。

额外授权文件：

- [LICENSE_EXCEPTION.md](./LICENSE_EXCEPTION.md)

当前额外授权覆盖的模块：

- `eqadmin-bom`
- `eqadmin-core-constants`
- `eqadmin-annotations`
- `eqadmin-result`

## 当前模块

```text
brick-bootkit-admin/
  pom.xml
  eqadmin-bom/
  eqadmin-core-constants/
  eqadmin-annotations/
  brick-boot-admin-api/
  eqadmin-spi/
  eqadmin-result/
  website/
  .github/workflows/
    website-pages.yml
    maven-central.yml
```

说明：

- `eqadmin-bom`: 公开模块 BOM
- `eqadmin-core-constants`: 通用常量
- `eqadmin-annotations`: 对外注解契约
- `brick-boot-admin-api`: 公开 DTO / VO / 配置模型
- `eqadmin-spi`: 对外扩展点接口
- `eqadmin-result`: 统一返回模型
- `website`: 官网静态站

当前已进入第二阶段：除基础注解、常量和通用结果模型外，公开层也开始承载安装配置、授权模式、监控统计和消息通道契约。

## 官网开发

```bash
cd website
npm ci
npm run dev
```

官网构建：

```bash
cd website
npm run build
```

图片优化：

```bash
cd website
npm run images:optimize
```

## Maven 开发

根目录编译：

```bash
mvn clean verify
```

仅编译公开模块：

```bash
mvn -pl eqadmin-bom,eqadmin-core-constants,eqadmin-annotations,brick-boot-admin-api,eqadmin-spi,eqadmin-result -am verify
```

## Maven Central 发布

发布工作流：

- `.github/workflows/maven-central.yml`

发布前需要准备：

- Sonatype Central namespace
- `CENTRAL_USERNAME`
- `CENTRAL_PASSWORD`
- `GPG_PRIVATE_KEY`
- `GPG_PASSPHRASE`

触发方式：

- 推送 tag，例如 `public-v1.0.0`
- 手动触发 `workflow_dispatch`

## GitHub Pages 部署

工作流文件：

- `.github/workflows/website-pages.yml`

部署产物：

- `website/dist`

## 自定义域名配置

当前 Pages 自定义域名：

- `yc.zqzqq.com`

仓库已包含：

- `website/public/CNAME`

## 重要说明

- 本仓库只放可公开的公共层代码，不放核心商业实现。
- 如果你后续继续抽离公开层，优先放 API、SPI、注解、DTO，不要放实现类。
- 根协议仍为 GPLv3；公开契约层通过 `LICENSE_EXCEPTION.md` 提供附加授权。
- 该附加授权只放宽“链接/依赖/组合使用”，不把公共模块本身改成宽松许可证。
- 商标、品牌名、Logo 不在本附加授权范围内。
