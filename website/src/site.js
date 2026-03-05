const SUPPORTED_LANGS = ["zh", "en"];
const DEFAULT_LANG = "zh";
const LANG_STORAGE_KEY = "bbka_site_lang";

const LABEL_MAP_EN = {
  "官网域名": "Website",
  "邮箱": "Email",
  "电话": "Phone",
  "微信号": "WeChat ID",
  "内容": "Content"
};

const UI_TEXT = {
  zh: {
    copyFailed: "复制失败，请手动复制",
    copyDone: (label) => `${label}已复制，可直接粘贴使用`,
    submitIdle: "",
    submitLoading: "提交中，请稍候...",
    submitSuccess: "提交成功，我们会尽快联系你。",
    submitMock: "测试模式：已接收你的咨询，但当前环境未配置 webhook 推送。",
    submitNoConfig: "当前环境未配置 webhook，请直接电话或微信联系。",
    submitFailed: "提交失败，请稍后重试或直接通过电话/微信联系。",
    nameRequired: "请填写姓名",
    contactRequired: "请至少填写电话或邮箱",
    langSwitch: "EN"
  },
  en: {
    copyFailed: "Copy failed. Please copy manually.",
    copyDone: (label) => `${label} copied. You can paste it now.`,
    submitIdle: "",
    submitLoading: "Submitting...",
    submitSuccess: "Submitted successfully. We will contact you soon.",
    submitMock:
      "Test mode: your request was accepted locally, but webhook delivery is not configured in this environment.",
    submitNoConfig:
      "Webhook is not configured in this environment. Please contact us via phone or WeChat directly.",
    submitFailed: "Submit failed. Please try again later.",
    nameRequired: "Please enter your name.",
    contactRequired: "Please provide phone or email.",
    langSwitch: "中文"
  }
};

const PAGE_META = {
  "/": {
    zh: {
      title: "brick-bootkit-admin | 可扩展企业后台平台",
      description:
        "brick-bootkit-admin 帮助企业快速搭建并持续演进后台系统，支持插件、微应用、应用市场与任务治理。"
    },
    en: {
      title: "brick-bootkit-admin | Extensible Enterprise Admin Platform",
      description:
        "An extensible enterprise admin platform with plugins, micro apps, app marketplace and task governance."
    }
  },
  "/capability/": {
    zh: {
      title: "平台能力矩阵 | brick-bootkit-admin",
      description:
        "从权限体系、插件运行时、微应用管理到应用市场与安装任务治理，全面展示企业后台能力。"
    },
    en: {
      title: "Capability Matrix | brick-bootkit-admin",
      description:
        "Explore core platform capabilities from permissions and plugins to micro apps, app marketplace and deployment tasks."
    }
  },
  "/scenarios/": {
    zh: {
      title: "行业场景与落地路径 | brick-bootkit-admin",
      description:
        "面向企业运营后台、SaaS 中台、内部工具平台与 AI 生态扩展，提供可执行的后台落地路径。"
    },
    en: {
      title: "Scenarios & Delivery Path | brick-bootkit-admin",
      description:
        "Delivery patterns for enterprise admin, SaaS management, internal tool platforms and AI ecosystem expansion."
    }
  },
  "/security/": {
    zh: {
      title: "安全与治理体系 | brick-bootkit-admin",
      description:
        "通过请求响应加密、授权控制、安装预检与任务追踪机制，降低后台系统上线与运行风险。"
    },
    en: {
      title: "Security & Governance | brick-bootkit-admin",
      description:
        "Reduce go-live and runtime risk with request/response encryption, authorization control, precheck and task tracing."
    }
  },
  "/ecosystem/": {
    zh: {
      title: "插件、微应用与 MCP 生态 | brick-bootkit-admin",
      description:
        "统一管理插件、微应用与 MCP 服务，通过应用包、版本与安装任务体系构建持续扩展生态。"
    },
    en: {
      title: "Plugin, Micro-app & MCP Ecosystem | brick-bootkit-admin",
      description:
        "Unify plugins, micro apps and MCP services with package/version/task governance for scalable growth."
    }
  },
  "/faq/": {
    zh: {
      title: "常见问题 | brick-bootkit-admin",
      description: "了解产品适用对象、扩展方式与治理能力。"
    },
    en: {
      title: "FAQ | brick-bootkit-admin",
      description: "Common questions about fit scenarios, extensibility and governance."
    }
  },
  "/contact/": {
    zh: {
      title: "预约演示与方案咨询 | brick-bootkit-admin",
      description: "联系遇财（杭州）科技有限公司，获取产品演示与实施建议。"
    },
    en: {
      title: "Demo & Solution Consultation | brick-bootkit-admin",
      description:
        "Contact the team for product demo and implementation advice tailored to your business stage."
    }
  },
  "/facts/": {
    zh: {
      title: "产品事实卡片 | brick-bootkit-admin",
      description: "面向检索与引用的产品事实页，集中展示定义、能力、场景与边界。"
    },
    en: {
      title: "Product Facts | brick-bootkit-admin",
      description:
        "Fact-centric page for search and AI citation: definition, capabilities, scenarios and boundaries."
    }
  }
};

