import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
import { fileURLToPath, URL } from "node:url";

export default defineConfig({
  plugins: [vue()],
  server: {
    port: 5173
  },
  build: {
    rollupOptions: {
      input: {
        home: fileURLToPath(new URL("./index.html", import.meta.url)),
        capability: fileURLToPath(new URL("./capability/index.html", import.meta.url)),
        scenarios: fileURLToPath(new URL("./scenarios/index.html", import.meta.url)),
        security: fileURLToPath(new URL("./security/index.html", import.meta.url)),
        ecosystem: fileURLToPath(new URL("./ecosystem/index.html", import.meta.url)),
        faq: fileURLToPath(new URL("./faq/index.html", import.meta.url)),
        contact: fileURLToPath(new URL("./contact/index.html", import.meta.url)),
        facts: fileURLToPath(new URL("./facts/index.html", import.meta.url))
      }
    }
  }
});
