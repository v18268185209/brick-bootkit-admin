import fs from "node:fs";
import path from "node:path";
import sharp from "sharp";

const root = process.cwd();
const targetDir = path.join(root, "public", "images", "showcase");
const quality = Number(process.env.WEBP_QUALITY || "82");

if (!fs.existsSync(targetDir)) {
  console.error(`Directory not found: ${targetDir}`);
  process.exit(1);
}

const files = fs
  .readdirSync(targetDir)
  .filter((file) => file.toLowerCase().endsWith(".png"))
  .sort((a, b) => a.localeCompare(b));

if (files.length === 0) {
  console.log("No PNG files found in showcase directory.");
  process.exit(0);
}

let converted = 0;
for (const file of files) {
  const inputPath = path.join(targetDir, file);
  const outputPath = path.join(targetDir, file.replace(/\.png$/i, ".webp"));
  await sharp(inputPath).webp({ quality }).toFile(outputPath);
  converted += 1;
  console.log(`Converted: ${file} -> ${path.basename(outputPath)}`);
}

console.log(`Done. Converted ${converted} image(s) to WebP (quality=${quality}).`);