const ZH_TO_EN_TEXT = {
  "首页": "Home",
  "平台能力": "Capabilities",
  "行业场景": "Scenarios",
  "安全治理": "Security",
  "生态扩展": "Ecosystem",
  "常见问题": "FAQ",
  "联系咨询": "Contact",
  "预约演示": "Book Demo",
  "企业后台平台": "Enterprise Admin Platform",
  "可扩展企业后台平台": "Extensible Enterprise Admin Platform",
  "三大核心价值": "Three Core Values",
  "更快上线": "Faster Go-Live",
  "更易扩展": "Easier Expansion",
  "更可治理": "Stronger Governance",
  "能力总览": "Capability Overview",
  "典型场景": "Typical Scenarios",
  "下一步行动": "Next Step",
  "扫码咨询": "Scan to Consult",
  "查看完整联系方式": "View Full Contact Details",
  "查看常见问题": "View FAQ",
  "获取方案建议": "Get Solution Advice",
  "复制": "Copy",
  "复制邮箱": "Copy Email",
  "复制电话": "Copy Phone",
  "复制域名": "Copy Domain",
  "点击复制": "Copy",
  "点击复制微信号": "Copy WeChat ID",
  "在线咨询表单": "Online Consultation Form",
  "姓名 *": "Name *",
  "公司": "Company",
  "电话": "Phone",
  "邮箱": "Email",
  "需求说明": "Requirement",
  "提交咨询": "Submit Inquiry",
  "推荐沟通流程": "Recommended Communication Process",
  "发送咨询邮件": "Send Email",
  "电话联系": "Call Now",
  "快速访问": "Quick Links",
  "联系咨询": "Contact"
};

const PLACEHOLDER_ZH_TO_EN = {
  "请输入姓名": "Enter your name",
  "请输入公司名称": "Enter your company",
  "请输入联系电话": "Enter your phone number",
  "请输入邮箱地址": "Enter your email",
  "请描述你的业务背景、目标与当前系统状态":
    "Describe your business background, goals and current system status"
};

const originalTextMap = new WeakMap();
const originalPlaceholderMap = new WeakMap();

function normalizePath(pathname) {
  if (!pathname || pathname === "/") return "/";
  return pathname.endsWith("/") ? pathname : `${pathname}/`;
}

function detectLanguageFromLocation() {
  const stored = localStorage.getItem(LANG_STORAGE_KEY);
  if (SUPPORTED_LANGS.includes(stored)) return stored;

  const timezone = Intl.DateTimeFormat().resolvedOptions().timeZone || "";
  const langs = (navigator.languages && navigator.languages.length
    ? navigator.languages
    : [navigator.language || ""]).map((item) => String(item).toLowerCase());
  const hasZh = langs.some((item) => item.startsWith("zh"));
  const inCnTimezone = /asia\/(shanghai|chongqing|harbin|urumqi|hong_kong|taipei)/i.test(timezone);
  return hasZh || inCnTimezone ? "zh" : "en";
}

