#!/usr/bin/env python3
from __future__ import annotations

import argparse
import re
import sys
from dataclasses import dataclass
from pathlib import Path


PROJECT_ARTIFACT_ID = "brick-bootkit-admin-parent"
VERSION_PATTERN = re.compile(
    r"(<artifactId>\s*" + re.escape(PROJECT_ARTIFACT_ID) + r"\s*</artifactId>\s*<version>)([^<]+)(</version>)",
    re.MULTILINE,
)


@dataclass
class UpdateResult:
    path: Path
    old_version: str
    new_version: str


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(
        description="Update brick-bootkit-admin Maven project version across all module pom.xml files."
    )
    parser.add_argument("version", help="Target project version, for example 1.2.0 or 1.2.0-SNAPSHOT")
    parser.add_argument(
        "--dry-run",
        action="store_true",
        help="Show which files would change without writing them.",
    )
    return parser.parse_args()


def validate_version(version: str) -> None:
    if not version or version.strip() != version:
        raise ValueError("Version must be a non-empty string without leading or trailing whitespace.")
    if any(ch.isspace() for ch in version):
        raise ValueError("Version must not contain whitespace.")


def repo_root() -> Path:
    return Path(__file__).resolve().parent.parent


def iter_poms(root: Path) -> list[Path]:
    return sorted(
        path
        for path in root.rglob("pom.xml")
        if "target" not in path.parts and ".git" not in path.parts and ".idea" not in path.parts
    )

def update_pom(path: Path, version: str, dry_run: bool) -> UpdateResult | None:
    with path.open("r", encoding="utf-8", newline="") as handle:
        original = handle.read()
    match = VERSION_PATTERN.search(original)
    if not match:
        return None

    old_version = match.group(2).strip()
    if old_version == version:
        return None

    updated = VERSION_PATTERN.sub(rf"\g<1>{version}\g<3>", original, count=1)
    if updated == original:
        return None

    if not dry_run:
        with path.open("w", encoding="utf-8", newline="") as handle:
            handle.write(updated)

    return UpdateResult(path=path, old_version=old_version, new_version=version)


def main() -> int:
    args = parse_args()

    try:
        validate_version(args.version)
    except ValueError as exc:
        print(f"Invalid version: {exc}", file=sys.stderr)
        return 2

    root = repo_root()
    pom_files = iter_poms(root)
    results: list[UpdateResult] = []

    for pom in pom_files:
        result = update_pom(pom, args.version, args.dry_run)
        if result is not None:
            results.append(result)

    mode = "Dry run" if args.dry_run else "Updated"
    if not results:
        print(f"{mode}: no pom.xml files needed changes.")
        return 0

    print(f"{mode} {len(results)} pom.xml file(s):")
    for item in results:
        relative_path = item.path.relative_to(root)
        print(f"  - {relative_path}: {item.old_version} -> {item.new_version}")

    return 0


if __name__ == "__main__":
    raise SystemExit(main())
