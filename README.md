# brick-bootkit-admin (Open Source Distribution Workspace)

本仓库用于发布 `brick-bootkit-admin` 的开源发行产物与文档，目标是让你在一个目录里完成：

1. 最小化数据库初始化（去隐私）
2. 一键构建并归集多平台产物
3. 安装文档与功能说明
4. 官方网站（Vite + Vue3）

## 目录说明

```text
brick-bootkit-admin/
  database/minimal/            # 最小 SQL（schema + 核心种子 + 菜单权限种子）
  docs/                        # 安装文档、功能说明、发布说明、截图
  scripts/release/             # 统一发布脚本
  scripts/sql/                 # SQL 生成脚本
  release/                     # 归集后的发行产物目录
  website/                     # 官方网站源码（Vite + Vue3）
```

## 快速开始

### 1) 生成/更新最小 SQL

Windows:

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\sql\generate-minimal-sql.ps1
```

Linux/macOS:

```bash
bash ./scripts/sql/generate-minimal-sql.sh
```

### 2) 导入数据库

按顺序执行：

1. `database/minimal/001-schema.sql`
2. `database/minimal/002-core-seed.sql`
3. `database/minimal/003-menu-perms.sql`

默认管理员：

- 账号：`admin`
- 密码：`Admin@123456`

### 3) 一键构建归集产物

Windows:

```powershell
powershell -ExecutionPolicy Bypass -File .\build-release.ps1 -Mode external -Version 1.0.0
```

Linux/macOS:

```bash
bash ./build-release.sh --mode external --version 1.0.0
```

### 4) 启动官网

```bash
cd website
npm install
npm run dev
```

## 详细文档

- 安装文档：`docs/INSTALL.md`
- 功能说明：`docs/FEATURES.md`
- 发布说明：`docs/RELEASE.md`
- 变更记录：`CHANGELOG.md`
- SQL 说明：`database/minimal/README.md`
- 发布脚本说明：`scripts/release/README.md`

## 备注

- Windows/Linux/macOS 安装包需在对应系统上构建。
- 非当前系统无法构建的目标目录，会写入 `NOT_BUILT_ON_THIS_OS.txt` 说明文件。
- 执行统一发布脚本后会自动生成网站下载数据：`website/public/data/downloads.json`。
- 已提供 GitHub Actions 多平台发布工作流：`.github/workflows/release-matrix.yml`。
- `v*` tag 推送时会自动发布 GitHub Release 并附加多平台压缩产物。