function replaceByMap(text, map) {
  let output = text;
  for (const [source, target] of Object.entries(map)) {
    if (output.includes(source)) {
      output = output.split(source).join(target);
    }
  }
  return output;
}

function applyTextLanguage(lang) {
  const walker = document.createTreeWalker(document.body, NodeFilter.SHOW_TEXT, {
    acceptNode(node) {
      if (!node || !node.nodeValue) return NodeFilter.FILTER_REJECT;
      const parent = node.parentElement;
      if (!parent) return NodeFilter.FILTER_REJECT;
      const tag = parent.tagName;
      if (tag === "SCRIPT" || tag === "STYLE" || tag === "NOSCRIPT") {
        return NodeFilter.FILTER_REJECT;
      }
      if (!node.nodeValue.trim()) return NodeFilter.FILTER_REJECT;
      return NodeFilter.FILTER_ACCEPT;
    }
  });

  const nodes = [];
  while (walker.nextNode()) {
    nodes.push(walker.currentNode);
  }

  for (const node of nodes) {
    if (!originalTextMap.has(node)) {
      originalTextMap.set(node, node.nodeValue);
    }
    const original = originalTextMap.get(node);
    if (lang === "en") {
      node.nodeValue = replaceByMap(original, ZH_TO_EN_TEXT);
    } else {
      node.nodeValue = original;
    }
  }

  for (const input of document.querySelectorAll("input[placeholder], textarea[placeholder]")) {
    if (!originalPlaceholderMap.has(input)) {
      originalPlaceholderMap.set(input, input.getAttribute("placeholder") || "");
    }
    const original = originalPlaceholderMap.get(input);
    if (lang === "en") {
      input.setAttribute("placeholder", replaceByMap(original, PLACEHOLDER_ZH_TO_EN));
    } else {
      input.setAttribute("placeholder", original);
    }
  }
}

function updateMetaLanguage(lang) {
  const key = normalizePath(window.location.pathname);
  const page = PAGE_META[key] || PAGE_META["/"];
  const meta = page[lang] || page[DEFAULT_LANG];
  if (!meta) return;

  document.title = meta.title;
  const desc = document.querySelector('meta[name="description"]');
  if (desc) desc.setAttribute("content", meta.description);
  const ogTitle = document.querySelector('meta[property="og:title"]');
  if (ogTitle) ogTitle.setAttribute("content", meta.title);
  const ogDesc = document.querySelector('meta[property="og:description"]');
  if (ogDesc) ogDesc.setAttribute("content", meta.description);
  const twTitle = document.querySelector('meta[name="twitter:title"]');
  if (twTitle) twTitle.setAttribute("content", meta.title);
  const twDesc = document.querySelector('meta[name="twitter:description"]');
  if (twDesc) twDesc.setAttribute("content", meta.description);
}

function updateLangToggleButtons(lang) {
  const next = UI_TEXT[lang]?.langSwitch || "EN";
  for (const btn of document.querySelectorAll("[data-lang-toggle]")) {
    btn.textContent = next;
  }
}

let currentLang = detectLanguageFromLocation();

function applyLanguage(lang, persist = false) {
  currentLang = SUPPORTED_LANGS.includes(lang) ? lang : DEFAULT_LANG;
  document.documentElement.lang = currentLang === "en" ? "en" : "zh-CN";
  document.body.setAttribute("data-lang", currentLang);
  updateMetaLanguage(currentLang);
  applyTextLanguage(currentLang);
  updateLangToggleButtons(currentLang);
  if (persist) localStorage.setItem(LANG_STORAGE_KEY, currentLang);
}

