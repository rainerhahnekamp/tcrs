System.config({
  baseURL: "/",
  defaultJSExtensions: true,
  transpiler: "typescript",
  paths: {
    "npm:*": "jspm_packages/npm/*"
  },
  typescriptOptions: {
	  "module": "commonjs"
  },
  map: {
    "typescript": "npm:typescript@1.8.9"
  }
});
