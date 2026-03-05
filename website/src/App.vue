<template>
  <div class="page">
    <header class="topbar">
      <div class="brand">
        <span class="dot"></span>
        <span class="name">brick-bootkit-admin</span>
      </div>
      <nav class="nav">
        <a href="#install">Install</a>
        <a href="#release">Release</a>
        <a href="#docs">Docs</a>
      </nav>
    </header>

    <section class="hero">
      <p class="kicker">Open Source Distribution</p>
      <h1>Ship Faster With a Ready-to-Release Admin Stack</h1>
      <p class="subtitle">
        This repository packages SQL initialization, cross-platform release automation,
        and documentation for <code>brick-bootkit-admin</code>.
      </p>
      <div class="actions">
        <a class="btn primary" href="../docs/INSTALL.md">Read Install Guide</a>
        <a class="btn ghost" href="../docs/FEATURES.md">Feature Manual</a>
      </div>
    </section>

    <section class="cards">
      <article class="card">
        <h3>Minimal SQL</h3>
        <p>Schema extracted from production dump, private records removed, core bootstrapping retained.</p>
        <a href="../database/minimal/README.md">database/minimal/README.md</a>
      </article>
      <article class="card">
        <h3>One-Command Build</h3>
        <p>Single script orchestrates raw JAR, obfuscated JAR, host installer and Docker package output.</p>
        <a href="../scripts/release/README.md">scripts/release/README.md</a>
      </article>
      <article class="card">
        <h3>Release Layout</h3>
        <p>Artifacts are grouped by target OS and format for direct publishing.</p>
        <a href="../release/">release/</a>
      </article>
    </section>

    <section id="install" class="panel">
      <h2>Installation Flow</h2>
      <ol>
        <li>Prepare MySQL and Redis.</li>
        <li>Import <code>database/minimal/001-schema.sql</code> and <code>002-core-seed.sql</code>.</li>
        <li>Optionally import <code>003-menu-perms.sql</code> for full menu/permission baseline.</li>
        <li>Start service and complete install wizard.</li>
      </ol>
    </section>

    <section id="release" class="panel">
      <h2>Artifact Targets</h2>
      <div class="matrix">
        <div><strong>raw/</strong><span>Original executable JAR</span></div>
        <div><strong>obfuscated/</strong><span>Allatori obfuscated package</span></div>
        <div><strong>windows/</strong><span>NSIS EXE output</span></div>
        <div><strong>linux/</strong><span>DEB/RPM output (Linux host)</span></div>
        <div><strong>macos/</strong><span>DMG output (macOS host)</span></div>
        <div><strong>docker/</strong><span>Docker image tar and compose templates</span></div>
      </div>
      <div class="download-block">
        <h3>Latest Build Manifest</h3>
        <p v-if="downloadMeta.generatedAt" class="meta">
          generatedAt: {{ downloadMeta.generatedAt }} | mode: {{ downloadMeta.mode }} | version: {{ downloadMeta.version }} | host: {{ downloadMeta.hostOs }}
        </p>
        <p v-else class="meta">No release metadata found yet. Run release build to generate downloads data.</p>
        <div v-if="groupEntries.length" class="filter-bar">
          <button
            v-for="item in filterOptions"
            :key="item.value"
            type="button"
            class="chip"
            :class="{ active: item.value === platformFilter }"
            @click="platformFilter = item.value"
          >
            {{ item.label }}
          </button>
        </div>
        <div v-if="filteredGroupEntries.length" class="groups">
          <details v-for="entry in filteredGroupEntries" :key="entry.name" class="group">
            <summary>{{ entry.name }} ({{ entry.items.length }})</summary>
            <ul>
              <li v-for="item in entry.items" :key="item.path">
                <code>{{ item.path }}</code>
                <span>{{ item.size }} bytes</span>
              </li>
            </ul>
          </details>
        </div>
      </div>
    </section>

    <section id="docs" class="panel">
      <h2>Documentation</h2>
      <ul>
        <li><a href="../docs/INSTALL.md">INSTALL.md</a></li>
        <li><a href="../docs/FEATURES.md">FEATURES.md</a></li>
        <li><a href="../docs/RELEASE.md">RELEASE.md</a></li>
      </ul>
    </section>
  </div>
</template>

<script setup>
import { computed, onMounted, ref } from "vue";

const downloadMeta = ref({
  generatedAt: "",
  hostOs: "",
  mode: "",
  version: "",
});
const groups = ref({});
const platformFilter = ref("all");

const groupEntries = computed(() =>
  Object.entries(groups.value || {})
    .map(([name, items]) => ({
      name,
      items: (Array.isArray(items) ? items : []).slice().sort((a, b) => a.path.localeCompare(b.path)),
    }))
    .sort((a, b) => a.name.localeCompare(b.name)),
);

const filterOptions = computed(() => {
  const options = [{ value: "all", label: "All" }];
  for (const entry of groupEntries.value) {
    options.push({ value: entry.name, label: entry.name });
  }
  return options;
});

const filteredGroupEntries = computed(() => {
  if (platformFilter.value === "all") return groupEntries.value;
  return groupEntries.value.filter((item) => item.name === platformFilter.value);
});

onMounted(async () => {
  try {
    const res = await fetch("/data/downloads.json", { cache: "no-store" });
    if (!res.ok) return;
    const data = await res.json();
    downloadMeta.value = {
      generatedAt: data.generatedAt || "",
      hostOs: data.hostOs || "",
      mode: data.mode || "",
      version: data.version || "",
    };
    groups.value = data.groups || {};
    if (!groups.value[platformFilter.value]) {
      platformFilter.value = "all";
    }
  } catch {
    // no-op
  }
});
</script>