for (const btn of document.querySelectorAll("[data-lang-toggle]")) {
  btn.addEventListener("click", () => {
    applyLanguage(currentLang === "zh" ? "en" : "zh", true);
  });
}

for (const node of document.querySelectorAll("[data-current-year]")) {
  node.textContent = String(new Date().getFullYear());
}

const toastEl = document.createElement("div");
toastEl.className = "copy-toast";
toastEl.setAttribute("role", "status");
toastEl.setAttribute("aria-live", "polite");
document.body.appendChild(toastEl);
let toastTimer = 0;

function translateLabel(label) {
  return currentLang === "en" ? LABEL_MAP_EN[label] || label : label;
}

function showCopyToast(message, ok) {
  toastEl.textContent = message;
  toastEl.classList.add("show");
  toastEl.classList.toggle("error", !ok);
  if (toastTimer) window.clearTimeout(toastTimer);
  toastTimer = window.setTimeout(() => {
    toastEl.classList.remove("show");
    toastEl.classList.remove("error");
  }, 1800);
}

function showCopyFeedback(feedbackEl, message, ok) {
  if (!feedbackEl) return;
  feedbackEl.textContent = message;
  feedbackEl.style.color = ok ? "var(--ok)" : "var(--warn)";
  window.setTimeout(() => {
    if (feedbackEl.textContent === message) {
      feedbackEl.textContent = "";
      feedbackEl.style.color = "var(--ok)";
    }
  }, 2400);
}

async function copyText(text) {
  if (!text) return false;
  if (navigator.clipboard && window.isSecureContext) {
    await navigator.clipboard.writeText(text);
    return true;
  }
  const area = document.createElement("textarea");
  area.value = text;
  area.setAttribute("readonly", "true");
  area.style.position = "fixed";
  area.style.left = "-9999px";
  document.body.appendChild(area);
  area.focus();
  area.select();
  const ok = document.execCommand("copy");
  document.body.removeChild(area);
  return ok;
}

for (const btn of document.querySelectorAll("[data-copy-text]")) {
  btn.addEventListener("click", async () => {
    if (btn.disabled) return;
    const text = btn.getAttribute("data-copy-text") || "";
    const rawLabel = btn.getAttribute("data-copy-label") || "内容";
    const label = translateLabel(rawLabel);
    const scope = btn.closest("[data-copy-scope]") || document;
    const feedbackEl = scope.querySelector("[data-copy-feedback]");
    btn.disabled = true;
    try {
      const ok = await copyText(text);
      const ui = UI_TEXT[currentLang] || UI_TEXT[DEFAULT_LANG];
      const copyFeedback = ok ? `${ui.copyDone(label)}` : ui.copyFailed;
      const inlineText = currentLang === "en" ? `Copied: ${text}` : `已复制：${text}`;
      showCopyFeedback(feedbackEl, ok ? inlineText : ui.copyFailed, ok);
      showCopyToast(copyFeedback, ok);
    } catch {
      const ui = UI_TEXT[currentLang] || UI_TEXT[DEFAULT_LANG];
      showCopyFeedback(feedbackEl, ui.copyFailed, false);
      showCopyToast(ui.copyFailed, false);
    } finally {
      window.setTimeout(() => {
        btn.disabled = false;
      }, 450);
    }
  });
}

function setFormStatus(el, message, isError = false) {
  if (!el) return;
  el.textContent = message;
  el.style.color = isError ? "var(--warn)" : "var(--muted)";
}

const STATIC_FORM_TEXT = {
  zh: {
    nameRequired: "\u8bf7\u586b\u5199\u59d3\u540d",
    contactRequired: "\u8bf7\u81f3\u5c11\u586b\u5199\u7535\u8bdd\u6216\u90ae\u7bb1",
    preparing: "\u6b63\u5728\u751f\u6210\u90ae\u4ef6\u8349\u7a3f\uff0c\u8bf7\u7a0d\u5019...",
    opened:
      "\u5df2\u4e3a\u4f60\u751f\u6210\u90ae\u4ef6\u8349\u7a3f\u3002\u5982\u679c\u672a\u81ea\u52a8\u6253\u5f00\u90ae\u7bb1\uff0c\u8bf7\u76f4\u63a5\u53d1\u90ae\u4ef6\u81f3 admin@zqzqq.com \u6216\u7535\u8bdd/\u5fae\u4fe1\u8054\u7cfb\u3002"
  },
  en: {
    nameRequired: "Please enter your name.",
    contactRequired: "Please provide phone or email.",
    preparing: "Preparing email draft...",
    opened:
      "Email draft generated. If your mail app did not open, please email admin@zqzqq.com or contact us via phone/WeChat."
  }
};

function formatLeadMailBody(payload) {
  return [
    "brick-bootkit-admin \u5b98\u7f51\u54a8\u8be2",
    "",
    `\u59d3\u540d / Name: ${payload.name || "-"}`,
    `\u516c\u53f8 / Company: ${payload.company || "-"}`,
    `\u7535\u8bdd / Phone: ${payload.phone || "-"}`,
    `\u90ae\u7bb1 / Email: ${payload.email || "-"}`,
    `\u8bed\u8a00 / Lang: ${payload.lang || "-"}`,
    "",
    "\u9700\u6c42\u8bf4\u660e / Requirement:",
    payload.requirement || "-",
    "",
    `\u9875\u9762 / Page: ${payload.pageUrl || "-"}`,
    `\u65f6\u95f4 / Time: ${new Date().toISOString()}`
  ].join("\n");
}

function buildMailtoHref(recipient, subject, body) {
  const safeRecipient = recipient || "admin@zqzqq.com";
  return `mailto:${encodeURIComponent(safeRecipient)}?subject=${encodeURIComponent(subject)}&body=${encodeURIComponent(body)}`;
}

const leadForm = document.querySelector("[data-lead-form]");
if (leadForm) {
  const submitBtn = leadForm.querySelector("[data-form-submit]");
  const statusEl = leadForm.querySelector("[data-form-status]");
  leadForm.addEventListener("submit", async (event) => {
    event.preventDefault();
    const text = STATIC_FORM_TEXT[currentLang] || STATIC_FORM_TEXT[DEFAULT_LANG];
    const formData = new FormData(leadForm);
    const payload = {
      name: String(formData.get("name") || "").trim(),
      company: String(formData.get("company") || "").trim(),
      phone: String(formData.get("phone") || "").trim(),
      email: String(formData.get("email") || "").trim(),
      requirement: String(formData.get("requirement") || "").trim(),
      pageUrl: window.location.href,
      lang: currentLang
    };

    if (!payload.name) {
      setFormStatus(statusEl, text.nameRequired, true);
      return;
    }
    if (!payload.phone && !payload.email) {
      setFormStatus(statusEl, text.contactRequired, true);
      return;
    }

    if (submitBtn) submitBtn.disabled = true;
    setFormStatus(statusEl, text.preparing, false);
    try {
      const recipient = leadForm.getAttribute("data-recipient-email") || "admin@zqzqq.com";
      const subjectZh =
        leadForm.getAttribute("data-mail-subject-zh") || "brick-bootkit-admin 官网咨询";
      const subjectEn =
        leadForm.getAttribute("data-mail-subject-en") || "brick-bootkit-admin Website Inquiry";
      const subject = currentLang === "en" ? subjectEn : subjectZh;
      const body = formatLeadMailBody(payload);
      const href = buildMailtoHref(recipient, subject, body);
      window.location.href = href;
      leadForm.reset();
      setFormStatus(statusEl, text.opened, false);
      showCopyToast(text.opened, true);
    } catch {
      setFormStatus(statusEl, text.opened, false);
      showCopyToast(text.opened, true);
    } finally {
      if (submitBtn) submitBtn.disabled = false;
    }
  });
}

applyLanguage(currentLang, false);
